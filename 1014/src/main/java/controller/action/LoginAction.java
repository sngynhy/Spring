package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ActionForward forward = null;
		
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		
		mVO.setId(request.getParameter("id"));
		mVO.setPw(request.getParameter("pw"));
		
		if (mDAO.login(mVO) != null) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", mVO.getId());
			
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 실패!');history.go(-1)</script>");
		}
		return forward;
	}
}
