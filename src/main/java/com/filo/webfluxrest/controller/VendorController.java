package com.filo.webfluxrest.controller;

import com.filo.webfluxrest.domain.Vendor;
import com.filo.webfluxrest.repositories.VendorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by T. Filo Zegarlicki on 05.05.2022
 **/

@RestController
public class VendorController {

    private final VendorRepository vendorRepository;

    public VendorController(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @GetMapping("api/vendors")
    Flux<Vendor> list() {
        return vendorRepository.findAll();
    }


    @GetMapping("api/vendors/{id}")
    Mono<Vendor> getByID(@PathVariable String id) {
        return vendorRepository.findById(id);
    }

}
