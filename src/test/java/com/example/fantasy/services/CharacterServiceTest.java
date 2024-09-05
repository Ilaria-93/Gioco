package com.example.fantasy.services;

import static org.junit.jupiter.api.Assertions.*;

class CharacterServiceTest {


        public static void main(String[] args) {
            Character character = new Character();
            character.setNome("Eldar");
            character.setRazza("Elf");
            character.setClasse("Mage");
            character.setDescrizione("A wise mage");

            System.out.println("Nome: " + character.getNome());
            System.out.println("Razza: " + character.getRazza());
            System.out.println("Classe: " + character.getClasse());
            System.out.println("Descrizione: " + character.getDescrizione());
        }

}