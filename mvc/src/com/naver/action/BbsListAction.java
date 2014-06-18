package com.naver.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BbsDAO;
import com.naver.model.BbsBean;

public class BbsListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BbsDAO bd=new BbsDAO();

		int listcount = bd.getcount();

		List<BbsBean> blist = bd.getBbsList();

		request.setAttribute("blist", blist);
		request.setAttribute("listcount", listcount);


		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./jsp/bbs_list.jsp");
		return forward;
	
}

}
