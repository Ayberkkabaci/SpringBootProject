package com.example.issue.api;

import com.example.issue.Dto.IssueDto;
import com.example.issue.Dto.ProjectDto;
import com.example.issue.Util.ApiPaths;
import com.example.issue.entity.Issue;
import com.example.issue.service.impl.IssueServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
    private final IssueServiceImpl issueServiceImpl;
    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id) {
        IssueDto projectDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }
    @PostMapping()
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto project) throws IllegalAccessException {    //bütün api leri ResponseEntityle yaz
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id",required = true) Long id ,@Valid @RequestBody IssueDto project) throws IllegalAccessException {
        return ResponseEntity.ok(issueServiceImpl.update(id, project));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true)Long id){
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
