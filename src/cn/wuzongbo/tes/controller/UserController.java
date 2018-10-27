package cn.wuzongbo.tes.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.ListUtils;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;












import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;












import cn.wuzongbo.tes.po.AdviserClasses;
import cn.wuzongbo.tes.po.AdviserClassesExample;
import cn.wuzongbo.tes.po.Assess;
import cn.wuzongbo.tes.po.AssessClasses;
import cn.wuzongbo.tes.po.AssessClassesExample;
import cn.wuzongbo.tes.po.AssessExample;
import cn.wuzongbo.tes.po.ClassCourseVo;
import cn.wuzongbo.tes.po.ClasscourseAndCourse;
import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.ClassesAndUserVo;
import cn.wuzongbo.tes.po.Config;
import cn.wuzongbo.tes.po.ConfigExample;
import cn.wuzongbo.tes.po.CriteriaClasses;
import cn.wuzongbo.tes.po.CriteriaClassesExample;
import cn.wuzongbo.tes.po.CriteriaVo;
import cn.wuzongbo.tes.po.Department;
import cn.wuzongbo.tes.po.DepartmentAndClassesVo;
import cn.wuzongbo.tes.po.DepartmentExample;
import cn.wuzongbo.tes.po.QueryAllClassesGetScoreVO;
import cn.wuzongbo.tes.po.QueryAllTeacherGetScoreVO;
import cn.wuzongbo.tes.po.QueryClassesGetScoreVO;
import cn.wuzongbo.tes.po.QueryTeacherGetScoreVO;
import cn.wuzongbo.tes.po.Recruit;
import cn.wuzongbo.tes.po.RecruitExample;
import cn.wuzongbo.tes.po.Scholarship;
import cn.wuzongbo.tes.po.ScholarshipExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.StudentAndClasssesAndDepart;
import cn.wuzongbo.tes.po.UserClasses;
import cn.wuzongbo.tes.po.UserClassesExample;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.po.Usersign;
import cn.wuzongbo.tes.service.AdviserClassesService;
import cn.wuzongbo.tes.service.AssessClassesService;
import cn.wuzongbo.tes.service.AssessService;
import cn.wuzongbo.tes.service.ClassCourseService;
import cn.wuzongbo.tes.service.ClassesService;
import cn.wuzongbo.tes.service.ConfigService;
import cn.wuzongbo.tes.service.CriteriaClassesService;
import cn.wuzongbo.tes.service.CriteriaService;
import cn.wuzongbo.tes.service.DepartmentService;
import cn.wuzongbo.tes.service.RecruitService;
import cn.wuzongbo.tes.service.ScholarshipService;
import cn.wuzongbo.tes.service.UserClassesService;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.service.UsersignService;
import cn.wuzongbo.tes.util.DateUtil;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private ClassesService classesService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UserClassesService userClassesService;
	
	@Autowired
	private AdviserClassesService adviserClassesService;
	@Autowired
	private UserService userService;

	@Autowired
	private CriteriaService criteriaService;
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private AssessService assessService;
	
	
	@Autowired
	private CriteriaClassesService criteriaClassesService;
	
	@Autowired
	private AssessClassesService assessClassesService;
	
	@Autowired
	private ScholarshipService scholarshipService;
    
	@Autowired
	private ClassCourseService classCourseService;
	
	@Autowired
	private RecruitService recruitService;
	
	@Autowired
	private UsersignService usersignService;
	
    /**
     * 
    
     * <p>Title: toset</p>  
    
     * <p>Description:锟矫伙拷锟斤拷锟斤拷页锟斤拷 </p>  
    
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
	@RequestMapping("/toset")
	public String toset(Model model, HttpSession session) throws Exception {
		StudentAndClasssesAndDepart userAndClasssesAndDepart = new StudentAndClasssesAndDepart();
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			Classes classes = classesService.findClassesById(user.getClassesid());
			Department department = departmentService.findDepartmentById(user.getDepartid());
			userAndClasssesAndDepart.setClasses(classes);
			BeanUtils.copyProperties(user, userAndClasssesAndDepart);
			userAndClasssesAndDepart.setDepartment(department);

			model.addAttribute("user", userAndClasssesAndDepart);
			if(user.getType()==5){
				ConfigExample configExample=new ConfigExample();
				ConfigExample.Criteria configCriteria=configExample.createCriteria();
				configCriteria.andIncTypeEqualTo("scholarship");
			    List<Config> configs=configService.queryConfigList(configExample);
			
			model.addAttribute("configs", configs);
				
			}
			
			return "default/layui/user/set";
		} else {

			return "default/layui/user/login";
		}

	}
    /**
     * 
    
     * <p>Title: toUser</p>  
    
     * <p>Description:锟矫伙拷锟斤拷锟斤拷 </p>  
    
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping("/touser")
	public String toUser(HttpSession session,Model model) throws Exception {
		
		 
		
		if(session!=null){
			User user = (User) session.getAttribute("user");
			
			if(user.getType()==5){
				ScholarshipExample scholarshipExample=new ScholarshipExample();
			
				scholarshipExample.setOrderByClause("createtime desc");
				List<Scholarship> scholarships=scholarshipService.query(scholarshipExample);
				
				model.addAttribute("scholarships", scholarships);
				
				//锟斤拷锟斤拷录取锟斤拷锟斤拷
				
				
				RecruitExample recruitExample=new RecruitExample();
				RecruitExample.Criteria recruitCriteria=recruitExample.createCriteria();
				
			     List<Recruit> recruits=	recruitService.query(null);
			   
			     model.addAttribute("recruits", recruits);
				
				
				return "default/layui/enrol/index";
				
			}
			if(user.getType()==6){
				
				return "forward:toassessresult";
			}
			
			List<QueryTeacherGetScoreVO> queryTeacherGetScoreVOs=getTeacherGetScoreList(session);
			if(queryTeacherGetScoreVOs!=null&&queryTeacherGetScoreVOs.size()>0){
				
				model.addAttribute("queryTeacherGetScoreVOs", queryTeacherGetScoreVOs);
				
				
			}
			
			List<QueryClassesGetScoreVO> classesGetScoreVOs=classesService.selectQueryClassesGetScoreByTeacherId(user.getId());
			
			if(classesGetScoreVOs!=null&&classesGetScoreVOs.size()>0){
				
				model.addAttribute("classesGetScoreVOs", classesGetScoreVOs);
			}
			return "default/layui/user/index";
		}
		else{
			
			return "default/layui/user/login";
		}
		
	}
	@RequestMapping("/toassessresult")
	public String toAssessResult(Model model) throws Exception{
		
		//锟斤拷取锟斤拷锟斤拷锟斤拷师锟斤拷锟斤拷锟斤拷
		
		List<QueryAllTeacherGetScoreVO> allTeacherGetScoreVOs=userService.selectTeacherGetAllAssessScorce();
		model.addAttribute("allTeacherGetScoreVOs", allTeacherGetScoreVOs);
		model.addAttribute("teacherCount", allTeacherGetScoreVOs.size());
		
		 //锟斤拷取锟斤拷锟酵ｏ拷学院锟侥诧拷锟斤拷
	     DepartmentExample departmentExample=new DepartmentExample();
	     DepartmentExample.Criteria departCriteria=departmentExample.createCriteria();
	     departCriteria.andTypeEqualTo("学院");
	     
	    List<Department> departments=departmentService.queryDepartmentList(departmentExample);
		model.addAttribute("departments", departments);
		
		
		//锟斤拷取锟斤拷锟叫班级锟斤拷学锟缴硷拷
		
		List<QueryAllClassesGetScoreVO> allClassesGetScoreVOs=classesService.selectAllScoreofClasses();
		model.addAttribute("allClassesGetScoreVOs", allClassesGetScoreVOs);
		model.addAttribute("classesCount", allClassesGetScoreVOs.size());
		
		
		//锟斤拷师锟斤拷锟斤拷锟斤拷锟斤拷
		List<QueryAllTeacherGetScoreVO> betweenTeacherGetScoreVOs=userService.selectBetweenTeacherScore();
		model.addAttribute("betweenTeacherGetScoreVOs", betweenTeacherGetScoreVOs);
		model.addAttribute("betweenTeacherCount", betweenTeacherGetScoreVOs.size());
		
		return "default/layui/user/assess_result";
		
	}
	@RequestMapping(value = "/scoreofteacherbydepartBar", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getScoreOfTeacherByDepart(@RequestParam(required=true,defaultValue="1") int departId) throws Exception{
				
		List<QueryTeacherGetScoreVO> getScoreVOs=assessService.getTeatcherScoreByDepart(departId);
		
		if(getScoreVOs.size()>0){
			//锟斤拷锟斤拷锟角诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷  1.锟斤拷锟斤拷   2.x锟斤拷锟斤拷锟斤拷路锟斤拷  3.路锟斤拷锟斤拷锟斤拷
	        //锟斤拷锟斤拷
			String title="锟斤拷师锟斤拷锟斤拷锟斤拷锟�";
//			锟斤拷师锟斤拷锟斤拷
			String[] teacherNames=new String[getScoreVOs.size()];;
			//锟斤拷锟斤拷锟斤拷锟斤拷
			double[] scores=new double[getScoreVOs.size()];
			
			 //####锟斤拷始锟斤拷锟斤拷option锟斤拷锟斤拷 ######
	        //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷虻サ牟锟斤拷锟斤拷锟斤拷锟斤拷锟� 锟斤拷锟斤拷锟斤拷染锟斤拷锟斤拷锟斤拷 锟斤拷铱锟斤拷锟斤拷锟斤拷私锟街拷锟斤拷锟斤拷胁锟斤拷锟绞癸拷锟�
	        //1.锟斤拷锟斤拷option锟斤拷锟斤拷    锟斤拷锟斤拷锟街凤拷式 一锟斤拷锟斤拷直锟接达拷锟斤拷option锟斤拷锟斤拷锟节凤拷装锟斤拷option之锟斤拷要使锟斤拷json转锟斤拷锟斤拷锟竭斤拷锟叫革拷式锟斤拷转锟斤拷
	        //锟斤拷锟斤拷使锟矫第讹拷锟街凤拷式直锟接癸拷锟斤拷GsonOption 通锟斤拷toString锟斤拷锟斤拷锟斤拷转锟斤拷锟斤拷json
			for(int i=0;i<getScoreVOs.size();i++){
				
				teacherNames[i]=getScoreVOs.get(i).getTeacherName();
				
				scores[i]=getScoreVOs.get(i).getScore();
			}
			
			Option option=new GsonOption();
			  //2.锟斤拷锟矫憋拷锟斤拷  锟斤拷选
	        option.title().text(title).x("left");//锟斤拷锟斤拷锟解传锟诫即锟斤拷 锟斤拷锟斤拷支锟斤拷锟斤拷式锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷示位锟斤拷 锟斤拷锟斤拷

	        //3.锟斤拷锟斤拷图锟斤拷  锟斤拷选
	        option.legend("路锟斤拷锟斤拷锟斤拷");
	        //4.锟斤拷锟矫癸拷锟斤拷锟斤拷  锟斤拷选
	        option.toolbox().show(true).feature(Tool.mark,
	                Tool.magicType); //锟斤拷锟矫可憋拷锟�

	        //5.锟斤拷锟斤拷锟斤拷示锟斤拷锟斤拷
	        option.tooltip().show(true).
	                formatter("{a}</br>{b}:{c}");//锟斤拷锟斤拷锟斤拷示锟侥革拷式 锟斤拷锟斤拷锟脚碉拷锟斤拷状图锟斤拷时锟斤拷锟斤拷示锟斤拷式
	      //6.锟斤拷锟斤拷x锟斤拷锟斤拷锟斤拷
			CategoryAxis categoryAxis =new CategoryAxis();
			
			categoryAxis.data(teacherNames);
			option.xAxis(categoryAxis);
			
			 //7.锟斤拷锟斤拷y锟斤拷 锟斤拷锟斤不锟斤拷指锟斤拷锟斤拷锟斤拷  锟皆讹拷锟斤拷锟斤拷
			
			ValueAxis valueAxis=new ValueAxis();
			option.yAxis(valueAxis);
			
			  //8.锟斤拷锟斤拷锟阶赐硷拷锟斤拷锟�
			
			Bar bar=new Bar();
			
			bar.name("锟斤拷师锟斤拷锟斤拷锟斤拷锟斤拷");
			for(int i=0;i<teacherNames.length;i++){
				Map<String,Object> map = new HashMap<>();
				
				map.put("value", scores[i]);
				map.put("name", teacherNames[i]);
				bar.data(map);
			}
			 //装锟斤拷锟斤拷锟捷憋拷锟斤拷
	        option.series(bar);
	        //option锟斤拷锟斤拷json锟斤拷式锟斤拷锟斤拷
	        String result = option.toString();
	     
//			
	       return 	result;
		}
		
		else{
			
		
			//return null;
			return "-1";
		}       
		
		
	}
	@RequestMapping(value = "/teacherGetScoreBar", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String teacherGetScoreBar(HttpSession session) throws Exception{
		Status status=null;
		List<QueryTeacherGetScoreVO> queryTeacherGetScoreVOs=getTeacherGetScoreList(session);
		
		if(queryTeacherGetScoreVOs.size()>0){
			//锟斤拷锟斤拷锟角诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷  1.锟斤拷锟斤拷   2.x锟斤拷锟斤拷锟斤拷路锟斤拷  3.路锟斤拷锟斤拷锟斤拷
	        //锟斤拷锟斤拷
			String title="锟斤拷师锟斤拷锟斤拷锟斤拷锟�";
//			锟斤拷师锟斤拷锟斤拷
			String[] teacherNames=new String[queryTeacherGetScoreVOs.size()];;
			//锟斤拷锟斤拷锟斤拷锟斤拷
			double[] scores=new double[queryTeacherGetScoreVOs.size()];
			
			 //####锟斤拷始锟斤拷锟斤拷option锟斤拷锟斤拷 ######
	        //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷虻サ牟锟斤拷锟斤拷锟斤拷锟斤拷锟� 锟斤拷锟斤拷锟斤拷染锟斤拷锟斤拷锟斤拷 锟斤拷铱锟斤拷锟斤拷锟斤拷私锟街拷锟斤拷锟斤拷胁锟斤拷锟绞癸拷锟�
	        //1.锟斤拷锟斤拷option锟斤拷锟斤拷    锟斤拷锟斤拷锟街凤拷式 一锟斤拷锟斤拷直锟接达拷锟斤拷option锟斤拷锟斤拷锟节凤拷装锟斤拷option之锟斤拷要使锟斤拷json转锟斤拷锟斤拷锟竭斤拷锟叫革拷式锟斤拷转锟斤拷
	        //锟斤拷锟斤拷使锟矫第讹拷锟街凤拷式直锟接癸拷锟斤拷GsonOption 通锟斤拷toString锟斤拷锟斤拷锟斤拷转锟斤拷锟斤拷json
			for(int i=0;i<queryTeacherGetScoreVOs.size();i++){
				
				teacherNames[i]=queryTeacherGetScoreVOs.get(i).getTeacherName();
				
				scores[i]=queryTeacherGetScoreVOs.get(i).getScore();
			}
			
			Option option=new GsonOption();
			  //2.锟斤拷锟矫憋拷锟斤拷  锟斤拷选
	        option.title().text(title).x("left");//锟斤拷锟斤拷锟解传锟诫即锟斤拷 锟斤拷锟斤拷支锟斤拷锟斤拷式锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷示位锟斤拷 锟斤拷锟斤拷

	        //3.锟斤拷锟斤拷图锟斤拷  锟斤拷选
	        option.legend("路锟斤拷锟斤拷锟斤拷");
	        //4.锟斤拷锟矫癸拷锟斤拷锟斤拷  锟斤拷选
	        option.toolbox().show(true).feature(Tool.mark,
	                Tool.magicType); //锟斤拷锟矫可憋拷锟�

	        //5.锟斤拷锟斤拷锟斤拷示锟斤拷锟斤拷
	        option.tooltip().show(true).
	                formatter("{a}</br>{b}:{c}");//锟斤拷锟斤拷锟斤拷示锟侥革拷式 锟斤拷锟斤拷锟脚碉拷锟斤拷状图锟斤拷时锟斤拷锟斤拷示锟斤拷式
	      //6.锟斤拷锟斤拷x锟斤拷锟斤拷锟斤拷
			CategoryAxis categoryAxis =new CategoryAxis();
			
			categoryAxis.data(teacherNames);
			option.xAxis(categoryAxis);
			
			 //7.锟斤拷锟斤拷y锟斤拷 锟斤拷锟斤不锟斤拷指锟斤拷锟斤拷锟斤拷  锟皆讹拷锟斤拷锟斤拷
			
			ValueAxis valueAxis=new ValueAxis();
			option.yAxis(valueAxis);
			
			  //8.锟斤拷锟斤拷锟阶赐硷拷锟斤拷锟�
			
			Bar bar=new Bar();
			
			bar.name("锟斤拷师锟斤拷锟斤拷锟斤拷锟斤拷");
			for(int i=0;i<teacherNames.length;i++){
				Map<String,Object> map = new HashMap<>();
				
				map.put("value", scores[i]);
				map.put("name", teacherNames[i]);
				bar.data(map);
			}
			 //装锟斤拷锟斤拷锟捷憋拷锟斤拷
	        option.series(bar);
	        //option锟斤拷锟斤拷json锟斤拷式锟斤拷锟斤拷
	        String result = option.toString();
	     
//			
	       return 	result;
		}
		
		else{
			
		
			//return null;
			return "-1";
		}       
		
	}
   private List<QueryTeacherGetScoreVO> getTeacherGetScoreList(HttpSession session) throws Exception{
	   
	   User user = (User) session.getAttribute("user");
		List<User> teachers = null;
		List<QueryTeacherGetScoreVO> queryTeacherGetScoreVOs=new ArrayList<QueryTeacherGetScoreVO>();
		QueryTeacherGetScoreVO queryTeacherGetScoreVO=null;
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		if(user.getClassesid()!=null&&user.getClassesid()>0){
			teachers = userClassesService.queryUserListByClassesId(user.getClassesid());
			if(teachers!=null&&teachers.size()>0){
				queryTeacherGetScoreVO=new QueryTeacherGetScoreVO();
				for(User teacher:teachers){
					queryTeacherGetScoreVO=new QueryTeacherGetScoreVO();
				  AssessExample assessExample=new AssessExample();
				  
				  AssessExample.Criteria assesssCriteria=assessExample.createCriteria();
				  
				  assesssCriteria.andTargetTeacherEqualTo(teacher.getId());
				  assesssCriteria.andUseridEqualTo(user.getId());
				  Assess assess=assessService.findAssess(assessExample);
				  if(assess!=null){
					  queryTeacherGetScoreVO.setTeacherId(teacher.getId());	
					  queryTeacherGetScoreVO.setTeacherName(teacher.getUsername());
					  queryTeacherGetScoreVO.setUserId(user.getId());
					  queryTeacherGetScoreVO.setScore(assess.getScorce());
					  queryTeacherGetScoreVO.setCreateTime(assess.getCreatetime());
					  queryTeacherGetScoreVOs.add(queryTeacherGetScoreVO);	  
					  
				  }
				
				}
				
				
			}
			
			
			
		}
		if(user.getType()==2||user.getType()==24){
			criteria.andDepartidEqualTo(user.getDepartid());
			List<Byte> types=new ArrayList<>();
			types.add((byte)24);
			types.add((byte)2);
			criteria.andTypeIn(types);
			List<User> teacherList=userService.queryUserList(userExample);
			
			for(User teacher:teacherList){
				queryTeacherGetScoreVO=new QueryTeacherGetScoreVO();
			  AssessExample assessExample=new AssessExample();
			  
			  AssessExample.Criteria assesssCriteria=assessExample.createCriteria();
			  
			  assesssCriteria.andTargetTeacherEqualTo(teacher.getId());
			  assesssCriteria.andUseridEqualTo(user.getId());
			  Assess assess=assessService.findAssess(assessExample);
			  if(assess!=null){
				  queryTeacherGetScoreVO.setTeacherId(teacher.getId());	
				  queryTeacherGetScoreVO.setTeacherName(teacher.getUsername());
				  queryTeacherGetScoreVO.setUserId(user.getId());
				  queryTeacherGetScoreVO.setScore(assess.getScorce());
				  queryTeacherGetScoreVO.setCreateTime(assess.getCreatetime());
				  queryTeacherGetScoreVOs.add(queryTeacherGetScoreVO);	  
				  
			  }
			
			}
			
			
		}
		if(user.getType()==3){
			AssessExample assessExample=new AssessExample();
			AssessExample.Criteria assessCriteria=assessExample.createCriteria();
			assessCriteria.andUseridEqualTo(user.getId());
			List<Assess> assesses=assessService.selectAssessesByUserId(assessExample);
			
			if(assesses!=null&&assesses.size()>0){
				for(Assess assess:assesses){
					
					User assessUser =userService.findUserById(assess.getTargetTeacher());
					
					queryTeacherGetScoreVO=new QueryTeacherGetScoreVO();
					
					 queryTeacherGetScoreVO.setTeacherId(assess.getTargetTeacher());	
					  queryTeacherGetScoreVO.setTeacherName(assessUser.getUsername());
					  queryTeacherGetScoreVO.setUserId(assessUser.getId());
					  queryTeacherGetScoreVO.setScore(assess.getScorce());
					  queryTeacherGetScoreVO.setCreateTime(assess.getCreatetime());
					  queryTeacherGetScoreVOs.add(queryTeacherGetScoreVO);	
					
					
				}
				
			}
			
			
			
			
			
		}
	   return queryTeacherGetScoreVOs;
	   
   }
	@RequestMapping(value = "/changepassword", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changepassword(HttpSession session, String nowpassword, String newpassword) throws Exception {
		Status status = null;
		User user = (User) session.getAttribute("user");
		if(user!=null){
			int result = userService.changePassword(newpassword, nowpassword, user.getId());
			if (result== 1) {
				status = new Status();
				status.setStatusCode(1);
				status.setMessage("锟斤拷锟斤拷锟睫改成癸拷");

			}
			else if(result== 0){
				
				status.setStatusCode(0);
				status.setMessage("原始锟斤拷锟诫不锟斤拷确");
			}
			else {

				status = new Status();
				status.setStatusCode(-1);
				status.setMessage("锟斤拷锟斤拷锟睫革拷失锟斤拷");

			}
			
		}
		else{
			
			status = new Status();
			status.setStatusCode(2);
			status.setMessage("锟矫伙拷锟斤拷锟饺碉拷陆锟斤拷锟斤拷锟斤拷");
		}
		

		return JacksonUtil.bean2Json(status);
	}
   /**
    * 
   
    * <p>Title: touserlist</p>  
   
    * <p>Description:学锟斤拷锟斤拷锟节班级锟斤拷锟斤拷 锟节匡拷锟斤拷师锟斤拷页锟斤拷
    *     
    * </p>  
   
    * @param session
    * @param model
    * @return
    * @throws Exception
    */
	@RequestMapping(value = "/touserlist")
	public String touserlist(HttpSession session, Model model) throws Exception {

		Status status = null;
		List<User> teachers = null;
		User user = (User) session.getAttribute("user");
		if (user != null) {
			UserExample userExample = new UserExample();
			UserExample.Criteria criteria = userExample.createCriteria();
			if (user.getClassesid() != null && user.getClassesid() > 0) {
                //锟叫讹拷去锟斤拷锟窖撅拷锟斤拷值慕锟绞�
				List<Integer> teacherIds=assessService.getTeacherIdByUserId(user.getId());
				
				teachers = userClassesService.queryUserListByClassesId(user.getClassesid());
				if(teachers!=null&&teachers.size()>0){
					
					  for(int i=0;i<teachers.size();i++){
					    	
					    	if(teacherIds.contains(teachers.get(i).getId())){
					    		
					    		teachers.remove(i);
					    		i--;
					    	}
					    	
					    }
					
				}
			  
				

			}
		
			if (user.getType() == 2||user.getType()==24) {
				//锟叫讹拷去锟斤拷锟窖撅拷锟斤拷值慕锟绞�
				List<Byte> types=new ArrayList<>();
				types.add((byte)24);
				types.add((byte)2);
				List<Integer> teacherIds=assessService.getTeacherIdByUserId(user.getId());
				
				criteria.andDepartidEqualTo(user.getDepartid());
				criteria.andTypeIn(types);
				criteria.andStatusEqualTo((byte)1);
				criteria.andIdNotEqualTo(user.getId());
				if(teacherIds!=null&&teacherIds.size()>0){
					criteria.andIdNotIn(teacherIds);
				}
				

				teachers = userService.queryUserList(userExample);

			}
			if(user.getType() == 3){
				//锟叫讹拷去锟斤拷锟窖撅拷锟斤拷值慕锟绞�
				List<Integer> teacherIds=assessService.getTeacherIdByUserId(user.getId());
				criteria.andTypeEqualTo((byte)2);
				criteria.andStatusEqualTo((byte)1);
				if(teacherIds!=null&&teacherIds.size()>0){
					criteria.andIdNotIn(teacherIds);
				}
				teachers = userService.queryUserList(userExample);
			}
			
			model.addAttribute("teachers", teachers);

			return "default/layui/user/userlist";
		} else {

			return "default/layui/user/login";

		}

	}
    /**
     * 
    
     * <p>Title: toassess</p>  
    
     * <p>Description: 锟斤拷师锟斤拷锟斤拷页锟斤拷</p>  
    
     * @param session
     * @param model
     * @param teacherId
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/toassess")
	public String toassess(HttpSession session, Model model, Integer teacherId) throws Exception {
		Map<String, Integer> ranks = configService.getRank("qxy_criteria");

		User user = (User) session.getAttribute("user");

		if (user.getType()== 1||user.getType()==2||user.getType()==3) {
			List<CriteriaVo> criteriaList = null;
			criteriaList = criteriaService.findCriteriaVo(Integer.parseInt(user.getType().toString()), null);
			
			Assess assess = new Assess();

			assess.setTargetTeacher(teacherId);
			assess.setUserid(user.getId());
			assess.setUsertype(user.getType());
			model.addAttribute("criteriaList", criteriaList);
			model.addAttribute("assess", assess);

		} 
		else if(user.getType()==24){
			
			List<CriteriaVo> criteriaList = null;
			criteriaList = criteriaService.findCriteriaVo(2, null);
			
			Assess assess = new Assess();

			assess.setTargetTeacher(teacherId);
			assess.setUserid(user.getId());
			assess.setUsertype(user.getType());
			model.addAttribute("criteriaList", criteriaList);
			model.addAttribute("assess", assess);
			
		}
		else {
			return "default/layui/user/login";

		}
		// user.getType()锟叫断ｏ拷1 学锟斤拷锟斤拷2锟斤拷师锟斤拷3锟斤拷锟斤拷

		model.addAttribute("ranks", ranks);
		return "default/layui/user/assess";
	}
	/**
	 * 
	
	 * <p>Title: toassessclasses</p>  
	
	 * <p>Description: 转锟斤拷锟斤拷学页锟斤拷</p>  
	
	 * @param session
	 * @param model
	 * @param teacherId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/toassessclass")
	public String toassessclasses(HttpSession session, Model model, Integer classesId) throws Exception {
		Map<String, Integer> ranks = configService.getRank("qxy_criteria");

		User user = (User) session.getAttribute("user");

		if (user != null) {
			CriteriaClassesExample criteriaClassesExample=new CriteriaClassesExample();
			CriteriaClassesExample.Criteria criteria=criteriaClassesExample.createCriteria();
			criteria.andStatusEqualTo((byte)1);
			List<CriteriaClasses> criteriaClassesList=criteriaClassesService.query(criteriaClassesExample);
			
			AssessClasses assessClasses =new AssessClasses();
			assessClasses.setTargetClasses(classesId);
			assessClasses.setCreatetime(new Date());
			assessClasses.setUserid(user.getId());
			assessClasses.setUsertype(user.getType());
			model.addAttribute("criteriaClassesList", criteriaClassesList);
			model.addAttribute("assessClasses", assessClasses);

		} else {
			return "default/layui/user/login";

		}
		// user.getType()锟叫断ｏ拷1 学锟斤拷锟斤拷2锟斤拷师锟斤拷3锟斤拷锟斤拷

		model.addAttribute("ranks", ranks);
		return "default/layui/user/assess_classes";
	}
	/**
	 * 
	
	 * <p>Title: assess</p>  
	
	 * <p>Description:锟斤拷师锟斤拷锟斤拷 </p>  
	
	 * @param assess
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/assess" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String assess(Assess assess) throws Exception{
		//锟叫讹拷锟角凤拷锟结交锟斤拷锟斤拷锟斤拷锟斤拷峤伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷峤灰伙拷危锟斤拷锟斤拷锟斤拷俅锟斤拷峤�(锟斤拷锟斤拷锟节硷拷)
		Status status=null;
		AssessExample assessExample=new AssessExample();
		AssessExample.Criteria criteria=assessExample.createCriteria();
		
		criteria.andTargetTeacherEqualTo(assess.getTargetTeacher());
		criteria.andUseridEqualTo(assess.getUserid());
		
		Assess assess2=assessService.findAssess(assessExample);
		if(assess2!=null){
			
			status=new Status();
			
			status.setStatusCode(1);
			status.setMessage("锟矫伙拷锟窖撅拷锟结交锟斤拷锟斤拷锟斤拷");
		}
		else{
			assess.setCreatetime(new Date());
			assessService.Insert(assess);
            status=new Status();
			
			status.setStatusCode(2);
			status.setMessage("锟斤拷锟斤拷锟结交锟缴癸拷锟斤拷锟斤拷锟斤拷");
			
		}
		
		return JacksonUtil.bean2Json(status);
	}
	
	@RequestMapping(value = "/assessclasses" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String assessclasses(AssessClasses assessClasses) throws Exception{
		//锟叫讹拷锟角凤拷锟结交锟斤拷锟斤拷锟斤拷锟斤拷峤伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷峤灰伙拷危锟斤拷锟斤拷锟斤拷俅锟斤拷峤�(锟斤拷锟斤拷锟节硷拷)
		Status status=null;
		AssessClassesExample assessclassesExample=new AssessClassesExample();
		AssessClassesExample.Criteria criteria=assessclassesExample.createCriteria();
		
		criteria.andTargetClassesEqualTo(assessClasses.getTargetClasses());
		criteria.andUseridEqualTo(assessClasses.getUserid());
        List<AssessClasses> assessClasseslist=assessClassesService.query(assessclassesExample);
        
		if(assessClasseslist!=null&&assessClasseslist.size()>0){
			
			status=new Status();
			
			status.setStatusCode(1);
			status.setMessage("锟矫伙拷锟窖撅拷锟结交锟斤拷锟斤拷锟斤拷");
		}
		else{
			assessClasses.setCreatetime(new Date());
			assessClassesService.insert(assessClasses);
            status=new Status();
			
			status.setStatusCode(2);
			status.setMessage("锟斤拷锟斤拷锟结交锟缴癸拷锟斤拷锟斤拷锟斤拷");
			
		}
		
		return JacksonUtil.bean2Json(status);
	}
    /**
     * 
    
     * <p>Title: toclasses</p>  
    
     * <p>Description:锟斤拷师锟节匡拷选锟斤拷页锟斤拷 </p>  
    
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/toclasses")
	public String toclasses(HttpSession session, Model model) throws Exception {

		List<DepartmentAndClassesVo> departmentAndClassesVos = departmentService.queryDepartAndClasses();

		UserClassesExample userClassesExample = new UserClassesExample();
		UserClassesExample.Criteria criteria = userClassesExample.createCriteria();
		User user = (User) session.getAttribute("user");
		if (user != null) {

			criteria.andUserIdEqualTo(user.getId());
		} else {

			return "default/layui/user/login";

		}

		List<UserClasses> userClassesList = userClassesService.queryUserClassesList(userClassesExample);
		List<Integer> classesIdsA = new ArrayList<Integer>();
		if (userClassesList != null && userClassesList.size() > 0) {
			for (UserClasses userClasses : userClassesList) {

				classesIdsA.add(userClasses.getClassesId());
			}
			model.addAttribute("classesIds", classesIdsA);

		}
		model.addAttribute("departmentAndClassesVos", departmentAndClassesVos);
		return "default/layui/user/classes";
	}
	/**
	 * 
	
	 * <p>Title: toAdviserClassesinfo</p>  
	
	 * <p>Description:锟斤拷锟斤拷锟斤拷锟轿革拷锟斤拷陌嗉讹拷锟较� </p>  
	
	 * @return 锟竭硷拷锟斤拷图
	 * @throws Exception 
	 */
	@RequestMapping("/toclassesinfo")
	public String toAdviserClassesinfo(Model model,HttpSession session) throws Exception{
		User user = (User) session.getAttribute("user");
		List<Classes> classesList=null;
		if (user != null) {
			
		 if(user.getType()==4){
			 
			// classesList=classesService.selectClassesByAdviserId(user.getId());
			 List<ClassesAndUserVo> classesAndUserVos=null;
			   
				 classesAndUserVos = classesService.selectClassesAndUserByAdviser(user.getId());
				 model.addAttribute("classesAndUserVos", classesAndUserVos);
				 				 
		
			
			 
		 }
		 if(user.getType()==2){
			 
			 List<Integer> classesIds=classesService.getClassesIdsByUserId(user.getId());
			 classesList =classesService.selectClassesByTeacherId(user.getId());
			 for (int i = 0; i < classesList.size(); i++) {
				 
				 
				 if(classesIds.contains(classesList.get(i).getId())){
					 
					 classesList.remove(i);
					 i--; 
					 
				 }
				 
			}
			 model.addAttribute("classesList", classesList); 
			 
		 }
		 if(user.getType()==24){
			 
				// classesList=classesService.selectClassesByAdviserId(user.getId());
			 List<ClassesAndUserVo> classesAndUserVos=null;
			   
				 classesAndUserVos = classesService.selectClassesAndUserByAdviser(user.getId());
				 model.addAttribute("classesAndUserVos", classesAndUserVos);
				 
				 
				 List<Integer> classesIds=classesService.getClassesIdsByUserId(user.getId());
				 classesList =classesService.selectClassesByTeacherId(user.getId());
				 for (int i = 0; i < classesList.size(); i++) {
					 
					 
					 if(classesIds.contains(classesList.get(i).getId())){
						 
						 classesList.remove(i);
						 i--; 
						 
					 }
					 
				}
				 model.addAttribute("classesList", classesList); 
			 
			 
		 }
			
		 
		    
			
			return	"default/layui/user/classesinfo";
		
		} else {

			return "default/layui/user/login";

		}
		
	
	}
	/**
	 * 
	
	 * <p>Title: toAdviserClasses</p>  
	
	 * <p>Description:锟斤拷锟斤拷锟斤拷选锟斤拷锟斤拷嗉讹拷锟揭筹拷锟� </p>  
	
	 * @param session
	 * @param model
	 * @return 锟竭硷拷页锟斤拷路锟斤拷
	 * @throws Exception
	 */
	@RequestMapping(value = "/toadviserclasses")
	public String toAdviserClasses(HttpSession session, Model model) throws Exception {

		List<DepartmentAndClassesVo> departmentAndClassesVos = departmentService.queryDepartAndClasses();

		AdviserClassesExample adviserClassesExample = new AdviserClassesExample();
		AdviserClassesExample.Criteria criteria = adviserClassesExample.createCriteria();
		User user = (User) session.getAttribute("user");
		if (user != null) {

			criteria.andAdviserIdEqualTo(user.getId());
		} else {

			return "default/layui/user/login";

		}

		List<AdviserClasses> adviserClassesList = adviserClassesService.queryAdviserClassesList(adviserClassesExample);
		List<Integer> classesIdsA = new ArrayList<Integer>();
		if (adviserClassesList != null && adviserClassesList.size() > 0) {
			for (AdviserClasses adviserClasses : adviserClassesList) {

				classesIdsA.add(adviserClasses.getClassesId());
			}
			model.addAttribute("classesIds", classesIdsA);

		}
		model.addAttribute("departmentAndClassesVos", departmentAndClassesVos);
	
	
		return "default/layui/user/adviser_classes";
	}
	/**
	 * 
	
	 * <p>Title: addAdviserClasses</p>  
	
	 * <p>Description: 选锟斤拷锟斤拷锟斤拷胃锟斤拷锟斤拷陌嗉�</p>  
	
	 * @param session
	 * @param classesIds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addadviserclasses" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addAdviserClasses(HttpSession session, @RequestParam("classesIds[]") List<Integer> classesIds)
			throws Exception {

		Status status = null;

		if (classesIds.size() == 0 && classesIds != null) {
			status = new Status();
			status.setStatusCode(1);

			status.setMessage("锟洁级锟斤拷锟斤拷锟斤拷要选锟斤拷一锟斤拷锟洁级");
		}

		// 锟斤拷取锟窖撅拷锟斤拷拥陌嗉�
		User user = (User) session.getAttribute("user");
		if (user != null) { 
			AdviserClassesExample adviserClassesExample=new AdviserClassesExample();
			
			AdviserClassesExample.Criteria criteria = adviserClassesExample.createCriteria();
			criteria.andAdviserIdEqualTo(user.getId());
			List<AdviserClasses> adviserClassesList = adviserClassesService.queryAdviserClassesList(adviserClassesExample);

			// 锟斤拷酶锟斤拷没锟斤拷锟斤拷锟斤拷邪嗉讹拷锟絠d
			List<Integer> classesIdsA = new ArrayList<Integer>();
			AdviserClasses adviserClasses = null;
			// 锟叫讹拷锟角凤拷锟斤拷锟斤拷锟斤拷税嗉�
			if (adviserClassesList != null && adviserClassesList.size() > 0) {
				for (AdviserClasses classes : adviserClassesList) {

					classesIdsA.add(classes.getClassesId());
				}

				// 锟叫讹拷classesIds锟斤拷锟较碉拷classId锟斤拷藕锟斤拷丫锟斤拷锟接班级锟斤拷沤锟斤拷锟絪ubstract锟斤拷锟斤拷去锟斤拷锟截革拷锟侥诧拷锟街ｏ拷
				// 锟斤拷锟斤拷锟斤拷锟斤拷classesIds锟斤拷classesIdsA锟斤拷锟斤拷锟斤拷锟斤拷牟锟斤拷纸锟斤拷锟斤拷锟斤拷
				// 锟斤拷锟斤拷锟斤拷锟斤拷classesIdsA锟斤拷classesIds锟斤拷锟斤拷锟斤拷锟斤拷牟锟斤拷纸锟斤拷锟缴撅拷锟�
				// 锟斤拷要使锟斤拷ListUtils锟斤拷

				// userClassesService.de

				List<Integer> substractB = ListUtils.subtract(classesIdsA, classesIds);
				List<Integer> substractA = ListUtils.subtract(classesIds, classesIdsA);
				if (substractB != null && substractB.size() > 0) {
					AdviserClassesExample adviserClassesExample2=new AdviserClassesExample();
					
					AdviserClassesExample.Criteria criteria2 = adviserClassesExample2.createCriteria();
					for (Integer i : substractB) {
						criteria2.andAdviserIdEqualTo(user.getId());
						criteria2.andClassesIdEqualTo(i);
						adviserClassesService.delete(adviserClassesExample2);

					}
				}
				if (substractA != null && substractA.size() > 0) {

					for (Integer i : substractA) {
						adviserClasses = new AdviserClasses();

						adviserClasses.setAdviserId(user.getId());
						adviserClasses.setClassesId(i);

						adviserClasses.setCreatetime(new Date());
						adviserClassesService.insert(adviserClasses);
					}

				}

			} else {

				for (Integer classesId : classesIds) {
					adviserClasses = new AdviserClasses();

					adviserClasses.setAdviserId(user.getId());
					adviserClasses.setClassesId(classesId);

					adviserClasses.setCreatetime(new Date());
					adviserClassesService.insert(adviserClasses);

				}

			}

			status = new Status();
			status.setStatusCode(3);

			status.setMessage("锟洁级锟斤拷息锟斤拷锟斤拷晒锟�");
		} else {

			status = new Status();
			status.setStatusCode(2);

			status.setMessage("锟姐还没锟叫碉拷录锟斤拷锟斤拷锟斤拷锟铰碉拷录");

		}

		return JacksonUtil.bean2Json(status);

	}
	/**
	 * 
	
	 * <p>Title: addClasses</p>  
	
	 * <p>Description: 锟斤拷师选锟斤拷锟节课的班级</p>  
	
	 * @param session
	 * @param classesIds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addclasses",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addClasses(HttpSession session, @RequestParam("classesIds[]") List<Integer> classesIds)
			throws Exception {

		Status status = null;

		if (classesIds.size() == 0 && classesIds != null) {
			status = new Status();
			status.setStatusCode(1);

			status.setMessage("锟洁级锟斤拷锟斤拷锟斤拷要选锟斤拷一锟斤拷锟洁级");
		}

		// 锟斤拷取锟窖撅拷锟斤拷拥陌嗉�
		User user = (User) session.getAttribute("user");
		if (user != null) {
			UserClassesExample userClassesExample = new UserClassesExample();
			UserClassesExample.Criteria criteria = userClassesExample.createCriteria();
			criteria.andUserIdEqualTo(user.getId());
			List<UserClasses> userClassesList = userClassesService.queryUserClassesList(userClassesExample);

			// 锟斤拷酶锟斤拷没锟斤拷锟斤拷锟斤拷邪嗉讹拷锟絠d
			List<Integer> classesIdsA = new ArrayList<Integer>();
			UserClasses userClasses1 = null;
			// 锟叫讹拷锟角凤拷锟斤拷锟斤拷锟斤拷税嗉�
			if (userClassesList != null && userClassesList.size() > 0) {
				for (UserClasses userClasses : userClassesList) {

					classesIdsA.add(userClasses.getClassesId());
				}

				// 锟叫讹拷classesIds锟斤拷锟较碉拷classId锟斤拷藕锟斤拷丫锟斤拷锟接班级锟斤拷沤锟斤拷锟絪ubstract锟斤拷锟斤拷去锟斤拷锟截革拷锟侥诧拷锟街ｏ拷
				// 锟斤拷锟斤拷锟斤拷锟斤拷classesIds锟斤拷classesIdsA锟斤拷锟斤拷锟斤拷锟斤拷牟锟斤拷纸锟斤拷锟斤拷锟斤拷
				// 锟斤拷锟斤拷锟斤拷锟斤拷classesIdsA锟斤拷classesIds锟斤拷锟斤拷锟斤拷锟斤拷牟锟斤拷纸锟斤拷锟缴撅拷锟�
				// 锟斤拷要使锟斤拷ListUtils锟斤拷

				// userClassesService.de

				List<Integer> substractB = ListUtils.subtract(classesIdsA, classesIds);
				List<Integer> substractA = ListUtils.subtract(classesIds, classesIdsA);
				if (substractB != null && substractB.size() > 0) {
					UserClassesExample userClassesExample2 = new UserClassesExample();
					UserClassesExample.Criteria criteria2 = userClassesExample2.createCriteria();
					for (Integer i : substractB) {
						criteria2.andUserIdEqualTo(user.getId());
						criteria2.andClassesIdEqualTo(i);
						userClassesService.deteteUserClasses(userClassesExample2);

					}
				}
				if (substractA != null && substractA.size() > 0) {

					for (Integer i : substractA) {
						userClasses1 = new UserClasses();

						userClasses1.setUserId(user.getId());
						userClasses1.setClassesId(i);

						userClasses1.setCeatetime(new Date());
						userClassesService.insertUserClasses(userClasses1);
					}

				}

			} else {

				for (Integer classesId : classesIds) {
					userClasses1 = new UserClasses();
					userClasses1.setUserId(user.getId());
					userClasses1.setClassesId(classesId);

					userClasses1.setCeatetime(new Date());
					userClassesService.insertUserClasses(userClasses1);

				}

			}

			status = new Status();
			status.setStatusCode(3);

			status.setMessage("锟洁级锟斤拷息锟斤拷锟斤拷晒锟�");
		} else {

			status = new Status();
			status.setStatusCode(2);

			status.setMessage("锟姐还没锟叫碉拷录锟斤拷锟斤拷锟斤拷锟铰碉拷录");

		}

		return JacksonUtil.bean2Json(status);

	}
	/**
	 * 
	
	 * <p>Title: checkUserno</p>  
	
	 * <p>Description: 锟叫断癸拷锟斤拷|学锟斤拷锟角凤拷锟截革拷</p>  
	
	 * @param userno
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/checkuserno" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String checkUserno(String userno) throws Exception{
		
		Status status=null;
		
		long row=userService.checkUserno(userno);
		
		if(row>0){
			
			status=new Status();
			status.setStatusCode(0);
			status.setMessage("锟斤拷锟斤拷|学锟斤拷锟截革拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷写");
		}
		else{
			
			status=new Status();
			status.setStatusCode(1);
			status.setMessage("锟斤拷锟斤拷|学锟脚诧拷锟截革拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�");
		}
		
		return JacksonUtil.bean2Json(status);
		
		
	}
	@RequestMapping(value = "/resetpassword" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String resetPassword(int id,String userno) throws Exception{
		
        Status status=null;
		
		int row=userService.resetPassword(id, userno);
		
		if(row>0){
			
			status=new Status();
			status.setStatusCode(1);
			status.setMessage("锟斤拷锟斤拷锟斤拷锟矫成癸拷");
		}
		else{
			
			status=new Status();
			status.setStatusCode(0);
			status.setMessage("锟斤拷锟斤拷锟斤拷锟斤拷失锟杰ｏ拷锟斤拷锟斤拷系锟斤拷锟斤拷员");
		}
		
		return JacksonUtil.bean2Json(status);
		
	}
	@RequestMapping("/nosubmit")
	public String nosubmit(Model model,Integer classesId,Integer teacherId ){
		
		List<User> users=userService.selectByClassesIdAndTeacherId(classesId, teacherId);
		
		model.addAttribute("users", users);
		 return "default/layui/user/nosubmit";
	}
	//锟斤拷锟斤拷锟矫伙拷锟斤拷锟斤拷
	@RequestMapping(value="/changeusertype",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String changeUserType(HttpSession session,Integer type) throws Exception{
		 Status status=null;
		 User user = (User) session.getAttribute("user");
		 if(user!=null){
			user.setType(Byte.valueOf(type.toString()));
           int row=userService.updateUserById(user.getId(), user);
			
			if(row>0){
				
				status=new Status();
				status.setStatusCode(1);
				status.setMessage("锟矫伙拷锟斤拷锟斤拷锟侥成癸拷,锟斤拷锟斤拷锟铰碉拷录");
			}
			else{
				
				status=new Status();
				status.setStatusCode(2);
				status.setMessage("锟矫伙拷锟斤拷锟斤拷锟斤拷失锟杰ｏ拷锟斤拷锟斤拷系锟斤拷锟斤拷员");
			}
		}
		 else{
			 
				status=new Status();
				status.setStatusCode(0);
				status.setMessage("锟斤拷锟斤拷锟铰碉拷录");
			 
		 }
		
			
			
			
			return JacksonUtil.bean2Json(status);
		
	}
	
	    //锟斤拷锟斤拷锟矫伙拷状态
		@RequestMapping(value="/changestatus.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String changeStatus(Integer userId,Integer status1) throws Exception{
			 Status status=null;

			
	           int row=userService.changeStatus(userId, status1);
				
				if(row>0){
					
					status=new Status();
					status.setStatusCode(1);
					status.setMessage("锟矫伙拷状态锟斤拷锟侥成癸拷,锟斤拷锟斤拷锟铰碉拷录");
				}
				else{
					
					status=new Status();
					status.setStatusCode(2);
					status.setMessage("锟矫伙拷状态锟斤拷锟斤拷失锟杰ｏ拷锟斤拷锟斤拷系锟斤拷锟斤拷员");
				}
		
			
				
				
				
				return JacksonUtil.bean2Json(status);
			
		}
		@RequestMapping("/getuserclassid")
		public String getUserclassid( HttpSession session,Integer userclassid){
			System.out.println(userclassid);
			return "success";
		}
		
		
		
		//自添tosign方法
		@RequestMapping("/tosign")
		public String tosign(Model model,HttpSession session) throws Exception {
			//创建usersign
			Usersign usersign=new Usersign();
			
			StudentAndClasssesAndDepart userAndClasssesAndDepart = new StudentAndClasssesAndDepart();
			if (session.getAttribute("user") != null) {
				User user = (User) session.getAttribute("user");
                //通过user表获取classid 取得classes表中数据				
				Classes classes = classesService.findClassesById(user.getClassesid());				
			    //Department department = departmentService.findDepartmentById(user.getDepartid());
//取得classname			
				String classcourse1=classes.getClassesName();
				System.out.println(classcourse1);
				//取得classid;
				Integer classid1=classes.getId();
				Integer userid1=user.getId();
				System.out.println(classid1);
				usersign.setClassesid(classid1);
				usersign.setUserid(userid1);
				//usersign.setCoursecode(coursecode);
				System.out.println(usersign.toString());
				List<ClassCourseVo> coursename1=classCourseService.selectcourseNamefromcourseByclasscourse();
				
				userAndClasssesAndDepart.setClasses(classes);
				BeanUtils.copyProperties(user, userAndClasssesAndDepart);
				//userAndClasssesAndDepart.setDepartment(department);
                //userAndClasssesAndDepart涓寘鍚玞lass鎵�鏈夋暟鎹紝
				model.addAttribute("user", userAndClasssesAndDepart);
				model.addAttribute("coursename1", coursename1);
				
				
				
		        //更具日期取得数据				
				List<ClasscourseAndCourse> classandcourse1 = classCourseService.selectclasscourseANDcourseByweekday1(user.getClassesid());
				model.addAttribute("classandcourse1", classandcourse1);
				
				List<ClasscourseAndCourse> classandcourse2 = classCourseService.selectclasscourseANDcourseByweekday2(user.getClassesid());
				model.addAttribute("classandcourse2", classandcourse2);
				
				List<ClasscourseAndCourse> classandcourse3 = classCourseService.selectclasscourseANDcourseByweekday3(user.getClassesid());
				model.addAttribute("classandcourse3", classandcourse3);
												
				List<ClasscourseAndCourse> classandcourse4 = classCourseService.selectclasscourseANDcourseByweekday4(user.getClassesid());
				model.addAttribute("classandcourse4", classandcourse4);
				
				List<ClasscourseAndCourse> classandcourse5 = classCourseService.selectclasscourseANDcourseByweekday5(user.getClassesid());
				model.addAttribute("classandcourse5", classandcourse5);				
				}				
			return"default/layui/user/sign";
		}
		public static String getType(Object o) {
			return o.getClass().toString();
		}

		//提交签到信息
		 @RequestMapping("/submitUserSign.do")
         public String submitUserSign(Usersign usersign,String coursetime,HttpServletRequest request) throws Exception{
			    String pattern = "EEE MMM dd HH:mm:ss zzz yyyy";   
		        SimpleDateFormat df = new SimpleDateFormat(pattern,Locale.US);
		        Date date = df.parse(coursetime);  
		        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
		        System.out.println("获取数据库中课程上课的小时和分："+sdf.format(date));
		        usersign.getSigntime();
		        Date nowdate=new Date();
		        System.out.println("获取现在小时和分："+sdf.format(nowdate));
		        System.out.println(getType(sdf.format(nowdate)));
			    //获取请求主机IP地址，如果通过代理进来，则透过防火墙获取真实IP地址
		        String ip = request.getHeader("X-Forwarded-For");
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		                ip = request.getHeader("Proxy-Client-IP");
		            }
		            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		                ip = request.getHeader("WL-Proxy-Client-IP");
		            }
		            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		                ip = request.getHeader("HTTP_CLIENT_IP");
		            }
		            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		            }
		            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		                ip = request.getRemoteAddr();
		            }}
			 
			    usersign.setIpaddress(ip);
			    usersign.setSigntime(new Date());			 
			    usersignService.insertSign(usersign);
    	   
    	    return "success";
         }

}
