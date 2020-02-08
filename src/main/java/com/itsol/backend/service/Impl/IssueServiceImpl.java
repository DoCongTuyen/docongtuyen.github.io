package com.itsol.backend.service.Impl;

import com.itsol.backend.domain.Issue;
import com.itsol.backend.dto.IssueDto;
import com.itsol.backend.repository.IssueRepository;
import com.itsol.backend.service.IssueService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)//xay ra exception thi quay lai
public class IssueServiceImpl implements IssueService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private  ModelMapper modelMapper;//truyen data giữa 2 object


    @Override
    @Transactional(readOnly = true)
    public List<IssueDto> getAllIssue() {
        logger.trace("Service to get all Issue");
        List<Issue> issueList= issueRepository.findAll();
        modelMapper = new ModelMapper();
        return issueList.stream().map(issue ->
                modelMapper.map(issue, IssueDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(IssueDto issueDto) {
        logger.trace("Service to create issue: {}", issueDto);
        Issue issue = modelMapper.map(issueDto,Issue.class);
        issueRepository.save(issue);
        System.out.println(issue);
    }

    @Override
    public void update(IssueDto issueDto) {

    }

    @Override
    public void delete(long issueId) {

    }

    @Override
    public IssueDto getIssueID(Long issueId) {
        return null;
    }


//    private ModelMapper modelMapper;
//    @Autowired
//    private IssueRepository issueRepository;
//    @Override
//    public List<IssueDto> get() {
////        List<Issue> issues = issueRepository.get();
////        return issues.stream().map(issue -> modelMapper.map(issue,IssueDto.class)).collect(Collectors.toList());
//        return  issueRepository.get();
//    }
//
//    @Override
//    public IssueDto get(long id) {
//        return null;
//    }
//
//    @Override
//    public void save(IssueDto issueDto) {
//
//    }
//
//    @Override
//    public void delete(long id) {
//
//    }

}
