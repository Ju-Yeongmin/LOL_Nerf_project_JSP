package hae.nerf.lol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hae.nerf.db.NerfDAO;

public class ChampionInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest resquest, HttpServletResponse responese) throws Exception {
		System.out.println(" M : ChampionInfoAction.execute() 호출 ");
		
		NerfDAO dao = new NerfDAO();
		dao.getOPGG();
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/championInfo.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
