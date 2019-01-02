package cn.canying.ctrls;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.canying.bean.User;
import cn.canying.services.UserService;
import cn.canying.util.PageData;

@Controller
@RequestMapping(value="/user")
public class UserCtls {
	@Autowired
	private UserService userService;
	
	/*@Autowired
	private RedisCache RedisCache;*/
	
	@RequestMapping("/findall")
	@ResponseBody
	public List<User> test(HttpServletRequest request) {
		PageData pd=new PageData(request);
		List<User>list=userService.test();
		/*RedisCache.putObject("list", list);*/
		/*系统使用共享session时候讲数据直接存入session后，可以在Redis中直接查询出来*/
		
		HttpSession session=request.getSession();
		session.setAttribute("list", list);
		return list;
	}
}
