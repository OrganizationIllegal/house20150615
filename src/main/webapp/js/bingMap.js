 var map = null;
 var defaultInfobox;
 var defaltCenter=new Microsoft.Maps.Location( -37.847019, 145.064643);        
      /*加载地图*/
      function getMap()
      {
       map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
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
	 		    var a=new Array();
	 		    a=items[0].gps.split(",");
	 		    var Center=new Microsoft.Maps.Location(a[0],a[1]);
	 		    map.setView({ zoom: 11, center: Center });	
	 		    lastZoomLevel = map.getZoom();
	 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
	 	        	if(lastZoomLevel != map.getZoom()){
	 	               lastZoomLevel = map.getZoom();
	 	               if(lastZoomLevel>5){
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
	 	 	 		        var zhou=items[i].project_zhou;
	 	 	 		        var price="$"+minprice+"-$"+maxprice;
	 	 	 		        var name=items[i].project_name;
	 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
	 	 	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
	 	 	 		       /* var pushpin= new Microsoft.Maps.Pushpin(LA,null);*/
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
	 	            	        var zhou2=items3[j].project_zhou;
	 	            	        var total=String(items2[j].zhou);
	 	            	        //alert(typeof(total))
	 	            	        var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; 
	 	                  	    var pushpin2= new Microsoft.Maps.Pushpin(LA2, pushpinOptions2);
	 	            	        /*var pushpin2= new Microsoft.Maps.Pushpin(LA2, {text:total});*/
	 	                  	    map.entities.push(pushpin2);
	 	            	    }
	 	               }
	 	        	}
	 	        });
	 		   
	 		   
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
      function add(name,img,price,num,pushpin,LA){
    	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,-30)}; 
		        var num1=num;
		        var img1=img;
		        var price1=price;
		        var name1=name;
		        if(defaultInfobox){
		        	defaultInfobox.setOptions({ visible: false });
		        }
			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
			    //alert(defaultInfobox.getId())
			    map.entities.push(defaultInfobox); 
			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:330px;"><a href="/Index?proNum='+num1+'"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目价格：'+price1+'</b><a href="/Index?proNum='+num1+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目名称:'+name1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:300px;cursor:default;"></div>'); 
			    
		    });
      }
      function display(){
    	  defaultInfobox.setOptions({ visible: false });
      }
	   /* 增加一居室pushpin*/
	   function addPushpin1()
      {
		 //alert("yijushi")
		 map.entities.clear(); 
		 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
		 $.ajax({
		 	    type: "GET",
		 		dateType: "json",
		 		url: "/BingMap/FileterType2?house_type=1",		
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
		 	               if(lastZoomLevel>6){
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
		 	 	 		        var zhou=items[i].project_zhou;
		 	 	 		        var price="$"+minprice+"-$"+maxprice;
		 	 	 		        var name=items[i].project_name;
		 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
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
		 	            	        var zhou2=items3[j].project_zhou;
		 	            	        var total=items2[j].zhou;
		 	            	        var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; 
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
	        });		 
      }
      function add1(name,img,price,num,pushpin,LA){
    	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,-30), }; 
		        var num1=num;
		        var img1=img;
		        var price1=price;
		        var name1=name;
		        if(defaultInfobox){
		        	defaultInfobox.setOptions({ visible: false });
		        }
			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
			    //alert(defaultInfobox.getId())
			    map.entities.push(defaultInfobox); 
			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:330px;"><a href="/Index?proNum='+num1+'"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目价格：'+price1+'</b><a href="/Index?proNum='+num1+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目名称:'+name1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:300px;cursor:default;"></div>'); 
			    
		    });
      }
       /* 增加二居室pushpin*/
	   function addPushpin2()
      {
	    //alert("erjushi")
		map.entities.clear(); 
	    map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
	    $.ajax({
	 	    type: "GET",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=2",		
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
	 	               if(lastZoomLevel>6){
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
	 	 	 		        var zhou=items[i].project_zhou;
	 	 	 		        var price="$"+minprice+"-$"+maxprice;
	 	 	 		        var name=items[i].project_name;
	 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
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
	 	            	        var zhou2=items3[j].project_zhou;
	 	            	        var total=items2[j].zhou;
	 	            	        var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; 
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
        });		 
      }
       function add2(name,img,price,num,pushpin,LA){
     	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
 		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,-30), }; 
 		        var num1=num;
 		        var img1=img;
 		        var price1=price;
 		        var name1=name;
 		        if(defaultInfobox){
 		        	defaultInfobox.setOptions({ visible: false });
 		        }
 			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
 			    //alert(defaultInfobox.getId())
 			    map.entities.push(defaultInfobox); 
 			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:330px;"><a href="/Index?proNum='+num1+'"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目价格：'+price1+'</b><a href="/Index?proNum='+num1+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目名称:'+name1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:300px;cursor:default;"></div>'); 
 			    
 		    });
       } 
      /* 增加三居室pushpin*/
	   function addPushpin3()
      {
		     //alert("sanjushi")
			 map.entities.clear(); 
			 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
			 $.ajax({
			 	    type: "GET",
			 		dateType: "json",
			 		url: "/BingMap/FileterType2?house_type=3",		
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
			 	               if(lastZoomLevel>6){
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
			 	 	 		        var zhou=items[i].project_zhou;
			 	 	 		        var price="$"+minprice+"-$"+maxprice;
			 	 	 		        var name=items[i].project_name;
			 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
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
			 	            	        var zhou2=items3[j].project_zhou;
			 	            	        var total=items2[j].zhou;
			 	            	        var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; 
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
		        });		 
      }
       function add3(name,img,price,num,pushpin,LA){
      	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
  		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,-30), }; 
  		        var num1=num;
  		        var img1=img;
  		        var price1=price;
  		        var name1=name;
  		        if(defaultInfobox){
  		        	defaultInfobox.setOptions({ visible: false });
  		        }
  			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
  			    //alert(defaultInfobox.getId())
  			    map.entities.push(defaultInfobox); 
  			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:330px;"><a href="/Index?proNum='+num1+'"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目价格：'+price1+'</b><a href="/Index?proNum='+num1+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目名称:'+name1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:300px;cursor:default;"></div>'); 
  			    
  		    });
        } 
       /* 增加四居室pushpin*/
	   function addPushpin4()
      {
		     //alert("sijushi")
			 map.entities.clear(); 
			 map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false });
			 $.ajax({
			 	    type: "GET",
			 		dateType: "json",
			 		url: "/BingMap/FileterType2?house_type=4",		
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
			 	               if(lastZoomLevel>6){
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
			 	 	 		        var zhou=items[i].project_zhou;
			 	 	 		        var price="$"+minprice+"-$"+maxprice;
			 	 	 		        var name=items[i].project_name;
			 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
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
			 	            	        var zhou2=items3[j].project_zhou;
			 	            	        var total=items2[j].zhou;
			 	            	        var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; 
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
		        });		 
      }
       function add4(name,img,price,num,pushpin,LA){
      	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
  		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,-30), }; 
  		        var num1=num;
  		        var img1=img;
  		        var price1=price;
  		        var name1=name;
  		        if(defaultInfobox){
  		        	defaultInfobox.setOptions({ visible: false });
  		        }
  			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
  			    //alert(defaultInfobox.getId())
  			    map.entities.push(defaultInfobox); 
  			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:330px;"><a href="/Index?proNum='+num1+'"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目价格：'+price1+'</b><a href="/Index?proNum='+num1+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目名称:'+name1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:300px;cursor:default;"></div>'); 
  			    
  		    });
        } 
       /* 增加搜索pushpin*/
         function addPushpinsearch()
      {
         var key=$("#keyWord").val();
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
		 	               if(lastZoomLevel>6){
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
		 	 	 		        var zhou=items[i].project_zhou;
		 	 	 		        var price="$"+minprice+"-$"+maxprice;
		 	 	 		        var name=items[i].project_name;
		 	 	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
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
		 	            	        var zhou2=items3[j].project_zhou;
		 	            	        var total=items2[j].zhou;
		 	            	        var pushpinOptions2 = {width:null, height:null,htmlContent: "<div style='width:100px;height:100px;text-align:center;'><div style='width:40px;height:40px;position:relative;top:65px;left:30px;font-size:15px;color:black;font-weight:bold;'>"+total+"</div><img src='/images/pushpin.png' style='width:100px;'/></div>"}; 
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
	        });		 
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
      function addSearch(name,img,price,num,pushpin,LA){
      	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
  		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,-30), }; 
  		        var num1=num;
  		        var img1=img;
  		        var price1=price;
  		        var name1=name;
  		        if(defaultInfobox){
  		        	defaultInfobox.setOptions({ visible: false });
  		        }
  			    defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions);
  			    //alert(defaultInfobox.getId())
  			    map.entities.push(defaultInfobox); 
  			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:330px;"><a href="/Index?proNum='+num1+'"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目价格：'+price1+'</b><a href="/Index?proNum='+num1+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目名称:'+name1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:300px;cursor:default;"></div>'); 
  			    
  		    });
        } 
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