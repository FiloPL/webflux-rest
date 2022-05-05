package com.filo.webfluxrest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

/**
 * Created by T. Filo Zegarlicki on 05.05.2022
 **/

@Data
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vendor {

    @Id
    private String id;

    private String firstName;
    private String lastName;

}
