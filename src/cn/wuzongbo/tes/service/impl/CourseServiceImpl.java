package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.CourseMapper;
import cn.wuzongbo.tes.po.Course;
import cn.wuzongbo.tes.po.CourseExample;
import cn.wuzongbo.tes.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;
	
	
	
    /**
     * 查询所有的课程名
     */
	@Override
	public List<Course> selectCourseName(CourseExample courseExample)
			throws Exception {
		// TODO Auto-generated method stub
		return courseMapper.selectByExample(courseExample);
	}
    /**
     * 添加数据
     */
	@Override
	public int insertCourse(Course course) throws Exception {
		// TODO Auto-generated method stub
		return courseMapper.insert(course);
	}
    /**
     * 删除数据
     */
	@Override
	public int deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return courseMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Course findCourseById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(id);
	}
	/**
	 * 根据id更新状态值
	 */
	/*@Override
	public int updateStatusbyCourseId(Byte status) {
		// TODO Auto-generated method stub
		return courseMapper.updateStatusbyCourseId(status);
	}*/
	@Override
	public int updateByPrimaryKeySelective(Course record) {
		// TODO Auto-generated method stub
		return courseMapper.updateByPrimaryKeySelective(record);
	}
	
	
	
	

}
