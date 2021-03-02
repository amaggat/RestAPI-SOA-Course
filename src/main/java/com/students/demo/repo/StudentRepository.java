package com.students.demo.repo;

import com.students.demo.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Students, Integer>, JpaSpecificationExecutor<Students> {

    @Query("SELECT DISTINCT student FROM Students student WHERE student.id= :id")
    @Transactional(readOnly = true)
    Students findByID(@Param("id") int id);

}
