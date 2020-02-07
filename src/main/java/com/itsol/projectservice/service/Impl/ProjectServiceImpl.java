package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.dto.ProjectDto;
import com.itsol.projectservice.repository.ProjectRepository;
import com.itsol.projectservice.service.ProjectService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;


@Service
public class ProjectServiceImpl implements ProjectService {
    private Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
    private String views = "";

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectDto> getAllProject() {
        try {
            return lstDTO(projectRepository.finAllEntity());
        } catch (Exception e) {
            logger.info("Lỗi findAll " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ProjectDto> getAllProjectPage(String property, Object value, String sortExperssion, String sortDirection, Integer offset, Integer limit) {
        List<ProjectDto> ProjectDtoList = new ArrayList<ProjectDto>();
        Object[] objects = projectRepository.getEntityPage(property,value,sortExperssion,sortDirection,offset,limit);
        ProjectDtoList = lstDTO((List<Project>) objects[1]);
        return ProjectDtoList;
    }

    @Override
    public String createProject(ProjectDto project) {
        try {
            if (project.getStartDate() == null) {
                views = "ngày bắt đầu dự án không được null";
            } else if (project.getEndDate() == null) {
                views = "ngày dự kiếm kết thúc dự án không được null";
            } else {
                project.setStatus(1);
                projectRepository.saveEntity(dtoParseModels(project));
                views = "thêm thành công project !";
            }
        } catch (Exception e) {
            logger.info("Lỗi insert " + e.getMessage());
            views = "thêm project không thành công!";
        }
        return views;
    }

    @Override
    public String updateProject(ProjectDto projectDto) {
        try {
            ProjectDto ProjectDto = findProjectById(projectDto.getId());
            if (projectDto.getStartDate() == null) {
                views = "ngày bắt đầu dự án không được null";
            } else if (projectDto.getEndDate() == null) {
                views = "ngày dự kiếm kết thúc dự án không được null";
            } else if (ProjectDto != null) {
                ProjectDto updateProject = modelparseDto(projectRepository.updateEntity(dtoParseModels(projectDto)));
                if (updateProject != null) {
                    views = "sửa thành công project";
                }
            } else {
                views = "không tìm thấy project phù hợp";
            }
        } catch (Exception e) {
            logger.info("Lỗi update" + e.getMessage());
            views = "lỗi update project";
        }
        return views;
    }

    @Override
    public ProjectDto findProjectById(Integer projectId) {
        try {
            ProjectDto ProjectDto = modelparseDto(projectRepository.findEntityById(projectId));
            if (ProjectDto != null) {
                return ProjectDto;
            }
        } catch (Exception e) {
            logger.info("( Lỗi tìm kiếm ) " + e.getMessage());
        }
        return null;
    }




    @Override
    public String deleteProject(Integer[] ids) {
        int count = 0;
        count = projectRepository.deleteEntity(ids);
        if (count != 0) {
            views = "xóa thành công " + count + " project";
        } else {
            views = "project không tồn tại";
        }
        return views;
    }

    @Override
    public String deleteProjectById(Integer projectId) {
        logger.info("deleteProjectById");
        int count = 0;
        count = projectRepository.deleteEntityByID(projectId);
        if (count != 0) {
            views = "xóa thành công project";
        } else {
            views = "project không tồn tại";
        }
        return views;

    }

    public List<ProjectDto> lstDTO(List<Project> lstModels) {
        List<ProjectDto> lstDTO = new ArrayList<>();
        for (Project project : lstModels) {
            lstDTO.add(modelparseDto(project));
        }
        return lstDTO;
    }

    public ProjectDto modelparseDto(Project model) {
        ProjectDto dto = new ProjectDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setStartDate(model.getStartDate());
        dto.setEndDate(model.getEndDate());
        dto.setStatus(model.getStatus());

        return dto;
    }

    public Project dtoParseModels(ProjectDto ProjectDto) {
        Project project = new Project();
        project.setId(ProjectDto.getId());
        project.setName(ProjectDto.getName());
        project.setStartDate(ProjectDto.getStartDate());
        project.setEndDate(ProjectDto.getEndDate());
        project.setStatus(ProjectDto.getStatus());
        return project;
    }

}
