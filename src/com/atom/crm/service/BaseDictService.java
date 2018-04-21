package com.atom.crm.service;

import java.util.List;

import com.atom.crm.pojo.BaseDict;

public interface BaseDictService {
	
	
	//根据类别代码查询数据
	public List<BaseDict> selectBaseDictListByCode(String code);
}
