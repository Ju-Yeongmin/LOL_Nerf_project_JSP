package hae.nerf.lol;

import java.net.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

import java.io.*;

public class test {
	public static void main(String[] args) throws IOException, JSONException {
		
		String name ="돌아온 왕오빠";
		String key ="RGAPI-830d636f-46bb-4598-8bf0-8f04d616d083";
		
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
		String puid = (String)byName.get("puuid");
		System.out.println(puid);
		
		url = new URL("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/smlK5hy2uOcmezQoZLkZZwg9mw3_CLkQYKN42M105ia1U_0m1ccg92CFnRvq7PA2ROIa6pLxIfVbUg/ids?start=0&count=20&api_key=RGAPI-830d636f-46bb-4598-8bf0-8f04d616d083");
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		sb = new StringBuilder();
		line="";
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		JSONArray matchesID = new JSONArray(sb.toString());
		System.out.println(matchesID);
		
		for (int i=0;i<matchesID.length();i++) {
			String matchID = (String)matchesID.get(i);
			url = new URL("https://asia.api.riotgames.com/lol/match/v5/matches/"+matchID+"?api_key="+key);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			sb = new StringBuilder();
			line="";
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject meta = (JSONObject) obj.get("metadata");
			JSONArray howPart = (JSONArray)meta.get("participants");
			
			int p=0;
			for (int j=0;j<howPart.length();j++) {
				String part = (String)howPart.get(j);
				
				if(part.equals("smlK5hy2uOcmezQoZLkZZwg9mw3_CLkQYKN42M105ia1U_0m1ccg92CFnRvq7PA2ROIa6pLxIfVbUg")) {
					p = i;
					break;
				}
			}
		}
//		HttpURLConnection conn1 = (HttpURLConnection) url.openConnection();
//		conn1.setRequestMethod("GET");
//		conn1.setRequestProperty("Content-type", "application/json");
//		System.out.println(conn.getResponseCode());
//		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//		StringBuilder sb = new StringBuilder();
//		String line;
//		while ((line = rd.readLine()) != null) {
//			sb.append(line);
//		}
//		rd.close();
//		conn.disconnect();
		
//		JSONObject obj = new JSONObject(sb.toString());
//		JSONObject meta = (JSONObject) obj.get("metadata");
//		JSONArray howPart = (JSONArray)meta.get("participants");
//		
//		int p=0;
//		for (int i=0;i<howPart.length();i++) {
//			String part = (String)howPart.get(i);
//			
//			if(part.equals("smlK5hy2uOcmezQoZLkZZwg9mw3_CLkQYKN42M105ia1U_0m1ccg92CFnRvq7PA2ROIa6pLxIfVbUg")) {
//				p = i;
//				break;
//			}
//		}
//		
//		System.out.println(p);
//		JSONObject obj2 = (JSONObject) obj.get("info");
//		System.out.println(obj2.get("queueId"));
//		JSONArray obj3 = (JSONArray) obj2.get("participants");
//		JSONObject memInfo = (JSONObject)obj3.get(p);
//		
//		System.out.println(memInfo.get("deaths"));
	}
}