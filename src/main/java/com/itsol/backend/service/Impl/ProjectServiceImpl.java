package com.itsol.backend.service.Impl;

import com.itsol.backend.domain.Project;
import com.itsol.backend.dto.ProjectDto;
import com.itsol.backend.repository.ProjectRepository;
import com.itsol.backend.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProjectDto> getAllProject() {
        List<Project> list= projectRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(project ->
                modelMapper.map(project, ProjectDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(Project project) {

    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void delete(long projectId) {

    }

    @Override
    public ProjectDto getProjectById(Long projectId) {
        return null;
    }

}
