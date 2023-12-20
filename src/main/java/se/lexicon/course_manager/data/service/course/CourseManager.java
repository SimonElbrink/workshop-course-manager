package se.lexicon.course_manager.data.service.course;

import jdk.tools.jlink.internal.plugins.VendorBugURLPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager.data.dao.CourseDao;
import se.lexicon.course_manager.data.dao.StudentDao;
import se.lexicon.course_manager.data.service.converter.Converters;
import se.lexicon.course_manager.dto.forms.CreateCourseForm;
import se.lexicon.course_manager.dto.forms.UpdateCourseForm;
import se.lexicon.course_manager.dto.views.CourseView;
import se.lexicon.course_manager.dto.views.StudentView;


import javax.swing.text.View;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseManager implements CourseService {

    private final CourseDao courseDao;
    private final StudentDao studentDao;
    private final Converters converters;

    @Autowired
    public CourseManager(CourseDao courseDao, StudentDao studentDao, Converters converters) {
        this.courseDao = courseDao;
        this.studentDao = studentDao;
        this.converters = converters;
    }

    //Madhu
    @Override
    public CourseView create(CreateCourseForm form) {
        return converters.courseToCourseView(courseDao.createCourse(form.getCourseName(), form.getStartDate(), form.getWeekDuration()));
    }

    //Madhu

    @Override
    public CourseView update(UpdateCourseForm form) {
        for (CourseView courseView : converters.coursesToCourseViews(courseDao.findAll())) {
            if (courseView.getId() == form.getId()) {
                return courseView;
            }
        }
        return null;
    }


    @Override
    public List<CourseView> searchByCourseName(String courseName) {
        List<CourseView> courses = new ArrayList<>();
        for (CourseView courseView : converters.coursesToCourseViews(courseDao.findAll())) {
            if (courseView.getCourseName().contains(courseName)) {
                courses.add(courseView);
            }
        }
        return courses;
    }


    //Daniel
    @Override
    public List<CourseView> searchByDateBefore(LocalDate end) {
        List<CourseView> courses = new ArrayList<>();
        for (CourseView view : converters.coursesToCourseViews(courseDao.findAll())) {
            if (view.getStartDate().isBefore(end)) {
                courses.add(view);
            }
        }
        return courses;
    }

    // Daniel
    @Override
    public List<CourseView> searchByDateAfter(LocalDate start) {
        List<CourseView> courses = new ArrayList<>();
        for (CourseView view : converters.coursesToCourseViews(courseDao.findAll())) {
            if(view.getStartDate().isAfter(start)) {
                courses.add(view);

            }
        }
        return courses;
    }

    @Override
    public boolean addStudentToCourse(int courseId, int studentId) {
        return false;
    }

    @Override
    public boolean removeStudentFromCourse(int courseId, int studentId) {
        return false;
    }

    // Chris
    @Override
    public CourseView findById(int id) {
        for (CourseView course : converters.coursesToCourseViews(courseDao.findAll())) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<CourseView> findAll() {
        return converters.coursesToCourseViews(courseDao.findAll());
    }

    @Override
    public List<CourseView> findByStudentId(int studentId) {
        List<CourseView> courses = new ArrayList<>();

        for (CourseView courseView : converters.coursesToCourseViews(courseDao.findAll())) {
            for(StudentView student : converters.studentsToStudentViews(studentDao.findAll())){
                if (student.getId()==studentId){
                    courses.add(courseView);
                }
            }
        }
        return courses;
    }

    @Override
    public boolean deleteCourse(int id) {
            return courseDao.removeCourse(courseDao.findById(id));
    }
}
