package se.lexicon.course_manager_assignment.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {

        if (student == null) return null;

        return new StudentView(student.getId(), student.getName(), student.getEmail(), student.getAddress());


    }

    @Override
    public CourseView courseToCourseView(Course course) {

        if (course == null) {
            return null;
        }

        return new CourseView(course.getId(), course.getCourseName(), course.getCourseStart(), course.getWeekDuration(), studentsToStudentViews(course.getStudents()));
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {

        if (courses == null) return null;

        List<CourseView> courseViewList = new ArrayList<>();
        for (Course c : courses) {
            courseViewList.add(courseToCourseView(c));
        }

        return courseViewList;

    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {

        if (students == null) return null;

        List<StudentView> studentViewList = new ArrayList<>();
        for (Student s :
                students) {
            studentViewList.add(studentToStudentView(s));
        }
        return studentViewList;
    }
}
