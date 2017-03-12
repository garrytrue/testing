package com.garrytrue.repository;


import com.garrytrue.model.Student;

import java.util.Map;

/**
 * Created by garrytrue on 12.03.17.
 */
public class StudentRepository implements CRUDRepository<Student> {
    private final Map<Long, Student> inMemory;

    public StudentRepository(Map<Long, Student> inMemory) {
        this.inMemory = inMemory;
    }


    @Override
    public void save(Student data) {
        inMemory.put(data.getId(), data);
    }

    @Override
    public Student get(long id) {
        return inMemory.get(id);
    }

    @Override
    public void update(Student data) {
        inMemory.replace(data.getId(), data);
    }

    @Override
    public Student delete(Student data) {
        return inMemory.remove(data.getId());
    }


}
