

$(function(){
    		var myChart = echarts.init(document.getElementById('zonefamily_pie')); 
	        
	        var labelTop = {
				    normal : {
				    	color:'#CDCD00',
				        label : {
				            show : false,
				            position : 'center',
				            formatter : '{b}',
				            textStyle: {
				                baseline : 'bottom'
				            }
				        },
				        labelLine : {
				            show : false
				        }
				    }
				};
				var labelFromatter = {
				    normal : {
				    	color:'#bfbfbf',
				        label : {
				            formatter : function (params){
				                return 100 - params.value + '%'
				            },
				            textStyle: {
				                baseline : 'top'
				            }
				        }
				    },
				};
				var labelBottom = {
				    normal : {
				        color: '#ccc',
				        label : {
				            show : false,
				            position : 'center'
				        },
				        labelLine : {
				            show : false
				        }
				    },
				    emphasis: {
				        color: 'rgba(0,0,0,0)'
				    }
				};
				var radius = [70, 90];
				option = {
				    series : [
				        {
				            type : 'pie',
				            center : ['16.5%', '52.2%'],
				            radius : radius,
				            x: '0%', // for funnel
				            itemStyle : labelFromatter,
				            data : [
				                {name:'other', value:46, itemStyle : labelBottom},
				                {name:'��������', value:54,itemStyle : labelTop}
				            ]
				        },
				        {
				            type : 'pie',
				            center : ['49.9%', '52.2%'],
				            radius : radius,
				            x:'20%', // for funnel
				            itemStyle : labelFromatter,
				            data : [
				                {name:'other', value:56, itemStyle : labelBottom},
				                {name:'�����ͥ', value:44,itemStyle : labelTop}
				            ]
				        },
				        {
				            type : 'pie',
				            center : ['83.3%', '52.2%'],
				            radius : radius,
				            x:'40%', // for funnel
				            itemStyle : labelFromatter,
				            data : [
				                {name:'other', value:65, itemStyle : labelBottom},
				                {name:'�����ͥ', value:35,itemStyle : labelTop}
				            ]
				        }
				        
				    ]
				};
        option.series[0].data[1].value=parseFloat(family.num1);
		option.series[0].data[0].value=parseFloat(100-parseFloat(family.num1));
		option.series[1].data[1].value=parseFloat(parseFloat(family.num2).toFixed(2));
		option.series[1].data[0].value=parseFloat(100-parseFloat(family.num2)).toFixed(2);
		option.series[2].data[1].value=parseFloat(parseFloat(family.num3).toFixed(2));
		option.series[2].data[0].value=parseFloat(100-parseFloat(family.num3)).toFixed(2);
		
	        // Ϊecharts���������� 
	        myChart.setOption(option); 



    	});