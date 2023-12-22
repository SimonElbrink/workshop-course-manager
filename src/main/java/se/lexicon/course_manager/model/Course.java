package se.lexicon.course_manager.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Course {

    private Integer id;
    private String courseName;
    private LocalDate courseStart;
    private Integer weekDuration;
    private Collection<Student> students;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
        this.students = new HashSet<>();
    }

    public Course(Integer id, String courseName, LocalDate courseStart, Integer weekDuration) {
        this(id);
        this.courseName = courseName;
        this.courseStart = courseStart;
        this.weekDuration = weekDuration;
    }

    public Integer getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getCourseStart() {
        return courseStart;
    }

    public void setCourseStart(LocalDate courseStart) {
        this.courseStart = courseStart;
    }

    public Integer getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(Integer weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student) {
        boolean wasEnrolled = false;

        if (!students.contains(student) && student != null) {
            wasEnrolled = students.add(student);
        }
        return wasEnrolled;
    }

    public boolean unrollStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId()) && Objects.equals(getCourseName(), course.getCourseName()) && Objects.equals(getCourseStart(), course.getCourseStart()) && Objects.equals(getWeekDuration(), course.getWeekDuration()) && Objects.equals(getStudents(), course.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCourseName(), getCourseStart(), getWeekDuration(), getStudents());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseStart=" + courseStart +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
