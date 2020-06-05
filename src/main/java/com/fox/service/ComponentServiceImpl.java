package com.fox.service;

import com.fox.converter.ComponentConverter;
import com.fox.model.ComponentModel;
import com.fox.model.request.ComponentModelRequest;
import com.fox.repository.ComponentRepository;
import com.fox.validate.ComponentValidate;
import com.fox.validate.error.BadRequestException;
import com.fox.validate.error.ValidateError;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComponentServiceImpl implements ComponentService {
    private ComponentRepository componentRepository;
    private ComponentValidate componentValidate;
    private ComponentConverter componentConverter;

    public ComponentServiceImpl(ComponentRepository componentRepository, ComponentValidate componentValidate, ComponentConverter componentConverter){
        this.componentRepository = componentRepository;
        this.componentValidate = componentValidate;
        this.componentConverter = componentConverter;
    }

    @Override
    @Transactional
    public ComponentModel create(ComponentModelRequest componentRequest) throws BadRequestException {
        ValidateError validateError = componentValidate.validateCreate(componentRequest);
        if(validateError.isError())
            throw new BadRequestException(validateError.getMessage());
        return componentConverter.convertComponentToComponentModel(
                componentRepository.save(
                        componentConverter.convertComponentRequestToComponent(componentRequest)
                )
        );
    }

    @Override
    public ComponentModel update(ComponentModelRequest componentRequest, Long id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        if(!componentRepository.existsById(id))
            throw new NotFoundException("Not found el with id: "+id);
        componentRepository.deleteById(id);
    }

    @Override
    public ComponentModel get(Long id) throws NotFoundException {
        if(!componentRepository.existsById(id))
            throw new NotFoundException("Not found el with id: "+id);
        return componentConverter.convertComponentToComponentModel(componentRepository.getOne(id));
    }

    @Override
    public List<ComponentModel> getAll() {
        return componentRepository.findAll().stream().
                map(componentConverter::convertComponentToComponentModel).
                collect(Collectors.toList());
    }


}
