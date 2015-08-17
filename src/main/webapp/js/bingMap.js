 var map = null;
 var defaultInfobox;
 var defaltCenter=new Microsoft.Maps.Location( -37.847019, 145.064643);  
      /*加载地图*/
      function getMap()
      {
       //生成地图
       map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
       /*var x=map.getPageX();
       var y=map.getPageY();
       alert('Map x: ' +  x);
       alert('Map y: ' +  y);*/
      /* bounds=map.getBounds(); 
       var zuoshang=bounds.getNorthwest();
       var youxia=bounds.getSoutheast();
       var center=bounds.center;
       var width=bounds.width;
       var height=bounds.height;
*/      /* alert('Map bounds: ' +  bounds);
       alert('Map center: ' +  center);
       alert('Map width: ' +  width);
       alert('Map height: ' +  height);*/
      /* alert('Map zuoshang: ' +  zuoshang);
       alert('Map youxia: ' +  youxia);*/
       $.ajax({
	 	    type: "GET",
	 		dateType: "json",
	 		url: "/BingMap/Coordinates", 		
	 		success:function(data){
	        //alert(data)
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    var items2=data.List2;
	 		    var items3=data.List3;
	 		    var itemsCentermoren=data.ListCentermoren;
	 		    var lenItems=items.length;
	 		    var lenCentermoren=itemsCentermoren.length;
	 		    var a=new Array();
	 		    var Zoom;
	 		    if(lenItems!=0&&lenCentermoren!=0){
	 		    	a=itemsCentermoren[0].gps.split(",");
	    		 	Zoom=5;	 		    	
	 		    }else{
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
	                 /*var zs=new Array();
	                 var yx=new Array();
	                 zs=zuoshang.split(",");
	                 yx=youxia.split(",");
//	                 var zs1=zs[0];
//	                 var zs2=zs[1];
//	                 var yx1=yx[0];
//	                 var yx2=yx[1];
	                 alert('zs: ' +  zs);
	                 alert('zs1: ' +  zs1);
	                 alert('zs2: ' +  zs2);*/
	                  // alert('Map bounds: ' +  bounds);
	                 var zs1=zuoshang.latitude;
	                 var zs2=zuoshang.longitude;
	                 var yx1=youxia.latitude;
                     var yx2=youxia.longitude;
	               /*   alert('Map zuoshang: ' +  zuoshang);
	                 alert('Map youxia: ' +  youxia);*/
	                 $.ajax({
	     		 	    type: "POST",
	     		 		dateType: "json",
	     		 		url: "/BingMap1/filterByGPS",	
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
	 	        	if(lastZoomLevel != map.getZoom()){
	 	               lastZoomLevel = map.getZoom();
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
	 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:-45px;left:-15px;'><div style='color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin2.png' style='width:20px;height:20px;'/></div>"}; 
	 	 	 		        //生成地图小图钉
	 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
	 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
	 	 				    add(type,img,price,num,pushpin,LA);
	 	 				    map.entities.push(pushpin);	
	 	 	 		    }	 	            	   
	 	               }else{
	 	            	    //alert(lastZoomLevel);
	 	            	  
	 	            	    map.entities.clear();
	 	            	    var len=items2.length;
	 	            	    for(var j=0;j<len;j++){
	 	            	        var arr2=new Array();
	 	            	        arr2=items3[j].gps.split(",");
	 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
	 	            	        var city2=items3[j].project_city;
	 	            	        var total=String(items2[j].city);
	 	            	        //alert(typeof(total))
	 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
	 	            	        var pushpinOptions2={text:total,width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
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
      //生成地图消息框
      function add(type,img,price,num,pushpin,LA){
    	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(-15,20)}; 
		        var num1=num;
		        var img1=img;
		        var price1=price;
		        var type1=type;
		        if(defaultInfobox){
		        	defaultInfobox.setOptions({ visible: false });
		        }
			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
			    //alert(defaultInfobox.getId())
			    map.entities.push(defaultInfobox); 
			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:240px;"><a href="/Index?proNum='+num1+'" target="blank"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">起价：$'+price1+'</b><a href="/Index?proNum='+num1+'" target="blank" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">类型：'+type1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:210px;cursor:default;"></div>'); 
			    
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
		 		    var items2=data.List2;
		 		    var items3=data.List3;
		 		    var itemsCentermoren=data.ListCentermoren;
		 		    var lenItems=items.length;
		 		    var lenCentermoren=itemsCentermoren.length;
		 		    var a=new Array();
		 		    var Zoom;
		 		    if(lenItems!=0){
		 		    	a=items[0].gps.split(",");
		 		    	Zoom=11;	 		    	
		 		    }else if(lenCentermoren!=0){
		 		    	a=itemsCentermoren[0].gps.split(",");
		    		 	Zoom=5;
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
		 	        	if(lastZoomLevel != map.getZoom()){
		 	               lastZoomLevel = map.getZoom();
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
		 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:-45px;left:-15px;'><div style='color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin2.png' style='width:20px;height:20px;'/></div>"}; 
		 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
		 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
		 	 				    add(type,img,price,num,pushpin,LA);
		 	 				    map.entities.push(pushpin);	
		 	 	 		    }	 	            	   
		 	               }else{
		 	            	    //alert(lastZoomLevel);
		 	            	    map.entities.clear();
		 	            	    var len=items2.length;
		 	            	    for(var j=0;j<len;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=items3[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var city2=items3[j].project_city;
		 	            	        var total=String(items2[j].city);
		 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
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
	   
	   
	   /* 增加公寓pushpin*/
	   function addPushpinNation(nation, city, area,item)
      {
		 //alert(nation+city+area)
		 map.entities.clear(); 
		 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
		 $.ajax({
		 	    type: "POST",
		 		dateType: "json",
		 		url: "/BingMap/Liandong",	
		 		data:{nation:nation, city:city, area:area},
		 		success:function(data){
		        //alert(data)
		 		data=$.parseJSON(data);
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
		 		    var items2=data.List2;
		 		    var items3=data.List3;
		 		    var itemsCentermoren=data.ListCentermoren;
		 		    var lenItems=items.length;
		 		    var lenCentermoren=itemsCentermoren.length;
		 		    var a=new Array();
		 		    var Zoom;
		 		    if(lenItems!=0){
		 		    	a=items[0].gps.split(",");
		 		    	Zoom=11;	 		    	
		 		    }else if(lenCentermoren!=0){
		 		    	a=itemsCentermoren[0].gps.split(",");
		    		 	Zoom=5;
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
		 	        	if(lastZoomLevel != map.getZoom()){
		 	               lastZoomLevel = map.getZoom();
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
		 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:-45px;left:-15px;'><div style='color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin2.png' style='width:20px;height:20px;'/></div>"}; 
		 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
		 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
		 	 				    add(type,img,price,num,pushpin,LA);
		 	 				    map.entities.push(pushpin);	
		 	 	 		    }	 	            	   
		 	               }else{
		 	            	    //alert(lastZoomLevel);
		 	            	    map.entities.clear();
		 	            	    var len=items2.length;
		 	            	    for(var j=0;j<len;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=items3[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var city2=items3[j].project_city;
		 	            	        var total=String(items2[j].city);
		 	            	       /* var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; */
		 	            	        var pushpinOptions2={text:total,width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
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
	 		    var items2=data.List2;
	 		    var items3=data.List3;
	 		    var itemsCentermoren=data.ListCentermoren;
	 		    var lenItems=items.length;
	 		    var lenCentermoren=itemsCentermoren.length;
	 		    var a=new Array();
	 		    var Zoom;
	 		    if(lenItems!=0){
	 		    	a=items[0].gps.split(",");
	 		    	Zoom=11;	 		    	
	 		    }else if(lenCentermoren!=0){
	 		    	a=itemsCentermoren[0].gps.split(",");
	    		 	Zoom=5;
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
	 	        	if(lastZoomLevel != map.getZoom()){
	 	               lastZoomLevel = map.getZoom();
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
	 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:-45px;left:-15px;'><div style='color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin2.png' style='width:20px;height:20px;'/></div>"}; 
	 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
	 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
	 	 				    add(type,img,price,num,pushpin,LA);
	 	 				    map.entities.push(pushpin);	
	 	 	 		    }	 	            	   
	 	               }else{
	 	            	    //alert(lastZoomLevel);
	 	            	    map.entities.clear();
	 	            	    var len=items2.length;
	 	            	    for(var j=0;j<len;j++){
	 	            	        var arr2=new Array();
	 	            	        arr2=items3[j].gps.split(",");
	 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
	 	            	        var city2=items3[j].project_city;
	 	            	       var total=String(items2[j].city);
	 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"};*/ 
	 	            	        var pushpinOptions2={text:total,width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
	 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
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
			 		    var items2=data.List2;
			 		    var items3=data.List3;
			 		    var itemsCentermoren=data.ListCentermoren;
			 		    var lenItems=items.length;
			 		    var lenCentermoren=itemsCentermoren.length;
			 		    var a=new Array();
			 		    var Zoom;
			 		    if(lenItems!=0){
			 		    	a=items[0].gps.split(",");
			 		    	Zoom=11;	 		    	
			 		    }else if(lenCentermoren!=0){
			 		    	a=itemsCentermoren[0].gps.split(",");
			    		 	Zoom=5;
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
			 	        	if(lastZoomLevel != map.getZoom()){
			 	               lastZoomLevel = map.getZoom();
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
			 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:-45px;left:-15px;'><div style='color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin2.png' style='width:20px;height:20px;'/></div>"}; 
			 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
			 	 	 		        /*var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
			 	 				    add(type,img,price,num,pushpin,LA);
			 	 				    map.entities.push(pushpin);	
			 	 	 		    }	 	            	   
			 	               }else{
			 	            	    //alert(lastZoomLevel);
			 	            	    map.entities.clear();
			 	            	    var len=items2.length;
			 	            	    for(var j=0;j<len;j++){
			 	            	        var arr2=new Array();
			 	            	        arr2=items3[j].gps.split(",");
			 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
			 	            	        var city2=items3[j].project_city;
			 	            	       var total=String(items2[j].city);
			 	            	        /*var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"};*/ 
			 	            	        var pushpinOptions2={text:total,width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
			 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
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
    		 		//url: "/BingMap/FileterKeyWord", 		
    		 		url: "/BingMap/FileterByProjectName", 
    		 		success:function(data){
    		 		data=$.parseJSON(data);
    		 		//alert(data)
    		 		
    		 		var html = getHtml1(data.List);
			 		 $("#left").html(html); 
			 		 
    		 		    var items=data.List;
    		 		    var items2=data.List2;
    		 		    var items3=data.List3;
    		 		    var itemsCentercity=data.ListCentercity;
    		 		    var itemsCenterarea=data.ListCenterarea;
    		 		    var itemsCentermoren=data.ListCentermoren;
    		 		    var lenItems=items.length;
    		 		    var lenCentercity=itemsCentercity.length;
    		 		    var lenCenterarea=itemsCenterarea.length;
    		 		    var lenCentermoren=itemsCentermoren.length;
    		 		    var a=new Array();
    		 		    //alert(typeof(a))
    		 		    alert(items[0].gps)
    		 		    var Zoom;
    		 		    if(lenItems!=0){
    		 		    	for(var k=0;k<lenItems;k++){
    		 		    		a=items[k].gps.split(",");
    		 		    		Zoom=5;
    		 		    	}
    		 		    	/*if(lenCentercity!=0&&lenCenterarea!=0&&lenCentermoren!=0){
        		 		    	if(city.length!=0){
        	    		 		       Zoom=11;
        	    		 		       for(var k1=0;k1<lenCentercity;k1++){
        	    		 		    	   if(city==itemsCentercity[k1].name){
        	    		 		    		   a=itemsCentercity[k1].gps.split(",");
        	    		 		    		   break;
        	    		 		    	   }
        	    		 		       }
        	    		 		       if(a.length==0){
        	  	    		 		    	for(var k2=0;k2<lenItems;k2++){
        	 	    		 		    	   if(city==items[k2].project_city){
        	 	    		 		    		   a=items[k2].gps.split(",");
        	 	    		 		    		   break;
        	 	    		 		    	   }
        	 	    		 		    	  
        	 	    		 		          }
        	  	    		 		       }
        	    		 		    }
        		 		    	 else  if(area.length!=0){
        	    		 		      Zoom=13;
        	    		 		      for(var k3=0;k3<lenCenterarea;k3++){
        	   		 		    	   if(area==itemsCenterarea[k3].name){
        	   		 		    		   a=itemsCenterarea[k3].gps.split(",");
        	   		 		    		   break;
        	   		 		    	   }
        	   		 		          }
        	    		 		     if(a.length==0){
     	  	    		 		    	for(var k4=0;k4<lenItems;k4++){
     	 	    		 		    	   if(area==items[k4].project_area){
     	 	    		 		    		   a=items[k4].gps.split(",");
     	 	    		 		    		  break;
     	 	    		 		    	   }
     	 	    		 		    	 
     	 	    		 		          }
     	  	    		 		       }
        	    		 		    }
        		 		    	else  if(address.length!=0){
        	    		 		       a=items[0].gps.split(",");
        	    		 		       Zoom=17;
        	    		 		    }
        		 		    	else{
        		 		    		a=itemsCentermoren[0].gps.split(",");
        	    		 		    Zoom=5;
        		 		    	}
        		 		    } else if(lenCentermoren!=0){
        		 		    	if(city.length!=0&&lenCentercity!=0){
     	    		 		       Zoom=11;
     	    		 		       for(var k11=0;k11<lenCentercity;k11++){
     	    		 		    	   if(city==itemsCentercity[k11].name){
     	    		 		    		   a=itemsCentercity[k11].gps.split(",");
     	    		 		    		   break;
     	    		 		    	   }
     	    		 		       }
     	    		 		      if(a.length==0){
  	  	    		 		    	for(var k12=0;k12<lenItems;k12++){
  	 	    		 		    	   if(city==items[k12].project_city){
  	 	    		 		    		   a=items[k12].gps.split(",");
  	 	    		 		    		   break;
  	 	    		 		    	   }
  	 	    		 		    	  
  	 	    		 		          }
  	  	    		 		       }
     	    		 		    }
        		 		    	else if(city.length!=0&&lenCentercity==0){
     	    		 		       Zoom=11;
     	    		 		      for(var k13=0;k13<lenItems;k13++){
   	    		 		    	   if(city==items[k13].project_city){
   	    		 		    		   a=items[k13].gps.split(",");
   	    		 		    		 break;
   	    		 		    	   }
   	    		 		    	  
   	    		 		          }
     	    		 		    }
     		 		    	 else  if(area.length!=0&&lenCenterarea!=0){
     	    		 		      Zoom=13;
     	    		 		      for(var k14=0;k14<lenCenterarea;k14++){
     	   		 		    	   if(area==itemsCenterarea[k14].name){
     	   		 		    		   a=itemsCenterarea[k14].gps.split(",");
     	   		 		    		   break;
     	   		 		    	   }
     	   		 		          }
     	    		 		     if(a.length==0){
  	  	    		 		    	for(var k15=0;k15<lenItems;k15++){
  	 	    		 		    	   if(area==items[k15].project_area){
  	 	    		 		    		   a=items[k15].gps.split(",");
  	 	    		 		    		   break;
  	 	    		 		    	   }
  	 	    		 		    	 
  	 	    		 		          }
  	  	    		 		       }
     	    		 		    }
     		 		    	 else  if(area.length!=0&&lenCenterarea==0){
    	    		 		      Zoom=13;
    	    		 		      for(var k16=0;k16<lenItems;k16++){
       	   		 		    	   if(area==items[k16].project_area){
       	   		 		    		   a=items[k16].gps.split(",");
       	   		 		    	       break;
       	   		 		    	   }
       	   		 		           
       	   		 		          }
    	    		 		    }
     		 		    	else  if(address.length!=0){
     	    		 		       a=items[0].gps.split(",");
     	    		 		       Zoom=17;
     	    		 		    }
     		 		    	else{
     		 		    		a=itemsCentermoren[0].gps.split(",");
     	    		 		    Zoom=5;
     		 		    	}
     		 		    }else if(lenCentermoren==0){
     		 		    	if(city.length!=0&&lenCentercity!=0){
  	    		 		       Zoom=11;
  	    		 		       for(var k21=0;k21<lenCentercity;k21++){
  	    		 		    	   if(city==itemsCentercity[k21].name){
  	    		 		    		   a=itemsCentercity[k21].gps.split(",");
  	    		 		    		   break;
  	    		 		    	   }
  	    		 		       }
  	    		 		       if(a.length==0){
  	    		 		    	for(var k22=0;k22<lenItems;k22++){
 	    		 		    	   if(city==items[k22].project_city){
 	    		 		    		   a=items[k22].gps.split(",");
 	    		 		    		  break;
 	    		 		    	   }
 	    		 		    	  
 	    		 		          }
  	    		 		       }
  	    		 		    }
     		 		    	else if(city.length!=0&&lenCentercity==0){
  	    		 		       Zoom=11;
  	    		 		      for(var k23=0;k23<lenItems;k23++){
	    		 		    	   if(city==items[k23].project_city){
	    		 		    		   a=items[k23].gps.split(",");
	    		 		    		  break;
	    		 		    	   }
	    		 		    	  
	    		 		          }
  	    		 		    }
  		 		    	 else if(area.length!=0&&lenCenterarea!=0){
  	    		 		      Zoom=13;
  	    		 		      for(var k24=0;k24<lenCenterarea;k24++){
  	   		 		    	   if(area==itemsCenterarea[k24].name){
  	   		 		    		   a=itemsCenterarea[k24].gps.split(",");
  	   		 		    		   break;
  	   		 		    	   }
  	   		 		          }
  	    		 		      if(a.length==0){
 	    		 		    	for(var k25=0;k25<lenItems;k25++){
	    		 		    	   if(area==items[k25].project_area){
	    		 		    		   a=items[k25].gps.split(",");	
	    		 		    		   break;
	    		 		    	   }
	    		 		    	 
	    		 		          }
 	    		 		       }
  	    		 		    }
  		 		    	 else  if(area.length!=0&&lenCenterarea==0){
 	    		 		      Zoom=13;
 	    		 		      for(var k26=0;k26<lenItems;k26++){
    	   		 		    	   if(area==items[k26].project_area){
    	   		 		    		   a=items[k26].gps.split(",");
    	   		 		    		   break; 
    	   		 		    	   }
    	   		 		    	
    	   		 		          }
 	    		 		    }
  		 		    	else  if(address.length!=0){
  	    		 		       a=items[0].gps.split(",");
  	    		 		       Zoom=17;
  	    		 		    }
  		 		    	else{
  		 		    		a[0]="-25.585241";
     		 		        a[1]="134.504120";
  	    		 		    Zoom=5;
  		 		    	}
     		 		    }*/		 		    	
    		 		    }else{
    		 		    	a[0]="-25.585241";
     		 		        a[1]="134.504120";
     		 		        Zoom=5;
    		 		    }  		 		    
    		 		    
    		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
    		 		    map.setView({ zoom: Zoom, center: Center });	
    		 		    lastZoomLevel = map.getZoom();
    		 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
    		 	        	if(lastZoomLevel != map.getZoom()){
    		 	               lastZoomLevel = map.getZoom();
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
    		 	 	 		        var minprice=items[i].project_min_price;
    		 	 	 		        var maxprice=items[i].project_high_price;
    		 	 	 		        var city=items[i].project_city;
    		 	 	 		        //var price=items[i].project_price_int_qi;
    		 	 	 		     var price=items[i].project_min_price;
    		 	 	 		        var type=items[i].project_type;
    		 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:-45px;left:-15px;'><div style='color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin2.png' style='width:20px;height:20px;'/></div>"}; 
    		 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
    		 	 	 		       // var pushpin= new Microsoft.Maps.Pushpin(LA,null);
    		 	 	 		        add(type,img,price,num,pushpin,LA);
    		 	 				    map.entities.push(pushpin);		
    		 	 	 		    }	 	            	   
    		 	               }else{
    		 	            	    //alert(lastZoomLevel);
    		 	            	    map.entities.clear();
    		 	            	    var len=items2.length;
    		 	            	    for(var j=0;j<len;j++){
    		 	            	        var arr2=new Array();
    		 	            	        arr2=items3[j].gps.split(",");
    		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
    		 	            	        var city2=items3[j].project_city;
    		 	            	       var total=String(items2[j].city);
    		 	            	        var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; 
    		 	            	        var pushpinOptions2={text:total,width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
    		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
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
        /* var key=$("#keyWord").val();
         //alert("key")
		 map.entities.clear(); 
		 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
		 $.ajax({
		 	    type: "GET",
		 		dateType: "json",
		 		url: "/BingMap/FileterKeyWord?keyword="+key, 		
		 		success:function(data){
		        //alert(data)
		 		data=$.parseJSON(data);
		 		
		 		    var items=data.List;
		 		    var items2=data.List2;
		 		    var items3=data.List3;
		 		    var a=new Array();
		 		    a=items[0].gps.split(",");
		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
		 		    map.setView({ zoom: 11, center: Center });	
		 		    lastZoomLevel = map.getZoom();
		 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
		 	        	if(lastZoomLevel != map.getZoom()){
		 	               lastZoomLevel = map.getZoom();
		 	               if(lastZoomLevel>9){
		 	            	  map.entities.clear();
		 	            	  for(var i=0;i<items.length;i++){
		 	 	 		        var arr=new Array();
		 	 	 		        arr=items[i].gps.split(",");
		 	 	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
		 	 	 		        var num=items[i].project_num;
		 	 	 		        var name=items[i].project_name;
		 	 	 		        var image=items[i].project_img;
		 	 	 		        var img=imgdir+"/"+image;	 		        
		 	 	 		        var minprice=items[i].project_min_price;
		 	 	 		        var maxprice=items[i].project_high_price;
		 	 	 		        var city=items[i].project_city;
		 	 	 		        var price="$"+minprice+"-$"+maxprice;
		 	 	 		        var name=items[i].project_name;
		 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:-45px;left:-15px;'><div style='color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin2.png' style='width:20px;height:20px;'/></div>"};  
		 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
		 	 				    add(name,img,price,num,pushpin,LA);
		 	 				    map.entities.push(pushpin);	
		 	 	 		    }	 	            	   
		 	               }else{
		 	            	    //alert(lastZoomLevel);
		 	            	    map.entities.clear();
		 	            	    var len=items2.length;
		 	            	    for(var j=0;j<len;j++){
		 	            	        var arr2=new Array();
		 	            	        arr2=items3[j].gps.split(",");
		 	            	        var LA2=new Microsoft.Maps.Location(arr2[0],arr2[1]); 
		 	            	        var city2=items3[j].project_city;
		 	            	       var total=String(items2[j].city);
		 	            	        var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; 
		 	            	        var pushpinOptions2={text:total,width: 30, height: 30,textOffset:new Microsoft.Maps.Point(0,8),icon:'/images/pushpin2.png'};
		 	            	        var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
		 	                  	    map.entities.push(pushpin2);
		 	            	    }
		 	               }
		 	        	}
		 	        });
		 		   
		 		   
		 		},
		 		error:function(){
		 			alert("addDefaultPushpin error")
		 		}
	        });	*/	 
		 /*$.ajax({
	  	 	    type: "POST",
	  	 		dateType: "json",
	  	 		url: "/BingMap/FileterKeyWord?keyword="+key, 	
	  	 		success:function(data){
	  	 		//alert(data)
	  	 		data=$.parseJSON(data);
	  	 		    var items=data.List;
	  	 		    if(items.length>0){ 
	  	 		    	var a=new Array();
	  		 		    a=items[0].gps.split(",");
	  		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
	  		 		    map.setView({ zoom: 11, center: Center });	
	  	 		    for(var i=0;i<items.length;i++){
	  	 		        var arr=new Array();
	  	 		        arr=items[i].gps.split(",");
	  	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]); 
	  	 		        var num=items[i].project_num;
	  	 		        var name=items[i].project_name;
	  	 		        var image=items[i].project_img;
	  	 		        var img="http://101.200.174.253:8080/all/"+image;	 		        
	  	 		        var minprice=items[i].project_min_price;
	  	 		        var maxprice=items[i].project_high_price;
	  	 		        var price="$"+minprice+"-$"+maxprice;
	  	 		     var name=items[i].project_name;
		 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:5px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"};  
		 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
	  	 		     addSearch(name,img,price,num,pushpin,LA);	
	  				    map.entities.push(pushpin);	  		        	        
	  	 		    }
	  	 		    }else{
	  	 		    map.entities.clear();
	  	 		    }
	  	 		},
	  	 		error:function(){
	  	 			alert("addDefaultPushpin error")
	  	 		}
	          });	*/	 
      }
         /*function addSearch(type,img,price,num,pushpin,LA){
       	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
   		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(-15,20)}; 
   		        var num1=num;
   		        var img1=img;
   		        var price1=price;
   		        var type1=type;
   		        if(defaultInfobox){
   		        	defaultInfobox.setOptions({ visible: false });
   		        }
   			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
   			    //alert(defaultInfobox.getId())
   			    map.entities.push(defaultInfobox); 
   			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:230px;"><a href="/Index?proNum='+num1+'" target="blank"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">起价：$'+price1+'</b><a href="/Index?proNum='+num1+'" target="blank" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">类型：'+type1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:200px;cursor:default;"></div>'); 
   			    
   		    });
         }*/
      /* 弹出搜索map*/
      /* function getPopMapsearch(){
    	  var key=$("#keyWord").val();
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false});
    	  $.ajax({
  	 	    type: "POST",
  	 		dateType: "json",
  	 		url: "/BingMap/FileterKeyWord?keyword="+key, 	
  	 		success:function(data){
  	 		data=$.parseJSON(data);
  	 		    var items=data.List;
  	 		    if(items.length>0){ 
  	 		    	var a=new Array();
  		 		    a=items[0].gps.split(",");
  		 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
  		 		    map.setView({ zoom: 11, center: Center });	
  	 		    for(var i=0;i<items.length;i++){
  	 		        var arr=new Array();
  	 		        arr=items[i].gps.split(",");
  	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]); 
  	 		        var num=items[i].project_num;
  	 		        var name=items[i].project_name;
  	 		        var image=items[i].project_img;
  	 		        var img="http://101.200.174.253:8080/all/"+image;	 		        
  	 		        var minprice=items[i].project_min_price;
  	 		        var maxprice=items[i].project_high_price;
  	 		        var price="$"+minprice+"-$"+maxprice;
  	 		     var name=items[i].project_name;
	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:5px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"};  
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
  	 		     addSearch(name,img,price,num,pushpin,LA);	
  				    map.entities.push(pushpin);	  		        	        
  	 		    }
  	 		    }else{
  	 		    map.entities.clear();
  	 		    }
  	 		},
  	 		error:function(){
  	 			alert("addDefaultPushpin error")
  	 		}
          });		 
      }
      
       function popModalsearch(){
		  getPopMapsearch();
		  $('#myModal').modal('show');
	  }*/
      
      
      