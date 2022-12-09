package hae.nerf.lol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hae.nerf.db.NerfDAO;

public class NerfAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest resquest, HttpServletResponse responese) throws Exception {
		System.out.println(" M : NerfAction.execute() 호출! ");
		
		// test 메서드
		NerfDAO dao = new NerfDAO();
		dao.test();
		
		dao.championJsonParsing();
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/nerfMain.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
