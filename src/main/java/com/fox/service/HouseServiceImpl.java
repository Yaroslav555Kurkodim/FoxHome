package com.fox.service;

import com.fox.converter.HouseConverter;
import com.fox.model.HouseModel;
import com.fox.model.request.HouseModelRequest;
import com.fox.repository.HouseRepository;
import com.fox.validate.error.BadRequestException;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseServiceImpl implements HouseService{
    private final HouseConverter houseConverter;
    private final HouseRepository houseRepository;
    private final ComponentService componentService;

    public HouseServiceImpl(HouseConverter houseConverter, HouseRepository houseRepository, ComponentService componentService) {
        this.houseConverter = houseConverter;
        this.houseRepository = houseRepository;
        this.componentService = componentService;
    }

    @Override
    @Transactional
    public HouseModel create(HouseModelRequest houseModelRequest) throws BadRequestException, NotFoundException {
        return houseConverter.
                convertHouseToHouseModel(houseRepository.
                        save(houseConverter.
                                convertHouseRequsetToHouse(houseModelRequest)
                                )
                        );
    }

    @Override
    public HouseModel update(HouseModelRequest houseModelRequest, Long id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        houseRepository.deleteById(id);
    }

    @Override
    public HouseModel get(Long id) throws NotFoundException {
        return houseConverter.convertHouseToHouseModel(houseRepository.getOne(id));
    }

    @Override
    public List<HouseModel> getAll() {
        return houseRepository.findAll().stream().
                map(houseConverter::convertHouseToHouseModel).
                collect(Collectors.toList());
    }

    private Double calculatePriceComponent(Double base,List<Long> componentIds) throws NotFoundException {
        Double result = base;
        for (Long id: componentIds) {
            result *= componentService.get(id).getkPrice();
        }
        return Double.valueOf(result);
    }
}
