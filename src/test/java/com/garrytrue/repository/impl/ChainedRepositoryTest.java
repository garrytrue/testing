package com.garrytrue.repository.impl;

import com.garrytrue.TestUtils;
import com.garrytrue.model.Student;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ChainedRepositoryTest {

    private ChainedRepository<Student> chainedRepository;

    @Before
    public void init() {
        ChainedRepository<Student> restLayer = new ChainedRepository(
                new StudentRESTRepository(TestUtils.generateStudentList(10)));
        ChainedRepository<Student> inmemoryLayer = new ChainedRepository(
                new StudentInMemoryRepository(TestUtils.generateStudents(3)));
        inmemoryLayer.setNextLayerRepository(restLayer);
        chainedRepository = inmemoryLayer;
    }

    @Test
    public void get_inmemoryPresent() throws Exception {
        Student expected = TestUtils.createStudent("FirstName 1", "LastName 1");
        Student actual = chainedRepository.get(1L);
        assertEquals(expected, actual);
    }

    @Test
    public void get_restPresent() throws Exception {
        Student expected = TestUtils.createStudent("FirstName 5", "LastName 5");
        Student actual = chainedRepository.get(5L);
        assertEquals(expected, actual);
    }

}