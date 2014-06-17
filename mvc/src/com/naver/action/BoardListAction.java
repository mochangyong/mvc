package com.naver.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardDAO;
import com.naver.model.BoardBean;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		BoardDAO bd = new BoardDAO();
		
		int listcount =bd.getCount();
		
		List<BoardBean> blist=bd.getList();
		
		request.setAttribute("blist", blist);
		request.setAttribute("listcount",listcount);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./jsp/board_list.jsp");
		return forward;
	}

}
