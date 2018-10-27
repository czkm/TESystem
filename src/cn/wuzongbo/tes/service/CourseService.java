package cn.wuzongbo.tes.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wuzongbo.tes.po.Course;
import cn.wuzongbo.tes.po.CourseExample;
import cn.wuzongbo.tes.po.Teacher;

/**
 * 课程Service
 * @author wy
 * desciption:
 * other:
 */
public interface CourseService {
	/**
	 * 查询所有的课程名
	 * @param courseExample
	 * @return
	 * @throws Exception
	 */
     public List<Course> selectCourseName(CourseExample courseExample) throws Exception;
     /**
      * 根据id查询课程的信息
      * @param id
      * @return
      * @throws Exception
      */
     public Course findCourseById(Integer id) throws Exception;
     /**
      * 向表中插入数据
      * @param course
      * @return
      * @throws Exception
      */
     public int insertCourse(Course course) throws Exception;
     /**
      * 根据课程ID删除课程
      * @param id
      * @return
      * @throws Exception
      */
     public int deleteById(Integer id) throws Exception;
     /**
      * 根据ID更新status
      * @param status
      * @return
      */
  //   public int updateStatusbyCourseId(Byte status);
     
    int updateByPrimaryKeySelective(Course record);
}
