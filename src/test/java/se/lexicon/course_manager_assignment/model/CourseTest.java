package se.lexicon.course_manager_assignment.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest {
    Course testObject;
    Student student;

    @BeforeEach
    void init() {
        testObject = new Course(1);
        student = new Student(1);
    }

    @Test
    void enrollStudent() {
        testObject.enrollStudent(student);

        assertTrue(testObject.getStudents().contains(student));

    }

    @Test
    void unrollStudent() {
        testObject.setStudents(new ArrayList<>(Collections.singletonList(student)));

        assertTrue(testObject.unrollStudent(student));
    }

    @Test
    void unrollStudent_nonExisting() {
        assertFalse(testObject.unrollStudent(student));
    }

}
