package com.fox.controller;

import com.fox.model.ComponentModel;
import com.fox.model.request.ComponentModelRequest;
import com.fox.service.ComponentService;
import com.fox.validate.error.BadRequestException;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/component")
public class ComponentController {
    private ComponentService componentService;

    public ComponentController(ComponentService componentService){
        this.componentService = componentService;
    }

    @PostMapping
    public @ResponseBody ComponentModel create(@RequestBody ComponentModelRequest componentRequest) throws BadRequestException {
        return componentService.create(componentRequest);
    }

    @GetMapping(value = {"/{id}",""})
    public @ResponseBody List<ComponentModel> getOneOrAll(@PathVariable(required = false) Long id) throws NotFoundException {
        if(id == null)
            return componentService.getAll();
        return Arrays.asList(componentService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws NotFoundException {
        componentService.delete(id);
    }
}
