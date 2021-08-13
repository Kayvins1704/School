package com.example.school.ClassDesign.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String courseName;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Student> studentList = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "courseList")
    private List<Instructor> instructorList = new ArrayList<>();

    public void addStudent(Student student){
        if(studentList == null) studentList = new ArrayList<>();
        studentList.add(student);
        student.getCourseList().add(this);
    }

    public void addInstructor(Instructor instructor){
        if(instructorList == null) instructorList = new ArrayList<>();
        instructorList.add(instructor);
        instructor.getCourseList().add(this);
    }
}
