package com.fox.validate;

import com.fox.model.request.ComponentModelRequest;
import com.fox.validate.error.ValidateError;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ComponentValidateImpl implements ComponentValidate{
    @Override
    public ValidateError validateCreate(ComponentModelRequest componentRequest) {
        ValidateError error = new ValidateError();
        if(StringUtils.isEmpty(componentRequest.getName()))
            error.addError("name");
        if(StringUtils.isEmpty(componentRequest.getDescription()))
            error.addError("description");
        return error;
    }
}
