package hae.nerf.lol;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import hae.nerf.db.NerfDAO;

public class FightRecordAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse responese) throws Exception {
		System.out.println(" M : FightRecordAction_execute() 호출 ");
		
		String name = request.getParameter("summonerID");
		name = name.replaceAll(" ", "");
		
		
		String key ="RGAPI-9fb87797-63cd-424b-92bc-bf27d4130a75";
		
		URL url = new URL("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+URLEncoder.encode(name,"UTF-8")+"?api_key="+key);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		JSONObject byName = new JSONObject(sb.toString());
		request.setAttribute("level", byName.get("summonerLevel")); 
		request.setAttribute("icon", byName.get("profileIconId")); 
		
		NerfDAO dao = new NerfDAO();
		List<HashMap<String,Object>> mList = dao.getMatchesList(name);
		request.setAttribute("mList", mList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./nerf/record.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
