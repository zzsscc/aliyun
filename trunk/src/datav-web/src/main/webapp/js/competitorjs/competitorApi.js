//这是放置所有竞品和专题的数组
var psArr = [];
//第一步获取在专题，竞品设置页面上用户的设置
function ajaxPSget(){
    $.ajax({
        url: '/topic/list',
        type: 'get',
        dataType: 'json',
        data: {

        },
        success:function(data){
            //console.log(data);
            for(var i=0;i<data.length;i++){
                //竞品
                if(data[i].topicType === 1){
                    //竞品要判断启动
                    if(data[i].topicStatus === 1){
                        psArr.push(data[i]);
                    }
                }
                //专题
                else {
                    psArr.push(data[i]);
                }
            }
            ajaxPSList();
        },
        error: function () {
            ajaxPSList();
        }
    });
}
ajaxPSget();

var userEmotion;
//折现图的超级数组
var lastArr = [];
var chulires=[];

var iiindex =0 ;
//放置竞品位置
function setPosition(paramArr){
    for(var i=0;i<paramArr.length;i++){
        //放置竞品位置
        switch (paramArr[i].position){
            case -1 :
                $('.ps-topic').css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var topicText = paramArr[i].name;
                $('.island2 .i-title').text(topicText);
                break;

            case 0:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText0 = paramArr[i].name;
                $('.island1 .i-title').text(psText0);
                break;

            case 1:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText1 = paramArr[i].name;
                $('.port1').text(psText1);
                break;

            case 2:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText2 = paramArr[i].name;
                $('.port2').text(psText2);
                break;

            case 3:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText3 = paramArr[i].name;
                $('.port3').text(psText3);
                break;

            case 4:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText4 = paramArr[i].name;
                $('.island3 .i-title').text(psText4);
                break;

            case 5:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText5 = paramArr[i].name;
                $('.port4').text(psText5);
                break;
            case 6:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText6 = paramArr[i].name;
                $('.island4 .i-title').text(psText6);
                break;
            default :
                //console.log('希望你不要看到我');
                break;
        }
    }
}

//第二步 获取竞品列表的信息 GET
///competition/list
function ajaxPSList(){
    $.ajax({
        url: '/competition/list',
        type: 'get',
        dataType: 'json',
        data: {

        },
        success:function(data){
            showLoading();
            //console.log(data);

            var res =  JSON.parse(data[0].info);
            //  千万别动这个函数，耗时近半个小时，有点绕   处理返回的数组 让每个位置（position）都只有一个对象
            function chuli(res){
                var returnArr = [];
                function jade(parm){
                    for(var j=0;j<returnArr.length;j++){
                        if(parm.position === returnArr[j].position){
                            return { index : j };
                        }
                    }
                    return false;
                }
                for(var i=0;i<res.length;i++){
                    if(jade(res[i])){
//                找到之前的对象将它剔除
                        var obj = jade(res[i]);
                        returnArr.splice(obj.index,1);
//                加入后来的对象
                        returnArr.push(res[i]);
                    }
                    else{
                        returnArr.push(res[i]);
                    }
                }
                return returnArr;
            }

            chulires = chuli(res);
            //console.log(chulires);
            iiindex=0;

            //放置竞品位置
            //childArr数组是chulires数组的子集
            var childArr = [];
            for(var i=0;i<chulires.length;i++){
                for(var j=0;j<psArr.length;j++){
                    if(chulires[i].topicId === psArr[j].topicId){
                        childArr.push(chulires[i]);
                    }
                }
            }
            chulires = childArr;
            setPosition(childArr);

            //清空折现图的超级数组
            lastArr = [];
            if(childArr.length>0)
            {
                ajaxPSexponent(time,childArr[iiindex].topicId,1,childArr[iiindex].name);
            }

            //接下来画四大情感值指针图
            for(var i=0;i<childArr.length;i++){
                //流水线，判断四个位置有没有值
                if(childArr[i].position === -1){
                    ajaxPSemotion(time,childArr[i].topicId,1,eA2Option,eA2,childArr[i].name);
                }
                if(childArr[i].position === 0){
                    ajaxPSemotion(time,childArr[i].topicId,1,eA1Option,eA1,childArr[i].name);
                }
                if(childArr[i].position === 4){
                    ajaxPSemotion(time,childArr[i].topicId,1,eA3Option,eA3,childArr[i].name);
                }
                if(childArr[i].position === 6){
                    ajaxPSemotion(time,childArr[i].topicId,1,eA4Option,eA4,childArr[i].name);
                }
            }

            ////热门事件setTimeout定时器
            function bindBom(){
                for(var j=0;j<childArr.length;j++){
                    var intervalTime = j*5000;
                    (function(j){
                        setTimeout(function(){
                            ajaxPSEvent(time,childArr[j].topicId,1,childArr[j].name);
                        },intervalTime);
                    })(j);
                }
            }
            bindBom();
            setInterval(function(){
                bindBom();
            },childArr.length*5000);


        },
        error: function () {
            //console.log('获取竞品列表出错了');
        }
    });
}




//获取单个竞品热门事件 GET
function ajaxPSEvent(time,topicId,timeType,name){
    $.ajax({
        url: '/front/queryReportHotEvent',
        type: 'get',
        dataType: 'json',
        data: {
            time:time,
            topicId:topicId,
            timeType:timeType
        },
        success:function(data){
            if(data.success === true){
                //先清空
                $('.list-ul').html('');
                $('.activity').text(name+'热门事件');


                //时间
                var time = data.result.logDate; //20161021
                var retime = ''+time; // "20161021"
                var len = retime.length;
                var re = retime.substr(4,len-4); // '1021'
                var reArr = re.split(''); //['1','0','2','1']
                reArr.splice(2,0,'.'); //['1','0','.','2','1']
                var timeStr = reArr.join(''); // '10.21'


                //事件文字
                //console.log(data);
                //console.log(data.result.listData);
                var resultArr = data.result.listData;
                var lggArr = resultArr.splice(0,10);
                for(var i=0;i<lggArr.length;i++){
                    //resultArr[i]
                    var num = i+1;
                    var str =  '<li class="clearfix">'
                                 + '<div class="list-num">'+num+'</div>'
                                 +'<div class="list-text">'+lggArr[i].name+'</div>'
                                 +'<div class="list-date">'+timeStr+'</div>'
                                 +'<div class="channel">'+'</div>'
                                +'</li>';
                    $('.list-ul').append(str);
                }
            }
        },
        error: function () {
            //console.log('获取竞品信息出错了');
        }
    });
}
//ajaxPSEvent(20161022,3190,1,'酒仙网');



//获取单个竞品的舆情指数走势（折线图）
function ajaxPSexponent(time,topicId,timeType,name){
    //舆情指数走势
    $.ajax({
        url: '/front/queryReportNumberTrend',
        type: 'get',
        dataType: 'json',
        data: {
            time:time,
            topicId:topicId,
            timeType:timeType
        },
        success: function (data) {
            //console.log(data);
            if(data.success){
                data.result.name = name;
                lastArr.push(data.result);
                draw(lastArr);
            }
            else{
                //console.log('data.success不是true');
            }
            iiindex ++;
            if(iiindex < chulires.length)
            {
                ajaxPSexponent(time,chulires[iiindex].topicId,1,chulires[iiindex].name);
            }
        },
        error: function () {
            //console.log('获取舆情指数走势出错了');
            iiindex ++;
            if(iiindex < chulires.length)
            {
                ajaxPSexponent(time,chulires[iiindex].topicId,1,chulires[iiindex].name);
            }
        }
    });
}


//画单个折线图的方式
function draw(arr){
    psmapOption.xAxis.data = [];
    psmapOption.series = [];
    psmapOption.legend.data = [];

    // X 轴
    for(var j=0;j<arr[0].length;j++){
        psmapOption.xAxis.data.push(arr[0][j].logDate);
    }
    for(var i=0;i<arr.length;i++){
        var obj = {
            name: '',
            type: 'line',
            symbol: 'circle',
            symbolSize: 10,
            data: [],
            itemStyle: {
                     normal: {
                        color: ''
                    }
                }
            };
        //名字
        obj.name = arr[i].name;

        //颜色
        switch (i){
            case 0 :
                obj.itemStyle.normal.color = '#50edb3';
                break;
            case 1:
                obj.itemStyle.normal.color = '#9fe6fb';
                break;

            case 2:
                obj.itemStyle.normal.color = '#e09a74';
                break;

            case 3:
                obj.itemStyle.normal.color = '#cf5b5b';
                break;

            case 4:
                obj.itemStyle.normal.color = '#89b9f5';
                break;

            case 5:
                obj.itemStyle.normal.color = '#ea8cdb';
                break;

            case 6:
                obj.itemStyle.normal.color = '#ff8800';
                break;
            case 7:
                obj.itemStyle.normal.color = 'yellow';
                break;
            default :
                //console.log('希望你不要看到我');
                break;
        }

        //Y轴
        for(var k=0;k<arr[i].length;k++){
            obj.data.push(arr[i][k].value);
        }
        psmapOption.series.push(obj);

        //小图标
        psmapOption.legend.data.push(arr[i].name);
    }
    psmap.setOption(psmapOption);
}




//获取单个竞品的情感值（指针图）
function ajaxPSemotion(time,topicId,timeType,mapOption,map,name){
    $.ajax({
        url: '/front/queryReportEmotion',
        type: 'get',
        dataType: 'json',
        data: {
            time:time,
            topicId:topicId,
            timeType:timeType
        },
        success: function (data) {
            if(data.success){
                //情绪图赋值数值
                userEmotion = data.result.value;
                mapOption.series[0].data[0].value = userEmotion;
                //name
                mapOption.series[0].data[0].name = name;
                function changeColor() {
                    //情绪图改变颜色
                    if(userEmotion<-100 || userEmotion>100){
                        //console.log('用户情绪指数不在-100~100之间');
                    }
                    else if (userEmotion < -50 ) {
                        //改变绿色部分的数值
                        mapOption.series[0].axisLine.lineStyle.color[0][0] = (parseFloat(userEmotion) + 100) / 200;
                        //把蓝色部分改为灰色
                        mapOption.series[0].axisLine.lineStyle.color[1][1] = '#393a5a';
                        //再把粉色部分改为灰色
                        mapOption.series[0].axisLine.lineStyle.color[2][1] = '#393a5a';
                        //重绘情绪指数图
                        map.setOption(mapOption);
                    }
                    else if(userEmotion < 0 && userEmotion>=-50){
                        //改变蓝色部分的数值
                        mapOption.series[0].axisLine.lineStyle.color[1][0] = (parseFloat(userEmotion) + 100) / 200;
                        //再把可能变为灰色的蓝色部分变回来
                        mapOption.series[0].axisLine.lineStyle.color[1][1] = '#89b9f5';
                        //把绿色部分的数值改为0.25
                        mapOption.series[0].axisLine.lineStyle.color[0][0] = 0.25;
                        mapOption.series[0].axisLine.lineStyle.color[0][1] = '#50edb3';
                        //再把粉色部分改为灰色
                        mapOption.series[0].axisLine.lineStyle.color[2][1] = '#393a5a';
                        //重绘情绪指数图
                        map.setOption(mapOption);
                    }
                    else if (userEmotion >= 0) {
                        //改变粉色部分的数值
                        mapOption.series[0].axisLine.lineStyle.color[2][0] = (parseFloat(userEmotion) + 100) / 200;
                        //再把可能变为灰色的粉色部分变回来
                        mapOption.series[0].axisLine.lineStyle.color[2][1] = '#ea8cdb';

                        //把绿色部分的数值改为0.25
                        mapOption.series[0].axisLine.lineStyle.color[0][0] = 0.25;
                        mapOption.series[0].axisLine.lineStyle.color[0][1] = '#50edb3';

                        //把蓝色部分的数值改为0.5
                        mapOption.series[0].axisLine.lineStyle.color[1][0] = 0.5;
                        mapOption.series[0].axisLine.lineStyle.color[1][1] = '#89b9f5';

                        //重绘情绪指数图
                        map.setOption(mapOption);
                    }
                }
                changeColor();
                hideLoading();
            }
            else{
                //console.log('data.success不是true');
            }
        },
        error: function () {
            //console.log('获取竞品情感值出错了');
        }
    });
}


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
