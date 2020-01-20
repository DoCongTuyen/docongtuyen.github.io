package com.itsol.projectservice.service.Impl;

import com.itsol.projectservice.domain.Team;
import com.itsol.projectservice.dto.TeamDto;
import com.itsol.projectservice.repository.TeamRepository;
import com.itsol.projectservice.service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {


    private TeamRepository teamRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<TeamDto> getAllTeam() {
        List<Team> list = teamRepository.findAll();
        modelMapper = new ModelMapper();
        return list.stream().map(team ->
                modelMapper.map(team, TeamDto.class)).collect(Collectors.toList());
    }

    @Override
    public void create(Team team) {

    }

    @Override
    public void update(Team team) {

    }

    @Override
    public void delete(long teamId) {

    }

    @Override
    public TeamDto getTeamById(Long teamId) {
        return null;
    }
}
