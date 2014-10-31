package com.sample.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.model.TestModel;
import com.sample.service.ISampleService;

/**
 * @author sunshine
 * 
 */
@Controller
public class SampleController {

	private static final Logger log = LoggerFactory
			.getLogger(SampleController.class);

	@Resource
	private ISampleService sampleService;
	
	@RequestMapping("/sample.html")
	public String getSampleJsp() {
		log.info("get the jsp file at {}", System.currentTimeMillis());
		return "SampleJsp";
	}
	@RequestMapping("/nofoundPage.html")
	public String getwrongpage() {
		log.info("get the jsp file at {}", System.currentTimeMillis());
		return "SampleJsp00000";
	}

	@RequestMapping("/getftl.html")
	public ModelAndView getSampleftl() {
		log.info("get the ftl file at {}", System.currentTimeMillis());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Sampleftl");
		mav.addObject("info", "something infomation from server");
		// return new ModelAndView("Sampleftl", "info",
		// "something infomation from server.");
		return mav;
	}

	@RequestMapping("/sample")
	public Object getSampleJson(final TestModel tm) {
		// springmvc自动转换请求参与， tm对象不会为空，没传的话，里面字段的值是默认值。
		if(tm.getInfo() != null) {
			return tm;
		}
		TestModel xm = new TestModel();
		xm.setStatus(true);
		xm.setInfo(" you get 100 millons..英文对么");
		return xm;
	}

	@RequestMapping("/mapJson")
	public Object getMapJson() {
		Map<String, Object> map = new HashMap<String, Object>(3);
		map.put("status", true);
		map.put("info", "haha, you get 100 millons-100万。");
		return map;
	}

	@RequestMapping("/sample.xml")
	public TestModel getSampleXml() {
		TestModel xm = new TestModel();
		xm.setStatus(true);
		xm.setInfo("this is xml info element 还有中文。");
		return xm;
	}

	@RequestMapping("/sample.config")
	public String getSampleConfig() {
		return "SampleConfig.config";
	}

	@RequestMapping("/sample.swf")
	public String getSampleSwf() {
		return "SampleSwf.swf";
	}

}
