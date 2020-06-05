package com.fox.converter;

import com.fox.entity.House;
import com.fox.model.HouseModel;
import com.fox.model.request.HouseModelRequest;

public interface HouseConverter {
    House convertHouseRequsetToHouse(HouseModelRequest houseModelRequest);

    HouseModel convertHouseToHouseModel(House house);
}
