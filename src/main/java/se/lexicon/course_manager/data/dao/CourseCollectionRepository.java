package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setStartDate(startDate);
        course.setWeekDuration(weekDuration);
        return course;
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
        Collection<Course> coursesFound = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCourseName().contains(name)) {
                coursesFound.add(course);
            }
        }
        return coursesFound;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        Collection<Course> coursesFound = new ArrayList<>();
        for (Course course : courses) {
            if (course.getStartDate().isBefore(end)) {
                coursesFound.add(course);
            }
        }
        return coursesFound;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        Collection<Course> coursesFound = new ArrayList<>();
        for (Course course : courses) {
            if (course.getStartDate().isAfter(start)) {
                coursesFound.add(course);
            }
        }
        return coursesFound;
    }

    @Override
    public Collection<Course> findAll() {
        return this.courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        Collection<Course> coursesFound = new ArrayList<>();
        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                if (student.getId() == studentId) {
                    coursesFound.add(course);
                }
            }
        }
        return coursesFound;
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
