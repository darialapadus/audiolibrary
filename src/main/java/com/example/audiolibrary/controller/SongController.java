package com.example.audiolibrary.controller;

import com.example.audiolibrary.model.Song;
import com.example.audiolibrary.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

//    @PostMapping("/create")
//    public Song createSong(@RequestParam String name, @RequestParam String artist, @RequestParam int releaseYear) {
//        try {
//            return songService.createSong(name, artist, releaseYear);
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

    //Audit
    @PostMapping("/create")
    public Song createSong(@RequestParam String name, @RequestParam String artist, @RequestParam int releaseYear, @RequestParam String username) {
        try {
            return songService.createSong(name, artist, releaseYear, username);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

//    @GetMapping("/searchByName")
//    public List<Song> searchSongsByName(@RequestParam String name) {
//        return songService.searchSongsByName(name);
//    }
//
//    @GetMapping("/searchByArtist")
//    public List<Song> searchSongsByArtist(@RequestParam String artist) {
//        return songService.searchSongsByArtist(artist);
//    }

    //Pageable
//    @GetMapping("/searchByName")
//    public Page<Song> searchSongsByName(@RequestParam String name, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return songService.searchSongsByName(name, pageable);
//    }
//
//    @GetMapping("/searchByArtist")
//    public Page<Song> searchSongsByArtist(@RequestParam String artist, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return songService.searchSongsByArtist(artist, pageable);
//    }

    //Pageable+Audit
    @GetMapping("/searchByName")
    public Page<Song> searchSongsByName(@RequestParam String name, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam String username) {
        Pageable pageable = PageRequest.of(page, size);
        return songService.searchSongsByName(name, pageable, username);
    }

    @GetMapping("/searchByArtist")
    public Page<Song> searchSongsByArtist(@RequestParam String artist, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam String username) {
        Pageable pageable = PageRequest.of(page, size);
        return songService.searchSongsByArtist(artist, pageable, username);
    }

}
