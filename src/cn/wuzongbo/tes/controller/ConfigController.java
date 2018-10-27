package cn.wuzongbo.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wuzongbo.tes.po.Config;
import cn.wuzongbo.tes.po.ConfigExample;
import cn.wuzongbo.tes.po.Status;
import cn.wuzongbo.tes.service.ConfigService;
import cn.wuzongbo.tes.util.JacksonUtil;

@Controller
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;

	@RequestMapping("/index.do")
	public String queryConfigList(Model model, @RequestParam(required = true, defaultValue = "1") Integer page,
			Config config) throws Exception {

		PageHelper.startPage(page, 10);
		ConfigExample configExample = new ConfigExample();
		ConfigExample.Criteria criteria = configExample.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		if (config.getIncType() != null && config.getIncType() != "") {
			criteria.andIncTypeEqualTo(config.getIncType());

		}
		if (config.getName() != null && config.getName() != "") {

			criteria.andNameLike("%"+config.getName()+"%");

		}

		List<Config> configList = configService.queryConfigList(configExample);

		PageInfo<Config> pageInfo = new PageInfo<Config>(configList);
		model.addAttribute("page", pageInfo);
		model.addAttribute("configList", configList);
		return "admin/config/list";

	}

	@RequestMapping("/toedit.do")
	public String toedit(Model model, Short id) throws Exception {

		if (id != null) {
			Config config = configService.findConfigById(id);

			model.addAttribute("config", config);

		}

		return "admin/config/edit";

	}

	@RequestMapping("/edit.do")
	public String edit(Short id, Config config) throws Exception {

		if (id != null) {

			configService.updateConfigById(id, config);
		} else {

			configService.insertConfig(config);

		}
		return "redirect:index.do";

	}

	@RequestMapping("/delete.do")
	public String delete(Short id) throws Exception {

		configService.deteteConfigById(id);

		return "redirect:index.do";

	}

	@RequestMapping(value = "/checkconfigname", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkConfigName(String name) throws Exception {
		Status status = null;

		long row = configService.checkConfigName(name);
		if (row > 0) {

			status = new Status();
			status.setStatusCode(0);
			status.setMessage("配置名称重复，请重新填写");
		} else {

			status = new Status();
			status.setStatusCode(1);
			status.setMessage("配置名称不重复，请继续操作");
		}

		return JacksonUtil.bean2Json(status);

	}
	
	@RequestMapping(value = "/changetime", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String changeTime(Integer id,String time) throws Exception {
		Status status = null;
		Config config=new Config();
		config.setId(Short.valueOf(id.toString()));
		config.setValue(time);
	  int	row =configService.updateConfigById(Short.valueOf(id.toString()), config);
	
		if (row > 0) {
			status = new Status();
			status.setStatusCode(1);
			status.setMessage("修改成功，请继续操作");

		
		} else {

			status = new Status();
			status.setStatusCode(0);
			status.setMessage("修改错误，请联系管理员");
		}

		return JacksonUtil.bean2Json(status);

	}

}
