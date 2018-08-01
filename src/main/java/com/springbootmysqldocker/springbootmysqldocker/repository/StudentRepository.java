package com.springbootmysqldocker.springbootmysqldocker.repository;

import com.springbootmysqldocker.springbootmysqldocker.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByNumber (Integer number);
    List<Student> findByRegistrationDate (Long registrationDate);
    List<Student> findByRegistrationDateAfter (Long registrationDate);
    List<Student> findByDepartment (String department);
    List<Student> findByFaculty (String faculty);
}
