    	$(function(){
    		var myChart = echarts.init(document.getElementById('price_line')); 
	        
	        var option = {
//	        	title:{
//	        		text:"���¸���ʱ��:2015-04-25",
//	        		x:"right"
//	        		
//	        	},
			    tooltip : {
			        trigger: 'axis',
			        formatter:'{b}<br/>房价:${c}'
			    },
			    legend: {
			        data:['����'],
			        show:false

			    },
			    
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['January','February','March','April','May','June','July']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'����',
			            type:'line',
			            stack: '�۸�',
			            data:[120, 12, 101, 104, 190, 230, 210]
			        }
			    ]
			};
                    
                    
	        option.xAxis[0].data=eval(trend_areamiddle_year);
	        option.series[0].data=eval(trend_areamiddle_rate);
	        // Ϊecharts����������� 
	        myChart.setOption(option); 



    	});

$('#trendTabs a').click(function (e) {
      e.preventDefault()

      $(this).tab('show');

      var myChart1 = echarts.init(document.getElementById('rent_line')); 
	        
	        var option1 = {
//	        	title:{
//	        		text:"���¸���ʱ��:2015-04-26",
//	        		x:"right"
//	        		
//	        	},
			    tooltip : {
			        trigger: 'axis',
			        formatter:'{b}<br/>租金:${c}'
			    },
			    legend: {
			        data:['���'],
			        show:false

			    },
			    
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['January','February','March','April','May','June','July']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'���',
			            type:'line',
			            stack: '�۸�',
			            data:[120, 132, 101, 134, 90, 230, 210]
			        }
			    ]
			};
            option1.xAxis[0].data=eval(areaZujinYeatList);
	        option1.series[0].data=eval(areaZujinRateList);
	        // Ϊecharts����������� 
	        myChart1.setOption(option1);

	        var myChart2 = echarts.init(document.getElementById('emptypercent_line')); 
	        var option2 = {
//	        	title:{
//	        		text:"���¸���ʱ��:2015-04-27",
//	        		x:"right"
//	        		
//	        	},
			    tooltip : {
			        trigger: 'axis',
			        formatter:'{b}<br/>回报率:{c}%'
			    },
			    legend: {
			        data:['������'],
			        show:false

			    },
			    
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['January','February','March','April','May','June','July']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            precision: 3,
			            splitNumber: 9,
			            boundaryGap: [0.001, 0.009], 
		                splitArea: { show: true } 
			        }
			    ],
			    series : [
			        {
			            name:'������',
			            type:'line',
			            stack: '�ٷֱ�',
			            data:[10, 32, 101, 134, 90, 30, 210]
			        }
			    ]
			};
            option2.xAxis[0].data=eval(areaZhikongYeatList);
	        option2.series[0].data=eval(areaZhikongRateList);
	        // Ϊecharts����������� 
	        myChart2.setOption(option2);
    });
    