package com.fox.controller;

import com.fox.model.HouseModel;
import com.fox.model.request.HouseModelRequest;
import com.fox.service.HouseService;
import com.fox.validate.error.BadRequestException;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/house")
public class HouseController {
    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping
    public HouseModel create(@RequestBody HouseModelRequest houseModelRequest) throws BadRequestException, NotFoundException {
        return houseService.create(houseModelRequest);
    }

    @GetMapping(value = {"/{id}",""})
    public List<HouseModel> getOneOrAll(@PathVariable(required = false) Long id) throws NotFoundException {
        if(id == null)
            return houseService.getAll();
        return Arrays.asList(houseService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws NotFoundException {
        houseService.delete(id);
    }

}
