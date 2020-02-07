package com.itsol.projectservice.rest;

import com.itsol.projectservice.dto.ProjectDto;
import com.itsol.projectservice.service.ProjectService;
import com.itsol.projectservice.service.common.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "danh-sanh-du-an/{offset}/{limit}")
    public ResponseEntity<List<ProjectDto>> getProjectPage(@PathVariable("offset") Integer offset,@PathVariable("limit") Integer limit){
        return ResponseEntity.ok(projectService.getAllProjectPage(null,null,null,null,offset,limit));
    }

    @GetMapping(value = "/danh-sach-du-an")
    public ResponseEntity<List<ProjectDto>> getAllProject(){
        return ResponseEntity.ok(projectService.getAllProject());
    }
    @GetMapping(value = "chi-tiet-du-an/{id}",produces = SystemConstants.TYPE_JSON)
    public ResponseEntity<ProjectDto> findProjectId(@PathVariable Integer id){
        ProjectDto ProjectDto = projectService.findProjectById(id);
        return ResponseEntity.ok(ProjectDto);
    }
    @PostMapping(value = "/add",consumes = SystemConstants.TYPE_JSON)
    public ResponseEntity saveProject(@RequestBody ProjectDto projectDto){
        String views = projectService.createProject(projectDto);
        return ResponseEntity.ok(new WrapperResult(200, views));
    }
    @PutMapping(value = "/editProject/{id}",consumes = SystemConstants.TYPE_JSON)
    public ResponseEntity updateProject(@RequestBody ProjectDto ProjectDto){
        String views = projectService.updateProject(ProjectDto);
        return ResponseEntity.ok(new WrapperResult(200, views));
    }
    @DeleteMapping(value = "/xoa-danh-sach-du-an",consumes = SystemConstants.TYPE_JSON)
    public ResponseEntity deleteProject(@RequestBody ProjectDto ProjectDto){
        String views ="";
        if(ProjectDto.getIds()!=null){
            views = projectService.deleteProject(ProjectDto.getIds());
        }else{
            views="không tồn tại";
        }
        return ResponseEntity.ok(views);
    }
    @DeleteMapping(value = "/xoa-du-an/{id}",consumes = SystemConstants.TYPE_JSON)
    public ResponseEntity deleteProjectById(@RequestBody ProjectDto ProjectDto){
        String views ="";
        if(ProjectDto.getId()!=null){
            views = projectService.deleteProjectById(ProjectDto.getId());
        }else{
            views="không tồn tại";
        }
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
