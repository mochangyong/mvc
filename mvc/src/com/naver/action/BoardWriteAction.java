package com.naver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./jsp/board_write.jsp");
			
			return forward;
	}

}
