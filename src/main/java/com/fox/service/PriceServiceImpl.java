package com.fox.service;

import com.fox.entity.House;
import com.fox.model.request.HouseModelRequest;
import com.fox.repository.ComponentRepository;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService{

    @Override
    public House buildHousePriceBaseComponents(House houseInput) {
        houseInput.getComponents().forEach(e -> houseInput.setPrice(houseInput.getPrice()*e.getkPrice()));
        return houseInput;
    }
}
