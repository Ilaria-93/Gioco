package com.example.fantasy.controllers;

import com.example.fantasy.entities.Carattere;
import com.example.fantasy.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gioco")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    // Restituisce l'elenco completo dei personaggi
    @GetMapping("/characters")
    public List<Carattere> getCharachter(Carattere carattere) {
        return characterService.getAllCharacters();
    }

    // Restituisce i dettagli di un personaggio specifico
    @GetMapping("/characters/{id}")
    public ResponseEntity<Carattere> getCharacterById(@PathVariable Integer id) {
        Optional<Carattere> carattereOpt = characterService.getCharacterById(id);
        if (carattereOpt.isPresent()) {
            return ResponseEntity.ok(carattereOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Crea un nuovo personaggio
    @PostMapping
    public Carattere createCharacter(@RequestBody Carattere carattere) {
        return characterService.createCharacter(carattere);
    }

    // Aggiorna i dettagli di un personaggio esistente
    @PutMapping("/{id}")
    public ResponseEntity<Carattere> updateCharacter(@PathVariable Integer id, @RequestBody Carattere carattere) {
        Optional<Carattere> updatedCarattere = characterService.updateCharacter(id, carattere);
        if (updatedCarattere.isPresent()) {
            return ResponseEntity.ok(updatedCarattere.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Rimuove un personaggio dall'elenco
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        Optional<Carattere> carattere = characterService.getCharacterById(id);
        if (carattere.isPresent()) {
            characterService.deleteCharacter(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Cerca personaggi per nome, razza o classe
    @GetMapping("/search")
    public List<Carattere> searchCharacters(@RequestParam String keyword) {
        return characterService.searchCharacters(keyword);
    }

    // Combattimento tra due personaggi
    @GetMapping("/fight")
    public ResponseEntity<Carattere> fightCharacters(@RequestParam Integer id1, @RequestParam Integer id2) {
        Optional<Carattere> winnerOpt = characterService.fightCharacters(id1, id2);
        if (winnerOpt.isPresent()) {
            return ResponseEntity.ok(winnerOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
