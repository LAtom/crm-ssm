package com.atom.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atom.common.utils.Page;
import com.atom.crm.pojo.BaseDict;
import com.atom.crm.pojo.Customer;
import com.atom.crm.pojo.QueryVo;
import com.atom.crm.service.BaseDictService;
import com.atom.crm.service.CustomerService;

/*
 * 客户管理
 * 
 */
@Controller

public class CustomerController {


	@Autowired
	private BaseDictService baseDictService;

	@Autowired
	private CustomerService customerService;


	//注入在成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;

	/*
	 * 显示用户列表
	 */
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo ,Model model){

		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");

		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);


		//通过四个条件 查询分页对象
		Page<Customer> page=customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);




		return "customer";
	}

	//去修改页面
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id){
		return customerService.selectCustomerById(id);
	}

	//修改保存
	@RequestMapping(value = "/customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		//修改
		customerService.updateCustomerById(customer);
		return "OK";
	}
	//删除

	@RequestMapping(value = "/customer/delete.action")
	public @ResponseBody
	String delete(Integer id){
		//删除
		customerService.deleteCustomerById(id);
		return "OK";

	}


}
