package com.api_consumption.user_service.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private Geo geo;

}
