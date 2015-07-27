$(function(){
	
	//锟矫碉拷片锟斤拷娌ワ拷锟�-锟斤拷始
	//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
	//jQuery(".ad_position .limit .ad_small_box ul li:eq(0)").css("opacity","1");
	var animate_time=200;//锟斤拷锟斤拷时锟戒：0.3锟斤拷
	var interval_time=5000;//锟斤拷锟脚硷拷锟绞憋拷洌�锟斤拷
	var ad_size=jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").size()-1;//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	var ad_huandeng_click_i = 0;//锟斤拷始锟斤拷
	
	//循锟斤拷锟斤拷锟斤拷
	function ad_huandeng_play(){
		
		ad_huandeng_click_i++;

		if(ad_huandeng_click_i<=ad_size)
			{jQuery(".ad_small_box_p ul li").eq(ad_huandeng_click_i).trigger("dblclick");}
		else
			{jQuery(".ad_small_box_p ul li").eq(0).trigger("dblclick");ad_huandeng_click_i = 0}
	}
	//锟斤拷锟斤拷循锟斤拷时锟戒，锟皆讹拷锟斤拷始循锟斤拷
	var ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);
	
	//锟斤拷停锟斤拷锟斤拷锟斤拷锟绞憋拷锟斤拷锟酵Ｖ�
	jQuery(".ad_position_p").hover(function(){clearInterval(ad_huandeng_setInterval);}, function(){ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);});
	
	//小图锟斤拷锟绞憋拷锟斤拷锟绞硷拷锟斤拷锟�
	jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").dblclick(function(){
		ad_huandeng_click_i=jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").index(jQuery(this));		
		jQuery(".ad_position_p .limit_p .ad_left_big_p").animate({"margin-top":ad_huandeng_click_i*-487},{duration:animate_time,queue:false});//锟斤拷图锟斤拷锟斤拷
		if(ad_huandeng_click_i<ad_size)//锟斤拷小图锟斤拷锟斤拷锟斤拷锟斤拷锟绞撅拷锟斤拷锟绞憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			{
				if(ad_huandeng_click_i==0||ad_huandeng_click_i==1)
					{jQuery(".ad_position_p .limit_p .ad_small_box_p ul").animate({"margin-top":"0px"},{duration:animate_time,queue:false});}
				else
					{
						jQuery(".ad_position_p .limit_p .ad_small_box_p ul").animate({"margin-top":(ad_huandeng_click_i-1)*-150},{duration:animate_time,queue:false});
					}
			}		
		if(ad_huandeng_click_i==0)//锟斤拷始锟叫讹拷指示锟斤拷图片锟斤拷位锟斤拷
			{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top","0px");}
		else if(ad_huandeng_click_i==ad_size)
			{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top","300px");}
		else
			{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top","150px");}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
		//锟叫讹拷锟斤拷锟铰帮拷钮锟角凤拷傻锟斤拷
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
	
	//锟斤拷锟斤拷锟叫⊥硷拷锟斤拷锟酵Ｊ憋拷锟斤拷锟斤拷锟狡讹拷
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
					{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top",this_ad_top-150);}
				else
					{{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top",this_ad_top-300);}}
			}
		else if(small_ad_hover_i>ad_huandeng_click_i)
			{
				if(small_ad_hover_i-ad_huandeng_click_i==1)
					{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top",this_ad_top+150);}
				else
					{{jQuery(".ad_position_p .limit_p .ad_small_box_p .small_right_limit_p .this_ad_p").css("top",this_ad_top+300);}}
			}
		ad_huandeng_click_i=small_ad_hover_i;
		//锟叫讹拷锟斤拷锟铰帮拷钮锟角凤拷傻锟斤拷
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
	
	//锟斤拷锟斤拷锟斤拷习锟脚ナ�
	jQuery(".ad_small_box_p .top_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i-1;
		if(ad_huandeng_click_i<0)
			{ad_huandeng_click_i=0;}		
		jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
	//锟斤拷锟斤拷锟斤拷掳锟脚ナ�
	jQuery(".ad_small_box_p .bottom_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i+1;
		if(ad_huandeng_click_i>=ad_size)
			{
				ad_huandeng_click_i=ad_size;
				jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").eq(ad_huandeng_click_i).trigger("dblclick");
				jQuery(".ad_position_p .limit_p .ad_small_box_p ul").animate({"margin-top":(ad_huandeng_click_i-2)*-150},{duration:animate_time,queue:false});
			}
		
		jQuery(".ad_position_p .limit_p .ad_small_box_p ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
	//锟矫碉拷片锟斤拷娌ワ拷锟�
});