package com.ailot.factory.method;

import com.ailot.factory.AbstractCourseFactory;
import com.ailot.factory.vo.Course;
import com.ailot.factory.vo.JavaCourse;
import com.ailot.factory.vo.Note;
import com.ailot.factory.vo.Video;

/**
 * @author lt48615
 * @date 2019-03-07 21:54
 */
public class JavaCourseFactory extends AbstractCourseFactory {

    @Override
    protected Course createCourse() {
        return new JavaCourse();
    }

    @Override
    protected Video createVideo() {
        return null;
    }

    @Override
    protected Note createNote() {
        return null;
    }
}
