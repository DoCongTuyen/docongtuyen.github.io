package com.itsol.projectservice.rest;

import com.itsol.projectservice.dto.ProjectGroupDto;
import com.itsol.projectservice.service.ProjectGroupService;
import com.itsol.projectservice.service.common.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProjectGroupController {
    @Autowired
    private ProjectGroupService projectGroupService;

    //    thông tin của 1 nhóm dư án theo id của dự án
//    Team lead,Hr
    @GetMapping(value = "/thong-tin-du-an/{id}", produces = SystemConstants.TYPE_JSON)
    public ResponseEntity<List<ProjectGroupDto>> getOneProjectGroup(@PathVariable("id") Integer projectId) {
        return ResponseEntity.ok(projectGroupService.getGroupByProjectId(projectId));
    }

    //    thêm thành viên vào dự án
//    hr,manager, teamlead thêm thành viên
    @PostMapping(value = "/them-thanh-vien", consumes = SystemConstants.TYPE_JSON, produces = SystemConstants.TYPE_JSON)
    public ResponseEntity addMemberProject(@RequestBody ProjectGroupDto projectGroupDto) {
        String views = projectGroupService.saveEmployeeProject(projectGroupDto);
        return ResponseEntity.ok(new WrapperResult(200, views));
    }

    //    cập nhật thông tin thành viên
//    manager cập nhật chức vụ cho nhân viên vào xét duyệt vào dự án
    @PutMapping(value = "/cap-nhat-thong-tin-thanh-vien",consumes = SystemConstants.TYPE_JSON, produces = SystemConstants.TYPE_JSON)
    public ResponseEntity updateMemberProject(@RequestBody ProjectGroupDto ProjectGroupDto) {
        String views = projectGroupService.updateEmployeeProject(ProjectGroupDto);
        return ResponseEntity.ok(views);
    }


    //    xóa thành viên ra khỏi dự án
    @DeleteMapping(value = "/thanh-vien-out-du-an")
    public ResponseEntity deleteMembersProject(@RequestBody ProjectGroupDto ProjectGroupDto){
        String views = projectGroupService.outProjectGroup(ProjectGroupDto.getIds());
        return ResponseEntity.ok(views);
    }

    @DeleteMapping(value = "/xoa-thanh-vien-du-an")
    public ResponseEntity deleteMemberProject(@RequestBody ProjectGroupDto ProjectGroupDto){
        String views = projectGroupService.deleteEmployeeProject(ProjectGroupDto.getId());
        return ResponseEntity.ok(new WrapperResult(200, views));
    }

    static class WrapperResult{
        private int status;
        private String message;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public WrapperResult(int status, String message) {
            this.status = status;
            this.message = message;
        }
    }
}
