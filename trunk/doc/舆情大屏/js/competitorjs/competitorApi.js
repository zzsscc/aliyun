
var tt =new Vue({
    el:'#main',
    data:{
        userEmotion:''
    }
});

//折现图的超级数组
var lastArr = [];

//获取竞品列表的信息 GET
///competition/list
function ajaxPSList(){
    $.ajax({
        url: 'http://192.168.3.44:8080/competition/list',
        type: 'get',
        dataType: 'json',
        data: {

        },
        success:function(data){

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
            var chulires = chuli(res);
            console.log(chulires);

            //清空折现图的超级数组
            lastArr = [];

            for(var i=0;i<chulires.length;i++){
                // res[i] 是每个对象
                //每个对象都去要自己的折现图的数据 就是一个数组[{logDate,value},{logDate,value},{logDate,value},{logDate,value}]
                //再将这个单个数组放到折线图超级数组中，每一次都调用draw()画折线图
                ajaxPSexponent(20161022,chulires[i].topicId,1,chulires[i].name);

                //放置竞品位置
                switch (chulires[i].position){
                    case -1 :
                        $('.ps-topic').css({
                            background:'url('+chulires[i].imgUrl+')',
                            backgroundSize:'100% 100%'
                        });
                        var topicText = chulires[i].name;
                        $('.island2 .i-title').text(topicText);
                        break;

                    case 0:
                        $('.img-ct .product').eq(chulires[i].position).css({
                            background:'url('+chulires[i].imgUrl+')',
                            backgroundSize:'100% 100%'
                        });
                        var psText0 = chulires[i].name;
                        $('.island1 .i-title').text(psText0);
                        break;

                    case 1:
                        $('.img-ct .product').eq(chulires[i].position).css({
                            background:'url('+chulires[i].imgUrl+')',
                            backgroundSize:'100% 100%'
                        });
                        var psText1 = chulires[i].name;
                        $('.port1').text(psText1);
                        break;

                    case 2:
                        $('.img-ct .product').eq(chulires[i].position).css({
                            background:'url('+chulires[i].imgUrl+')',
                            backgroundSize:'100% 100%'
                        });
                        var psText2 = chulires[i].name;
                        $('.port2').text(psText2);
                        break;

                    case 3:
                        $('.img-ct .product').eq(chulires[i].position).css({
                            background:'url('+chulires[i].imgUrl+')',
                            backgroundSize:'100% 100%'
                        });
                        var psText3 = chulires[i].name;
                        $('.port3').text(psText3);
                        break;

                    case 4:
                        $('.img-ct .product').eq(chulires[i].position).css({
                            background:'url('+chulires[i].imgUrl+')',
                            backgroundSize:'100% 100%'
                        });
                        var psText4 = chulires[i].name;
                        $('.island3 .i-title').text(psText4);
                        break;

                    case 5:
                        $('.img-ct .product').eq(chulires[i].position).css({
                            background:'url('+chulires[i].imgUrl+')',
                            backgroundSize:'100% 100%'
                        });
                        var psText5 = res[i].name;
                        $('.port4').text(psText5);
                        break;
                    case 6:
                        $('.img-ct .product').eq(chulires[i].position).css({
                            background:'url('+chulires[i].imgUrl+')',
                            backgroundSize:'100% 100%'
                        });
                        var psText6 = chulires[i].name;
                        $('.island4 .i-title').text(psText6);
                        break;
                    default : console.log('希望你不要看到我'); break;
                }



                //接下来画四大情感值指针图
                //流水线，判断四个位置有没有值
                if(chulires[i].position === -1){
                    ajaxPSemotion(20161022,chulires[i].topicId,1,eA2Option,eA2,chulires[i].name);
                }
                if(chulires[i].position === 0){
                    ajaxPSemotion(20161022,chulires[i].topicId,1,eA1Option,eA1,chulires[i].name);
                }
                if(chulires[i].position === 4){
                    ajaxPSemotion(20161022,chulires[i].topicId,1,eA3Option,eA3,chulires[i].name);
                }
                if(chulires[i].position === 6){
                    ajaxPSemotion(20161022,chulires[i].topicId,1,eA4Option,eA4,chulires[i].name);
                }
            }


            ////热门事件setTimeout定时器
            function bindBom(){
                for(var j=0;j<chulires.length;j++){
                    var time = j*5000;
                    (function(j){
                        setTimeout(function(){
                            ajaxPSEvent(20161022,chulires[j].topicId,1,chulires[j].name);
                        },time);
                    })(j);
                }
            }
            bindBom();
            setInterval(function(){
                bindBom();
            },chulires.length*5000);


        },
        error: function () {
            console.log('获取竞品列表出错了');
        }
    });
}
ajaxPSList();



//获取单个竞品热门事件 GET
function ajaxPSEvent(time,topicId,timeType,name){
    $.ajax({
        url: 'http://192.168.3.44:8080/front/queryReportHotEvent',
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
                for(var i=0;i<10;i++){
                    //resultArr[i]
                    var num = i+1;
                    var str =  '<li class="clearfix">'
                                 + '<div class="list-num">'+num+'</div>'
                                 +'<div class="list-text">'+resultArr[i].name+'</div>'
                                 +'<div class="list-date">'+timeStr+'</div>'
                                 +'<div class="channel">'+'</div>'
                                +'</li>';
                    $('.list-ul').append(str);
                }
            }
        },
        error: function () {
            console.log('获取竞品信息出错了');
        }
    });
}
//ajaxPSEvent(20161022,3190,1,'酒仙网');



//获取单个竞品的舆情指数走势（折线图）
function ajaxPSexponent(time,topicId,timeType,name){
    //舆情指数走势
    $.ajax({
        url: 'http://192.168.3.44:8080/front/queryReportNumberTrend',
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


            //单个的画折线图的方式：
            //    //名字
            //    psmapOption.series[0].name = name;
            //    //小图标
            //    psmapOption.legend.data.push(name);
            //    var arr = data.result;
            //    for(var i=0;i<arr.length;i++){
            //        psmapOption.xAxis.data.push(arr[i].logDate);
            //        psmapOption.series[0].data.push(arr[i].value);
            //    }
            //    psmap.setOption(psmapOption);
            }
            else{
                console.log('data.success不是true');
            }
        },
        error: function () {
            console.log('获取舆情指数走势出错了');
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
            default : console.log('希望你不要看到我'); break;
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
        url: 'http://192.168.3.44:8080/front/queryReportEmotion',
        type: 'get',
        dataType: 'json',
        data: {
            time:time,
            topicId:topicId,
            timeType:timeType
        },
        success: function (data) {
            //console.log(data);
            //console.log('收到数据了');
            if(data.success){
                //console.log(data);
                //console.log(data.result.value);
                //情绪图赋值数值
                tt.userEmotion = data.result.value;
                mapOption.series[0].data[0].value = tt.userEmotion;
                //name
                mapOption.series[0].data[0].name = name;
                function changeColor() {
                    //情绪图改变颜色
                    if(tt.userEmotion<-100 || tt.userEmotion>100){
                        console.log('用户情绪指数不在-100~100之间');
                    }
                    else if (tt.userEmotion < -50 ) {
                        //改变绿色部分的数值
                        mapOption.series[0].axisLine.lineStyle.color[0][0] = (parseFloat(tt.userEmotion) + 100) / 200;
                        //把蓝色部分改为灰色
                        mapOption.series[0].axisLine.lineStyle.color[1][1] = '#393a5a';
                        //再把粉色部分改为灰色
                        mapOption.series[0].axisLine.lineStyle.color[2][1] = '#393a5a';
                        //重绘情绪指数图
                        map.setOption(mapOption);
                    }
                    else if(tt.userEmotion < 0 && tt.userEmotion>=-50){
                        //改变蓝色部分的数值
                        mapOption.series[0].axisLine.lineStyle.color[1][0] = (parseFloat(tt.userEmotion) + 100) / 200;
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
                    else if (tt.userEmotion >= 0) {
                        //改变粉色部分的数值
                        mapOption.series[0].axisLine.lineStyle.color[2][0] = (parseFloat(tt.userEmotion) + 100) / 200;
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

            }
            else{
                console.log('data.success不是true');
            }
        },
        error: function () {
            console.log('获取竞品情感值出错了');
        }
    });
}
//ajaxPSemotion(20161022,3190,1,eA1Option,eA1);
//ajaxPSemotion(20161017,3190,1,eA2Option,eA2);
//ajaxPSemotion(20161017,3190,1,eA3Option,eA3);
//ajaxPSemotion(20161017,3190,1,eA4Option,eA4);
