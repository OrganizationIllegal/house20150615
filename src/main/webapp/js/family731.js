

$(function(){
    		var arc1 = echarts.init(document.getElementById('zonefamily_pie1')); 
    		var arc2 = echarts.init(document.getElementById('zonefamily_pie2'));
    		var arc3 = echarts.init(document.getElementById('zonefamily_pie3'));
    		var dataStyle1 = {
    			    normal: {
    			    	color:'rgba(35,153,186,1)',
    			        label: {show:false},
    			        labelLine: {show:false}
    			    }
    			};
    		var dataStyle2 = {
    			    normal: {
    			    	color:'rgba(124,165,99,1)',
    			        label: {show:false},
    			        labelLine: {show:false}
    			    }
    			};
    		var dataStyle3 = {
    			    normal: {
    			    	color:'rgba(217,130,37,1)',
    			        label: {show:false},
    			        labelLine: {show:false}
    			    }
    			};
    			var placeHolderStyle = {
    			    normal : {
    			        color: 'rgba(0,0,0,0)',
    			        label: {show:false},
    			        labelLine: {show:false}
    			    },
    			    emphasis : {
    			        color: 'rgba(0,0,0,0)'
    			    }
    			};
    			option = {
    			    series : [
    			        {
    			            name:'1',
    			            type:'pie',
    			          	startAngle:0,
    			            clockWise:false,
    			            radius : [78, 98],
    			            center:['43.5%', '59%'],
    			            itemStyle : dataStyle1,
    			            data:[
    			                {
    			                    value:10
    			                },
    			                {
    			                    value:90,
    			                    name:'invisible',
    			                    itemStyle : placeHolderStyle
    			                }
    			            ]
    			        }
    			    ]
    			};
    			option.series[0].data[0].value=parseFloat(family.num1);
    			option.series[0].data[1].value=parseFloat(100-parseFloat(family.num1));
    			option.series[0].radius=[76,96];
    			option.series[0].center=['42.7%', '59%'];
    			option.series[0].itemStyle=dataStyle1;
    			option.series[0].startAngle=-45;
    			arc1.setOption(option); 
    			option.series[0].data[0].value=parseFloat(parseFloat(family.num2).toFixed(2));
    			option.series[0].data[1].value=parseFloat(100-parseFloat(family.num2)).toFixed(2);
    			option.series[0].radius=[76,96];
    			option.series[0].center=['43.8%', '59%'];
    			option.series[0].itemStyle=dataStyle2;
    			option.series[0].startAngle=25;
    			arc2.setOption(option); 
    			option.series[0].data[0].value=parseFloat(parseFloat(family.num3).toFixed(2));
    			option.series[0].data[1].value=parseFloat(100-parseFloat(family.num3)).toFixed(2);
    			option.series[0].radius=[76,96];
    			option.series[0].center=['43%', '59%'];
    			option.series[0].itemStyle=dataStyle3;
    			option.series[0].startAngle=-45;
    			arc3.setOption(option); 
    			                    
    	});