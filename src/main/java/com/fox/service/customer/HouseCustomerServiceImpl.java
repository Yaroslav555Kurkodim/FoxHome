package com.fox.service.customer;

import com.fox.converter.HouseConverter;
import com.fox.entity.Component;
import com.fox.entity.House;
import com.fox.model.HouseModel;
import com.fox.repository.ComponentRepository;
import com.fox.repository.HouseRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseCustomerServiceImpl implements HouseCustomerService {
    private final HouseRepository houseRepository;
    private final ComponentRepository componentRepository;
    private final HouseConverter houseConverter;

    public HouseCustomerServiceImpl(HouseRepository houseRepository, ComponentRepository componentRepository, HouseConverter houseConverter) {
        this.houseRepository = houseRepository;
        this.componentRepository = componentRepository;
        this.houseConverter = houseConverter;
    }

    @Override
    public List<HouseModel> findHousesByComponents(List<Long> componentIds) {
        return houseRepository.findAll().stream().filter(e ->
                CollectionUtils.containsAny(e.getComponents().stream().map(Component::getId).collect(Collectors.toList()), componentIds)).
                map(houseConverter::convertHouseToHouseModel).collect(Collectors.toList());
    }

    @Override
    public Double getAveragePriceHouseByComponents(List<Long> componentIds) {
        Double result = Double.valueOf(0);
        List<HouseModel> existHouses = findHousesByComponents(componentIds);
        for (HouseModel el : existHouses)
            result += el.getPrice();
        return result/existHouses.size();
    }


}
