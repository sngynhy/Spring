package controller.action;

import java.io.IOException;

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
		
		bDAO.insertBoard(bVO);
		
//		forward.setPath("selectOneBoard.do?wpk=" + request.getParameter("wpk"));
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}
}
