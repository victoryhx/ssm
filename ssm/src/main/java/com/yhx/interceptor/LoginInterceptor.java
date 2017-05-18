package com.yhx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

//preHandle方法按顺序执行
//postHandle和afterCompletion按拦截器配置的逆向顺序执行
//拦截器1放行，拦截器2preHandle才会放行
//拦截器2 preHandle不放行，拦截器2 postHandle和afterCompletion不会放行
public class LoginInterceptor implements
org.springframework.web.servlet.HandlerInterceptor {
	 //执行handler完成执行此方法
		//统一异常处理Exception,统一日志处理
		public void afterCompletion(HttpServletRequest arg0,
				HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("LoginIntercepter...afterCompletion");

		}
	    //进入handler方法之后，返回modelAndView之前执行
		//应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到试图，也可以在这里统一指定试图
		public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
				Object arg2, ModelAndView arg3) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("LoginIntercepter...postHandle");

		}
	    //进入handler之前执行
		//用于身份认证、和身份授权
		//比如身份认证，如果认证通过表示当前用户没有登录，需要此方法拦截不在向下执行
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
				Object arg2) throws Exception {
			System.out.println("LoginIntercepter...preHandle");
			
			//获取请求的url
			String url=request.getRequestURI();
			//判断url是不是公开地址（实际使用时将公开地址配置在配置文件中）
			//这里公开地址是登录提交的地址
			if(url.indexOf("login.action")>=0){
				 //执行到这里表示用户身份需要认证，跳转登录页面
			  //  request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
				return true;
			}
			//判断session
		    HttpSession session=request.getSession();
		    //从session中取出用户身份信息
		    String username=(String) session.getAttribute("username");
		    if(username!=null){
		    	//身份存在，放行
		    	return true;
		    }
		    //执行到这里表示用户身份需要认证，跳转登录页面
		    request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
			// return false 表示拦截 不往下进行
			// return true 表示放行
			return true;
		}
}
