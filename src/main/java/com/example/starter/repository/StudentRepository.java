package com.example.starter.repository;

import com.example.starter.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.tokens.Token;


@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {
}
