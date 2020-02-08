package com.itsol.backend.service;


import com.itsol.backend.dto.IssueDto;

import java.util.List;

public interface IssueService {

    List<IssueDto> getAllIssue();

    void create(IssueDto issueDto);

    void update(IssueDto issueDto);

    void delete(long issueId);

    IssueDto getIssueID(Long issueId);
//    List<IssueDto> get();
//
//    IssueDto get(long id);
//
//    void save(IssueDto issueDto);
//
//    void delete(long id);
}
