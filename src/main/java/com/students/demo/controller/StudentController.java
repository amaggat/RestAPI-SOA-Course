package com.students.demo.controller;

import com.students.demo.model.Students;
import com.students.demo.repo.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import javax.persistence.criteria.Predicate;


@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/api/students")
    public Page<Students> list(@RequestParam(name ="name", required = false) String name,
                               @RequestParam(name ="gender", required = false) String gender,
                               @RequestParam(name ="dob", required = false) String dob,
                               Pageable pageable){
        Page<Students> students = studentRepository.findAll((Specification<Students>) (root, cq, cb)-> {
            Predicate p = cb.conjunction();
            if(Objects.nonNull(name)){
                p = cb.and(p, cb.like(root.get("name"), "%" + name + "%"));
            }
            if(Objects.nonNull(gender)){
                p = cb.and(p, cb.equal(root.get("gender"), gender ));
            }
            if(Objects.nonNull(dob)){
                p = cb.and(p, cb.equal(root.get("dob"), dob ));
            }
            return p;
        }, pageable);
        return students;
    }

    @GetMapping("/api/students/{id}")
    public Students searchByID (@PathVariable("id") int studentID) {
        return studentRepository.findByID(studentID);
    }

//    public ResponseEntity addStudent (@RequestBody Students students){
//        studentRepository.save(students);
//        return new ResponseEntity(HttpStatus.OK);
//    }


}
