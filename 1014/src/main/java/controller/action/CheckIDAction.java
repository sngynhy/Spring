package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;

public class CheckIDAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward forward = null;
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		MemberDAO mDAO = new MemberDAO();

		if (id == null || id == "") { // �Է°��� ���� ���
			out.println("null");
		} else {
			out.println(mDAO.checkID(request.getParameter("id")));
		}
		return forward;
	}
}
