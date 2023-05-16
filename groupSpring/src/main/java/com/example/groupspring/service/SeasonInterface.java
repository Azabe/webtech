package com.example.groupspring.service;

import java.util.List;

import com.example.groupspring.model.Matchday;
import com.example.groupspring.model.Season;
import com.example.groupspring.model.Team;

public interface SeasonInterface {
	Season registerSeason(Season seas);
	Season updateSeason(Season seas);
	void deleteSeason(String seas);
	List<Season> seasonList();
	Season findSeasonBySeasonId(String seas);
	
	Team registerTeam(Team tea);
	Team updateTeam(Team tea);
	void deleteTeam(String tea);
	List<Team> teamList();
	Team findTeamByTeamId(String tea);
	
	Matchday registerMatchday(Matchday mat);
	Matchday updateMatchday(Matchday mat);
	void deleteMatchday(String mat);
	List<Matchday> getAllMatchdays();
	Matchday findMatchdayByMatchdayId(String mat);
	
}
