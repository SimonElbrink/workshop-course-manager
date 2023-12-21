package se.lexicon.course_manager.data.service.converter;


import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.dto.views.StudentView;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.util.Collection;
import java.util.List;

public interface Converters {

    StudentView studentToStudentView(Student student);

    CourseView courseToCourseView(Course course);

    List<CourseView> coursesToCourseViews(Collection<Course> courses);

    List<StudentView> studentsToStudentViews(Collection<Student> students);
}
