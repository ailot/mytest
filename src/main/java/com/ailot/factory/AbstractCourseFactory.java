package com.ailot.factory;

import com.ailot.factory.vo.Course;
import com.ailot.factory.vo.Note;
import com.ailot.factory.vo.Video;

/**
 * @author lt48615
 * @date 2019-03-07 21:46
 */
public abstract class AbstractCourseFactory {

    protected abstract Course createCourse();

    protected abstract Video createVideo();

    protected abstract Note createNote();


}
