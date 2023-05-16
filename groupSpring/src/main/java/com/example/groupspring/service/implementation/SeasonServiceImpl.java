package com.example.groupspring.service.implementation;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.groupspring.model.Matchday;
import com.example.groupspring.model.Season;
import com.example.groupspring.model.Team;
import com.example.groupspring.repository.MatchdayRepository;
import com.example.groupspring.repository.SeasonRepository;
import com.example.groupspring.repository.TeamRepository;
import com.example.groupspring.service.SeasonInterface;


@Service
public class SeasonServiceImpl implements SeasonInterface {
	@Autowired
    SeasonRepository seasonRepository;
	
	@Autowired
    TeamRepository teamRepository;
	
	@Autowired
    MatchdayRepository matchdayRepository;

	@Override
	public Season registerSeason(Season seas) {
		return seasonRepository.save(seas);
	}

	@Override
	public Season updateSeason(Season seas) {
		return seasonRepository.save(seas);
	}

	@Override
	public void deleteSeason(String seas) {
		seasonRepository.deleteById(seas);
	}

	@Override
	public List<Season> seasonList() {
		return seasonRepository.findAll();
	}

	@Override
	public Season findSeasonBySeasonId(String seas) {
		return seasonRepository.findById(seas).get();
	}

	@Override
	public Team registerTeam(Team tea) {
		return teamRepository.save(tea);
	}

	@Override
	public Team updateTeam(Team tea) {
		return teamRepository.save(tea);
	}

	@Override
	public void deleteTeam(String tea) {
		teamRepository.deleteById(tea);
	}

	@Override
	public List<Team> teamList() {
		return teamRepository.findAll();
	}

	@Override
	public Team findTeamByTeamId(String tea) {
		return teamRepository.findById(tea).get();
	}

	@Override
	public Matchday registerMatchday(Matchday mat) {
		return matchdayRepository.save(mat);
	}

	@Override
	public Matchday updateMatchday(Matchday mat) {
		return matchdayRepository.save(mat);
	}

	@Override
	public void deleteMatchday(String mat) {
		matchdayRepository.deleteById(mat);
		
	}

	@Override
	public List<Matchday> getAllMatchdays() {
		return matchdayRepository.findAll();
	}

	@Override
	public Matchday findMatchdayByMatchdayId(String mat) {
		return matchdayRepository.findById(mat).get();
	}

	
	

	
}
