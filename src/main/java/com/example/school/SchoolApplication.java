package com.example.school;

import com.example.school.ClassDesign.models.Course;
import com.example.school.ClassDesign.models.Instructor;
import com.example.school.ClassDesign.models.InstructorDetail;
import com.example.school.ClassDesign.models.Student;
import com.example.school.ClassDesign.services.InstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SchoolApplication {
    private static final Logger logger = LoggerFactory.getLogger(SchoolApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SchoolApplication.class, args);
        InstructorService instructorService = context.getBean("instructorService", InstructorService.class);
        Instructor instructor1 = new Instructor("Vinit", new InstructorDetail("Great Teacher"));
        instructor1.addCourse(new Course("Physics"));
        instructor1.addCourse(new Course("Maths"));
        instructor1.addStudent(new Student("Tony", "kvinit1704@gmail.com"));
        instructor1.addStudent(new Student("Stark", "kvinit1704@gmail.com"));

        Instructor instructor2 = new Instructor("Kay", new InstructorDetail("Great Teacher"));
        instructor2.addCourse(new Course("Physicsz"));
        instructor2.addCourse(new Course("Mathsz"));
        instructor2.addStudent(new Student("Tonyz", "kvinit1704@gmail.com"));
        instructor2.addStudent(new Student("Starkz", "kvinit1704@gmail.com"));

        logger.info("Saving instructor1 " + instructorService.save(instructor1));
        logger.info("Saving instructor2 " + instructorService.save(instructor2));
    }
}
