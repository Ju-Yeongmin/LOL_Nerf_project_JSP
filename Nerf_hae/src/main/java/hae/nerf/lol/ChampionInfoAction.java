package hae.nerf.lol;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hae.nerf.db.CrawlingVO;
import hae.nerf.db.NerfDAO;

public class ChampionInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest resquest, HttpServletResponse responese) throws Exception {
		System.out.println(" M : ChampionInfoAction.execute() 호출 ");
		
		NerfDAO dao = new NerfDAO();
		
		// 라인별 데이터 호출
		//탑
		List<CrawlingVO> topChampionInfo = dao.getChampionInfo("top");
		//정글
		List<CrawlingVO> jugChampionInfo = dao.getChampionInfo("jug");
		//미드
		List<CrawlingVO> midChampionInfo = dao.getChampionInfo("mid");
		//원딜
		List<CrawlingVO> adcChampionInfo = dao.getChampionInfo("adc");
		//서폿	
		List<CrawlingVO> supChampionInfo = dao.getChampionInfo("sup");
		
		// request 저장
		resquest.setAttribute("topChampionInfo", topChampionInfo);
		resquest.setAttribute("jugChampionInfo", jugChampionInfo);
		resquest.setAttribute("midChampionInfo", midChampionInfo);
		resquest.setAttribute("adcChampionInfo", adcChampionInfo);
		resquest.setAttribute("supChampionInfo", supChampionInfo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/championInfo.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
