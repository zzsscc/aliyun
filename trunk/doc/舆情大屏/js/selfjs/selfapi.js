var tt =new Vue({
    el:'#main',
    data:{
        userEmotion:'',
        psNum:''
    }
});
    //热门事件
    $.ajax({
        url: 'http://192.168.3.44:8080/rest/v1/report/queryReportHotEvent',
        type: 'get',
        dataType: 'jsonp',
        data: {
            time:20161017
        },
        success: function (data) {
            if(data.success){
                var arr = data.result.listData.splice(0,7);
                for(var i=0;i<arr.length;i++){
                    if(arr[i].name.length>12){
                        arr[i].name=arr[i].name.substr(0,12)+"...";
                    }
                    heatEventOption.yAxis.data.push(arr[i].name);
                    heatEventOption.series[0].data.push(arr[i].count);
                }
                heatEvent.setOption(heatEventOption);
            }
            else{
                console.log('data.success不是true');
            }
        },
        error: function () {
            console.log('出错了');
        }
    });

//情感分析
$.ajax({
    url: 'http://192.168.3.44:8080/rest/v1/report/queryReportEmotion',
    type: 'get',
    dataType: 'jsonp',
    data: {
        time:20161017
    },
    success: function (data) {
        //console.log(data);
        //console.log('收到数据了');
        if(data.success){
            //情绪图赋值数值
            tt.userEmotion = data.result.value;
            emotionIndexChartOption.series[0].data[0].value = tt.userEmotion;
            function changeColor() {
                //情绪图改变颜色
                if(tt.userEmotion<-100 || tt.userEmotion>100){
                    console.log('用户情绪指数不在-100~100之间');
                }
                else if (tt.userEmotion < -50 ) {
                    //改变绿色部分的数值
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[0][0] = (parseFloat(tt.userEmotion) + 100) / 200;
                    //把蓝色部分改为灰色
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][1] = '#393a5a';
                    //再把粉色部分改为灰色
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][1] = '#393a5a';
                    //重绘情绪指数图
                    myChartEmo.setOption(emotionIndexChartOption);
                }
                else if(tt.userEmotion < 0 && tt.userEmotion>=-50){
                    //改变蓝色部分的数值
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][0] = (parseFloat(tt.userEmotion) + 100) / 200;
                    //再把可能变为灰色的蓝色部分变回来
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][1] = '#89b9f5';
                    //把绿色部分的数值改为0.25
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[0][0] = 0.25;
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[0][1] = '#50edb3';
                    //再把粉色部分改为灰色
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][1] = '#393a5a';
                    //重绘情绪指数图
                    myChartEmo.setOption(emotionIndexChartOption);
                }
                else if (tt.userEmotion >= 0) {
                    //改变粉色部分的数值
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][0] = (parseFloat(tt.userEmotion) + 100) / 200;
                    //再把可能变为灰色的粉色部分变回来
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][1] = '#ea8cdb';

                    //把绿色部分的数值改为0.25
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[0][0] = 0.25;
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[0][1] = '#50edb3';

                    //把蓝色部分的数值改为0.5
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][0] = 0.5;
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][1] = '#89b9f5';

                    //重绘情绪指数图
                    myChartEmo.setOption(emotionIndexChartOption);
                }
            }
            changeColor();
        }
        else{
            console.log('data.success不是true');
        }
    },
    error: function () {
        console.log('出错了');
    }
});

//情感趋势
$.ajax({
    url: 'http://192.168.3.44:8080/rest/v1/report/queryReportEmotionTrend',
    type: 'get',
    dataType: 'jsonp',
    data: {
        time:20161017
    },
    success: function (data) {
        //console.log(data);
        //console.log('收到数据了');
        if(data.success){
            var arr = data.result;
            for(var i=0;i<arr.length;i++){
                //option2.xAxis[0].data = [];
                //option2.series[0].data = [];
                 option2.xAxis[0].data.push(arr[i].hour+':00');
                option2.series[0].data.push(arr[i].value);
            }
            myChart2.setOption(option2);
        }
        else{
            console.log('data.success不是true');
        }
    },
    error: function () {
        console.log('出错了');
    }
});

//舆情指数走势
$.ajax({
    url: 'http://192.168.3.44:8080/rest/v1/report/queryReportNumberTrend',
    type: 'get',
    dataType: 'jsonp',
    data: {
        time:20161017
    },
    success: function (data) {
        //console.log(data);
        //console.log('收到数据了');
        if(data.success){
            var arr = data.result;
            for(var i=0;i<arr.length;i++){
                //option3.xAxis[0].data = [];
                //option3.series[0].data = [];
                option3.xAxis[0].data.push(arr[i].hour+':00');
                option3.series[0].data.push(arr[i].value);
            }
            myChart3.setOption(option3);
        }
        else{
            console.log('data.success不是true');
        }
    },
    error: function () {
        console.log('出错了');
    }
});

//舆情指数
$.ajax({
    url: 'http://192.168.3.44:8080/rest/v1/report/queryReportTopic',
    type: 'get',
    dataType: 'jsonp',
    data: {
        time:20161017
    },
    success: function (data) {
        if(data.success){
          tt.psNum = data.result.value;
        }
        else{
            console.log('data.success不是true');
        }
    },
    error: function () {
        console.log('出错了');
    }
});

//热搜媒体
$.ajax({
    url: 'http://192.168.3.44:8080/rest/v1/report/queryReportNumber',
    type: 'get',
    dataType: 'jsonp',
    data: {
        time:20161017
    },
    success: function (data) {
        if(data.success){
            var arr = data.result.splice(0,7);
            for(var i=0;i<arr.length;i++){
                $('#rank').find('p').eq(i+1).text(i+1);
                $('#mt').find('p').eq(i+1).text(arr[i].sourceName);
                $('#mtNum').find('p').eq(i+1).text(arr[i].value);
            }
        }
        else{
            console.log('data.success不是true');
        }
    },
    error: function () {
        console.log('出错了');
    }
});
//热词搜索
$.ajax({
    url: 'http://192.168.3.44:8080/rest/v1/report/queryReportHotWord',
    type: 'get',
    dataType: 'jsonp',
    data: {
        time:20161017
    },
    success: function (data) {
        if(data.success){
            var arr = data.result.listData.splice(0,7);
            for(var i=0;i<arr.length;i++){
                $('#rcRank').find('p').eq(i+1).text(i+1);
                $('#rcMedia').find('p').eq(i+1).text(arr[i].name);
                $('#rcNum').find('p').eq(i+1).text(arr[i].count);
            }
        }
        else{
            console.log('data.success不是true');
        }
    },
    error: function () {
        console.log('出错了');
    }
});







