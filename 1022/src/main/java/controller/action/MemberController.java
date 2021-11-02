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

//높은 응집도를 위한 컨트롤러 통합
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// HM의 역할
	@RequestMapping(value="/login.do", method=RequestMethod.POST) // post 요청 방식 - 같은 action값인 경우에도 요청 방식에 따라 다르게 처리 가능
	public String login(HttpServletRequest request, MemberVO vo) throws Exception {
		
		if (vo.getId()==null || vo.getId().equals("")) { // 입력값이 없을 경우 예외처리
			throw new Exception("아이디 입력값 공백 에러");
//			throw new IllegalArgumentException("아이디 입력값 공백 에러"); // throws 처리하지 않고 예외 처리
		}
		
		if (memberService.login(vo) != null) { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", vo.getId());
			return "redirect:main.do";
		} else {
			return "redirect:login.jsp";
		}
	}
	
	// get 요청 방식 - index.jsp 로그인하러 가기 -> 게스트용 ID와 PW 제공 - 포폴용
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String geustLogin(@ModelAttribute("guest") MemberVO vo) throws Exception { // @ModelAttribute("guest") MemberVO vo : MemberVO의 이름을 guest로 설정
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
		
		if (id == null || id == "") { // 입력값이 없는 경우
			out.println("null");
		} else {
			out.println(memberService.checkID(id));
		}
		return "signup.jsp";
	}
}
