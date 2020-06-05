package com.fox.service;

import com.fox.model.ComponentModel;
import com.fox.model.request.ComponentModelRequest;
import com.fox.validate.error.BadRequestException;
import javassist.NotFoundException;

import java.util.List;

public interface ComponentService {

    ComponentModel create(ComponentModelRequest componentRequest) throws BadRequestException;

    ComponentModel update(ComponentModelRequest componentRequest,Long id);

    void delete(Long id) throws NotFoundException;

    ComponentModel get(Long id) throws NotFoundException;

    List<ComponentModel> getAll();
}
