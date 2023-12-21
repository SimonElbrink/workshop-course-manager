package se.lexicon.course_manager.model;

import se.lexicon.course_manager.data.sequencers.CourseSequencer;

import java.io.Serializable;
import java.time.LocalDate;
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
        this.id = CourseSequencer.getCourseSequencer();
    }


    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return this.weekDuration;
    }
    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student){
        if(student==null || students.contains(student)){
            return false;
        }
        students.add(student);
        return true;
    }
    public boolean unrollStudent(Student student){
        return students.remove(student);
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
}
