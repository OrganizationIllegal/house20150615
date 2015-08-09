 var map = null;
 var defaultInfobox;
 var map2=null; 
 
 var LA=null;
 //var defaltCenter=new Microsoft.Maps.Location(-37.847019, 145.064643); 
      /*加载地图*/
      function getIndexMap(){
    	 map = new Microsoft.Maps.Map(document.getElementById('indexMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: true });
     	 map2 = new Microsoft.Maps.Map(document.getElementById('eyeMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL', mapTypeId: Microsoft.Maps.MapTypeId.birdseye,showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false,disableZooming: true });
     	 var url=window.location.href;   	
     	 var name=url.indexOf("=");
     	 var proNum=url.substring(name+1);
     	 //alert(proNum)
     	 $.ajax({
  	 	    type: "POST",
  	 		dateType: "json",
  	 		//url: "/BingMap/FileterProNum"+url, 
  	 		url: "/BingMap/FileterProNum",
  	 		data:{"proNum":proNum},
  	 		success:function(data){
  	 		//alert(data)
  	 		data=$.parseJSON(data);
  	 		    var items=data.List;
  	 		    for(var i=0;i<items.length;i++){
  	 		        var arr=new Array();
  	 		        arr=items[i].gps.split(",");
  	 		        LA=new Microsoft.Maps.Location(arr[0],arr[1]);
  	 		       map.setView({ zoom: 14, center: LA });
  	 	    	   map2.setView({ zoom: 18, center: LA });
  	 	    	var name=items[i].project_name;
  	 	    	var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:-45px;left:-15px;'><div style='color:red;font-size:12px;background-color:white;padding:3px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin2.png' style='width:20px;height:20px;'/></div>"}; 
 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
 		        var pushpin2= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
  	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', popModal); 
  	 		       // Microsoft.Maps.Events.addHandler(pushpin, 'mouseover', getEyeMap); 	
  				    map.entities.push(pushpin);	
  				  map2.entities.push(pushpin2);
  	 		    }
  	 		},
  	 		error:function(){
  	 			alert("addDefaultPushpin error")
  	 		}
          });		
    	 //addDefaultPushpin();	
      }
      function getPopMap(){ 
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AkRLgOcOmMs4A-3UjBRPWc_LmVGmdSTsP2xmGtzaP_1Ixhg6kL2kwoMlQl-qyojL',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: false});
    	  map.setView({ zoom: 14, center: LA });
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
  	 		    lastZoomLevel = map.getZoom();
  	 	        Microsoft.Maps.Events.addHandler(map, 'viewchangeend', function(){
  	 	        	if(lastZoomLevel != map.getZoom()){
  	 	               lastZoomLevel = map.getZoom();
  	 	               //alert(lastZoomLevel);
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
  	 			alert("addDefaultPushpin error")
  	 		}
          });		 
    	  /*$.ajax({
  	 	    type: "GET",
  	 		dateType: "json",
  	 		url: "/BingMap/Coordinates",  	 		
  	 		success:function(data){
  	 		//alert(data)
  	 		data=$.parseJSON(data);
  	 		    var items=data.List;
  	 		    for(var i=0;i<items.length;i++){
  	 		        var arr=new Array();
  	 		        arr=items[i].gps.split(",");
  	 		        var LA2=new Microsoft.Maps.Location(arr[0],arr[1]);
  	 		        var num=items[i].project_num;
  	 		        var image=items[i].project_img;
  	 		        var img="http://101.200.174.253:8080/all/"+image;
  	 		        var name=items[i].project_name;
  	 		        var minprice=items[i].project_min_price;
  	 		        var maxprice=items[i].project_high_price;
  	 		        var price="$"+minprice+"-$"+maxprice;
  	 		     var name=items[i].project_name;
	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:12px;background-color:white;padding:1px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA2, pushpinOptions);
  				    add(name,img,price,num,pushpin,LA2);
  				    map.entities.push(pushpin);	  		        	        
  	 		    }
  	 		},
  	 		error:function(){
  	 			alert("addDefaultPushpin error")
  	 		}
          });		 */
      }     
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

			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:230px;"><a href="/Index?proNum='+num1+'" target="blank"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">起价：$'+price1+'</b><a href="/Index?proNum='+num1+'" target="blank" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">类型:'+type1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:200px;cursor:default;"></div>'); 
			    
		    });
      }
	  /*弹出模态框*/
	  function popModal(){
		  getPopMap();
		  $('#myModal').modal('show');
	  }
	  function display(){
    	  defaultInfobox.setOptions({ visible: false });
      }