package com.garrytrue;

import com.garrytrue.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by garrytrue on 12.03.17.
 */
public final class TestUtils {
    private TestUtils() {
        throw new AssertionError("Don't make instance");
    }

    public static Student getStudent1() {
        return new Student(1, "One", "One");
    }

    public static List<Student> generateStudent(int count) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Student(i, "FirstName " + i, "LastName " + i));
        }
        return list;
    }

}
