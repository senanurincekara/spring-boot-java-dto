package com.example.starter.services.impl;

import com.example.starter.dto.DtoStudent;
import com.example.starter.dto.DtoStudentIU;
import com.example.starter.entites.Student;
import com.example.starter.repository.StudentRepository;
import com.example.starter.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudent) {
        //DtoStudent türünde bir response nesnesi oluşturulmuş.
        // Bu nesne, metot tamamlandığında geriye döndürülecek.
        DtoStudent response =new DtoStudent();
        Student student = new Student();
        //, DTO'dan (dtoStudent) entity'ye (student) alanlar (properties) kopyalanmış
        // aynı isim ve tipteki alanları iki nesne arasında taşımak için kullanılır..
        BeanUtils.copyProperties(dtoStudent,student);

        //studentRepository.save(student) ile entity, veritabanına kaydediliyor.
        Student dbStudent = studentRepository.save(student);
        //Kaydedilen entity, dbStudent olarak döndürülüyor. Bu, genellikle
        // birincil anahtar (ID) gibi veritabanı tarafından oluşturulan değerleri içeren,
        // tam bir entity nesnesidir.
        BeanUtils.copyProperties(dbStudent ,response );
       return response;


/*
        Bu metot, bir DTO'yu alıp:

        DTO'yu entity'ye dönüştürüyor.
        Entity'yi veritabanına kaydediyor.
        Veritabanından dönen entity'den yanıt DTO'su oluşturuyor.
        Yanıt DTO'sunu geri döndürüyor.

        */

    }

    @Override
    public List<DtoStudent> getAllStudents(){
        List<DtoStudent> dtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();

        for (Student student : studentList){
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student, dto);
            dtoList.add(dto);
        }

        return  dtoList;
    }


    @Override
    public DtoStudent getStudentById(Integer id){
        DtoStudent dto = new DtoStudent();

        Optional<Student> findStudent = studentRepository.findById(id);
        if(!findStudent.isEmpty()){
            Student dbStudent = findStudent.get();
            BeanUtils.copyProperties(dbStudent , dto);
            return dto;
        }
        return null;
    }


    @Override
    public void deleteStudentById(Integer id){
       Optional<Student> optional= studentRepository.findById(id);

        if(optional != null){
            studentRepository.delete(optional.get());
        }


    }



    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dboStudent){
        DtoStudent dto = new DtoStudent();

        Optional<Student> optional= studentRepository.findById(id);
        if(optional != null){
            Student dbStudent = optional.get();

            dbStudent.setFirstName(dboStudent.getFirstName());
            dbStudent.setLastName(dboStudent.getLastName());
            dbStudent.setBirthOfDate(dboStudent.getBirthOfDate());

           Student updatedStudent =  studentRepository.save(dbStudent);
           BeanUtils.copyProperties(updatedStudent , dto);
           return  dto;
        }
        return null;
    }


}
