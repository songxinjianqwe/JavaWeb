package me.newsong.domain;

public class Province {
	private int id;
	private int provinceid;
	private String province;
	public Province() {
		// TODO Auto-generated constructor stub
	}
	
	public Province(int id, int provinceid, String province) {
		super();
		this.id = id;
		this.provinceid = provinceid;
		this.province = province;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceid=" + provinceid + ", province=" + province + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
