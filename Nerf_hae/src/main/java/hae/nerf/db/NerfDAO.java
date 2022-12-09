package hae.nerf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
		Document doc = Jsoup.connect("https://www.op.gg/champions?region=global&tier=platinum_plus&position=top").get();
		
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
				pstmt.setString(2, list.get(i).getC_name());
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
			sql = "select * from championinfo where c_category = ? order by c_tier, c_winrate desc";
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
			
			sql = "insert into matches values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		
	}
	
}
