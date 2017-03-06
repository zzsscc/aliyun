
var userEmotion;
var newKeyArr = [];
var weiboUser = "";
function getshuju() {
    $.ajax({
        type: "GET",
        url: "/front/weiboAnalysisResult",
        dataType: "json",
        success: function (response) {
            showLoading();
            if(response.success===true && response.result.data !==null){
                //console.log(response.result.data);
                weiboUser = response.result.uInfo.name
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





            if(response.success===true && response.result.graphNodes !==null && response.result.graphEdges !==null) {
                //处理将ajax传过来的数据，如果是字符串则转换为json
                if(typeof response.result.graphNodes=='string'){
                    var graphNodes = JSON.parse(response.result.graphNodes);
                    var graphEdges = JSON.parse(response.result.graphEdges);
                }else{
                    var graphNodes = response.result.graphNodes;
                    var graphEdges = response.result.graphEdges;
                }

                //创建twaver容器
                var box = new twaver.ElementBox();
                //创建twaver画布
                var network = new twaver.vector.Network(box);
                var view = network.getView();
                document.getElementById('dianlutu').appendChild(view);

                //设置twaver画布的位置和大小
                network.adjustBounds({x: 0, y: 0, width: 720, height: 420});

                //设置统一样式
                twaver.Styles.setStyle('label.color','#6ad0c5');
                twaver.Styles.setStyle('select.color','transparent');


                //小旋风矢量图
                //引入图片，在图片加载后将图片作为矢量图定义
                var weibobimg = new Image();
                weibobimg.src = '/img/focusNews-img/weibo1.png';
                weibobimg.onload = function () {
                    weibobimg.onload = null;
                    twaver.Util.registerImage('weibolgimg', weibobimg, 38, 38);
                    network.invalidateElementUIs();
                };
                //定义矢量图
                twaver.Util.registerImage('weibolg', {
                    w: 38,
                    h: 38,
                    origin: {
                        x: 0,
                        y: 0
                    },
                    //fill: '#57AB9A',   填充色
                    //lineWidth: 1,      边框线宽度
                    //lineColor: '#EC6C00',     边框线颜色
                    pattern: 'weibolgimg',     //将引入的图片的矢量图网元作为这个矢量图填充
                    //vectors-图形数组
                    v: [
                        {

                            shape: 'circle',    //图形形状，圆
                            r: 19,              //圆的半径
                            cx: 19,
                            cy: 19,
                            rotate: '<%= getClient("angle") %>',     //图形旋转角度，<%= getClient("变量") %>作为表达式，可以动态设置旋转角度，与下面的setClient('angle', 具体的值)相对应;
                            rotateOrigin:19                          //旋转的基点，设置为和半径等同则为绕中心旋转
                        }
                    ]
                });


                var weibosmimg = new Image();
                weibosmimg.src = '/img/focusNews-img/weibo2.png';
                weibosmimg.onload = function () {
                    weibosmimg.onload = null;
                    twaver.Util.registerImage('weibosmimg', weibosmimg, 30, 30);
                    network.invalidateElementUIs();
                };
                twaver.Util.registerImage('weibosm', {
                    w: 30,
                    h: 30,
                    origin: {
                        x: 0,
                        y: 0
                    },
                    pattern: 'weibosmimg',
                    v: [
                        {
                            shape: 'circle',
                            r: 15,
                            cx: 15,
                            cy: 15,
                            rotate: '<%= getClient("angle") %>',
                            rotateOrigin:15
                        }
                    ]
                });


                var weiboxsimg = new Image();
                weiboxsimg.src = '/img/focusNews-img/weibo3.png';
                weiboxsimg.onload = function () {
                    weiboxsimg.onload = null;
                    twaver.Util.registerImage('weiboxsimg', weiboxsimg, 24, 24);
                    network.invalidateElementUIs();
                };
                twaver.Util.registerImage('weiboxs', {
                    w: 24,
                    h: 24,
                    origin: {
                        x: 0,
                        y: 0
                    },
                    pattern: 'weiboxsimg',
                    v: [
                        {
                            shape: 'circle',
                            r: 12,
                            cx: 12,
                            cy: 12,
                            rotate: '<%= getClient("angle") %>',
                            rotateOrigin:12
                        }
                    ]
                });



                //动点矢量图
                var dongdian = new Image();
                dongdian.src = '/img/focusNews-img/runpoint.png';
                dongdian.onload = function () {
                    dongdian.onload = null;
                    twaver.Util.registerImage('dongdian', dongdian, 3, 26);
                    network.invalidateElementUIs();
                };
                twaver.Util.registerImage('dd', {
                    w: 3,
                    h: 26,
                    origin: {
                        x: 0,
                        y: 0
                    },
                    pattern: 'dongdian',
                    v: [
                        {
                            shape: 'rect',             //定义图形形状，长方形
                            rect: { w: 3, h: 26 },     //长方形的宽高
                            rotate: '<%= getClient("angle") %>',
                            rotateOrigin:0
                        }
                    ]
                });

                //画点
                //微博
                function drawNode(nodeName,wname,wImage,lx,ly,arr){
                    //new一个新的点，nodeName为node的名字
                    nodeName = new twaver.Node({
                        name: wname,      //设置node的name，也是node下面的文字的内容
                        Image: wImage,    //设置node的背景图片，即上面定义的矢量图的名字
                        location: {       //设置node的位置
                            x: lx,
                            y: ly
                        }
                    });
                        //将画的node存起来，要用的时候arr[i]即可得到相应的node
                    if(arr){
                        arr.push(nodeName);
                    }
                    //向容器中添加点
                    box.add(nodeName);
                }

                var nodeArr=[];
                var bbnode=[];
                var smnode=[];
                var xsnode=[];
                var yuan=null;
                var xuanzhuan=null;
                var ddArr=[];
                var lineArr=[];
                function readdnode(){
                    twaver.Util.stopAllAnimates();
                    for(var i=0;i<nodeArr.length;i++){
                        box.clear(nodeArr[i]);
                    }
                    if(ddArr){
                        for(var i=0;i<ddArr.length;i++){
                            box.clear(ddArr[i]);
                        }
                    }
                    if(xuanzhuan){
                        clearInterval(xuanzhuan);
                    }
                    if(lineArr){
                        for(var i=0;i<lineArr.length;i++){
                            box.clear(lineArr[i]);
                        }
                    }
                    //向容器中添加小旋风点
                    nodeArr=[];
                    bbnode=[];
                    smnode=[];
                    xsnode=[];
                    yuan=null;
                    function setrandom(max,min){
                        return Math.floor(Math.random()*(max-min+1)+min);
                    }
                    var pos=[];
                    //给每个小旋风一个随机的位置
                    for(var i=0;i<20;i++){
                        pos.push({x:setrandom(600,20),y:setrandom(350,20)});
                    }
                    for(var i=0;i<graphNodes.length;i++){
                        if(graphNodes[i]['id']==weiboUser){
                            bbnode.push(graphNodes[i]);
                            //把转发源名字保存下来
                            yuan=graphNodes[i]['id'];
                        }
                    }

                    for(var i=0;i<graphNodes.length;i++){
                        if(parseInt(graphNodes[i]['viz_size'])==52){
                            smnode.push(graphNodes[i]);
                        }
                    }

                    var zhongjie=[];
                    for(var j=0;j<graphEdges.length;j++){
                        if(graphEdges[j]['target']==yuan){    //graphNodes[i]['id']
                            //取得路径中target是发送源的那些
                            zhongjie.push(graphEdges[j]);
                        }
                    }
                    for(var i=0;i<graphNodes.length;i++){
                        for(var j=0;j<zhongjie.length;j++){
                            if(zhongjie[j]['source']==graphNodes[i]['id']){
                                xsnode.push(graphNodes[i]);
                            }
                        }
                    }
                    //画最大的点
                    for(var i=0;i<bbnode.length;i++){
                        //给每一个小旋风点不一样的nodeName，用来区分使用
                        var nodeName='node'+i+'bb';
                        //根据阿里接口的size数值的大小画不同大小的小旋风点
                        //drawNode(nodeName,bbnode[i].id,'weibolg',getPos(bbnode[i]['viz_position_x']),getPos(bbnode[i]['viz_position_y']),nodeArr);
                        drawNode(nodeName,bbnode[i].id,'weibolg',360,210,nodeArr);
                    }

                    //for(var i=0;i<smnode.length;i++){
                    //    //给每一个小旋风点不一样的nodeName，用来区分使用
                    //    var nodeName='node'+i+'sm';
                    //    //根据阿里接口的size数值的大小画不同大小的小旋风点
                    //    drawNode(nodeName,smnode[i].id,'weibosm',getPos(smnode[i]['viz_position_x']),getPos(smnode[i]['viz_position_y']),nodeArr);
                    //}


                    //随机取小点中的n个加到页面中
                    //在所有小点中取得随机点在其中的位置
                    var xsrannode=[];
                    var xsransize = xsnode.length-1;
                    if(xsransize > 50)
                    {
                        xsransize = 20;
                    }
                    for(var i=0;i<xsransize;i++){
                        if(xsnode.length>50)
                        {
                            xsrannode.push(setrandom(xsnode.length-1,0));
                        }
                        else {
                            xsrannode.push(i);
                        }

                    }
                    //xsnode.length=20;
                    //console.log(xsrannode.length);
                    for(var i=0;i<xsrannode.length;i++){
                        //给每一个小旋风点不一样的nodeName，用来区分使用
                        var nodeName='node'+i+'xs';
                        //根据阿里接口的size数值的大小画不同大小的小旋风点
                        //drawNode(nodeName,xsnode[i]['id'],'weiboxs',getPos(xsnode[i]['viz_position_x']),getPos(xsnode[i]['viz_position_y']),nodeArr);
                        try {
                            drawNode(nodeName,xsnode[xsrannode[i]]['id'],'weiboxs',pos[i].x,pos[i].y,nodeArr);
                        }
                        catch(e) {
                            //console.log(e);
                        }
                    }
                    //由于阿里接口给的位置有正有负，且值很大，所以在使用前重新计算位置
                    function getPos(position){
                        return Math.abs(parseInt(position)/2.2);
                    }
                    //小旋风旋转
                    var angvalue=0;
                    xuanzhuan=setInterval(function () {
                        for(var i=0;i<nodeArr.length;i++){
                            nodeArr[i].setClient('angle',angvalue);
                        }
                        angvalue+=10;
                    }, 50);


                    //得到路径目标是随机点的那些
                    var lujin=[];
                    for(var i=0;i<nodeArr.length;i++){
                        for(var j=0;j<zhongjie.length;j++){
                            if(zhongjie[j]["source"]==nodeArr[i]['_name']){
                                lujin.push(zhongjie[j]);
                            }
                        }
                    }

                    //画线
                    lineArr=[];
                    function drawLine(nodefrom,nodeto){
                        createLink(nodefrom,nodeto,lineArr);
                    }
                    //根据阿里接口的target和source与画点时给的node的name值对应
                    //graphEdges.length=20;
                    for(var i=0;i<lujin.length;i++){
                        for(var j=0;j<nodeArr.length;j++){
                            if(lujin[i]['target']==nodeArr[j]['_name']){
                                var nodefromName=nodeArr[j];
                                for(var k=0;k<nodeArr.length;k++){
                                    if(lujin[i]['source']==nodeArr[k]['_name']){
                                        var nodetoName=nodeArr[k];
                                        drawLine(nodefromName,nodetoName);
                                    }
                                }
                            }
                        }
                    }

                    //先将动点全部画好，放在画布以外的位置
                    ddArr=[];
                    for(var i=0;i<lujin.length;i++){
                        var ddName='node'+i;
                        drawNode(ddName,'','dd',-10,-10,ddArr);
                    }
                    //drawNode('node111','','dd',600,50);
                    //ddArr[0].setClient('ang', 0);

                    //动点的动画方法
                    function makedd(fromx,fromy,tox,toy,dd,delayTime,durTime,intervalTime){
                        new twaver.Animate({
                            from: { x: fromx, y: fromy },       //起始点
                            to: { x: tox, y: toy },             //结束点
                            type: 'point',
                            delay: delayTime,   //延迟时间
                            dur: durTime,       //持续时间
                            interval:intervalTime,    //播放间隔时间
                            easing: 'easeOut',
                            repeat:Number.POSITIVE_INFINITY,       //动画重复次数，Number.POSITIVE_INFINITY为无限次
                            reverse:false,                         //动画重复时，from和to值是否调换，也就是第二次动画是从结束状态变化到起始状态，默认值为true
                            onUpdate: function (value) {
                                dd.setLocation(value.x, value.y);       //更新时动态设置动点的位置
                            },
                            onDone:function(){
                                box.remove(dd);         //动画结束时删除这个node
                            }
                        })
                            .play();        //动画执行
                    }


                    var which=0;
                    for(var i=0;i<lujin.length;i++){
                        for(var j=0;j<nodeArr.length;j++){
                            if(nodeArr[j]['_image']=='weibolg'){
                                if(lujin[i]['target']==nodeArr[j]['_name']){
                                    //得到发射点网元的中心点位置
                                    var fromposx=nodeArr[j].getCenterLocation().x;
                                    var fromposy=nodeArr[j].getCenterLocation().y;
                                    for(var k=0;k<nodeArr.length;k++){
                                        if(nodeArr[k]['_image']=='weiboxs'){
                                            if(lujin[i]['source']==nodeArr[k]['_name']){
                                                var toposx=nodeArr[k].getCenterLocation().x;
                                                var toposy=nodeArr[k].getCenterLocation().y;
                                                var xbian=fromposx-toposx;
                                                var ybian=fromposy-toposy;
                                                var ang=Math.asin(xbian/Math.sqrt((xbian*xbian)+(ybian*ybian)));
                                                if(ybian>0){
                                                    ddArr[i].setClient('angle', 180/Math.PI*-ang);
                                                }else if(ybian<0){
                                                    ddArr[i].setClient('angle', (180/Math.PI*ang)+180);
                                                }
                                                makedd(fromposx,fromposy,toposx,toposy,ddArr[i],0,2000,0);
                                            }
                                        }
                                    }
                                }
                                }
                            }
                        }

                        //添加两点之间的连接线
                        function createLink(from, to, arr , color, type) {
                            var link = new twaver.Link(from, to);
                            link.setStyle('link.looped.type', "rectangle");
                            link.setStyle('link.color', "#242754");
                            link.setStyle('link.width',1);
                            if (type) {
                                link.setStyle('link.type', type);
                            }
                            if (color) {
                                link.setStyle('link.color', color);
                            }
                            box.add(link);
                            if(arr){
                                arr.push(link);
                            }
                            return link;
                        }
                }
                readdnode();
                setInterval(function(){
                    readdnode();
                },3600000)
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