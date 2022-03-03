package com.bootcamp.calatologcurrencyservice.controller;


import com.bootcamp.calatologcurrencyservice.model.CatalogCurrency;
import com.bootcamp.calatologcurrencyservice.service.ICatalogCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalogcurrency")
public class CatalogCurrencyController {
    private final ICatalogCurrencyService service;

    @GetMapping
    public Flux<CatalogCurrency> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<CatalogCurrency> getOne(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<CatalogCurrency> create(@RequestBody CatalogCurrency product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Mono<CatalogCurrency> update(@PathVariable String id, @RequestBody CatalogCurrency product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
