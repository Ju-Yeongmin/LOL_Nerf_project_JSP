package hae.nerf.db;

public class CrawlingVO {
	private String c_rank;
	private String c_name;
	private String c_image;
	private String c_tier;
	private String c_winrate;
	private String c_pickrate;
	private String c_banrate;
	
	
	public String getC_rank() {
		return c_rank;
	}
	public void setC_rank(String c_rank) {
		this.c_rank = c_rank;
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
	
	
	@Override
	public String toString() {
		return "CrawlingVO [c_rank=" + c_rank + ", c_name=" + c_name + ", c_image=" + c_image + ", c_tier=" + c_tier
				+ ", c_winrate=" + c_winrate + ", c_pickrate=" + c_pickrate + ", c_banrate=" + c_banrate + "]";
	}
	
}
