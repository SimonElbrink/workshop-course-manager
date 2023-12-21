package se.lexicon.course_manager.data.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager.data.dao.CourseDao;
import se.lexicon.course_manager.data.dao.StudentDao;
import se.lexicon.course_manager.data.service.converter.Converters;
import se.lexicon.course_manager.dto.forms.CreateStudentForm;
import se.lexicon.course_manager.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager.dto.views.StudentView;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentManager implements StudentService {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final Converters converters;

    @Autowired
    public StudentManager(StudentDao studentDao, CourseDao courseDao, Converters converters) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.converters = converters;
    }


    @Override
    public StudentView create(CreateStudentForm form) {
        return converters.studentToStudentView(studentDao.createStudent(form.getName(), form.getEmail(), form.getAddress()));
    }

    // Satya
    @Override
    public StudentView update(UpdateStudentForm form) {
        for (StudentView studentView : converters.studentsToStudentViews(studentDao.findAll())) {
            if (studentView.getId() == form.getId()) {
                return studentView;
            }
        }
        return null;
    }

    // Madhu
    @Override
    public StudentView findById(int id) {
        for (StudentView studentView : converters.studentsToStudentViews(studentDao.findAll())) {
            if (studentView.getId() == id) {
                return studentView;
            }
        }
        return null;
    }

    // Daniel
    @Override
    public StudentView searchByEmail(String email) {
        for (StudentView studentView : converters.studentsToStudentViews(studentDao.findAll())) {
            if (studentView.getEmail() == email) {
                return studentView;
            }
        }
        return null;
    }


    // Christian
    @Override
    public List<StudentView> searchByName(String name) {
        List<StudentView> students = new ArrayList<>();
        for (StudentView student : converters.studentsToStudentViews(studentDao.findAll())) {
            if (student.getName().equalsIgnoreCase(name)) {
                students.add(student);
            }
        }
        return students;
    }

    @Override
    public List<StudentView> findAll() {
        return converters.studentsToStudentViews(studentDao.findAll());
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.removeStudent(studentDao.findById(id));
    }
}
