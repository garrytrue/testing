package com.garrytrue.repository;

import com.garrytrue.TestUtils;
import com.garrytrue.model.Student;
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
        map = TestUtils.generateStudent(10);
        repository = new StudentRepository(map);
    }

    @After
    public void tearDown() throws Exception {
        repository = null;
    }

    @Test
    public void save() throws Exception {
        Student test = TestUtils.getStudent1();
        repository.save(test);
        map.get(test.getId());
        Assert.assertEquals(test, map.get(test.getId()));
    }

    @Test
    public void get() throws Exception {
        Student expected = TestUtils.getStudent1();
        map.put(expected.getId(), expected);
        Student actual = repository.get(expected.getId());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() throws Exception {
        Student expected = TestUtils.getStudent1();
        repository.update(expected);
        Student actual = map.get(expected.getId());
        Assert.assertEquals(expected, actual);
    }

}