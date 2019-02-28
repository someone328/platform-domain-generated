package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.model.Error;
import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.model.Pet;
import io.vertx.cluster.platform.model.Pets;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

public final class PetsApiHeader extends MainApiHeader {
    private PetsApiHeader(String name, String value) {
        super(name, value);
    }
    
    private PetsApiHeader(String name, Iterable<String> values) {
        super(name, values);
    }
    
    public static PetsApiHeader PetsApi_listPets_200_createXNext(String xNext) {
        return new PetsApiHeader("x-next", xNext.toString());
    }
    

}