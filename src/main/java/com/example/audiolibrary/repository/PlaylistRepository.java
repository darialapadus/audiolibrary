package com.example.audiolibrary.repository;

import com.example.audiolibrary.model.Playlist;
import com.example.audiolibrary.model.Song;
import com.example.audiolibrary.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
//    List<Playlist> findByOwner(User owner);
    Page<Playlist> findByOwner(User owner, Pageable pageable);
    Optional<Playlist> findByIdAndOwner(Long id, User owner);
    Optional<Playlist> findByNameAndOwner(String name, User owner);
}
