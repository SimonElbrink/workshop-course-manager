package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.*;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        int id = CourseSequencer.nextCourseId();
        Course newCourse = new Course(id, courseName, startDate, weekDuration);
        courses.add(newCourse);
        return newCourse;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        HashSet<Course> result = new HashSet<>();
        for (Course course : courses) {
            if (Objects.equals(course.getCourseName(), name)) {
                result.add(course);
            }
        }
        return result;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        HashSet<Course> result = new HashSet<>();
        for (Course course : courses) {
            if (course.getStartDate().isBefore(end)) {
                result.add(course);
            }
        }
        return result;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        HashSet<Course> result = new HashSet<>();
        for (Course course : courses) {
            if (course.getStartDate().isAfter(start)) {
                result.add(course);
            }
        }
        return result;
    }

    @Override
    public Collection<Course> findAll() {
        //return null;
        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        HashSet<Course> result = new HashSet<>();
        //for (Course course : courses) {
        //    if (course.getStudents()) {
        //
        //    }
        //}
        return null;
    }

    @Override
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
