package hae.nerf.lol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hae.nerf.db.CrawlingVO;
import hae.nerf.db.NerfDAO;

public class ChampionInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest resquest, HttpServletResponse responese) throws Exception {
		System.out.println(" M : ChampionInfoAction.execute() 호출 ");
		
		NerfDAO dao = new NerfDAO();
		
		
		
		// 여기 페이지 주석 해제한채로 실행하면 db에 이미 데이터 들어가있어서 추가로 들어갑니다 
		// 나중에 다른페이지로 분리 예정 (갱신버튼)
//		// 크롤링 값 저장(탑)
//		List<CrawlingVO> voTOP = dao.getOPGGtop();
//		dao.insertChampionInfo(voTOP);
//		// 크롤링 값 저장(정글)
//		List<CrawlingVO> voJUG = dao.getOPGGjug();
//		dao.insertChampionInfo(voJUG);
//		// 크롤링 값 저장(미드)
//		List<CrawlingVO> voMID = dao.getOPGGmid();
//		dao.insertChampionInfo(voMID);
//		// 크롤링 값 저장(원딜)
//		List<CrawlingVO> voADC = dao.getOPGGadc();
//		dao.insertChampionInfo(voADC);
//		// 크롤링 값 저장(서폿)
//		List<CrawlingVO> voSUP = dao.getOPGGsup();
//		dao.insertChampionInfo(voSUP);
		
		// 라인별 데이터 호출
		
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/championInfo.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
