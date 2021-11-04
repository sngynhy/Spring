package controller.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/*
mvc���ӽ����̽����� @ControllerAdvice,@ExceptionHandler�� �غ��
@ControllerAdvice���� ����Ͻ��޼�������� ���ܹ߻��� @ExceptionHandler����ȣ���
*/
// ���� ó�� Ŭ���� - ������̼����� �����ϱ�
@ControllerAdvice("controller.action") // ("���ܰ� �߻��Ǵ� ����Ͻ� �޼��尡 �ִ� Ŭ������")
public class CommonExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handlerNullPointerException(Exception e) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("excep/error.jsp");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("excep/error.jsp");
		return mav;

	}
}
