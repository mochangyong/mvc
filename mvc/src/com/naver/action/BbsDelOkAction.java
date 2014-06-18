package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BbsDAO;
import com.naver.model.BbsBean;

public class BbsDelOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out= response.getWriter();
			request.setCharacterEncoding("UTF-8");
			
			int bbs_no = Integer.parseInt(request.getParameter("bbs_no"));
			String del_pwd = request.getParameter("del_pwd");
			
			BbsDAO bd=new BbsDAO();
			
			BbsBean db_pwd = bd.getbbsCont(bbs_no);
			
			if(db_pwd.getBbs_pwd().equals(del_pwd)){
			
			int re=bd.Delbbs(bbs_no);
			if(re==1){
				response.sendRedirect("bbs_list.do");
			}else{
				out.println("<script>");
				out.println("alert('삭제실패')");
				out.println("history.back()");
				out.println("</script>");
			}
			}else{
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.')");
			out.println("history.back()");
			out.println("</script>");
			}
		return null;
	}

}
