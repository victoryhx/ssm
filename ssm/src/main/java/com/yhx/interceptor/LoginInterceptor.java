package com.yhx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

//preHandle������˳��ִ��
//postHandle��afterCompletion�����������õ�����˳��ִ��
//������1���У�������2preHandle�Ż����
//������2 preHandle�����У�������2 postHandle��afterCompletion�������
public class LoginInterceptor implements
org.springframework.web.servlet.HandlerInterceptor {
	 //ִ��handler���ִ�д˷���
		//ͳһ�쳣����Exception,ͳһ��־����
		public void afterCompletion(HttpServletRequest arg0,
				HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("LoginIntercepter...afterCompletion");

		}
	    //����handler����֮�󣬷���modelAndView֮ǰִ��
		//Ӧ�ó�����modelAndView�����������õ�ģ������(����˵�����)�����ﴫ����ͼ��Ҳ����������ͳһָ����ͼ
		public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
				Object arg2, ModelAndView arg3) throws Exception {
			// TODO Auto-generated method stub
			System.out.println("LoginIntercepter...postHandle");

		}
	    //����handler֮ǰִ��
		//���������֤���������Ȩ
		//���������֤�������֤ͨ����ʾ��ǰ�û�û�е�¼����Ҫ�˷������ز�������ִ��
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
				Object arg2) throws Exception {
			System.out.println("LoginIntercepter...preHandle");
			
			//��ȡ�����url
			String url=request.getRequestURI();
			//�ж�url�ǲ��ǹ�����ַ��ʵ��ʹ��ʱ��������ַ�����������ļ��У�
			//���﹫����ַ�ǵ�¼�ύ�ĵ�ַ
			if(url.indexOf("login.action")>=0){
				 //ִ�е������ʾ�û������Ҫ��֤����ת��¼ҳ��
			  //  request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
				return true;
			}
			//�ж�session
		    HttpSession session=request.getSession();
		    //��session��ȡ���û������Ϣ
		    String username=(String) session.getAttribute("username");
		    if(username!=null){
		    	//��ݴ��ڣ�����
		    	return true;
		    }
		    //ִ�е������ʾ�û������Ҫ��֤����ת��¼ҳ��
		    request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
			// return false ��ʾ���� �����½���
			// return true ��ʾ����
			return true;
		}
}
