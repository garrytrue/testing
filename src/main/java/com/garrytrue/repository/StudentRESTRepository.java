package com.garrytrue.repository;

import com.garrytrue.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by garrytrue on 12.03.17.
 */
public class StudentRESTRepository extends AbstractRepository {
    private final List<Student> list = new ArrayList<>();
    private final AtomicLong atomicLong = new AtomicLong();

    public StudentRESTRepository(CRUDRepository<Student> succesor) {
        super(succesor);
    }

    @Override
    public Student save(Student data) {
        long id = atomicLong.incrementAndGet();
        data.setId(id);
        list.add(data);
        return data;
    }

    @Override
    public Student get(long id) {
        return list.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Student update(Student data) {
        return data;
    }

    @Override
    public void delete(Student data) {
        list.remove(data);
    }

    @Override
    public void deleteAll() {
        list.clear();
    }
}
