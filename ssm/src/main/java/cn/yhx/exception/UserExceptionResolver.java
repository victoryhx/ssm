package cn.yhx.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class UserExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//handler���Ǵ�����������Ҫִ��Handler����
		//�������쳣����������쳣������ϵͳ�Զ����쳣��ֱ��ȡ���쳣��Ϣ���ڴ���ҳ��չʾ
		UserException userException=null;
		if(ex instanceof UserException){
			userException=(UserException)ex;
		}else{
			userException=new UserException("δ֪����");
		}
		
		//������쳣���Ͳ���ϵͳ�Զ����쳣������һ���Զ����쳣����(��ϢΪ"δ֪����")
		String message=userException.getMessage();
		ModelAndView modelAndView =new ModelAndView();
		//��������Ϣ����ҳ��
		modelAndView.addObject("message", message);
		//ָ�����ҳ��
		modelAndView.setViewName("error");
		return modelAndView;
	}
   
}
