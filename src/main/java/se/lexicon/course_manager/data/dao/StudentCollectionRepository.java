package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student =  new Student(name, email, address);
        if(this.students == null){
            this.students = new ArrayList<>();
        }
        else {
            this.students.add(student);
        }
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        // ANITA@lexicon.com , anita@lexicon.com
        if(this.students != null) {
            for(Student student : students) {
                if(student.getEmail().equalsIgnoreCase(email)){
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        //anita r, anitaruth, anitas
        List<Student> matchedStudentNames = new ArrayList<>();
        if(this.students != null) {
            for(Student student : students) {
                if(student.getName().contains(name)){
                    matchedStudentNames.add(student);
                }
            }
        }
        return matchedStudentNames;
    }

    @Override
    public Student findById(int id) {
        if(this.students != null) {
            for(Student student : students) {
                if(student.getId() == id){
                    return student;
                }
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
        return this.students.remove(student);

    }

    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}