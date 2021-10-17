package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class SelectOneBoardAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		bVO.setWpk(Integer.parseInt(request.getParameter("wpk")));
		
		BoardVO data = bDAO.getBoard(bVO);
		request.setAttribute("data", data);
		
		forward.setPath("readBoard.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
