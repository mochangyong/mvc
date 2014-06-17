package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardDAO;
import com.naver.model.BoardBean;

public class BoardWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			
			
			String board_name = request.getParameter("board_name").trim();
			String board_title = request.getParameter("board_title").trim();
			String board_cont = request.getParameter("board_cont").trim();
			String board_pwd = request.getParameter("board_pwd").trim();
			
			BoardBean b= new BoardBean();
			b.setBoard_name(board_name);   b.setBoard_title(board_title);
			b.setBoard_cont(board_cont);   b.setBoard_pwd(board_pwd);
			
			
			BoardDAO bd= new BoardDAO();
			
			int re=bd.insertBoard(b);
			
			if(re==1){
				out.println("<script>");
				out.println("alert('저장성공')");
				out.println("location='board_list.do'");
				out.println("</script>");
			}else{
				out.println("<script>");
				out.println("alert('저장실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		
		
		return null;
	}

}
