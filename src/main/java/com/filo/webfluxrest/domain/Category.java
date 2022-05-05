package com.filo.webfluxrest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by T. Filo Zegarlicki on 05.05.2022
 **/

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private String id;
    private String description;
}
