package com.aassoua.mvc.service.imp;

import com.aassoua.mvc.dto.ClubDto;
import com.aassoua.mvc.module.Club;
import com.aassoua.mvc.repository.ClubRepository;
import com.aassoua.mvc.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImp implements ClubService {

    @Autowired
    private ClubRepository ClubDAO;

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = ClubDAO.findAll();
        return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());
    }

    @Override
    public void saveClub(Club club) {
        ClubDAO.save(club);
    }

    @Override
    public ClubDto updateClub(Long id) {
        return null;
    }

    @Override
    public ClubDto findClubById(Long id) {
        Optional<Club> club = ClubDAO.findById(id);
        return club.map(this::mapToClubDto).orElse(null);
    }

    private ClubDto mapToClubDto(Club club) {
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .photoUrl(club.getPhotoUrl())
                .updatedOn(club.getUpdatedOn())
                .build();
    }
}

