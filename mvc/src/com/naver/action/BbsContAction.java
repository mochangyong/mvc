package com.naver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BbsDAO;
import com.naver.model.BbsBean;

public class BbsContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int bbs_no = Integer.parseInt(request.getParameter("bbs_no"));
		
		String state = request.getParameter("state");
		
		BbsDAO bd=new BbsDAO();
		
		if(state.equals("cont")){
			bd.updatehit(bbs_no);
		}
		BbsBean bcont =new BbsBean();
		
		bcont=bd.getbbsCont(bbs_no);
		
		request.setAttribute("bcont", bcont);
		
		String bbs_cont = bcont.getBbs_cont().replace("\n", "<br/>");
		
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		if(state.equals("cont")){
			request.setAttribute("bbs_cont", bbs_cont);
			forward.setPath("./jsp/bbs_cont.jsp");
		}else if(state.equals("edit")){
			forward.setPath("./jsp/bbs_edit.jsp");
		}else if(state.equals("del")){
			forward.setPath("./jsp/bbs_delete.jsp");
		}
		
		
		return forward;
	}

}
