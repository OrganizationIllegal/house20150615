package com.kate.app.dao;

//import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;
public class ImageDao {
	 public static void CopyImage(MultipartFile originfile,String name)throws Exception{
		    //会抛异常，所以我们在主函数中给抛出去
		       try {
		            FileOutputStream out = new FileOutputStream("D:"+ File.separator+"Pictures"+File.separator+"all"+ File.separator+ name);
		            // 写入文件
		            out.write(originfile.getBytes());
		            out.flush();
		            out.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		   }
}
