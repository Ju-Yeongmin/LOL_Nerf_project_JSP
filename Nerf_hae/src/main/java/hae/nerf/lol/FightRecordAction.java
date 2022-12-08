package hae.nerf.lol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FightRecordAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest resquest, HttpServletResponse responese) throws Exception {
		System.out.println(" M : FightRecordAction_execute() 호출 ");
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/record.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
