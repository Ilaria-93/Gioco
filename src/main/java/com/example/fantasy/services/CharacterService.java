package com.example.fantasy.services;

import com.example.fantasy.entities.Carattere;
import com.example.fantasy.repositories.CarattereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CarattereRepository carattereRepository;

    // Restituisce l'elenco completo dei personaggi
    public List<Carattere> getAllCharacters() {
        return carattereRepository.findAll();
    }

    // Restituisce un personaggio specifico per ID
    public Optional<Carattere> getCharacterById(Integer id) {
        if (carattereRepository.existsById(id)) {
            return carattereRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    // Crea un nuovo personaggio
    public Carattere createCharacter(Carattere carattere) {
        return carattereRepository.save(carattere);
    }

    // Aggiorna i dettagli di un personaggio esistente
    public Optional<Carattere> updateCharacter(Integer id, Carattere carattere) {
        Optional<Carattere> characterOpt = carattereRepository.findById(id);
        if (characterOpt.isPresent()) {
            Carattere existingCharacter = characterOpt.get();
            existingCharacter.setNome(carattere.getNome());
            existingCharacter.setRazza(carattere.getRazza());
            existingCharacter.setClasse(carattere.getClasse());
            existingCharacter.setDescrizione(carattere.getDescrizione());

            carattereRepository.save(existingCharacter);
            return Optional.of(existingCharacter);
        } else {
            return Optional.empty();
        }
    }

    // Rimuove un personaggio dall'elenco
    public void deleteCharacter(Integer id) {
        carattereRepository.deleteById(id);
    }

    // Cerca personaggi per nome, razza o classe
    public List<Carattere> searchCharacters(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return carattereRepository.findAll();
        }
        return carattereRepository.searchByKeyword(keyword.trim().toLowerCase());
    }

    // Metodo per il combattimento tra due personaggi
    public Optional<Carattere> fightCharacters(Integer id1, Integer id2) {
        Optional<Carattere> carattere1 = carattereRepository.findById(id1);
        Optional<Carattere> carattere2 = carattereRepository.findById(id2);

        if (carattere1.isPresent() && carattere2.isPresent()) {
            Carattere char1 = carattere1.get();
            Carattere char2 = carattere2.get();

            if (char1.getLivello() > char2.getLivello()) {
                return Optional.of(char1);
            } else if (char1.getLivello() < char2.getLivello()) {
                return Optional.of(char2);
            } else {
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }
}
