package com.example.school.ClassDesign.repositories;

import com.example.school.ClassDesign.models.Course;
import com.example.school.ClassDesign.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("select i from Instructor i where i.name = :name")
    Optional<Instructor> findByName(@Param("name") String name);

    @Query("select i.courseList from Instructor i where i.name = :name")
    Optional<Course> findCoursesByInstructor(@Param("name") String name);
}
