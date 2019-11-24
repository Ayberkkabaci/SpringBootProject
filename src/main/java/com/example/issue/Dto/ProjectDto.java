package com.example.issue.Dto;

import com.example.issue.entity.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "project data transfer object")
public class ProjectDto  {
    @ApiModelProperty(value = "Project ID")
    private Long id;
    @NonNull
    @ApiModelProperty(required = true,value = "Name of project")
    private String projectName;
    @NonNull
    @ApiModelProperty(required = true,value = "Code of project")
    private String projectCode;
}
