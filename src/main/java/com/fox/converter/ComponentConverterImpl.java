package com.fox.converter;

import com.fox.entity.Component;
import com.fox.model.ComponentModel;
import com.fox.model.request.ComponentModelRequest;
import com.fox.repository.TypeRepository;

@org.springframework.stereotype.Component
public class ComponentConverterImpl implements ComponentConverter{
    private TypeRepository typeRepository;
    private TypeConverter typeConverter;

    public ComponentConverterImpl(TypeRepository typeRepository, TypeConverter typeConverter) {
        this.typeRepository = typeRepository;
        this.typeConverter = typeConverter;
    }

    @Override
    public Component convertComponentRequestToComponent(ComponentModelRequest componentRequest) {
        return new Component().name(componentRequest.getName()).description(componentRequest.getDescription()).
                kPrice(componentRequest.getkPrice()).type(typeRepository.getOne(componentRequest.getTypeId()));
    }

    @Override
    public ComponentModel convertComponentToComponentModel(Component component) {
        return new ComponentModel().id(component.getId()).name(component.getName()).
                description(component.getDescription()).kPrice(component.getkPrice()).
                type(typeConverter.convertTypeToTypeModel(component.getType()));
    }
}
