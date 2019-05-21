package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.UserinfoDO;
import com.bootdo.system.service.UserinfoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 15:42:48
 */
 
@Controller
@RequestMapping("/system/userinfo")
public class UserinfoController {
	@Autowired
	private UserinfoService userinfoService;
	
	@GetMapping()
	@RequiresPermissions("system:userinfo:userinfo")
	String Userinfo(){
		return "system/userinfo/userinfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:userinfo:userinfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserinfoDO> userinfoList = userinfoService.list(query);
		int total = userinfoService.count(query);
		PageUtils pageUtils = new PageUtils(userinfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:userinfo:add")
	String add(){
	    return "system/userinfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:userinfo:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		UserinfoDO userinfo = userinfoService.get(id);
		model.addAttribute("userinfo", userinfo);
	    return "system/userinfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:userinfo:add")
	public R save( UserinfoDO userinfo){
		if(userinfoService.save(userinfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:userinfo:edit")
	public R update( UserinfoDO userinfo){
		userinfoService.update(userinfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:userinfo:remove")
	public R remove( Integer id){
		if(userinfoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:userinfo:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		userinfoService.batchRemove(ids);
		return R.ok();
	}
	
}
