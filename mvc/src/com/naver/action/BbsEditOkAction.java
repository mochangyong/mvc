package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BbsDAO;
import com.naver.model.BbsBean;

public class BbsEditOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			request.setCharacterEncoding("UTF-8");
		
			
			int bbs_no = Integer.parseInt(request.getParameter("bbs_no"));
			String bbs_name= request.getParameter("bbs_name");
			String bbs_title =request.getParameter("bbs_title");
			String bbs_cont = request.getParameter("bbs_cont");
			String bbs_pwd = request.getParameter("bbs_pwd");
			
			BbsDAO bd=new BbsDAO();
			
			BbsBean db_pwd = bd.getbbsCont(bbs_no);
			
			
			if(db_pwd.getBbs_pwd().equals(bbs_pwd)){
				
				BbsBean eb= new BbsBean();
				eb.setBbs_no(bbs_no); eb.setBbs_name(bbs_name);
				eb.setBbs_title(bbs_title); eb.setBbs_cont(bbs_cont);
				
				int re= bd.Editbbs(eb);
				if(re==1){
					response.sendRedirect("bbs_cont.do?bbs_no="+bbs_no+"&state=cont");
					}else{
					out.println("<script>");
					out.println("alert('수정실패')");
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
