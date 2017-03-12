package com.garrytrue;

import com.garrytrue.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by garrytrue on 12.03.17.
 */
public final class TestUtils {
    private TestUtils() {
        throw new AssertionError("Don't make instance");
    }

    public static Student createStudent(String firstName, String lastName) {
        Student student = new Student(firstName, lastName);
        return student;
    }

    public static Map<Long, Student> generateStudents(int count) {
        Map<Long, Student> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(Long.valueOf(i), createStudent("FirstName " + i, "LastName " + i));
        }
        return map;
    }

    public static List<Student> generateStudentList(int count) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Student student = createStudent("FirstName " + i, "LastName " + i);
            student.setId(i);
            list.add(student);
        }
        return list;
    }
}
