package se.lexicon.course_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.course_manager.data.dao.StudentCollectionRepository;

@SpringBootApplication
public class CourseManagerAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagerAssignmentApplication.class, args);
    }

}
