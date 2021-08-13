package com.example.school.ClassDesign.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String emailId;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy="studentList")
    private List<Instructor> instructorList;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy="studentList")
    private List<Course> courseList;

    public void addInstructor(Instructor instructor){
        if(instructorList == null) instructorList = new ArrayList<>();
        instructorList.add(instructor);
        instructor.getStudentList().add(this);
    }

    public void addCourse(Course course){
        if(courseList == null) courseList = new ArrayList<>();
        courseList.add(course);
        course.getStudentList().add(this);
    }
}
