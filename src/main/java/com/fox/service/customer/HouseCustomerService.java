package com.fox.service.customer;

import com.fox.model.HouseModel;

import java.util.List;

public interface HouseCustomerService {
    List<HouseModel> findHousesByComponents(List<Long> componentIds);

    Double getAveragePriceHouseByComponents(List<Long> componentIds);
}
