package com.mycompany.propery.management.service.impl;

import com.mycompany.propery.management.converter.PropertyConverter;
import com.mycompany.propery.management.model.Property;
import com.mycompany.propery.management.repository.PropertyRepository;
import com.mycompany.propery.management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter = new PropertyConverter();

    @Override
    public Property saveProperty(Property property) {
        propertyRepository.save(propertyConverter.convertPropertyEntityToModel(property));
        return property;
    }
}
