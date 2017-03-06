
var userEmotion;
var newKeyArr = [];
var weiboUser = "";
function getshuju() {
    $.ajax({
        type: "GET",
        url: "/front/weiboAnalysisResult/preview",
        data:{
            id:previewId
        },
        dataType: "json",
        success: function (response) {
            console.log(response);
            showLoading();
            if(response.success===true && response.result.data !==null){
                //console.log(response.result.data);
                //微博账户名
                $('.top-head-l .one-level').text(weiboUser);
                //微博已证信息
                $('.top-head-l .sec-level').text(response.result.uInfo.verifiedReason);
                //微博具体描述
                //67是文字的上限
                if(response.result.uInfo.description.length>67){
                    var realStr = response.result.uInfo.description.substr(0,67);
                    realStr = realStr +'...';
                    $('.left-left-top-words').text(realStr);
                }
                else{
                    $('.left-left-top-words').text(response.result.uInfo.description);
                }
                //微博logo
                $('.headpic').attr('src',response.result.uInfo.avatarLarge);

                //一堆信息
                var resSimStr = response.result.simpleReport;
                if(resSimStr){
                    var re = />-?\d+</g;
                    var arr = resSimStr.match(re);
                    //arr=[">404536<", ">35<", ">17<", ">16<", ">1<", ">99<"]
                    var reArr = [];
                    for(var i=0;i<arr.length;i++){
                        var num = /-?\d+/g;
                        var a =arr[i].match(num);
                        reArr.push(a);
                    }
                    function choose() {
                        //[[404536][35][17][16][1][99]] 一共三转
                        if (reArr.length === 6) {
                            //新闻曝光量
                            $('.round-num .one').text(reArr[0][0]);
                            //新闻转发量
                            $('.round-num .two').text(reArr[1][0]);
                            //一转
                            $('.round-num .three').text(reArr[2][0]);
                            //二转
                            $('.round-num .four').text(reArr[3][0]);
                            //三转
                            $('.round-num .five').text(reArr[4][0]);
                            //用户情绪指数
                            userEmotion = reArr[5][0];
                        }
                        //[[404536][35][17][18][99]] 一共二转
                        else if (reArr.length === 5) {
                            //新闻曝光量
                            $('.round-num .one').text(reArr[0][0]);
                            //新闻转发量
                            $('.round-num .two').text(reArr[1][0]);
                            //一转
                            $('.round-num .three').text(reArr[2][0]);
                            //二转
                            $('.round-num .four').text(reArr[3][0]);
                            //三转
                            $('.round-num .five').text(0);
                            //用户情绪指数
                            userEmotion = reArr[4][0];
                        }
                        //[[404536][35][35][99]] 一共一转
                        else if (reArr.length === 4) {
                            //新闻曝光量
                            $('.round-num .one').text(reArr[0][0]);
                            //新闻转发量
                            $('.round-num .two').text(reArr[1][0]);
                            //一转
                            $('.round-num .three').text(reArr[2][0]);
                            //二转
                            $('.round-num .four').text(reArr[3][0]);
                            //三转
                            $('.round-num .five').text(0);
                            //用户情绪指数
                            userEmotion = reArr[3][0];
                        }
                        //太多了
                        else{
                            //新闻曝光量
                            $('.round-num .one').text(reArr[0][0]);
                            //新闻转发量
                            $('.round-num .two').text(reArr[1][0]);
                            //一转
                            $('.round-num .three').text(reArr[2][0]);
                            //二转
                            $('.round-num .four').text(reArr[3][0]);
                            //三转
                            $('.round-num .five').text(0);
                            //用户情绪指数
                            userEmotion = reArr[reArr.length-1][0];
                        }
                    }
                    choose ();


                    //情绪图赋值数值
                    emotionIndexChartOption.series[0].data[0].value =userEmotion;
                    function changeColor() {
                        //情绪图改变颜色
                        if(userEmotion<-100 || userEmotion>100){
                            //console.log('用户情绪指数不在-100~100之间');
                        }
                        else if (userEmotion < -50 ) {
                            //改变绿色部分的数值
                            emotionIndexChartOption.series[0].axisLine.lineStyle.color[0][0] = (parseFloat(userEmotion) + 100) / 200;
                            //把蓝色部分改为灰色
                            emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][1] = '#393a5a';
                            //再把粉色部分改为灰色
                            emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][1] = '#393a5a';
                            //重绘情绪指数图
                            emotionIndexChart.setOption(emotionIndexChartOption);
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
                            emotionIndexChart.setOption(emotionIndexChartOption);
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
                            emotionIndexChart.setOption(emotionIndexChartOption);
                        }

                    }
                    changeColor();
                }

                //关键传播账号所有信息数组
                newKeyArr = response.result.data.top100User.splice(0,9);
                function keyArr(){
                    for(var i=0;i<newKeyArr.length;i++){
                        //最讨厌的时间
                        var year = new Date(newKeyArr[i].postTime).getFullYear();
                        var month = new Date(newKeyArr[i].postTime).getMonth()+1;
                        var date = new Date(newKeyArr[i].postTime).getDate();
                        var hours = new Date(newKeyArr[i].postTime).getHours();
                        var minutes = new Date(newKeyArr[i].postTime).getMinutes();
                        var time = ''+year+'/'+month+'/'+date+' '+hours+':'+minutes;

                        var str = '<li class="lgg-li clearfix">'
                            +'<div class="td-name">'+newKeyArr[i].screenName+'</div>'
                            +'<div class="td-fen">'+newKeyArr[i].followersCount+'</div>'
                            +'<div class="td-user-type">'+newKeyArr[i].verifiedType+'</div>'
                            +'<div class="td-time">'+time+'</div>'
                            +'<div class="td-two last-td">'+newKeyArr[i].repostCount+'</div>'
                            +'</li>';
                        $('.lgg-ul').append(str);
                    }
                }
                keyArr();



                //72小时转播图

                //每隔个8小时显示一次  也就是每隔48个十分钟显示一次 [0] [47] [95] [143] [191] [239] [287] [335] [383] [431]
                //var len = response.result.data.timeList.length;
                var len = response.result.data.timeList.length;
                var cirArr = [];
                //动态生成cirArr数组
                function creatCirArr(){
                    var num = 0 ;
                    var arr = [];
                    while (num < len){
                        num = num +48;
                        arr.push(num);
                    }
                    arr.pop();
                    arr.push(len);
                    return arr;
                }
                //var cirArr = [48,96,144,192,240,288,336,384,len];
                cirArr = creatCirArr();
                //console.log(cirArr);
                //x轴
                chart72hOption.xAxis[0].data = [];
                function xAx(){
                    chart72hOption.xAxis[0].data.push(response.result.data.timeList[0].x);
                    for(var i=0;i<cirArr.length;i++){
                        var index = cirArr[i] - 1;
                        //console.log(index);
                        chart72hOption.xAxis[0].data.push(response.result.data.timeList[index].x);
                    }
                }
                xAx();

                //y轴
                chart72hOption.series[0].data = [];
                function yAx(){
                    //设置x=0时的值
                    chart72hOption.series[0].data.push(response.result.data.timeList[0].y);
                    function innerCir(){
                        //cirArr = [48,96,144,192,240,288,336,384,len];
                        cirArr = creatCirArr();
                        //console.log(cirArr);
                        var a = 0;
                        //向y轴里面放数值
                        for(var i=0;i<cirArr.length;i++){
                            var total = 0;
                            //console.log(a,cirArr[i]);
                            for(var j =a;j<cirArr[i];j++){
                                total = total +response.result.data.timeList[j].y;
                            }
                            chart72hOption.series[0].data.push(total);
                            //经过48次循环之后，a变为了48
                            a = j;
                            //console.log(chart72hOption.series[0].data);
                        }
                    }
                    innerCir();
                }
                yAx();
                //重绘地图
                chart72h.setOption(chart72hOption);



                //用户类型
                var person = response.result.data.userTypeMap.个人认证;
                var company = response.result.data.userTypeMap.企业认证;
                var master = response.result.data.userTypeMap.微博达人;
                var general = response.result.data.userTypeMap.普通用户;
                if(!person){
                    person=0;
                }
                if(!company){
                    company=0;
                }
                if(!master){
                    master=0;
                }
                if(!general){
                    general=0;
                }
                var tophotNumArr = [];
                tophotNumArr.push(person, company, master, general);
                var topHot = document.getElementsByClassName('right-top-center')[0];
                var tophotNum = topHot.getElementsByClassName('hot-num');
                var tophotStrip = topHot.getElementsByClassName('hot-strip');
                var topsunHotArr = eval(tophotNumArr.join('+'));


                var tophotArr = [];
                tophotArr.push(person / topsunHotArr * 100, company / topsunHotArr * 100, master / topsunHotArr * 100, general / topsunHotArr * 100);
                rightHot(tophotNum, tophotArr, tophotStrip, tophotNumArr, topsunHotArr);
                //图
                for (var i = 0; i < tophotNumArr.length; i++) {
                    rightTopChartOption.series[0].data[i].value = tophotNumArr[3-i];
                }
                rightTopChart.setOption(rightTopChartOption);


                //男女比例
                var men = response.result.data.sexMap.男;
                var female = response.result.data.sexMap.女;
                if(!men){
                    men=0;
                }
                if(!female){
                    female=0;
                }
                var middlehotNumArr = [];
                middlehotNumArr.push(men, female);
                var middleHot = document.getElementsByClassName('right-middle-center')[0];
                var middlehotNum = middleHot.getElementsByClassName('hot-num');
                var middlehotStrip = middleHot.getElementsByClassName('hot-strip');
                var middlesunHotArr = eval(middlehotNumArr.join('+'));

                var middlehotArr = [];
                middlehotArr.push(men / middlesunHotArr * 100, female / middlesunHotArr * 100);
                rightHot(middlehotNum, middlehotArr, middlehotStrip, middlehotNumArr, middlesunHotArr);
                //图
                for (var i = 0; i < middlehotNumArr.length; i++) {
                    rightMiddleChartOption.series[0].data[i].value = middlehotNumArr[1-i];
                }
                rightMiddleChart.setOption(rightMiddleChartOption);


                //水军比例
                var shuifalse = response.result.data.waterArmyMap.false;
                var shuitrue = response.result.data.waterArmyMap.true;
                if(!shuifalse){
                    shuifalse=0;
                }
                if(!shuitrue){
                    shuitrue=0;
                }
                var bottomhotNumArr = [];
                bottomhotNumArr.push(shuifalse, shuitrue);
                var bottomHot = document.getElementsByClassName('right-bottom-center')[0];
                var bottomhotNum = bottomHot.getElementsByClassName('hot-num');
                var bottomhotStrip = bottomHot.getElementsByClassName('hot-strip');
                var bottomsunHotArr = eval(bottomhotNumArr.join('+'));

                var bottomhotArr = [];
                bottomhotArr.push(shuifalse / bottomsunHotArr * 100, shuitrue / bottomsunHotArr * 100);
                rightHot(bottomhotNum, bottomhotArr, bottomhotStrip, bottomhotNumArr, bottomsunHotArr);
                //图
                for (var i = 0; i < bottomhotNumArr.length; i++) {
                    rightBottomChartOption.series[0].data[i].value = bottomhotNumArr[1 - i];
                }
                rightBottomChart.setOption(rightBottomChartOption);


                function rightHot(hotNum, hotArr, hotStrip, hotNumArr, sunHotArr) {
                    for (var i = 0; i < hotNum.length; i++) {
                        hotNum[i].innerHTML = hotArr[i].toFixed(1) + '%';
                        hotStrip[i].style.width = (hotNumArr[i] / sunHotArr) * 90 + "px"
                    }
                }




                //地图
                var total = 0;
                var areaMap=response.result.data.areaMap;
                var trueAreaMap=[];
                var trueOtherAreaMap=[];
                var dark='<div class="dark clearfix">'+
                    '<div class="color dark-color"></div>'+
                    '<div class="wenzi dark-wenzi">深色&nbsp;&nbsp;&nbsp;14.3%</div>'+
                    '</div>';
                var medium='<div class="medium clearfix">'+
                    '<div class="color medium-color"></div>'+
                    '<div class="wenzi medium-wenzi">深色&nbsp;&nbsp;&nbsp;14.3%</div>'+
                    '</div>';
                var tint='<div class="tint clearfix">'+
                    '<div class="color tint-color"></div>'+
                    '<div class="wenzi tint-wenzi">深色&nbsp;&nbsp;&nbsp;14.3%</div>'+
                    '</div>';
                //去掉数据中没有key的部分
                for(i=0;i<areaMap.length;i++){
                    if(areaMap[i].key && areaMap[i].key!='其他'){     //把key为非其他的部分存起来
                        trueAreaMap.push(areaMap[i]);
                    }else if(areaMap[i].key && areaMap[i].key=='其他'){      //把key为其他的那个存起来
                        trueOtherAreaMap.push(areaMap[i]);
                    }
                }
                //只取7个非其他地区
                if(trueAreaMap.length>7){
                    trueAreaMap.length=7;
                }
                //累加非其他地区的数值为total
                for(var i=0;i<trueAreaMap.length;i++ ){
                    total = total + trueAreaMap[i].value;
                }
                //如果其他地区的数组不为空，total加上其他的value
                if(trueOtherAreaMap.length>0){
                    total +=trueOtherAreaMap[0].value;
                }
                for(var j=0;j<trueAreaMap.length;j++){
                    trueAreaMap[j].value = (trueAreaMap[j].value/total*100).toFixed(2) + "%";
                    for(var i=0;i<visitorsTrackPoption.dataRange.splitList.length;i++){
                        if(visitorsTrackPoption.dataRange.splitList[i].label === trueAreaMap[j].key){
                            visitorsTrackPoption.dataRange.splitList[i].color= '#19647b';
                            if(j === 0){
                                visitorsTrackPoption.dataRange.splitList[i].color= '#08475a';
                            }
                        }
                    }

                    //右边的图注
                    //if(j==0){
                    //    $('.map-info-center').append(dark);
                    //    $('.dark-wenzi').html(trueAreaMap[j].key+'&nbsp;&nbsp;&nbsp;'+trueAreaMap[j].value);
                    //}else if(j>0 && j<trueAreaMap.length-1){
                    //    $('.map-info-center').append(medium);
                    //}else if(j==trueAreaMap.length-1){
                    //    $('.map-info-center').append(tint);
                    //    $('.tint-wenzi').html(trueAreaMap[j].key+'&nbsp;&nbsp;&nbsp;'+trueAreaMap[j].value);
                    //}
                    if(j==0){
                        $('.map-info-center').append(dark);
                        $('.dark-wenzi').html(trueAreaMap[j].key+'&nbsp;&nbsp;&nbsp;'+trueAreaMap[j].value);
                    }
                }

                //for(var i=1;i<trueAreaMap.length-1;i++){
                //    $($('.medium-wenzi')[i-1]).html(trueAreaMap[i].key+'&nbsp;&nbsp;&nbsp;'+trueAreaMap[i].value);
                //}
                //右边的图注
                for(var i=1;i<trueAreaMap.length;i++){
                    $('.map-info-center').append(medium);
                    $($('.medium-wenzi')[i-1]).html(trueAreaMap[i].key+'&nbsp;&nbsp;&nbsp;'+trueAreaMap[i].value);
                }

                //其他地区
                if(trueOtherAreaMap.length>0) {
                    trueOtherAreaMap[0].value = (trueOtherAreaMap[0].value / total * 100).toFixed(2) + "%";
                    $('.map-info-center').append(tint);
                    $($('.tint-wenzi')).html(trueOtherAreaMap[0].key + '&nbsp;&nbsp;&nbsp;' + trueOtherAreaMap[0].value);
                }
                //重绘地图
                MapChart.setOption(visitorsTrackPoption);

            }


            //微博传播路径
            weiboUser = response.result.uInfo.name;
            if(weiboUser.length>5){
                weiboUser=weiboUser.slice(0,4);
                weiboUser=weiboUser+'..'
            }
            //处理发微博的时间
            var pTime=response.result.pubTime;
            var specifictime = timeformated(pTime);
            var pTimeCuo = Date.parse(new Date(specifictime));
            var pTimeCuo=pTimeCuo+1000*60*60*8

            //画svg
            var dltW=700;
            var dltH=420;
            var svg=d3.select('#dianlutu').append('svg').attr({
                'width':dltW,
                'height':dltH,
                //'border':'1px solid #fff'
            });

            //博主
            var zsData=[{name:weiboUser,r:35}];

            var zsCircle=svg.selectAll('circle.zs').data(zsData).enter().append('circle');
            var zsText=svg.selectAll('text.zs').data(zsData).enter().append('text');
            //定义球的渐变
            var acol = d3.rgb(82,217,167);
            var bcol = d3.rgb(3,98,99);
            var defs = svg.append("defs");

            var linearGradient = defs.append("linearGradient")
                .attr("id","linearColor")
                .attr("x1","20%")
                .attr("y1","20%")
                .attr("x2","100%")
                .attr("y2","100%");

            var stop1 = linearGradient.append("stop")
                .attr("offset","0%")
                .style("stop-color",acol.toString());

            var stop2 = linearGradient.append("stop")
                .attr("offset","100%")
                .style("stop-color",bcol.toString());

            //定义博主的圆
            zsCircle.attr({
                'class':'zs',
                'cx':dltW/2,
                'cy':dltH/2,
                'r':0,
                "fill":"url(#" + linearGradient.attr("id") + ")"
            })

            //博主圆的动画
            zsCircle
                .transition()
                .duration(500)
                .attr({
                    'r':function(d){return d.r},
                })


            //博主的文字
            zsText.text(function(d){return d.name}).attr({
                'class':'zs',
                'x':function(d){return dltW/2},
                'y':function(d){return dltH/2+6},
                'text-anchor':'middle',
                'fill':'transparent',
                'font-size':'14px'
            })

            //博主文字动画
            zsText
                .transition()
                .delay(500)
                .duration(500)
                .attr({
                    'fill':'white',
                })

            //博主外边的圈
            var zsOutData=[{rx:78,ry:48},{rx:126,ry:80},{rx:184,ry:112},{rx:248,ry:148},{rx:313,ry:185}];
            var zsCircle1=svg.selectAll('ellipse.zsout').data(zsOutData).enter().append('ellipse');
            //定义内3外圈的渐变
            var ccol = d3.rgb(0,69,122);
            var dcol = d3.rgb(111,10,130);
            var defsOut = svg.append("defs");

            var linearGradientOut = defsOut.append("linearGradient")
                .attr("id","linearColorOut")
                .attr("x1","0%")
                .attr("y1","0%")
                .attr("x2","100%")
                .attr("y2","0%");

            var stop3 = linearGradientOut.append("stop")
                .attr("offset","0%")
                .style("stop-color",ccol.toString());

            var stop4 = linearGradientOut.append("stop")
                .attr("offset","100%")
                .style("stop-color",dcol.toString());
            //定义外2外圈的渐变
            var gcol = d3.rgb(2,75,125);
            var hcol = d3.rgb(102,1,117);
            var defsOut2 = svg.append("defs");

            var linearGradientOut2 = defsOut2.append("linearGradient")
                .attr("id","linearColorOut2")
                .attr("x1","0%")
                .attr("y1","0%")
                .attr("x2","100%")
                .attr("y2","0%");

            var stop7 = linearGradientOut2.append("stop")
                .attr("offset","0%")
                .style("stop-color",gcol.toString());

            var stop8 = linearGradientOut2.append("stop")
                .attr("offset","100%")
                .style("stop-color",hcol.toString());
            zsCircle1.attr({
                'class':'zsout',
                'cx':dltW/2,
                'cy':dltH/2,
                'rx':function(d,i){return d.rx},
                'ry':function(d,i){return d.ry},
                'fill':'transparent',
                'stroke':"transparent",
                'stroke-width':0,
                'stroke-dasharray':function(d,i){
                    if(i>=0&&i<3){
                        return '2,4'
                    }else if(i>=3){
                        return '0.9'
                    }

                }
            });
            //外圆动画
            zsCircle1
                .transition()
                .delay(function(d, i) {
                    return i * 500+500;
                })
                .duration(500)
                .attr({
                    //'stroke':"url(#" + linearGradientOut.attr("id") + ")",
                    'stroke':function(d,i){
                        if(i<3){
                            return "url(#" + linearGradientOut.attr("id") + ")"
                        }else{
                            return "url(#" + linearGradientOut2.attr("id") + ")"
                        }
                    },
                    'stroke-width':function(d,i){
                        if(i<2){
                            return 2
                        }else{
                            return 1
                        }
                    },
                });


            //把转发的点的信息存下来
            var pathData=[];
            for(var i=0;i<newKeyArr.length;i++){
                pathData.push({
                    name:newKeyArr[i].screenName,
                    folcon:newKeyArr[i].followersCount,
                    time:newKeyArr[i].postTime-pTimeCuo,
                    seccon:newKeyArr[i].repostCount,
                    x:dltW/2,
                    y:dltH/2-35
                })
            }
            //console.log(pathData);

            //画线
            //定义比例尺
            var lScale=d3.scale.linear().domain([
                -d3.max(pathData,function(d){return d.time}),
                d3.max(pathData,function(d){return d.time})
            ]).range([0,150]);
            //定义比例尺
            var lwScale=d3.scale.linear().domain([
                0,
                d3.max(pathData,function(d){return d.seccon})
            ]).range([1,3]);
            //定义线的渐变
            var ecol = d3.rgb(30,132,253);
            var fcol = d3.rgb(183,25,239);
            var defsLine = svg.append("defs");

            var linearGradientLine = defsLine.append("linearGradient")
                .attr("id","linearColorLine")
                .attr("x1","0%")
                .attr("y1","0%")
                .attr("x2","100%")
                .attr("y2","0%");

            var stop5 = linearGradientOut.append("stop")
                .attr("offset","0%")
                .style("stop-color",ecol.toString());

            var stop6 = linearGradientOut.append("stop")
                .attr("offset","100%")
                .style("stop-color",fcol.toString());
            var lineData=[];
            function toLine(i,seccon){
                lineData=[
                    {x:dltW/2, y:dltH/2-35},
                    //{x:dltW/2, y:dltH/2-35-lScale(pathData[i].time)},
                    {x:dltW/2, y:dltH/2-35},
                ];

                //线生成器
                var lineFunction = d3.svg.line()
                    .x(function(d){return d.x;})
                    .y(function(d){return d.y;})
                    .interpolate("linear");


                //把path扔到容器中-- lineData和lineFunction，并给d赋属性
                var lineGraph = svg.append("path")
                    .attr("d",lineFunction(lineData))
                    .attr("stroke","#252f5d")
                    //.attr({
                    //    'stroke':"url(#" + linearGradientLine.attr("id") + ")",
                    //})
                    .attr("stroke-width",function(d){return lwScale(seccon)})
                    .attr("fill","none")
                    .attr("transform", "rotate("+i*(360/newKeyArr.length)+" 350,210)")

                //线动画延伸
                lineData=[
                    {x:dltW/2, y:dltH/2-35},
                    {x:dltW/2, y:dltH/2-35-lScale(pathData[i].time)},
                    //{x:dltW/2, y:dltH/2-36},
                ];

                lineFunction = d3.svg.line()
                    .x(function(d){return d.x;})
                    .y(function(d){return d.y;})
                    .interpolate("linear");


                lineGraph
                    .transition()
                    .delay(3000)
                    .duration(1000)
                    .ease("bounce")
                    .attr("d",lineFunction(lineData))
            }
            for(var i=0;i<newKeyArr.length;i++){
                var seccon=pathData[i].seccon
                toLine(i,seccon);
            }


            //画转发点
            var flCircle=svg.selectAll('circle.fl').data(pathData).enter().append('circle');
            //定义比例尺
            var rScale=d3.scale.linear().domain([
                0,
                d3.max(pathData,function(d){return d.folcon})
            ]).range([5,20]);

            //定义转发者的圆
            flCircle.attr({
                'class':'fl',
                'cx':function(d){return d.x},
                'cy':function(d,i){return d.y},
                'r':function(d){return rScale(d.folcon)},
                "fill":"transparent",
                "transform":function(d,i){
                    return "rotate("+i*(360/newKeyArr.length)+" 350,210)"
                }
            });

            //球动画
            flCircle
                .transition()
                .delay(function(d, i) {
                    return 3000;
                })
                .duration(1000)
                .ease("bounce")
                .attr({
                    'class':'fl',
                    'cx':function(d){return d.x},
                    'cy':function(d,i){return d.y-lScale(d.time)},
                    'r':function(d){return rScale(d.folcon)},
                    "fill":"url(#" + linearGradient.attr("id") + ")",
                })


            //
            setTimeout(function(){
                //放文字
                var cc=document.querySelectorAll('.fl');

                for(var i=0;i<cc.length;i++){
                    //获取小球位置
                    var ctm=cc[i].getCTM();
                    var ctmx=Number(cc[i].getAttribute("cx")),ctmy=Number(cc[i].getAttribute("cy"));
                    var curX=ctmx*ctm.a+ctmy*ctm.c+ctm.e,curY=ctmx*ctm.b+ctmy*ctm.d+ctm.f;
                    //console.log(curX);
                    //console.log(curY);
                    pathData[i].x2=curX;
                    pathData[i].y2=curY;
                }
                //console.log(pathData);


                //转发者的文字
                var flText=svg.selectAll('text.flt').data(pathData).enter().append('text');
                flText.text(function(d){return d.name}).attr({
                    'class':'flt',
                    'x':function(d){return d.x2},
                    'y':function(d){return d.y2+rScale(d.folcon)+15},
                    'dy':'.35em',
                    'text-anchor':'middle',
                    'fill':'transparent',
                    'font-size':'14px',
                });

                //转发者的文字动画
                flText
                    .transition()
                    .delay(function(d, i) {
                        return i * 100;
                    })
                    .duration(100)
                    .ease("bounce")
                    .attr({
                        'fill':'#6ad0c5',
                    })
            },4000)


            // 格式化日期时间
            function timeformated(timestr){
                // 时间日期的格式转换
                timestr=timestr.replace('T'," ");
                timestr=timestr.replace('000Z',"");
                timestr=timestr.replace('\.',"");
                return timestr;
            }


            hideLoading();
        },
        error: function () {
            alert('fail');
        }
    });
}
getshuju();
//setInterval(function(){
//    getshuju()
//},2000)





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
    $('.overlay').show();
}

/**
 * 显示Loading提示
 */
function showLoading() {
    // 先显示遮罩层
    showOverlay();
    // Loading提示窗口居中
    $(".spinner").css('top', 520 + 'px');
    $(".spinner").css('left', 940 + 'px');

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

