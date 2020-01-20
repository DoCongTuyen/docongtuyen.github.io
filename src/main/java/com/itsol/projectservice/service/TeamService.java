package com.itsol.projectservice.service;

import com.itsol.projectservice.domain.Team;
import com.itsol.projectservice.dto.TeamDto;

import java.util.List;

public interface TeamService {
    List<TeamDto> getAllTeam();

    void create(Team team);
    void update(Team team);
    void delete(long teamId);
    TeamDto getTeamById(Long teamId);

}
