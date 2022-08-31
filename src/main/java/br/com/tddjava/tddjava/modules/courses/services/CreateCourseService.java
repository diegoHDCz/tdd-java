package br.com.tddjava.tddjava.modules.courses.services;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.repositories.CourseJPARepository;
import br.com.tddjava.tddjava.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseService {

    private ICourseRepository repository;

    public CreateCourseService(ICourseRepository repository){
        this.repository = repository;
    }

    public Course execute(Course course) {
        Course existCurse = repository.findByName(course.getName());

        if (existCurse != null) {
            throw new Error("Curso já existe");
        }

        return repository.save(course);


    }
}
