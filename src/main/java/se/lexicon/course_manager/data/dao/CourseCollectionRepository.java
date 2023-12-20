package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;
    private CourseSequencer courseSequencer;


    public CourseCollectionRepository(Collection<Course> courses) {

        this.courses = courses;
        this.courseSequencer = new CourseSequencer();
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        int id = CourseSequencer.nextCourseId();
        Course course = new Course (id, courseName, startDate, weekDuration, new HashSet<>());
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses)
        {
            if(course.getId)() == id)
            {
                return course;
            }
        }

    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        Collection<Course> result = new HashSet<>();
        for ( Course course : courses){
            if (course.getCourseName().contains(name)){
                result.add(course);
            }
        }
        return result;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        Collection<Course> result = new HashSet<>();
        for (Course course : courses){
            if(course.getStartDate().isAfter(end)){
                result.add(course);
            }
        }
        return result;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        Collection<Course> result = new HashSet<>();
        for (Course course : courses){
            if (course.getStartDate().isAfter(start)){
                result.add(course);
            }
        }
        return result;
    }

    @Override
    public Collection<Course> findAll() {
        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        Collection<Course> result = new HashSet<>();
        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                if (student.getId() == studentId) {
                    result.add(course);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public boolean removeCourse(Course course) {
        return courses.remove(course);
    }

    @Override
    public void clear() {
        courses.clear();
    }
}

