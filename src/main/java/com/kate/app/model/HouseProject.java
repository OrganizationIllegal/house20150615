package com.kate.app.model;

import java.sql.Timestamp;
import java.util.List;

public class HouseProject implements Comparable<HouseProject>{
	private int id;
	private String project_name;
	private String project_img;
	private String project_logo;
	private String bijiao;
	private String zhou;
	
	public String getZhou() {
		return zhou;
	}
	public void setZhou(String zhou) {
		this.zhou = zhou;
	}
	public String getBijiao() {
		return bijiao;
	}
	public void setBijiao(String bijiao) {
		this.bijiao = bijiao;
	}
	
	
	public int compareTo(HouseProject arg0) {
        return this.getBijiao().compareTo(arg0.getBijiao());
    }
	
	/**
	 * 增加项目关键字,用于BingMap左侧按房屋类型
	 * @author wenruijie
	 * @time   20150730
	 */
	private List<String> project_key;
	private String project_address_short;
	
	
	public String getProject_address_short() {
		return project_address_short;
	}
	public void setProject_address_short(String project_address_short) {
		this.project_address_short = project_address_short;
	}
	

	public List<String> getProject_key() {
		return project_key;
	}
	public void setProject_key(List<String> project_key) {
		this.project_key = project_key;
	}
	public String getProject_logo() {
		return project_logo;
	}
	public void setProject_logo(String project_logo) {
		this.project_logo = project_logo;
	}
	private String project_nation;
	private String project_address;
	private String project_area;    
	private String project_price_qi;
	private int project_price_int_qi;
	public int getProject_price_int_qi() {
		return project_price_int_qi;
	}
	public void setProject_price_int_qi(int project_price_int_qi) {
		this.project_price_int_qi = project_price_int_qi;
	}
	private String project_type;
	private int project_sales_remain;
/*	private Timestamp project_finish_time;*/
	private String project_finish_time;
	private String project_desc;
	private int developer_id;
	private String project_city;
	private String project_house_type;
	private String project_high;
	private String project_price;
	private String project_lan_en;
	private String project_num;
	private String project_vedio;
	private String project_zhou;
	private String area_qujian;
	private String project_lan_cn;
	private String gps;
	private String return_money;
	private int news_boke_id;
	private int walk_num;
	private int area_id;
	private String mianji;
	private String recommend_id_1;
	private String recommend_id_2;
	private String recommend_id_3;
	private String wuyefei;
	private String project_min_price;
	private String project_high_price;
	private String maxPrice;
	private String minPrice;
	
	
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	private int tuijiandu;
	private Timestamp housePrice_update_time;
	private String tuijian_news_num_1;
	private String tuijian_news_num_2;
	private String tuijian_news_num_3;
	
	
	  private String xinkaipan;
	    private String huaren;
	    private String remen;
	    private String xuequ;
	    private String baozu;
	    private String daxue;
	    private String center;
	    private String traffic;
	    private String xianfang;
	    private String maidi;
	
	
	public String getXinkaipan() {
			return xinkaipan;
		}
		public void setXinkaipan(String xinkaipan) {
			this.xinkaipan = xinkaipan;
		}
		public String getHuaren() {
			return huaren;
		}
		public void setHuaren(String huaren) {
			this.huaren = huaren;
		}
		public String getRemen() {
			return remen;
		}
		public void setRemen(String remen) {
			this.remen = remen;
		}
		public String getXuequ() {
			return xuequ;
		}
		public void setXuequ(String xuequ) {
			this.xuequ = xuequ;
		}
		public String getBaozu() {
			return baozu;
		}
		public void setBaozu(String baozu) {
			this.baozu = baozu;
		}
		public String getDaxue() {
			return daxue;
		}
		public void setDaxue(String daxue) {
			this.daxue = daxue;
		}
		public String getCenter() {
			return center;
		}
		public void setCenter(String center) {
			this.center = center;
		}
		public String getTraffic() {
			return traffic;
		}
		public void setTraffic(String traffic) {
			this.traffic = traffic;
		}
		public String getXianfang() {
			return xianfang;
		}
		public void setXianfang(String xianfang) {
			this.xianfang = xianfang;
		}
		public String getMaidi() {
			return maidi;
		}
		public void setMaidi(String maidi) {
			this.maidi = maidi;
		}
	public String getTuijian_news_num_1() {
		return tuijian_news_num_1;
	}
	public void setTuijian_news_num_1(String tuijian_news_num_1) {
		this.tuijian_news_num_1 = tuijian_news_num_1;
	}
	public String getTuijian_news_num_2() {
		return tuijian_news_num_2;
	}
	public void setTuijian_news_num_2(String tuijian_news_num_2) {
		this.tuijian_news_num_2 = tuijian_news_num_2;
	}
	public String getTuijian_news_num_3() {
		return tuijian_news_num_3;
	}
	public void setTuijian_news_num_3(String tuijian_news_num_3) {
		this.tuijian_news_num_3 = tuijian_news_num_3;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_img() {
		return project_img;
	}
	public void setProject_img(String project_img) {
		this.project_img = project_img;
	}
	public String getProject_nation() {
		return project_nation;
	}
	public void setProject_nation(String project_nation) {
		this.project_nation = project_nation;
	}
	public String getProject_address() {
		return project_address;
	}
	public void setProject_address(String project_address) {
		this.project_address = project_address;
	}
	public String getProject_area() {
		return project_area;
	}
	public void setProject_area(String project_area) {
		this.project_area = project_area;
	}
	public String getProject_price_qi() {
		return project_price_qi;
	}
	public void setProject_price_qi(String project_price_qi) {
		this.project_price_qi = project_price_qi;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public int getProject_sales_remain() {
		return project_sales_remain;
	}
	public void setProject_sales_remain(int project_sales_remain) {
		this.project_sales_remain = project_sales_remain;
	}
	/*public Timestamp getProject_finish_time() {
		return project_finish_time;
	}
	public void setProject_finish_time(Timestamp project_finish_time) {
		this.project_finish_time = project_finish_time;
	}*/
	
	public String getProject_desc() {
		return project_desc;
	}
	public String getProject_finish_time() {
		return project_finish_time;
	}
	public void setProject_finish_time(String project_finish_time) {
		this.project_finish_time = project_finish_time;
	}
	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}
	public int getDeveloper_id() {
		return developer_id;
	}
	public void setDeveloper_id(int developer_id) {
		this.developer_id = developer_id;
	}
	public String getProject_city() {
		return project_city;
	}
	public void setProject_city(String project_city) {
		this.project_city = project_city;
	}
	public String getProject_house_type() {
		return project_house_type;
	}
	public void setProject_house_type(String project_house_type) {
		this.project_house_type = project_house_type;
	}
	public String getProject_high() {
		return project_high;
	}
	public void setProject_high(String project_high) {
		this.project_high = project_high;
	}
	public String getProject_price() {
		return project_price;
	}
	public void setProject_price(String project_price) {
		this.project_price = project_price;
	}
	public String getProject_lan_en() {
		return project_lan_en;
	}
	public void setProject_lan_en(String project_lan_en) {
		this.project_lan_en = project_lan_en;
	}
	public String getProject_num() {
		return project_num;
	}
	public void setProject_num(String project_num) {
		this.project_num = project_num;
	}
	public String getProject_vedio() {
		return project_vedio;
	}
	public void setProject_vedio(String project_vedio) {
		this.project_vedio = project_vedio;
	}
	public String getProject_zhou() {
		return project_zhou;
	}
	public void setProject_zhou(String project_zhou) {
		this.project_zhou = project_zhou;
	}
	public String getArea_qujian() {
		return area_qujian;
	}
	public void setArea_qujian(String area_qujian) {
		this.area_qujian = area_qujian;
	}
	public String getProject_lan_cn() {
		return project_lan_cn;
	}
	public void setProject_lan_cn(String project_lan_cn) {
		this.project_lan_cn = project_lan_cn;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getReturn_money() {
		return return_money;
	}
	public void setReturn_money(String return_money) {
		this.return_money = return_money;
	}
	public int getNews_boke_id() {
		return news_boke_id;
	}
	public void setNews_boke_id(int news_boke_id) {
		this.news_boke_id = news_boke_id;
	}
	public int getWalk_num() {
		return walk_num;
	}
	public void setWalk_num(int walk_num) {
		this.walk_num = walk_num;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public String getMianji() {
		return mianji;
	}
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}


	public String getRecommend_id_1() {
		return recommend_id_1;
	}
	public void setRecommend_id_1(String recommend_id_1) {
		this.recommend_id_1 = recommend_id_1;
	}
	public String getRecommend_id_2() {
		return recommend_id_2;
	}
	public void setRecommend_id_2(String recommend_id_2) {
		this.recommend_id_2 = recommend_id_2;
	}
	public String getRecommend_id_3() {
		return recommend_id_3;
	}
	public void setRecommend_id_3(String recommend_id_3) {
		this.recommend_id_3 = recommend_id_3;
	}
	public String getWuyefei() {
		return wuyefei;
	}
	public void setWuyefei(String wuyefei) {
		this.wuyefei = wuyefei;
	}
	public String getProject_min_price() {
		return project_min_price;
	}
	public void setProject_min_price(String project_min_price) {
		this.project_min_price = project_min_price;
	}
	public String getProject_high_price() {
		return project_high_price;
	}
	public void setProject_high_price(String project_high_price) {
		this.project_high_price = project_high_price;
	}
	public int getTuijiandu() {
		return tuijiandu;
	}
	public void setTuijiandu(int tuijiandu) {
		this.tuijiandu = tuijiandu;
	}
	public Timestamp getHousePrice_update_time() {
		return housePrice_update_time;
	}
	public void setHousePrice_update_time(Timestamp housePrice_update_time) {
		this.housePrice_update_time = housePrice_update_time;
	}
	public String getBuytaxInfo() {
		return buytaxInfo;
	}
	public void setBuytaxInfo(String buytaxInfo) {
		this.buytaxInfo = buytaxInfo;
	}
	public String getHoldInfo() {
		return holdInfo;
	}
	public void setHoldInfo(String holdInfo) {
		this.holdInfo = holdInfo;
	}
	public String getDeveloper_id_name() {
		return developer_id_name;
	}
	public void setDeveloper_id_name(String developer_id_name) {
		this.developer_id_name = developer_id_name;
	}
	public int getMin_area() {
		return min_area;
	}
	public void setMin_area(int min_area) {
		this.min_area = min_area;
	}
	public int getMax_area() {
		return max_area;
	}
	public void setMax_area(int max_area) {
		this.max_area = max_area;
	}
	public String getArea_num() {
		return area_num;
	}
	public void setArea_num(String area_num) {
		this.area_num = area_num;
	}
	private String buytaxInfo;
	private String holdInfo;
	private String developer_id_name;
	private int min_area;
	private int max_area;
	private int minArea;
	private int maxArea;
	private String project_price_int_qi_str;
	public String getProject_price_int_qi_str() {
		return project_price_int_qi_str;
	}
	public void setProject_price_int_qi_str(String project_price_int_qi_str) {
		this.project_price_int_qi_str = project_price_int_qi_str;
	}
	public int getMinArea() {
		return minArea;
	}
	public void setMinArea(int minArea) {
		this.minArea = minArea;
	}
	public int getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(int maxArea) {
		this.maxArea = maxArea;
	}
	private String area_num;
	private String project_name_short;


	public String getProject_name_short() {
		return project_name_short;
	}
	public void setProject_name_short(String project_name_short) {
		this.project_name_short = project_name_short;
	}
	
	
}