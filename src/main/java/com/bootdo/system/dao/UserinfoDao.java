package com.bootdo.system.dao;

import com.bootdo.system.domain.UserinfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 15:42:48
 */
@Mapper
public interface UserinfoDao {

	UserinfoDO get(Integer id);
	
	List<UserinfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserinfoDO userinfo);
	
	int update(UserinfoDO userinfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
