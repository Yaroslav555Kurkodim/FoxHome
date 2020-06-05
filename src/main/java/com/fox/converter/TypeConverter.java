package com.fox.converter;

import com.fox.entity.Type;
import com.fox.model.TypeModel;
import com.fox.model.request.TypeModelRequest;

public interface TypeConverter {

    Type convertTypeRequestToType(TypeModelRequest modelRequest);

    TypeModel convertTypeToTypeModel(Type type);
}
