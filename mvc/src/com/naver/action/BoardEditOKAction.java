package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardDAO;
import com.naver.model.BoardBean;

public class BoardEditOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		String board_name =request.getParameter("board_name");
		String board_title =request.getParameter("board_title");
		String board_cont =request.getParameter("board_cont");
		String board_pwd = request.getParameter("board_pwd");
		
		BoardDAO bd= new BoardDAO();
		
		BoardBean db_pwd =bd.getBoardCont(board_no);
		
		if(db_pwd.getBoard_pwd().equals(board_pwd)){
			BoardBean eb= new BoardBean();
			eb.setBoard_name(board_name); eb.setBoard_no(board_no);
			eb.setBoard_title(board_title); eb.setBoard_cont(board_cont);
			
			int re= bd.editBoard(eb);
			if(re==1){
response.sendRedirect("board_cont.do?board_no="+board_no+
					"&state=cont");
				
				
			}else{
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.go(-1)");
			out.println("</script>");
			}
		}else{
			out.println("<script>");
			out.println("alert('비번이 다릅니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		
		return null;
		
	}

}
