package com.eshutech.admin.action.authority;

import com.eshutech.biz.entity.TblIsvInstances;
import com.eshutech.biz.entity.TblUser;
import com.eshutech.biz.service.IsvInstanceService;
import com.eshutech.biz.service.UserService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private UserService userService;
	@Resource
	private IsvInstanceService isvInstanceService;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index(HttpServletRequest request,Model model,HttpSession session)
	{
		Integer userId = (Integer) session.getAttribute("userId");
		if(null != userId) {
			TblUser loginUser = userService.findOne(userId);
			if (null != loginUser) {
				return "redirect:/manager/index";
			}
		}
		return "manager/login";
	}

	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public String login(@ModelAttribute  TblUser user, Model model, HttpServletRequest request, HttpSession session) {
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
			TblUser loginUser = userService.findUserByName(user.getUsername());
			//过期时间判断
			TblIsvInstances tblIsvInstances = isvInstanceService.findByUserId(loginUser.getId());
			if(null != tblIsvInstances)
			{

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(null!=tblIsvInstances.getExpiredOn()) {
					try {

						Date date = format.parse(tblIsvInstances.getExpiredOn());
						if (date.before(new Date())) {
							log.info("实例已过期");
							model.addAttribute("error", "登录失败，您输入的账号已过期");
							return "manager/login";
						}
					} catch (ParseException e) {
						e.printStackTrace();
						model.addAttribute("error", "登录失败，您输入的账号已失效");
						return "manager/login";
					}
				}
			}
			loginUser.setModifyTime(new Date());
			userService.updateUser(loginUser);
			session.setAttribute("nick",loginUser.getFullname());
			session.setAttribute("userId",loginUser.getId());
			session.setAttribute("username",loginUser.getUsername());
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
			TblUser loginUser = userService.findOne(userId);
			if (null != loginUser) {
				return "redirect:/manager/index";
			}
		}
		return "manager/login";
	}
}
