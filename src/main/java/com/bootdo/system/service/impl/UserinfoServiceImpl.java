package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.UserinfoDao;
import com.bootdo.system.domain.UserinfoDO;
import com.bootdo.system.service.UserinfoService;



@Service
public class UserinfoServiceImpl implements UserinfoService {
	@Autowired
	private UserinfoDao userinfoDao;
	
	@Override
	public UserinfoDO get(Integer id){
		return userinfoDao.get(id);
	}
	
	@Override
	public List<UserinfoDO> list(Map<String, Object> map){
		return userinfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userinfoDao.count(map);
	}
	
	@Override
	public int save(UserinfoDO userinfo){
		return userinfoDao.save(userinfo);
	}
	
	@Override
	public int update(UserinfoDO userinfo){
		return userinfoDao.update(userinfo);
	}
	
	@Override
	public int remove(Integer id){
		return userinfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return userinfoDao.batchRemove(ids);
	}
	
}
