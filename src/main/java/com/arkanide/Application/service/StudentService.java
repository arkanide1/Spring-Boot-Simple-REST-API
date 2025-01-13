package com.arkanide.Application.service;

import com.arkanide.Application.model.Student;
import com.arkanide.Application.repo.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repo ;

    @Autowired
    StudentService(StudentRepository repo){
        this.repo = repo;
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }
    public void addStudent(Student student){
        Optional<Student> studentOptional = repo.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        repo.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = repo.existsById(id);
        if(!exists){
            throw new IllegalStateException("student does not exists");
        }
        repo.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id,  String name , String email) {
        Student student = repo.findById(id).orElseThrow( ()-> new IllegalStateException("student not found") );
        if(name != null && !name.isEmpty() && !Objects.equals(student.getName(), name) ){
            student.setName(name);
        }
        if(email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email) ) {
            Optional<Student> studentOptional = repo.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
