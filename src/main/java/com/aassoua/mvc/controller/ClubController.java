package com.aassoua.mvc.controller;

import com.aassoua.mvc.dto.ClubDto;
import com.aassoua.mvc.module.Club;
import com.aassoua.mvc.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping("/clubs")
    public String listClubs(Model model) {
        List<ClubDto> clubs = clubService.findAllClubs();
        System.out.println(clubs);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club){
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

    @PatchMapping("/club/{clubId}/edit")
    public String updateClub(Model model, @PathVariable("clubId") Long id){
        ClubDto club = clubService.findClubById(id);
        clubService.updateClub(id);
        model.addAttribute("club", club);
        return "clubs-list";
    }

}
