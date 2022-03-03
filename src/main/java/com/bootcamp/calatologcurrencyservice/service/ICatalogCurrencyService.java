package com.bootcamp.calatologcurrencyservice.service;


import com.bootcamp.calatologcurrencyservice.model.CatalogCurrency;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICatalogCurrencyService {

     Flux<CatalogCurrency> findAll();

     Mono<CatalogCurrency> save(CatalogCurrency client);

     Mono<Void> delete(String id);

     Mono<CatalogCurrency> update(String id, CatalogCurrency product);

     Mono<CatalogCurrency> findById(String id);

}
