package hae.nerf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public List<CrawlingVO> getOPGG() throws Exception {
		Document doc = Jsoup.connect("https://www.op.gg/champions?region=global&tier=platinum_plus&position=top").get();
//		Document doc = Jsoup.connect("https://www.op.gg/champions").get();
		
		
		
		Elements c_ranks = doc.select(".css-3bfwic.e1oulx2j4 span ");
		Elements c_names = doc.select(".css-jgru8w.e1oulx2j7 .css-cym2o0.e1oulx2j6 a strong"); 
		Elements c_images;
		Elements c_tiers = doc.select(".css-ew1afn.e1oulx2j3 value");
		Elements c_winrate = doc.select(".css-1wvfkid.exo2f211");
		Elements c_pickrate;
		Elements c_banrate;
		
		
		for (int i = 0; i < c_ranks.size(); i+=2) {
			System.out.println(c_ranks.get(i).text());
			//System.out.println(c_names.get(i/2).text());
		}
		
		System.out.println(c_names);
		System.out.println(c_winrate);
			
		
		return null;
	}
	
	
	
}
