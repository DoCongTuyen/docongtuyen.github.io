package com.itsol.projectservice.service;

import com.itsol.projectservice.domain.Position;
import com.itsol.projectservice.dto.PositionDto;

import java.util.List;

public interface PositionService {
    List<PositionDto> getAllPosition();

    void create(Position position);
    void update(Position position);
    void delete(long positionId);
    PositionDto getPositionById(Long positionId);
}
