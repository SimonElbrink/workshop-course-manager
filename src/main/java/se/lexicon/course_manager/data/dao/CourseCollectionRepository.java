package se.lexicon.course_manager.data.dao;

import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        return new Course(courseName, startDate, weekDuration);
    }

    @Override
    public Course findById(int id) {
        if(courses!=null){
            for(Course course : courses){
                if(course.getId() == id){
                    return course;
                }
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        List<Course> coursesMatched = new ArrayList<>();
        if(courses!=null){
            for(Course course : courses){
                if(course.getCourseName().contains(name)){
                    coursesMatched.add(course);
                }
            }
        }
        return coursesMatched;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        List<Course> coursesBefore = new ArrayList<>();
        if(courses != null){
            for(Course course : courses){
                if(course.getStartDate().isBefore(end)){
                    coursesBefore.add(course);
                }
            }
        }
        return coursesBefore;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        List<Course> coursesAfter = new ArrayList<>();
        if(courses != null){
            for(Course course : courses){
                if(course.getStartDate().isAfter(start)){
                    coursesAfter.add(course);
                }
            }
        }
        return coursesAfter;
    }

    @Override
    public Collection<Course> findAll() {
        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        List<Course> coursesEnrolled = new ArrayList<>();
        if(courses != null) {
            for(Course course : courses) {
                Collection<Student> studentsInCourse = course.getStudents();
                for(Student student : studentsInCourse) {
                    if(student.getId() == studentId) {
                        coursesEnrolled.add(course);
                    }
                }
            }
        }
        return coursesEnrolled;
    }

    @Override
    public boolean removeCourse(Course course) {
        if (courses != null && courses.contains(course)) {
            courses.remove(course);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}