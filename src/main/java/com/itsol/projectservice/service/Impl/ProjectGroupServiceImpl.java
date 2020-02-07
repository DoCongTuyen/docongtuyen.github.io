package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Eproject;
import com.itsol.projectservice.domain.Project;
import com.itsol.projectservice.dto.ProjectGroupDto;
import com.itsol.projectservice.repository.EmployeeRepositoryImpl;
import com.itsol.projectservice.repository.ProjectGroupRepository;
import com.itsol.projectservice.repository.ProjectRepository;
import com.itsol.projectservice.service.ProjectGroupService;
import com.itsol.projectservice.service.common.ProjectGroupUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectGroupServiceImpl implements ProjectGroupService {
    Logger logger = LoggerFactory.getLogger(ProjectGroupServiceImpl.class);
    @Autowired
    private ProjectGroupRepository projectGroupRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepositoryImpl employeeRepository;

    @Autowired
    private ProjectGroupUtils utils;

    @Override
    public List<ProjectGroupDto> getGroupByProjectId(Integer projectId) {
        logger.info("getGroupByProjectId");
        Project project = projectRepository.findEntityById(projectId);
        if (project != null) {
            List<Eproject> lstModels = projectGroupRepository.finByProperty("project", project, "joinDate", "DESC");
            List<ProjectGroupDto> lstDTO = utils.getListDTO(lstModels);
            return lstDTO;
        }
        return null;
    }


    public boolean checkEmployeeInGroupProject(ProjectGroupDto dto){
        List<Eproject> lst = projectGroupRepository.finByProperty("project",projectRepository.findEntityById(dto.getProjectId()),null,null);
        for (Eproject eproject:lst) {
            if(eproject.getEmployee().getId()==dto.getUserId()){
                return true;
            }
        }
        return false;
    }
    @Override
    public String saveEmployeeProject(ProjectGroupDto dto) {
        logger.info("saveEmployeeProject");
        String views = "";
        if(!checkEmployeeInGroupProject(dto)) {
            try {
                projectGroupRepository.saveEntity(utils.Model(dto));
                views = "thêm thành công nhân viên vào nhóm dự án";
            } catch (Exception e) {
                views = "thêm không thành công!";
            }
        }else {
            views = "thành viên đã tồn tại";
        }
        return views;
    }

    @Override
    public String updateEmployeeProject(ProjectGroupDto dto) {
        logger.info("updateEmployeeProject");
        String views="";
        Eproject eproject = projectGroupRepository.findEntityById(dto.getId());
        if(eproject!=null){
            Eproject updateProjectGroup = projectGroupRepository.updateEntity(utils.Model(dto));
            if(updateProjectGroup!=null){
                views = "Sửa thành công";
            }
        }else{
            views = "đối tượng không tồn tại";
        }
        return null;
    }

    @Override
    public ProjectGroupDto findEmployeeProject(String username) {
        return null;
    }

    @Override
    public String outProjectGroup(Integer[] ids) {
        logger.info("outProjectGroup");
        String views = "";
        int count=0;
        count = projectGroupRepository.deleteEntity(ids);
        if(count!=0){
            views="Bạn đã cho "+count+" thoát ra khỏi nhóm";
        }else{
            views=" thành viên không tồn tại";
        }
        return views;
    }

    @Override
    public String deleteEmployeeProject(Integer id) {
        logger.info("deleteEmployeeProject");
        String views = "";
        int count=0;
        count = projectGroupRepository.deleteEntityByID(id);
        if(count!=0){
            views="Bạn đã cho "+count+" thoát ra khỏi nhóm";
        }else{
            views=" thành viên không tồn tại";
        }
        return views;
    }
}
