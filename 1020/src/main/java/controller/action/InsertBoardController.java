package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class InsertBoardController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		BoardVO bVO = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		
		bVO.setId((String)session.getAttribute("sessionID"));
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		
		int wpk = bDAO.insertBoard(bVO);
		
		if (wpk == -1) { // insert ???? ??
			return "insertBoard";
		} else {
			return "selectBoard.do?wpk=" + wpk;
		}
	}
}
