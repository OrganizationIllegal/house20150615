$(function(){
	//�õ�Ƭ��沥��--��ʼ
	//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
	//jQuery(".ad_position .limit .ad_small_box ul li:eq(0)").css("opacity","1");
	var animate_time=200;//����ʱ�䣺0.3��
	var interval_time=5000;//���ż��ʱ�䣺5��
	var ad_size=jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").size()-1;//�����������
	var ad_huandeng_click_i = 0;//��ʼ��
	
	//ѭ������
	function ad_huandeng_play(){
		
		ad_huandeng_click_i++;

		if(ad_huandeng_click_i<=ad_size)
			{jQuery(".ad_small_box_p ul li").eq(ad_huandeng_click_i).trigger("dblclick");}
		else
			{jQuery(".ad_small_box_p ul li").eq(0).trigger("dblclick");ad_huandeng_click_i = 0}
	}
	//����ѭ��ʱ�䣬�Զ���ʼѭ��
	var ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);
	
	//��ͣ�������ʱ����ֹͣ
	jQuery(".ad_position_p").hover(function(){clearInterval(ad_huandeng_setInterval);}, function(){ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);});
	
	//Сͼ���ʱ����ʼ����
	jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").dblclick(function(){
		ad_huandeng_click_i=jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").index(jQuery(this));		
		jQuery(".ad_position_p .limit_p .ad_left_big_p").animate({"margin-top":ad_huandeng_click_i*-487},{duration:animate_time,queue:false});//��ͼ����
		if(ad_huandeng_click_i<ad_size)//��Сͼ���������ʾ����ʱ����������
			{
				if(ad_huandeng_click_i==0||ad_huandeng_click_i==1)
					{jQuery(".ad_position_p .limit_p .ad_small_box_p ul").animate({"margin-top":"0px"},{duration:animate_time,queue:false});}
				else
					{
						jQuery(".ad_position_p .limit_p .ad_small_box_p ul").animate({"margin-top":(ad_huandeng_click_i-1)*-144},{duration:animate_time,queue:false});
					}
			}		
		if(ad_huandeng_click_i==0)//��ʼ�ж�ָʾ��ͼƬ��λ��
			{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top","0px");}
		else if(ad_huandeng_click_i==ad_size)
			{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top","288px");}
		else
			{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top","144px");}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
		//�ж����°�ť�Ƿ�ɵ��
		if(ad_huandeng_click_i==0)
			{
				jQuery(".ad_small_box_p .top_button").addClass("off");
//				jQuery(".ad_small_box_p .bottom_button").removeClass("off");
			}
		else if(ad_huandeng_click_i==ad_size)
			{
//				jQuery(".ad_small_box_p .top_button").removeClass("off");
				jQuery(".ad_small_box_p .bottom_button").addClass("off");
			}
		else 
			{
//				jQuery(".ad_small_box_p .top_button").removeClass("off");
//				jQuery(".ad_small_box_p .bottom_button").removeClass("off");
			}
	});
	
	//�����Сͼ����ͣʱ������ƶ�
	jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").mouseover(function(){		
		var small_ad_hover_i = jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").index(jQuery(this));
		var this_ad_top=jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top");
		this_ad_top=parseInt(this_ad_top);
		jQuery(".ad_position_p .limit_p .ad_left_big_p").animate({"margin-top":small_ad_hover_i*-487},{duration:animate_time,queue:false});if(small_ad_hover_i!=ad_huandeng_click_i);
		if(small_ad_hover_i==0)
			{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top","0px");}
		else if(small_ad_hover_i<ad_huandeng_click_i)
			{
				if(ad_huandeng_click_i-small_ad_hover_i==1)
					{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top",this_ad_top-144);}
				else
					{{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top",this_ad_top-288);}}
			}
		else if(small_ad_hover_i>ad_huandeng_click_i)
			{
				if(small_ad_hover_i-ad_huandeng_click_i==1)
					{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top",this_ad_top+144);}
				else
					{{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top",this_ad_top+288);}}
			}
		ad_huandeng_click_i=small_ad_hover_i;
		//�ж����°�ť�Ƿ�ɵ��
		if(ad_huandeng_click_i==0)
			{
				jQuery(".ad_small_box_p .top_button").addClass("off");
//				jQuery(".ad_small_box_p .bottom_button").removeClass("off");
			}
		else if(ad_huandeng_click_i==ad_size)
			{
//				jQuery(".ad_small_box_p .top_button").removeClass("off");
				jQuery(".ad_small_box_p .bottom_button").addClass("off");
			}
		else
			{
//				jQuery(".ad_small_box_p .top_button").removeClass("off");
//				jQuery(".ad_small_box_p .bottom_button").removeClass("off");
			}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
	});	
	
	//������ϰ�ťʱ
	jQuery(".ad_small_box_p .top_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i-1;
		if(ad_huandeng_click_i<0)
			{ad_huandeng_click_i=0;}		
		jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
	//������°�ťʱ
	jQuery(".ad_small_box_p .bottom_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i+1;
		if(ad_huandeng_click_i>=ad_size)
			{
				ad_huandeng_click_i=ad_size;
				jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").eq(ad_huandeng_click_i).trigger("dblclick");
				jQuery(".ad_position_p .limit_p .ad_small_box_p ul").animate({"margin-top":(ad_huandeng_click_i-2)*-144},{duration:animate_time,queue:false});
			}
		
		jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
	//�õ�Ƭ��沥��
});