package com.atom.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atom.crm.mapper.BaseDictDao;
import com.atom.crm.pojo.BaseDict;
import com.atom.crm.service.BaseDictService;

@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {
		
	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> selectBaseDictListByCode(String code) {
		
		return baseDictDao.selectBaseDictListByCode(code);
	}
	
}
