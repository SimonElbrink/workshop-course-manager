package se.lexicon.course_manager.data.dao;


import se.lexicon.course_manager.data.sequencers.CourseSequencer;
import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class CourseCollectionRepository implements CourseDao {

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {

        Course newCourseToAdd = new Course(CourseSequencer.nextCourseId(), courseName, startDate, weekDuration);

        //Ternary operator
        return courses.add(newCourseToAdd) ? newCourseToAdd : null;
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

        Set<Course> namesFound = new HashSet<>();

        for (Course c :
                courses) {
            if (c.getCourseName().contains(name)) {
                namesFound.add(c);
            }
        }

        return namesFound;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {

        Set<Course> coursesStartDateBefore = new HashSet<>();

        for (Course c : courses) {
            if (c.getCourseStart().isBefore(end)) {
                coursesStartDateBefore.add(c);
            }
        }

        return coursesStartDateBefore;
    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        Set<Course> coursesStartDateAfter = new HashSet<>();

        for (Course c : courses) {
            if (c.getCourseStart().isAfter(start)) {
                coursesStartDateAfter.add(c);
            }
        }

        return coursesStartDateAfter;
    }

    @Override
    public Collection<Course> findAll() {
        return Collections.unmodifiableCollection(courses);
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        Set<Course> coursesFoundWithMatchingStudent = new HashSet<>();


        for (Course c : courses) {
            for (Student s : c.getStudents()) {
                if (s.getId() == studentId) {
                    coursesFoundWithMatchingStudent.add(c);
                }
            }
        }
        return coursesFoundWithMatchingStudent;
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
