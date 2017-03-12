package com.garrytrue.repository.impl;

import com.garrytrue.model.Student;
import com.garrytrue.repository.CRUDRepository;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class StudentInMemoryRepository implements CRUDRepository<Student> {
    private final Map<Long, Student> studentStorage;
    private final AtomicLong autoId = new AtomicLong(0);

    public StudentInMemoryRepository(Map<Long, Student> studentStorage) {
        this.studentStorage = studentStorage;
    }

    @Override
    public Student save(Student data) {
        long id = autoId.incrementAndGet();
        data.setId(id);
        studentStorage.put(id, data);
        return data;
    }

    @Override
    public Student get(long id) {
        return studentStorage.get(id);
    }

    @Override
    public Student update(Student data) {
        studentStorage.replace(data.getId(), data);
        return data;
    }

    @Override
    public void delete(Student data) {
        studentStorage.remove(data.getId());
    }

    @Override
    public void deleteAll() {
        studentStorage.clear();
        autoId.set(0);
    }
}