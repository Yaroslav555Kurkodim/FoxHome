package com.fox.service;


import com.fox.model.HouseModel;
import com.fox.model.TypeModel;
import com.fox.model.request.HouseModelRequest;
import com.fox.model.request.TypeModelRequest;
import com.fox.validate.error.BadRequestException;
import javassist.NotFoundException;

import java.util.List;

public interface HouseService {
    HouseModel create(HouseModelRequest houseModelRequest) throws BadRequestException, NotFoundException;

    HouseModel update(HouseModelRequest houseModelRequest,Long id);

    void delete(Long id) throws NotFoundException;

    HouseModel get(Long id) throws NotFoundException;

    List<HouseModel> getAll();
}
