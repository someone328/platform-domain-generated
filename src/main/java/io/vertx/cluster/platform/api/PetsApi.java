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

public interface PetsApi  {
	

   /**
   * Получить список всех питомцев
   * 
   * @param limit Лимит объектов в ответе на запрос (max 100) (optional)
   * @return Pets
   * @throws ApiException if fails to make API call
	*/
    Single<ResourceResponse<Pets>> listPets(Integer limit);    

   /**
   * Сохранить питомца
   * 
   * @param body  (required)
   * @throws ApiException if fails to make API call
	*/
    Single<ResourceResponse<Void>> savePet(Pet body, User user);    

   /**
   * Информация по конкретному питомцу
   * 
   * @param petId Id питомца, для его поиска (required)
   * @return Pet
   * @throws ApiException if fails to make API call
	*/
    Single<ResourceResponse<Pet>> showPetById(String petId);    
}
