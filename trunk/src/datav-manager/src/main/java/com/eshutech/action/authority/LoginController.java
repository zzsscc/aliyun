package com.eshutech.action.authority;

import com.eshutech.biz.entity.SysUser;
import com.eshutech.biz.service.SysUserService;
import com.eshutech.utils.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 系统登录Controller
 * @author yuqs
 * @since 0.1
 */
@Controller
public class LoginController extends BaseController{
	private static Log log = LogFactory.getLog(LoginController.class);

	@Resource
	private SysUserService sysUserService;


	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index(HttpServletRequest request,Model model,HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userId");
		if(null != userId) {
			SysUser loginUser = sysUserService.findOne(userId);
			if (null != loginUser) {
				return "redirect:/manager/index";
			}
		}
		return "manager/login";
	}

	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public String login(@ModelAttribute  SysUser user, Model model, HttpServletRequest request, HttpSession session) {
		log.info("Login user=====" + user);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		String remember = WebUtils.getCleanParam(request, "remember");
		log.info("remember=" + remember);
		try {
			if(remember != null && remember.equalsIgnoreCase("on")) {
				token.setRememberMe(true);
			}
			subject.login(token);
			session.setAttribute("username",user.getUsername());
			SysUser loginUser = sysUserService.findUserByName(user.getUsername());
			session.setAttribute("nick",loginUser.getFullname());
			session.setAttribute("userId",loginUser.getId());
			loginUser.setModifyTime(new Date());
			sysUserService.updateUser(loginUser);
			return "redirect:/manager/index";
		} catch(UnknownAccountException ue) {
			token.clear();
			log.info(ue.getMessage());
			model.addAttribute("error", "登录失败，您输入的账号不存在");
			return "manager/login";
		} catch(IncorrectCredentialsException ie) {
			token.clear();
			log.info(ie.getMessage());
			model.addAttribute("username", user.getUsername());
			model.addAttribute("error", "登录失败，密码不匹配");
			return "manager/login";
		}
		catch(RuntimeException re) {
			token.clear();
			log.info("RuntimeException:"+re.getMessage());
			model.addAttribute("username", user.getUsername());
			model.addAttribute("error", "登录失败");
			return "manager/login";
		}
	}


	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public String loginForm(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(null != userId) {
			SysUser loginUser = sysUserService.findOne(userId);
			if (null != loginUser) {
				return "redirect:/manager/index";
			}
		}
		return "manager/login";
	}
}
