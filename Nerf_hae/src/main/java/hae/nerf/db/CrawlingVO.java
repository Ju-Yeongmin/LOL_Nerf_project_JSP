package hae.nerf.db;

public class CrawlingVO {
	private int c_no;
	private String c_name;
	private String c_image;
	private String c_tier;
	private String c_winrate;
	private String c_pickrate;
	private String c_banrate;
	private String c_category;
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_image() {
		return c_image;
	}
	public void setC_image(String c_image) {
		this.c_image = c_image;
	}
	public String getC_tier() {
		return c_tier;
	}
	public void setC_tier(String c_tier) {
		this.c_tier = c_tier;
	}
	public String getC_winrate() {
		return c_winrate;
	}
	public void setC_winrate(String c_winrate) {
		this.c_winrate = c_winrate;
	}
	public String getC_pickrate() {
		return c_pickrate;
	}
	public void setC_pickrate(String c_pickrate) {
		this.c_pickrate = c_pickrate;
	}
	public String getC_banrate() {
		return c_banrate;
	}
	public void setC_banrate(String c_banrate) {
		this.c_banrate = c_banrate;
	}
	public String getC_category() {
		return c_category;
	}
	public void setC_category(String c_category) {
		this.c_category = c_category;
	}
	
	
	@Override
	public String toString() {
		return "CrawlingVO [c_no=" + c_no + ", c_name=" + c_name + ", c_image=" + c_image + ", c_tier=" + c_tier
				+ ", c_winrate=" + c_winrate + ", c_pickrate=" + c_pickrate + ", c_banrate=" + c_banrate
				+ ", c_categry=" + c_category + "]";
	}
	
	
}
