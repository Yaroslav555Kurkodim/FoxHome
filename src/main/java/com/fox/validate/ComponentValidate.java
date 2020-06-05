package com.fox.validate;

import com.fox.model.request.ComponentModelRequest;
import com.fox.validate.error.ValidateError;

public interface ComponentValidate {
    ValidateError validateCreate(ComponentModelRequest componentRequest);
}
