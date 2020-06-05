package com.fox.validate.error;

public class ValidateError {

    private boolean isError;

    private StringBuilder message;

    public ValidateError(){
        isError = false;
        message = new StringBuilder("not valid value: ");
    }

    public ValidateError addError(String value){
        isError = true;
        message.append(value + "; ");
        return this;
    }

    public boolean isError(){
        return isError;
    }

    public String getMessage() {
        return message.toString();
    }
}
