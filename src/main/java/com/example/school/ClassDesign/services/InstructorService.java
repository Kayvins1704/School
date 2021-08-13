package com.example.school.ClassDesign.services;

import com.example.school.ClassDesign.models.Course;
import com.example.school.ClassDesign.models.Instructor;
import com.example.school.ClassDesign.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Optional<Instructor> getInstructorByName(String name){
        return instructorRepository.findByName(name);
    }

    public Optional<Course> getCourseByInstructor(String name){
        return instructorRepository.findCoursesByInstructor(name);
    }
    @Transactional
    public Instructor save(Instructor instructor){
        return instructorRepository.save(instructor);
    }
}
