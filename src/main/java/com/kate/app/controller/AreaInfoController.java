package com.kate.app.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.AreaInfoDao;
import com.kate.app.dao.AreaInputDao;
import com.kate.app.dao.BaseDao;
import com.kate.app.dao.NewsBokeDao;
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.AreaFamilyBackEnd;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.AreaMiddle;
import com.kate.app.model.AreaMiddle2;
import com.kate.app.model.AreaPeopleInfo;
import com.kate.app.model.AreaPeopleInfo2;
import com.kate.app.model.AreaTeDian;
import com.kate.app.model.AreaTeDian2;
import com.kate.app.model.AreaZhikong;
import com.kate.app.model.AreaZhikong2;
import com.kate.app.model.AreaZujin;
import com.kate.app.model.AreaZujin2;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.InvestmentDataBackEnd;
import com.kate.app.model.MiddlePrice2;
import com.kate.app.model.MiddlePriceBackEnd;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.NewsZhiye;
import com.kate.app.model.ZhiYeZhiDao;
import com.kate.app.service.ConvertJson;

@Controller
public class AreaInfoController extends BaseDao {
	@Autowired
	private AreaInputDao areaInputDao;
	@Autowired
	private AreaInfoDao areaInfoDao;
	@Autowired
	private NewsBokeDao newsBokeDao;
	@Autowired
	private ZhiYeDao zhiYeDao;
	@Autowired
	private AjaxDao ajaxDao;
	
	
	//区域中位数房价   
	private List<MiddlePrice2> middlepricebackendlistbefore;
	//区域房价中位数走势
	private List<AreaMiddle2> areamiddlelistbefore;
	//区域租金走势
	private List<AreaZujin2> zujinlistbefore;
	//区域租金回报走势
	private List<AreaZhikong2> huibaolistbefore;
	//区域特点
	private List<AreaTeDian2> tedianlistbefore;
	//区域人口分布
	private List<AreaPeopleInfo2> peoplelistbefore;
	//推荐经纪人
	private List<BrokerInfo> brokerlistbefore;
	//推荐项目
	private List<HouseProject> projectlistbefore;
	//新闻报道
	private List<NewsZhiye> newszhiyelistbefore;
	
	
			@RequestMapping({ "/AreaDelete" })
			public void deleteArea(HttpServletRequest req, HttpServletResponse resp) throws Exception{
				int id = Integer.parseInt(req.getParameter("id"));
				String area_num=req.getParameter("area_num");
				int flag =0;
				flag+=areaInfoDao.deleteAreaInfo(id);
				flag+=areaInfoDao.deleteInvest(area_num);
				flag+=areaInfoDao.deleteFamily(area_num);
				flag+=areaInfoDao.deleteMiddlePrice(area_num);
				flag+=areaInfoDao.deleteMiddleTrend(area_num);
				flag+=areaInfoDao.deleteZujin(area_num);
				flag+=areaInfoDao.deleteHuibao(area_num);
				flag+=areaInfoDao.deleteTedian(area_num);
				flag+=areaInfoDao.deletePeople(area_num);
				flag+=areaInfoDao.deleteBroker(area_num);
				flag+=areaInfoDao.deleteProject(area_num);
				flag+=areaInfoDao.deleteNewsBoke(area_num);
				JSONObject json = new JSONObject();
				json.put("data", flag);
				try{
					writeJson(json.toJSONString(),resp);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
	@RequestMapping({"/AreaEdit"})
	public String areaEidt(HttpServletRequest req,HttpServletResponse resp){
		String id=req.getParameter("id");
		//区域信息
		AreaInfo ai=new AreaInfo();
		ai=areaInfoDao.getAreaInfoBackEnd(Integer.parseInt(id));
		//投资数据
		InvestmentDataBackEnd invest=new InvestmentDataBackEnd();
		invest=areaInfoDao.getInvestInfo(ai.getArea_num(),"公寓");
		//投资数据
		InvestmentDataBackEnd invest1=new InvestmentDataBackEnd();
		invest1=areaInfoDao.getInvestInfo(ai.getArea_num(),"别墅");
		//区域家庭构成
		AreaFamilyBackEnd family=new AreaFamilyBackEnd();
		family=areaInfoDao.getFamilyBackEnd(ai.getArea_num());
		//区域中位数房价
		List<MiddlePrice2> middlepricebackendlist = new ArrayList<MiddlePrice2>();
		middlepricebackendlist=areaInfoDao.getMiddlePrice(ai.getArea_num());
		middlepricebackendlistbefore=areaInfoDao.getMiddlePrice(ai.getArea_num());
		//区域房价中位数走势
		List<AreaMiddle2> areamiddlelist=new  ArrayList<AreaMiddle2>();
		areamiddlelist=areaInfoDao.getAreaMiddleList(ai.getArea_num());
		areamiddlelistbefore=areaInfoDao.getAreaMiddleList(ai.getArea_num());
		//区域租金走势
		List<AreaZujin2> zujinlist=new ArrayList<AreaZujin2>();
		zujinlist=areaInfoDao.getAreaZujinList(ai.getArea_num());
		zujinlistbefore=areaInfoDao.getAreaZujinList(ai.getArea_num());
		//区域租金回报走势
		List<AreaZhikong2> huibaolist=new ArrayList<AreaZhikong2>();
		huibaolist=areaInfoDao.getAreaKongzhiList(ai.getArea_num());
		huibaolistbefore=areaInfoDao.getAreaKongzhiList(ai.getArea_num());
		//区域特点
		List<AreaTeDian2> tedianlist=new ArrayList<AreaTeDian2>();
		tedianlist=areaInfoDao.getAreaTedianList(ai.getArea_num());
		tedianlistbefore=areaInfoDao.getAreaTedianList(ai.getArea_num());
		//区域人口分布
		List<AreaPeopleInfo2> peoplelist=new ArrayList<AreaPeopleInfo2>();
		peoplelist=areaInfoDao.getAreaPeopleList(ai.getArea_num());
		peoplelistbefore=areaInfoDao.getAreaPeopleList(ai.getArea_num());
		//推荐经纪人
		List<BrokerInfo> brokerlist=new ArrayList<BrokerInfo>();
		brokerlist=areaInfoDao.getAreaBrokerList(ai.getArea_num());
		brokerlistbefore=areaInfoDao.getAreaBrokerList(ai.getArea_num());
		//推荐项目
		List<HouseProject> projectlist=new ArrayList<HouseProject>();
		projectlist=areaInfoDao.getAreaProjectList(ai.getArea_num());
		projectlistbefore=areaInfoDao.getAreaProjectList(ai.getArea_num());
		//新闻报道
		List<NewsZhiye> newszhiyelist=new ArrayList<NewsZhiye>();
		newszhiyelist=areaInfoDao.getAreaNewsBokeList(ai.getArea_num());
		newszhiyelistbefore=areaInfoDao.getAreaNewsBokeList(ai.getArea_num());
		req.setAttribute("AreaInfo", ai);
		req.setAttribute("Invest", invest);
		req.setAttribute("Invest1", invest1);
		req.setAttribute("Family", family);
		req.setAttribute("middlepricebackendlist", middlepricebackendlist);
		req.setAttribute("middlepricebackendlistjson", ConvertJson.list2json(middlepricebackendlist).replace(" ", "&nbsp;").replace("'", "&#39;"));
		req.setAttribute("areamiddlelist", areamiddlelist);
		req.setAttribute("areamiddlelistjson", ConvertJson.list2json(areamiddlelist).replace(" ", "&nbsp;").replace("'", "&#39;"));
		req.setAttribute("zujinlist", zujinlist);
		req.setAttribute("zujinlistjson", ConvertJson.list2json(zujinlist).replace(" ", "&nbsp;").replace("'", "&#39;"));
		req.setAttribute("huibaolist", huibaolist);
		req.setAttribute("huibaolistjson", ConvertJson.list2json(huibaolist).replace(" ", "&nbsp;").replace("'", "&#39;"));
		req.setAttribute("tedianlist", tedianlist);
		req.setAttribute("tedianlistjson", ConvertJson.list2json(tedianlist).replace(" ", "&nbsp;").replace("'", "&#39;"));
		req.setAttribute("peoplelist", peoplelist);
		req.setAttribute("peoplelistjson", ConvertJson.list2json(peoplelist).replace(" ", "&nbsp;").replace("'", "&#39;"));
		req.setAttribute("brokerlist", brokerlist);
		req.setAttribute("brokerlistjson", ConvertJson.list2json(brokerlist).replace(" ", "&nbsp;").replace("'", "&#39;"));
		req.setAttribute("projectlist", projectlist);
		req.setAttribute("projectlistjson", ConvertJson.list2json(projectlist).replace(" ", "&nbsp;").replace("'", "&#39;"));
		req.setAttribute("newszhiyelist", newszhiyelist);
		req.setAttribute("newszhiyelistjson", ConvertJson.list2json(newszhiyelist).replace(" ", "&nbsp;").replace("'", "&#39;"));		
		getBrokerName(req,resp);
		getProjectName(req,resp);
		getNewsList(req,resp);
		return "/areaEdit.jsp";
	}
	
	
	//ajax 鑾峰彇鎸囧畾id鍊煎拰type绫诲瀷鐨勭疆涓氭寚瀵兼垨鑰呮柊闂诲崥瀹㈢殑淇℃伅
	@RequestMapping({ "/getnewsinfo" })    
	public void getnewsinfo(HttpServletRequest req, HttpServletResponse resp){
		String id=req.getParameter("id");
		String type=req.getParameter("type");
		String hpstr;
		
		if(type.equals("newsboke")){
			NewsBoke nb=new NewsBoke();
			nb=areaInputDao.getNewsBokeInfo(id);
			hpstr=ConvertJson.object2json(nb);
		}
		else{
			ZhiYeZhiDao zy=new ZhiYeZhiDao();
			zy=areaInputDao.getZhiYeInfo(id);
			hpstr=ConvertJson.object2json(zy);
		}
		try{
			writeJson(hpstr,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//ajax 鑾峰彇鎸囧畾id鍊肩殑缁忔祹浜轰俊鎭�
	@RequestMapping({ "/getjingjireninfo" })    
	public void getjingjireninfo(HttpServletRequest req, HttpServletResponse resp){
		String id=req.getParameter("id");
		BrokerInfo bf=areaInputDao.getBrokerInfo(id);
		String bfstr=ConvertJson.object2json(bf);
		try{
			writeJson(bfstr,resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//ajax 鑾峰彇鎸囧畾id鍊肩殑椤圭洰淇℃伅
		@RequestMapping({ "/getprojectinfo" })    
		public void getprojectinfo(HttpServletRequest req, HttpServletResponse resp){
			String id=req.getParameter("id");
			HouseProject hp=areaInputDao.getProjectInfo(id);
			String hpstr=ConvertJson.object2json(hp);
			try{
				writeJson(hpstr,resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	//鍖哄煙褰曞叆
	@RequestMapping({"/AreaInput"})
	public String areaInput(HttpServletRequest req,HttpServletResponse resp){
		getBrokerName(req,resp);
		getProjectName(req,resp);
		getNewsList(req,resp);
		return "/areaLuru.jsp";
	}
	
	//寰楀埌缁忕邯浜虹殑濮撳悕
	@RequestMapping({"/AreaInput/Broker"})
	public void getBrokerName(HttpServletRequest req,HttpServletResponse resp){
		List<BrokerInfo> brokerSet=areaInputDao.getBrokers();
		req.setAttribute("brokerSet", brokerSet);
	}
	//寰楀埌椤圭洰鐨勫悕绉�
		@RequestMapping({"/AreaInput/Project"})
		public void getProjectName(HttpServletRequest req,HttpServletResponse resp){
			List<HouseProject> projectSet=areaInputDao.getProjectInfos();
			req.setAttribute("projectSet", projectSet);
		}
	//鑾峰緱鏂伴椈鍗氬鍜岃亴涓氭寚瀵肩殑鏂伴椈淇℃伅
		@RequestMapping({"/AreaInput/newslist"})
		public void getNewsList(HttpServletRequest req,HttpServletResponse resp){
			List<ZhiYeZhiDao> projectSet=areaInputDao.getZhiyezhidaos();
			List<NewsBoke> bokelist=areaInputDao.getNewsbokes();
			req.setAttribute("newsbokelist", ConvertJson.list2json(bokelist));
			req.setAttribute("zhiyelist", ConvertJson.list2json(projectSet));
		}
	//鍖哄煙鍒楄〃
	@RequestMapping({ "/AreaInfoList" })    
	public void selectAreaList(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = areaInputDao.selectAreaList();
		int count = array.size();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(array.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//新闻博客输入
	@RequestMapping({ "/inputNewsBoke" })
	public void inputNewsBoke(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String news_num = req.getParameter("news_num");
		String news_title  = req.getParameter("news_title");
		String news_people  = req.getParameter("news_people");
		String news_time = req.getParameter("news_time");
		String news_fenlei = req.getParameter("news_fenlei");
		String news_detail  = req.getParameter("news_detail");
		String news_image  = req.getParameter("news_image");
		String news_abstract  = req.getParameter("news_abstract");
		int flag = 0;
		JSONObject json = new JSONObject();
		int isDuplicate=newsBokeDao.isDuplicate(news_num);
		if (isDuplicate==1) {
			json.put("isDuplicate", "1");
		}
		else{
			flag =newsBokeDao.InsertNewsBoke(news_num, news_title, news_people, news_time, news_fenlei, news_abstract, news_detail, news_image);
			json.put("flag", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping({ "/NewsInput" })
	public String inputNewsBoke2(HttpServletRequest req, HttpServletResponse resp){
		List<String> fenleiList = zhiYeDao.newsBokeFenlei();
		req.setAttribute("fenleiList",fenleiList);
		return "/newsLuru.jsp";		
	}
	//新闻博客更新
	@RequestMapping({ "/EditNewsBoke" })
	public void UpdateNewsBoke(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id=Integer.parseInt(req.getParameter("id"));
		String news_num = req.getParameter("news_num");
		String news_title  = req.getParameter("news_title");
		String news_people  = req.getParameter("news_people");
		String news_time = req.getParameter("news_time");
		String news_fenlei = req.getParameter("news_fenlei");
		String news_detail  = req.getParameter("news_detail");
		String news_image  = req.getParameter("news_image");
		String news_abstract  = req.getParameter("news_abstract");
		int flag = 0;
		JSONObject json = new JSONObject();
		int isDuplicate=0;//newsBokeDao.isDuplicate(news_num);
		if (isDuplicate==1) {
			json.put("isDuplicate", "1");
		}
		else{
			flag =newsBokeDao.updateNewsBoke(id, news_num, news_title, news_people, news_time, news_fenlei, news_abstract, news_detail, news_image);
			json.put("flag", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//置业指导Add
		@RequestMapping({ "/inputZhiYe" })
		public void inputZhiYe(HttpServletRequest req, HttpServletResponse resp) throws Exception{
			String zhiye_num = req.getParameter("zhiye_num");
			String title  = req.getParameter("title");
			String fabu_people  = req.getParameter("fabu_people");
			String fabu_time = req.getParameter("fabu_time");
			String fenlei = req.getParameter("fenlei");
			String zhiye_abstract  = req.getParameter("zhiye_abstract");
			String image  = req.getParameter("image");
			String detail  = req.getParameter("detail");
			int flag = 0;
			JSONObject json = new JSONObject();
			int isDuplicate=zhiYeDao.isDuplicate(zhiye_num);
			if (isDuplicate==1) {
				json.put("isDuplicate", "1");
			}
			else{
				flag =zhiYeDao.InsertZhiye(zhiye_num, title, fabu_people, fabu_time, fenlei, zhiye_abstract, detail, image);
				json.put("flag", flag);
			}
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//置业指导编辑
		@RequestMapping({ "/EditZhiYe" })
		public void UpdateZhiYe(HttpServletRequest req, HttpServletResponse resp) throws Exception{
			int id=Integer.parseInt(req.getParameter("id"));
			String zhiye_num = req.getParameter("zhiye_num");
			String title  = req.getParameter("title");
			String fabu_people  = req.getParameter("fabu_people");
			String fabu_time = req.getParameter("fabu_time");
			String fenlei = req.getParameter("fenlei");
			String zhiye_abstract  = req.getParameter("zhiye_abstract");
			String image  = req.getParameter("image");
			String detail  = req.getParameter("detail");
			int flag = 0;
			JSONObject json = new JSONObject();
			int isDuplicate=0;//zhiYeDao.isDuplicate(zhiye_num);
			if (isDuplicate==1) {
				json.put("isDuplicate", "1");
			}
			else {
				flag =zhiYeDao.updateZhiye(id, zhiye_num, title, fabu_people, fabu_time, fenlei, zhiye_abstract, detail, image);
				json.put("flag", flag);
			}
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		//娣诲姞缁忕邯浜烘湇鍔″尯鍩�
				@RequestMapping({ "/addServiceArea" })
				public void addServiceArea(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int shunxu=0;
					String broker_num = req.getParameter("broker_num");
					String area_code  = req.getParameter("area_code");
					String view_shunxu  = req.getParameter("view_shunxu");
					if(view_shunxu!=null && !"".equals(view_shunxu)){
					shunxu=Integer.parseInt(view_shunxu);
					}
					int flag = 0;
					JSONObject json = new JSONObject();
					flag =areaInputDao.InsertServiceArea(broker_num, area_code, shunxu);
					json.put("flag", flag);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
				//娣诲姞缁忕邯浜烘湇鍔″尯鍩�
				@RequestMapping({ "/addInteType" })
				public void addInteType(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int shunxu=0;
					String broker_num = req.getParameter("broker_num");
					String interested_num  = req.getParameter("interested_num");
					String view_shunxu  = req.getParameter("view_shunxu");
					if(view_shunxu!=null && !"".equals(view_shunxu)){
					shunxu=Integer.parseInt(view_shunxu);
					}
					int flag = 0;
					JSONObject json = new JSONObject();
					flag =areaInputDao.InsertInteType(broker_num, interested_num, shunxu);
					json.put("flag", flag);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}

		//缁忕邯浜哄綍鍏�
				@RequestMapping({ "/inputBroker" })
				public void inputBroler(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int experience=0;
					String broker_num = req.getParameter("broker_num");
					String broker_name  = req.getParameter("broker_name");
					String broker_language  = req.getParameter("broker_language");
					String broker_region = req.getParameter("broker_region");
					String broker_type = req.getParameter("broker_type");
					String broker_zizhi  = req.getParameter("broker_zizhi");
					String broker_experience  = req.getParameter("broker_experience");
					String broker_img  = req.getParameter("broker_img");
					String introduction  = req.getParameter("introduction");
					String type_num  = req.getParameter("type_num");
					String type_name  = req.getParameter("type_name");
					String type_image  = req.getParameter("type_image");
					if(broker_experience!=null && !"".equals(broker_experience)){
						experience=Integer.parseInt(broker_experience);	
					}
					JSONObject json = new JSONObject();
					int flag1 =areaInputDao.insertBrokerInfo(broker_name, broker_language, broker_region, broker_img, experience, broker_num, broker_type, broker_zizhi, introduction);
					int flag2 =areaInputDao.InsertInteType2(type_num, type_name, type_image);
					//System.out.println(flag1);
					//System.out.println(flag2);
					json.put("flag", flag1+flag2);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
				//娣诲姞鍖哄煙涓綅鏁版埧浠�
				@RequestMapping({ "/addMiddlePrice" })
				public void addMiddlePrice(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int buyprice=0;
					int zuprice=0;
					int buyoneprice=0;
					int buytwoprice=0;
					int buythreeprice=0;
					int zuoneprice=0;
					int zutwoprice=0;
					int zuthreeprice=0;
					String buy_price = req.getParameter("buy_price");
					String zu_price  = req.getParameter("zu_price");
					String buy_one_name  = req.getParameter("buy_one_name");
					String buy_one_price = req.getParameter("buy_one_price");
					String buy_two_name  = req.getParameter("buy_two_name");
					String buy_two_price  = req.getParameter("buy_two_price");
					String buy_three_name = req.getParameter("buy_three_name");
					String buy_three_price  = req.getParameter("buy_three_price");
					String zu_one_name  = req.getParameter("zu_one_name");
					String zu_one_price = req.getParameter("zu_one_price");
					String zu_two_name  = req.getParameter("zu_two_name");
					String zu_two_price  = req.getParameter("zu_two_price");
					String zu_three_name  = req.getParameter("zu_three_name");
					String zu_three_price = req.getParameter("zu_three_price");
					String project_type  = req.getParameter("project_type");
					String area_quyu  = req.getParameter("area_quyu");
					if(buy_price!=null && !"".equals(buy_price)){
						buyprice=Integer.parseInt(buy_price);
					}
					if(zu_price!=null && !"".equals(zu_price)){
						zuprice=Integer.parseInt(zu_price);
					}
					if(buy_one_price!=null && !"".equals(buy_one_price)){
						buyoneprice=Integer.parseInt(buy_one_price);
					}
					if(buy_two_price!=null && !"".equals(buy_two_price)){
						buytwoprice=Integer.parseInt(buy_two_price);
					}
					if(buy_three_price!=null && !"".equals(buy_three_price)){
						buythreeprice=Integer.parseInt(buy_three_price);
					}
					if(zu_one_price!=null && !"".equals(zu_one_price)){
						zuoneprice=Integer.parseInt(zu_one_price);
					}
					if(zu_two_price!=null && !"".equals(zu_two_price)){
						zutwoprice=Integer.parseInt(zu_two_price);
					}
					if(zu_three_price!=null && !"".equals(zu_three_price)){
						zuthreeprice=Integer.parseInt(zu_three_price);
					}
					int flag = 0;
					JSONObject json = new JSONObject();
					flag =areaInputDao.insertMiddlePrice(buyprice, zuprice, buy_one_name, buyoneprice, buy_two_name, buytwoprice, buy_three_name, buythreeprice, zu_one_name, zuoneprice, zu_two_name, zutwoprice, zu_three_name, zuthreeprice, project_type, area_quyu);
					json.put("flag", flag);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				
				//娣诲姞鎴夸环涓綅鏁拌蛋鍔�
				@RequestMapping({ "/addMidTrend" })
				public void addMidTrend(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int shunxu=0;
					int z=0;
					String heng = req.getParameter("heng");
					String zong  = req.getParameter("zong");
					String view_shunxu  = req.getParameter("view_shunxu");
					String project_type  = req.getParameter("project_type");
					String area_code  = req.getParameter("area_code");
					if(view_shunxu!=null && !"".equals(view_shunxu)){
					shunxu=Integer.parseInt(view_shunxu);
					}
					if(zong!=null && !"".equals(zong)){
						z=Integer.parseInt(zong);
						}
					int flag = 0;
					JSONObject json = new JSONObject();
					flag =areaInputDao.insertMidTrend(heng, z, shunxu, project_type, area_code);
					json.put("flag", flag);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				//娣诲姞鎴夸环涓綅鏁拌蛋鍔�
				@RequestMapping({ "/addZujinTrend" })
				public void addZujinTrend(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int shunxu=0;
					int z=0;
					String heng = req.getParameter("heng");
					String zong  = req.getParameter("zong");
					String view_shunxu  = req.getParameter("view_shunxu");
					String project_type  = req.getParameter("project_type");
					String area_code  = req.getParameter("area_code");
					if(view_shunxu!=null && !"".equals(view_shunxu)){
					shunxu=Integer.parseInt(view_shunxu);
					}
					if(zong!=null && !"".equals(zong)){
						z=Integer.parseInt(zong);
						}
					int flag = 0;
					JSONObject json = new JSONObject();
					flag =areaInputDao.insertZuJinTrend(heng, z, shunxu, project_type, area_code);
					json.put("flag", flag);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
				//娣诲姞鎴夸环涓綅鏁拌蛋鍔�
				@RequestMapping({ "/addHuibaoTrend" })
				public void addHuibaoTrend(HttpServletRequest req, HttpServletResponse resp) throws Exception{
					int shunxu=0;
					int z=0;
					String heng = req.getParameter("heng");
					String zong  = req.getParameter("zong");
					String view_shunxu  = req.getParameter("view_shunxu");
					String project_type  = req.getParameter("project_type");
					String area_code  = req.getParameter("area_code");
					if(view_shunxu!=null && !"".equals(view_shunxu)){
					shunxu=Integer.parseInt(view_shunxu);
					}
					if(zong!=null && !"".equals(zong)){
						z=Integer.parseInt(zong);
						}
					int flag = 0;
					JSONObject json = new JSONObject();
					flag =areaInputDao.insertHuibaoTrend(heng, z, shunxu, project_type, area_code);
					json.put("flag", flag);
					try{
						writeJson(json.toJSONString(),resp);
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}
			
				
				
				//区域信息添加
				@RequestMapping({ "/AddAreaInfo" })
				public void AddBrokerInfo(HttpServletRequest req, HttpServletResponse resp){
					JSONObject ajson=new JSONObject();
					String area = req.getParameter("area");
					String middleprice = req.getParameter("middleprice");
					String middletrend = req.getParameter("middletrend");
					String zujintrendlist = req.getParameter("zujintrendlist");
					
					String huibaotrendlist = req.getParameter("huibaotrendlist");
					
					String tedianlist = req.getParameter("tedianlist");
					
					String peoplelist = req.getParameter("peoplelist");
					
					String brokerlist = req.getParameter("brokerlist");
					String projectlist = req.getParameter("projectlist");
					String newslist = req.getParameter("newslist");
					
					
					JSONObject json = JSONObject.parseObject(area);
					String area_num = json.getString("area_num");//区域编号
					String area_name = json.getString("area_name");
					String area_city = json.getString("area_city");
					String area_zhou = json.getString("area_zhou");
					String area_nation = json.getString("area_nation");
					String area_postcode = json.getString("area_postcode");
					
					
					/*boolean flag = areaInfoDao.addAreaInfo(area_num, area_name, area_city, area_zhou, area_nation, area_postcode);*/
					String touzi_datasource = json.getString("touzi_datasource");
					
					String touzi_date = json.getString("touzi_date");
					
			       /* String time1 = "";
					Timestamp ts1 = new Timestamp(System.currentTimeMillis()); 
					if(touzi_date==null||"".equals(touzi_date)){
						touzi_date =new SimpleDateFormat("yyyy-MM-dd").format(new Date());// "2015-05-09";
					}
			        try {  
			        	time1 = touzi_date+" "+"00:00:00";
			            ts1 = Timestamp.valueOf(time1);   
			            
			        } catch (Exception e) {   
			            e.printStackTrace();   
			        } */
			       
					
					
					
					
					
					
					String year_increment_rate = json.getString("year_increment_rate");
					String middle_price = json.getString("middle_price");
					String middle_zu_price = json.getString("middle_zu_price");
					String zu_house_rate = json.getString("zu_house_rate");
					String price_review = json.getString("price_review");
					String zu_xuqiu = json.getString("zu_xuqiu");
					String pro_type = json.getString("pro_type");
					
					String touzi_datasource1 = json.getString("touzi_datasource1");
					String touzi_date1 = json.getString("touzi_date1");
					String year_increment_rate1 = json.getString("year_increment_rate1");
					String middle_price1 = json.getString("middle_price1");
					String middle_zu_price1 = json.getString("middle_zu_price1");
					String zu_house_rate1 = json.getString("zu_house_rate1");
					String price_review1 = json.getString("price_review1");
					String zu_xuqiu1 = json.getString("zu_xuqiu1");
					String pro_type1 = json.getString("pro_type1");
					
					String data_exam = null;
					
					/*boolean result1 = areaInfoDao.addTouziData(touzi_datasource, touzi_date, middle_price, middle_zu_price, price_review, year_increment_rate, zu_house_rate, zu_xuqiu, data_exam, area_num, area_name);*/
					
					String family_datasource = json.getString("family_datasource");
					String family_date = json.getString("family_date");
					String family_one = json.getString("family_one");
					String family_one_rate = json.getString("family_one_rate");
					String family_two = json.getString("family_two");
					String family_two_rate = json.getString("family_two_rate");
					String family_three = json.getString("family_three");
					String family_three_rate = json.getString("family_three_rate");
					/*boolean resultFamily = areaInfoDao.addAreaFamily(area_num, family_one, family_one_rate, family_two, family_two_rate, family_three, family_three_rate, family_datasource, family_date);*/
					
					
					JSONArray middlepriceArray = JSONArray.parseArray(middleprice);
					List<MiddlePrice2> middlepriceList=new ArrayList<MiddlePrice2>();
					for (int i=0; i<middlepriceArray.size(); i++){
						 JSONObject object = (JSONObject)middlepriceArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
						 MiddlePrice2 e = (MiddlePrice2) JSONToObj(object.toString(), MiddlePrice2.class);
						 middlepriceList.add(e);
					}
					System.out.println("brokersList.length():"+middlepriceList.size());
					/*for(MiddlePrice2 item : middlepriceList){
						boolean resultMiddle = areaInfoDao.addMiddlePrice(item, area_num);
					}*/
					
					
					JSONArray middletrendArray = JSONArray.parseArray(middletrend);
					List<AreaMiddle2> middletrendList=new ArrayList<AreaMiddle2>();
					for (int i=0; i<middletrendArray.size(); i++){
						 JSONObject object = (JSONObject)middletrendArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
						 AreaMiddle2 e = (AreaMiddle2) JSONToObj(object.toString(), AreaMiddle2.class);
						 middletrendList.add(e);
					}
					System.out.println("brokersList.length():"+middletrendList.size());
					/*for(AreaMiddle2 item : middletrendList){
						boolean resultMiddle = areaInfoDao.addMiddleTrend(item, area_num);
					}*/
					
					
					JSONArray zujintrendlistArray = JSONArray.parseArray(zujintrendlist);
					List<AreaZujin2> zujintrendlistList=new ArrayList<AreaZujin2>();
					for (int i=0; i<zujintrendlistArray.size(); i++){
						 JSONObject object = (JSONObject)zujintrendlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
						 AreaZujin2 e = (AreaZujin2) JSONToObj(object.toString(), AreaZujin2.class);
						 zujintrendlistList.add(e);
					}
					
					/*for(AreaZujin2 item : zujintrendlistList){
						boolean resultZujin = areaInfoDao.addMiddleZujin(item, area_num);
					}*/
					//区域租金回报
					JSONArray huibaotrendlistArray = JSONArray.parseArray(huibaotrendlist);
					List<AreaZhikong2> huibaotrendlistList=new ArrayList<AreaZhikong2>();
					for (int i=0; i<huibaotrendlistArray.size(); i++){
						 JSONObject object = (JSONObject)huibaotrendlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
						 AreaZhikong2 e = (AreaZhikong2) JSONToObj(object.toString(), AreaZhikong2.class);
						 huibaotrendlistList.add(e);
					}
					
					/*for(AreaZhikong2 item : huibaotrendlistList){
						boolean resultZujin = areaInfoDao.addAreaZhikong(item, area_num);
					}*/
					//区域地点
					JSONArray tedianlistArray = JSONArray.parseArray(tedianlist);
					List<AreaTeDian2> tedianlistList=new ArrayList<AreaTeDian2>();
					for (int i=0; i<tedianlistArray.size(); i++){
						 JSONObject object = (JSONObject)tedianlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
						 AreaTeDian2 e = (AreaTeDian2) JSONToObj(object.toString(), AreaTeDian2.class);
						 tedianlistList.add(e);
					}
					
					/*for(AreaTeDian2 item : tedianlistList){
						boolean resultZujin = areaInfoDao.addAreaTeDian(item, area_num);
					}*/
					
					//区域人口分布
					
					JSONArray peoplelistArray = JSONArray.parseArray(peoplelist);
					List<AreaPeopleInfo2> peoplelistList=new ArrayList<AreaPeopleInfo2>();
					for (int i=0; i<peoplelistArray.size(); i++){
						 JSONObject object = (JSONObject)peoplelistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
						 AreaPeopleInfo2 e = (AreaPeopleInfo2) JSONToObj(object.toString(), AreaPeopleInfo2.class);
						 peoplelistList.add(e);
					}
					
					/*for(AreaPeopleInfo2 item : peoplelistList){
						boolean resultZujin = areaInfoDao.addAreaPeople(item, area_num);
					}*/
					//推荐经纪人
					JSONArray brokerlistArray = JSONArray.parseArray(brokerlist);
					int length = brokerlistArray.size() >= 3 ? 3: brokerlistArray.size();
					
					List<BrokerInfo> brokerlistList=new ArrayList<BrokerInfo>();
					for (int i = 0; i < length; i++){
						 JSONObject object = (JSONObject)brokerlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
						 BrokerInfo e = (BrokerInfo) JSONToObj(object.toString(), BrokerInfo.class);
						 brokerlistList.add(e);
					}
					/*boolean resultTuijianBroker = areaInfoDao.addAreaTuijianBroker(brokerlistList, area_num);*/

					JSONArray projectlistArray = JSONArray.parseArray(projectlist);
					int length1 = projectlistArray.size() >= 3 ? 3: projectlistArray.size();
					
					List<String> projectlistList=new ArrayList<String>();
					for (int i = 0; i < length1; i++){
						 JSONObject object = (JSONObject)projectlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
						 String project_name = object.getString("project_name");
						 //HouseProject e = (HouseProject) JSONToObj(object.toString(), HouseProject.class);
						 projectlistList.add(project_name);
					}
					/*boolean resultTuijianPro = areaInfoDao.addAreaTuijianPro(projectlistList, area_num);*/

					
					JSONArray newslistArray = JSONArray.parseArray(newslist);
					//int length2 = newslistArray.size() >= 3 ? 3: newslistArray.size();
					
					List<String> newslistList=new ArrayList<String>();
					List<String> list = new ArrayList<String>();
					for (int i = 0; i < newslistArray.size(); i++){
						 JSONObject object = (JSONObject)newslistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
						 if(object.containsKey("title")){
							 String title = object.getString("title");
							 //ZhiYeZhiDao e = (ZhiYeZhiDao) JSONToObj(object.toString(), ZhiYeZhiDao.class);
							 list.add(title);
						 }
						 else{
							 String news_title = object.getString("news_title");
							 //NewsBoke e = (NewsBoke) JSONToObj(object.toString(), NewsBoke.class);
							 newslistList.add(news_title);
						 }
					}
					/*boolean resultTuijianBoke = areaInfoDao.addAreaTuijianBoke(newslistList, list, area_num);*/
					//判断区域编号不能重复
					int isDuplicate=areaInfoDao.isDuplicate(area_num);
					if(isDuplicate==1){
						ajson.put("isDuplicate", "1");
					}
					else{
					//添加
				    try {
						int result=areaInfoDao.AddArea(area_num, area_name, area_city, area_zhou, area_nation, area_postcode,touzi_datasource, touzi_datasource1, touzi_date, touzi_date1, middle_price, middle_price1, middle_zu_price, middle_zu_price1, price_review, price_review1, year_increment_rate, year_increment_rate1, zu_house_rate, zu_house_rate1, zu_xuqiu, zu_xuqiu1, pro_type, pro_type1, data_exam, data_exam, family_one, family_one_rate, family_two, family_two_rate, family_three, family_three_rate, family_datasource, family_date,middlepriceList,middletrendList,zujintrendlistList,huibaotrendlistList,tedianlistList,peoplelistList,brokerlistList,projectlistList,newslistList,list);
						if(result==1){
							ajson.put("flag", "1");
						}
						else{
							ajson.put("flag", "0");
						}
				    } catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					 try {
							writeJson(ajson.toJSONString(),resp);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					    
					
			}
			//区域信息编辑
			@RequestMapping({ "/EditAreaInfo" })
			public void UpdateBrokerInfo(HttpServletRequest req, HttpServletResponse resp){
				JSONObject ajson=new JSONObject();
				int id=Integer.parseInt(req.getParameter("id"));
				int id2=Integer.parseInt(req.getParameter("id2"));
				int id21=Integer.parseInt(req.getParameter("id21"));
				int id3=Integer.parseInt(req.getParameter("id3"));
				String area = req.getParameter("area");//区域信息
				String middleprice = req.getParameter("middleprice");
				String middletrend = req.getParameter("middletrend");
				String zujintrendlist = req.getParameter("zujintrendlist");
				
				String huibaotrendlist = req.getParameter("huibaotrendlist");
				
				String tedianlist = req.getParameter("tedianlist");
				
				String peoplelist = req.getParameter("peoplelist");
				
				String brokerlist = req.getParameter("brokerlist");
				String projectlist = req.getParameter("projectlist");
				String newslist = req.getParameter("newslist");
				
				//区域信息
				JSONObject json = JSONObject.parseObject(area);
				String area_num = json.getString("area_num");
				String area_name = json.getString("area_name");
				String area_city = json.getString("area_city");
				String area_zhou = json.getString("area_zhou");
				String area_nation = json.getString("area_nation");
				String area_postcode = json.getString("area_postcode");
				
				//投资数据
				/*boolean flag = areaInfoDao.addAreaInfo(area_num, area_name, area_city, area_zhou, area_nation, area_postcode);*/
				String touzi_datasource = json.getString("touzi_datasource");
				String touzi_date = json.getString("touzi_date");
				String year_increment_rate = json.getString("year_increment_rate");
				String middle_price = json.getString("middle_price");
				String middle_zu_price = json.getString("middle_zu_price");
				String zu_house_rate = json.getString("zu_house_rate");
				String price_review = json.getString("price_review");
				String zu_xuqiu = json.getString("zu_xuqiu");
				String pro_type = json.getString("pro_type");

				String touzi_datasource1 = json.getString("touzi_datasource1");
				String touzi_date1 = json.getString("touzi_date1");
				String year_increment_rate1 = json.getString("year_increment_rate1");
				String middle_price1 = json.getString("middle_price1");
				String middle_zu_price1 = json.getString("middle_zu_price1");
				String zu_house_rate1 = json.getString("zu_house_rate1");
				String price_review1 = json.getString("price_review1");
				String zu_xuqiu1 = json.getString("zu_xuqiu1");
				String pro_type1= json.getString("pro_type1");


				String data_exam = null;
				String data_exam1 = null;
				
				/*boolean result1 = areaInfoDao.addTouziData(touzi_datasource, touzi_date, middle_price, middle_zu_price, price_review, year_increment_rate, zu_house_rate, zu_xuqiu, data_exam, area_num, area_name);*/
				//区域家庭构成
				String family_datasource = json.getString("family_datasource");
				String family_date = json.getString("family_date");
				String family_one = json.getString("family_one");
				String family_one_rate = json.getString("family_one_rate");
				String family_two = json.getString("family_two");
				String family_two_rate = json.getString("family_two_rate");
				String family_three = json.getString("family_three");
				String family_three_rate = json.getString("family_three_rate");
				/*boolean resultFamily = areaInfoDao.addAreaFamily(area_num, family_one, family_one_rate, family_two, family_two_rate, family_three, family_three_rate, family_datasource, family_date);*/
				/*//区域中位数房价   
				private List<MiddlePrice2> ;
				//区域房价中位数走势
				private List<AreaMiddle2> areamiddlelistbefore;
				//区域租金走势
				private List<AreaZujin2> ;
				//区域租金回报走势
				private List<AreaZhikong2> ;
				//区域特点
				private List<AreaTeDian2> ;
				//区域人口分布
				private List<AreaPeopleInfo2> ;
				//推荐经纪人
				private List<BrokerInfo> ;
				//推荐项目
				private List<HouseProject> ;
				//新闻报道
				private List<NewsZhiye> ;*/
				//区域中位数房价
				JSONArray middlepriceArray = JSONArray.parseArray(middleprice);
				List<MiddlePrice2> middlepriceList=new ArrayList<MiddlePrice2>();//用于编辑
				List<MiddlePrice2> middlepriceList2=new ArrayList<MiddlePrice2>();//用于添加
				List<MiddlePrice2> middlepriceListdelete=new ArrayList<MiddlePrice2>();//用于添加
				for (int i=0; i<middlepriceArray.size(); i++){
					 JSONObject object = (JSONObject)middlepriceArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
					 MiddlePrice2 e = (MiddlePrice2) JSONToObj(object.toString(), MiddlePrice2.class);
					 if(e.getId()==0){
						 middlepriceList2.add(e);
					 }else{
						 middlepriceList.add(e);
					 }
				}
				for (int i=0;i<middlepricebackendlistbefore.size();i++){
					boolean flag=false;
					for(int j=0;j<middlepriceList.size();j++){
						if(middlepricebackendlistbefore.get(i).getId()==middlepriceList.get(j).getId()){
							flag=true;
							break;
						}
					}
					if(flag==false){
						middlepriceListdelete.add(middlepricebackendlistbefore.get(i));
					}
				}
				System.out.println("brokersList.length():"+middlepriceList.size());
				/*for(MiddlePrice2 item : middlepriceList){
					boolean resultMiddle = areaInfoDao.addMiddlePrice(item, area_num);
				}*/
				
				//区域房价中位数走势
				JSONArray middletrendArray = JSONArray.parseArray(middletrend);
				List<AreaMiddle2> middletrendList=new ArrayList<AreaMiddle2>();//用于编辑
				List<AreaMiddle2> middletrendList2=new ArrayList<AreaMiddle2>();//用于添加
				List<AreaMiddle2> middletrendListdelete=new ArrayList<AreaMiddle2>();//用于添加
				for (int i=0; i<middletrendArray.size(); i++){
					 JSONObject object = (JSONObject)middletrendArray.get(i); //瀵逛簬姣忎釜json瀵硅薄
					 AreaMiddle2 e = (AreaMiddle2) JSONToObj(object.toString(), AreaMiddle2.class);
					 if(e.getId()==0){
						 middletrendList2.add(e);
					 }else{
						 middletrendList.add(e);
					 }
				}
				for (int i=0;i<areamiddlelistbefore.size();i++){
					boolean flag=false;
					for(int j=0;j<middletrendList.size();j++){
						if(areamiddlelistbefore.get(i).getId()==middletrendList.get(j).getId()){
							flag=true;
							break;
						}
					}
					if(flag==false){
						middletrendListdelete.add(areamiddlelistbefore.get(i));
					}
				}
				System.out.println("brokersList.length():"+middletrendList.size());
				/*for(AreaMiddle2 item : middletrendList){
					boolean resultMiddle = areaInfoDao.addMiddleTrend(item, area_num);
				}*/
				
				//区域租金走势
				JSONArray zujintrendlistArray = JSONArray.parseArray(zujintrendlist);
				List<AreaZujin2> zujintrendlistList=new ArrayList<AreaZujin2>();
				List<AreaZujin2> zujintrendlistList2=new ArrayList<AreaZujin2>();
				List<AreaZujin2> zujintrendlistListdelete=new ArrayList<AreaZujin2>();
				for (int i=0; i<zujintrendlistArray.size(); i++){
					 JSONObject object = (JSONObject)zujintrendlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
					 AreaZujin2 e = (AreaZujin2) JSONToObj(object.toString(), AreaZujin2.class);
					 if(e.getId()==0){
						 zujintrendlistList2.add(e);
					 }else{
						 zujintrendlistList.add(e);
					 }
				}
				for (int i=0;i<zujinlistbefore.size();i++){
					boolean flag=false; 
					for(int j=0;j<zujintrendlistList.size();j++){
						if(zujinlistbefore.get(i).getId()==zujintrendlistList.get(j).getId()){
							flag=true;
							break;
						}
					}
					if(flag==false){
						zujintrendlistListdelete.add(zujinlistbefore.get(i));
					}
				}
				
				/*for(AreaZujin2 item : zujintrendlistList){
					boolean resultZujin = areaInfoDao.addMiddleZujin(item, area_num);
				}*/
				//区域租金回报走势
				JSONArray huibaotrendlistArray = JSONArray.parseArray(huibaotrendlist);
				List<AreaZhikong2> huibaotrendlistList=new ArrayList<AreaZhikong2>();
				List<AreaZhikong2> huibaotrendlistList2=new ArrayList<AreaZhikong2>();
				List<AreaZhikong2> huibaotrendlistListdelete=new ArrayList<AreaZhikong2>();
				for (int i=0; i<huibaotrendlistArray.size(); i++){
					 JSONObject object = (JSONObject)huibaotrendlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
					 AreaZhikong2 e = (AreaZhikong2) JSONToObj(object.toString(), AreaZhikong2.class);
					 if(e.getId()==0){
						 huibaotrendlistList2.add(e);
					 }else{
						 huibaotrendlistList.add(e);
					 }
				}
				for (int i=0;i<huibaolistbefore.size();i++){
					boolean flag=false;
					for(int j=0;j<huibaotrendlistList.size();j++){
						if(huibaolistbefore.get(i).getId()==huibaotrendlistList.get(j).getId()){
							flag=true;
							break;
						}
					}
					if(flag==false){
						huibaotrendlistListdelete.add(huibaolistbefore.get(i));
					}
				}
				
				/*for(AreaZhikong2 item : huibaotrendlistList){
					boolean resultZujin = areaInfoDao.addAreaZhikong(item, area_num);
				}*/
				//区域地点
				JSONArray tedianlistArray = JSONArray.parseArray(tedianlist);
				List<AreaTeDian2> tedianlistList=new ArrayList<AreaTeDian2>();
				List<AreaTeDian2> tedianlistList2=new ArrayList<AreaTeDian2>();
				List<AreaTeDian2> tedianlistListdelete=new ArrayList<AreaTeDian2>();
				for (int i=0; i<tedianlistArray.size(); i++){
					 JSONObject object = (JSONObject)tedianlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
					 AreaTeDian2 e = (AreaTeDian2) JSONToObj(object.toString(), AreaTeDian2.class);
					 if(e.getId()==0){
						 tedianlistList2.add(e);
					 }else{
						 tedianlistList.add(e);
					 }
				}
				for (int i=0;i<tedianlistbefore.size();i++){
					boolean flag=false;
					for(int j=0;j<tedianlistList.size();j++){
						if(tedianlistbefore.get(i).getId()==tedianlistList.get(j).getId()){
							flag=true;
							break;
						}
					}
					if(flag==false){
						tedianlistListdelete.add(tedianlistbefore.get(i));
					}
				}
				/*for(AreaTeDian2 item : tedianlistList){
					boolean resultZujin = areaInfoDao.addAreaTeDian(item, area_num);
				}*/
				
				//区域人口分布
				
				JSONArray peoplelistArray = JSONArray.parseArray(peoplelist);
				List<AreaPeopleInfo2> peoplelistList=new ArrayList<AreaPeopleInfo2>();
				List<AreaPeopleInfo2> peoplelistList2=new ArrayList<AreaPeopleInfo2>();
				List<AreaPeopleInfo2> peoplelistListdelete=new ArrayList<AreaPeopleInfo2>();
				for (int i=0; i<peoplelistArray.size(); i++){
					 JSONObject object = (JSONObject)peoplelistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
					 AreaPeopleInfo2 e = (AreaPeopleInfo2) JSONToObj(object.toString(), AreaPeopleInfo2.class);
					 if(e.getId()==0){
						 peoplelistList2.add(e);
					 }else{
						 peoplelistList.add(e);
					 }
					
				}
				for (int i=0;i<peoplelistbefore.size();i++){
					boolean flag=false;
					for(int j=0;j<peoplelistList.size();j++){
						if(peoplelistbefore.get(i).getId()==peoplelistList.get(j).getId()){
							flag=true;
							break;
						}
					}
					if(flag==false){
						peoplelistListdelete.add(peoplelistbefore.get(i));
					}
				}
				/*for(AreaPeopleInfo2 item : peoplelistList){
					boolean resultZujin = areaInfoDao.addAreaPeople(item, area_num);
				}*/
				//推荐经纪人
				JSONArray brokerlistArray = JSONArray.parseArray(brokerlist);
				int length = brokerlistArray.size() >= 3 ? 3: brokerlistArray.size();
				
				List<BrokerInfo> brokerlistList=new ArrayList<BrokerInfo>();
				List<BrokerInfo> brokerlistList2=new ArrayList<BrokerInfo>();
				/*List<BrokerInfo> brokerlistListdelete=new ArrayList<BrokerInfo>();*/
				for (int i = 0; i < length; i++){
					 JSONObject object = (JSONObject)brokerlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
					 BrokerInfo e = (BrokerInfo) JSONToObj(object.toString(), BrokerInfo.class);
					 if(e.getId()==0){
						 brokerlistList2.add(e);
					 }else{
						 brokerlistList.add(e);
					 }
					 /*brokerlistList.add(e);*/
				}
				/*for (int i=0;i<brokerlistbefore.size();i++){
					for(int j=0;j<brokerlistList.size();j++){
						if(brokerlistbefore.get(i).getId()==brokerlistList.get(j).getId()){
							brokerlistListdelete.add(brokerlistList.get(j));
							break;
						}
					}
				}*/
				/*boolean resultTuijianBroker = areaInfoDao.addAreaTuijianBroker(brokerlistList, area_num);*/
				//推荐项目
				JSONArray projectlistArray = JSONArray.parseArray(projectlist);
				int length1 = projectlistArray.size() >= 3 ? 3: projectlistArray.size();
				
				List<String> projectlistList=new ArrayList<String>();
				/*List<String> projectlistListdelete=new ArrayList<String>();*/
				for (int i = 0; i < length1; i++){
					 JSONObject object = (JSONObject)projectlistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
					 String project_name = object.getString("project_name");
					 //HouseProject e = (HouseProject) JSONToObj(object.toString(), HouseProject.class);
					/* if(e.getId()==0){
						 projectlistList2.add(e);
					 }else{
						 projectlistList.add(e);
					 }*/
					 projectlistList.add(project_name);
				}
				/*for (int i=0;i<projectlistbefore.size();i++){
					for(int j=0;j<projectlistList.size();j++){
						if(projectlistbefore.get(i).getId()==projectlistList.get(j).getId()){
							projectlistListdelete.add(projectlistList.get(j));
							break;
						}
					}
				}*/
				/*boolean resultTuijianPro = areaInfoDao.addAreaTuijianPro(projectlistList, area_num);*/

				//新闻报道
				JSONArray newslistArray = JSONArray.parseArray(newslist);
				//int length2 = newslistArray.size() >= 3 ? 3: newslistArray.size();
				
				List<String> newslistList=new ArrayList<String>();
				List<String> list = new ArrayList<String>();
				for (int i = 0; i < newslistArray.size(); i++){
					 JSONObject object = (JSONObject)newslistArray.get(i);   //瀵逛簬姣忎釜json瀵硅薄
					 if(object.containsKey("title")){
						 String title = object.getString("title");
						 //ZhiYeZhiDao e = (ZhiYeZhiDao) JSONToObj(object.toString(), ZhiYeZhiDao.class);
						 list.add(title);
					 }
					 else{
						 String news_title = object.getString("news_title");
						 //NewsBoke e = (NewsBoke) JSONToObj(object.toString(), NewsBoke.class);
						 newslistList.add(news_title);
					 }
				}
				/*for (int i=0;i<newszhiyelistbefore.size();i++){
					for(int j=0;j<middlepriceList.size();j++){
						if(newszhiyelistbefore.get(i).getId()==middlepriceList.get(j).getId()){
							middlepriceListdelete.add(middlepriceList.get(j));
							break;
						}
					}
				}*/
				/*boolean resultTuijianBoke = areaInfoDao.addAreaTuijianBoke(newslistList, list, area_num);*/
				/*int isDuplicate=areaInfoDao.isDuplicate(area_num);
				if(isDuplicate==1){
					ajson.put("isDuplicate", "1");
				}
				else{*/
				//添加
			    try {

					int result=areaInfoDao.EditArea(id,id2,id21,id3,area_num, area_name, area_city, area_zhou, area_nation, area_postcode,touzi_datasource, touzi_datasource1, touzi_date,touzi_date1, middle_price, middle_price1,middle_zu_price, middle_zu_price1,price_review, price_review1, year_increment_rate, year_increment_rate1, zu_house_rate, zu_house_rate1, zu_xuqiu, zu_xuqiu1, pro_type, pro_type1, data_exam, data_exam,family_one, family_one_rate, family_two, family_two_rate, family_three, family_three_rate, family_datasource, family_date,middlepriceList,middlepriceList2,middletrendList,middletrendList2,zujintrendlistList,zujintrendlistList2,huibaotrendlistList,huibaotrendlistList2,tedianlistList,tedianlistList2,peoplelistList,peoplelistList2,brokerlistList,projectlistList,newslistList,list,middlepriceListdelete,middletrendListdelete,zujintrendlistListdelete,huibaotrendlistListdelete,tedianlistListdelete,peoplelistListdelete);

					System.out.println("result::"+result);
					if(result==1){
						ajson.put("flag", "1");
					}
					else{
						ajson.put("flag", "0");
					}
			    } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    //}
				 try {
						writeJson(ajson.toJSONString(),resp);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
			public void writeJson(String json, HttpServletResponse response)throws Exception{
			    response.setContentType("text/html");
			    response.setCharacterEncoding("UTF-8");
			    PrintWriter out = response.getWriter();
			    if(StringUtils.isNotEmpty(json)){
			        out.println(json);
			    }
			    out.flush();
			    out.close();
			}
			//灏唈sons
				 public static<T> Object JSONToObj(String jsonStr,Class<T> obj) {
				        T t = null;
				        try {
				            ObjectMapper objectMapper = new ObjectMapper();
				            t = objectMapper.readValue(jsonStr,
				                    obj);
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				        return t;
				    }
	
				/*//鏌ユ壘椤圭洰淇℃伅
					@RequestMapping({ "/selectArea" })
					public String selectArea(HttpServletRequest req,HttpServletResponse resp){
						JSONObject json = new JSONObject();
						int id =Integer.parseInt(req.getParameter("id"));
						HouseProject houseProject=projectInputDao.selectProjectInfo(id);
						req.setAttribute("houseProject", houseProject);
						return "/AreaInfo.jsp";
					}*/
}
