package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BbsDAO;
import com.naver.model.BbsBean;

public class BbsWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//int bbs_no = Integer.parseInt(request.getParameter("bbs_no"));
		String bbs_name =request.getParameter("bbs_name");
		String bbs_title = request.getParameter("bbs_title");
		String bbs_cont = request.getParameter("bbs_cont");
		String bbs_pwd = request.getParameter("bbs_pwd");
		
		BbsDAO bd= new BbsDAO();
		
		BbsBean b = new BbsBean();
		
		//b.setBbs_no(bbs_no); 
		b.setBbs_name(bbs_name);
		b.setBbs_title(bbs_title); b.setBbs_cont(bbs_cont);
		b.setBbs_pwd(bbs_pwd);
		
		int re=bd.insertb(b);
		
		if(re==1){
			out.println("<script>");
			out.println("alert('저장성공')");
			out.println("location='bbs_list.do'");
			out.println("</script>");
			
		}else{
			out.println("<script>");
			out.println("alert('저장실패')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		return null;
	}

}
