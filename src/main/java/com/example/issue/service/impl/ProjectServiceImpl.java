package com.example.issue.service.impl;

import com.example.issue.Dto.ProjectDto;
import com.example.issue.Util.Tpage;
import com.example.issue.entity.Project;
import com.example.issue.Repository.ProjectRepository;
import com.example.issue.service.ProjectService;
import javafx.scene.control.Tab;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper= modelMapper;
    }
   @Override
   public ProjectDto update(Long id, ProjectDto project) throws IllegalAccessException {
        Project projectDb= projectRepository.getOne(id);
        if (projectDb==null){
            throw new IllegalAccessException("project does not exist" +id);
        }
       Project projectCheck= (Project) projectRepository.getByProjectCode(project.getProjectCode());
       if (projectCheck!=null&&projectCheck.getId()!=projectDb.getId()){
           throw new IllegalAccessException("project code already exist");
       }
       projectDb.setProjectCode(project.getProjectCode());
       projectDb.setProjectName(project.getProjectName());
       projectRepository.save(projectDb);
       return modelMapper.map(projectDb,ProjectDto.class);
   }

    @Override
    public ProjectDto save(ProjectDto project) throws IllegalAccessException {
        Project projectCheck= (Project) projectRepository.getByProjectCode(project.getProjectCode());
        if (projectCheck!=null){
            throw new IllegalAccessException("project code already exist");
        }
        Project p =modelMapper.map(project,Project.class);
        p=projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public void save(ProjectDto project, Tab projectDb) throws IllegalAccessException {
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p= projectRepository.getOne(id);

        if(Objects.isNull(p) || Objects.isNull(p.getId()))
            throw new RuntimeException("kayıt bulunamadı");
        return modelMapper.map(p,ProjectDto.class);
    }
    @Override
    public ProjectDto getByProjectCode(String ProjectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String ProjectCode) {
        return null;
    }

    @Override
    public Page<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        Tpage<ProjectDto> response = new Tpage<ProjectDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return (Page<ProjectDto>) response;
    }

    @Override
    public Boolean delete(ProjectDto  project) {
        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

}
