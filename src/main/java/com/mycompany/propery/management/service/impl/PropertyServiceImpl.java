package com.mycompany.propery.management.service.impl;

import com.mycompany.propery.management.converter.PropertyConverter;
import com.mycompany.propery.management.entity.PropertyEntity;
import com.mycompany.propery.management.model.Property;
import com.mycompany.propery.management.repository.PropertyRepository;
import com.mycompany.propery.management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter = new PropertyConverter();

    @Override
    public Property saveProperty(Property property) {
        propertyRepository.save(propertyConverter.convertPropertyModelToEntity(property));
        return property;
    }

    @Override
    public List<Property> findAll() {
        List<PropertyEntity> properties = (List<PropertyEntity>) propertyRepository.findAll();
        return properties.stream().map(prop -> propertyConverter.convertPropertyEntityToModel(prop)).toList();
    }

    @Override
    public Property updateProperty(Property property,  Long propertyId) {
        if(propertyRepository.findById(propertyId).isPresent()) {
            PropertyEntity pe = propertyConverter.convertPropertyModelToEntity(property);
            pe.setId(propertyId);
            propertyRepository.save(pe);
            return property;
        }
        return null;
    }

    @Override
    public Property deleteProperty(Long propertyId) {
        Optional<PropertyEntity> pe = propertyRepository.findById(propertyId);
        if(pe.isPresent()) {
            propertyRepository.delete(pe.get());
            return propertyConverter.convertPropertyEntityToModel(pe.get());
        }
        return null;
    }


}
