package io.vertx.cluster.platform.api;

import com.fasterxml.jackson.core.type.TypeReference;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import com.github.phiz71.vertx.swagger.router.SwaggerRouter;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.ServiceLoader;

import io.vertx.cluster.platform.model.Error;
import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.model.Pet;
import io.vertx.cluster.platform.model.Pets;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

import java.util.List;
import java.util.Map;

public class PetsApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    private static final String LISTPETS_SERVICE_ID = "listPets_v1";
    private static final String SAVEPET_SERVICE_ID = "savePet_v1";
    private static final String SHOWPETBYID_SERVICE_ID = "showPetById_v1";

    private PetsApi service;

    /**
     * Handler for listPets
     */
    final Handler<Message<JsonObject>> listPetsHandler = message -> {
        try {
            Integer limit = null;
            if(message.body().getString("limit") != null) {
                limit = Json.mapper.readValue(message.body().getString("limit"), Integer.class);
            }
            service.listPets(limit).subscribe(
                verticleHelper.getRxResultHandler(message, true, new TypeReference<Pets>(){}),
                verticleHelper.getErrorAction(message, LISTPETS_SERVICE_ID)
            );        } catch (Exception e) {
            verticleHelper.manageError(message, e, LISTPETS_SERVICE_ID);
        }
    };

    /**
     * Handler for savePet
     */
    final Handler<Message<JsonObject>> savePetHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            Pet body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Pet.class);
            service.savePet(body, io.vertx.rxjava.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message, false, new TypeReference<Void>(){}),
                verticleHelper.getErrorAction(message, SAVEPET_SERVICE_ID)
            );        } catch (Exception e) {
            verticleHelper.manageError(message, e, SAVEPET_SERVICE_ID);
        }
    };

    /**
     * Handler for showPetById
     */
    final Handler<Message<JsonObject>> showPetByIdHandler = message -> {
        try {
            String petId = message.body().getString("petId");
            service.showPetById(petId).subscribe(
                verticleHelper.getRxResultHandler(message, true, new TypeReference<Pet>(){}),
                verticleHelper.getErrorAction(message, SHOWPETBYID_SERVICE_ID)
            );        } catch (Exception e) {
            verticleHelper.manageError(message, e, SHOWPETBYID_SERVICE_ID);
        }
    };


    @Override
    public void start() throws Exception {
        this.service = createServiceImplementation();
    	vertx.eventBus().<JsonObject> consumer(LISTPETS_SERVICE_ID).handler(listPetsHandler);
    	vertx.eventBus().<JsonObject> consumer(SAVEPET_SERVICE_ID).handler(savePetHandler);
    	vertx.eventBus().<JsonObject> consumer(SHOWPETBYID_SERVICE_ID).handler(showPetByIdHandler);
    }

    protected PetsApi createServiceImplementation() {
    	ArrayList<PetsApi> realizations = Lists.newArrayList(ServiceLoader.load(PetsApi.class));
        if(realizations.isEmpty()) {
            throw new RuntimeException("No realizations for "+ PetsApi.class +" were founded");
        }
        if(realizations.size() > 1 ) {
            throw new RuntimeException("More then one realization of "+ PetsApi.class +" were founded: "+ realizations);
        }
        return realizations.get(0);
    }
}
