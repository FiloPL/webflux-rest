package com.filo.webfluxrest.repositories;

import com.filo.webfluxrest.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by T. Filo Zegarlicki on 05.05.2022
 **/

public interface CategoryRepository extends ReactiveMongoRepository <Category, String>{
}