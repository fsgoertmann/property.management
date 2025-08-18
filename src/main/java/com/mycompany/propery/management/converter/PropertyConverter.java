package com.mycompany.propery.management.converter;

import com.mycompany.propery.management.entity.PropertyEntity;
import com.mycompany.propery.management.model.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertPropertyModelToEntity(Property property) {
        PropertyEntity propertyEntity = new PropertyEntity();

        propertyEntity.setTitle(property.getTitle());
        propertyEntity.setDescription(property.getDescription());
        propertyEntity.setOwnerName(property.getOwnerName());
        propertyEntity.setOwnerEmail(property.getOwnerEmail());
        propertyEntity.setPrice(property.getPrice());
        propertyEntity.setAddress(property.getAddress());

        return propertyEntity;
    }

    public Property convertPropertyEntityToModel(PropertyEntity propertyEntity) {
        Property property = new Property();

        property.setTitle(propertyEntity.getTitle());
        property.setDescription(propertyEntity.getDescription());
        property.setOwnerName(propertyEntity.getOwnerName());
        property.setOwnerEmail(propertyEntity.getOwnerEmail());
        property.setPrice(propertyEntity.getPrice());
        property.setAddress(propertyEntity.getAddress());

        return property;
    }
}
