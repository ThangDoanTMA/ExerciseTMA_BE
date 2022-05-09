package com.example.ManagerEmployee.Controller;

import com.example.ManagerEmployee.Model.Team;
import com.example.ManagerEmployee.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders ="*" )
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("team/create")
    public String createTeam(@RequestBody Team team){
        Team insertTeam = teamRepository.insert(team);
        return "Employee created " + insertTeam.getTeamName();
    }

    @PostMapping("team/delete={id}")
    public void deleteEmployee(@PathVariable String id) {
        teamRepository.deleteById(id);
    }

    @GetMapping("/team/list")
    public List<Team> listTeam(){
        return teamRepository.findAll();
    }
}
