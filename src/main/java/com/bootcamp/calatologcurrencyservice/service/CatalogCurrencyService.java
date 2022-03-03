package com.bootcamp.calatologcurrencyservice.service;


import com.bootcamp.calatologcurrencyservice.model.CatalogCurrency;
import com.bootcamp.calatologcurrencyservice.repository.CatalogCurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor
@Service
@AllArgsConstructor
//@ConditionalOnProperty(name = "cache.enabled", havingValue = "false")
public class CatalogCurrencyService implements ICatalogCurrencyService {

    //Clorox
    @Autowired
    private CatalogCurrencyRepository repository;


    @Override
    public Flux<CatalogCurrency> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<CatalogCurrency> save(CatalogCurrency currency) {
        return  repository.save(currency);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<CatalogCurrency> update(String id, CatalogCurrency product) {
        return repository.findById(id).flatMap(newProduct -> {
            product.setId(newProduct.getId());
            product.setCreateDate(LocalDate.now());
            return repository.save(product);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<CatalogCurrency> findById(String id) {
        return repository.findById(id);
    }

}
