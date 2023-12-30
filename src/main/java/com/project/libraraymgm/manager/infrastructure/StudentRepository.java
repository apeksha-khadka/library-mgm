package com.project.libraraymgm.manager.infrastructure;

import com.project.libraraymgm.manager.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student save(Student student) ;
}
