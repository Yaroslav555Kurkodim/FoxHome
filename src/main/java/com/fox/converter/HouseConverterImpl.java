package com.fox.converter;

import com.fox.entity.House;
import com.fox.model.HouseModel;
import com.fox.model.request.HouseModelRequest;
import com.fox.repository.ComponentRepository;
import com.fox.service.PriceService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class HouseConverterImpl implements HouseConverter{
    private final ComponentRepository componentRepository;

    public HouseConverterImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public House convertHouseRequsetToHouse(HouseModelRequest house) {
        return new House().name(house.getName()).description(house.getDescription()).
                components(componentRepository.findAllById(house.getComponentIds())).
                price(house.getBasePrice());
    }

    @Override
    public HouseModel convertHouseToHouseModel(House house) {
        return new HouseModel().id(house.getId()).name(house.getName()).
                description(house.getDescription()).price(house.getPrice()).
                componentIds(house.getComponents().stream().
                        map(com.fox.entity.Component::getId).collect(Collectors.toList()));
    }
}
