package com.kate.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.HouseProjectDao;
import com.kate.app.dao.SuggestionDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.Suggestion;
import com.kate.app.model.SuggestionProject;

@Service
public class SuggestionService {
	@Autowired
    private SuggestionDao suggestionDao;
	@Autowired
    private HouseProjectDao houseProjectDao;
	
	private  final static String SUGGESTION = "data1.txt";
	private  final static String SUGGESTIONRECO = "dataReco.txt";
	private  final static String SUGGESTIONMap = "dataMap.txt";
	private  final static String SUGGESTIONFuwu = "dataFuwu.txt";
	private  final static String SUGGESTIONSuozai = "dataSuozai.txt";
	private final static String URL = "D:/";
	
	/*
	 * suggestion读取文件信息，匹配用户的query
	 */
	public List<String>  getSuggestion(String query) throws IOException{
		List<String[]> list = new ArrayList<String[]>();
		String path = URL + SUGGESTION;   //文件的路径
		
		List<String> resultList = new ArrayList<String>();
		//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while (reader.ready()) {    //文件内容的读取
			String line = reader.readLine();
			String args[] = line.split(";");   //通过;截取得到字符串数组
			list.add(args);
		}
		reader.close();
		
		for(String[] strs : list){     
			int temp=-1;
			if(strs.length==1){   //长度为1
				if(strs[0].toUpperCase().startsWith(query.toUpperCase())){   //java的首字符匹配
					resultList.add(strs[0]);
				}
			}
			else if(strs.length==2){
				//String[] listCode = strs[2].split(",");    //通过,得到字符串数组
				if(strs[0].toUpperCase().startsWith(query.toUpperCase())){   //将第一个字符串用java的前缀进行匹配
					String str = strs[0] + "," + strs[1];
					resultList.add(str);
				}
			}
			else{
				String[] listCode = strs[2].split(",");    //通过,得到字符串数组
				
				if(listCode[1].toUpperCase().startsWith(query.toUpperCase())){   //将第一个字符串用java的前缀进行匹配
					String str = strs[0] + "," + strs[1] +"," + listCode[0]+" "+listCode[1];
					resultList.add(str);
				}
				for(int i = 0; i < strs.length-1; i++){
					if(strs[i].toUpperCase().startsWith(query.toUpperCase())){
						temp = i;
						break;
					}
				}
				
				if(temp==0){
					String str = strs[0];
					str = str + "," + strs[1] +"," + strs[2];
					resultList.add(str);
				}else if(temp==2){
					String str = strs[2];
					str = strs[0] + "," + strs[1] +"," + str;
					resultList.add(str);
				}
				
				else if(temp==1){
					String str = strs[1];
					str = strs[0] + "," + str +"," + strs[2];
					resultList.add(str);
				}
				
			}
			
			
			
		}
		
				return resultList;
		
	}
	
	/*
	 * suggestion用到的文件
	 */
	public void writeFileByName() {
		File docFile = new File("D:/data1.txt");
		try {
			docFile.createNewFile();
			FileOutputStream txtfile = new FileOutputStream(docFile);
			PrintStream p = new PrintStream(txtfile);
			
			List<SuggestionProject> projectList = suggestionDao.getProjectSearch();   //数据库查找项目名称和所在的州
			
			List<String> zhouList = suggestionDao.getProjectZhou();   //查询项目所在的州
			List<AreaInfo> areaList = suggestionDao.getAreaInfo();   //查询区域信息
			List<String> cityList = suggestionDao.getProjectCity();  //查询项目所在的城市
			List<String> cityList1 = suggestionDao.getProjectCityAndZhou();  //查询项目所在的城市
			
			List<Suggestion> list = new ArrayList<Suggestion>();
			for(AreaInfo item : areaList){
				Suggestion data = new Suggestion();
				String areaNum = item.getArea_num();
				HouseProject project = null;
				String proNum = null;
				if(areaNum!=null && !"".equals(areaNum)){
					project = houseProjectDao.HouseProjectByAreaNumDao(areaNum);  //通过区域编号查找项目信息
				}
				if(project!=null){
					proNum = project.getProject_num();
				}
				data.setArea_name(item.getArea_name());
				data.setArea_city(item.getArea_city());
				//data.setArea_nation(item.getArea_nation());
				data.setArea_postcode(item.getArea_postcode());
				data.setArea_zhou(item.getArea_zhou());
				data.setProNum(proNum);
				list.add(data);
			}
			
			/*for(Suggestion item : list){     //区域名称
				p.append(item.getArea_name()+"\r\n");
			}
			for(String zhou : zhouList){
				p.append(zhou+"\r\n");
			}
			for(String city : cityList){
				p.append(city+"\r\n");
			}*/
			
			for(String city : cityList1){
				p.append(city+"\r\n");
			}
			
			for(SuggestionProject item : projectList){   //将项目名称写入文件
				p.append(item.getProject_name()+"\r\n");
			}
			for(Suggestion item : list){
				String post = item.getArea_postcode();  //将区域编号写入文件
				String code = "";
				if(post==null || "".equals(post)){
					code = item.getArea_zhou()+","+"0000";   //将区域州名和编号写入文
				}
				else{
					code = item.getArea_zhou()+","+item.getArea_postcode();
				}
				String result = item.getArea_name()+";"+item.getArea_city()+";"+code;
				String proNumber = item.getProNum();
				if(proNumber==null || proNumber.equals("")){
					result = result+";"+"";
				}
				else{
					result = result+";"+item.getProNum();
				}
				p.append(result+"\r\n");
			}
			
			/*for(Suggestion item : list){
				
				String result = item.getArea_city()+";"+item.getArea_zhou();
				
				p.append(result+"\r\n");
			}*/
			
			//p.println(proName);
			txtfile.close();
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 推荐项目列表，文件读取，目前不用
	 */
	public List<String>  getSuggestionReco() throws IOException{
		List<String[]> list = new ArrayList<String[]>();
		String path = URL + SUGGESTIONRECO;
		
		List<String> resultList = new ArrayList<String>();
		//BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
		BufferedReader reader = new BufferedReader(new FileReader(path));
		while (reader.ready()) {
			String line = reader.readLine();
			resultList.add(line);
		}
		reader.close();
		
			return resultList;
	}
	
	
	/*
	 *  地图页面地址的推荐列表，文件读取，目前不用
	 */
	
	public List<String>  getSuggestionMap(String query) throws IOException{
		List<String[]> list = new ArrayList<String[]>();
		String path = URL + SUGGESTIONMap;
		
		List<String> resultList = new ArrayList<String>();
		List<String> listLast = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
		//BufferedReader reader = new BufferedReader(new FileReader(path));
		while (reader.ready()) {
			String line = reader.readLine();
			resultList.add(line);
		}
		reader.close();
		for(String e: resultList){
			if(e.trim().toUpperCase().startsWith(query.toUpperCase())){
				listLast.add(e);
				System.out.println(e);
			}
		}
			return listLast;
	}
	
	/*
	 *  服务团队服务区域推荐列表，文件读取，目前不用
	 */
	public List<String>  getSuggestionFuwu(String query) throws IOException{
		List<String[]> list = new ArrayList<String[]>();
		String path = URL + SUGGESTIONFuwu;
		
		List<String> resultList = new ArrayList<String>();
		List<String> listLast = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
		//BufferedReader reader = new BufferedReader(new FileReader(path));
		while (reader.ready()) {
			String line = reader.readLine();
			resultList.add(line);
		}
		reader.close();
		for(String e: resultList){
			if(e.trim().toUpperCase().startsWith(query.toUpperCase())){
				listLast.add(e);
				System.out.println(e);
			}
		}
			return listLast;
	}
	
	
	/*
	 *  服务团队所在区域推荐列表，文件读取，目前不用
	 */
	
	public List<String>  getSuggestionSuozai(String query) throws IOException{
		List<String[]> list = new ArrayList<String[]>();
		String path = URL + SUGGESTIONSuozai;
		
		List<String> resultList = new ArrayList<String>();
		List<String> listLast = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
		//BufferedReader reader = new BufferedReader(new FileReader(path));
		while (reader.ready()) {
			String line = reader.readLine();
			resultList.add(line);
		}
		reader.close();
		for(String e: resultList){
			if(e.trim().toUpperCase().startsWith(query.toUpperCase())){
				listLast.add(e);
				System.out.println(e);
			}
		}
			return listLast;
	}
	
	/*
	 * 将推荐的地图页的地址存入文件中，现在不用
	 */
	public void writeFileByMap() {
		File docFile = new File("D:/dataMap.txt");
		try {
			docFile.createNewFile();
			FileOutputStream txtfile = new FileOutputStream(docFile);
			PrintStream p = new PrintStream(txtfile);
			
			List<String> addList = suggestionDao.getProjectAdd();

			for(String add : addList){
				p.append(add+"\r\n");
			}

			txtfile.close();
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 将经纪人的服务区域写入文件
	 */
	public void writeFileByFuwu() {
		File docFile = new File("D:/dataFuwu.txt");
		try {
			docFile.createNewFile();
			FileOutputStream txtfile = new FileOutputStream(docFile);
			PrintStream p = new PrintStream(txtfile);
			
			List<String> addList = suggestionDao.getFuwuQuyu();

			for(String add : addList){
				p.append(add+"\r\n");
			}

			txtfile.close();
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 将经纪人的所在区域写入文件
	 */
	public void writeFileBySuozai() {
		File docFile = new File("D:/dataSuozai.txt");
		try {
			docFile.createNewFile();
			FileOutputStream txtfile = new FileOutputStream(docFile);
			PrintStream p = new PrintStream(txtfile);
			
			List<String> addList = suggestionDao.getSuozaiQuyu();

			for(String add : addList){
				p.append(add+"\r\n");
			}

			txtfile.close();
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

