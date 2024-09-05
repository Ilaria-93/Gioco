package com.example.fantasy.repositories;

import com.example.fantasy.entities.Carattere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarattereRepository extends JpaRepository<Carattere, Integer> {

    @Query("SELECT c FROM Carattere c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.razza) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.classe) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Carattere> searchByKeyword(@Param("keyword") String keyword);

}
