package com.example.issue.service;

import com.example.issue.Dto.ProjectDto;
import javafx.scene.control.Tab;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ProjectService {
    void save(ProjectDto project, Tab projectDb) throws IllegalAccessException;
    ProjectDto getById(Long id);
    ProjectDto getByProjectCode(String projectCode);
    List<ProjectDto> getByProjectCodeContains(String projectCode);
    Page<ProjectDto> getAllPageable(Pageable pageable);
    Boolean delete(ProjectDto project);
    ProjectDto update(Long id,ProjectDto project) throws IllegalAccessException;

    Object save(ProjectDto project) throws IllegalAccessException;
}
