package se.lexicon.course_manager.data.service.course;



import se.lexicon.course_manager.dto.forms.CreateCourseForm;
import se.lexicon.course_manager.dto.forms.UpdateCourseForm;
import se.lexicon.course_manager.dto.views.CourseView;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {
    CourseView create(CreateCourseForm form);

    CourseView update(UpdateCourseForm form);

    List<CourseView> searchByCourseName(String courseName);

    List<CourseView> searchByDateBefore(LocalDate end);

    List<CourseView> searchByDateAfter(LocalDate start);

    boolean addStudentToCourse(int courseId, int studentId);

    boolean removeStudentFromCourse(int courseId, int studentId);

    CourseView findById(int id);

    List<CourseView> findAll();

    List<CourseView> findByStudentId(int studentId);

    boolean deleteCourse(int id);
}
