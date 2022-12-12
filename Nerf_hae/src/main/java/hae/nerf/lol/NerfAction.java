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
		
		// 한번만 넣으면 쓸일없어서 주석해놨습니다 필요할때 db데이터 날리고 실행해주세요
//		dao.championJsonParsing();
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/nerfMain.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
