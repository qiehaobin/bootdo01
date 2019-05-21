package com.bootdo.system.service;

import com.bootdo.system.domain.UserinfoDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 15:42:48
 */
public interface UserinfoService {
	
	UserinfoDO get(Integer id);
	
	List<UserinfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserinfoDO userinfo);
	
	int update(UserinfoDO userinfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
