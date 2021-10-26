package controller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.board.BoardDAO;
import model.board.BoardVO;

//높은 응집도를 위한 컨트롤러 통합
@Controller
public class BoardController {
	
	@ModelAttribute("sm")
	public Map<String, String> searchMap() {
		Map<String, String> sm = new HashMap<String, String>();
		sm.put("제목", "title");
		sm.put("내용", "content");
		sm.put("작성자", "id");
		return sm;
	}
	
//	@RequestMapping("/searchBoard.do")
//	public String searchBoard(BoardVO vo, BoardDAO dao, Model model) throws Exception {		
//		List<BoardVO> datas =  dao.getBoardList(vo);
//		model.addAttribute("datas", datas);
//		return "main.jsp";
//	}
	
	@RequestMapping("/main.do")
	public String getBoardList(BoardDAO dao, BoardVO vo, Model model) throws Exception {
		List<BoardVO> datas = dao.getBoardList(vo); // 게시글 전체 조회
		model.addAttribute("datas", datas); // 정보 저장 - setAttribute의 역할
		return "main.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDAO dao, BoardVO vo, Model model) throws Exception {
		BoardVO data = dao.getBoard(vo);		
		model.addAttribute("data", data);
		return "readBoard.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(HttpServletRequest request, BoardVO vo, BoardDAO dao) throws Exception { // BoardVO, DAO를 바인드 변수처럼 사용		
		dao.insertBoard(vo);
		return "redirect:main.do";
		
//		HttpSession session = request.getSession();
//		
//		BoardVO bVO = new BoardVO();
//		BoardDAO bDAO = new BoardDAO();
//		
//		bVO.setId((String)session.getAttribute("sessionID"));
//		bVO.setTitle(request.getParameter("title"));
//		bVO.setContent(request.getParameter("content"));
//		
//		int wpk = bDAO.insertBoard(bVO);
//		
//		if (wpk == -1) { // insert 실패 시
//			return "insertBoard.jsp";
//		} else {
//			return "redirect:selectBoard.do?wpk=" + wpk;
//		}
	}

}
