package com.fox.validate;

import com.fox.model.request.TypeModelRequest;
import com.fox.validate.error.ValidateError;

public interface TypeValidate {

    ValidateError validate(TypeModelRequest request);
}
