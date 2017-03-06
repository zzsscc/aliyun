
var userEmotion;
    //热门事件
    $.ajax({
        url: '/front/queryReportHotEvent',
        type: 'get',
        dataType: 'json',
        data: {
            time:time,timeType:type,topicId:topicId
        },
        success: function (data) {
            // showLoading();
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
                //console.log('data.success不是true');
            }
            hideLoading();
        },
        error: function () {
            //console.log('出错了');
        }
    });

//情感分析
$.ajax({
    url: '/front/queryReportEmotion',
    type: 'get',
    dataType: 'json',
    data: {
        time:time,timeType:type,topicId:topicId
    },
    success: function (data) {
        // showLoading();
        if(data.success){
            //情绪图赋值数值
            userEmotion = data.result.value;
            emotionIndexChartOption.series[0].data[0].value = userEmotion;
            function changeColor() {
                //情绪图改变颜色
                if(userEmotion<-100 || userEmotion>100){
                    console.log('用户情绪指数不在-100~100之间');
                }
                else if (userEmotion < -50 ) {
                    //改变绿色部分的数值
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[0][0] = (parseFloat(userEmotion) + 100) / 200;
                    //把蓝色部分改为灰色
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][1] = '#393a5a';
                    //再把粉色部分改为灰色
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][1] = '#393a5a';
                    //重绘情绪指数图
                    myChartEmo.setOption(emotionIndexChartOption);
                }
                else if(userEmotion < 0 && userEmotion>=-50){
                    //改变蓝色部分的数值
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][0] = (parseFloat(userEmotion) + 100) / 200;
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
                else if (userEmotion >= 0) {
                    //改变粉色部分的数值
                    emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][0] = (parseFloat(userEmotion) + 100) / 200;
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
            //console.log('data.success不是true');
        }
        hideLoading();
    },
    error: function () {
        //console.log('出错了');
    }
});

//情感趋势
$.ajax({
    url: '/front/queryReportEmotionTrend',
    type: 'get',
    dataType: 'json',
    data: {
        time:time,timeType:type,topicId:topicId
    },
    success: function (data) {
        // showLoading();
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
            //console.log('data.success不是true');
        }
        hideLoading();
    },
    error: function () {
        //console.log('出错了');
    }
});

//舆情指数走势
$.ajax({
    url: '/front/queryReportNumberTrend',
    type: 'get',
    dataType: 'json',
    data: {
        time:time,timeType:type,topicId:topicId
    },
    success: function (data) {
        // showLoading();
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
            //console.log('data.success不是true');
        }
        hideLoading();
    },
    error: function () {
        //console.log('出错了');
    }
});

//舆情指数
$.ajax({
    url: '/front/queryReportTopic',
    type: 'get',
    dataType: 'json',
    data: {
        time:time,timeType:type,topicId:topicId
    },
    success: function (data) {
        // showLoading();
        if(data.success){
          $('#centernumber').text(data.result.value);
        }
        else{
            //console.log('data.success不是true');
        }
        hideLoading();
    },
    error: function () {
        //console.log('出错了');
    }
});

//热搜媒体
$.ajax({
    url: '/front/queryReportNumber',
    type: 'get',
    dataType: 'json',
    data: {
        time:time,timeType:type,topicId:topicId
    },
    success: function (data) {
        // showLoading();
        if(data.success){
            var arr = data.result.splice(0,7);
            for(var i=0;i<arr.length;i++){
                $('#rank').find('p').eq(i+1).text(i+1);
                $('#mt').find('p').eq(i+1).text(arr[i].sourceName);
                $('#mtNum').find('p').eq(i+1).text(arr[i].value);
            }
        }
        else{
            //console.log('data.success不是true');
        }
        hideLoading();
    },
    error: function () {
        //console.log('出错了');
    }
});
//热词搜索
$.ajax({
    url: '/front/queryReportHotWord',
    type: 'get',
    dataType: 'json',
    data: {
        time:time,timeType:type,topicId:topicId
    },
    success: function (data) {
        // showLoading();
        if(data.success){
            var arr = data.result.listData.splice(0,7);
            for(var i=0;i<arr.length;i++){
                $('#rcRank').find('p').eq(i+1).text(i+1);
                $('#rcMedia').find('p').eq(i+1).text(arr[i].name);
                $('#rcNum').find('p').eq(i+1).text(arr[i].count);
            }
        }
        else{
            //console.log('data.success不是true');
        }
        hideLoading();
    },
    error: function () {
        //console.log('出错了');
    }
});




// 浏览器兼容 取得浏览器可视区高度
function getWindowInnerHeight() {
    var winHeight = window.innerHeight
        || (document.documentElement && document.documentElement.clientHeight)
        || (document.body && document.body.clientHeight);
    return winHeight;

}

// 浏览器兼容 取得浏览器可视区宽度
function getWindowInnerWidth() {
    var winWidth = window.innerWidth
        || (document.documentElement && document.documentElement.clientWidth)
        || (document.body && document.body.clientWidth);
    return winWidth;

}

/**
 * 显示遮罩层
 */
function showOverlay() {
    // 遮罩层宽高分别为页面内容的宽高
    $('.overlay').css({'height':$(document).height(),'width':$(document).width()});
    $('.overlay').show();
}

/**
 * 显示Loading提示
 */
function showLoading() {
    // 先显示遮罩层
    showOverlay();
    // Loading提示窗口居中
    $(".spinner").css('top',
        (getWindowInnerHeight() - $(".spinner").height()) / 2 + 'px');
    $(".spinner").css('left',
        (getWindowInnerWidth() - $(".spinner").width()) / 2 + 'px');

    $(".spinner").show();
    $(document).scroll(function() {
        return false;
    });
}


/**
 * 隐藏Loading提示
 */
function hideLoading() {
    $('.overlay').hide();
    $('.spinner').hide();
    $(document).scroll(function() {
        return true;
    });
}







