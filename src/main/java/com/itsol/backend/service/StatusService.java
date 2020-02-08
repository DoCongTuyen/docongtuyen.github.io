package com.itsol.backend.service;

import com.itsol.backend.dto.StatusDto;

import java.util.List;

public interface StatusService {
    List<StatusDto> getAllStatus();

    void create(StatusDto statusDto);

    void update(StatusDto statusDto);

    void delete(Long statusId);

    StatusDto getStatusID(Long statusId);
}
