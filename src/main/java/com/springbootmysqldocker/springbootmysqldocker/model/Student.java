package com.springbootmysqldocker.springbootmysqldocker.model;

import javax.persistence.*;

@Entity
@Table(name = "student_info",schema = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    private String name;
    private String surname;
    private String faculty;
    private String department;
    private String birthDate;
    private Long registrationDate;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Long getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Long registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Student [number = "+number+", name="+name+", surname="+surname+", faculty="+faculty+", department="+department+", birthDate="+birthDate+", registrationDate="+registrationDate+"]";
    }
}
