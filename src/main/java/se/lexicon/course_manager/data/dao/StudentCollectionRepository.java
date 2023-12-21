package se.lexicon.course_manager.data.dao;



import se.lexicon.course_manager.data.sequencers.StudentSequencer;
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
        int id = StudentSequencer.nextStudentId();
        Student newStudent = new Student(id, name, email, address);
        students.add(newStudent);
        return newStudent;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
        //if (students.contains(student.getEmail())) {
        //    return student;
        //}

        for (Student student : students) {

            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }
    // if above is correct?
    @Override
    public Collection<Student> findByNameContains(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    } // Do last

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        //return null;
        return this.students; // do we need to iterate with a loop?
        // return new array list (students).

    }
    // just return the whole Set?
    @Override
    public boolean removeStudent(Student student) {
        //if (students.contains(student)){
            //students.remove(student); // Is this enough? Just remove the object Student
            //which is passed in here? Do we need to worry about how the student will be
            //removed for example by id? That is probably already implemented and no need
            //to worry about it?
            //return true;
        //}
        //return false;
        return students.remove(student); // this always returns boolean.
    }
    // ask if above is correct.
    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
