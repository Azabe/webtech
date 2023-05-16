package com.example.groupspring.controller;

import com.example.groupspring.model.Matchday;
import com.example.groupspring.model.Season;
import com.example.groupspring.model.Signup;
import com.example.groupspring.model.Team;
import com.example.groupspring.repository.MatchdayRepository;
import com.example.groupspring.repository.SeasonRepository;
import com.example.groupspring.repository.TeamRepository;
import com.example.groupspring.service.implementation.SeasonServiceImpl;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LeagueController {
	
    @Autowired
    SeasonServiceImpl seasonService;
    @Autowired
    TeamRepository teamrepo;
    @Autowired
    SeasonRepository seasrepo;
    @Autowired
    MatchdayRepository matrepo;

    @GetMapping("/season")
    public String seasonPage(Model model){
        model.addAttribute("season",seasonService.seasonList());
        return "all_seasons";
    }

    @GetMapping("/team") public String teamPage(Model model){
    model.addAttribute("team",seasonService.teamList());
    return "all_teams"; 
    }
    
	 @GetMapping("/matchday") 
	 public String matchdayPage(Model model){
	 model.addAttribute("matchday",seasonService.getAllMatchdays());
	 return "all_matchdays";
	 }
		
    
    @GetMapping("/saveMatchday")
    public String registermatchDayPage(Model model){
        Matchday mat = new Matchday();
        model.addAttribute("matchday", mat);
        return "new_matchday";
    }
    @PostMapping("/saveMatchday")
    public String registerMatchday(@ModelAttribute("matchday") Matchday thematchday){
    	
        Matchday savedMatchday = seasonService.registerMatchday(thematchday);
        if(savedMatchday != null){
            return "redirect:/matchday";
        }
        return "new_matchday";
    }
    @GetMapping("/saveSeason")
    public String registerSeasonPage(Model model){
        Season seas = new Season();
        model.addAttribute("season", seas);
        return "new_season";
    }
    @PostMapping("/saveSeason")
    public String registerSeason(@ModelAttribute("season") Season theseason){
        Season savedSeason = seasonService.registerSeason(theseason);
        if(savedSeason != null){
            return "redirect:/season";
        }
        return "new_season";
    }
    @GetMapping("/saveTeam")
    public String registerTeamPage(Model model){
        Team tea = new Team();
        model.addAttribute("team", tea);
        return "team";
    }
    @PostMapping("/saveTeam")
    public String registerSeason(@ModelAttribute("team") Team theteam){
        Team savedTeam = seasonService.registerTeam(theteam);
        if(savedTeam != null){
            return "redirect:/team";
        }
        return "team";
    }
    @GetMapping("/season/{id}")
    public String editSeason(@PathVariable String id, Model model){
        model.addAttribute("season", seasonService.findSeasonBySeasonId(id));
        return "update_season";
    }
      @PostMapping("/season/{id}")
    public String updateSeason(@PathVariable String id,
                                @ModelAttribute("season") Season season, Model model)
      {
          Season existingSeason=seasonService.findSeasonBySeasonId(id);
          existingSeason.setYear(season.getYear());
          existingSeason.setStatus(season.getStatus());
          Season upSeason = seasonService.updateSeason(existingSeason);
          if(upSeason != null){
              return "redirect:/season";
          }
          return "season";
      }
      @GetMapping("/team/{id}")
      public String editTeam(@PathVariable String id, Model model){
          model.addAttribute("team", seasonService.findTeamByTeamId(id));
          return "update_team";
      }
        @PostMapping("/team/{id}")
      public String updateTeam(@PathVariable String id,
                                  @ModelAttribute("team") Team team, Model model)
        {
            Team existingTeam=seasonService.findTeamByTeamId(id);
            existingTeam.setTeamid(team.getTeamid());
            existingTeam.setPicture(team.getPicture());
            existingTeam.setTeamname(team.getTeamname());
            Team upTeam = seasonService.updateTeam(existingTeam);
            if(upTeam != null){
                return "redirect:/team";
            }
            return "team";
        }
        @GetMapping("/matchday/{id}")
        public String editmatchday(@PathVariable String id, Model model){
            model.addAttribute("matchday", seasonService.findMatchdayByMatchdayId(id));
            return "update_matchday";
        }
          @PostMapping("/matchday/{id}")
        public String updateMatchday(@PathVariable String id,
                                    @ModelAttribute("matchday") Matchday matchday, Model model)
          {
              Matchday existingMatchday=seasonService.findMatchdayByMatchdayId(id);
              existingMatchday.setSituation(matchday.getSituation());
              existingMatchday.setStatus(matchday.getStatus());
              existingMatchday.setMatchdayid(matchday.getMatchdayid());
              Matchday upMatchday = seasonService.updateMatchday(existingMatchday);
              if(upMatchday != null){
                  return "redirect:/matchday";
              }
              return "matchday";
          }
        @GetMapping("/pop/{id}")
        public String pop(@PathVariable String id, Model model){
            model.addAttribute("season", seasonService.findSeasonBySeasonId(id));
            return "pop";
        }

    
        @GetMapping("/pop/del/{id}")
        public String deleteSeason(@PathVariable String id)
     {
         seasonService.deleteSeason(id);
         return "redirect:/season";
     }
        @GetMapping("/pop_tea/{id}")
        public String pop_tea(@PathVariable String id, Model model){
            model.addAttribute("team", seasonService.findTeamByTeamId(id));
            return "pop_tea";
        }

    
        @GetMapping("/pop_tea/del/{id}")
        public String deleteTeam(@PathVariable String id)
     {
         seasonService.deleteTeam(id);
         return "redirect:/team";
     }
        @GetMapping("/pop_mat/{id}")
        public String pop_mat(@PathVariable String id, Model model){
            model.addAttribute("matchday", seasonService.findMatchdayByMatchdayId(id));
            return "pop_matchday";
        }
        @GetMapping("/pop_mat/del/{id}")
        public String deleteMatchday(@PathVariable String id)
     {
         seasonService.deleteMatchday(id);
         return "redirect:/matchday";
     }
        @GetMapping("/logout")
        public String login(Model model){
            Signup signup=new Signup();
            model.addAttribute("login",signup);
           return "login";
        }
        @GetMapping("/first")
        public String first(Model model){
        	long tea = teamrepo.count();
        	model.addAttribute("tea", tea);
        	long sea = seasrepo.count();
        	model.addAttribute("sea", sea);
        	long mat = matrepo.count();
        	model.addAttribute("mat", mat);
            return "index";
        }
    }
