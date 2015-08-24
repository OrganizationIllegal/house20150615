 var map = null;
 var defaultInfobox;
 var defaltCenter=new Microsoft.Maps.Location( -25.585241, 134.504120);  




      /*加载地图*/
      function getMap()
      {
    	
    	
       //生成地图
       map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
      
       if(liandong1 == 1){
    	  var time1 = 0;
    	  $.ajax({
		 	    type: "GET",
		 		dateType: "json",
		 		url: "/BingMap/Coordinates01", 		
		 		success:function(data){
		        //alert(data)
		 		data=$.parseJSON(data);
		 		
		 		    var items=data.List;
		 		    var itemsNation1=data.ListNation1;
		 		    var itemsNation2=data.ListNation2;
		 		    var itemsZhou1=data.ListZhou1;
		 		    var itemsZhou2=data.ListZhou2;
		 		    var itemsCity1=data.ListCity1;
		 		    var itemsCity2=data.ListCity2;
		 		    var itemsArea1=data.ListArea1;
		 		    var itemsArea2=data.ListArea2;
		 		   /* var itemsCentermoren=data.ListCentermoren;
		 		    var lenCentermoren=itemsCentermoren.length;*/
		 		    var lenItems=items.length;
		 		    var a=new Array();
		 		    var Zoom;
		 		    if(lenItems!=0){
		 		    	a=items[0].gps.split(",");
		 		    	Zoom=4;	 		    	
		 		    }
		 		    else{
		 		    	a[0]="-25.585241";
			 		    a[1]="134.504120";
			 		    Zoom=5;
		 		    }
		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
		 		    //设置地图中心点和层级
		 		    map.setView({ zoom: Zoom, center: Center });	
		 		    lastZoomLevel = map.getZoom();
		 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
		 	        	//联动
		 	        	 var bounds=map.getBounds();
		            	 var zuoshang=bounds.getNorthwest();
		                 var youxia=bounds.getSoutheast();
		                 var zs1=zuoshang.latitude;
		                 var zs2=zuoshang.longitude;
		                 var yx1=youxia.latitude;
	                     var yx2=youxia.longitude;
		                 //alert('Map zuoshang: ' +  zuoshang);
		                 //alert('Map youxia: ' +  youxia);
	                     time1++;
	              	   //alert(time+"time")
	                     if(time1!=1){
	                    	 $.ajax({
	 		     		 	    type: "POST",
	 		     		 		dateType: "json",
	 		     		 		url: "/BingMap1/filterByGPS1",	
	 		     		 		data:{gpsLeftX:zs1,gpsLeftY:zs2,gpsRightX:yx1,gpsRightY:yx2},
	 		     		 		success:function(data){
	 		     		       
	 		     		 		data=$.parseJSON(data);
	 		     		 		
	 		     		 		//alert(data.List)
	 		     		 		 var html = getHtml1(data.List);
	 		     		 		
	 		     		 		 $("#left").html(html);  
	 		     		 		  
	 		     		 	    },
	 		     		 
	 		     		 		error:function(){
	 		     		 			//alert("addDefaultPushpin error")
	 		     		 		}
	 		     	        });
	                     }
		                 
		                 if(lastZoomLevel != map.getZoom()){
			 	               lastZoomLevel = map.getZoom();
			 	            //注册鼠标上移事件
 			 	              $(document).on("mouseenter","#left >.div_node",function(){
 		 	             			$(this).css("background-color","rgb(223,223,223)");
 		 	             			var nation=$(this).children().first().text();
 		 	             			var zhou=$(this).children().first().next().text();
 		 	             			var city=$(this).children().first().next().next().text();
 		 	             			var area=$(this).children().first().next().next().next().text();
 		 	             			var href=$(this).children().first().next().next().next().next().next().attr("href");
 		 	             			var arr=new Array();
 		 	             			arr = href.split("=");
 		 	             			var proNum=arr[1];
 		 	             			//alert(proNum);
 		 	             			var arr3=new Array();
 	                 		 		var LA3;
 	                 		 		var total2;
 	                 		 		var pushpinOptions3;
 	                 		 		var pushpin3;
 	                 		 		//项目名
 	                 		 		if(lastZoomLevel>10){
 	                 		 		map.entities.clear();
 	                 		 		for(var p=0;p<lenItems;p++){
 	                 		 	        arr3=items[p].gps.split(",");
 	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
 	                 		 	        var num=items[p].project_num;
   			 	 	 		            var name=items[p].project_name;
   			 	 	 		            var image=items[p].project_img;
   			 	 	 		            var img=imgdir+"/"+image;	 		        
   			 	 	 		            var price=items[p].project_min_price;
   			 	 	 		            var type=items[p].project_type;
 	    			 	 	 		    if(proNum==num){
 	    			 	 	 		    	//map.entities.remove(LA3);
 	                 		 				pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin3.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add(name,type,img,price,num,pushpin3,LA3);
 	    		 	                  	    map.entities.push(pushpin3);
 	    			 	 	 		    }else{
 	    			 	 	 		    	pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
 	    			 	 	 		    	pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add(name,type,img,price,num,pushpin3,LA3);
 	    		 	                  	    map.entities.push(pushpin3);
 	    			 	 	 		    }
 	                 		 		}	
 	                 		 		}
 	                 		 	    //区域
 	                 		 		else if(lastZoomLevel>8){
 	                 		 		map.entities.clear();
 	                 		 		for(var a=0;a<lenArea;a++){
 			 	            	        arr3=itemsArea2[a].gps.split(",");
 			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 			 	            	        var area3=itemsArea2[a].project_area;
 			 	            	        total2=String(itemsArea1[a].area);
 	                 		 			if(area==area3){
 	                 		 				//map.entities.remove(LA3);
 	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea2.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add2(area3,pushpin3,LA3);
 	                 		 				addmouse_out(pushpin3);
 	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	    		 	                  	        map.entities.push(pushpin3);
 		                    		 		}else{
 		                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
     	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
     	                 		 				add2(area3,pushpin3,LA3);
     	                 		 				addmouse_out(pushpin3);
     	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
     	    		 	                  	        map.entities.push(pushpin3);
 		                    		 		}
 	                 		 		}	 	                    		 		
 	                 		 		}
 	                 		 		//城市
 	                 		 		else if(lastZoomLevel>6){
 	                 		 			map.entities.clear();
 	                 		 			for(var c=0;c<lenCity;c++){
 	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
 	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 	 	   		 	            	        var city3=itemsCity2[c].project_city;
 	 	   		 	            	        total2=String(itemsCity1[c].city);
 	 	                    		 			if(city==city3){
 	 	                    		 				//map.entities.remove(LA3);
 	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity2.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(city3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);
 		 	                    		 			
 		 	                    		 		}else{
 		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(city3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);
 		 	                    		 		}
 	 	                    		 		}	
 	                 		 		}
 	                 		 	//州
 	                 		 		else if(lastZoomLevel>4){
 	                 		 			map.entities.clear();
 	                 		 			for(var z=0;z<lenZhou;z++){
 		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
 		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
 		   		 	            	            total2=String(itemsZhou1[z].zhou);
 		                    		 			if(zhou==zhou3){
 		                    		 				//map.entities.remove(LA3);
 		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou2.png'};
 		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 		                    		 				add2(zhou3,pushpin3,LA3);
 		                    		 				addmouse_out(pushpin3);
 		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 		       		 	                  	        map.entities.push(pushpin3);
 	 	                    		 			
 	 	                    		 		}else{
 	 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);
 	 	                    		 		}
 		                    		 		}
 	                 		 		}
 	                 		 	 // 国家
 	                 		 		else{
 	                 		 			map.entities.clear();
 	                 		 			for(var n=0;n<lenNation;n++){
 	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
 	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
 	 	   		 	            	        var pronum=itemsNation2[n].project_num;
 	 	   		 	            	        total2=String(itemsNation1[n].nation);
 	 	                    		 			if(nation==nation3){
 	 	                    		 				//map.entities.remove(LA3);
 	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(nation3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);
 		 	                    		 			
 		 	                    		 		}else{
 		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(nation3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);
 		 	                    		 		}
 	 	                    		 		}
 	                 		 		}
 		 	             		})
 		 	             		 //注册鼠标离开事件
 		 	             		$(document).on("mouseleave","#left >.div_node",function(){
 		 	             			$(this).css("background-color","white");
 		 	             			var arr3=new Array();
 	                 		 		var LA3;
 	                 		 		var total2;
 	                 		 		var pushpinOptions3;
 	                 		 		var pushpin3;
 	                 		 		//项目名
 	                 		 		if(lastZoomLevel>10){
 	                 		 		map.entities.clear();
 	                 		 		for(var p=0;p<lenItems;p++){
 	                 		 	        arr3=items[p].gps.split(",");
 	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
 	                 		 	        var num=items[p].project_num;
   			 	 	 		            var name=items[p].project_name;
   			 	 	 		            var image=items[p].project_img;
   			 	 	 		            var img=imgdir+"/"+image;	 		        
   			 	 	 		            var price=items[p].project_min_price;
   			 	 	 		            var type=items[p].project_type;  	    			 	 	 
 	                 		 			pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
 	                 		 			pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 			add(name,type,img,price,num,pushpin3,LA3);
 	    		 	                  	map.entities.push(pushpin3);    	    			 	 	 		    
 	                 		 		}	
 	                 		 		}
 	                 		 	    //区域
 	                 		 		else if(lastZoomLevel>8){
 	                 		 		map.entities.clear();
 	                 		 		for(var a=0;a<lenArea;a++){
 			 	            	        arr3=itemsArea2[a].gps.split(",");
 			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 			 	            	        var area3=itemsArea2[a].project_area;
 			 	            	        total2=String(itemsArea1[a].area);	
 	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add2(area3,pushpin3,LA3);
 	                 		 				addmouse_out(pushpin3);
 	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	    		 	                  	        map.entities.push(pushpin3);	                    		 		
 	                 		 		}	 	                    		 		
 	                 		 		}
 	                 		 		//城市
 	                 		 		else if(lastZoomLevel>6){
 	                 		 			map.entities.clear();
 	                 		 			for(var c=0;c<lenCity;c++){
 	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
 	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 	 	   		 	            	        var city3=itemsCity2[c].project_city;
 	 	   		 	            	        total2=String(itemsCity1[c].city);
 	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(city3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);  		 	                    		 		
 	 	                    		 		}	
 	                 		 		}
 	                 		 	//州
 	                 		 		else if(lastZoomLevel>4){
 	                 		 			map.entities.clear();
 	                 		 			for(var z=0;z<lenZhou;z++){
 		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
 		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
 		   		 	            	            total2=String(itemsZhou1[z].zhou);
 		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
 		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 		                    		 				add2(zhou3,pushpin3,LA3);
 		                    		 				addmouse_out(pushpin3);
 		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 		       		 	                  	        map.entities.push(pushpin3);                   		 		
 		                    		 		}
 	                 		 		}
 	                 		 	 // 国家
 	                 		 		else{
 	                 		 			map.entities.clear();
 	                 		 			for(var n=0;n<lenNation;n++){
 	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
 	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
 	 	   		 	            	        var pronum=itemsNation2[n].project_num;
 	 	   		 	            	        total2=String(itemsNation1[n].nation);
 	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(nation3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);   		 	                    		 		
 	 	                    		 		}
 	                 		 		}
 		 	             		})
			 	               if(lastZoomLevel>10){
			 	            	  map.entities.clear();
			 	            	  for(var i=0;i<items.length;i++){
			 	 	 		        var arr=new Array();
			 	 	 		        arr=items[i].gps.split(",");
			 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
			 	 	 		        var num=items[i].project_num;
			 	 	 		        var name=items[i].project_name;
			 	 	 		        var image=items[i].project_img;
			 	 	 		        var img=imgdir+"/"+image;	 		        
			 	 	 		       /* var minprice=items[i].project_min_price;
			 	 	 		        var maxprice=items[i].project_high_price;*/
			 	 	 		        var city=items[i].project_city;
			 	 	 		        //var price=items[i].project_price_int_qi;
			 	 	 		        var price=items[i].project_min_price;
			 	 	 		        var type=items[i].project_type;
			 	 	 		        var pushpinOptions = {width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'}; 
			 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
			 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
			 	 				    add(name,type,img,price,num,pushpin,LA);
			 	 				    map.entities.push(pushpin);	
			 	 	 		    }	 	            	   
			 	               }else if(lastZoomLevel>8){		 	            	  
			 	            	    map.entities.clear();
			 	            	    var lenArea=itemsArea1.length;
			 	            	    for(var j=0;j<lenArea;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=itemsArea2[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var area2=itemsArea2[j].project_area;
			 	            	        var total=String(itemsArea1[j].area);
			 	            	        //alert(typeof(total))
			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
			 	            	        add2(area2,pushpin2,LA2);
			 	            	        addmouse_out(pushpin2);
			 	            	        add3(lastZoomLevel,pushpin2,LA2);
			 	                  	    map.entities.push(pushpin2);
			 	            	    }
			 	               }else if(lastZoomLevel>6){
			 	            	    map.entities.clear();
			 	            	    var lenCity=itemsCity1.length;
			 	            	    for(var j=0;j<lenCity;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=itemsCity2[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var city2=itemsCity2[j].project_city;
			 	            	        var total=String(itemsCity1[j].city);
			 	            	        //alert(typeof(total))
			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
			 	            	        add2(city2,pushpin2,LA2);
			 	            	        addmouse_out(pushpin2);
			 	            	        add3(lastZoomLevel,pushpin2,LA2);
			 	                  	    map.entities.push(pushpin2);
			 	            	    }
			 	               }else if(lastZoomLevel>4){
			 	            	    map.entities.clear();
			 	            	    var lenZhou=itemsZhou1.length;
			 	            	    for(var j=0;j<lenZhou;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=itemsZhou2[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var zhou2=itemsZhou2[j].project_zhou;
			 	            	        var total=String(itemsZhou1[j].zhou);
			 	            	        //alert(typeof(total))
			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
			 	            	        add2(zhou2,pushpin2,LA2);
			 	            	       addmouse_out(pushpin2);
			 	            	        add3(lastZoomLevel,pushpin2,LA2);
			 	                  	    map.entities.push(pushpin2);
			 	            	    }
			 	               }else{
			 	            	    map.entities.clear();
			 	            	    var lenNation=itemsNation1.length;
			 	            	    for(var j=0;j<lenNation;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=itemsNation2[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var nation2=itemsNation2[j].project_nation;
			 	            	        var total=String(itemsNation1[j].nation);
			 	            	        //alert(nation2);
			 	            	        //var shownation=nation2+'\r\n'+total;
			 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin2.png' style='width:100px;'/></div>"}; */
			 	            	        var pushpinOptions2={text:total,width: 42, height: 42,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
			 	            	        add2(nation2,pushpin2,LA2);
			 	            	       addmouse_out(pushpin2);
			 	            	        add3(lastZoomLevel,pushpin2,LA2);
			 	                  	    map.entities.push(pushpin2);
			 	            	    }
			 	               }
			 	        	}
		 	        });
		 		   
		 		   
		 		},
		 		error:function(){
		 			//alert("addDefaultPushpin error")
		 		}
	        });	
      }
    	  else{
    		  var time = 0;
    		  $.ajax({
    		 	    type: "GET",
    		 		dateType: "json",
    		 		url: "/BingMap/Coordinates", 		
    		 		success:function(data){
    		        //alert(data)
    		 		data=$.parseJSON(data);
    		 		    var items=data.List;
    		 		    var itemsNation1=data.ListNation1;
    		 		    var itemsNation2=data.ListNation2;
    		 		    var itemsZhou1=data.ListZhou1;
    		 		    var itemsZhou2=data.ListZhou2;
    		 		    var itemsCity1=data.ListCity1;
    		 		    var itemsCity2=data.ListCity2;
    		 		    var itemsArea1=data.ListArea1;
    		 		    var itemsArea2=data.ListArea2;
    		 		   /* var itemsCentermoren=data.ListCentermoren;
    		 		    var lenCentermoren=itemsCentermoren.length;*/
    		 		    var lenItems=items.length;
    		 		    var a=new Array();
    		 		    var Zoom;
    		 		    if(lenItems!=0){
    		 		    	a=items[0].gps.split(",");
    		 		    	Zoom=4;	 		    	
    		 		    }
    		 		    else{
    		 		    	a[0]="-25.585241";
    			 		    a[1]="134.504120";
    			 		    Zoom=5;
    		 		    }
    		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
    		 		    //设置地图中心点和层级
    		 		    map.setView({ zoom: Zoom, center: Center });	
    		 		    lastZoomLevel = map.getZoom();
    		 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
    		 	        	//联动
    		 	        	 var bounds=map.getBounds();
    		            	 var zuoshang=bounds.getNorthwest();
    		                 var youxia=bounds.getSoutheast();
    		                 var zs1=zuoshang.latitude;
    		                 var zs2=zuoshang.longitude;
    		                 var yx1=youxia.latitude;
    	                     var yx2=youxia.longitude;
    	                     time++;
    	                     //alert(time+"ooooooooo")
    		                 if(time!=1){
    		                	 $.ajax({
    	    		     		 	    type: "POST",
    	    		     		 		dateType: "json",
    	    		     		 		url: "/BingMap1/filterByGPS1",	
    	    		     		 		data:{gpsLeftX:zs1,gpsLeftY:zs2,gpsRightX:yx1,gpsRightY:yx2},
    	    		     		 		success:function(data){
    	    		     		       
    	    		     		 		data=$.parseJSON(data);
    	    		     		 		
    	    		     		 		 var html = getHtml1(data.List);
    	    		     		 		 
    	    		     		 		 $("#left").html(html);  
    	    		     		 		  
    	    		     		 	    },
    	    		     		 
    	    		     		 		error:function(){
    	    		     		 			//alert("addDefaultPushpin error")
    	    		     		 		}
    	    		     	        });
    		                 }
    		                 
    		                 if(lastZoomLevel != map.getZoom()){
    			 	               lastZoomLevel = map.getZoom();
    			 	              //注册鼠标上移事件
    			 	              $(document).on("mouseenter","#left >.div_node",function(){
    		 	             			$(this).css("background-color","rgb(223,223,223)");
    		 	             			var nation=$(this).children().first().text();
    		 	             			var zhou=$(this).children().first().next().text();
    		 	             			var city=$(this).children().first().next().next().text();
    		 	             			var area=$(this).children().first().next().next().next().text();
    		 	             			var href=$(this).children().first().next().next().next().next().next().attr("href");
    		 	             			var arr=new Array();
    		 	             			arr = href.split("=");
    		 	             			var proNum=arr[1];
    		 	             			//alert(proNum);
    		 	             			var arr3=new Array();
    	                 		 		var LA3;
    	                 		 		var total2;
    	                 		 		var pushpinOptions3;
    	                 		 		var pushpin3;
    	                 		 		//项目名
    	                 		 		if(lastZoomLevel>10){
    	                 		 		map.entities.clear();
    	                 		 		for(var p=0;p<lenItems;p++){
    	                 		 	        arr3=items[p].gps.split(",");
    	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
    	                 		 	        var num=items[p].project_num;
      			 	 	 		            var name=items[p].project_name;
      			 	 	 		            var image=items[p].project_img;
      			 	 	 		            var img=imgdir+"/"+image;	 		        
      			 	 	 		            var price=items[p].project_min_price;
      			 	 	 		            var type=items[p].project_type;
    	    			 	 	 		    if(proNum==num){
    	    			 	 	 		    	//map.entities.remove(LA3);
    	                 		 				pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin3.png'};
    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	                 		 				add(name,type,img,price,num,pushpin3,LA3);
    	    		 	                  	    map.entities.push(pushpin3);
    	    			 	 	 		    }else{
    	    			 	 	 		    	pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
    	    			 	 	 		    	pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	                 		 				add(name,type,img,price,num,pushpin3,LA3);
    	    		 	                  	    map.entities.push(pushpin3);
    	    			 	 	 		    }
    	                 		 		}	
    	                 		 		}
    	                 		 	    //区域
    	                 		 		else if(lastZoomLevel>8){
    	                 		 		map.entities.clear();
    	                 		 		for(var a=0;a<lenArea;a++){
    			 	            	        arr3=itemsArea2[a].gps.split(",");
    			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
    			 	            	        var area3=itemsArea2[a].project_area;
    			 	            	        total2=String(itemsArea1[a].area);
    	                 		 			if(area==area3){
    	                 		 				//map.entities.remove(LA3);
    	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea2.png'};
    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	                 		 				add2(area3,pushpin3,LA3);
    	                 		 				addmouse_out(pushpin3);
    	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    	    		 	                  	        map.entities.push(pushpin3);
    		                    		 		}else{
    		                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
        	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
        	                 		 				add2(area3,pushpin3,LA3);
        	                 		 				addmouse_out(pushpin3);
        	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
        	    		 	                  	        map.entities.push(pushpin3);
    		                    		 		}
    	                 		 		}	 	                    		 		
    	                 		 		}
    	                 		 		//城市
    	                 		 		else if(lastZoomLevel>6){
    	                 		 			map.entities.clear();
    	                 		 			for(var c=0;c<lenCity;c++){
    	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
    	 	   		 	            	        var city3=itemsCity2[c].project_city;
    	 	   		 	            	        total2=String(itemsCity1[c].city);
    	 	                    		 			if(city==city3){
    	 	                    		 				//map.entities.remove(LA3);
    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity2.png'};
    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	 	                    		 				add2(city3,pushpin3,LA3);
    	 	                    		 				addmouse_out(pushpin3);
    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    	 	       		 	                  	        map.entities.push(pushpin3);
    		 	                    		 			
    		 	                    		 		}else{
    		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	 	                    		 				add2(city3,pushpin3,LA3);
    	 	                    		 				addmouse_out(pushpin3);
    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    	 	       		 	                  	        map.entities.push(pushpin3);
    		 	                    		 		}
    	 	                    		 		}	
    	                 		 		}
    	                 		 	//州
    	                 		 		else if(lastZoomLevel>4){
    	                 		 			map.entities.clear();
    	                 		 			for(var z=0;z<lenZhou;z++){
    		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
    		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
    		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
    		   		 	            	            total2=String(itemsZhou1[z].zhou);
    		                    		 			if(zhou==zhou3){
    		                    		 				//map.entities.remove(LA3);
    		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou2.png'};
    		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    		                    		 				add2(zhou3,pushpin3,LA3);
    		                    		 				addmouse_out(pushpin3);
    		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    		       		 	                  	        map.entities.push(pushpin3);
    	 	                    		 			
    	 	                    		 		}else{
    	 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);
    	 	                    		 		}
    		                    		 		}
    	                 		 		}
    	                 		 	 // 国家
    	                 		 		else{
    	                 		 			map.entities.clear();
    	                 		 			for(var n=0;n<lenNation;n++){
    	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
    	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
    	 	   		 	            	        var pronum=itemsNation2[n].project_num;
    	 	   		 	            	        total2=String(itemsNation1[n].nation);
    	 	                    		 			if(nation==nation3){
    	 	                    		 				//map.entities.remove(LA3);
    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	 	                    		 				add2(nation3,pushpin3,LA3);
    	 	                    		 				addmouse_out(pushpin3);
    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    	 	       		 	                  	        map.entities.push(pushpin3);
    		 	                    		 			
    		 	                    		 		}else{
    		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	 	                    		 				add2(nation3,pushpin3,LA3);
    	 	                    		 				addmouse_out(pushpin3);
    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    	 	       		 	                  	        map.entities.push(pushpin3);
    		 	                    		 		}
    	 	                    		 		}
    	                 		 		}
    		 	             		})
    		 	             		 //注册鼠标离开事件
    		 	             		$(document).on("mouseleave","#left >.div_node",function(){
    		 	             			$(this).css("background-color","white");
    		 	             			var arr3=new Array();
    	                 		 		var LA3;
    	                 		 		var total2;
    	                 		 		var pushpinOptions3;
    	                 		 		var pushpin3;
    	                 		 		//项目名
    	                 		 		if(lastZoomLevel>10){
    	                 		 		map.entities.clear();
    	                 		 		for(var p=0;p<lenItems;p++){
    	                 		 	        arr3=items[p].gps.split(",");
    	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
    	                 		 	        var num=items[p].project_num;
      			 	 	 		            var name=items[p].project_name;
      			 	 	 		            var image=items[p].project_img;
      			 	 	 		            var img=imgdir+"/"+image;	 		        
      			 	 	 		            var price=items[p].project_min_price;
      			 	 	 		            var type=items[p].project_type;  	    			 	 	 
    	                 		 			pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
    	                 		 			pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	                 		 			add(name,type,img,price,num,pushpin3,LA3);
    	    		 	                  	map.entities.push(pushpin3);    	    			 	 	 		    
    	                 		 		}	
    	                 		 		}
    	                 		 	    //区域
    	                 		 		else if(lastZoomLevel>8){
    	                 		 		map.entities.clear();
    	                 		 		for(var a=0;a<lenArea;a++){
    			 	            	        arr3=itemsArea2[a].gps.split(",");
    			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
    			 	            	        var area3=itemsArea2[a].project_area;
    			 	            	        total2=String(itemsArea1[a].area);	
    	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	                 		 				add2(area3,pushpin3,LA3);
    	                 		 				addmouse_out(pushpin3);
    	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    	    		 	                  	        map.entities.push(pushpin3);	                    		 		
    	                 		 		}	 	                    		 		
    	                 		 		}
    	                 		 		//城市
    	                 		 		else if(lastZoomLevel>6){
    	                 		 			map.entities.clear();
    	                 		 			for(var c=0;c<lenCity;c++){
    	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
    	 	   		 	            	        var city3=itemsCity2[c].project_city;
    	 	   		 	            	        total2=String(itemsCity1[c].city);
    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	 	                    		 				add2(city3,pushpin3,LA3);
    	 	                    		 				addmouse_out(pushpin3);
    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    	 	       		 	                  	        map.entities.push(pushpin3);  		 	                    		 		
    	 	                    		 		}	
    	                 		 		}
    	                 		 	//州
    	                 		 		else if(lastZoomLevel>4){
    	                 		 			map.entities.clear();
    	                 		 			for(var z=0;z<lenZhou;z++){
    		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
    		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
    		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
    		   		 	            	            total2=String(itemsZhou1[z].zhou);
    		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
    		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    		                    		 				add2(zhou3,pushpin3,LA3);
    		                    		 				addmouse_out(pushpin3);
    		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    		       		 	                  	        map.entities.push(pushpin3);                   		 		
    		                    		 		}
    	                 		 		}
    	                 		 	 // 国家
    	                 		 		else{
    	                 		 			map.entities.clear();
    	                 		 			for(var n=0;n<lenNation;n++){
    	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
    	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
    	 	   		 	            	        var pronum=itemsNation2[n].project_num;
    	 	   		 	            	        total2=String(itemsNation1[n].nation);
    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
    	 	                    		 				add2(nation3,pushpin3,LA3);
    	 	                    		 				addmouse_out(pushpin3);
    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
    	 	       		 	                  	        map.entities.push(pushpin3);   		 	                    		 		
    	 	                    		 		}
    	                 		 		}
    		 	             		})
    		 	             		
    			 	               if(lastZoomLevel>10){
    			 	            	  map.entities.clear();
    			 	            	  for(var i=0;i<items.length;i++){
    			 	 	 		        var arr=new Array();
    			 	 	 		        arr=items[i].gps.split(",");
    			 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
    			 	 	 		        var num=items[i].project_num;
    			 	 	 		        var name=items[i].project_name;
    			 	 	 		        var image=items[i].project_img;
    			 	 	 		        var img=imgdir+"/"+image;	 		        
    			 	 	 		       /* var minprice=items[i].project_min_price;
    			 	 	 		        var maxprice=items[i].project_high_price;*/
    			 	 	 		        var city=items[i].project_city;
    			 	 	 		        //var price=items[i].project_price_int_qi;
    			 	 	 		        var price=items[i].project_min_price;
    			 	 	 		        var type=items[i].project_type;
    			 	 	 		        var pushpinOptions = {width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'}; 
    			 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
    			 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
    			 	 				    add(name,type,img,price,num,pushpin,LA);
    			 	 				    map.entities.push(pushpin);	
    			 	 	 		    }	 	            	   
    			 	               }else if(lastZoomLevel>8){		 	            	  
    			 	            	    map.entities.clear();
    			 	            	    var lenArea=itemsArea1.length;
    			 	            	    for(var j=0;j<lenArea;j++){
    			 	            	        var arr2=new Array();
    			 	            	        arr2=itemsArea2[j].gps.split(",");
    			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
    			 	            	        var area2=itemsArea2[j].project_area;
    			 	            	        var total=String(itemsArea1[j].area);
    			 	            	        //alert(typeof(total))
    			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
    			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
    			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
    			 	            	        add2(area2,pushpin2,LA2);
    			 	            	       addmouse_out(pushpin2);
    			 	            	        add3(lastZoomLevel,pushpin2,LA2);
    			 	                  	    map.entities.push(pushpin2);
    			 	            	    }
    			 	               }else if(lastZoomLevel>6){
    			 	            	    map.entities.clear();
    			 	            	    var lenCity=itemsCity1.length;
    			 	            	    for(var j=0;j<lenCity;j++){
    			 	            	        var arr2=new Array();
    			 	            	        arr2=itemsCity2[j].gps.split(",");
    			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
    			 	            	        var city2=itemsCity2[j].project_city;
    			 	            	        var total=String(itemsCity1[j].city);
    			 	            	        //alert(typeof(total))
    			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
    			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
    			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
    			 	            	        add2(city2,pushpin2,LA2);
    			 	            	       addmouse_out(pushpin2);
    			 	            	        add3(lastZoomLevel,pushpin2,LA2);
    			 	                  	    map.entities.push(pushpin2);
    			 	            	    }
    			 	               }else if(lastZoomLevel>4){
    			 	            	    map.entities.clear();
    			 	            	    var lenZhou=itemsZhou1.length;
    			 	            	    for(var j=0;j<lenZhou;j++){
    			 	            	        var arr2=new Array();
    			 	            	        arr2=itemsZhou2[j].gps.split(",");
    			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
    			 	            	        var zhou2=itemsZhou2[j].project_zhou;
    			 	            	        var total=String(itemsZhou1[j].zhou);
    			 	            	        //alert(typeof(total))
    			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
    			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
    			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
    			 	            	        add2(zhou2,pushpin2,LA2);
    			 	            	       addmouse_out(pushpin2);
    			 	            	        add3(lastZoomLevel,pushpin2,LA2);
    			 	                  	    map.entities.push(pushpin2);
    			 	            	    }
    			 	               }else{
    			 	            	    map.entities.clear();
    			 	            	    var lenNation=itemsNation1.length;
    			 	            	    for(var j=0;j<lenNation;j++){
    			 	            	        var arr2=new Array();
    			 	            	        arr2=itemsNation2[j].gps.split(",");
    			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
    			 	            	        var nation2=itemsNation2[j].project_nation;
    			 	            	        var total=String(itemsNation1[j].nation);
    			 	            	        //var shownation=nation2+'\r\n'+total;
    			 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin2.png' style='width:100px;'/></div>"}; */
    			 	            	        var pushpinOptions2={text:total,width: 42, height: 42,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
    			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
    			 	            	        add2(nation2,pushpin2,LA2);
    			 	            	       addmouse_out(pushpin2);
    			 	            	        add3(lastZoomLevel,pushpin2,LA2);
    			 	                  	    map.entities.push(pushpin2);
    			 	            	    }
    			 	               }
    			 	        	}
    		 	        });
    		 		   
    		 		   
    		 		},
    		 		error:function(){
    		 			//alert("addDefaultPushpin error")
    		 		}
    	        });	
    		  
    	  }
      }

      //生成地图消息框
      function add(name,type,img,price,num,pushpin,LA){
    	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(-15,20)}; 
		        var num1=num;
		        var img1=img;
		        var price1=price;
		        var type1=type;
		        var name1=name;
		        if(defaultInfobox){
		        	defaultInfobox.setOptions({ visible: false });
		        }
			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
			    map.entities.push(defaultInfobox); 
			    /*defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:240px;"><a href="/Index?proNum='+num1+'" target="blank"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">起价：$'+price1+'</b><a href="/Index?proNum='+num1+'" target="blank" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">类型：'+type1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:210px;cursor:default;"></div>');*/ 
			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:320px;"><a href="/Index?proNum='+num1+'" target="blank"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><a href="/Index?proNum='+num1+'" target="blank" style="position:absolute;left:125px;top:25px;font-size:13px;font-family:Microsoft YaHei;width: 198px;overflow: hidden;display: block;height: 18px;" title="'+name1+'">项目名：'+name1+'</a><b id="infoboxTitle" style="position:absolute; top:45px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">起价：$'+price1+'</b><b id="infoboxDescription" style="position:absolute; top:65px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">类型：'+type1+'</b><img src="images/close1.gif" onclick="display()" style="position:absolute;left:290px;cursor:default;"></div>');
		    });
      }
      function add2(name,pushpin,LA){
    	  Microsoft.Maps.Events.addHandler(pushpin, 'mouseover', function(){
		        var infoboxOptions = {description:name,width :150, height :50,showPointer:false,offset:new Microsoft.Maps.Point(0,15)}; 
		        if(defaultInfobox){
		        	defaultInfobox.setOptions({ visible: false });
		        }
			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
			    map.entities.push(defaultInfobox); 
		    });
      }
      function addmouse_out(pushpin){
    	  Microsoft.Maps.Events.addHandler(pushpin, 'mouseout', function(){
		        if(defaultInfobox){
		        	defaultInfobox.setOptions({ visible: false });
		        }
		    });
      }
      function add3(zoomLevel,pushpin,LA){
    	 Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
    		 map.entities.clear();
    		 map.setView({ zoom: zoomLevel+2, center:LA});
    	 });
      }
      //隐藏地图消息框
      function display(){
    	  defaultInfobox.setOptions({ visible: false });
      }
      //添加房屋类型pushpin   
      function addPushpin()
      {
		//alert("ffff")
		 $.ajax({
		 	    type: "GET",
		 		dateType: "json",
		 		url: "/BingMap/FileterType2?house_type=0",		
		 		success:function(data){
		       
		 		data=$.parseJSON(data);
		 		
		 		
		 		 var html = getHtml1(data.List);
		 		 
		 		 $("#left").html(html);  
		 		  
		 	    },
		 
		 		error:function(){
		 			//alert("addDefaultPushpin error")
		 		}
	        });		 
      }
      
      
   
      
      
      
      
	   /* 增加公寓pushpin*/
	   function addPushpin1()
      {
		   var gongyu = 0;
		 //alert("gongyu")
		 map.entities.clear(); 
		 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
		 $.ajax({
		 	    type: "GET",
		 		dateType: "json",
		 		url: "/BingMap/FileterType2?house_type=1",		
		 		success:function(data){
		        //alert(data)
		 		data=$.parseJSON(data);
		 		
		 		 var html = getHtml1(data.List);
		 		 //alert(html)
		 		 $("#left").html(html);  
		 		    var items=data.List;
		 		    var itemsNation1=data.ListNation1;
		 		    var itemsNation2=data.ListNation2;
		 		    var itemsZhou1=data.ListZhou1;
		 		    var itemsZhou2=data.ListZhou2;
		 		  
		 		    var itemsCity1=data.ListCity1;
		 		    var itemsCity2=data.ListCity2;
		 		    var itemsArea1=data.ListArea1;
		 		    var itemsArea2=data.ListArea2;
		 		    var lenItems=items.length;
		 		    var a=new Array();
		 		    var Zoom;
		 		    if(lenItems!=0){
		 		    	a=items[0].gps.split(",");
		 		    	Zoom=4;	 		    	
		 		    }
		 		    else{
		 		    	a[0]="-25.585241";
			 		    a[1]="134.504120";
			 		    Zoom=5;
		 		    } 
		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
		 		    map.setView({ zoom: Zoom, center: Center });
		 		    lastZoomLevel = map.getZoom();
		 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
		 	        	//联动
		 	        	 var bounds=map.getBounds();
		            	 var zuoshang=bounds.getNorthwest();
		                 var youxia=bounds.getSoutheast();
		                 var zs1=zuoshang.latitude;
		                 var zs2=zuoshang.longitude;
		                 var yx1=youxia.latitude;
	                     var yx2=youxia.longitude;
	                     gongyu++;
	                     if(gongyu!=1){
	                    	 $.ajax({
	 		     		 	    type: "POST",
	 		     		 		dateType: "json",
	 		     		 		url: "/BingMap1/filterByGPS1",	
	 		     		 		data:{gpsLeftX:zs1,gpsLeftY:zs2,gpsRightX:yx1,gpsRightY:yx2},
	 		     		 		success:function(data){
	 		     		       
	 		     		 		data=$.parseJSON(data);
	 		     		 		
	 		     		 		
	 		     		 		 var html = getHtml1(data.List);
	 		     		 		 
	 		     		 		 $("#left").html(html);  
	 		     		 		  
	 		     		 	    },
	 		     		 
	 		     		 		error:function(){
	 		     		 			//alert("addDefaultPushpin error")
	 		     		 		}
	 		     	        });
	                     }
		                 
		 	        	if(lastZoomLevel != map.getZoom()){
		 	               lastZoomLevel = map.getZoom();
		 	            //注册鼠标上移事件
			 	              $(document).on("mouseenter","#left >.div_node",function(){
		 	             			$(this).css("background-color","rgb(223,223,223)");
		 	             			var nation=$(this).children().first().text();
		 	             			var zhou=$(this).children().first().next().text();
		 	             			var city=$(this).children().first().next().next().text();
		 	             			var area=$(this).children().first().next().next().next().text();
		 	             			var href=$(this).children().first().next().next().next().next().next().attr("href");
		 	             			var arr=new Array();
		 	             			arr = href.split("=");
		 	             			var proNum=arr[1];
		 	             			//alert(proNum);
		 	             			var arr3=new Array();
	                 		 		var LA3;
	                 		 		var total2;
	                 		 		var pushpinOptions3;
	                 		 		var pushpin3;
	                 		 		//项目名
	                 		 		if(lastZoomLevel>10){
	                 		 		map.entities.clear();
	                 		 		for(var p=0;p<lenItems;p++){
	                 		 	        arr3=items[p].gps.split(",");
	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
	                 		 	        var num=items[p].project_num;
			 	 	 		            var name=items[p].project_name;
			 	 	 		            var image=items[p].project_img;
			 	 	 		            var img=imgdir+"/"+image;	 		        
			 	 	 		            var price=items[p].project_min_price;
			 	 	 		            var type=items[p].project_type;
	    			 	 	 		    if(proNum==num){
	    			 	 	 		    	//map.entities.remove(LA3);
	                 		 				pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin3.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	    map.entities.push(pushpin3);
	    			 	 	 		    }else{
	    			 	 	 		    	pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	    			 	 	 		    	pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	    map.entities.push(pushpin3);
	    			 	 	 		    }
	                 		 		}	
	                 		 		}
	                 		 	    //区域
	                 		 		else if(lastZoomLevel>8){
	                 		 		map.entities.clear();
	                 		 		for(var a=0;a<lenArea;a++){
			 	            	        arr3=itemsArea2[a].gps.split(",");
			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
			 	            	        var area3=itemsArea2[a].project_area;
			 	            	        total2=String(itemsArea1[a].area);
	                 		 			if(area==area3){
	                 		 				//map.entities.remove(LA3);
	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea2.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add2(area3,pushpin3,LA3);
	                 		 				addmouse_out(pushpin3);
	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    		 	                  	        map.entities.push(pushpin3);
		                    		 		}else{
		                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add2(area3,pushpin3,LA3);
 	                 		 				addmouse_out(pushpin3);
 	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	    		 	                  	        map.entities.push(pushpin3);
		                    		 		}
	                 		 		}	 	                    		 		
	                 		 		}
	                 		 		//城市
	                 		 		else if(lastZoomLevel>6){
	                 		 			map.entities.clear();
	                 		 			for(var c=0;c<lenCity;c++){
	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var city3=itemsCity2[c].project_city;
	 	   		 	            	        total2=String(itemsCity1[c].city);
	 	                    		 			if(city==city3){
	 	                    		 				//map.entities.remove(LA3);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 			
		 	                    		 		}else{
		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 		}
	 	                    		 		}	
	                 		 		}
	                 		 	//州
	                 		 		else if(lastZoomLevel>4){
	                 		 			map.entities.clear();
	                 		 			for(var z=0;z<lenZhou;z++){
		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
		   		 	            	            total2=String(itemsZhou1[z].zhou);
		                    		 			if(zhou==zhou3){
		                    		 				//map.entities.remove(LA3);
		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou2.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);
	 	                    		 			
	 	                    		 		}else{
	 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                    		 				add2(zhou3,pushpin3,LA3);
	                    		 				addmouse_out(pushpin3);
	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	       		 	                  	        map.entities.push(pushpin3);
	 	                    		 		}
		                    		 		}
	                 		 		}
	                 		 	 // 国家
	                 		 		else{
	                 		 			map.entities.clear();
	                 		 			for(var n=0;n<lenNation;n++){
	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
	 	   		 	            	        var pronum=itemsNation2[n].project_num;
	 	   		 	            	        total2=String(itemsNation1[n].nation);
	 	                    		 			if(nation==nation3){
	 	                    		 				//map.entities.remove(LA3);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 			
		 	                    		 		}else{
		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 		}
	 	                    		 		}
	                 		 		}
		 	             		})
		 	             		 //注册鼠标离开事件
		 	             		$(document).on("mouseleave","#left >.div_node",function(){
		 	             			$(this).css("background-color","white");
		 	             			var arr3=new Array();
	                 		 		var LA3;
	                 		 		var total2;
	                 		 		var pushpinOptions3;
	                 		 		var pushpin3;
	                 		 		//项目名
	                 		 		if(lastZoomLevel>10){
	                 		 		map.entities.clear();
	                 		 		for(var p=0;p<lenItems;p++){
	                 		 	        arr3=items[p].gps.split(",");
	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
	                 		 	        var num=items[p].project_num;
			 	 	 		            var name=items[p].project_name;
			 	 	 		            var image=items[p].project_img;
			 	 	 		            var img=imgdir+"/"+image;	 		        
			 	 	 		            var price=items[p].project_min_price;
			 	 	 		            var type=items[p].project_type;  	    			 	 	 
	                 		 			pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	                 		 			pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 			add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	map.entities.push(pushpin3);    	    			 	 	 		    
	                 		 		}	
	                 		 		}
	                 		 	    //区域
	                 		 		else if(lastZoomLevel>8){
	                 		 		map.entities.clear();
	                 		 		for(var a=0;a<lenArea;a++){
			 	            	        arr3=itemsArea2[a].gps.split(",");
			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
			 	            	        var area3=itemsArea2[a].project_area;
			 	            	        total2=String(itemsArea1[a].area);	
	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add2(area3,pushpin3,LA3);
	                 		 				addmouse_out(pushpin3);
	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    		 	                  	        map.entities.push(pushpin3);	                    		 		
	                 		 		}	 	                    		 		
	                 		 		}
	                 		 		//城市
	                 		 		else if(lastZoomLevel>6){
	                 		 			map.entities.clear();
	                 		 			for(var c=0;c<lenCity;c++){
	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var city3=itemsCity2[c].project_city;
	 	   		 	            	        total2=String(itemsCity1[c].city);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);  		 	                    		 		
	 	                    		 		}	
	                 		 		}
	                 		 	//州
	                 		 		else if(lastZoomLevel>4){
	                 		 			map.entities.clear();
	                 		 			for(var z=0;z<lenZhou;z++){
		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
		   		 	            	            total2=String(itemsZhou1[z].zhou);
		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);                   		 		
		                    		 		}
	                 		 		}
	                 		 	 // 国家
	                 		 		else{
	                 		 			map.entities.clear();
	                 		 			for(var n=0;n<lenNation;n++){
	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
	 	   		 	            	        var pronum=itemsNation2[n].project_num;
	 	   		 	            	        total2=String(itemsNation1[n].nation);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);   		 	                    		 		
	 	                    		 		}
	                 		 		}
		 	             		})
		 	               if(lastZoomLevel>10){
		 	            	  map.entities.clear();
		 	            	  for(var i=0;i<items.length;i++){
		 	 	 		        var arr=new Array();
		 	 	 		        arr=items[i].gps.split(",");
		 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
		 	 	 		        var num=items[i].project_num;
		 	 	 		        var name=items[i].project_name;
		 	 	 		        var image=items[i].project_img;
		 	 	 		        var img=imgdir+"/"+image;	 		        
		 	 	 		       /* var minprice=items[i].project_min_price;
		 	 	 		        var maxprice=items[i].project_high_price;*/
		 	 	 		        var city=items[i].project_city;
		 	 	 		        //var price=items[i].project_price_int_qi;
		 	 	 		        var price=items[i].project_min_price;
		 	 	 		        var type=items[i].project_type;
		 	 	 		        var pushpinOptions = {width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'}; 
		 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
		 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
		 	 				    add(name,type,img,price,num,pushpin,LA);
		 	 				    map.entities.push(pushpin);	
		 	 	 		    }	 	            	   
		 	               }else if(lastZoomLevel>8){		 	            	  
		 	            	    map.entities.clear();
		 	            	    var lenArea=itemsArea1.length;
		 	            	    for(var j=0;j<lenArea;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsArea2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var area2=itemsArea2[j].project_area;
		 	            	        var total=String(itemsArea1[j].area);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(area2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else if(lastZoomLevel>6){
		 	            	    map.entities.clear();
		 	            	    var lenCity=itemsCity1.length;
		 	            	    for(var j=0;j<lenCity;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsCity2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var city2=itemsCity2[j].project_city;
		 	            	        var total=String(itemsCity1[j].city);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(city2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else if(lastZoomLevel>4){
		 	            	    map.entities.clear();
		 	            	    var lenZhou=itemsZhou1.length;
		 	            	    for(var j=0;j<lenZhou;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsZhou2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var zhou2=itemsZhou2[j].project_zhou;
		 	            	        var total=String(itemsZhou1[j].zhou);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(zhou2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else{
		 	            	    map.entities.clear();
		 	            	    var lenNation=itemsNation1.length;
		 	            	    for(var j=0;j<lenNation;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsNation2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var nation2=itemsNation2[j].project_nation;
		 	            	        var total=String(itemsNation1[j].nation);
		 	            	        //var shownation=nation2+'\r\n'+total;
		 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin2.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 42, height: 42,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(nation2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);		 	                  	 
		 	            	    }
		 	               }
		 	        	}
		 	        });
		 		   
		 		   
		 		},
		 		error:function(){
		 			//alert("addDefaultPushpin error")
		 		}
	        });		 
      }
	   
	   
	   /* 增加搜索pushpin*/
	   function addPushpinNation(nation, city, area,item)
      {
		 //alert(nation+city+area)
		 map.entities.clear(); 
		 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
		 var xuanze = 0;
		 $.ajax({
		 	    type: "POST",
		 		dateType: "json",
		 		url: "/BingMap/Liandong",	
		 		data:{nation:nation, city:city, area:area},
		 		success:function(data){
		        //alert(data)
		 		data=$.parseJSON(data);
		 		//alert(data.List+"返回数据")
		 		var cityArray=data.cityArray;
		 		var areaArray=data.areaArray;
		 		if(item == 1){
		 			$('#city').empty();
		        	   $('#city').append($('<option></option>').val("0").text("城市"));
		        	   for(var i=0; i<cityArray.length; i++)  
		        	   {  
		        		/*    jQuery("#city").append("<option value='"+cityArray[i].cityname+"'>"+cityArray[i].cityname+"</option>");  */
		        		   $('#city').append($('<option></option>').val(cityArray[i].city).text(cityArray[i].city));
		        	   } 
		 		}
		 		else if(item == 2){
		 			$('#area').empty();
		        	   $('#area').append($('<option></option>').val("0").text("区域"));
		        	   for(var i=0; i<areaArray.length; i++)  
		        	   {  
		        		/*    jQuery("#city").append("<option value='"+cityArray[i].cityname+"'>"+cityArray[i].cityname+"</option>");  */
		        		   $('#area').append($('<option></option>').val(areaArray[i].area).text(areaArray[i].area));
		        	   } 
		 		}
	        	   
	        	    
	        	   
		 		
		 		
		 		 var html = getHtml1(data.List);
		 		 //alert(html)
		 		 $("#left").html(html);  
		 		    var items=data.List;
		 		    var itemsNation1=data.ListNation1;
		 		    var itemsNation2=data.ListNation2;
		 		    var itemsZhou1=data.ListZhou1;
		 		    var itemsZhou2=data.ListZhou2;
		 		    var itemsCity1=data.ListCity1;
		 		    var itemsCity2=data.ListCity2;
		 		    var itemsArea1=data.ListArea1;
		 		    var itemsArea2=data.ListArea2;
		 		    var itemsCenternation=data.ListCenternation;
		 		    var itemsCentercity=data.ListCentercity;
		 		    var itemsCenterarea=data.ListCenterarea;
		 		    var lenItems=items.length;
		 		    var lenCenternation=itemsCenternation.length;
		 		    var lenCentercity=itemsCentercity.length;
		 		    var lenCenterarea=itemsCenterarea.length;
		 		    var a=new Array();
		 		    var Zoom;
		 		    //alert(nation)
		 		    //alert(city)
		 		    //alert(area)
		 		    if(lenItems!=0){
		 		    	if(area!=0){
		 		    		//alert("area")
	    		 		      Zoom=10;
	    		 		      if(lenCentercity!=0){
	    		 		    	 //alert("area1")
	    		 		    	 for(var k3=0;k3<lenCenterarea;k3++){
	  	   		 		    	   if(area==itemsCenterarea[k3].name){
	  	   		 		    		   a=itemsCenterarea[k3].gps.split(",");
	  	   		 		    		   break;
	  	   		 		    	   }
	  	   		 		          }
	    		 		      }    		 		     
	    		 		     if(a.length==0){
	    		 		    	//alert("area1")
		    		 		    	for(var k4=0;k4<lenItems;k4++){
		    		 		    	   if(area==items[k4].project_area){
		    		 		    		   a=items[k4].gps.split(",");
		    		 		    		  break;
		    		 		    	   }
		    		 		    	 
		    		 		          }
		    		 		       }
	    		 		    }
		 		    	else if(city!=0){
		 		    		   //alert("ctiy")
		 		    		   Zoom=8;
		 		    		   if(lenCentercity!=0){
		 		    		   //alert("ctiy1")
	    		 		       for(var k1=0;k1<lenCentercity;k1++){
	    		 		    	   if(city==itemsCentercity[k1].name){
	    		 		    		   a=itemsCentercity[k1].gps.split(",");
	    		 		    		   break;
	    		 		    	   }
	    		 		         }
	    		 		       }
	    		 		       if(a.length==0){
	    		 		    	  //alert("ctiy2")
	  	    		 		    	for(var k2=0;k2<lenItems;k2++){
	 	    		 		    	   if(city==items[k2].project_city){
	 	    		 		    		   a=items[k2].gps.split(",");
	 	    		 		    		   break;
	 	    		 		    	   }
	 	    		 		    	  
	 	    		 		          }
	  	    		 		       }
	    		 		    }
		 		    	else if(nation!=0){
		 		    		   //alert("nation")
		 		    		   Zoom=4;
		 		    		   if(lenCenternation!=0){
		 		    			   //alert("nation1")
		    		 		       for(var n1=0;n1<lenCenternation;n1++){
		    		 		    	   if(nation==itemsCenternation[n1].name){
		    		 		    		   a=itemsCenternation[n1].gps.split(",");
		    		 		    		   break;
		    		 		    	   }
		    		 		       } 
		 		    		   }	    		 		       
	    		 		       if(a.length==0){
	    		 		    	    //alert("nation2")
	  	    		 		    	for(var n2=0;n2<lenItems;n2++){
	 	    		 		    	   if(nation==items[n2].project_nation){
	 	    		 		    		   a=items[n2].gps.split(",");
	 	    		 		    		   break;
	 	    		 		    	   }	 	    		 		    	  
	 	    		 		          }
	  	    		 		       }
	    		 		    }
		 		    	
		 		    }		 		
		 		    else{
		 		    	a[0]="-25.585241";
			 		    a[1]="134.504120";
			 		    Zoom=5;
		 		    } 
		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
		 		    map.setView({ zoom: Zoom, center: Center });
		 		    lastZoomLevel = map.getZoom();
		 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
		 	        	//联动
		 	        	 var bounds=map.getBounds();
		            	 var zuoshang=bounds.getNorthwest();
		                 var youxia=bounds.getSoutheast();
		                 var zs1=zuoshang.latitude;
		                 var zs2=zuoshang.longitude;
		                 var yx1=youxia.latitude;
	                     var yx2=youxia.longitude;
	                     xuanze++;
	                     alert(xuanze+"ffffff")
	                     if(xuanze!=1){
	                    	 $.ajax({
	 		     		 	    type: "POST",
	 		     		 		dateType: "json",
	 		     		 		url: "/BingMap1/filterByGPS1",	
	 		     		 		data:{gpsLeftX:zs1,gpsLeftY:zs2,gpsRightX:yx1,gpsRightY:yx2},
	 		     		 		success:function(data){
	 		     		       
	 		     		 		data=$.parseJSON(data);
	 		     		 		
	 		     		 		
	 		     		 		 var html = getHtml1(data.List);
	 		     		 		 
	 		     		 		 $("#left").html(html);  
	 		     		 		  
	 		     		 	    },
	 		     		 
	 		     		 		error:function(){
	 		     		 			//alert("addDefaultPushpin error")
	 		     		 		}
	 		     	        });
	                     }
	                		 
		                 
		                 if(lastZoomLevel != map.getZoom()){
			 	               lastZoomLevel = map.getZoom();
			 	            //注册鼠标上移事件
 			 	              $(document).on("mouseenter","#left >.div_node",function(){
 		 	             			$(this).css("background-color","rgb(223,223,223)");
 		 	             			var nation=$(this).children().first().text();
 		 	             			var zhou=$(this).children().first().next().text();
 		 	             			var city=$(this).children().first().next().next().text();
 		 	             			var area=$(this).children().first().next().next().next().text();
 		 	             			var href=$(this).children().first().next().next().next().next().next().attr("href");
 		 	             			var arr=new Array();
 		 	             			arr = href.split("=");
 		 	             			var proNum=arr[1];
 		 	             			//alert(proNum);
 		 	             			var arr3=new Array();
 	                 		 		var LA3;
 	                 		 		var total2;
 	                 		 		var pushpinOptions3;
 	                 		 		var pushpin3;
 	                 		 		//项目名
 	                 		 		if(lastZoomLevel>10){
 	                 		 		map.entities.clear();
 	                 		 		for(var p=0;p<lenItems;p++){
 	                 		 	        arr3=items[p].gps.split(",");
 	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
 	                 		 	        var num=items[p].project_num;
   			 	 	 		            var name=items[p].project_name;
   			 	 	 		            var image=items[p].project_img;
   			 	 	 		            var img=imgdir+"/"+image;	 		        
   			 	 	 		            var price=items[p].project_min_price;
   			 	 	 		            var type=items[p].project_type;
 	    			 	 	 		    if(proNum==num){
 	    			 	 	 		    	//map.entities.remove(LA3);
 	                 		 				pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin3.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add(name,type,img,price,num,pushpin3,LA3);
 	    		 	                  	    map.entities.push(pushpin3);
 	    			 	 	 		    }else{
 	    			 	 	 		    	pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
 	    			 	 	 		    	pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add(name,type,img,price,num,pushpin3,LA3);
 	    		 	                  	    map.entities.push(pushpin3);
 	    			 	 	 		    }
 	                 		 		}	
 	                 		 		}
 	                 		 	    //区域
 	                 		 		else if(lastZoomLevel>8){
 	                 		 		map.entities.clear();
 	                 		 		for(var a=0;a<lenArea;a++){
 			 	            	        arr3=itemsArea2[a].gps.split(",");
 			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 			 	            	        var area3=itemsArea2[a].project_area;
 			 	            	        total2=String(itemsArea1[a].area);
 	                 		 			if(area==area3){
 	                 		 				//map.entities.remove(LA3);
 	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea2.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add2(area3,pushpin3,LA3);
 	                 		 				addmouse_out(pushpin3);
 	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	    		 	                  	        map.entities.push(pushpin3);
 		                    		 		}else{
 		                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
     	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
     	                 		 				add2(area3,pushpin3,LA3);
     	                 		 				addmouse_out(pushpin3);
     	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
     	    		 	                  	        map.entities.push(pushpin3);
 		                    		 		}
 	                 		 		}	 	                    		 		
 	                 		 		}
 	                 		 		//城市
 	                 		 		else if(lastZoomLevel>6){
 	                 		 			map.entities.clear();
 	                 		 			for(var c=0;c<lenCity;c++){
 	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
 	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 	 	   		 	            	        var city3=itemsCity2[c].project_city;
 	 	   		 	            	        total2=String(itemsCity1[c].city);
 	 	                    		 			if(city==city3){
 	 	                    		 				//map.entities.remove(LA3);
 	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity2.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(city3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);
 		 	                    		 			
 		 	                    		 		}else{
 		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(city3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);
 		 	                    		 		}
 	 	                    		 		}	
 	                 		 		}
 	                 		 	//州
 	                 		 		else if(lastZoomLevel>4){
 	                 		 			map.entities.clear();
 	                 		 			for(var z=0;z<lenZhou;z++){
 		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
 		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
 		   		 	            	            total2=String(itemsZhou1[z].zhou);
 		                    		 			if(zhou==zhou3){
 		                    		 				//map.entities.remove(LA3);
 		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou2.png'};
 		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 		                    		 				add2(zhou3,pushpin3,LA3);
 		                    		 				addmouse_out(pushpin3);
 		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 		       		 	                  	        map.entities.push(pushpin3);
 	 	                    		 			
 	 	                    		 		}else{
 	 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);
 	 	                    		 		}
 		                    		 		}
 	                 		 		}
 	                 		 	 // 国家
 	                 		 		else{
 	                 		 			map.entities.clear();
 	                 		 			for(var n=0;n<lenNation;n++){
 	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
 	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
 	 	   		 	            	        var pronum=itemsNation2[n].project_num;
 	 	   		 	            	        total2=String(itemsNation1[n].nation);
 	 	                    		 			if(nation==nation3){
 	 	                    		 				//map.entities.remove(LA3);
 	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(nation3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);
 		 	                    		 			
 		 	                    		 		}else{
 		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(nation3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);
 		 	                    		 		}
 	 	                    		 		}
 	                 		 		}
 		 	             		})
 		 	             		 //注册鼠标离开事件
 		 	             		$(document).on("mouseleave","#left >.div_node",function(){
 		 	             			$(this).css("background-color","white");
 		 	             			var arr3=new Array();
 	                 		 		var LA3;
 	                 		 		var total2;
 	                 		 		var pushpinOptions3;
 	                 		 		var pushpin3;
 	                 		 		//项目名
 	                 		 		if(lastZoomLevel>10){
 	                 		 		map.entities.clear();
 	                 		 		for(var p=0;p<lenItems;p++){
 	                 		 	        arr3=items[p].gps.split(",");
 	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
 	                 		 	        var num=items[p].project_num;
   			 	 	 		            var name=items[p].project_name;
   			 	 	 		            var image=items[p].project_img;
   			 	 	 		            var img=imgdir+"/"+image;	 		        
   			 	 	 		            var price=items[p].project_min_price;
   			 	 	 		            var type=items[p].project_type;  	    			 	 	 
 	                 		 			pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
 	                 		 			pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 			add(name,type,img,price,num,pushpin3,LA3);
 	    		 	                  	map.entities.push(pushpin3);    	    			 	 	 		    
 	                 		 		}	
 	                 		 		}
 	                 		 	    //区域
 	                 		 		else if(lastZoomLevel>8){
 	                 		 		map.entities.clear();
 	                 		 		for(var a=0;a<lenArea;a++){
 			 	            	        arr3=itemsArea2[a].gps.split(",");
 			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 			 	            	        var area3=itemsArea2[a].project_area;
 			 	            	        total2=String(itemsArea1[a].area);	
 	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add2(area3,pushpin3,LA3);
 	                 		 				addmouse_out(pushpin3);
 	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	    		 	                  	        map.entities.push(pushpin3);	                    		 		
 	                 		 		}	 	                    		 		
 	                 		 		}
 	                 		 		//城市
 	                 		 		else if(lastZoomLevel>6){
 	                 		 			map.entities.clear();
 	                 		 			for(var c=0;c<lenCity;c++){
 	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
 	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 	 	   		 	            	        var city3=itemsCity2[c].project_city;
 	 	   		 	            	        total2=String(itemsCity1[c].city);
 	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(city3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);  		 	                    		 		
 	 	                    		 		}	
 	                 		 		}
 	                 		 	//州
 	                 		 		else if(lastZoomLevel>4){
 	                 		 			map.entities.clear();
 	                 		 			for(var z=0;z<lenZhou;z++){
 		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
 		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
 		   		 	            	            total2=String(itemsZhou1[z].zhou);
 		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
 		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 		                    		 				add2(zhou3,pushpin3,LA3);
 		                    		 				addmouse_out(pushpin3);
 		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 		       		 	                  	        map.entities.push(pushpin3);                   		 		
 		                    		 		}
 	                 		 		}
 	                 		 	 // 国家
 	                 		 		else{
 	                 		 			map.entities.clear();
 	                 		 			for(var n=0;n<lenNation;n++){
 	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
 	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
 	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
 	 	   		 	            	        var pronum=itemsNation2[n].project_num;
 	 	   		 	            	        total2=String(itemsNation1[n].nation);
 	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
 	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	 	                    		 				add2(nation3,pushpin3,LA3);
 	 	                    		 				addmouse_out(pushpin3);
 	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	 	       		 	                  	        map.entities.push(pushpin3);   		 	                    		 		
 	 	                    		 		}
 	                 		 		}
 		 	             		})
			 	               if(lastZoomLevel>10){
			 	            	  map.entities.clear();
			 	            	  for(var i=0;i<items.length;i++){
			 	 	 		        var arr=new Array();
			 	 	 		        arr=items[i].gps.split(",");
			 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
			 	 	 		        var num=items[i].project_num;
			 	 	 		        var name=items[i].project_name;
			 	 	 		        var image=items[i].project_img;
			 	 	 		        var img=imgdir+"/"+image;	 		        
			 	 	 		       /* var minprice=items[i].project_min_price;
			 	 	 		        var maxprice=items[i].project_high_price;*/
			 	 	 		        var city=items[i].project_city;
			 	 	 		        //var price=items[i].project_price_int_qi;
			 	 	 		        var price=items[i].project_min_price;
			 	 	 		        var type=items[i].project_type;
			 	 	 		        var pushpinOptions = {width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'}; 
			 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
			 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
			 	 				    add(name,type,img,price,num,pushpin,LA);
			 	 				    map.entities.push(pushpin);	
			 	 	 		    }	 	            	   
			 	               }else if(lastZoomLevel>8){		 	            	  
			 	            	    map.entities.clear();
			 	            	    var lenArea=itemsArea1.length;
			 	            	    for(var j=0;j<lenArea;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=itemsArea2[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var area2=itemsArea2[j].project_area;
			 	            	        var total=String(itemsArea1[j].area);
			 	            	        //alert(typeof(total))
			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
			 	            	        add2(area2,pushpin2,LA2);
			 	            	       addmouse_out(pushpin2);
			 	            	        add3(lastZoomLevel,pushpin2,LA2);
			 	                  	    map.entities.push(pushpin2);
			 	            	    }
			 	               }else if(lastZoomLevel>6){
			 	            	    map.entities.clear();
			 	            	    var lenCity=itemsCity1.length;
			 	            	    for(var j=0;j<lenCity;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=itemsCity2[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var city2=itemsCity2[j].project_city;
			 	            	        var total=String(itemsCity1[j].city);
			 	            	        //alert(typeof(total))
			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
			 	            	        add2(city2,pushpin2,LA2);
			 	            	       addmouse_out(pushpin2);
			 	            	        add3(lastZoomLevel,pushpin2,LA2);
			 	                  	    map.entities.push(pushpin2);
			 	            	    }
			 	               }else if(lastZoomLevel>4){
			 	            	    map.entities.clear();
			 	            	    var lenZhou=itemsZhou1.length;
			 	            	    for(var j=0;j<lenZhou;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=itemsZhou2[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var zhou2=itemsZhou2[j].project_zhou;
			 	            	        var total=String(itemsZhou1[j].zhou);
			 	            	        //alert(typeof(total))
			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
			 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
			 	            	        add2(zhou2,pushpin2,LA2);
			 	            	       addmouse_out(pushpin2);
			 	            	        add3(lastZoomLevel,pushpin2,LA2);
			 	                  	    map.entities.push(pushpin2);
			 	            	    }
			 	               }else{
			 	            	    map.entities.clear();
			 	            	    var lenNation=itemsNation1.length;
			 	            	    for(var j=0;j<lenNation;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=itemsNation2[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var nation2=itemsNation2[j].project_nation;
			 	            	        var total=String(itemsNation1[j].nation);
			 	            	        //var shownation=nation2+'\r\n'+total;
			 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin2.png' style='width:100px;'/></div>"}; */
			 	            	        var pushpinOptions2={text:total,width: 42, height: 42,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
			 	            	        add2(nation2,pushpin2,LA2);
			 	            	       addmouse_out(pushpin2);
			 	            	        add3(lastZoomLevel,pushpin2,LA2);
			 	                  	    map.entities.push(pushpin2);
			 	            	    }
			 	               }
			 	        	}
		 	        });
		 		   
		 		   
		 		},
		 		error:function(){
		 			//alert("addDefaultPushpin error")
		 		}
	        });		 
      }
	   
	   
	   
       /* 增加别墅pushpin*/
	   function addPushpin2()
      {
		    var bieshu = 0;
	    //alert("bieshu")
		map.entities.clear(); 
	    map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
	    $.ajax({
	 	    type: "GET",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=2",		
	 		success:function(data){
	        //alert(data)
	 		data=$.parseJSON(data);
	 		 var html = getHtml1(data.List);
	 		 $("#left").html(html); 
	 		    var items=data.List;
	 		    var itemsNation1=data.ListNation1;
	 		    var itemsNation2=data.ListNation2;
	 		    var itemsZhou1=data.ListZhou1;
	 		    var itemsZhou2=data.ListZhou2;
	 		    var itemsCity1=data.ListCity1;
	 		    var itemsCity2=data.ListCity2;
	 		    var itemsArea1=data.ListArea1;
	 		    var itemsArea2=data.ListArea2;
	 		    var lenItems=items.length;
	 		    var a=new Array();
	 		    var Zoom;
	 		    if(lenItems!=0){
	 		    	a=items[0].gps.split(",");
	 		    	Zoom=4;	 		    	
	 		    }
	 		    else{
	 		    	a[0]="-25.585241";
		 		    a[1]="134.504120";
		 		    Zoom=5;
	 		    } 
	 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
	 		    map.setView({ zoom: Zoom, center: Center });
	 		    lastZoomLevel = map.getZoom();
	 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
	 	        	//联动
	 	        	 var bounds=map.getBounds();
	            	 var zuoshang=bounds.getNorthwest();
	                 var youxia=bounds.getSoutheast();
	                 var zs1=zuoshang.latitude;
	                 var zs2=zuoshang.longitude;
	                 var yx1=youxia.latitude;
                    var yx2=youxia.longitude;
                    bieshu++;
                    if(bieshu!=1){
                    	$.ajax({
    	     		 	    type: "POST",
    	     		 		dateType: "json",
    	     		 		url: "/BingMap1/filterByGPS1",	
    	     		 		data:{gpsLeftX:zs1,gpsLeftY:zs2,gpsRightX:yx1,gpsRightY:yx2},
    	     		 		success:function(data){
    	     		       
    	     		 		data=$.parseJSON(data);
    	     		 		 var html = getHtml1(data.List);
    	     		 		 $("#left").html(html);  
    	     		 		  
    	     		 	    },
    	     		 
    	     		 		error:function(){
    	     		 			//alert("addDefaultPushpin error")
    	     		 		}
    	     	        });
                    }
	                 
	                 if(lastZoomLevel != map.getZoom()){
		 	               lastZoomLevel = map.getZoom();
		 	            //注册鼠标上移事件
			 	              $(document).on("mouseenter","#left >.div_node",function(){
		 	             			$(this).css("background-color","rgb(223,223,223)");
		 	             			var nation=$(this).children().first().text();
		 	             			var zhou=$(this).children().first().next().text();
		 	             			var city=$(this).children().first().next().next().text();
		 	             			var area=$(this).children().first().next().next().next().text();
		 	             			var href=$(this).children().first().next().next().next().next().next().attr("href");
		 	             			var arr=new Array();
		 	             			arr = href.split("=");
		 	             			var proNum=arr[1];
		 	             			//alert(proNum);
		 	             			var arr3=new Array();
	                 		 		var LA3;
	                 		 		var total2;
	                 		 		var pushpinOptions3;
	                 		 		var pushpin3;
	                 		 		//项目名
	                 		 		if(lastZoomLevel>10){
	                 		 		map.entities.clear();
	                 		 		for(var p=0;p<lenItems;p++){
	                 		 	        arr3=items[p].gps.split(",");
	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
	                 		 	        var num=items[p].project_num;
			 	 	 		            var name=items[p].project_name;
			 	 	 		            var image=items[p].project_img;
			 	 	 		            var img=imgdir+"/"+image;	 		        
			 	 	 		            var price=items[p].project_min_price;
			 	 	 		            var type=items[p].project_type;
	    			 	 	 		    if(proNum==num){
	    			 	 	 		    	//map.entities.remove(LA3);
	                 		 				pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin3.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	    map.entities.push(pushpin3);
	    			 	 	 		    }else{
	    			 	 	 		    	pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	    			 	 	 		    	pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	    map.entities.push(pushpin3);
	    			 	 	 		    }
	                 		 		}	
	                 		 		}
	                 		 	    //区域
	                 		 		else if(lastZoomLevel>8){
	                 		 		map.entities.clear();
	                 		 		for(var a=0;a<lenArea;a++){
			 	            	        arr3=itemsArea2[a].gps.split(",");
			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
			 	            	        var area3=itemsArea2[a].project_area;
			 	            	        total2=String(itemsArea1[a].area);
	                 		 			if(area==area3){
	                 		 				//map.entities.remove(LA3);
	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea2.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add2(area3,pushpin3,LA3);
	                 		 				addmouse_out(pushpin3);
	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    		 	                  	        map.entities.push(pushpin3);
		                    		 		}else{
		                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add2(area3,pushpin3,LA3);
 	                 		 				addmouse_out(pushpin3);
 	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	    		 	                  	        map.entities.push(pushpin3);
		                    		 		}
	                 		 		}	 	                    		 		
	                 		 		}
	                 		 		//城市
	                 		 		else if(lastZoomLevel>6){
	                 		 			map.entities.clear();
	                 		 			for(var c=0;c<lenCity;c++){
	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var city3=itemsCity2[c].project_city;
	 	   		 	            	        total2=String(itemsCity1[c].city);
	 	                    		 			if(city==city3){
	 	                    		 				//map.entities.remove(LA3);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 			
		 	                    		 		}else{
		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 		}
	 	                    		 		}	
	                 		 		}
	                 		 	//州
	                 		 		else if(lastZoomLevel>4){
	                 		 			map.entities.clear();
	                 		 			for(var z=0;z<lenZhou;z++){
		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
		   		 	            	            total2=String(itemsZhou1[z].zhou);
		                    		 			if(zhou==zhou3){
		                    		 				//map.entities.remove(LA3);
		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou2.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);
	 	                    		 			
	 	                    		 		}else{
	 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                    		 				add2(zhou3,pushpin3,LA3);
	                    		 				addmouse_out(pushpin3);
	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	       		 	                  	        map.entities.push(pushpin3);
	 	                    		 		}
		                    		 		}
	                 		 		}
	                 		 	 // 国家
	                 		 		else{
	                 		 			map.entities.clear();
	                 		 			for(var n=0;n<lenNation;n++){
	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
	 	   		 	            	        var pronum=itemsNation2[n].project_num;
	 	   		 	            	        total2=String(itemsNation1[n].nation);
	 	                    		 			if(nation==nation3){
	 	                    		 				//map.entities.remove(LA3);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 			
		 	                    		 		}else{
		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 		}
	 	                    		 		}
	                 		 		}
		 	             		})
		 	             		 //注册鼠标离开事件
		 	             		$(document).on("mouseleave","#left >.div_node",function(){
		 	             			$(this).css("background-color","white");
		 	             			var arr3=new Array();
	                 		 		var LA3;
	                 		 		var total2;
	                 		 		var pushpinOptions3;
	                 		 		var pushpin3;
	                 		 		//项目名
	                 		 		if(lastZoomLevel>10){
	                 		 		map.entities.clear();
	                 		 		for(var p=0;p<lenItems;p++){
	                 		 	        arr3=items[p].gps.split(",");
	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
	                 		 	        var num=items[p].project_num;
			 	 	 		            var name=items[p].project_name;
			 	 	 		            var image=items[p].project_img;
			 	 	 		            var img=imgdir+"/"+image;	 		        
			 	 	 		            var price=items[p].project_min_price;
			 	 	 		            var type=items[p].project_type;  	    			 	 	 
	                 		 			pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	                 		 			pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 			add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	map.entities.push(pushpin3);    	    			 	 	 		    
	                 		 		}	
	                 		 		}
	                 		 	    //区域
	                 		 		else if(lastZoomLevel>8){
	                 		 		map.entities.clear();
	                 		 		for(var a=0;a<lenArea;a++){
			 	            	        arr3=itemsArea2[a].gps.split(",");
			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
			 	            	        var area3=itemsArea2[a].project_area;
			 	            	        total2=String(itemsArea1[a].area);	
	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add2(area3,pushpin3,LA3);
	                 		 				addmouse_out(pushpin3);
	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    		 	                  	        map.entities.push(pushpin3);	                    		 		
	                 		 		}	 	                    		 		
	                 		 		}
	                 		 		//城市
	                 		 		else if(lastZoomLevel>6){
	                 		 			map.entities.clear();
	                 		 			for(var c=0;c<lenCity;c++){
	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var city3=itemsCity2[c].project_city;
	 	   		 	            	        total2=String(itemsCity1[c].city);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);  		 	                    		 		
	 	                    		 		}	
	                 		 		}
	                 		 	//州
	                 		 		else if(lastZoomLevel>4){
	                 		 			map.entities.clear();
	                 		 			for(var z=0;z<lenZhou;z++){
		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
		   		 	            	            total2=String(itemsZhou1[z].zhou);
		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);                   		 		
		                    		 		}
	                 		 		}
	                 		 	 // 国家
	                 		 		else{
	                 		 			map.entities.clear();
	                 		 			for(var n=0;n<lenNation;n++){
	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
	 	   		 	            	        var pronum=itemsNation2[n].project_num;
	 	   		 	            	        total2=String(itemsNation1[n].nation);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);   		 	                    		 		
	 	                    		 		}
	                 		 		}
		 	             		})
		 	               if(lastZoomLevel>10){
		 	            	  map.entities.clear();
		 	            	  for(var i=0;i<items.length;i++){
		 	 	 		        var arr=new Array();
		 	 	 		        arr=items[i].gps.split(",");
		 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
		 	 	 		        var num=items[i].project_num;
		 	 	 		        var name=items[i].project_name;
		 	 	 		        var image=items[i].project_img;
		 	 	 		        var img=imgdir+"/"+image;	 		        
		 	 	 		       /* var minprice=items[i].project_min_price;
		 	 	 		        var maxprice=items[i].project_high_price;*/
		 	 	 		        var city=items[i].project_city;
		 	 	 		        //var price=items[i].project_price_int_qi;
		 	 	 		        var price=items[i].project_min_price;
		 	 	 		        var type=items[i].project_type;
		 	 	 		        var pushpinOptions = {width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'}; 
		 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
		 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
		 	 				    add(name,type,img,price,num,pushpin,LA);
		 	 				    map.entities.push(pushpin);	
		 	 	 		    }	 	            	   
		 	               }else if(lastZoomLevel>8){		 	            	  
		 	            	    map.entities.clear();
		 	            	    var lenArea=itemsArea1.length;
		 	            	    for(var j=0;j<lenArea;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsArea2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var area2=itemsArea2[j].project_area;
		 	            	        var total=String(itemsArea1[j].area);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(area2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else if(lastZoomLevel>6){
		 	            	    map.entities.clear();
		 	            	    var lenCity=itemsCity1.length;
		 	            	    for(var j=0;j<lenCity;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsCity2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var city2=itemsCity2[j].project_city;
		 	            	        var total=String(itemsCity1[j].city);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(city2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else if(lastZoomLevel>4){
		 	            	    map.entities.clear();
		 	            	    var lenZhou=itemsZhou1.length;
		 	            	    for(var j=0;j<lenZhou;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsZhou2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var zhou2=itemsZhou2[j].project_zhou;
		 	            	        var total=String(itemsZhou1[j].zhou);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(zhou2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else{
		 	            	    map.entities.clear();
		 	            	    var lenNation=itemsNation1.length;
		 	            	    for(var j=0;j<lenNation;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsNation2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var nation2=itemsNation2[j].project_nation;
		 	            	        var total=String(itemsNation1[j].nation);
		 	            	        //var shownation=nation2+'\r\n'+total;
		 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin2.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 42, height: 42,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(nation2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }
		 	        	}
	 	        });
	 		   
	 		   
	 		},
	 		error:function(){
	 			//alert("addDefaultPushpin error")
	 		}
        });		 
      }
      /* 增加联排别墅pushpin*/
	   function addPushpin3()
      {
		     var lianpai = 0;
		     //alert("lianpaibieshu")
			 map.entities.clear(); 
			 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
			 $.ajax({
			 	    type: "GET",
			 		dateType: "json",
			 		url: "/BingMap/FileterType2?house_type=3",		
			 		success:function(data){
			        //alert(data)
			 		data=$.parseJSON(data);
			 		 var html = getHtml1(data.List);
			 		 $("#left").html(html); 
			 		    var items=data.List;
			 		    var itemsNation1=data.ListNation1;
			 		    var itemsNation2=data.ListNation2;
			 		    var itemsZhou1=data.ListZhou1;
			 		    var itemsZhou2=data.ListZhou2;
			 		    var itemsCity1=data.ListCity1;
			 		    var itemsCity2=data.ListCity2;
			 		    var itemsArea1=data.ListArea1;
			 		    var itemsArea2=data.ListArea2;
			 		    var lenItems=items.length;
			 		    var a=new Array();
			 		    var Zoom;
			 		    if(lenItems!=0){
			 		    	a=items[0].gps.split(",");
			 		    	Zoom=4;	 		    	
			 		    }
			 		    else{
			 		    	a[0]="-25.585241";
				 		    a[1]="134.504120";
				 		    Zoom=5;
			 		    } 
			 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
			 		    map.setView({ zoom: Zoom, center: Center });
/*			 		    var a=new Array();
			 		    a=items[0].gps.split(",");
			 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
			 		    map.setView({ zoom: 11, center: Center });*/	
			 		    lastZoomLevel = map.getZoom();
			 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
			 	        	//联动
			 	        	 var bounds=map.getBounds();
			            	 var zuoshang=bounds.getNorthwest();
			                 var youxia=bounds.getSoutheast();
			                 var zs1=zuoshang.latitude;
			                 var zs2=zuoshang.longitude;
			                 var yx1=youxia.latitude;
		                     var yx2=youxia.longitude;
		                     lianpai++;
		                     if(lianpai!=1){
		                    	 $.ajax({
					     		 	    type: "POST",
					     		 		dateType: "json",
					     		 		url: "/BingMap1/filterByGPS1",	
					     		 		data:{gpsLeftX:zs1,gpsLeftY:zs2,gpsRightX:yx1,gpsRightY:yx2},
					     		 		success:function(data){
					     		       
					     		 		data=$.parseJSON(data);
					     		 		
					     		 		
					     		 		 var html = getHtml1(data.List);
					     		 		 
					     		 		 $("#left").html(html);  
					     		 		  
					     		 	    },
					     		 
					     		 		error:function(){
					     		 			//alert("addDefaultPushpin error")
					     		 		}
					     	        });
		                     }
			                 
			                 if(lastZoomLevel != map.getZoom()){
				 	               lastZoomLevel = map.getZoom();
				 	            //注册鼠标上移事件
	    			 	              $(document).on("mouseenter","#left >.div_node",function(){
	    		 	             			$(this).css("background-color","rgb(223,223,223)");
	    		 	             			var nation=$(this).children().first().text();
	    		 	             			var zhou=$(this).children().first().next().text();
	    		 	             			var city=$(this).children().first().next().next().text();
	    		 	             			var area=$(this).children().first().next().next().next().text();
	    		 	             			var href=$(this).children().first().next().next().next().next().next().attr("href");
	    		 	             			var arr=new Array();
	    		 	             			arr = href.split("=");
	    		 	             			var proNum=arr[1];
	    		 	             			//alert(proNum);
	    		 	             			var arr3=new Array();
	    	                 		 		var LA3;
	    	                 		 		var total2;
	    	                 		 		var pushpinOptions3;
	    	                 		 		var pushpin3;
	    	                 		 		//项目名
	    	                 		 		if(lastZoomLevel>10){
	    	                 		 		map.entities.clear();
	    	                 		 		for(var p=0;p<lenItems;p++){
	    	                 		 	        arr3=items[p].gps.split(",");
	    	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
	    	                 		 	        var num=items[p].project_num;
	      			 	 	 		            var name=items[p].project_name;
	      			 	 	 		            var image=items[p].project_img;
	      			 	 	 		            var img=imgdir+"/"+image;	 		        
	      			 	 	 		            var price=items[p].project_min_price;
	      			 	 	 		            var type=items[p].project_type;
	    	    			 	 	 		    if(proNum==num){
	    	    			 	 	 		    	//map.entities.remove(LA3);
	    	                 		 				pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin3.png'};
	    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	                 		 				add(name,type,img,price,num,pushpin3,LA3);
	    	    		 	                  	    map.entities.push(pushpin3);
	    	    			 	 	 		    }else{
	    	    			 	 	 		    	pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	    	    			 	 	 		    	pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	                 		 				add(name,type,img,price,num,pushpin3,LA3);
	    	    		 	                  	    map.entities.push(pushpin3);
	    	    			 	 	 		    }
	    	                 		 		}	
	    	                 		 		}
	    	                 		 	    //区域
	    	                 		 		else if(lastZoomLevel>8){
	    	                 		 		map.entities.clear();
	    	                 		 		for(var a=0;a<lenArea;a++){
	    			 	            	        arr3=itemsArea2[a].gps.split(",");
	    			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	    			 	            	        var area3=itemsArea2[a].project_area;
	    			 	            	        total2=String(itemsArea1[a].area);
	    	                 		 			if(area==area3){
	    	                 		 				//map.entities.remove(LA3);
	    	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea2.png'};
	    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	                 		 				add2(area3,pushpin3,LA3);
	    	                 		 				addmouse_out(pushpin3);
	    	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    	    		 	                  	        map.entities.push(pushpin3);
	    		                    		 		}else{
	    		                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
	        	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	        	                 		 				add2(area3,pushpin3,LA3);
	        	                 		 				addmouse_out(pushpin3);
	        	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	        	    		 	                  	        map.entities.push(pushpin3);
	    		                    		 		}
	    	                 		 		}	 	                    		 		
	    	                 		 		}
	    	                 		 		//城市
	    	                 		 		else if(lastZoomLevel>6){
	    	                 		 			map.entities.clear();
	    	                 		 			for(var c=0;c<lenCity;c++){
	    	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
	    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	    	 	   		 	            	        var city3=itemsCity2[c].project_city;
	    	 	   		 	            	        total2=String(itemsCity1[c].city);
	    	 	                    		 			if(city==city3){
	    	 	                    		 				//map.entities.remove(LA3);
	    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity2.png'};
	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	 	                    		 				add2(city3,pushpin3,LA3);
	    	 	                    		 				addmouse_out(pushpin3);
	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    	 	       		 	                  	        map.entities.push(pushpin3);
	    		 	                    		 			
	    		 	                    		 		}else{
	    		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	 	                    		 				add2(city3,pushpin3,LA3);
	    	 	                    		 				addmouse_out(pushpin3);
	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    	 	       		 	                  	        map.entities.push(pushpin3);
	    		 	                    		 		}
	    	 	                    		 		}	
	    	                 		 		}
	    	                 		 	//州
	    	                 		 		else if(lastZoomLevel>4){
	    	                 		 			map.entities.clear();
	    	                 		 			for(var z=0;z<lenZhou;z++){
	    		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
	    		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	    		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
	    		   		 	            	            total2=String(itemsZhou1[z].zhou);
	    		                    		 			if(zhou==zhou3){
	    		                    		 				//map.entities.remove(LA3);
	    		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou2.png'};
	    		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    		                    		 				add2(zhou3,pushpin3,LA3);
	    		                    		 				addmouse_out(pushpin3);
	    		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    		       		 	                  	        map.entities.push(pushpin3);
	    	 	                    		 			
	    	 	                    		 		}else{
	    	 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
			                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
			                    		 				add2(zhou3,pushpin3,LA3);
			                    		 				addmouse_out(pushpin3);
			       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
			       		 	                  	        map.entities.push(pushpin3);
	    	 	                    		 		}
	    		                    		 		}
	    	                 		 		}
	    	                 		 	 // 国家
	    	                 		 		else{
	    	                 		 			map.entities.clear();
	    	                 		 			for(var n=0;n<lenNation;n++){
	    	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
	    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	    	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
	    	 	   		 	            	        var pronum=itemsNation2[n].project_num;
	    	 	   		 	            	        total2=String(itemsNation1[n].nation);
	    	 	                    		 			if(nation==nation3){
	    	 	                    		 				//map.entities.remove(LA3);
	    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	 	                    		 				add2(nation3,pushpin3,LA3);
	    	 	                    		 				addmouse_out(pushpin3);
	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    	 	       		 	                  	        map.entities.push(pushpin3);
	    		 	                    		 			
	    		 	                    		 		}else{
	    		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	 	                    		 				add2(nation3,pushpin3,LA3);
	    	 	                    		 				addmouse_out(pushpin3);
	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    	 	       		 	                  	        map.entities.push(pushpin3);
	    		 	                    		 		}
	    	 	                    		 		}
	    	                 		 		}
	    		 	             		})
	    		 	             		 //注册鼠标离开事件
	    		 	             		$(document).on("mouseleave","#left >.div_node",function(){
	    		 	             			$(this).css("background-color","white");
	    		 	             			var arr3=new Array();
	    	                 		 		var LA3;
	    	                 		 		var total2;
	    	                 		 		var pushpinOptions3;
	    	                 		 		var pushpin3;
	    	                 		 		//项目名
	    	                 		 		if(lastZoomLevel>10){
	    	                 		 		map.entities.clear();
	    	                 		 		for(var p=0;p<lenItems;p++){
	    	                 		 	        arr3=items[p].gps.split(",");
	    	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
	    	                 		 	        var num=items[p].project_num;
	      			 	 	 		            var name=items[p].project_name;
	      			 	 	 		            var image=items[p].project_img;
	      			 	 	 		            var img=imgdir+"/"+image;	 		        
	      			 	 	 		            var price=items[p].project_min_price;
	      			 	 	 		            var type=items[p].project_type;  	    			 	 	 
	    	                 		 			pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	    	                 		 			pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	                 		 			add(name,type,img,price,num,pushpin3,LA3);
	    	    		 	                  	map.entities.push(pushpin3);    	    			 	 	 		    
	    	                 		 		}	
	    	                 		 		}
	    	                 		 	    //区域
	    	                 		 		else if(lastZoomLevel>8){
	    	                 		 		map.entities.clear();
	    	                 		 		for(var a=0;a<lenArea;a++){
	    			 	            	        arr3=itemsArea2[a].gps.split(",");
	    			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	    			 	            	        var area3=itemsArea2[a].project_area;
	    			 	            	        total2=String(itemsArea1[a].area);	
	    	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
	    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	                 		 				add2(area3,pushpin3,LA3);
	    	                 		 				addmouse_out(pushpin3);
	    	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    	    		 	                  	        map.entities.push(pushpin3);	                    		 		
	    	                 		 		}	 	                    		 		
	    	                 		 		}
	    	                 		 		//城市
	    	                 		 		else if(lastZoomLevel>6){
	    	                 		 			map.entities.clear();
	    	                 		 			for(var c=0;c<lenCity;c++){
	    	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
	    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	    	 	   		 	            	        var city3=itemsCity2[c].project_city;
	    	 	   		 	            	        total2=String(itemsCity1[c].city);
	    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	 	                    		 				add2(city3,pushpin3,LA3);
	    	 	                    		 				addmouse_out(pushpin3);
	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    	 	       		 	                  	        map.entities.push(pushpin3);  		 	                    		 		
	    	 	                    		 		}	
	    	                 		 		}
	    	                 		 	//州
	    	                 		 		else if(lastZoomLevel>4){
	    	                 		 			map.entities.clear();
	    	                 		 			for(var z=0;z<lenZhou;z++){
	    		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
	    		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	    		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
	    		   		 	            	            total2=String(itemsZhou1[z].zhou);
	    		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
	    		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    		                    		 				add2(zhou3,pushpin3,LA3);
	    		                    		 				addmouse_out(pushpin3);
	    		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    		       		 	                  	        map.entities.push(pushpin3);                   		 		
	    		                    		 		}
	    	                 		 		}
	    	                 		 	 // 国家
	    	                 		 		else{
	    	                 		 			map.entities.clear();
	    	                 		 			for(var n=0;n<lenNation;n++){
	    	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
	    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	    	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
	    	 	   		 	            	        var pronum=itemsNation2[n].project_num;
	    	 	   		 	            	        total2=String(itemsNation1[n].nation);
	    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	    	 	                    		 				add2(nation3,pushpin3,LA3);
	    	 	                    		 				addmouse_out(pushpin3);
	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    	 	       		 	                  	        map.entities.push(pushpin3);   		 	                    		 		
	    	 	                    		 		}
	    	                 		 		}
	    		 	             		})
				 	               if(lastZoomLevel>10){
				 	            	  map.entities.clear();
				 	            	  for(var i=0;i<items.length;i++){
				 	 	 		        var arr=new Array();
				 	 	 		        arr=items[i].gps.split(",");
				 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
				 	 	 		        var num=items[i].project_num;
				 	 	 		        var name=items[i].project_name;
				 	 	 		        var image=items[i].project_img;
				 	 	 		        var img=imgdir+"/"+image;	 		        
				 	 	 		       /* var minprice=items[i].project_min_price;
				 	 	 		        var maxprice=items[i].project_high_price;*/
				 	 	 		        var city=items[i].project_city;
				 	 	 		        //var price=items[i].project_price_int_qi;
				 	 	 		        var price=items[i].project_min_price;
				 	 	 		        var type=items[i].project_type;
				 	 	 		        var pushpinOptions = {width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'}; 
				 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
				 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
				 	 				    add(name,type,img,price,num,pushpin,LA);
				 	 				    map.entities.push(pushpin);	
				 	 	 		    }	 	            	   
				 	               }else if(lastZoomLevel>8){		 	            	  
				 	            	    map.entities.clear();
				 	            	    var lenArea=itemsArea1.length;
				 	            	    for(var j=0;j<lenArea;j++){
				 	            	        var arr2=new Array();
				 	            	        arr2=itemsArea2[j].gps.split(",");
				 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
				 	            	        var area2=itemsArea2[j].project_area;
				 	            	        var total=String(itemsArea1[j].area);
				 	            	        //alert(typeof(total))
				 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
				 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
				 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
				 	            	        add2(area2,pushpin2,LA2);
				 	            	       addmouse_out(pushpin2);
				 	            	        add3(lastZoomLevel,pushpin2,LA2);
				 	                  	    map.entities.push(pushpin2);
				 	            	    }
				 	               }else if(lastZoomLevel>6){
				 	            	    map.entities.clear();
				 	            	    var lenCity=itemsCity1.length;
				 	            	    for(var j=0;j<lenCity;j++){
				 	            	        var arr2=new Array();
				 	            	        arr2=itemsCity2[j].gps.split(",");
				 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
				 	            	        var city2=itemsCity2[j].project_city;
				 	            	        var total=String(itemsCity1[j].city);
				 	            	        //alert(typeof(total))
				 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
				 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
				 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
				 	            	        add2(city2,pushpin2,LA2);
				 	            	       addmouse_out(pushpin2);
				 	            	        add3(lastZoomLevel,pushpin2,LA2);
				 	                  	    map.entities.push(pushpin2);
				 	            	    }
				 	               }else if(lastZoomLevel>4){
				 	            	    map.entities.clear();
				 	            	    var lenZhou=itemsZhou1.length;
				 	            	    for(var j=0;j<lenZhou;j++){
				 	            	        var arr2=new Array();
				 	            	        arr2=itemsZhou2[j].gps.split(",");
				 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
				 	            	        var zhou2=itemsZhou2[j].project_zhou;
				 	            	        var total=String(itemsZhou1[j].zhou);
				 	            	        //alert(typeof(total))
				 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
				 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
				 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
				 	            	        add2(zhou2,pushpin2,LA2);
				 	            	       addmouse_out(pushpin2);
				 	            	        add3(lastZoomLevel,pushpin2,LA2);
				 	                  	    map.entities.push(pushpin2);
				 	            	    }
				 	               }else{
				 	            	    map.entities.clear();
				 	            	    var lenNation=itemsNation1.length;
				 	            	    for(var j=0;j<lenNation;j++){
				 	            	        var arr2=new Array();
				 	            	        arr2=itemsNation2[j].gps.split(",");
				 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
				 	            	        var nation2=itemsNation2[j].project_nation;
				 	            	        var total=String(itemsNation1[j].nation);
				 	            	        //var shownation=nation2+'\r\n'+total;
				 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin2.png' style='width:100px;'/></div>"}; */
				 	            	        var pushpinOptions2={text:total,width: 42, height: 42,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
				 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
				 	            	        add2(nation2,pushpin2,LA2);
				 	            	       addmouse_out(pushpin2);
				 	            	        add3(lastZoomLevel,pushpin2,LA2);
				 	                  	    map.entities.push(pushpin2);
				 	            	    }
				 	               }
				 	        	}
			 	        });
			 		   
			 		   
			 		},
			 		error:function(){
			 			//alert("addDefaultPushpin error")
			 		}
		        });		 
      }
       /* 增加搜索pushpin*/
         function addPushpinsearch()
      {
        	 var project_name = $("#keyWord").val();
        	 //alert(project_name)
        	/* var area=$("#project_area").val();
        	 var city=$("#project_city").val();
        	 var address=$("#project_address").val();
        	 var arrArea=new Array();
        	 arrArea=area.split(",");
        	 area=arrArea[0];
        	 var arrCity=new Array();
        	 arrCity=city.split(",");
        	 city=arrCity[0];
        	 var arrAddr=new Array();
        	 arrAddr=address.split(",");
        	 address=arrAddr[0];
        	 if(typeof(city)=="undefined"){
        		 city="";
        	 }*/
        	 //alert(city);
        	 //alert(area);
        	 //alert(address);
    		 map.entities.clear(); 
    		 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
    		 $.ajax({
    		 	    type: "POST",
    		 		dateType: "json",
    		 		data:{"project_name":project_name/*,"city":city,"address":address*/}, 		
    		 		url: "/BingMap/FileterByProjectName", 
    		 		success:function(data){
    		 		data=$.parseJSON(data);
    		 		//alert(data)
    		 		
    		 		var html = getHtml1(data.List);
			 		 $("#left").html(html); 
			 		 
    		 		    var items=data.List;
    		 		    var itemsNation1=data.ListNation1;
    		 		    var itemsNation2=data.ListNation2;
    		 		    var itemsZhou1=data.ListZhou1;
    		 		    var itemsZhou2=data.ListZhou2;
    		 		    var itemsCity1=data.ListCity1;
    		 		    var itemsCity2=data.ListCity2;
    		 		    var itemsArea1=data.ListArea1;
    		 		    var itemsArea2=data.ListArea2;   		 		  
    		 		    var lenItems=items.length;
    		 		    var a=new Array();
    		 		    var Zoom;
    		 		    if(lenItems!=0){
    		 		    	a=items[0].gps.split(",");
			 		    	Zoom=13;   		 		    	 		    	
    		 		    }else{
    		 		    	a[0]="-25.585241";
     		 		        a[1]="134.504120";
     		 		        Zoom=5;
    		 		    }  		 		    
    		 		    
    		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
    		 		    map.setView({ zoom: Zoom, center: Center });	
    		 		    lastZoomLevel = map.getZoom();
    		 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
    		 	        	//联动
   		 	        	/* var bounds=map.getBounds();
   		            	 var zuoshang=bounds.getNorthwest();
   		                 var youxia=bounds.getSoutheast();
   		                 var zs1=zuoshang.latitude;
   		                 var zs2=zuoshang.longitude;
   		                 var yx1=youxia.latitude;
   	                     var yx2=youxia.longitude;
   		                 $.ajax({
   		     		 	    type: "POST",
   		     		 		dateType: "json",
   		     		 		url: "/BingMap1/filterByGPS1",	
   		     		 		data:{gpsLeftX:zs1,gpsLeftY:zs2,gpsRightX:yx1,gpsRightY:yx2},
   		     		 		success:function(data){
   		     		       
   		     		 		data=$.parseJSON(data);
   		     		 		
   		     		 		
   		     		 		 var html = getHtml1(data.List);
   		     		 		 
   		     		 		 $("#left").html(html);  
   		     		 		  
   		     		 	    },
   		     		 
   		     		 		error:function(){
   		     		 			//alert("addDefaultPushpin error")
   		     		 		}
   		     	        });*/
   		              if(lastZoomLevel != map.getZoom()){
		 	               lastZoomLevel = map.getZoom();
		 	            //注册鼠标上移事件
			 	              $(document).on("mouseenter","#left >.div_node",function(){
		 	             			$(this).css("background-color","rgb(223,223,223)");
		 	             			var nation=$(this).children().first().text();
		 	             			var zhou=$(this).children().first().next().text();
		 	             			var city=$(this).children().first().next().next().text();
		 	             			var area=$(this).children().first().next().next().next().text();
		 	             			var href=$(this).children().first().next().next().next().next().next().attr("href");
		 	             			var arr=new Array();
		 	             			arr = href.split("=");
		 	             			var proNum=arr[1];
		 	             			//alert(proNum);
		 	             			var arr3=new Array();
	                 		 		var LA3;
	                 		 		var total2;
	                 		 		var pushpinOptions3;
	                 		 		var pushpin3;
	                 		 		//项目名
	                 		 		if(lastZoomLevel>10){
	                 		 		map.entities.clear();
	                 		 		for(var p=0;p<lenItems;p++){
	                 		 	        arr3=items[p].gps.split(",");
	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
	                 		 	        var num=items[p].project_num;
			 	 	 		            var name=items[p].project_name;
			 	 	 		            var image=items[p].project_img;
			 	 	 		            var img=imgdir+"/"+image;	 		        
			 	 	 		            var price=items[p].project_min_price;
			 	 	 		            var type=items[p].project_type;
	    			 	 	 		    if(proNum==num){
	    			 	 	 		    	//map.entities.remove(LA3);
	                 		 				pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin3.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	    map.entities.push(pushpin3);
	    			 	 	 		    }else{
	    			 	 	 		    	pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	    			 	 	 		    	pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	    map.entities.push(pushpin3);
	    			 	 	 		    }
	                 		 		}	
	                 		 		}
	                 		 	    //区域
	                 		 		else if(lastZoomLevel>8){
	                 		 		map.entities.clear();
	                 		 		for(var a=0;a<lenArea;a++){
			 	            	        arr3=itemsArea2[a].gps.split(",");
			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
			 	            	        var area3=itemsArea2[a].project_area;
			 	            	        total2=String(itemsArea1[a].area);
	                 		 			if(area==area3){
	                 		 				//map.entities.remove(LA3);
	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea2.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add2(area3,pushpin3,LA3);
	                 		 				addmouse_out(pushpin3);
	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    		 	                  	        map.entities.push(pushpin3);
		                    		 		}else{
		                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
 	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
 	                 		 				add2(area3,pushpin3,LA3);
 	                 		 				addmouse_out(pushpin3);
 	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
 	    		 	                  	        map.entities.push(pushpin3);
		                    		 		}
	                 		 		}	 	                    		 		
	                 		 		}
	                 		 		//城市
	                 		 		else if(lastZoomLevel>6){
	                 		 			map.entities.clear();
	                 		 			for(var c=0;c<lenCity;c++){
	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var city3=itemsCity2[c].project_city;
	 	   		 	            	        total2=String(itemsCity1[c].city);
	 	                    		 			if(city==city3){
	 	                    		 				//map.entities.remove(LA3);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 			
		 	                    		 		}else{
		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 		}
	 	                    		 		}	
	                 		 		}
	                 		 	//州
	                 		 		else if(lastZoomLevel>4){
	                 		 			map.entities.clear();
	                 		 			for(var z=0;z<lenZhou;z++){
		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
		   		 	            	            total2=String(itemsZhou1[z].zhou);
		                    		 			if(zhou==zhou3){
		                    		 				//map.entities.remove(LA3);
		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou2.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);
	 	                    		 			
	 	                    		 		}else{
	 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                    		 				add2(zhou3,pushpin3,LA3);
	                    		 				addmouse_out(pushpin3);
	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	       		 	                  	        map.entities.push(pushpin3);
	 	                    		 		}
		                    		 		}
	                 		 		}
	                 		 	 // 国家
	                 		 		else{
	                 		 			map.entities.clear();
	                 		 			for(var n=0;n<lenNation;n++){
	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
	 	   		 	            	        var pronum=itemsNation2[n].project_num;
	 	   		 	            	        total2=String(itemsNation1[n].nation);
	 	                    		 			if(nation==nation3){
	 	                    		 				//map.entities.remove(LA3);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 			
		 	                    		 		}else{
		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);
		 	                    		 		}
	 	                    		 		}
	                 		 		}
		 	             		})
		 	             		 //注册鼠标离开事件
		 	             		$(document).on("mouseleave","#left >.div_node",function(){
		 	             			$(this).css("background-color","white");
		 	             			var arr3=new Array();
	                 		 		var LA3;
	                 		 		var total2;
	                 		 		var pushpinOptions3;
	                 		 		var pushpin3;
	                 		 		//项目名
	                 		 		if(lastZoomLevel>10){
	                 		 		map.entities.clear();
	                 		 		for(var p=0;p<lenItems;p++){
	                 		 	        arr3=items[p].gps.split(",");
	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
	                 		 	        var num=items[p].project_num;
			 	 	 		            var name=items[p].project_name;
			 	 	 		            var image=items[p].project_img;
			 	 	 		            var img=imgdir+"/"+image;	 		        
			 	 	 		            var price=items[p].project_min_price;
			 	 	 		            var type=items[p].project_type;  	    			 	 	 
	                 		 			pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	                 		 			pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 			add(name,type,img,price,num,pushpin3,LA3);
	    		 	                  	map.entities.push(pushpin3);    	    			 	 	 		    
	                 		 		}	
	                 		 		}
	                 		 	    //区域
	                 		 		else if(lastZoomLevel>8){
	                 		 		map.entities.clear();
	                 		 		for(var a=0;a<lenArea;a++){
			 	            	        arr3=itemsArea2[a].gps.split(",");
			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
			 	            	        var area3=itemsArea2[a].project_area;
			 	            	        total2=String(itemsArea1[a].area);	
	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	                 		 				add2(area3,pushpin3,LA3);
	                 		 				addmouse_out(pushpin3);
	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	    		 	                  	        map.entities.push(pushpin3);	                    		 		
	                 		 		}	 	                    		 		
	                 		 		}
	                 		 		//城市
	                 		 		else if(lastZoomLevel>6){
	                 		 			map.entities.clear();
	                 		 			for(var c=0;c<lenCity;c++){
	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var city3=itemsCity2[c].project_city;
	 	   		 	            	        total2=String(itemsCity1[c].city);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(city3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);  		 	                    		 		
	 	                    		 		}	
	                 		 		}
	                 		 	//州
	                 		 		else if(lastZoomLevel>4){
	                 		 			map.entities.clear();
	                 		 			for(var z=0;z<lenZhou;z++){
		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
		   		 	            	            total2=String(itemsZhou1[z].zhou);
		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
		                    		 				add2(zhou3,pushpin3,LA3);
		                    		 				addmouse_out(pushpin3);
		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
		       		 	                  	        map.entities.push(pushpin3);                   		 		
		                    		 		}
	                 		 		}
	                 		 	 // 国家
	                 		 		else{
	                 		 			map.entities.clear();
	                 		 			for(var n=0;n<lenNation;n++){
	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
	 	   		 	            	        var pronum=itemsNation2[n].project_num;
	 	   		 	            	        total2=String(itemsNation1[n].nation);
	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
	 	                    		 				add2(nation3,pushpin3,LA3);
	 	                    		 				addmouse_out(pushpin3);
	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
	 	       		 	                  	        map.entities.push(pushpin3);   		 	                    		 		
	 	                    		 		}
	                 		 		}
		 	             		})
		 	               if(lastZoomLevel>10){
		 	            	  map.entities.clear();
		 	            	  for(var i=0;i<items.length;i++){
		 	 	 		        var arr=new Array();
		 	 	 		        arr=items[i].gps.split(",");
		 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
		 	 	 		        var num=items[i].project_num;
		 	 	 		        var name=items[i].project_name;
		 	 	 		        var image=items[i].project_img;
		 	 	 		        var img=imgdir+"/"+image;	 		        
		 	 	 		       /* var minprice=items[i].project_min_price;
		 	 	 		        var maxprice=items[i].project_high_price;*/
		 	 	 		        var city=items[i].project_city;
		 	 	 		        //var price=items[i].project_price_int_qi;
		 	 	 		        var price=items[i].project_min_price;
		 	 	 		        var type=items[i].project_type;
		 	 	 		        var pushpinOptions = {width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'}; 
		 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
		 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
		 	 				    add(name,type,img,price,num,pushpin,LA);
		 	 				    map.entities.push(pushpin);	
		 	 	 		    }	 	            	   
		 	               }else if(lastZoomLevel>8){		 	            	  
		 	            	    map.entities.clear();
		 	            	    var lenArea=itemsArea1.length;
		 	            	    for(var j=0;j<lenArea;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsArea2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var area2=itemsArea2[j].project_area;
		 	            	        var total=String(itemsArea1[j].area);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(area2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else if(lastZoomLevel>6){
		 	            	    map.entities.clear();
		 	            	    var lenCity=itemsCity1.length;
		 	            	    for(var j=0;j<lenCity;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsCity2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var city2=itemsCity2[j].project_city;
		 	            	        var total=String(itemsCity1[j].city);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(city2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else if(lastZoomLevel>4){
		 	            	    map.entities.clear();
		 	            	    var lenZhou=itemsZhou1.length;
		 	            	    for(var j=0;j<lenZhou;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsZhou2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var zhou2=itemsZhou2[j].project_zhou;
		 	            	        var total=String(itemsZhou1[j].zhou);
		 	            	        //alert(typeof(total))
		 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(zhou2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }else{
		 	            	    map.entities.clear();
		 	            	    var lenNation=itemsNation1.length;
		 	            	    for(var j=0;j<lenNation;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=itemsNation2[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var nation2=itemsNation2[j].project_nation;
		 	            	        var total=String(itemsNation1[j].nation);
		 	            	        //var shownation=nation2+'\r\n'+total;
		 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin2.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 42, height: 42,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	            	        add2(nation2,pushpin2,LA2);
		 	            	       addmouse_out(pushpin2);
		 	            	        add3(lastZoomLevel,pushpin2,LA2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }
		 	        	}
    		 	        });
    		 		   
    		 		   
    		 		},
    		 		error:function(){
    		 			//alert("addDefaultPushpin error")
    		 		}
    	        });	 
      }
         
         /* 增加排序pushpin*/
  	   function addPushpinOrder(order)
        {
  		   var order1 = 0;
  		     //alert("paixu"+order);
  			 map.entities.clear(); 
  			 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
  			 $.ajax({
  			 	    type: "GET",
  			 		dateType: "json",
  			 		url: "/OrderByPrice?order="+order,		
  			 		success:function(data){
  			        //alert(data)
  			 		data=$.parseJSON(data);
  			 		 var html = getHtml1(data.List);
  			 		 $("#left").html(html); 
  			 		    var items=data.List;
  			 		    var itemsNation1=data.ListNation1;
  			 		    var itemsNation2=data.ListNation2;
  			 		    var itemsZhou1=data.ListZhou1;
  			 		    var itemsZhou2=data.ListZhou2;
  			 		    var itemsCity1=data.ListCity1;
  			 		    var itemsCity2=data.ListCity2;
  			 		    var itemsArea1=data.ListArea1;
  			 		    var itemsArea2=data.ListArea2;
  			 		    var lenItems=items.length;
  			 		    var a=new Array();
  			 		    var Zoom;
  			 		    if(lenItems!=0){
  			 		    	a=items[0].gps.split(",");
  			 		    	Zoom=4;	 		    	
  			 		    }
  			 		    else{
  			 		    	a[0]="-25.585241";
  				 		    a[1]="134.504120";
  				 		    Zoom=5;
  			 		    } 
  			 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
  			 		    map.setView({ zoom: Zoom, center: Center });	
  			 		    lastZoomLevel = map.getZoom();
  			 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
  			 	        	//联动
  			 	        	 var bounds=map.getBounds();
  			            	 var zuoshang=bounds.getNorthwest();
  			                 var youxia=bounds.getSoutheast();
  			                 var zs1=zuoshang.latitude;
  			                 var zs2=zuoshang.longitude;
  			                 var yx1=youxia.latitude;
  		                     var yx2=youxia.longitude;
  		                     order1++;
  		                     if(order1!=1){
  		                    	$('#Price').val("0");
  		                    	 $.ajax({
  					     		 	    type: "POST",
  					     		 		dateType: "json",
  					     		 		url: "/BingMap1/filterByGPS1",	
  					     		 		data:{gpsLeftX:zs1,gpsLeftY:zs2,gpsRightX:yx1,gpsRightY:yx2},
  					     		 		success:function(data){
  					     		       
  					     		 		data=$.parseJSON(data);
  					     		 		
  					     		 		
  					     		 		 var html = getHtml1(data.List);
  					     		 		 
  					     		 		 $("#left").html(html);  
  					     		 		  
  					     		 	    },
  					     		 
  					     		 		error:function(){
  					     		 			//alert("addDefaultPushpin error")
  					     		 		}
  					     	        });
  		                     }
  			                 
  			                 if(lastZoomLevel != map.getZoom()){
  				 	               lastZoomLevel = map.getZoom();
  				 	            //注册鼠标上移事件
  	    			 	              $(document).on("mouseenter","#left >.div_node",function(){
  	    		 	             			$(this).css("background-color","rgb(223,223,223)");
  	    		 	             			var nation=$(this).children().first().text();
  	    		 	             			var zhou=$(this).children().first().next().text();
  	    		 	             			var city=$(this).children().first().next().next().text();
  	    		 	             			var area=$(this).children().first().next().next().next().text();
  	    		 	             			var href=$(this).children().first().next().next().next().next().next().attr("href");
  	    		 	             			var arr=new Array();
  	    		 	             			arr = href.split("=");
  	    		 	             			var proNum=arr[1];
  	    		 	             			//alert(proNum);
  	    		 	             			var arr3=new Array();
  	    	                 		 		var LA3;
  	    	                 		 		var total2;
  	    	                 		 		var pushpinOptions3;
  	    	                 		 		var pushpin3;
  	    	                 		 		//项目名
  	    	                 		 		if(lastZoomLevel>10){
  	    	                 		 		map.entities.clear();
  	    	                 		 		for(var p=0;p<lenItems;p++){
  	    	                 		 	        arr3=items[p].gps.split(",");
  	    	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
  	    	                 		 	        var num=items[p].project_num;
  	      			 	 	 		            var name=items[p].project_name;
  	      			 	 	 		            var image=items[p].project_img;
  	      			 	 	 		            var img=imgdir+"/"+image;	 		        
  	      			 	 	 		            var price=items[p].project_min_price;
  	      			 	 	 		            var type=items[p].project_type;
  	    	    			 	 	 		    if(proNum==num){
  	    	    			 	 	 		    	//map.entities.remove(LA3);
  	    	                 		 				pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin3.png'};
  	    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	                 		 				add(name,type,img,price,num,pushpin3,LA3);
  	    	    		 	                  	    map.entities.push(pushpin3);
  	    	    			 	 	 		    }else{
  	    	    			 	 	 		    	pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
  	    	    			 	 	 		    	pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	                 		 				add(name,type,img,price,num,pushpin3,LA3);
  	    	    		 	                  	    map.entities.push(pushpin3);
  	    	    			 	 	 		    }
  	    	                 		 		}	
  	    	                 		 		}
  	    	                 		 	    //区域
  	    	                 		 		else if(lastZoomLevel>8){
  	    	                 		 		map.entities.clear();
  	    	                 		 		for(var a=0;a<lenArea;a++){
  	    			 	            	        arr3=itemsArea2[a].gps.split(",");
  	    			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
  	    			 	            	        var area3=itemsArea2[a].project_area;
  	    			 	            	        total2=String(itemsArea1[a].area);
  	    	                 		 			if(area==area3){
  	    	                 		 				//map.entities.remove(LA3);
  	    	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea2.png'};
  	    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	                 		 				add2(area3,pushpin3,LA3);
  	    	                 		 				addmouse_out(pushpin3);
  	    	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    	    		 	                  	        map.entities.push(pushpin3);
  	    		                    		 		}else{
  	    		                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
  	        	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	        	                 		 				add2(area3,pushpin3,LA3);
  	        	                 		 				addmouse_out(pushpin3);
  	        	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	        	    		 	                  	        map.entities.push(pushpin3);
  	    		                    		 		}
  	    	                 		 		}	 	                    		 		
  	    	                 		 		}
  	    	                 		 		//城市
  	    	                 		 		else if(lastZoomLevel>6){
  	    	                 		 			map.entities.clear();
  	    	                 		 			for(var c=0;c<lenCity;c++){
  	    	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
  	    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
  	    	 	   		 	            	        var city3=itemsCity2[c].project_city;
  	    	 	   		 	            	        total2=String(itemsCity1[c].city);
  	    	 	                    		 			if(city==city3){
  	    	 	                    		 				//map.entities.remove(LA3);
  	    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity2.png'};
  	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	 	                    		 				add2(city3,pushpin3,LA3);
  	    	 	                    		 				addmouse_out(pushpin3);
  	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    	 	       		 	                  	        map.entities.push(pushpin3);
  	    		 	                    		 			
  	    		 	                    		 		}else{
  	    		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
  	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	 	                    		 				add2(city3,pushpin3,LA3);
  	    	 	                    		 				addmouse_out(pushpin3);
  	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    	 	       		 	                  	        map.entities.push(pushpin3);
  	    		 	                    		 		}
  	    	 	                    		 		}	
  	    	                 		 		}
  	    	                 		 	//州
  	    	                 		 		else if(lastZoomLevel>4){
  	    	                 		 			map.entities.clear();
  	    	                 		 			for(var z=0;z<lenZhou;z++){
  	    		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
  	    		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
  	    		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
  	    		   		 	            	            total2=String(itemsZhou1[z].zhou);
  	    		                    		 			if(zhou==zhou3){
  	    		                    		 				//map.entities.remove(LA3);
  	    		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou2.png'};
  	    		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    		                    		 				add2(zhou3,pushpin3,LA3);
  	    		                    		 				addmouse_out(pushpin3);
  	    		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    		       		 	                  	        map.entities.push(pushpin3);
  	    	 	                    		 			
  	    	 	                    		 		}else{
  	    	 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
  			                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  			                    		 				add2(zhou3,pushpin3,LA3);
  			                    		 				addmouse_out(pushpin3);
  			       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  			       		 	                  	        map.entities.push(pushpin3);
  	    	 	                    		 		}
  	    		                    		 		}
  	    	                 		 		}
  	    	                 		 	 // 国家
  	    	                 		 		else{
  	    	                 		 			map.entities.clear();
  	    	                 		 			for(var n=0;n<lenNation;n++){
  	    	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
  	    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
  	    	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
  	    	 	   		 	            	        var pronum=itemsNation2[n].project_num;
  	    	 	   		 	            	        total2=String(itemsNation1[n].nation);
  	    	 	                    		 			if(nation==nation3){
  	    	 	                    		 				//map.entities.remove(LA3);
  	    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
  	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	 	                    		 				add2(nation3,pushpin3,LA3);
  	    	 	                    		 				addmouse_out(pushpin3);
  	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    	 	       		 	                  	        map.entities.push(pushpin3);
  	    		 	                    		 			
  	    		 	                    		 		}else{
  	    		 	                    		 			pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation2.png'};
  	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	 	                    		 				add2(nation3,pushpin3,LA3);
  	    	 	                    		 				addmouse_out(pushpin3);
  	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    	 	       		 	                  	        map.entities.push(pushpin3);
  	    		 	                    		 		}
  	    	 	                    		 		}
  	    	                 		 		}
  	    		 	             		})
  	    		 	             		 //注册鼠标离开事件
  	    		 	             		$(document).on("mouseleave","#left >.div_node",function(){
  	    		 	             			$(this).css("background-color","white");
  	    		 	             			var arr3=new Array();
  	    	                 		 		var LA3;
  	    	                 		 		var total2;
  	    	                 		 		var pushpinOptions3;
  	    	                 		 		var pushpin3;
  	    	                 		 		//项目名
  	    	                 		 		if(lastZoomLevel>10){
  	    	                 		 		map.entities.clear();
  	    	                 		 		for(var p=0;p<lenItems;p++){
  	    	                 		 	        arr3=items[p].gps.split(",");
  	    	                 		 	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]);
  	    	                 		 	        var num=items[p].project_num;
  	      			 	 	 		            var name=items[p].project_name;
  	      			 	 	 		            var image=items[p].project_img;
  	      			 	 	 		            var img=imgdir+"/"+image;	 		        
  	      			 	 	 		            var price=items[p].project_min_price;
  	      			 	 	 		            var type=items[p].project_type;  	    			 	 	 
  	    	                 		 			pushpinOptions3={width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
  	    	                 		 			pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	                 		 			add(name,type,img,price,num,pushpin3,LA3);
  	    	    		 	                  	map.entities.push(pushpin3);    	    			 	 	 		    
  	    	                 		 		}	
  	    	                 		 		}
  	    	                 		 	    //区域
  	    	                 		 		else if(lastZoomLevel>8){
  	    	                 		 		map.entities.clear();
  	    	                 		 		for(var a=0;a<lenArea;a++){
  	    			 	            	        arr3=itemsArea2[a].gps.split(",");
  	    			 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
  	    			 	            	        var area3=itemsArea2[a].project_area;
  	    			 	            	        total2=String(itemsArea1[a].area);	
  	    	                 		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
  	    	                 		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	                 		 				add2(area3,pushpin3,LA3);
  	    	                 		 				addmouse_out(pushpin3);
  	    	    		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    	    		 	                  	        map.entities.push(pushpin3);	                    		 		
  	    	                 		 		}	 	                    		 		
  	    	                 		 		}
  	    	                 		 		//城市
  	    	                 		 		else if(lastZoomLevel>6){
  	    	                 		 			map.entities.clear();
  	    	                 		 			for(var c=0;c<lenCity;c++){
  	    	 	   		 	            	        arr3=itemsCity2[c].gps.split(",");
  	    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
  	    	 	   		 	            	        var city3=itemsCity2[c].project_city;
  	    	 	   		 	            	        total2=String(itemsCity1[c].city);
  	    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
  	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	 	                    		 				add2(city3,pushpin3,LA3);
  	    	 	                    		 				addmouse_out(pushpin3);
  	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    	 	       		 	                  	        map.entities.push(pushpin3);  		 	                    		 		
  	    	 	                    		 		}	
  	    	                 		 		}
  	    	                 		 	//州
  	    	                 		 		else if(lastZoomLevel>4){
  	    	                 		 			map.entities.clear();
  	    	                 		 			for(var z=0;z<lenZhou;z++){
  	    		   		 	            	            arr3=itemsZhou2[z].gps.split(",");
  	    		   		 	            	            LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
  	    		   		 	            	            var zhou3=itemsZhou2[z].project_zhou;
  	    		   		 	            	            total2=String(itemsZhou1[z].zhou);
  	    		                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
  	    		                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    		                    		 				add2(zhou3,pushpin3,LA3);
  	    		                    		 				addmouse_out(pushpin3);
  	    		       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    		       		 	                  	        map.entities.push(pushpin3);                   		 		
  	    		                    		 		}
  	    	                 		 		}
  	    	                 		 	 // 国家
  	    	                 		 		else{
  	    	                 		 			map.entities.clear();
  	    	                 		 			for(var n=0;n<lenNation;n++){
  	    	 	   		 	            	        arr3=itemsNation2[n].gps.split(",");
  	    	 	   		 	            	        LA3=new Microsoft.Maps.Location(arr3[0],arr3[1]); 
  	    	 	   		 	            	        var nation3=itemsNation2[n].project_nation;
  	    	 	   		 	            	        var pronum=itemsNation2[n].project_num;
  	    	 	   		 	            	        total2=String(itemsNation1[n].nation);
  	    	 	                    		 				pushpinOptions3={text:total2,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
  	    	 	                    		 				pushpin3= new Microsoft.Maps.Pushpin(LA3, pushpinOptions3);
  	    	 	                    		 				add2(nation3,pushpin3,LA3);
  	    	 	                    		 				addmouse_out(pushpin3);
  	    	 	       		 	            	            add3(lastZoomLevel,pushpin3,LA3);
  	    	 	       		 	                  	        map.entities.push(pushpin3);   		 	                    		 		
  	    	 	                    		 		}
  	    	                 		 		}
  	    		 	             		})
  				 	               if(lastZoomLevel>10){
  				 	            	  map.entities.clear();
  				 	            	  for(var i=0;i<items.length;i++){
  				 	 	 		        var arr=new Array();
  				 	 	 		        arr=items[i].gps.split(",");
  				 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
  				 	 	 		        var num=items[i].project_num;
  				 	 	 		        var name=items[i].project_name;
  				 	 	 		        var image=items[i].project_img;
  				 	 	 		        var img=imgdir+"/"+image;	 		        
  				 	 	 		       /* var minprice=items[i].project_min_price;
  				 	 	 		        var maxprice=items[i].project_high_price;*/
  				 	 	 		        var city=items[i].project_city;
  				 	 	 		        //var price=items[i].project_price_int_qi;
  				 	 	 		        var price=items[i].project_min_price;
  				 	 	 		        var type=items[i].project_type;
  				 	 	 		        var pushpinOptions = {width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'}; 
  				 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
  				 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
  				 	 				    add(name,type,img,price,num,pushpin,LA);
  				 	 				    map.entities.push(pushpin);	
  				 	 	 		    }	 	            	   
  				 	               }else if(lastZoomLevel>8){		 	            	  
  				 	            	    map.entities.clear();
  				 	            	    var lenArea=itemsArea1.length;
  				 	            	    for(var j=0;j<lenArea;j++){
  				 	            	        var arr2=new Array();
  				 	            	        arr2=itemsArea2[j].gps.split(",");
  				 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
  				 	            	        var area2=itemsArea2[j].project_area;
  				 	            	        var total=String(itemsArea1[j].area);
  				 	            	        //alert(typeof(total))
  				 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
  				 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinArea.png'};
  				 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
  				 	            	        add2(area2,pushpin2,LA2);
  				 	            	       addmouse_out(pushpin2);
  				 	            	        add3(lastZoomLevel,pushpin2,LA2);
  				 	                  	    map.entities.push(pushpin2);
  				 	            	    }
  				 	               }else if(lastZoomLevel>6){
  				 	            	    map.entities.clear();
  				 	            	    var lenCity=itemsCity1.length;
  				 	            	    for(var j=0;j<lenCity;j++){
  				 	            	        var arr2=new Array();
  				 	            	        arr2=itemsCity2[j].gps.split(",");
  				 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
  				 	            	        var city2=itemsCity2[j].project_city;
  				 	            	        var total=String(itemsCity1[j].city);
  				 	            	        //alert(typeof(total))
  				 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
  				 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinCity.png'};
  				 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
  				 	            	        add2(city2,pushpin2,LA2);
  				 	            	       addmouse_out(pushpin2);
  				 	            	        add3(lastZoomLevel,pushpin2,LA2);
  				 	                  	    map.entities.push(pushpin2);
  				 	            	    }
  				 	               }else if(lastZoomLevel>4){
  				 	            	    map.entities.clear();
  				 	            	    var lenZhou=itemsZhou1.length;
  				 	            	    for(var j=0;j<lenZhou;j++){
  				 	            	        var arr2=new Array();
  				 	            	        arr2=itemsZhou2[j].gps.split(",");
  				 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
  				 	            	        var zhou2=itemsZhou2[j].project_zhou;
  				 	            	        var total=String(itemsZhou1[j].zhou);
  				 	            	        //alert(typeof(total))
  				 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
  				 	            	        var pushpinOptions2={text:total,width: 41, height: 41,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinZhou.png'};
  				 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
  				 	            	        add2(zhou2,pushpin2,LA2);
  				 	            	       addmouse_out(pushpin2);
  				 	            	        add3(lastZoomLevel,pushpin2,LA2);
  				 	                  	    map.entities.push(pushpin2);
  				 	            	    }
  				 	               }else{
  				 	            	    map.entities.clear();
  				 	            	    var lenNation=itemsNation1.length;
  				 	            	    for(var j=0;j<lenNation;j++){
  				 	            	        var arr2=new Array();
  				 	            	        arr2=itemsNation2[j].gps.split(",");
  				 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
  				 	            	        var nation2=itemsNation2[j].project_nation;
  				 	            	        var total=String(itemsNation1[j].nation);
  				 	            	        //var shownation=nation2+'\r\n'+total;
  				 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin2.png' style='width:100px;'/></div>"}; */
  				 	            	        var pushpinOptions2={text:total,width: 42, height: 42,textOffset:new Microsoft.Maps.Point(0,15),icon:'/images/pushpinNation.png'};
  				 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
  				 	            	        add2(nation2,pushpin2,LA2);
  				 	            	       addmouse_out(pushpin2);
  				 	            	        add3(lastZoomLevel,pushpin2,LA2);
  				 	                  	    map.entities.push(pushpin2);
  				 	            	    }
  				 	               }
  				 	        	}
  			 	        });
  			 		   
  			 		   
  			 		},
  			 		error:function(){
  			 			//alert("addDefaultPushpin error")
  			 		}
  		        });		 
        }
      
      
      