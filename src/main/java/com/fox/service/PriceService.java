package com.fox.service;

import com.fox.entity.House;
import com.fox.model.request.HouseModelRequest;

public interface PriceService {
    House buildHousePriceBaseComponents(House houseInput);
}
