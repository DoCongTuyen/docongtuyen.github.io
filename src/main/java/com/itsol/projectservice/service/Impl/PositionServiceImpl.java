package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Position;
import com.itsol.projectservice.dto.PositionDto;
import com.itsol.projectservice.repository.PositionRepository;
import com.itsol.projectservice.service.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<PositionDto> getAllPosition() {
        List<Position> list = positionRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(position ->
                modelMapper.map(position, PositionDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(Position position) {

    }

    @Override
    public void update(Position position) {

    }

    @Override
    public void delete(long positionId) {

    }

    @Override
    public PositionDto getPositionById(Long positionId) {
        return null;
    }
}
