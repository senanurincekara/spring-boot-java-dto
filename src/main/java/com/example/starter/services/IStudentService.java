package com.example.starter.services;

import com.example.starter.dto.DtoStudent;
import com.example.starter.dto.DtoStudentIU;

import java.util.List;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);

   public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    void deleteStudentById(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoUpdateStudent);
}
