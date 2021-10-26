package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.member.MemberDAO;
import model.member.MemberVO;

//높은 응집도를 위한 컨트롤러 통합
@Controller
public class MemberController {
	// HM의 역할
	@RequestMapping(value="/login.do", method=RequestMethod.POST) // post 요청 방식 - 같은 action값인 경우에도 요청 방식에 따라 다르게 처리 가능
	public String login(HttpServletRequest request, MemberDAO dao, MemberVO vo) throws Exception {
		if (dao.login(vo) != null) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", vo.getId());
			return "redirect:main.do";
		} else {
			return "redirect:login.jsp";
		}
	}
	
	// get 요청 방식 - index.jsp 로그인하러 가기 -> 게스트용 ID와 PW 제공 - 포폴용
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String geustLogin(@ModelAttribute("guest") MemberVO vo) throws Exception { // @ModelAttribute("guest") MemberVO vo : MemberVO의 이름을 guset로 설정
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
	public String insertMember(MemberDAO dao, MemberVO vo) throws Exception {		
		if (dao.insertMember(vo)) {
			return "index.jsp";
		} else {
			return "signup.jsp";
		}
	}
	
	@RequestMapping("/checkID.do")
//	public ModelAndView checkID(HttpServletRequest request, HttpServletResponse response, MemberDAO dao, ModelAndView mav) throws Exception {
	public String checkID(@RequestParam(value="id",defaultValue="",required=false) String id, HttpServletResponse response, MemberDAO dao) throws Exception {
//		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		if (id == null || id == "") { // 입력값이 없는 경우
			out.println("null");
		} else {
			out.println(dao.checkID(id));
		}
		return "signup.jsp";
	}
}
