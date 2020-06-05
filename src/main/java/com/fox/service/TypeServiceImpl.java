package com.fox.service;

import com.fox.converter.TypeConverter;
import com.fox.model.TypeModel;
import com.fox.model.request.TypeModelRequest;
import com.fox.repository.TypeRepository;
import com.fox.validate.TypeValidate;
import com.fox.validate.error.BadRequestException;
import com.fox.validate.error.ValidateError;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService{
    private TypeRepository typeRepository;
    private TypeValidate typeValidate;
    private TypeConverter typeConverter;

    public TypeServiceImpl(TypeRepository typeRepository, TypeValidate typeValidate, TypeConverter typeConverter) {
        this.typeRepository = typeRepository;
        this.typeValidate = typeValidate;
        this.typeConverter = typeConverter;
    }


    @Override
    @Transactional
    public TypeModel create(TypeModelRequest typeRequest) throws BadRequestException {
        ValidateError error = typeValidate.validate(typeRequest);
        if(error.isError())
            throw new BadRequestException(error.getMessage());
        return typeConverter.
                convertTypeToTypeModel(typeRepository.
                        save(typeConverter.
                                convertTypeRequestToType(typeRequest)
                        )
                );
    }

    @Override
    public TypeModel update(TypeModelRequest typeRequest, Long id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        if(!typeRepository.existsById(id))
            throw new NotFoundException("not found with id: "+id);
        typeRepository.deleteById(id);
    }

    @Override
    public TypeModel get(Long id) throws NotFoundException {
        if(!typeRepository.existsById(id))
            throw new NotFoundException("not found with id: "+id);
        return typeConverter.convertTypeToTypeModel(typeRepository.getOne(id));
    }

    @Override
    public List<TypeModel> getAll() {
        return typeRepository.findAll().stream().
                map(typeConverter::convertTypeToTypeModel).
                collect(Collectors.toList());
    }
}
