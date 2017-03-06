package com.eshutech.authority;


import com.eshutech.biz.entity.SysUser;
import com.eshutech.biz.service.SysUserService;
import com.eshutech.biz.util.EncodeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import static com.eshutech.biz.constant.Constants.HASH_ALGORITHM;
import static com.eshutech.biz.constant.Constants.HASH_INTERATIONS;

/**
 * shiro的认证授权域
 * @author yuqs
 * @since 0.1
 */
public class ShiroAuthorizingRealm extends AuthorizingRealm {
	private static Log log = LogFactory.getLog(ShiroAuthorizingRealm.class);

	@Resource
	private SysUserService sysUserService;

    
	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	/**
	 * 构造函数，设置安全的初始化信息
	 */
	public ShiroAuthorizingRealm() {
		super();
		setAuthenticationTokenClass(UsernamePasswordToken.class);
	}

	/**
	 * 获取当前认证实体的授权信息（授权包括：角色、权限）
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取当前登录的用户名
		ShiroPrincipal subject = (ShiroPrincipal)super.getAvailablePrincipal(principals);
		String username = subject.getUsername();
		Integer userId = subject.getId();
		log.info("用户【" + username + "】授权开始......");
		try {
			if(!subject.isAuthorized()) {
				//根据用户名称，获取该用户所有的权限列表
//				List<String> authorities = userService.getAuthoritiesName(userId);
//				List<String> rolelist = userService.getRolesName(userId);
//				subject.setAuthorities(authorities);
//				subject.setRoles(rolelist);
				subject.setAuthorized(true);
				log.info("用户【" + username + "】授权初始化成功......");
				log.info("用户【" + username + "】 角色列表为：" + subject.getRoles());
//				log.info("用户【" + username + "】 权限列表为：" + subject.getAuthorities());
			} else {
				log.info("用户【" + username + "】已授权......");
			}
		} catch(RuntimeException e) {
			throw new AuthorizationException("用户【" + username + "】授权失败");
		}
		//给当前用户设置权限
//		info.addStringPermissions(subject.getAuthorities());
		info.addRoles(subject.getRoles());
		return info;
	}

	/**
	 * 根据认证方式（如表单）获取用户名称、密码
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		log.info(upToken.getUsername());
		log.info(String.valueOf(upToken.getPassword()));

		if (username == null) {
			log.warn("用户名不能为空");
			throw new AccountException("用户名不能为空");
		}

		SysUser user = null;
		try {
			user = sysUserService.findUserByName(username);
		} catch(Exception ex) {
			log.warn("获取用户失败\n" + ex.getMessage());
		}
		if (user == null) {
		    log.warn("用户不存在");
		    throw new UnknownAccountException("用户不存在");
		}
		if(user.getEnabled() == null || "2".equals(user.getEnabled())) {
		    log.warn("用户被禁止使用");
		    throw new UnknownAccountException("用户被禁止使用");
		}
		log.info("用户【" + username + "】取值成功");
		log.info(user.getPassword());
		log.info(user.getSalt());
		byte[] salt = EncodeUtils.hexDecode(user.getSalt());
		ByteSource byteSource = ByteSource.Util.bytes(salt);
		log.info(byteSource.toHex());
		ShiroPrincipal subject = new ShiroPrincipal(user);
//		List<String> authorities = userService.getAuthoritiesName(user.getId());
//		List<String> rolelist = userService.getRolesName(user.getId());
//		subject.setAuthorities(authorities);
//		subject.setRoles(rolelist);
//		subject.setAuthorized(true);
		return new SimpleAuthenticationInfo(subject, user.getPassword(), byteSource, getName());



		//UsernamePasswordToken对象用来存放提交的登录信息
//		UsernamePasswordToken uptoken=(UsernamePasswordToken) token;
//		//查出是否有此用户
//		SeUser user=userService.findUserByName(uptoken.getUsername());
//		if(user!=null){
//			//若存在，将此用户存放到登录认证info中
//			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
//		}
//		return null;
	}
	
//	@SuppressWarnings("static-access")
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(HASH_ALGORITHM);
		matcher.setHashIterations(HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}

}
