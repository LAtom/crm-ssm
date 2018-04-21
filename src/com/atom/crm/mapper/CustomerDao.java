package com.atom.crm.mapper;

import java.util.List;

import com.atom.crm.pojo.BaseDict;
import com.atom.crm.pojo.Customer;
import com.atom.crm.pojo.QueryVo;

public interface CustomerDao {
	
	//根据类别代码查询数据
	public List<BaseDict> selectBaseDictListByCode(String code);
	
	//总条数
	public Integer customerCountByQueryVo(QueryVo vo);
	
	//分页结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	
	//通过ID查询客户
	public Customer selectCustomerById(Integer id);
	
	//修改客户通过ID
	public void updateCustomerById(Customer customer);
	
	//通过ID 删除客户
	public void deleteCustomerById(Integer id);

	
}
