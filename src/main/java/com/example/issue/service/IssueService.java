package com.example.issue.service;

import com.example.issue.Dto.IssueDto;
import com.example.issue.Util.Tpage;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public interface IssueService {
    IssueDto save(IssueDto issue);
    IssueDto getById(Long id);
    Tpage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete(Long issue);
    IssueDto update(Long id,IssueDto project);
}
