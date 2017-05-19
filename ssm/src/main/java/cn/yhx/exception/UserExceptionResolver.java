package cn.yhx.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class UserExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//handler就是处理器适配器要执行Handler对象
		//解析出异常类型如果该异常类型是系统自定义异常，直接取出异常信息，在错误页面展示
		UserException userException=null;
		if(ex instanceof UserException){
			userException=(UserException)ex;
		}else{
			userException=new UserException("未知错误");
		}
		
		//如果该异常类型不是系统自定义异常，构建一个自定义异常类型(信息为"未知错误")
		String message=userException.getMessage();
		ModelAndView modelAndView =new ModelAndView();
		//将错误信息传到页面
		modelAndView.addObject("message", message);
		//指向错误页面
		modelAndView.setViewName("error");
		return modelAndView;
	}
   
}
