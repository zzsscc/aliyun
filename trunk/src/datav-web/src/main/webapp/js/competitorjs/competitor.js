//        折线图
var psmap = echarts.init(document.getElementById('ps-map'));
var psmapOption =  {
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        //data:['大陈岛','东引岛','蛇蟠岛','大沙岱'],
        data:[],
        textStyle:{color:'#57aba3'},
        x:800,
        y:140
    },
    grid: {
//        x:65,
//        y:40,
//        x2:60,
//        y2:20
    },
    xAxis:  {
        type: 'category',
//        name : '（月份）',
        boundaryGap: false,
        //data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
        data: [],
        axisLine:{
            lineStyle:{
                color:'#093f50',
                width:2
            }
        },
        axisLabel:{
            textStyle:{
                color:'#6ad0c5'
            }
        },
        splitLine:{
            show:true,
            lineStyle:{
                color:'#17172a',
                width:2
            }
        },
        axisTick:{
            inside:true,
            lineStyle:{
                width:2
            }
        }
    },
    yAxis: {
        type: 'value',
        name : '数量',
        nameTextStyle:{
            color:'#6ad0c5'
        },
        axisLine:{
            lineStyle:{
                color:'#093f50',
                width:2
            }
        },
        axisLabel:{
            textStyle:{
                color:'#6ad0c5'
            }
        },
        splitLine:{
            show:true,
            lineStyle:{
                color:'#17172a',
                width:2
            }
        },
        axisTick:{
            inside:true,
            lineStyle:{
                width:2
            }
        }
    },
    series: [

    ]
};


//        指针图
var eA1 = echarts.init(document.getElementById('em1'));
var eA2 = echarts.init(document.getElementById('em2'));
var eA3 = echarts.init(document.getElementById('em3'));
var eA4 = echarts.init(document.getElementById('em4'));

var eA1Option = {
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
//                    color: [[0.25, '#50edb3'], [0.5,'#89b9f5'],[0.89, '#ea8cdb'], [1, '#393a5a']]
                    color: [[0.25, '#50edb3'], [0.5,'#89b9f5'],[0.89, '#393a5a'], [1, '#393a5a']]
                }
            },
            axisTick: {            // 坐标轴小标记
                length:10,        // 属性length控制线长
                splitNumber:10,
                inside:false,
                lineStyle: {       // 属性lineStyle控制线条样式
                    color:'auto',
                    width:2
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
                }
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
                name: ''
            }]
        }
    ]
};
var eA2Option = {
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
                    color: [[0.25, '#50edb3'], [0.5,'#89b9f5'],[0.89, '#393a5a'], [1, '#393a5a']]
                }
            },
            axisTick: {            // 坐标轴小标记
                length:10,        // 属性length控制线长
                splitNumber:10,
                inside:false,
                lineStyle: {       // 属性lineStyle控制线条样式
                    color:'auto',
                    width:2
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
                }
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
var eA3Option = {
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
                    color: [[0.25, '#50edb3'], [0.5,'#89b9f5'],[0.89, '#393a5a'], [1, '#393a5a']]
                }
            },
            axisTick: {            // 坐标轴小标记
                length:10,        // 属性length控制线长
                splitNumber:10,
                inside:false,
                lineStyle: {       // 属性lineStyle控制线条样式
                    color:'auto',
                    width:2
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
                }
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
var eA4Option = {
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
                    color: [[0.25, '#50edb3'], [0.5,'#89b9f5'],[0.89, '#393a5a'], [1, '#393a5a']]
                }
            },
            axisTick: {            // 坐标轴小标记
                length:10,        // 属性length控制线长
                splitNumber:10,
                inside:false,
                lineStyle: {       // 属性lineStyle控制线条样式
                    color:'auto',
                    width:2
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
                }
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

