package com.example.starter.repository;

import com.example.starter.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.tokens.Token;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {


    //kendi özel metodlarımız

    //HQL --> SINIFIN İSMİ VE DEĞİŞKEN İSİMLERİ İLE SORGU
    @Query(value = "from Student", nativeQuery =false)
    List<Student> findAllStudent();

    //SQL --> TABLO İSMİ VE TABLO İÇİNDEKİ KOLON SORGULARI İLE SORGU
    @Query(value = "select * from student.student", nativeQuery =true)
    List<Student> findAllStudent2();
}
