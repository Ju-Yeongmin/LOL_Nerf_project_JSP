package hae.nerf.lol;

import java.net.*;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hae.nerf.db.NerfDAO;

import java.io.*;

public class test {
	public static void main(String[] args) throws IOException, JSONException {
		
		String name ="돌아온 왕오빠";
		String key ="RGAPI-d329c0c0-829a-4340-84f2-482d69190e4b";
		
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
		
		url = new URL("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/"+puid+"/ids?start=0&count=20&api_key="+key);
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
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		for (int i=0;i<3;i++) {
			HashMap<String, Object> hm = new HashMap<String,Object>();
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
			JSONArray Parts = (JSONArray)meta.get("participants");
			
			int p=0;
			
			/** 경기 20개 받아서 등록
			 * 
			 * 
			 */
			for (int j=0;j<Parts.length();j++) {
				
				String part = (String)Parts.get(j);
				
				if(part.equals(puid)) {
					p = j;
					break;
				}
			}
			
			
			JSONObject info = (JSONObject) obj.get("info");
			JSONArray part = (JSONArray) info.get("participants");
			StringBuilder sb4 = new StringBuilder();
			JSONObject memInfo;
			for (int j=0;j<part.length();j++) {
				memInfo = (JSONObject)part.get(j);
				sb4.append(memInfo.get("championName")+",");
			}
			memInfo = (JSONObject)part.get(p);
			JSONArray teams = (JSONArray)info.get("teams");
			JSONObject team;
			if (p<5) {
			team = (JSONObject)teams.get(0);
			} else {
				team = (JSONObject)teams.get(1);
			}
			JSONObject tobj = (JSONObject)team.get("objectives");
			JSONObject tchamp = (JSONObject)tobj.get("champion");
			JSONObject perks = (JSONObject)memInfo.get("perks");
			JSONArray Styles = (JSONArray)perks.get("styles");
			JSONObject pStyle = (JSONObject)Styles.get(0);
			JSONObject sStyle = (JSONObject)Styles.get(1);
			JSONArray pStyles = (JSONArray)pStyle.get("selections");
			JSONArray sStyles = (JSONArray)sStyle.get("selections");
			StringBuilder sb2 = new StringBuilder();
			sb2.append(pStyle.get("style")+",");
//			sb2.append();
			for (int j=0;j<pStyles.length();j++) {
				JSONObject a = (JSONObject)pStyles.get(j);
				sb2.append(a.get("perk")+",");
			}
			StringBuilder sb3 = new StringBuilder();
			sb3.append(sStyle.get("style")+",");
			for (int j=0;j<sStyles.length();j++) {
				JSONObject a = (JSONObject)sStyles.get(j);
				sb3.append(a.get("perk")+",");
			}
			
			
			
			
			hm.put("matchid", matchID);
			hm.put("win", (Boolean)team.get("win"));
			hm.put("u_num", p);
			hm.put("champion_Name", sb4.substring(0,sb4.toString().length()-1));	
			hm.put("queueid",(int)info.get("queueId"));
			hm.put("kda",(int)memInfo.get("kills")+","+(int)memInfo.get("deaths")+","+(int)memInfo.get("assists"));
			hm.put("team_total_kills", (int) tchamp.get("kills"));
			hm.put("summoner_spell", (int)memInfo.get("summoner1Id")+","+(int)memInfo.get("summoner2Id"));
			hm.put("statPerks",perks.get("statPerks").toString().replaceAll("[{}]", "") );
			hm.put("primary_perks", sb2.substring(0,sb2.toString().length()-1));
			hm.put("sub_perks", sb3.substring(0,sb3.toString().length()-1));
			hm.put("level", (int)memInfo.get("champLevel"));
			hm.put("gold", (int)memInfo.get("goldEarned"));
			hm.put("cs", (int)memInfo.get("totalMinionsKilled"));
			hm.put("playtime", (int)((Long)info.get("gameEndTimestamp")-(Long)info.get("gameStartTimestamp")));
			hm.put("detector_ward",(int)memInfo.getInt("detectorWardsPlaced"));
			hm.put("wardkp", (int)memInfo.get("wardsKilled")+","+(int)memInfo.get("wardsPlaced"));
			hm.put("items",(int)memInfo.get("item0")+","+(int)memInfo.get("item1")+","+(int)memInfo.get("item2")+","
					+(int)memInfo.get("item3")+","+(int)memInfo.get("item4")+","+(int)memInfo.get("item5")+","+(int)memInfo.get("item6"));
			
			NerfDAO dao = new NerfDAO();
			dao.insertMatch(hm);
//			Boolean win = (Boolean)team.get("win");
//			String champName = (String)memInfo.get("championName");
//			int queueId = (int)info.get("queueId");
//			int kills = (int)memInfo.get("kills");
//			int deaths = (int)memInfo.get("deaths");
//			int assists = (int)memInfo.get("assists");
//			int tKills = (int) tchamp.get("kills");
//			int summoner1Id = (int)memInfo.get("summoner1Id");
//			int summoner2Id = (int)memInfo.get("summoner2Id");
//			String statPerks = perks.get("statPerks").toString().replaceAll("[{}]", "");
//			String priStyle = sb2.substring(0,sb2.toString().length()-1);
//			String subStyle = sb3.substring(0,sb3.toString().length()-1);
//			int champLevel = (int)memInfo.get("champLevel");
//			int gold = (int)memInfo.get("goldEarned");
//			int cs = (int)memInfo.get("totalMinionsKilled");
//			int timeStamp = (int)((Long)info.get("gameEndTimestamp")-(Long)info.get("gameStartTimestamp"));
//			int detectWard = (int)memInfo.getInt("detectorWardsPlaced");
//			String wardkp = (int)memInfo.get("wardsKilled")+","+(int)memInfo.get("wardsPlaced");
//			String items = (int)memInfo.get("item0")+","+(int)memInfo.get("item1")+","+(int)memInfo.get("item2")+","
//					+(int)memInfo.get("item3")+","+(int)memInfo.get("item4")+","+(int)memInfo.get("item5")+","+(int)memInfo.get("item6");
			
			
			
			
		}
		
	}
}