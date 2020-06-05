package com.fox.controller.customer;

import com.fox.model.HouseModel;
import com.fox.service.customer.HouseCustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/home")
public class HouseCustomerController {
    private final HouseCustomerService houseCustomerService;

    public HouseCustomerController(HouseCustomerService houseCustomerService) {
        this.houseCustomerService = houseCustomerService;
    }

    @PostMapping("/all/by/components")
    public @ResponseBody List<HouseModel> findHouseByComponents(@RequestBody List<Long> componentIds){
        return houseCustomerService.findHousesByComponents(componentIds);
    }

    @PostMapping("price/by/components")
    public Double getAveragePrice(@RequestBody List<Long> componentIds){
        return houseCustomerService.getAveragePriceHouseByComponents(componentIds);
    }
}
