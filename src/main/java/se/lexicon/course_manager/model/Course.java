package se.lexicon.course_manager.model;

import java.time.LocalDate;
import java.util.*;

public class Course {

    private int id;

    private String courseName;

    private LocalDate startDate;

    private int weekDuration;

    Collection<Student> students = new HashSet<>();


    public Course(String courseName, LocalDate startDate, int weekDuration) {
        setId(id);
        setCourseName(courseName);
        setStartDate(startDate);
        setWeekDuration(weekDuration);
        //setStudents(students);
        //, HashSet<Student> students
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(HashSet<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student) {
        if (student == null || students.contains(student)) {
            return false;
        }
        return students.add(student);
    }

    public boolean unrollStudent(Student student) {
        return students.remove(student);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Course.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("courseName='" + courseName + "'")
                .add("startDate=" + startDate)
                .add("weekDuration=" + weekDuration)
                .add("students=" + students)
                .toString();
    }
}
