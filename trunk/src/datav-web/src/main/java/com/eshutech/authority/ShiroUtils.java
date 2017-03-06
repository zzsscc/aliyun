package com.eshutech.authority;

import com.eshutech.biz.entity.TblUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * shiro工具类
 * @author yuqs
 * @since 0.1
 */
public class ShiroUtils {
	/**
	 * 返回当前登录的认证实体ID
	 * @return
	 */
	public static Integer getUserId() {
		ShiroPrincipal principal = getPrincipal();
		if(principal != null) return principal.getId();
		return -1;
	}
	
	public static TblUser getUser() {
		ShiroPrincipal principal = getPrincipal();
		if(principal != null) return principal.getUser();
		return null;
	}
	
	/**
	 * 返回当前登录的认证实体部门ID
	 * @return
	 */
	public static Integer getOrgId() {
		TblUser user = getUser();
		if(user != null && user.getOrg() != null) return user.getOrg();
		return -1;
	}
	
	/**
	 * 获取当前登录的认证实体
	 * @return
	 */
	public static ShiroPrincipal getPrincipal() {
		Subject subject = SecurityUtils.getSubject();
		return (ShiroPrincipal)subject.getPrincipal();
	}
	
	/**
	 * 获取所有组集合
	 * @return
	 */
	public static List<String> getGroups() {
		List<String> groups = new ArrayList<String>();
		Integer orgId = getOrgId();
		ShiroPrincipal principal = getPrincipal();
		if(principal != null) {
			groups.addAll(principal.getRoles());
		}
		if(orgId != null) {
			groups.add(String.valueOf(orgId));
		}
		return groups;
	}
	
	/**
	 * 获取当前认证实体的中文名称
	 * @return
	 */
	public static String getFullname() {
		ShiroPrincipal principal = getPrincipal();
		if(principal != null) return principal.toString();
		return "";
	}
	
	/**
	 * 获取当前认证实体的登录名称
	 * @return
	 */
	public static String getUsername() {
		ShiroPrincipal principal = getPrincipal();
		if(principal != null) return principal.getUsername();
		throw new RuntimeException("user's name is null.");
	}

}
