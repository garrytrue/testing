package com.garrytrue.repository;


import com.garrytrue.model.Student;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by garrytrue on 12.03.17.
 */
public class StudentInMemoryRepository extends AbstractRepository {
    private final Map<Long, Student> inMemory;
    private final AtomicLong atomicLong = new AtomicLong(0);

    public StudentInMemoryRepository(Map<Long, Student> inMemory, CRUDRepository<Student> sucessor) {
        super(sucessor);
        this.inMemory = inMemory;
    }


    @Override
    public Student save(Student data) {
        long id = atomicLong.incrementAndGet();
        data.setId(id);
        inMemory.put(id, data);
        if (hasSuccesor()) {
            getSuccesor().save(data);
        }
        return data;
    }

    @Override
    public Student get(long id) {
        Student student = inMemory.get(id);
        return student != null ? student : hasSuccesor() ? getSuccesor().get(id) : null;
    }

    @Override
    public Student update(Student data) {
        inMemory.replace(data.getId(), data);
        return data;
    }

    @Override
    public void delete(Student data) {
        inMemory.remove(data.getId());
        if (hasSuccesor()) {
            getSuccesor().delete(data);
        }
    }

    @Override
    public void deleteAll() {
        inMemory.clear();
        atomicLong.getAndSet(0);
        if (hasSuccesor()) {
            getSuccesor().deleteAll();
        }
    }


}
