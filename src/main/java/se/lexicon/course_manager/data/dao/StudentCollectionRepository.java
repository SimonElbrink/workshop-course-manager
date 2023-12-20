package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.model.Course;
import se.lexicon.course_manager.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student= new Student();
        student.setName(name);
        student.setEmail(email);;
        student.setAddress(address);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        for (Student student : students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        Collection<Student> studentsFound = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                studentsFound.add(student);
            }
        }
        return studentsFound;
    }

    @Override
    public Student findById(int id) {
        for (Student student : students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return this.students;
    }

    @Override
    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
