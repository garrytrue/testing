package com.garrytrue;

import com.garrytrue.model.Student;
import com.garrytrue.repository.impl.ChainedRepository;
import com.garrytrue.repository.impl.StudentInMemoryRepository;
import com.garrytrue.repository.impl.StudentRESTRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        HashMap<Long, Student> storage = new HashMap<>();
        List<Student> restStorage = new ArrayList<>();
        ChainedRepository<Student> restLayer = new ChainedRepository(new StudentRESTRepository(restStorage));
        ChainedRepository<Student> inmemoryLayer = new ChainedRepository<>(new StudentInMemoryRepository(storage));
        inmemoryLayer.setNextLayerRepository(restLayer);
    }
}