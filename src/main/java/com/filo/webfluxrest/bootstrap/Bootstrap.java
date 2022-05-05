package com.filo.webfluxrest.bootstrap;

import com.filo.webfluxrest.domain.Category;
import com.filo.webfluxrest.domain.Vendor;
import com.filo.webfluxrest.repositories.CategoryRepository;
import com.filo.webfluxrest.repositories.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by T. Filo Zegarlicki on 05.05.2022
 **/

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count().block() == 0) {
            // load data
            log.info("### LOADING DATA on BootStrap ###");

            categoryRepository.save(Category.builder()
                    .description("Fruits").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Nuts").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Breads").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Meats").build()).block();

            categoryRepository.save(Category.builder()
                    .description("Eggs").build()).block();

            log.info("Loaded Categories: " + categoryRepository.count().block());

            vendorRepository.save(Vendor.builder()
                    .firstName("Joe")
                    .lastName("Buck").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Micheal")
                    .lastName("Weston").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Jessie")
                    .lastName("Waters").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Bill")
                    .lastName("Nershi").build()).block();

            vendorRepository.save(Vendor.builder()
                    .firstName("Jimmy")
                    .lastName("Buffett").build()).block();

            log.info("Loaded Vendors: " + vendorRepository.count().block());

        }
    }
}
