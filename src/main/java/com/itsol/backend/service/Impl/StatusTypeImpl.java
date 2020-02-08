package com.itsol.backend.service.Impl;

import com.itsol.backend.domain.StatusType;
import com.itsol.backend.dto.StatusTypeDto;
import com.itsol.backend.repository.StatusTypeRepository;
import com.itsol.backend.service.StatusTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StatusTypeImpl implements StatusTypeService {

    @Autowired
    private StatusTypeRepository statusTypeRepository;

    @Autowired
    private  ModelMapper modelMapper;


    @Override
    @Transactional(readOnly = true)
    public List<StatusTypeDto> getAllStatusType() {
        List<StatusType> list = statusTypeRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(statusType ->
                modelMapper.map(statusType, StatusTypeDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(StatusTypeDto statusTypeDto) {
        StatusType statusType = modelMapper.map(statusTypeDto, StatusType.class);
        statusTypeRepository.save(statusType);
    }

    @Override
    public void update(StatusTypeDto statusTypeDto) {
        StatusType statusType = statusTypeRepository.getOne(statusTypeDto.getId());
        statusType.setName(statusTypeDto.getName());
    }

    @Override
    public void delete(long statusTypeID) {
        statusTypeRepository.deleteById(statusTypeID);
    }

    @Override
    public StatusTypeDto getStatusTypeId(Long statusTypeID) {
        return null;
    }


}
