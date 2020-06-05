package com.fox.controller;

import com.fox.model.TypeModel;
import com.fox.model.request.TypeModelRequest;
import com.fox.service.TypeService;
import com.fox.validate.error.BadRequestException;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeController {
    private TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public TypeModel create(@RequestBody TypeModelRequest typeRequest) throws BadRequestException {
        return typeService.create(typeRequest);
    }

    @GetMapping(value = {"/{id}",""})
    public List<TypeModel> getOneOrAll(@PathVariable(required = false) Long id) throws NotFoundException {
        if(id == null)
            return typeService.getAll();
        return Arrays.asList(typeService.get(id));
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) throws NotFoundException {
        typeService.delete(id);
    }
}
