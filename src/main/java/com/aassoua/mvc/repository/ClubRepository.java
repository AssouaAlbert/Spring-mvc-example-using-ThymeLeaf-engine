package com.aassoua.mvc.repository;

import com.aassoua.mvc.module.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String url);
}
