package hae.nerf.lol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hae.nerf.db.CrawlingVO;
import hae.nerf.db.NerfDAO;

public class ChampionUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest resquest, HttpServletResponse responese) throws Exception {
		System.out.println(" M : ChampionUpdateAction.execute() ");
		
		NerfDAO dao = new NerfDAO();
		dao.removeChampionInfo();
		
		// 크롤링 값 저장(탑)
		List<CrawlingVO> voTOP = dao.getOPGGtop();
		dao.insertChampionInfo(voTOP);
		// 크롤링 값 저장(정글)
		List<CrawlingVO> voJUG = dao.getOPGGjug();
		dao.insertChampionInfo(voJUG);
		// 크롤링 값 저장(미드)
		List<CrawlingVO> voMID = dao.getOPGGmid();
		dao.insertChampionInfo(voMID);
		// 크롤링 값 저장(원딜)
		List<CrawlingVO> voADC = dao.getOPGGadc();
		dao.insertChampionInfo(voADC);
		// 크롤링 값 저장(서폿)
		List<CrawlingVO> voSUP = dao.getOPGGsup();
		dao.insertChampionInfo(voSUP);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./ChampionInfo.hae");
		forward.setRedirect(true);
		
		return forward;
	}

}
