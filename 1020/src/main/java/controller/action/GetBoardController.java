package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class GetBoardController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		bVO.setWpk(Integer.parseInt(request.getParameter("wpk")));
		
		BoardVO data = bDAO.getBoard(bVO);
		request.setAttribute("data", data);
		
		return "readBoard.jsp";
	}
}
