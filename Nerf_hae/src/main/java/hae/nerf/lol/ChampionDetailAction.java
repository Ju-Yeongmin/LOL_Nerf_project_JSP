package hae.nerf.lol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChampionDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest resquest, HttpServletResponse responese) throws Exception {
		System.out.println(" M : ChampionDetailAction.execute() 호출 ");
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/championDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
