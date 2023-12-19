package se.lexicon.course_manager.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.dto.views.StudentView;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;


import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {
        return null;
    }

    @Override
    public CourseView courseToCourseView(Course course) {
        return null;
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        return null;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        return null;
    }
}
