package controller.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import model.board.BoardService;
import model.board.BoardVO;

// ������̼��� ��������ν� �������̽� ����� �����ϴ� ����
// 1. �Ϻ��� POJO Ŭ������ �ȴ�!
// 2. �߻� �޼ҵ��� ���������� ��� (�������̵� X) -> �Լ��� input, output, �Լ��� ������ �����Ӱ� ������ �� �ִ�!

//���� �������� ���� ��Ʈ�ѷ� ����
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("sm")
	public Map<String, String> searchMap() {
		Map<String, String> sm = new HashMap<String, String>();
		sm.put("����", "title");
		sm.put("����", "content");
		sm.put("�ۼ���", "id");
		return sm;
	}
	
	@RequestMapping("/searchBoard.do")
	public String searchBoard(BoardVO vo, Model model) throws Exception {		
		List<BoardVO> datas =  boardService.getBoardList(vo);
		model.addAttribute("datas", datas);
		return "main.jsp";
	}
	
	@RequestMapping("/main.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		List<BoardVO> datas = boardService.getBoardList(vo); // �Խñ� ��ü ��ȸ
		model.addAttribute("datas", datas); // ���� ���� - setAttribute�� ����
		return "main.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		BoardVO data = boardService.getBoard(vo);		
		model.addAttribute("data", data);
		return "readBoard.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(HttpServletRequest request, BoardVO vo) throws Exception {		
		boardService.insertBoard(vo);
		return "redirect:main.do";
	}

}
