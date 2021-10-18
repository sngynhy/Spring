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

// control.jsp 역할
// FrontController
// 서블릿 클래스
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
		
		/* 1. 클라이언트의 "요청"을 분석 */
		String uri = request.getRequestURI(); // uri : /FrontController/main.do
		String cp = request.getContextPath(); // cp :/FrontController
		String action = uri.substring(cp.length()); // action : /main/do - 실제 액션값만 추출 -> 유지 보수성 증가
		
		/* 2. control을 매핑하는 역할 == if(action.equals("main")) */
		ActionForward forward = null;
		
		if (action.equals("/main.do")) { // 메인 - 게시글 목록 출력
			forward = new MainAction().execute(request, response);
		} else if (action.equals("/login.do")) { // 로그인
			forward = new LoginAction().execute(request, response);
		} else if (action.equals("/logout.do")) { // 로그아웃
			forward = new LogoutAction().execute(request, response);
		} else if (action.equals("/insertMember.do")) { // 회원가입
			forward = new InsertMemberAction().execute(request, response);
		} else if (action.equals("/checkID.do")) {
			forward = new CheckIDAction().execute(request, response);
		} else if (action.equals("/insertBoard.do")) { // 게시글 작성
			forward = new InsertBoardAction().execute(request, response);
		} else if (action.equals("/searchBoard.do")) { // 게시글 검색
			forward = new SearchBoardAction().execute(request, response);
		} else if (action.equals("/selectBoard.do")) { // 게시글 보기
			forward = new SelectOneBoardAction().execute(request, response);
		} else { // 만약 잘못된 action값인 경우
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/error/errer404.jsp");
		}
		
		/* 3. 클라이언트에게 결과 화면 출력 */
		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식
				response.sendRedirect(forward.getPath());
			} else { // forward 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath()); // 최종 경로
				dispatcher.forward(request, response);
			}
		}
	}
}
