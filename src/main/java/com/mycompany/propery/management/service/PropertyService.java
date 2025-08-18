package com.mycompany.propery.management.service;

import com.mycompany.propery.management.model.Property;

import java.util.List;

public interface PropertyService {
    public Property saveProperty(Property property);

    public List<Property> findAll();

    public Property updateProperty(Property property, Long propertyId);

    public Property deleteProperty(Long propertyId);
}
