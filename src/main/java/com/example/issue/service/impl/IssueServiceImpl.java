package com.example.issue.service.impl;
import com.example.issue.Dto.IssueDto;
import com.example.issue.Util.Tpage;
import com.example.issue.entity.Issue;
import com.example.issue.Repository.IssueRepository;
import com.example.issue.service.IssueService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Arrays;
@Service
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository; //final--> atama yapmayı engeller sadece constructor da atama yapabilirsin
    private final ModelMapper modelMapper;

    public IssueServiceImpl (IssueRepository issueRepository,ModelMapper modelMapper){
    this.issueRepository=issueRepository;
    this.modelMapper=modelMapper;
    }
    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()==null)
            throw new IllegalArgumentException("issue date cannot be null ");
        Issue issueDb = modelMapper.map(issue,Issue.class);
        issueDb= issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }
    @Override
    public IssueDto getById(Long id) {
        return  modelMapper.map(issueRepository.getOne(id),IssueDto.class);
    }
    @Override
    public Tpage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        Tpage<IssueDto> response =new Tpage<>();
        response.setStat(data,Arrays.asList(modelMapper.map(data.getContent(),IssueDto[].class)));
        //IssueDto[] dtos=modelMapper.map(data.getContent(),IssueDto[].class);
        //page.setStat(data, Arrays.asList(dtos));
        return response;
    }
    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return null;
    }
    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }
}