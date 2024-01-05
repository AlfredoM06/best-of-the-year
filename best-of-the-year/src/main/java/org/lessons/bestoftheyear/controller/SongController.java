package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @GetMapping
    public String list(Model model) {
        model.addAttribute("songList", getSongs());
        return "song/songs";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable(name = "id") int songId, Model model) {

        Song song = getSongById(songId);
        model.addAttribute("songId", songId);
        model.addAttribute("song", song);
        return "song/details";
    }


    private List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();

        songs.add(new Song(1, "Flowers", "Miley Cirus"));
        songs.add(new Song(2, "Bad Habits", "Ed Sheeran"));
        songs.add(new Song(3, "Unstoppable", "Sia"));
        songs.add(new Song(4, "Treat You Better", "Shawn Mendes"));
        songs.add(new Song(5, "Calm Down", "Selena Gomez"));

        return songs;
    }


    private Song getSongById(int id) {
        List<Song> songs = getSongs();
        for (Song song : songs) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null;
    }
}
