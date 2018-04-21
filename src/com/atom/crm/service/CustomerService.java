package com.atom.crm.service;

import com.atom.common.utils.Page;
import com.atom.crm.pojo.Customer;
import com.atom.crm.pojo.QueryVo;

public interface CustomerService {
	
	//通过四个条件 查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	public void updateCustomerById(Customer customer);
	public void deleteCustomerById(Integer id);
}
