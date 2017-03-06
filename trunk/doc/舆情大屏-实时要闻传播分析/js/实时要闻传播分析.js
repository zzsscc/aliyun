
    //情感值

        var emotionIndexChart = echarts.init(document.getElementById('emotion-index-chart'));

        var emotionIndexChartOption = {
            tooltip : {
                formatter: "{a} <br/>{b} : {c}%"
            },
            series: [
                {
                    name: '情绪指数',
                    type: 'gauge',
                    min: -100,
                    max: 100,
                    startAngle:220,
                    endAngle:-40,
                    splitNumber:4,
                    center:	['50%', '60%'],
                    radius:90,
                    axisLine: {            // 坐标轴线
                        lineStyle: {       // 属性lineStyle控制线条样式
                            width: 0,
//                    百分之25之前是红色  百分之25之后到百分之75之前是黄色  百分之75之后到百分之100之前是黄色
                            color: [[0.25, '#50edb3'], [0.5,'#89b9f5'],[0.89, '#ea8cdb'], [1, '#393a5a']]
                        }
                    },
                    axisTick: {            // 坐标轴小标记
                        length:10,        // 属性length控制线长
                        splitNumber:10,
                        inside:false,
                        lineStyle: {       // 属性lineStyle控制线条样式
                            color:'auto',
                            width:2,
//                    color:'red'
//                    color: [[0.09, 'red'],[0.82, 'yellow'],[1, 'blue']]
                        }
                    },
                    splitLine: {           // 主分隔线
                        length:10,         // 属性length控制线长
                        lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                            color:'auto',
                        }
                    },
                    axisLabel:{             //坐标轴文本 数值
                        textStyle:{
                            color:'#6ad0c5'
                        },
                    },
//                指针宽度
                    pointer: {
                        width:0,
                        length: '90%',
                        color:'#6ad0c5'
                    },

//            标题 正能量
                    title:{
                        show:true,
                        textStyle:{
                            color:'#6ad0c5',
                            fontSize:16
                        },
                        offsetCenter: [0, '-10%'],

                    },
                    detail: {
                        textStyle: {
                            color:'#6ad0c5',
                            fontSize:20
                        },
                        offsetCenter: [0, '20%'],
                        //加上百分比
                       // formatter:'{value}%'
                    },
                    data: [{
                        value: 78,
                        name: '用户情绪指数'
                    }]
                }
            ]

        };





    //右边条形图
    //var topHot=document.getElementsByClassName('right-top-center')[0];
    //var tophotArr=[15.1,43.1,21.1,20.6];
    //var tophotNum=topHot.getElementsByClassName('hot-num');
    //var tophotStrip=topHot.getElementsByClassName('hot-strip');
    //
    //var topsunHotArr=eval(tophotArr.join('+'));
    //
    //for(var i=0;i<tophotNum.length;i++){
    //    tophotNum[i].innerHTML=tophotArr[i]+'%';
    //    tophotStrip[i].style.width=(tophotArr[i]/topsunHotArr)*90+"px"
    //}
    //
    //
    //
    //var middleHot=document.getElementsByClassName('right-middle-center')[0];
    //var middlehotArr=[60,40];
    //var middlehotNum=middleHot.getElementsByClassName('hot-num');
    //var middlehotStrip=middleHot.getElementsByClassName('hot-strip');
    //
    //var middlesunHotArr=eval(middlehotArr.join('+'));
    //
    //for(var i=0;i<middlehotNum.length;i++){
    //    middlehotNum[i].innerHTML=middlehotArr[i]+'%';
    //    middlehotStrip[i].style.width=(middlehotArr[i]/middlesunHotArr)*90+"px"
    //}
    //
    //
    //
    //var bottomHot=document.getElementsByClassName('right-bottom-center')[0];
    //var bottomhotArr=[88.5,11.5];
    //var bottomhotNum=bottomHot.getElementsByClassName('hot-num');
    //var bottomhotStrip=bottomHot.getElementsByClassName('hot-strip');
    //
    //var bottomsunHotArr=eval(bottomhotArr.join('+'));
    //
    //for(var i=0;i<bottomhotNum.length;i++){
    //    bottomhotNum[i].innerHTML=bottomhotArr[i]+'%';
    //    bottomhotStrip[i].style.width=(bottomhotArr[i]/bottomsunHotArr)*90+"px"
    //}



    //72小时折线图

        var chart72h = echarts.init(document.getElementById('chart72h'));

        var chart72hOption = {
            tooltip: {
                trigger: 'axis'
            },
            calculable: true,
            grid: {
                x: 60,
                y: 60,
                x2: 30,
                y2: 50,
                borderColor: '#e5e5e5'
            },
            color: ['#6ad0c5'],
            xAxis: [
                {
                    type: 'category',
                    boundaryGap: false,
                    data: [],
                    axisTick: {
                        show: false,
                    },
                    axisLabel: {
                        textStyle: {
                            fontSize: 12,     //刻度大小
                            color: "#6ad0c5",
                        },
                        margin: 20,
                    },
                    axisLine: {
                        lineStyle: {
                            color: "#093f50",
                            width: 2,
                        }
                    },
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: ['#17172a'],
                        }
                    },
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    name: '转发量',
                    nameTextStyle: {
                        fontSize: 12,
                        color: '#6ad0c5',
                    },
                    axisTick: {
                        show: false,
                    },
                    axisLabel: {
                        textStyle: {
                            fontSize: 12,     //刻度大小
                            color: "#6ad0c5",
                        },
                        margin: 20,
                    },
                    axisLine: {
                        lineStyle: {
                            color: "#093f50",
                            width: 2,
                        }
                    },
                    splitLine: {
                        lineStyle: {
                            color: ['#17172a'],
                        }
                    },
                }
            ],
            series: [
                {
                    name: '次数',
                    type: 'line',
                    smooth: true,
                    symbolSize: 2,
                    symbol: 'circle',
                    itemStyle: {
                        normal: {
                            areaStyle: {
                                type: 'default',
                                color: 'rgba(106,208,197,0.3)',    //填充色
                            }
                        }
                    },
                    data: []
                }
            ]
        }






    //用户特征饼图
    //1

        var rightTopChart = echarts.init(document.getElementById('right-top-chart'));

        var rightTopChartOption = {
            title: {
                text: '用户类型',
                x: 'center',
                y: 'center',
                textStyle : {
                    color : '#6ad0c5',
                    fontSize : 16,
                }
            },
            calculable: true,
            color: ['#8f572f', '#319647', '#304494', '#723a93'],
            series: [
                {
                    name: '用户类型',
                    type: 'pie',
                    radius: ['90%', '80%'],
                    center: ['50%', '50%'],
                    itemStyle : {
                        normal : {
                            label : {
                                show : false
                            },
                            labelLine : {
                                show : false
                            }
                        },
                        emphasis : {
                            label : {
                                show : false
                            },
                            labelLine : {
                                show : false
                            }
                        }
                    },
                    data: [
                        {value: 206, name: '普通用户'},
                        {value: 211, name: '微博达人'},
                        {value: 431, name: '企业认证'},
                        {value: 151, name: '个人认证'},
                    ]
                }
            ]
        }

        rightTopChart.setOption(rightTopChartOption);


    //2

        var rightMiddleChart = echarts.init(document.getElementById('right-middle-chart'));

        var rightMiddleChartOption = {
            title: {
                text: '男女比例',
                x: 'center',
                y: 'center',
                textStyle : {
                    color : '#6ad0c5',
                    fontSize : 16,
                }
            },
            calculable: true,
            color: ['#8f572f', '#304494'],
            series: [
                {
                    name: '男女比例',
                    type: 'pie',
                    radius: ['90%', '80%'],
                    center: ['50%', '50%'],
                    itemStyle : {
                        normal : {
                            label : {
                                show : false
                            },
                            labelLine : {
                                show : false
                            }
                        },
                        emphasis : {
                            label : {
                                show : false
                            },
                            labelLine : {
                                show : false
                            }
                        }
                    },
                    data: [
                        {value: 400, name: '女'},
                        {value: 600, name: '男'},
                    ]
                }
            ]
        }

        rightMiddleChart.setOption(rightMiddleChartOption);



    //3

        var rightBottomChart = echarts.init(document.getElementById('right-bottom-chart'));

        var rightBottomChartOption = {
            title: {
                text: '水军比例',
                x: 'center',
                y: 'center',
                textStyle : {
                    color : '#6ad0c5',
                    fontSize : 16,
                }
            },
            calculable: true,
            color: ['#319647', '#723a93'],
            series: [
                {
                    name: '水军比例',
                    type: 'pie',
                    radius: ['90%', '80%'],
                    center: ['50%', '50%'],
                    itemStyle : {
                        normal : {
                            label : {
                                show : false
                            },
                            labelLine : {
                                show : false
                            }
                        },
                        emphasis : {
                            label : {
                                show : false
                            },
                            labelLine : {
                                show : false
                            }
                        }
                    },
                    data: [
                        {value: 115, name: '水军'},
                        {value: 885, name: '普通用户'},
                    ]
                }
            ]
        }

        rightBottomChart.setOption(rightBottomChartOption);



    //地图

        var MapChart = echarts.init(document.getElementById('map-chart'));

        var visitorsTrackPoption = {
//    背景色
//            backgroundColor: '#0e1221',
//            tooltip : {
//                trigger: 'item'
//            },
//            legend: {
//                orient: 'vertical',
//                top: 'bottom',
//                left: 'right',
//                textStyle: {
//                    color: '#fff'
//                },
//                selectedMode: 'single'
//            },
//            geo: {
//                map: 'china',
//                roam: true,
////        调省颜色、边界颜色
//                itemStyle: {
//                    normal: {
//                        areaColor: '#368097',
//                        borderColor: '#000'
//                    }
//                }
//            },
            series : [
                {
                    name: '随机数据',
                    type: 'map',
                    mapType: 'china',
                    selectedMode : 'single',
                    mapLocation:{
                        width:330,
                        height:260
                    },
                    data:[
                        {//去掉南海诸岛
                            name: '南海诸岛',
                            value: 0,
                            itemStyle:{
                                normal:{
                                    opacity:0
                                }
                            }
                        },
                        {name: '北京', selected:false,value:1},
                        {name: '天津', selected:false,value:2},
                        {name: '上海', selected:false,value:3},
                        {name: '重庆', selected:false,value:4},
                        {name: '河北', selected:false,value:5},
                        {name: '河南', selected:false,value:6},
                        {name: '云南', selected:false,value:7},
                        {name: '辽宁', selected:false,value:8},
                        {name: '黑龙江', selected:false,value:9},
                        {name: '湖南', selected:false,value:10},
                        {name: '安徽', selected:false,value:11},
                        {name: '山东', selected:false,value:12},
                        {name: '新疆', selected:false,value:13},
                        {name: '江苏', selected:false,value:14},
                        {name: '浙江', selected:false,value:15},
                        {name: '江西', selected:false,value:16},
                        {name: '湖北', selected:false,value:17},
                        {name: '广西', selected:false,value:18},
                        {name: '甘肃', selected:false,value:19},
                        {name: '山西', selected:false,value:20},
                        {name: '内蒙古', selected:false,value:21},
                        {name: '陕西', selected:false,value:22},
                        {name: '吉林', selected:false,value:23},
                        {name: '福建', selected:false,value:24},
                        {name: '贵州', selected:false,value:25},
                        {name: '广东', selected:false,value:26},
                        {name: '青海', selected:false,value:27},
                        {name: '西藏', selected:false,value:28},
                        {name: '四川', selected:false,value:29},
                        {name: '宁夏', selected:false,value:30},
                        {name: '海南', selected:false,value:31},
                        {name: '台湾', selected:false,value:32},
                        {name: '香港', selected:false,value:33},
                        {name: '澳门', selected:false,value:34}
                    ]//各省地图颜色数据依赖value
                }
            ],
            dataRange: {
                x: '-1000px',//图例横轴位置
                y: '-1000px',//图例纵轴位置
                splitList: [
                    {start:1, end:1, label: '北京', color: '#368097'},
                    {start:2, end:2, label: '天津', color: '#368097'},
                    {start:3, end:3, label: '上海', color: '#368097'},
                    {start:4, end:4, label: '重庆', color: '#368097'},
                    {start:5, end:5, label: '河北', color: '#368097'},
                    {start:6, end:6, label: '河南', color: '#368097'},
                    {start:7, end:7, label: '云南', color: '#368097'},
                    {start:8, end:8, label: '辽宁', color: '#368097'},
                    {start:9, end:9, label: '黑龙江', color: '#368097'},
                    {start:10, end:10, label: '湖南', color: '#368097'},
                    {start:11, end:11, label: '安徽', color: '#368097'},
                    {start:12, end:12, label: '山东', color: '#368097'},
                    {start:13, end:13, label: '新疆', color: '#368097'},
                    {start:14, end:14, label: '江苏', color: '#368097'},
                    {start:15, end:15, label: '浙江', color: '#368097'},
                    {start:16, end:16, label: '江西', color: '#368097'},
                    {start:17, end:17, label: '湖北', color: '#368097'},
                    {start:18, end:18, label: '广西', color: '#368097'},
                    {start:19, end:19, label: '甘肃', color: '#368097'},
                    {start:20, end:20, label: '山西', color: '#368097'},
                    {start:21, end:21, label: '内蒙古', color: '#368097'},
                    {start:22, end:22, label: '陕西', color: '#368097'},
                    {start:23, end:23, label: '吉林', color: '#368097'},
                    {start:24, end:24, label: '福建', color: '#368097'},
                    {start:25, end:25, label: '贵州', color: '#368097'},
                    {start:26, end:26, label: '广东', color: '#368097'},
                    {start:27, end:27, label: '青海', color: '#368097'},
                    {start:28, end:28, label: '西藏', color: '#368097'},
                    {start:29, end:29, label: '四川', color: '#368097'},
                    {start:30, end:30, label: '宁夏', color: '#368097'},
                    {start:31, end:31, label: '海南', color: '#368097'},
                    {start:32, end:32, label: '台湾', color: '#368097'},
                    {start:33, end:33, label: '香港', color: '#368097'},
                    {start:34, end:34, label: '澳门', color: '#368097'},

                ]
            },//各省地图颜色；start：值域开始值；end：值域结束值；label：图例名称；color：自定义颜色值；
        };



        MapChart.setOption(visitorsTrackPoption);

