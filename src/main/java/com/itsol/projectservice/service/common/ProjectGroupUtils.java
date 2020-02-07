package com.itsol.projectservice.service.common;

import com.itsol.projectservice.domain.Employee;
import com.itsol.projectservice.domain.Eproject;
import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.dto.EmployeeDto;
import com.itsol.projectservice.dto.ProjectDto;
import com.itsol.projectservice.dto.ProjectGroupDto;
import com.itsol.projectservice.repository.EmployeeRepositoryImpl;
import com.itsol.projectservice.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProjectGroupUtils {
    private static Logger logger = LoggerFactory.getLogger(ProjectGroupUtils.class);
    @Autowired
    private EmployeeRepositoryImpl employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;
    public Eproject Model(ProjectGroupDto dto){
        Eproject model = new Eproject();
        model.setId(dto.getId());
        model.setJoinDate(dto.getJoinDate());
        model.setOutDate(dto.getOutDate());
        model.setPosition(dto.getPosition());
        try{
            Employee findEmployee = employeeRepository.getEmployeeById(dto.getUserId());
            if(findEmployee!=null){
                model.setEmployee(findEmployee);
            }
        }catch (Exception e){
            logger.info("(Lỗi không tìm thấy Employee) "+e.getMessage());
        }
        try{
            Project project = projectRepository.findEntityById(dto.getProjectId());
            if(project!=null){
                model.setProject(project);
            }
        }catch (Exception e){
            logger.info("(Lỗi không tìm thấy Project) "+e.getMessage());
        }
        return model;
    }

    public  ProjectGroupDto DTO(Eproject models) {
        ProjectGroupDto dto = new ProjectGroupDto();
        dto.setId(models.getId());
//        set project
        ProjectDto projectDTO = new ProjectDto();
        BeanUtils.copyProperties(models.getProject(),projectDTO);
        dto.setProjectDto(projectDTO);
//        set employee
        EmployeeDto EmployeeDto = new EmployeeDto();
        EmployeeDto.setId(models.getEmployee().getId());
        EmployeeDto.setUsername(models.getEmployee().getUsername());
        EmployeeDto.setEmail(models.getEmployee().getEmail());
        EmployeeDto.setSkype(models.getEmployee().getSkype());
        dto.setEmployeeDto(EmployeeDto);

        dto.setJoinDate(models.getJoinDate());
        dto.setOutDate(models.getOutDate());
        dto.setPosition(models.getPosition());
        return dto;
    }
    public List<ProjectGroupDto> getListDTO(List<Eproject> lstModel){
        if(!lstModel.isEmpty()||lstModel.size()!=0){
            List<ProjectGroupDto> lstDTO = new ArrayList<ProjectGroupDto>();
            for (Eproject eproject:lstModel) {
                lstDTO.add(DTO(eproject));
            }
            return lstDTO;
        }
        return null;
    }
}
