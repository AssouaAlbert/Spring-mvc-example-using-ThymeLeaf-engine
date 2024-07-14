package com.aassoua.mvc.service;

import com.aassoua.mvc.dto.ClubDto;
import com.aassoua.mvc.module.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    void saveClub(Club club);
    ClubDto updateClub(Long id);
    ClubDto findClubById(Long id);
}
