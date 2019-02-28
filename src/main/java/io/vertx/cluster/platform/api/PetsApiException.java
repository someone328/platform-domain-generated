package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.model.Error;
import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.model.Pet;
import io.vertx.cluster.platform.model.Pets;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

public final class PetsApiException extends MainApiException {
    public PetsApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public static PetsApiException PetsApi_listPets_0_createException() {
        return new PetsApiException(0, "Непредвиденная ошибка");
    }
public static PetsApiException PetsApi_savePet_0_createException() {
        return new PetsApiException(0, "Непредвиденная ошибка");
    }
public static PetsApiException PetsApi_showPetById_0_createException() {
        return new PetsApiException(0, "Непредвиденная ошибка");
    }

}