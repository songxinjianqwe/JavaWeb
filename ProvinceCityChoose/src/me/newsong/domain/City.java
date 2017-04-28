package me.newsong.domain;

public class City {
	private int id;
	private int cityid;
	private String city;
	private int provinceid;
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	public City(int id, int cityid, String city, int provinceid) {
		super();
		this.id = id;
		this.cityid = cityid;
		this.city = city;
		this.provinceid = provinceid;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityid=" + cityid + ", city=" + city + ", provinceid=" + provinceid + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	
}
