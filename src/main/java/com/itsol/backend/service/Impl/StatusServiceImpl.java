package com.itsol.backend.service.Impl;

import com.itsol.backend.domain.Status;
import com.itsol.backend.dto.StatusDto;
import com.itsol.backend.repository.StatusRepository;
import com.itsol.backend.service.StatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private  ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<StatusDto> getAllStatus() {
        List<Status> list = statusRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(entity -> modelMapper.map(entity,StatusDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(StatusDto statusDto) {

    }

    @Override
    public void update(StatusDto statusDto) {

    }

    @Override
    public void delete(Long statusId) {

    }

    @Override
    public StatusDto getStatusID(Long statusId) {
        return null;
    }


}
