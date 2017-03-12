package com.garrytrue.repository.impl;

import com.garrytrue.model.Student;
import com.garrytrue.repository.CRUDRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class StudentRESTRepository implements CRUDRepository<Student> {
    private final List<Student> restEmulator;
    private final AtomicLong autoId = new AtomicLong();

    public StudentRESTRepository(List<Student> list) {
        this.restEmulator = list;
        this.autoId.set(list.size());
    }

    @Override
    public Student save(Student data) {
        long id = autoId.incrementAndGet();
        data.setId(id);
        restEmulator.add(data);
        return data;
    }

    @Override
    public Student get(long id) {
        return restEmulator.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Student update(Student data) {
        return data;
    }

    @Override
    public void delete(Student data) {
        restEmulator.remove(data);
    }

    @Override
    public void deleteAll() {
        restEmulator.clear();
        autoId.set(0);
    }
}