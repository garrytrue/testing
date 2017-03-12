package com.garrytrue;

import com.garrytrue.model.Student;

import java.util.HashMap;
import java.util.Map;

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

    public static Map<Long, Student> generateStudent(int count) {
        Map<Long, Student> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put((long) i, new Student(i, "FirstName " + i, "LastName " + i));
        }
        return map;
    }

}
