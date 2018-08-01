package com.springbootmysqldocker.springbootmysqldocker.controller;

import com.springbootmysqldocker.springbootmysqldocker.model.Student;
import com.springbootmysqldocker.springbootmysqldocker.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@Slf4j
@RequestMapping(value = "/students")
public class StudentController{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody List<Student> getAll(){
        return (List<Student>) studentRepository.findAll();
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody Student addStudent (@RequestBody Student student){
        //registrationDate convert to timestamp
        Timestamp regDate = new Timestamp(System.currentTimeMillis());
        student.setRegistrationDate(regDate.getTime());
        //birthDate convert to timestamp
        //Timestamp birthDate = new Timestamp(student.getBirthDate());
        //student.setBirthDate(birthDate.getTime());
        log.info("Student added to database. Request : {}",student);
        return studentRepository.save(student);
    }

    @RequestMapping(value = "/byDepartment/{department}",method = RequestMethod.GET)
    public @ResponseBody List<Student> getStudentsByDepartment (@PathVariable String department){
        List<Student> students = studentRepository.findByDepartment(department);
        log.info("{} student(s) found at {}",students.size(),department);
        return students;
    }

    @RequestMapping(value = "/byFaculty/{faculty}",method = RequestMethod.GET)
    public @ResponseBody List<Student> getStudentsByFaculty (@PathVariable String faculty){
        List<Student> students = studentRepository.findByFaculty(faculty);
        log.info("{} student(s) found at {}",students.size(),faculty);
        return students;
    }

    @RequestMapping(value = "/{number}",method = RequestMethod.GET)
    public @ResponseBody Student getStudentByNumber(@PathVariable Integer number){
        Student student = studentRepository.findByNumber(number);
        log.info("Result : {}",student);
        return student;
    }

    @RequestMapping(value = "/dateBefore/{year}/{month}/{day}",method = RequestMethod.GET)
    public @ResponseBody List<Student> getStudentsBefore (@PathVariable Integer year,@PathVariable Integer month,@PathVariable Integer day) throws Exception{
        day = day == null ? 1 : day;
        month = month == null ? 1 : month;
        if (year == null) return null;
        String dateString = year + "-" + month + "-" + day + " 00:00:00";
        //DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        //Date date = format.parse(dateString);
        Timestamp timestamp = Timestamp.valueOf(dateString);
        long date = timestamp.getTime();
        List<Student> students = studentRepository.findByRegistrationDate(date);
        log.info("{} student(s) found at {}",students.size(),dateString);
        return students;
    }
}
