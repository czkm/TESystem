package cn.wuzongbo.tes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wuzongbo.tes.mapper.ClassCourseMapper;
import cn.wuzongbo.tes.po.ClassCourse;
import cn.wuzongbo.tes.po.ClassCourseExample;
import cn.wuzongbo.tes.po.ClassCourseVo;
import cn.wuzongbo.tes.po.ClasscourseAndCourse;
import cn.wuzongbo.tes.service.ClassCourseService;


/**
 * @author ������
 * NO�� 35
 *2018��8��6��
 */
@Service
public class ClassCourseServiceImpl implements ClassCourseService {
	@Autowired
	private ClassCourseMapper classCourseMapper;

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#countByExample(cn.wuzongbo.tes.po.ClassCourseExample)
	 */
	@Override
	public long countByExample(ClassCourseExample example) {
		// TODO Auto-generated method stub
		return classCourseMapper.countByExample(example);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#deleteByExample(cn.wuzongbo.tes.po.ClassCourseExample)
	 */
	@Override
	public int deleteByExample(ClassCourseExample example) {
		// TODO Auto-generated method stub
		return classCourseMapper.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return classCourseMapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#insert(cn.wuzongbo.tes.po.ClassCourse)
	 */
	@Override
	public int insert(ClassCourse record) {
		// TODO Auto-generated method stub
		return classCourseMapper.insert(record);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#insertSelective(cn.wuzongbo.tes.po.ClassCourse)
	 */
	@Override
	public int insertSelective(ClassCourse record) {
		// TODO Auto-generated method stub
		return classCourseMapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#selectByExample(cn.wuzongbo.tes.po.ClassCourseExample)
	 */
	@Override
	public List<ClassCourse> selectByExample(ClassCourseExample example) {
		// TODO Auto-generated method stub
		return classCourseMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public ClassCourse selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return classCourseMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#updateByExampleSelective(cn.wuzongbo.tes.po.ClassCourse, cn.wuzongbo.tes.po.ClassCourseExample)
	 */
	@Override
	public int updateByExampleSelective(ClassCourse record, ClassCourseExample example) {
		// TODO Auto-generated method stub
		return classCourseMapper.updateByExampleSelective(record, example);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#updateByExample(cn.wuzongbo.tes.po.ClassCourse, cn.wuzongbo.tes.po.ClassCourseExample)
	 */
	@Override
	public int updateByExample(ClassCourse record, ClassCourseExample example) {
		// TODO Auto-generated method stub
		return classCourseMapper.updateByExample(record, example);
	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#updateByPrimaryKeySelective(cn.wuzongbo.tes.po.ClassCourse)
	 */
	@Override
	public int updateByPrimaryKeySelective(ClassCourse record) {
		// TODO Auto-generated method stub
		return classCourseMapper.updateByPrimaryKeySelective(record);
	}

	/* 
	 * @see cn.wuzongbo.tes.service.ClassCourseService#updateByPrimaryKey(cn.wuzongbo.tes.po.ClassCourse)
	 */
	@Override
	public int updateByPrimaryKey(ClassCourse record) {
		// TODO Auto-generated method stub
		return classCourseMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<ClassCourseVo> selectOtherNamefromOtherTable() throws Exception {
		// TODO Auto-generated method stub
		return classCourseMapper.selectOtherNamefromOtherTable();
	}

	@Override
	public List<ClassCourseVo> selectcourseNamefromcourseByclasscourse()
			throws Exception {
		// TODO Auto-generated method stub
		return classCourseMapper.selectcourseNamefromcourseByclasscourse();
	}

										
	//根据班级名称进行模糊查询
	@Override
	public List<ClassCourseVo> selectOtherNamefromOtherTablename(String name) {
		return classCourseMapper.selectOtherNamefromOtherTablename(name);

	}

	/* (non-Javadoc)
	 * @see cn.wuzongbo.tes.service.ClassCourseService#changStatue(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public int changStatue(ClassCourseVo classCourseVo){ 	
		return classCourseMapper.updateByPrimaryKeySelective(classCourseVo);
	}
			
	//根据weekDay来获取当天的课程
	@Override
	public List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday1(Integer userclassesid)
			throws Exception {
		// TODO Auto-generated method stub
		return classCourseMapper.selectclasscourseANDcourseByweekday1(userclassesid);
	}
	@Override
	public List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday2(Integer userclassesid)
			throws Exception {
		// TODO Auto-generated method stub
		return classCourseMapper.selectclasscourseANDcourseByweekday2(userclassesid);
	}

	@Override
	public List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday3(Integer userclassesid)
			throws Exception {
		// TODO Auto-generated method stub
		return classCourseMapper.selectclasscourseANDcourseByweekday3(userclassesid);
	}

	@Override
	public List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday4(Integer userclassesid)
			throws Exception {
		// TODO Auto-generated method stub
		return classCourseMapper.selectclasscourseANDcourseByweekday4(userclassesid);
	}

	@Override
	public List<ClasscourseAndCourse> selectclasscourseANDcourseByweekday5(Integer userclassesid)
			throws Exception {
		// TODO Auto-generated method stub
		return classCourseMapper.selectclasscourseANDcourseByweekday5(userclassesid);
	}
    				
}

	