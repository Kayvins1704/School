package com.example.school.ClassDesign.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_detail_id", referencedColumnName = "id")
    @NonNull
    private InstructorDetail instructorDetail;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "instructor_student",
    joinColumns = @JoinColumn(name = "instructor_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Student> studentList;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "instructor_course",
            joinColumns = @JoinColumn(name = "instructor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private List<Course> courseList;

    public void addStudent(Student student){
        if(studentList == null) studentList = new ArrayList<>();
        studentList.add(student);
        student.getInstructorList().add(this);
    }

    public void addCourse(Course course){
        if(courseList == null) courseList = new ArrayList<>();
        courseList.add(course);
        course.getInstructorList().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return id == that.id && name.equals(that.name) && instructorDetail.equals(that.instructorDetail) && Objects.equals(studentList, that.studentList) && Objects.equals(courseList, that.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, instructorDetail, studentList, courseList);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructorDetail=" + instructorDetail +
                ", studentList=" + studentList +
                ", courseList=" + courseList +
                '}';
    }
}
