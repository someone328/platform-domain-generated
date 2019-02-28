package io.vertx.cluster.platform.api;

import io.vertx.cluster.platform.model.Error;
import io.vertx.cluster.platform.MainApiException;
import io.vertx.cluster.platform.MainApiHeader;
import io.vertx.cluster.platform.model.Pet;
import io.vertx.cluster.platform.model.Pets;
import io.vertx.cluster.platform.util.ResourceResponse;
import io.vertx.cluster.platform.util.VerticleHelper;

import rx.Completable;
import rx.Single;
import io.vertx.rxjava.ext.auth.User;

import java.util.List;
import java.util.Map;

public class PetsApiImpl implements PetsApi {
    //listPets
    public Single<ResourceResponse<Pets>> listPets(Integer limit){
        throw new java.lang.UnsupportedOperationException("Not implemented, yet") ;
    };    
    //savePet
    public Single<ResourceResponse<Void>> savePet(Pet body, User user){
        throw new java.lang.UnsupportedOperationException("Not implemented, yet") ;
    };    
    //showPetById
    public Single<ResourceResponse<Pet>> showPetById(String petId){
        throw new java.lang.UnsupportedOperationException("Not implemented, yet") ;
    };    
}
