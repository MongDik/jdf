package com.mong.jdf.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mong.jdf.admin.dao.StudentMapper;
import com.mong.jdf.admin.model.StudentEntity;

@Controller
public class TestController {

	@Autowired
	private StudentMapper studentMapper;

	@RequestMapping(value = "index.do")
	public void indexPage() {
		StudentEntity entity = studentMapper.getStudent("10000013");
		System.out.println("name：" + entity.getStudentName());
		System.out.println("123");
	}
}
