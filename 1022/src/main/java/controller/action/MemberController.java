package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.member.MemberService;
import model.member.MemberVO;

//���� �������� ���� ��Ʈ�ѷ� ����
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// HM�� ����
	@RequestMapping(value="/login.do", method=RequestMethod.POST) // post ��û ��� - ���� action���� ��쿡�� ��û ��Ŀ� ���� �ٸ��� ó�� ����
	public String login(HttpServletRequest request, MemberVO vo) throws Exception {
		
		if (vo.getId()==null || vo.getId().equals("")) { // �Է°��� ���� ��� ����ó��
			throw new Exception("���̵� �Է°� ���� ����");
//			throw new IllegalArgumentException("���̵� �Է°� ���� ����"); // throws ó������ �ʰ� ���� ó��
		}
		
		if (memberService.login(vo) != null) { // �α��� ����
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", vo.getId());
			return "redirect:main.do";
		} else {
			return "redirect:login.jsp";
		}
	}
	
	// get ��û ��� - index.jsp �α����Ϸ� ���� -> �Խ�Ʈ�� ID�� PW ���� - ������
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String geustLogin(@ModelAttribute("guest") MemberVO vo) throws Exception { // @ModelAttribute("guest") MemberVO vo : MemberVO�� �̸��� guest�� ����
		vo.setId("guest");
		vo.setPw("1234");
		return "login.jsp";
	}
	
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/insertMember.do")
	public String insertMember(MemberVO vo) throws Exception {		
		if (memberService.insertMember(vo)) {
			return "index.jsp";
		} else {
			return "signup.jsp";
		}
	}
	
	@RequestMapping("/checkID.do")
//	public ModelAndView checkID(HttpServletRequest request, HttpServletResponse response, MemberDAO dao, ModelAndView mav) throws Exception {
	public String checkID(@RequestParam(value="id",defaultValue="",required=false) String id, HttpServletResponse response) throws Exception {
//		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		if (id == null || id == "") { // �Է°��� ���� ���
			out.println("null");
		} else {
			out.println(memberService.checkID(id));
		}
		return "signup.jsp";
	}
}
