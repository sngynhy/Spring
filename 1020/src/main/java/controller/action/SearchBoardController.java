package controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Controller;
import model.board.BoardDAO;
import model.board.BoardVO;

public class SearchBoardController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardVO bVO = new BoardVO();
		bVO.setType(request.getParameter("type"));
		bVO.setKeyword(request.getParameter("keyword"));
		
		BoardDAO bDAO = new BoardDAO();
		
		List<BoardVO> datas =  bDAO.getBoardList(bVO);
		request.setAttribute("datas", datas);

		return "main.jsp";
	}
}
