package com.garrytrue.repository;

import com.garrytrue.TestUtils;
import com.garrytrue.model.Student;
import com.garrytrue.repository.impl.StudentInMemoryRepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;

/**
 * Created by garrytrue on 12.03.17.
 */
@RunWith(JUnit4.class)
public class StudentRepositoryTest {
    private CRUDRepository<Student> repository;
    private Map<Long, Student> map;

    @Before
    public void setUp() throws Exception {
        map = TestUtils.generateStudents(10);
        repository = new StudentInMemoryRepository(map);
    }

    @After
    public void tearDown() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void save() throws Exception {
//        Student actual = TestUtils.createStudent();
//        Student expected = repository.save(actual);
//        Assert.assertEquals(actual.getFirstName(), expected.getFirstName());
//        Assert.assertEquals(actual.getSecondName(), expected.getSecondName());
    }

    @Test
    public void get() throws Exception {
        long loadedStudentId = 1L;
        Student expected = new Student("FirstName 1", "LastName 1");
        Assert.assertEquals(expected, repository.get(loadedStudentId));
    }

    @Test
    public void update() throws Exception {
//        Student test = TestUtils.createStudent();
//        Student expected = repository.update(test);
//        Student actual = repository.get(expected.getId());
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Student test = TestUtils.createStudent(",", "");
        repository.delete(test);
        Student actual = repository.get(test.getId());
        Assert.assertNull(actual);
    }

    @Test
    public void deleteAll() {
        repository.deleteAll();
        Student test = TestUtils.createStudent("", "");
        Student actual = repository.get(test.getId());
        Assert.assertNull(actual);


    }
}