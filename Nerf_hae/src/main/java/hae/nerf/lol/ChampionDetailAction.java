package hae.nerf.lol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hae.nerf.db.NerfDAO;

public class ChampionDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest resquest, HttpServletResponse responese) throws Exception {
		System.out.println(" M : ChampionDetailAction.execute() 호출 ");
		String id = (String) resquest.getAttribute("name");
		
		NerfDAO dao = new NerfDAO();
		
		List championDetailList = dao.getChampionDetail(id);
		
		resquest.setAttribute("cList", championDetailList);		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/championDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
