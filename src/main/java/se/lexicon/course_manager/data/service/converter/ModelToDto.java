package se.lexicon.course_manager.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.dto.views.StudentView;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {
        return new StudentView(student.getId(), student.getName(), student.getEmail(), student.getAddress());
    }

    @Override
    public CourseView courseToCourseView(Course course) {
        return new CourseView(course.getId(), course.getCourseName(), course.getStartDate(), course.getWeekDuration(), studentsToStudentViews(course.getStudents()));
    }
    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        List<CourseView> newCourses = new ArrayList<>();
        for (Course course : courses) {
            newCourses.add(courseToCourseView(course));
        }
        return newCourses;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        List<StudentView> newStudents = new ArrayList<>();
        for (Student student : students) {
            newStudents.add(studentToStudentView(student));
        }
        return newStudents;
    }
}
