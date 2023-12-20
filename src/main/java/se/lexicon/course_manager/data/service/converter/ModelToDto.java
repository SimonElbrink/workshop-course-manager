package se.lexicon.course_manager.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.dto.views.StudentView;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {
        return new StudentView(student.getId(), student.getName(), student.getEmail(), student.getAddress());
    }
    @Override
    public CourseView courseToCourseView(Course course) {
        return new CourseView(course.getCourseName(),course.getStartDate(),course.getId(),course.getStudents(),course.getWeekDuration());
    }
    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        return courses.stream()
                .map(this::courseToCourseView)
                .collect(Collectors.toList());
    }
    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        return students.stream()
                .map(this::studentToStudentView)
                .collect(Collectors.toList());
    }
}
