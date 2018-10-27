package cn.wuzongbo.tes.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.baidu.ueditor.ActionEnter;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.AnonymousCOSCredentials;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.ListObjectsRequest;
import com.qcloud.cos.model.ObjectListing;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import cn.wuzongbo.tes.exception.CustomException;
import cn.wuzongbo.tes.po.Classes;
import cn.wuzongbo.tes.po.QueryAllTeacherGetScoreVO;
import cn.wuzongbo.tes.po.QueryClassesRateofStudentSubmit;
import cn.wuzongbo.tes.po.Recruit;
import cn.wuzongbo.tes.po.RecruitExample;
import cn.wuzongbo.tes.po.Scholarship;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.po.Student;
import cn.wuzongbo.tes.po.User;
import cn.wuzongbo.tes.po.UserExample;
import cn.wuzongbo.tes.service.ClassesService;
import cn.wuzongbo.tes.service.RecruitService;
import cn.wuzongbo.tes.service.ScholarshipService;
import cn.wuzongbo.tes.service.StudentService;
import cn.wuzongbo.tes.service.UserService;
import cn.wuzongbo.tes.util.DateUtil;
import cn.wuzongbo.tes.util.ExcelUtil;
import cn.wuzongbo.tes.util.ImportExcelUtil;
import cn.wuzongbo.tes.util.JacksonUtil;
import cn.wuzongbo.tes.util.MD5Util;
import cn.wuzongbo.tes.util.VerifyCodeUtils;

@Controller
@RequestMapping("/file")
public class FileController {
	@Autowired
	private UserService userService;

	@Autowired
	private ClassesService classesService;

	@Autowired
	private ScholarshipService scholarshipService;

	@Autowired
	private RecruitService recruitService;

	@RequestMapping("/config")
	public void config(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");
		String rootPath = request.getSession().getServletContext().getRealPath("/upload/");

		try {
			String exec = new ActionEnter(request, rootPath).exec();
			PrintWriter writer = response.getWriter();
			writer.write(exec);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
		if (!file.isEmpty()) {

			String path = request.getServletContext().getRealPath("/upload/");

			String filename = file.getOriginalFilename();

			File filePath = new File(path, filename);

			if (!filePath.getParentFile().exists()) {

				filePath.getParentFile().mkdirs();
			}
			String ext = filename.substring(filename.lastIndexOf("."));
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String newFileName = uuid + ext;
			file.transferTo(new File(path + File.separator + newFileName));
			String fullFilePath = path + File.separator + newFileName;

			COSClient cosclient = getCCOSClient();
			// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
			String bucketName = "file-1251531734";

			// 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
			// 大文件上传请参照 API 文档高级 API 上传
			File localFile = new File(fullFilePath);
			// 指定要上传到 COS 上的路径
			String key = newFileName;
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
			PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
			String etag = putObjectResult.getETag();
			// 生成可以访问的路径，用于文件的下载和图片显示
			GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
			URL url = cosclient.generatePresignedUrl(req);
			System.out.println(url);
			cosclient.shutdown();

			return "success";

		} else {

			return "error";
		}

	}

	@RequestMapping(value = "/toupload")
	public String toupload() {

		String bucketName = "file-1251531734";
		COSClient cosclient = getCCOSClient();
		// 获取 bucket 下成员（设置 delimiter）
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
		listObjectsRequest.setBucketName(bucketName);
		// 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
		listObjectsRequest.setPrefix("");
		// 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员
		listObjectsRequest.setDelimiter("/");
		// 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
		listObjectsRequest.setMarker("");
		// 设置最多 list 100 个成员,（如果不设置, 默认为 1000 个，最大允许一次 list 1000 个 key）
		listObjectsRequest.setMaxKeys(100);

		ObjectListing objectListing = cosclient.listObjects(listObjectsRequest);
		// 获取下次 list 的 marker
		String nextMarker = objectListing.getNextMarker();
		// 判断是否已经 list 完, 如果 list 结束, 则 isTruncated 为 false, 否则为 true
		boolean isTruncated = objectListing.isTruncated();
		List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();

		cosclient.shutdown();
		return "admin/file/upload";

	}

	@RequestMapping(value = "/ajaxUpload", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxUploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file)
			throws Exception {
		if (!file.isEmpty()) {

			String path = request.getServletContext().getRealPath("/upload/");

			String filename = file.getOriginalFilename();

			File filePath = new File(path, filename);

			if (!filePath.getParentFile().exists()) {

				filePath.getParentFile().mkdirs();
			}
			String ext = filename.substring(filename.lastIndexOf("."));
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String newFileName = uuid + ext;
			file.transferTo(new File(path + File.separator + newFileName));
			String fullFilePath = path + File.separator + newFileName;

			COSClient cosclient = getAnonymousClient();
			// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
			String bucketName = "file-1251531734";

			// 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
			// 大文件上传请参照 API 文档高级 API 上传
			File localFile = new File(fullFilePath);
			// 指定要上传到 COS 上的路径
			String key = newFileName;
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
			PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
			String etag = putObjectResult.getETag();
			GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
			URL url = cosclient.generatePresignedUrl(req);
			System.out.println(url);
			cosclient.shutdown();
		}
		return "{\"status\":1}";
	}

	@RequestMapping(value = "/student/ajaxImportExcel", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String importStudentExcel(HttpServletRequest request, @RequestParam("file") MultipartFile file)
			throws Exception {

		Status status = null;
		if (!file.isEmpty()) {
			InputStream is = file.getInputStream();
			String fileName = file.getOriginalFilename();
			List<List<Object>> list = new ImportExcelUtil().getBankListByExcel(is, fileName);

			User user = null;
			for (int i = 0; i < list.size(); i++) {
				List<Object> listObject = list.get(i);
				user = new User();
				String password = "88888888";
				String userNo = String.valueOf(listObject.get(2));// 工号|学号

				long row = checkUserno(userNo);
				if (row > 0) {
					continue;
				}
				String userName = String.valueOf(listObject.get(0));
				int userStatus = Integer.parseInt(listObject.get(3).toString());// 用户状态
				int classesId = Integer.parseInt(listObject.get(4).toString());// 班级

				int departId = Integer.parseInt(listObject.get(5).toString());// 班级
				user.setUsername(userName);
				// MD5Util.MD5(userNo+password);使用MD5加密
				user.setPassword(MD5Util.MD5(userNo + password));
				user.setUserno(userNo);
				user.setStatus((byte) userStatus);
				user.setClassesid(classesId);
				user.setType((byte) 1);
				user.setDepartid(departId);
				userService.insertUser(user);
			}
			status = new Status();
			status.setStatusCode(1);
			status.setMessage("导入数据成功");

		} else {

			status = new Status();
			status.setStatusCode(2);
			status.setMessage("文件不存在");
		}

		return JacksonUtil.bean2Json(status);

	}

	@RequestMapping(value = "/teacher/ajaxImportExcel", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String importTeacherExcel(@RequestParam("file") MultipartFile file) throws Exception {

		Status status = null;
		if (!file.isEmpty()) {
			InputStream is = file.getInputStream();
			String fileName = file.getOriginalFilename();
			List<List<Object>> list = new ImportExcelUtil().getBankListByExcel(is, fileName);

			User user = null;
			for (int i = 0; i < list.size(); i++) {
				List<Object> listObject = list.get(i);
				user = new User();
				String password = "88888888";
				String userNo = String.valueOf(listObject.get(0));// 工号|学号
				long row = checkUserno(userNo);
				if (row > 0) {
					continue;
				}
				String userName = String.valueOf(listObject.get(1));
				int departId = Integer.parseInt(listObject.get(2).toString());
				String ranks = String.valueOf(listObject.get(3));
				String major = String.valueOf(listObject.get(4));
				int userStatus = Integer.parseInt(listObject.get(5).toString());// 用户状态
				user.setUsername(userName);
				// MD5Util.MD5(userNo+password);使用MD5加密
				user.setPassword(MD5Util.MD5(userNo + password));
				user.setUserno(userNo);
				user.setStatus((byte) userStatus);
				user.setDepartid(departId);
				user.setRanks(ranks);
				user.setMajor(major);
				user.setType((byte) 2);
				userService.insertUser(user);
			}
			status = new Status();
			status.setStatusCode(1);
			status.setMessage("导入数据成功");

		} else {

			status = new Status();
			status.setStatusCode(2);
			status.setMessage("文件不存在");
		}

		return JacksonUtil.bean2Json(status);

	}

	@RequestMapping(value = "/ajaxImportAdviserExcel", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String importAdviserExcel(@RequestParam("file") MultipartFile file) throws Exception {

		Status status = null;
		if (!file.isEmpty()) {
			InputStream is = file.getInputStream();
			String fileName = file.getOriginalFilename();
			List<List<Object>> list = new ImportExcelUtil().getBankListByExcel(is, fileName);

			User user = null;
			for (int i = 0; i < list.size(); i++) {
				List<Object> listObject = list.get(i);
				user = new User();
				String password = "88888888";
				String userNo = String.valueOf(listObject.get(0));// 工号|学号
				long row = checkUserno(userNo);
				if (row > 0) {
					continue;
				}
				String userName = String.valueOf(listObject.get(1));
				int departId = Integer.parseInt(listObject.get(2).toString());
				String ranks = String.valueOf(listObject.get(3));
				String major = String.valueOf(listObject.get(4));
				int userStatus = Integer.parseInt(listObject.get(5).toString());// 用户状态
				user.setUsername(userName);
				// MD5Util.MD5(userNo+password);使用MD5加密
				user.setPassword(MD5Util.MD5(userNo + password));
				user.setUserno(userNo);
				user.setStatus((byte) userStatus);
				user.setDepartid(departId);
				user.setRanks(ranks);
				user.setMajor(major);
				user.setType((byte) 4);
				userService.insertUser(user);
			}
			status = new Status();
			status.setStatusCode(1);
			status.setMessage("导入数据成功");

		} else {

			status = new Status();
			status.setStatusCode(2);
			status.setMessage("文件不存在");
		}

		return JacksonUtil.bean2Json(status);

	}

	@RequestMapping(value = "/classes/ajaxImportExcel", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String importClassesExcel(@RequestParam("file") MultipartFile file) throws Exception {
		List<Classes> origin = classesService.queryClassesList(null);
		Status status = null;
		if (!file.isEmpty()) {
			InputStream is = file.getInputStream();
			String fileName = file.getOriginalFilename();
			List<List<Object>> list = new ImportExcelUtil().getBankListByExcel(is, fileName);
			Classes classes = null;
			for (int i = 0; i < list.size(); i++) {
				List<Object> listObject = list.get(i);
				classes = new Classes();
				String classesName = String.valueOf(listObject.get(0));// 班级名称
				long row = checkClassesName(classesName);
				if (row > 0) {

					continue;
				}
				int departId = Integer.parseInt(listObject.get(1).toString());
				int classesStatus = Integer.parseInt(listObject.get(2).toString());// 用户状态
				classes.setClassesName(classesName);
				classes.setDepartId(departId);
				classes.setStatus((byte) classesStatus);

				classesService.insertClasses(classes);

			}

			status = new Status();
			status.setStatusCode(1);
			status.setMessage("导入数据成功");

		} else {

			status = new Status();
			status.setStatusCode(2);
			status.setMessage("文件不存在");
		}

		return JacksonUtil.bean2Json(status);

	}

	@RequestMapping(value = "/ajaxRecruitExcel", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ajaxEnrolExcel(@RequestParam("file") MultipartFile file) throws Exception {
		Status status = null;
		// 数据库是否存在数据
		List<Recruit> origin = recruitService.query(null);
		if (origin != null && origin.size() > 0) {
			if (!file.isEmpty()) {
				InputStream is = file.getInputStream();
				String fileName = file.getOriginalFilename();
				List<List<Object>> list = new ImportExcelUtil().getBankListByExcel(is, fileName);
				Recruit recruit = null;
				for (int i = 0; i < list.size(); i++) {
					List<Object> listObject = list.get(i);
					recruit = new Recruit();
					String name = String.valueOf(listObject.get(1));
					
					String studentNo = String.valueOf(listObject.get(0));// 考生号
					if (studentNo == null || studentNo == "") {

						continue;
					}
					String major = String.valueOf(listObject.get(2));// 专业
					String grade = listObject.get(3).toString();
				
					double score = Double.valueOf(listObject.get(5).toString());
					DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					// String in=listObject.get(4).toString();

					// String in
					// =DateUtil.convert2String(Long.valueOf(listObject.get(4).toString()),DateUtil.DATE_FORMAT);
					Date inschool = format1.parse(listObject.get(6).toString());

					String address = String.valueOf(listObject.get(4));// 考生号
					String mobile = String.valueOf(listObject.get(3));

					String ems = String.valueOf(listObject.get(7));
					recruit.setName(name);
					recruit.setStudentno(studentNo);
					recruit.setMajor(major);
					recruit.setScore(score);
					recruit.setAddress(address);
					recruit.setInschool(inschool);
					recruit.setMobile(mobile);
					recruit.setEms(ems);
					boolean row = recruitService.checkStudetnno(studentNo);
					if (row) {
						RecruitExample recruitExample = new RecruitExample();
						RecruitExample.Criteria criteria = recruitExample.createCriteria();
						criteria.andStudentnoEqualTo(studentNo);

						List<Recruit> recruits = recruitService.query(recruitExample);
						if (recruits != null && recruits.size() > 0) {
							recruit.setId(recruits.get(0).getId());
							recruitService.update(recruit);
						}

					} else {

						recruitService.insert(recruit);

					}

				}

				status = new Status();
				status.setStatusCode(1);
				status.setMessage("导入数据成功");

			} else {

				status = new Status();
				status.setStatusCode(2);
				status.setMessage("文件不存在");
			}

		} else {
			if (!file.isEmpty()) {
				InputStream is = file.getInputStream();
				String fileName = file.getOriginalFilename();
				List<List<Object>> list = new ImportExcelUtil().getBankListByExcel(is, fileName);
				Recruit recruit = null;
				for (int i = 0; i < list.size(); i++) {
					List<Object> listObject = list.get(i);
					recruit = new Recruit();
String name = String.valueOf(listObject.get(1));
					
					String studentNo = String.valueOf(listObject.get(0));// 考生号
					if (studentNo == null || studentNo == "") {

						continue;
					}
					String major = String.valueOf(listObject.get(2));// 专业

				
					double score = Double.valueOf(listObject.get(5).toString());
					DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					// String in=listObject.get(4).toString();

					// String in
					// =DateUtil.convert2String(Long.valueOf(listObject.get(4).toString()),DateUtil.DATE_FORMAT);
					Date inschool = format1.parse(listObject.get(6).toString());

					String address = String.valueOf(listObject.get(4));// 考生号
					String mobile = String.valueOf(listObject.get(3));

					String ems = String.valueOf(listObject.get(7));
					recruit.setName(name);
					recruit.setStudentno(studentNo);
					recruit.setMajor(major);
					recruit.setScore(score);
					recruit.setAddress(address);
					recruit.setInschool(inschool);
					recruit.setMobile(mobile);
					recruit.setEms(ems);

					recruitService.insert(recruit);

				}

				status = new Status();
				status.setStatusCode(1);
				status.setMessage("导入数据成功");

			} else {

				status = new Status();
				status.setStatusCode(2);
				status.setMessage("文件不存在");
			}

		}

		return JacksonUtil.bean2Json(status);

	}

	private long checkUserno(String userno) throws Exception {
		long row = userService.checkUserno(userno);
		return row;
	}

	private long checkClassesName(String classesName) throws Exception {

		long row = classesService.checkClassesName(classesName);
		return row;

	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: getCCOSClient
	 * </p>
	 * 
	 * <p>
	 * Description: 返回COSClient实例
	 * </p>
	 * 
	 * @return COSClient
	 */
	private static COSClient getCCOSClient() {

		// 1 初始化用户身份信息(secretId, secretKey)
		COSCredentials cred = new BasicCOSCredentials("AKID78xeKMwwQmwtiLBaqumW5Sc0IOHDEG70",
				"LbfXTDnFVY0LyRiFftuiK5kLohV6aw8k");
		// 2 设置bucket的区域, COS地域的简称请参照
		// https://cloud.tencent.com/document/product/436/6224
		ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));

		// 3 生成cos客户端
		COSClient cosclient = new COSClient(cred, clientConfig);

		return cosclient;

	}

	private static COSClient getAnonymousClient() {

		// 生成匿名的请求签名，需要重新初始化一个匿名的cosclient
		// 1 初始化用户身份信息, 匿名身份不用传入ak sk
		COSCredentials cred = new AnonymousCOSCredentials();
		// 2 设置bucket的区域, COS地域的简称请参照
		// https://cloud.tencent.com/document/product/436/6224
		ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
		// 3 生成cos客户端
		COSClient cosclient = new COSClient(cred, clientConfig);
		return cosclient;

	}

	@RequestMapping("/exportStudentExcel")
	public String exportStudentExcel(HttpServletResponse response) throws Exception {

		String filename = "导出学生的数据";
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andTypeEqualTo((byte) 1);
		List<User> users = userService.queryUserList(userExample);
		List<Map<String, Object>> list = createStudentExcelRecord(users);
		String columnNames[] = { "姓名", "密码", "工号", "状态", "班级", "部门" };// 列名
		String keys[] = { "username", "password", "userno", "status", "classesid", "departid" };// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;

	}

	@RequestMapping("/exportTeacherExcel")
	public String exportTeacherExcel(HttpServletResponse response) throws Exception {

		String filename = "导出教师的数据";
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andTypeEqualTo((byte) 2);
		List<User> users = userService.queryUserList(userExample);
		List<Map<String, Object>> list = createTeacherExcelRecord(users);
		String columnNames[] = { "工号", "姓名", "部门", "职称", "专业", "状态" };// 列名
		String keys[] = { "userno", "username", "departid", "ranks", "major", "status" };// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;

	}

	@RequestMapping("/exportAdviserExcel")
	public String exportAdviserExcel(HttpServletResponse response) throws Exception {

		String filename = "导出班主任的数据";
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andTypeEqualTo((byte) 4);
		List<User> users = userService.queryUserList(userExample);
		List<Map<String, Object>> list = createTeacherExcelRecord(users);
		String columnNames[] = { "工号", "姓名", "部门", "职称", "专业", "状态" };// 列名
		String keys[] = { "userno", "username", "departid", "ranks", "major", "status" };// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;

	}

	@RequestMapping("/exportClassesExcel")
	public String exportClassesExcel(HttpServletResponse response) throws Exception {

		String filename = "导出班级的数据";
		List<Classes> classesList = classesService.queryClassesList(null);
		List<Map<String, Object>> list = createClassesExcelRecord(classesList);
		String columnNames[] = { "班级名称", "部门", "状态" };// 列名
		String keys[] = { "classesName", "departId", "status" };// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;

	}

	@RequestMapping("/exportAssessExcel")
	public String exportAssessExcel(HttpServletResponse response) throws Exception {

		String filename = "导出全校教师测评数据";
		List<QueryAllTeacherGetScoreVO> allTeacherGetScoreVOs = userService.selectTeacherGetAllAssessScorce();
		List<Map<String, Object>> list = createAssessExcelRecord(allTeacherGetScoreVOs);
		String columnNames[] = { "教师名称", "测评分数", "部门" };// 列名
		String keys[] = { "username", "score", "departName" };// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;

	}

	@RequestMapping("/exportBetweenAssessExcel")
	public String exportBetweenAssessExcel(HttpServletResponse response) throws Exception {

		String filename = "导出全校教师互评数据结果";
		List<QueryAllTeacherGetScoreVO> allTeacherGetScoreVOs = userService.selectBetweenTeacherScore();
		List<Map<String, Object>> list = createAssessExcelRecord(allTeacherGetScoreVOs);
		String columnNames[] = { "教师名称", "测评分数", "部门" };// 列名
		String keys[] = { "username", "score", "departName" };// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;

	}

	@RequestMapping("/exportTeacherClassesStudentSubmitRateExcel")
	public String ExportTeacherClassesStudentSubmitRateExcel(HttpServletResponse response) throws Exception {

		String filename = "导出教师授课班级学生提交比例";
		List<QueryClassesRateofStudentSubmit> classesRateofStudentSubmits = userService
				.selectTeacherClassesRateofStudentSubmit();
		List<Map<String, Object>> list = createClassesRateofStudentSubmit(classesRateofStudentSubmits);
		String columnNames[] = { "教师名称", "班级名称", "提交人数", "总人数", "提交比率", "部门" };// 列名
		String keys[] = { "userName", "classesName", "studentSubmitCount", "studentCount", "rate", "departName" };// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;

	}

	@RequestMapping("/exportScholarshipExcel")
	public String ExportScholarshipExcel(HttpServletResponse response) throws Exception {

		String filename = "导出新生申请奖学金数据";
		List<Scholarship> scholarships = scholarshipService.query(null);
		List<Map<String, Object>> list = createScholarshipExcel(scholarships);
		String columnNames[] = { "姓名", "考生号", "类型", "分数", "专业", "批次", "联系电话", "时间" };// 列名
		String keys[] = { "name", "studentno", "studenttype", "grade", "marjor", "batch", "contact", "createtime" };// map中的key

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((filename + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;

	}

	private List<Map<String, Object>> createStudentExcelRecord(List<User> users) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		User user = null;
		for (int j = 0; j < users.size(); j++) {
			user = users.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("username", user.getUsername());
			mapValue.put("password", user.getPassword());
			mapValue.put("userno", user.getUserno());

			mapValue.put("status", user.getStatus());
			mapValue.put("classesid", user.getClassesid());
			mapValue.put("departid", user.getClassesid());
			listmap.add(mapValue);
		}
		return listmap;
	}

	private List<Map<String, Object>> createTeacherExcelRecord(List<User> users) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		User user = null;
		for (int j = 0; j < users.size(); j++) {
			user = users.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("id", user.getId());
			mapValue.put("username", user.getUsername());
			mapValue.put("password", user.getPassword());
			mapValue.put("userno", user.getUserno());

			mapValue.put("status", user.getStatus());
			mapValue.put("departid", user.getDepartid());
			mapValue.put("ranks", user.getRanks());
			mapValue.put("major", user.getMajor());

			listmap.add(mapValue);
		}
		return listmap;
	}

	private List<Map<String, Object>> createClassesExcelRecord(List<Classes> classesList) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Classes classes = null;
		for (int j = 0; j < classesList.size(); j++) {
			classes = classesList.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("classesName", classes.getClassesName());

			mapValue.put("departId", classes.getDepartId());
			mapValue.put("status", classes.getStatus());
			listmap.add(mapValue);
		}
		return listmap;
	}

	private List<Map<String, Object>> createAssessExcelRecord(List<QueryAllTeacherGetScoreVO> allTeacherGetScoreVOs) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		QueryAllTeacherGetScoreVO allTeacherGetScoreVO = null;
		for (int j = 0; j < allTeacherGetScoreVOs.size(); j++) {
			allTeacherGetScoreVO = allTeacherGetScoreVOs.get(j);
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("username", allTeacherGetScoreVO.getUsername());

			mapValue.put("score", allTeacherGetScoreVO.getScore());
			mapValue.put("departName", allTeacherGetScoreVO.getDepartName());
			listmap.add(mapValue);
		}
		return listmap;
	}

	private List<Map<String, Object>> createScholarshipExcel(List<Scholarship> scholarships) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		Scholarship scholarship = null;
		for (int j = 0; j < scholarships.size(); j++) {
			scholarship = scholarships.get(j);

			// String keys[]=
			// {"name","studentno","studenttype","grade","marjor","batch","contact","createtime"};//map中的key
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("name", scholarship.getName());
			mapValue.put("studentno", scholarship.getStudentno());
			mapValue.put("studenttype", scholarship.getStudenttype());
			mapValue.put("grade", scholarship.getGrade());
			mapValue.put("marjor", scholarship.getMarjor());
			mapValue.put("batch", scholarship.getBatch());
			mapValue.put("createtime", scholarship.getCreatetime());
			mapValue.put("contact", scholarship.getContact());
			listmap.add(mapValue);
		}
		return listmap;
	}

	private List<Map<String, Object>> createClassesRateofStudentSubmit(
			List<QueryClassesRateofStudentSubmit> classesRateofStudentSubmits) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		QueryClassesRateofStudentSubmit queryClassesRateofStudentSubmit = null;
		for (int j = 0; j < classesRateofStudentSubmits.size(); j++) {
			queryClassesRateofStudentSubmit = classesRateofStudentSubmits.get(j);

			// String keys[]=
			// {"userName","classesName","studentSubmitCount","studentCount","rate","departName"};//map中的key
			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("userName", queryClassesRateofStudentSubmit.getUserName());
			mapValue.put("classesName", queryClassesRateofStudentSubmit.getClassesName());
			mapValue.put("studentSubmitCount", queryClassesRateofStudentSubmit.getStudentSubmitCount());
			mapValue.put("studentCount", queryClassesRateofStudentSubmit.getStudentCount());
			mapValue.put("rate", queryClassesRateofStudentSubmit.getRate());
			mapValue.put("departName", queryClassesRateofStudentSubmit.getDepartName());
			listmap.add(mapValue);
		}
		return listmap;
	}

	/**
	 * 
	 * <p>
	 * Title: generateNumber
	 * </p>
	 * 
	 * <p>
	 * Description: 生成验证码
	 * </p>
	 * 
	 * @param request
	 * @param response
	 * @param session
	 */
	@RequestMapping("/verifyCode")
	public void generateNumber(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入会话session
		// 删除以前的验证码
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		// 生成图片
		int w = 110, h = 30;
		try {
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
