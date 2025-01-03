package com.example.starter.controller.impl;

import com.example.starter.controller.IStudentController;
import com.example.starter.dto.DtoStudent;
import com.example.starter.dto.DtoStudentIU;
import com.example.starter.entites.Student;
import com.example.starter.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "/save2")

    @Override
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU){

        return studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents(){

        return studentService.getAllStudents();
    }




    //id si şu olan öğrenciyi getir
    @GetMapping(path = "/list-by-id/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name="id") Integer id){

        return studentService.getStudentById(id);
    }


    @DeleteMapping(path = "/delete-student/{id}")
    @Override
    public void deleteStudent(@PathVariable(name="id") Integer id){
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/update-student/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name="id") Integer id, @RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.updateStudent(id,dtoStudentIU);
    }


}
