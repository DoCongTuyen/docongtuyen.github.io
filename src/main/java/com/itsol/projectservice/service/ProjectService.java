package com.itsol.projectservice.service;

import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.dto.ProjectDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProjectService {
    List<ProjectDto> getAllProject();

    List<ProjectDto> getAllProjectPage(String property, Object value, String sortExperssion, String sortDirection, Integer offset, Integer limit);

    String createProject(ProjectDto project);

    String updateProject(ProjectDto project);

    ProjectDto findProjectById(Integer projectId);

    String deleteProjectById(Integer projectId);

    String deleteProject(Integer[] ids);

}
