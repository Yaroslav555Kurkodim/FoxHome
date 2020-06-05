package com.fox.validate;

import com.fox.model.request.TypeModelRequest;
import com.fox.validate.error.ValidateError;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class TypeValidateImpl implements TypeValidate{
    @Override
    public ValidateError validate(TypeModelRequest request) {
        ValidateError error = new ValidateError();
        if(StringUtils.isEmpty(request.getName()))
            error.addError("name");
        if(StringUtils.isEmpty(request.getDescription()))
            error.addError("description");
        return error;
    }
}
