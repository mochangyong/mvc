package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardDAO;
import com.naver.model.BoardBean;

public class BoardDelOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			
			request.setCharacterEncoding("UTF-8");
			
			int board_no = Integer.parseInt(request.getParameter("board_no"));
			String del_pwd = request.getParameter("del_pwd");
			
			BoardDAO bd= new BoardDAO();
			
			BoardBean db_pwd= bd.getBoardCont(board_no);
		
			if(!db_pwd.getBoard_pwd().equals(del_pwd)){
				out.println("<script>");
				out.println("alert('비번이 다릅니다')");
				out.println("history.back()");
				out.println("</script>");
			}else{
				int re=bd.Delboard(board_no);
				if(re==1){
					response.sendRedirect("board_list.do");
				}else{
					out.println("<script>");
					out.println("alert('삭제 실패')");
					out.println("history.back()");
					out.println("</script>");
				}
			}
		
		return null;
	}

}
