package com.garrytrue.repository;

import com.garrytrue.TestUtils;
import com.garrytrue.fakedata.FakeStorage;
import com.garrytrue.model.Student;
import com.garrytrue.storage.IStorage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by garrytrue on 12.03.17.
 */
@RunWith(JUnit4.class)
public class StudentRepositoryTest {
    private IStorage<Student> testStorage;
    private CRUDRepository<Student> repository;

    @Before
    public void setUp() throws Exception {
        testStorage = new FakeStorage();
        repository = new StudentRepository(testStorage);
    }

    @After
    public void tearDown() throws Exception {
        testStorage = null;
        repository = null;
    }

    @Test
    public void save() throws Exception {
        Student test = TestUtils.getStudent1();
        repository.save(test);
        testStorage.getById(test.getId());
        Assert.assertEquals(test, testStorage.getById(test.getId()));
    }

    @Test
    public void get() throws Exception {
        Student expected = TestUtils.getStudent1();
        testStorage.save(expected);
        Student actual = repository.get(expected.getId());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void update() throws Exception {
        Student expected = TestUtils.getStudent1();
        repository.update(expected);
        Student actual = testStorage.getById(expected.getId());
        Assert.assertEquals(expected, actual);
    }

}