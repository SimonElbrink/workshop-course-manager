package se.lexicon.course_manager.model;

import se.lexicon.course_manager.data.dao.CourseCollectionRepository;
import se.lexicon.course_manager.data.sequencers.CourseSequencer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Course implements Serializable {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students;

    public Course() {
    }

    public Course(int id) {
        this.id = id;
    }

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        setId(CourseSequencer.nextCourseId());
        setCourseName(courseName);
        setStartDate(startDate);
        setWeekDuration(weekDuration);
        setStudents();
    }
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    private void setCourseName(String courseName) {
        // if (courseName == null && courseName.isEmpty()) throw new IllegalArgumentException("Course name was null");
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    private void setStartDate(LocalDate startDate) {
        // if (startDate == null) throw new IllegalArgumentException("Start date was null");
        this.startDate = startDate;
    }

    public int getWeekDuration(){
        return weekDuration;
    }

    private void setWeekDuration(int weekDuration){
        // if (weekDuration == 0) throw new IllegalArgumentException("Week duration was 0");
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents() {
        this.students = new ArrayList<Student>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", courseName='").append(courseName).append('\'');
        sb.append(", startDate=").append(startDate);
        sb.append(", weekDuration=").append(weekDuration);
        sb.append(", students=").append(students);
        sb.append('}');
        return sb.toString();
    }

    public boolean enrollStudent(Student student) {
        if(this.students!= null && !this.students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean unrollStudent(Student student) {
        if(this.students!= null && this.students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;
    }
}