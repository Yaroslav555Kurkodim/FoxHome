package com.fox.converter;

import com.fox.entity.Type;
import com.fox.model.TypeModel;
import com.fox.model.request.TypeModelRequest;
import org.springframework.stereotype.Component;

@Component
public class TypeConverterImpl implements TypeConverter{
    @Override
    public Type convertTypeRequestToType(TypeModelRequest modelRequest) {
        return new Type().name(modelRequest.getName()).
                description(modelRequest.getDescription());
    }

    @Override
    public TypeModel convertTypeToTypeModel(Type type) {
        return new TypeModel().id(type.getId()).name(type.getName()).
                description(type.getDescription());
    }
}
