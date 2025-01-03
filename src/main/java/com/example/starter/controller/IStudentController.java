package com.example.starter.controller;

import com.example.starter.dto.DtoStudent;
import com.example.starter.dto.DtoStudentIU;
import com.example.starter.entites.Student;

import java.util.List;

public interface IStudentController {



   public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudents();

    //id si şu olan öğrenciyi getir
    public DtoStudent getStudentById(Integer id);


    void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id , DtoStudentIU dtoStudentIU);
}
