package com.kate.app.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.RegionPeopleDao;
import com.kate.app.model.AreaPeopleInfo;
import com.kate.app.model.FamilyIncome;
import com.kate.app.model.PeopleForeign;
import com.kate.app.model.PeopleInfo;
import com.kate.app.model.PeopleNation;
@Service
public class PeopleInfoService {
	@Autowired
	private RegionPeopleDao regionPeopleDao;
	
	public List<AreaPeopleInfo> getAreaPeopleInfo(String area_code){
		List<AreaPeopleInfo> list=regionPeopleDao.getAreaPeopleInfo(area_code);
		DecimalFormat df = new DecimalFormat("#,###,###");
		DecimalFormat df1=new DecimalFormat("0.00");
		String zx2 = "";
		String zx3 = "";
		for(int i=0;i<list.size();i++){
			String c1=list.get(i).getColumn1();
			String c2=list.get(i).getColumn2();
			String c3=list.get(i).getColumn3();
			if("周薪".equals(c1)){
				if(c2!=null && !"".equals(c2)){
					zx2=df.format(Integer.parseInt(c2));
				}
				if(c3!=null && !"".equals(c3)){
					zx3=df.format(Integer.parseInt(c3));
				}
				
				list.get(i).setColumn2(zx2);
				list.get(i).setColumn3(zx3);			
			}
			if(c2.contains("0.")){
				float f2=Float.parseFloat(c2)*100;
				list.get(i).setColumn2(df1.format(f2)+"%");
			}
			if(c3.contains("0.")){
				float f3=Float.parseFloat(c3)*100;
				list.get(i).setColumn3(df1.format(f3)+"%");
			}
		}
		return list;
	}
	
	public List<PeopleInfo> getPeopleInfo(){
		List<PeopleInfo> peopleInfoList=regionPeopleDao.getPeopleInfo();
		return peopleInfoList;
	}
	public List<PeopleNation> getPeopleNation(){
		List<PeopleNation> peopleNationList=regionPeopleDao.getPeopleNation();
		return peopleNationList;
	}
	public List<PeopleForeign>  getPeopleForeign(){
		List<PeopleForeign> peopleForeignList=regionPeopleDao.getPeopleForeign();
		return peopleForeignList;
	}
	public List<FamilyIncome> getFamilyIncome(){
		List<FamilyIncome> familyIncomeList=regionPeopleDao.getFamilyIncome();
		return familyIncomeList;
	}
}
