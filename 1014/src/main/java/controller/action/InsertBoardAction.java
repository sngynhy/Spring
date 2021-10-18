package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.board.BoardDAO;
import model.board.BoardVO;

public class InsertBoardAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		
		bVO.setId((String)session.getAttribute("sessionID"));
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		
		int wpk = bDAO.insertBoard(bVO);
		
		if (wpk == -1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('등록 실패!');history.go(-1)</script>");
		} else {
			forward.setPath("selectBoard.do?wpk=" + wpk);
			forward.setRedirect(true);
		}
		return forward;
	}
}
