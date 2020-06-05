package com.fox.service;

import com.fox.model.TypeModel;
import com.fox.model.request.TypeModelRequest;
import com.fox.validate.error.BadRequestException;
import javassist.NotFoundException;

import java.util.List;

public interface TypeService {

    TypeModel create(TypeModelRequest typeRequest) throws BadRequestException;

    TypeModel update(TypeModelRequest typeRequest,Long id);

    void delete(Long id) throws NotFoundException;

    TypeModel get(Long id) throws NotFoundException;

    List<TypeModel> getAll();
}
