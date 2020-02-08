package com.itsol.backend.service;

import com.itsol.backend.dto.StatusTypeDto;

import java.util.List;

public interface StatusTypeService {
    List<StatusTypeDto> getAllStatusType();

    void create(StatusTypeDto statusTypeDto);

    void update(StatusTypeDto statusTypeDto);

    void delete(long statusTypeID);

    StatusTypeDto getStatusTypeId(Long statusTypeID);
}
