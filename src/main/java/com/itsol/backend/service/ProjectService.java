package com.itsol.backend.service;

import com.itsol.backend.domain.Project;
import com.itsol.backend.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllProject();

    void create(Project project);
    void update(Project project);
    void delete(long projectId);
    ProjectDto getProjectById(Long projectId);

}
