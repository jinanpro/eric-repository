package service;

import entity.Student;
import ericspring.EricSpringBootApplication;

@EricSpringBootApplication
public class StudentService {
    Student student;

    /**
     * get和set方法
     */
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * 写个方法
     */
    public void getMessage() {
        System.out.println(student.getMessage());
    }

}
