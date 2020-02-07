package com.itsol.projectservice.service;

import com.itsol.projectservice.dto.ProjectGroupDto;

import java.util.List;

public interface ProjectGroupService {

    List<ProjectGroupDto> getGroupByProjectId(Integer projectId);

    String saveEmployeeProject(ProjectGroupDto dto);

    String updateEmployeeProject(ProjectGroupDto dto);

    ProjectGroupDto findEmployeeProject(String username);

    String outProjectGroup(Integer[]ids);

    String deleteEmployeeProject(Integer id);
    }
