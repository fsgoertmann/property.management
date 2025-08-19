package com.mycompany.propery.management.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Property {
    private String title;
    private String description;
    private Double price;
    private String address;
}
