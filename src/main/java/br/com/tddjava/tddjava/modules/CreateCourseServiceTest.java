package br.com.tddjava.tddjava.modules;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.services.CreateCourseService;

import br.com.tddjava.tddjava.repositories.CourseInMemoryRepository;
import org.junit.Assert;
import org.junit.Test;

public class CreateCourseServiceTest {
    @Test
    public void should_be_able_to_create_a_new_course() {


        Course course = new Course();
        course.setDescription("Course-Description-teste");
        course.setName("Course-Name");
        course.setWorkload(100);

        CourseInMemoryRepository repository = new CourseInMemoryRepository();

        CreateCourseService createCourseService = new CreateCourseService(repository);
        Course createdCourse = createCourseService.execute(course);

        Assert.assertNotNull(createdCourse.getId());


    }
    @Test(expected = Error.class)
    public void should_not_be_able_to_create_a_new_course_if_exists() {

        Course course = new Course();
        course.setDescription("Course-Description-teste");
        course.setName("Course-Name");
        course.setWorkload(100);

        CourseInMemoryRepository repository = new CourseInMemoryRepository();

        CreateCourseService createCourseService = new CreateCourseService(repository);
        createCourseService.execute(course);
        createCourseService.execute(course);


    }
}
