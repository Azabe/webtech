package com.example.groupspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Matchday")
public class Matchday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name ="id")
	private Season season;
	@Column(name ="Season_Id")
	private long seasonid;
	@Column(name ="Matchday_Id")
	private long matchdayid;
	@Column(name ="Home_Team")
	private String hometeam;
	@Column(name ="Away_Team")
	private String awayteam;
	@Column(name ="Status")
	private String status;
	@Column(name ="Situation")
	private String situation;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSeasonid() {
		return seasonid;
	}
	public void setSeasonid(long seasonid) {
		this.seasonid = seasonid;
	}
	public long getMatchdayid() {
		return matchdayid;
	}
	public void setMatchdayid(long matchdayid) {
		this.matchdayid = matchdayid;
	}
	public String getHometeam() {
		return hometeam;
	}
	public void setHometeam(String hometeam) {
		this.hometeam = hometeam;
	}
	public String getAwayteam() {
		return awayteam;
	}
	public void setAwayteam(String awayteam) {
		this.awayteam = awayteam;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	
}
