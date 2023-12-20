package se.lexicon.course_manager.model;


import java.time.LocalDate;
import java.util.Collection;

public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration, Collection<Student> students) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
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

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student) {
        return students.add(student);
    }

    public boolean unenrollStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return id == course.id && weekDuration == course.weekDuration && courseName.equals(course.courseName) && startDate.equals(course.startDate) && students.equals(course.students);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + courseName.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + weekDuration;
        result = 31 * result + students.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +", courseName='" + courseName + '\'' + ", startDate=" + startDate + ", weekDuration=" + weekDuration + ", students=" + students + '}';
    }
}