package com.ailot.factory;

import com.ailot.factory.method.JavaCourseFactory;
import com.ailot.factory.vo.Course;

/**
 * @author lt48615
 * @date 2019-03-07 21:55
 */
public class FacotryTest {

    static AbstractCourseFactory factory = new JavaCourseFactory();

    public static void main(String[] args) {

        factory.createCourse().study();
    }
}
