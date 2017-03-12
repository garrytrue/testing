package com.garrytrue;

import com.garrytrue.model.Student;
import com.garrytrue.repository.CRUDRepository;
import com.garrytrue.repository.StudentInMemoryRepository;
import com.garrytrue.repository.StudentRESTRepository;

import java.util.HashMap;

public class Application {
    private CRUDRepository<Student> inMemoryRestChainedRepository;

    public static void main(String[] args) {
        Application app = new Application();
        app.initChainOfRepo();
        app.inMemoryRestChainedRepository.save(new Student("Igor", "Torba"));
        Student nullStudent = app.inMemoryRestChainedRepository.get(5);
        Student torba = app.inMemoryRestChainedRepository.get(1);
        System.out.println(nullStudent);
        System.out.println(torba);
    }

    void initChainOfRepo() {
        CRUDRepository<Student> restRepo = new StudentRESTRepository(null);
        inMemoryRestChainedRepository = new StudentInMemoryRepository(new HashMap<>(), restRepo);
    }
}
