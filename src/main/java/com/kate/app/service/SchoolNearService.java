package com.kate.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.SchoolNearDao;
import com.kate.app.model.NearPeiTao;
import com.kate.app.model.NearSchool;

@Service
public class SchoolNearService {
	@Autowired
	private SchoolNearDao schoolNearDao;
	public List<NearSchool> getNearSchoolInfo(String proNum){
		List<NearSchool> nearSchoolList=schoolNearDao.getNearSchoolInfoNew(proNum);
		for(NearSchool item : nearSchoolList){
			if(item!=null){
				String name = item.getSchool_name();
				if(name!=null && !"".equals(name)){
					name = name.replace("&nbsp;", " ");
				}
				item.setSchool_name(name);
				String name1 = item.getSchool_name();
				if(name1!=null && !"".equals(name1)){
					String type = schoolNearDao.getNearSchoolInfoByType(name1);
					item.setSchool_type(type);
				}
			}
			
		}
		
		return nearSchoolList;
	}
	public List<NearPeiTao> getNearSchoolFacilityInfo(String proNum){
		List<NearPeiTao> nearSchoolFacility=schoolNearDao.getNearSchoolFacilityInfo(proNum);
		return nearSchoolFacility;
	}

}
