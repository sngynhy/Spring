package controller.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.ActionForward;
import controller.action.CheckIDAction;
import controller.action.InsertBoardAction;
import controller.action.InsertMemberAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.MainAction;
import controller.action.SearchBoardAction;
import controller.action.SelectOneBoardAction;

// control.jsp ����
// FrontController
// ���� Ŭ����
public class DispatcherServlit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DispatcherServlit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 1. Ŭ���̾�Ʈ�� "��û"�� �м� */
		String uri = request.getRequestURI(); // uri : /FrontController/main.do
		String cp = request.getContextPath(); // cp :/FrontController
		String action = uri.substring(cp.length()); // action : /main/do - ���� �׼ǰ��� ���� -> ���� ������ ����
		
		/* 2. control�� �����ϴ� ���� == if(action.equals("main")) */
		ActionForward forward = null;
		
		if (action.equals("/main.do")) { // ���� - �Խñ� ��� ���
			forward = new MainAction().execute(request, response);
		} else if (action.equals("/login.do")) { // �α���
			forward = new LoginAction().execute(request, response);
		} else if (action.equals("/logout.do")) { // �α׾ƿ�
			forward = new LogoutAction().execute(request, response);
		} else if (action.equals("/insertMember.do")) { // ȸ������
			forward = new InsertMemberAction().execute(request, response);
		} else if (action.equals("/checkID.do")) {
			forward = new CheckIDAction().execute(request, response);
		} else if (action.equals("/insertBoard.do")) { // �Խñ� �ۼ�
			forward = new InsertBoardAction().execute(request, response);
		} else if (action.equals("/searchBoard.do")) { // �Խñ� �˻�
			forward = new SearchBoardAction().execute(request, response);
		} else if (action.equals("/selectBoard.do")) { // �Խñ� ����
			forward = new SelectOneBoardAction().execute(request, response);
		} else { // ���� �߸��� action���� ���
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/errer404.jsp");
		}
		
		/* 3. Ŭ���̾�Ʈ���� ��� ȭ�� ��� */
		if (forward != null) {
			if (forward.isRedirect()) { // redirect ���
				response.sendRedirect(forward.getPath());
			} else { // forward ���
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); // ���� ���
				dispatcher.forward(request, response);
			}
		}
	}
}
