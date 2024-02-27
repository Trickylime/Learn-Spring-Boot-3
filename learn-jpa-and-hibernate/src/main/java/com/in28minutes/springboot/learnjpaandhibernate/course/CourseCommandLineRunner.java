package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Course course1 = new Course(1, "Learn AWS JPA!", "Jack");
        repository.save(course1);
        repository.save(new Course(2, "Learn Azure JPA!", "Jack"));
        repository.save(new Course(3, "Learn DevOps JPA!", "Jack"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("Jack"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("DevOps"));
        System.out.println(repository.findByName("Learn DevOps JPA!"));
    }
}
