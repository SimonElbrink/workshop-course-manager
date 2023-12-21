package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.StudentSequencer;
import se.lexicon.course_manager.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class StudentCollectionRepository implements StudentDao{

    private Collection<Student> students = new ArrayList<>();

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    public StudentCollectionRepository() { }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student = new Student(StudentSequencer.nextStudentId(),name, email, address);
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for (Student student: students) {
            if(student.getEmail().equalsIgnoreCase(email)) return student;
        }

        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> studentsByNameContains = new ArrayList<>();
        for (Student student: students) {
            if(student.getName().equalsIgnoreCase(name)) studentsByNameContains.add(student);
        }

        return studentsByNameContains;
    }

    @Override
    public Student findById(int id) {
        for (Student student: students) {
            if(student.getId() == id) return student;
        }

        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return students;
    }

    @Override
    public boolean removeStudent(Student student) {
        Student studentToRemove = null;
        for (Student check: students) {
            if(check.equals(student)) studentToRemove = check;
        }
        if(studentToRemove != null) students.remove(studentToRemove);
        return studentToRemove != null;
    }

    @Override
    public void clear() {
        students.clear();
    }
}
