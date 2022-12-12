package hae.nerf.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NerfDAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";

	// 디비 연결
	private Connection getConnection() throws Exception {
		Context initCTX = new InitialContext();

		DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/Nerf_hae");

		con = ds.getConnection();

		return con;
	} // 디비 연결

	// 자원 해제
	public void closeDB() {
		System.out.println(" DAO : 연결 자원 해제 ");
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // 자원해제
	
	public void test() {
		System.out.println(" DAO : 테스트 메서드 실행 ");
		
		try {
			con = getConnection();
			sql = "select now()";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println(" 현재 DB 시간 : " + rs.getTimestamp(1));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	/**
	 *	op.gg 크롤링 메서드 (탑)
	 */
	public List<CrawlingVO> getOPGGtop() throws Exception {
		Document doc = Jsoup.connect("https://www.op.gg/champions?region=global&tier=platinum_plus&position=top").get(); //겟방식으로 호출하겠다
		
		Elements c_names = doc.select(".css-jgru8w.e1oulx2j7 .css-cym2o0.e1oulx2j6 a strong"); 
		Elements c_images = doc.select(".css-cym2o0.e1oulx2j6 a img");
		Elements c_tiers = doc.select(".css-ew1afn.e1oulx2j3");
		Elements c_allrate = doc.select(".css-1wvfkid.exo2f211");
		
		List<CrawlingVO> list = new ArrayList<CrawlingVO>();
		
		for (int i = 0; i < c_names.size(); i++) {
//			System.out.println(c_ranks.get(i).text());
//			System.out.println(i);
//			System.out.println(c_names.get(i));
//			System.out.println(c_allrate.get(i));
//			System.out.println(c_tiers.get(i).text());
//			System.out.println("이미지 : " + c_images.get(i).attr("src"));
//			System.out.println("승률 : " + c_allrate.get(i*3).text());
//			System.out.println("픽률 : " + c_allrate.get(i*3+1).text());
//			System.out.println("밴률 : " + c_allrate.get(i*3+2).text());
			Element c_name = c_names.get(i);
			Element c_tier = c_tiers.get(i);
			Element c_image = c_images.get(i);
			Element c_winrate = c_allrate.get(i*3);
			Element c_pickrate = c_allrate.get(i*3+1);
			Element c_banrate = c_allrate.get(i*3+2);
			
			CrawlingVO vo = new CrawlingVO();
			vo.setC_name(c_name.text());
			vo.setC_tier(c_tier.text());
			vo.setC_image(c_image.attr("src"));
			vo.setC_winrate(c_winrate.text());
			vo.setC_pickrate(c_pickrate.text());
			vo.setC_banrate(c_banrate.text());
			vo.setC_category("top");
			
			list.add(vo);
		}
		return list;
	}
	
	/**
	 *	op.gg 크롤링 메서드 (정글)
	 */
	public List<CrawlingVO> getOPGGjug() throws Exception {
		Document doc = Jsoup.connect("https://www.op.gg/champions?region=global&tier=platinum_plus&position=jungle").get();
		
		Elements c_names = doc.select(".css-jgru8w.e1oulx2j7 .css-cym2o0.e1oulx2j6 a strong"); 
		Elements c_images = doc.select(".css-cym2o0.e1oulx2j6 a img");
		Elements c_tiers = doc.select(".css-ew1afn.e1oulx2j3");
		Elements c_allrate = doc.select(".css-1wvfkid.exo2f211");
		
		List<CrawlingVO> list = new ArrayList<CrawlingVO>();
		
		for (int i = 0; i < c_names.size(); i++) {
//			System.out.println(c_ranks.get(i).text());
//			System.out.println(i);
//			System.out.println(c_names.get(i).text());
//			System.out.println(c_tiers.get(i).text());
//			System.out.println("이미지 : " + c_images.get(i).attr("src"));
//			System.out.println("승률 : " + c_allrate.get(i*3).text());
//			System.out.println("픽률 : " + c_allrate.get(i*3+1).text());
//			System.out.println("밴율 : " + c_allrate.get(i*3+2).text());
			Element c_name = c_names.get(i);
			Element c_tier = c_tiers.get(i);
			Element c_image = c_images.get(i);
			Element c_winrate = c_allrate.get(i*3);
			Element c_pickrate = c_allrate.get(i*3+1);
			Element c_banrate = c_allrate.get(i*3+2);
			
			CrawlingVO vo = new CrawlingVO();
			vo.setC_name(c_name.text());
			vo.setC_tier(c_tier.text());
			vo.setC_image(c_image.attr("src"));
			vo.setC_winrate(c_winrate.text());
			vo.setC_pickrate(c_pickrate.text());
			vo.setC_banrate(c_banrate.text());
			vo.setC_category("jug");
			
			list.add(vo);
		}
		return list;
	}
	
	/**
	 *	op.gg 크롤링 메서드 (미드)
	 */
	public List<CrawlingVO> getOPGGmid() throws Exception {
		Document doc = Jsoup.connect("https://www.op.gg/champions?region=global&tier=platinum_plus&position=mid").get();
		
		Elements c_names = doc.select(".css-jgru8w.e1oulx2j7 .css-cym2o0.e1oulx2j6 a strong"); 
		Elements c_images = doc.select(".css-cym2o0.e1oulx2j6 a img");
		Elements c_tiers = doc.select(".css-ew1afn.e1oulx2j3");
		Elements c_allrate = doc.select(".css-1wvfkid.exo2f211");
		
		List<CrawlingVO> list = new ArrayList<CrawlingVO>();
		
		for (int i = 0; i < c_names.size(); i++) {
//			System.out.println(c_ranks.get(i).text());
//			System.out.println(i);
//			System.out.println(c_names.get(i).text());
//			System.out.println(c_tiers.get(i).text());
//			System.out.println("이미지 : " + c_images.get(i).attr("src"));
//			System.out.println("승률 : " + c_allrate.get(i*3).text());
//			System.out.println("픽률 : " + c_allrate.get(i*3+1).text());
//			System.out.println("밴율 : " + c_allrate.get(i*3+2).text());
			Element c_name = c_names.get(i);
			Element c_tier = c_tiers.get(i);
			Element c_image = c_images.get(i);
			Element c_winrate = c_allrate.get(i*3);
			Element c_pickrate = c_allrate.get(i*3+1);
			Element c_banrate = c_allrate.get(i*3+2);
			
			CrawlingVO vo = new CrawlingVO();
			vo.setC_name(c_name.text());
			vo.setC_tier(c_tier.text());
			vo.setC_image(c_image.attr("src"));
			vo.setC_winrate(c_winrate.text());
			vo.setC_pickrate(c_pickrate.text());
			vo.setC_banrate(c_banrate.text());
			vo.setC_category("mid");
			
			list.add(vo);
		}
		return list;
	}

	/**
	 *	op.gg 크롤링 메서드 (원딜)
	 */
	public List<CrawlingVO> getOPGGadc() throws Exception {
		Document doc = Jsoup.connect("https://www.op.gg/champions?region=global&tier=platinum_plus&position=adc").get();
		
		Elements c_names = doc.select(".css-jgru8w.e1oulx2j7 .css-cym2o0.e1oulx2j6 a strong"); 
		Elements c_images = doc.select(".css-cym2o0.e1oulx2j6 a img");
		Elements c_tiers = doc.select(".css-ew1afn.e1oulx2j3");
		Elements c_allrate = doc.select(".css-1wvfkid.exo2f211");
		
		List<CrawlingVO> list = new ArrayList<CrawlingVO>();
		
		for (int i = 0; i < c_names.size(); i++) {
//			System.out.println(c_ranks.get(i).text());
//			System.out.println(i);
//			System.out.println(c_names.get(i).text());
//			System.out.println(c_tiers.get(i).text());
//			System.out.println("이미지 : " + c_images.get(i).attr("src"));
//			System.out.println("승률 : " + c_allrate.get(i*3).text());
//			System.out.println("픽률 : " + c_allrate.get(i*3+1).text());
//			System.out.println("밴율 : " + c_allrate.get(i*3+2).text());
			Element c_name = c_names.get(i);
			Element c_tier = c_tiers.get(i);
			Element c_image = c_images.get(i);
			Element c_winrate = c_allrate.get(i*3);
			Element c_pickrate = c_allrate.get(i*3+1);
			Element c_banrate = c_allrate.get(i*3+2);
			
			CrawlingVO vo = new CrawlingVO();
			vo.setC_name(c_name.text());
			vo.setC_tier(c_tier.text());
			vo.setC_image(c_image.attr("src"));
			vo.setC_winrate(c_winrate.text());
			vo.setC_pickrate(c_pickrate.text());
			vo.setC_banrate(c_banrate.text());
			vo.setC_category("adc");
			
			list.add(vo);
		}
		return list;
	}
	
	/**
	 *	op.gg 크롤링 메서드 (서폿)
	 */
	public List<CrawlingVO> getOPGGsup() throws Exception {
		Document doc = Jsoup.connect("https://www.op.gg/champions?region=global&tier=platinum_plus&position=support").get();
		
		Elements c_names = doc.select(".css-jgru8w.e1oulx2j7 .css-cym2o0.e1oulx2j6 a strong"); 
		Elements c_images = doc.select(".css-cym2o0.e1oulx2j6 a img");
		Elements c_tiers = doc.select(".css-ew1afn.e1oulx2j3");
		Elements c_allrate = doc.select(".css-1wvfkid.exo2f211");
		
		List<CrawlingVO> list = new ArrayList<CrawlingVO>();
		
		for (int i = 0; i < c_names.size(); i++) {
//			System.out.println(c_ranks.get(i).text());
//			System.out.println(i);
//			System.out.println(c_names.get(i).text());
//			System.out.println(c_tiers.get(i).text());
//			System.out.println("이미지 : " + c_images.get(i).attr("src"));
//			System.out.println("승률 : " + c_allrate.get(i*3).text());
//			System.out.println("픽률 : " + c_allrate.get(i*3+1).text());
//			System.out.println("밴율 : " + c_allrate.get(i*3+2).text());
			Element c_name = c_names.get(i);
			Element c_tier = c_tiers.get(i);
			Element c_image = c_images.get(i);
			Element c_winrate = c_allrate.get(i*3);
			Element c_pickrate = c_allrate.get(i*3+1);
			Element c_banrate = c_allrate.get(i*3+2);
			
			CrawlingVO vo = new CrawlingVO();
			vo.setC_name(c_name.text());
			vo.setC_tier(c_tier.text());
			vo.setC_image(c_image.attr("src"));
			vo.setC_winrate(c_winrate.text());
			vo.setC_pickrate(c_pickrate.text());
			vo.setC_banrate(c_banrate.text());
			vo.setC_category("sup");
			
			list.add(vo);
		}
		return list;
	}
	
	/**
	 *	DB에 크롤링 데이터 저장 메서드 
	 */
	public void insertChampionInfo(List<CrawlingVO> list) {
		try {
			
			con = getConnection();
			sql = "insert into championinfo "
					+ "values(?,?,?,?,?,?,?,?) ";
			pstmt = con.prepareStatement(sql);

			for (int i = 0; i < list.size(); i++) {
				// c_no 계산
				String sql2 = "select max(c_no) from championinfo";
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				ResultSet rs2 = pstmt2.executeQuery();
				int c_no = 0;
				if (rs2.next()) {
					c_no = rs2.getInt(1)+1;
				}
				
				pstmt.setInt(1, c_no);
				
				// 첫글자 대문자, 나머지 소문자, 특수문자 전부 제거
				String firstLetter = list.get(i).getC_name().replaceAll("[^A-Z^a-z]", "").substring(0, 1);
		        String remainLetter = list.get(i).getC_name().replaceAll("[^A-Z^a-z]", "").substring(1);
		        firstLetter = firstLetter.toUpperCase();
		        remainLetter = remainLetter.toLowerCase();
		        String c_name = firstLetter + remainLetter;
				
		        if (c_name.equals("Drmundo")) {
		        	c_name = "DrMundo";
		        } else if (c_name.equals("Jarvaniv")) {
		        	c_name = "JarvanIV";
		        } else if (c_name.equals("Kogmaw")) {
		        	c_name = "KogMaw";
		        } else if (c_name.equals("Ksante")) {
		        	c_name = "KSante";
		        } else if (c_name.equals("Leesin")) {
		        	c_name = "LeeSin";
		        } else if (c_name.equals("Tahmkench")) {
		        	c_name = "TahmKench";
		        } else if (c_name.equals("Masteryi")) {
		        	c_name = "MasterYi";
		        } else if (c_name.equals("Missfortune")) {
		        	c_name = "MissFortune";
		        } else if (c_name.equals("Nunuwillump")) {
		        	c_name = "Nunu";
		        } else if (c_name.equals("Reksai")) {
		        	c_name = "RekSai";
		        } else if (c_name.equals("Renataglasc")) {
		        	c_name = "Renata";
		        } else if (c_name.equals("Twistedfate")) {
		        	c_name = "TwistedFate";
		        } else if (c_name.equals("Wukong")) {
		        	c_name = "MonkeyKing";
		        } else if (c_name.equals("Xinzhao")) {
		        	c_name = "XinZhao";
		        } 
		        
		        
		        pstmt.setString(2, c_name);
		        
				pstmt.setString(3, list.get(i).getC_image());
				pstmt.setString(4, list.get(i).getC_tier());
				pstmt.setString(5, list.get(i).getC_winrate());
				pstmt.setString(6, list.get(i).getC_pickrate());
				pstmt.setString(7, list.get(i).getC_banrate());
				pstmt.setString(8, list.get(i).getC_category());
				
				pstmt.executeUpdate();
			}
			
			System.out.println(" DAO : 챔피언 정보 저장! ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	
	/**
	 * 카테고리(탑,정글,미드,원딜,서폿)별로 DB 챔피언 통계 데이터 불러오는 메서드
	 */
	public List<CrawlingVO> getChampionInfo(String category) {
		List<CrawlingVO> list = new ArrayList<CrawlingVO>();
		
		try {
			con = getConnection();
			sql = "select A.c_no, A.c_name, A.c_image, A.c_tier, A.c_winrate, A.c_pickrate, A.c_banrate, A.c_category, B.name "
					+ "from championinfo A JOIN championdetail B "
					+ "ON A.c_name = B.id "
					+ "where c_category = ? "
					+ "order by c_tier, c_winrate desc;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CrawlingVO vo = new CrawlingVO();
				
				vo.setC_no(rs.getInt("c_no"));
				vo.setC_name(rs.getString("c_name"));
				vo.setC_banrate(rs.getString("c_banrate"));
				vo.setC_image(rs.getString("c_image"));
				vo.setC_pickrate(rs.getString("c_pickrate"));
				vo.setC_tier(rs.getString("c_tier"));
				vo.setC_winrate(rs.getString("c_winrate"));
				vo.setC_category(category);
				vo.setName(rs.getString("name"));
				
				list.add(vo);
			}
			System.out.println(" DAO : 챔피언 정보 조회 완료 ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return list;
	}
	
	public void removeChampionInfo() {
		try {
			con = getConnection();
			sql = "delete from championinfo";
			pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	public void insertMatch(HashMap<String, Object> hm) {
		int match_num=1;
		try {
			con = getConnection();
			sql = "select max(match_num) from matches";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				match_num = rs.getInt(1)+1;
			}
			
			sql = "insert into matches values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, match_num);
			pstmt.setString(2,(String)hm.get("matchid"));
			pstmt.setString(3,hm.get("win").toString());
			pstmt.setInt(4, (int)hm.get("u_num"));
			pstmt.setString(5,(String)hm.get("champion_Name"));
			pstmt.setInt(6, (int)hm.get("queueid"));
			pstmt.setString(7,(String)hm.get("kda"));
			pstmt.setInt(8, (int)hm.get("team_total_kills"));
			pstmt.setString(9,(String)hm.get("summoner_spell"));
			pstmt.setString(10,(String)hm.get("statPerks"));
			pstmt.setString(11,(String)hm.get("primary_perks"));
			pstmt.setString(12,(String)hm.get("sub_perks"));
			pstmt.setInt(13, (int)hm.get("level"));
			pstmt.setInt(14, (int)hm.get("gold"));
			pstmt.setInt(15, (int)hm.get("cs"));
			pstmt.setInt(16, (int)hm.get("playtime"));
			pstmt.setInt(17, (int)hm.get("detector_ward"));
			pstmt.setString(18,(String)hm.get("wardkp"));
			pstmt.setString(19,(String)hm.get("items"));
			pstmt.setString(20,(String)hm.get("summoner_name"));
			pstmt.setLong(21, (Long)hm.get("gameStartTimestamp"));
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
	}
	
	public List<String> getChampionNames() {
		List<String> list = new ArrayList<String>();
		
		try {
			con = getConnection();
			sql = "select distinct c_name from championinfo order by c_name";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			
			System.out.println(" DAO :  ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return list;
	}
	
	
	public void championJsonParsing() {
		final String REQUEST_URL = "http://ddragon.leagueoflegends.com/cdn/12.23.1/data/ko_KR/champion.json";
		
		try {
			URL requestURL = new URL(REQUEST_URL);
			HttpURLConnection conn = (HttpURLConnection)requestURL.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String readline = null;
			StringBuffer response = new StringBuffer();
			
			while ( (readline = br.readLine()) != null) {
				response.append(readline);
			}
			
			JSONObject responseBody = new JSONObject(response.toString());
			
			JSONObject data = responseBody.getJSONObject("data");
			List<String> nameList = getChampionNames();
			
			con = getConnection();
			
			for (int i = 0; i < nameList.size(); i++) {
				sql = "insert into championdetail "
						+ "values(?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				
				JSONObject ChampionDetail = data.getJSONObject(nameList.get(i));
				JSONObject CD_info = ChampionDetail.getJSONObject("info");
				JSONObject CD_image = ChampionDetail.getJSONObject("image");
				JSONObject CD_stats = ChampionDetail.getJSONObject("stats");
				
				ChampionDetailVO vo = new ChampionDetailVO();
//				System.out.println(ChampionDetail.get("id"));
//				vo.setId(ChampionDetail.get("id").toString());
				pstmt.setString(1, ChampionDetail.get("id").toString());
//				System.out.println(ChampionDetail.get("key"));
//				vo.setKey(ChampionDetail.get("key").toString());
				pstmt.setString(2, ChampionDetail.get("key").toString());
//				System.out.println(ChampionDetail.get("name"));
//				vo.setName(ChampionDetail.get("name").toString());
				pstmt.setString(3, ChampionDetail.get("name").toString());
//				System.out.println(ChampionDetail.get("title"));
//				vo.setTitle(ChampionDetail.get("title").toString());
				pstmt.setString(4, ChampionDetail.get("title").toString());
//				System.out.println(ChampionDetail.get("blurb"));
//				vo.setBlurb(ChampionDetail.get("blurb").toString());
				pstmt.setString(5, ChampionDetail.get("blurb").toString());
//				
//				System.out.println(CD_info.get("attack"));
//				vo.setAttack(CD_info.get("attack").toString());
				pstmt.setString(6, CD_info.get("attack").toString());
//				System.out.println(CD_info.get("defense"));
//				vo.setDefense(CD_info.get("defense").toString());
				pstmt.setString(7, CD_info.get("defense").toString());
//				System.out.println(CD_info.get("magic"));
//				vo.setMagic(CD_info.get("magic").toString());
				pstmt.setString(8, CD_info.get("magic").toString());
//				System.out.println(CD_info.get("difficulty"));
//				vo.setDifficult(CD_info.get("difficulty").toString());
				pstmt.setString(9, CD_info.get("difficulty").toString());
//				
//				System.out.println(CD_image.get("full"));
//				vo.setImage(CD_image.get("full").toString());
				pstmt.setString(10, CD_image.get("full").toString());
//				
//				System.out.println(ChampionDetail.get("partype"));
//				vo.setPartype(ChampionDetail.get("partype").toString());
				pstmt.setString(11, ChampionDetail.get("partype").toString());
//				
//				System.out.println(CD_stats.get("hp"));
//				vo.setHp(CD_stats.get("hp").toString());
				pstmt.setString(12, CD_stats.get("hp").toString());
//				System.out.println(CD_stats.get("hpperlevel"));
//				vo.setHpperlevel(CD_stats.get("hpperlevel").toString());
				pstmt.setString(13, CD_stats.get("hpperlevel").toString());
//				System.out.println(CD_stats.get("mp"));
//				vo.setMp(CD_stats.get("mp").toString());
				pstmt.setString(14, CD_stats.get("mp").toString());
//				System.out.println(CD_stats.get("mpperlevel"));
//				vo.setMpperlevel(CD_stats.get("mpperlevel").toString());
				pstmt.setString(15, CD_stats.get("mpperlevel").toString());
//				System.out.println(CD_stats.get("movespeed"));
//				vo.setMovespeed(CD_stats.get("movespeed").toString());
				pstmt.setString(16, CD_stats.get("movespeed").toString());
//				System.out.println(CD_stats.get("armor"));
//				vo.setArmor(CD_stats.get("armor").toString());
				pstmt.setString(17, CD_stats.get("armor").toString());
//				System.out.println(CD_stats.get("armorperlevel"));
//				vo.setArmorperlevel(CD_stats.get("armorperlevel").toString());
				pstmt.setString(18, CD_stats.get("armorperlevel").toString());
//				System.out.println(CD_stats.get("spellblock"));
//				vo.setSpellblock(CD_stats.get("spellblock").toString());
				pstmt.setString(19, CD_stats.get("spellblock").toString());
//				System.out.println(CD_stats.get("spellblockperlevel"));
//				vo.setSpellblockperlevel(CD_stats.get("spellblockperlevel").toString());
				pstmt.setString(20, CD_stats.get("spellblockperlevel").toString());
//				System.out.println(CD_stats.get("attackrange"));
//				vo.setAttackrange(CD_stats.get("attackrange").toString());
				pstmt.setString(21, CD_stats.get("attackrange").toString());
//				System.out.println(CD_stats.get("hpregen"));
//				vo.setHpregen(CD_stats.get("hpregen").toString());
				pstmt.setString(22, CD_stats.get("hpregen").toString());
//				System.out.println(CD_stats.get("hpregenperlevel"));
//				vo.setHpregenperlevel(CD_stats.get("hpregenperlevel").toString());
				pstmt.setString(23, CD_stats.get("hpregenperlevel").toString());
//				System.out.println(CD_stats.get("mpregen"));
//				vo.setMpregen(CD_stats.get("mpregen").toString());
				pstmt.setString(24, CD_stats.get("mpregen").toString());
//				System.out.println(CD_stats.get("mpregenperlevel"));
//				vo.setMpregenperlevel(CD_stats.get("mpregenperlevel").toString());
				pstmt.setString(25, CD_stats.get("mpregenperlevel").toString());
//				System.out.println(CD_stats.get("crit"));
//				vo.setCrit(CD_stats.get("crit").toString());
				pstmt.setString(26, CD_stats.get("crit").toString());
//				System.out.println(CD_stats.get("critperlevel"));
//				vo.setCritperlevel(CD_stats.get("critperlevel").toString());
				pstmt.setString(27, CD_stats.get("critperlevel").toString());
//				System.out.println(CD_stats.get("attackdamage"));
//				vo.setAttackdamage(CD_stats.get("attackdamage").toString());
				pstmt.setString(28, CD_stats.get("attackdamage").toString());
//				System.out.println(CD_stats.get("attackdamageperlevel"));
//				vo.setAttackdamageperlevel(CD_stats.get("attackdamageperlevel").toString());
				pstmt.setString(29, CD_stats.get("attackdamageperlevel").toString());
//				System.out.println(CD_stats.get("attackspeedperlevel"));
//				vo.setAttackspeedperlevel(CD_stats.get("attackspeedperlevel").toString());
				pstmt.setString(30, CD_stats.get("attackspeedperlevel").toString());
//				System.out.println(CD_stats.get("attackspeed"));
//				vo.setAttackspeed(CD_stats.get("attackspeed").toString());
				pstmt.setString(31, CD_stats.get("attackspeed").toString());
				
				pstmt.executeUpdate();
//				
//				System.out.println("---------------------------------------");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	public ArrayList<HashMap<String, Object>> getMatchesList(String name) {
		ArrayList<HashMap<String,Object>> List = new ArrayList<HashMap<String,Object>>();
		
		try {
			con = getConnection();
			
			sql = "select * from matches where summoner_name=? order by gameStartTimestamp desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				HashMap<String, Object> hm = new HashMap<String,Object>();
				
				hm.put("win", rs.getString("win"));
				hm.put("champs", rs.getString("champion_Name"));
				hm.put("u_num", rs.getInt("u_num"));
				hm.put("queueid", rs.getInt("queueid"));
				hm.put("kda", rs.getString("kda"));
				hm.put("team_kills", rs.getInt("team_total_kills"));
				hm.put("spells", rs.getString("summoner_spell"));
				hm.put("statPerks", rs.getString("statPerks"));
				hm.put("primary_perks", rs.getString("primary_perks"));
				hm.put("sub_perks", rs.getString("sub_perks"));
				hm.put("level", rs.getInt("level"));
				hm.put("gold", rs.getInt("gold"));
				hm.put("cs", rs.getInt("cs"));
				hm.put("playtime", rs.getInt("playtime"));
				hm.put("d_ward", rs.getInt("detector_ward"));
				hm.put("ward_kp", rs.getString("wardkp"));
				hm.put("items", rs.getString("items"));
				
				List.add(hm);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
		
		return List;
	}
	
	public List getChampionDetail(String id) {
		List championDetailList = new ArrayList();
		ChampionDetailVO dvo = null;
		try {
			con = getConnection();
			
			sql = " select * from championdetail where id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dvo = new ChampionDetailVO();
				
				dvo.setArmor(rs.getString("armor"));
				dvo.setArmorperlevel(rs.getString("armorperlevel"));
				dvo.setAttack(rs.getString("attack"));
				dvo.setAttackdamage(rs.getString("attackdamage"));
				dvo.setAttackdamageperlevel(rs.getString("attackdamageperlevel"));
				dvo.setAttackrange(rs.getString("attackrange"));
				dvo.setAttackspeed(rs.getString("attackspeed"));
				dvo.setAttackspeedperlevel(rs.getString("attackspeedperlevel"));
				dvo.setBlurb(rs.getString("blurb"));
				dvo.setCrit(rs.getString("crit"));
				dvo.setCritperlevel(rs.getString("critperlevel"));
				dvo.setDefense(rs.getString("defense"));
				dvo.setDifficult(rs.getString("difficult"));
				dvo.setHp(rs.getString("hp"));
				dvo.setHpperlevel(rs.getString("hpperlevel"));
				dvo.setHpregen(rs.getString("hpregen"));
				dvo.setHpregenperlevel(rs.getString("hpregenperlevel"));
				dvo.setMagic(rs.getString("magic"));
				dvo.setMovespeed(rs.getString("movespeed"));
				dvo.setMp(rs.getString("mp"));
				dvo.setMpperlevel(rs.getString("mpperlevel"));
				dvo.setMpregen(rs.getString("mpregen"));
				dvo.setMpregenperlevel(rs.getString("mpregenperlevel"));
				dvo.setName(rs.getString("name"));
				dvo.setPartype(rs.getString("parttype"));
				dvo.setSpellblock(rs.getString("spellblock"));
				dvo.setSpellblockperlevel(rs.getString("spellblockperlevel"));
				dvo.setTitle(rs.getString("title"));
				dvo.setId(rs.getString("id"));
				dvo.setName(rs.getString("name"));
				
				championDetailList.add(dvo);
			}
			System.out.println(" DAO : 챔피언 디테일 조회완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return championDetailList;
		
	}
	
	
	
	
}
