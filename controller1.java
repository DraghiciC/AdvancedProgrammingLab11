package com.example.demo;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class controller1 {
 private final List<GameData> games = new ArrayList<>();
 public controller1() {
 }
 @GetMapping
 public List<GameData> getProducts() {
 return games;
 }
 @PostMapping
 public void createGame(@RequestParam String p1,String p2, String content) {
	 games.add(new GameData(p1,p2,content));
 }
 @PutMapping("/{id}")
 public ResponseEntity<String> updateGame(@PathVariable String p, @RequestParam String p1,@RequestParam String p2,@RequestParam String content) {
 GameData game = findByPlayer(p);
 if (game == null) {
 return new ResponseEntity<>(
 "Game not found", HttpStatus.NOT_FOUND);
 }
 game= new GameData(p1,p2,content);
 return new ResponseEntity<>(
 "Game updated successsfully", HttpStatus.OK);
 }
private GameData findByPlayer(String p) {
	for (GameData game : games) {
        if (game.getNamep1().equals(p)) {
            return game;
        }
        if (game.getNamep2().equals(p)) {
            return game;
        }
    }
	return null;
}
@DeleteMapping(value = "/{id}")
public ResponseEntity<String> deleteGame(@PathVariable String p1,@PathVariable String p2) {
GameData game = findByPlayers(p1,p2);
if (game == null) {
return new ResponseEntity<>(
"Game not found", HttpStatus.GONE);
}
games.remove(game);
return new ResponseEntity<>("Game deleted", HttpStatus.OK);
}
private GameData findByPlayers(String p1,String p2) {
	for (GameData game : games) {
        if (game.getNamep1().equals(p1)) {
            return game;
        }
        if (game.getNamep2().equals(p2)) {
            return game;
        }
    }
	return null;
}

}