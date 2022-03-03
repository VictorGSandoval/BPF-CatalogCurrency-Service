package com.bootcamp.calatologcurrencyservice.repository;

import com.bootcamp.calatologcurrencyservice.model.CatalogCurrency;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogCurrencyRepository extends ReactiveMongoRepository<CatalogCurrency, String> {

   // Mono<CatalogCurrency> findByPhoneNumber(String phoneNumber);

}