package se.lexicon.course_manager.data.service.student;



import se.lexicon.course_manager.dto.forms.CreateStudentForm;
import se.lexicon.course_manager.dto.forms.UpdateStudentForm;
import se.lexicon.course_manager.dto.views.StudentView;

import java.util.List;

public interface StudentService {
    StudentView create(CreateStudentForm form);

    StudentView update(UpdateStudentForm form);

    StudentView findById(int id);

    StudentView searchByEmail(String email);

    List<StudentView> searchByName(String name);

    List<StudentView> findAll();

    boolean deleteStudent(int id);
}
