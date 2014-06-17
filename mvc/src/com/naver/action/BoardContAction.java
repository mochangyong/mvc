package com.naver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardDAO;
import com.naver.model.BoardBean;

public class BoardContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		String state =request.getParameter("state");
		
		BoardDAO bd=new BoardDAO();
		if(state.equals("cont")){
			bd.updatehit(board_no);
		}
		BoardBean bcont = new BoardBean();
		
				bcont=bd.getBoardCont(board_no);
		String board_cont = bcont.getBoard_cont().replace("/n", "<br/>");
				
		request.setAttribute("bcont", bcont);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		
		if(state.equals("cont")){
			request.setAttribute("board_cont", board_cont);
			forward.setPath("./jsp/board_cont.jsp");
		}else if(state.equals("edit")){
			forward.setPath("./jsp/board_edit.jsp");
		}else if(state.equals("del")){
			forward.setPath("./jsp/board_delete.jsp");
			
		}
		return forward;
	}

}
