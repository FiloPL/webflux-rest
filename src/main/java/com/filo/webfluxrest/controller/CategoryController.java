package com.filo.webfluxrest.controller;

import com.filo.webfluxrest.domain.Category;
import com.filo.webfluxrest.repositories.CategoryRepository;
import org.reactivestreams.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by T. Filo Zegarlicki on 05.05.2022
 **/

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/api/categories")
    Flux<Category> list() {
        return categoryRepository.findAll();
    }

    @GetMapping("/api/categories/{id}")
    Mono<Category> getByID(@PathVariable String id) {
        return categoryRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/api/categories")
    Mono<Void> create(@RequestBody Publisher<Category> categoryStream) {
        return categoryRepository.saveAll(categoryStream).then();
    }
}
