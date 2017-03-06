
var vb = new Vue({
    el:'#main',
    data:{
        name:'天台县旅游局',
        verifiedReason:'天台县旅游局官方微博',
        description:'#最美杜鹃# 天台华顶云锦杜鹃四月底将盛开。一起来看看全国还有哪些美丽的杜鹃花。动动手指，选出你心目中最美的杜鹃花。',
        profileImageURL:'../img/头像.png',
        //simpleReport:'',
        newExp:22536477,
        newForward:6477,
        newOneF:4077,
        newTwoF:1457,
        newThreeF:543,
        keyArr:[],
        items:[]
    }
});
function getshuju() {
        $.ajax({
            type: "GET",
            //async: false,
            url: "http://192.168.3.7:8080/rest/v1/weiboAnalysis",
            dataType: "jsonp",
            jsonp: "callback",
            jsonpCallback:"flightHandler",
            success: function (response) {
                if(response.success===true && response.result.data !==null){
                    console.log('分析完成');
                    //微博账户名
                    vb.name = response.result.uInfo.name ;
                    //微博已证信息
                    vb.verifiedReason = response.result.uInfo.verifiedReason;
                    //微博具体描述
                    //67是文字的上限
                    if(response.result.uInfo.description.length>67){
                        var realStr = response.result.uInfo.description.substr(0,67);
                        realStr = realStr +'...';
                        vb.description = realStr;
                    }
                    else{
                        vb.description = response.result.uInfo.description;
                    }
                    //微博logo
                    vb.profileImageURL = response.result.uInfo.profileImageURL;

                    //一堆信息
                    vb.simpleReport = response.result.simpleReport;
                    //'消息曝光量<span title="曝光量表示所有转发用户的总粉丝数">404536</span>，' +
                    //'共计转发<b>35</b>次，其中一转<b>17</b>次，' +
                    //'二转<b>16</b>次，三转<b>1</b>次，北京、浙江、上海地区参与转发人数较多。用户情绪指数为<b>99</b>，' +
                    //'传递了超强的正能量。没有发现任何疑似水军。'
                    if(vb.simpleReport){
                        var re = />-?\d+</g;
                        var arr = vb.simpleReport.match(re);
                        //arr=[">404536<", ">35<", ">17<", ">16<", ">1<", ">99<"]
                        var reArr = [];
                        for(var i=0;i<arr.length;i++){
                            var num = /-?\d+/g;
                            var a =arr[i].match(num);
                            reArr.push(a);
                        }
                        //reArr=[[404536][35][17][16][1][99]]
                        //根据数组长度，改变一转二转三转的数字
                        function choose() {
                            //[[404536][35][17][16][1][99]] 一共三转
                            if (reArr.length === 6) {
                                //新闻曝光量
                                vb.newExp = reArr[0][0];
                                //新闻转发量
                                vb.newForward = reArr[1][0];
                                //一转
                                vb.newOneF = reArr[2][0];
                                //二转
                                vb.newTwoF = reArr[3][0];
                                //三转
                                vb.newThreeF = reArr[4][0];
                                //用户情绪指数
                                vb.userEmotion = reArr[5][0];
                            }
                            //[[404536][35][17][18][99]] 一共二转
                            else if (reArr.length === 5) {
                                //新闻曝光量
                                vb.newExp = reArr[0][0];
                                //新闻转发量
                                vb.newForward = reArr[1][0];
                                //一转
                                vb.newOneF = reArr[2][0];
                                //二转
                                vb.newTwoF = reArr[3][0];
                                //三转
                                vb.newThreeF = 0;
                                //用户情绪指数
                                vb.userEmotion = reArr[4][0];
                            }
                            //[[404536][35][35][99]] 一共一转
                            else if (reArr.length === 4) {
                                //新闻曝光量
                                vb.newExp = reArr[0][0];
                                //新闻转发量
                                vb.newForward = reArr[1][0];
                                //一转
                                vb.newOneF = reArr[2][0];
                                //二转
                                vb.newTwoF = 0;
                                //三转
                                vb.newThreeF = 0;
                                //用户情绪指数
                                vb.userEmotion = reArr[3][0];
                            }
                        }


                        choose ();

                        //情绪图赋值数值
                        emotionIndexChartOption.series[0].data[0].value = vb.userEmotion;
                        function changeColor() {
                            //情绪图改变颜色
                            if(vb.userEmotion<-100 || vb.userEmotion>100){
                                console.log('用户情绪指数不在-100~100之间');
                            }
                            else if (vb.userEmotion < -50 ) {
                                //改变绿色部分的数值
                                emotionIndexChartOption.series[0].axisLine.lineStyle.color[0][0] = (parseFloat(vb.userEmotion) + 100) / 200;
                                //把蓝色部分改为灰色
                                emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][1] = '#393a5a';
                                //再把粉色部分改为灰色
                                emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][1] = '#393a5a';
                                //重绘情绪指数图
                                emotionIndexChart.setOption(emotionIndexChartOption);
                            }
                            else if(vb.userEmotion < 0 && vb.userEmotion>=-50){
                                //改变蓝色部分的数值
                                emotionIndexChartOption.series[0].axisLine.lineStyle.color[1][0] = (parseFloat(vb.userEmotion) + 100) / 200;
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
                            else if (vb.userEmotion >= 0) {
                                //改变粉色部分的数值
                                emotionIndexChartOption.series[0].axisLine.lineStyle.color[2][0] = (parseFloat(vb.userEmotion) + 100) / 200;
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
                    vb.keyArr = response.result.data.top100User;

                    //72小时转播图

                    //每隔个8小时显示一次  也就是每隔48个十分钟显示一次 [0] [47] [95] [143] [191] [239] [287] [335] [383] [431]
                    var len = response.result.data.timeList.length;
                    var cirArr = [48,96,144,192,240,288,336,384,len];
                    //x轴
                    chart72hOption.xAxis[0].data = [];
                    function xAx(){
                        chart72hOption.xAxis[0].data.push(response.result.data.timeList[0].x);
                        for(var i=0;i<cirArr.length;i++){
                            var index = cirArr[i] - 1;
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
                            cirArr = [48,96,144,192,240,288,336,384,len];
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
                    if(areaMap.length>8){
                        areaMap.length=8;
                    }
                    for(var i=0;i<areaMap.length;i++ ){
                        total = total + areaMap[i].value;
                    }
                    for(var j=0;j<areaMap.length;j++){
                        areaMap[j].value = (areaMap[j].value/total*100).toFixed(2) + "%";
                        for(var i=0;i<visitorsTrackPoption.dataRange.splitList.length;i++){
                            if(visitorsTrackPoption.dataRange.splitList[i].label === areaMap[j].key){
                                visitorsTrackPoption.dataRange.splitList[i].color= '#19647b';
                                if(j === 0){
                                    visitorsTrackPoption.dataRange.splitList[i].color= '#08475a';
                                }
                            }
                        }
                    }
                    MapChart.setOption(visitorsTrackPoption);
                    vb.items = areaMap;
                    for(var i=0 ; i<vb.items.length;i++){
                        if(i===0){
                            vb.items[i].isA = true;
                        }else if(i<vb.items.length-1){
                            vb.items[i].isB = true;
                        }else {
                            vb.items[i].isC = true;
                        }
                    }
                    //console.log($('.color'));
                    //for(var i=0;i<$dark.length;i++){
                    //    if(i===0){
                    //        $dark[i].addClass('dark-color');
                    //    }else if(i<$dark.length-1){
                    //        $dark[i].addClass('medium-color');
                    //    }else{
                    //        $dark[i].addClass('tint-color');
                    //    }
                    //}

                    //var mapFirst = response.result.data.areaMap[0].key;
                    //var mapSecond = response.result.data.areaMap[1].key;
                    //var mapNumArr = [];
                    //for(var i=0;i<response.result.data.areaMap.length;i++){
                    //    mapNumArr.push(response.result.data.areaMap[i].value);
                    //    alert(mapNumArr);
                    //}
                    //var mapsunArr = eval(mapNumArr.join('+'));
                }



                //if(response.success===true && response.result.graphNodes !==null && response.result.graphEdges !==null) {
                //    var graphNodes = JSON.parse(response.result.graphNodes);
                //    var graphEdges = JSON.parse(response.result.graphEdges);
                //    console.log(graphNodes.length);
                //    console.log(graphEdges.length);
                //
                //
                //    var box = new twaver.ElementBox();
                //    var network = new twaver.vector.Network(box);
                //    var view = network.getView();
                //    document.getElementById('dianlutu').appendChild(view);
                //
                //    network.adjustBounds({x: 0, y: 0, width: 710, height: 410});
                //
                //    twaver.Styles.setStyle('label.color','#6ad0c5');
                //    twaver.Styles.setStyle('select.color','transparent');
                //
                //    //小旋风矢量图
                //    var weibobimg = new Image();
                //    weibobimg.src = '../img/微博1无发光.png';
                //    weibobimg.onload = function () {
                //        weibobimg.onload = null;
                //        twaver.Util.registerImage('weibolgimg', weibobimg, 38, 38);
                //        network.invalidateElementUIs();
                //    };
                //    twaver.Util.registerImage('weibolg', {
                //        w: 38,
                //        h: 38,
                //        //shadowOffsetX: 0,
                //        //shadowOffsetY: 0,
                //        //shadowBlur: 5,
                //        //shadowColor: '#fccedb',
                //        origin: {
                //            x: 0,
                //            y: 0
                //        },
                //        pattern: 'weibolgimg',
                //        v: [
                //            {
                //                shape: 'circle',
                //                r: 19,
                //                cx: 19,
                //                cy: 19,
                //                rotate: '<%= getClient("angle") %>',
                //            }
                //        ]
                //    });
                //
                //
                //    var weibosmimg = new Image();
                //    weibosmimg.src = '../img/微博2无发光.png';
                //    weibosmimg.onload = function () {
                //        weibosmimg.onload = null;
                //        twaver.Util.registerImage('weibosmimg', weibosmimg, 30, 30);
                //        network.invalidateElementUIs();
                //    };
                //    twaver.Util.registerImage('weibosm', {
                //        w: 30,
                //        h: 30,
                //        origin: {
                //            x: 0,
                //            y: 0
                //        },
                //        pattern: 'weibosmimg',
                //        v: [
                //            {
                //                shape: 'circle',
                //                r: 15,
                //                cx: 15,
                //                cy: 15,
                //                rotate: '<%= getClient("angle") %>',
                //            }
                //        ]
                //    });
                //
                //
                //    var weiboxsimg = new Image();
                //    weiboxsimg.src = '../img/微博3无发光.png';
                //    weiboxsimg.onload = function () {
                //        weiboxsimg.onload = null;
                //        twaver.Util.registerImage('weiboxsimg', weiboxsimg, 24, 24);
                //        network.invalidateElementUIs();
                //    };
                //    twaver.Util.registerImage('weiboxs', {
                //        w: 24,
                //        h: 24,
                //        origin: {
                //            x: 0,
                //            y: 0
                //        },
                //        pattern: 'weiboxsimg',
                //        v: [
                //            {
                //                shape: 'circle',
                //                r: 12,
                //                cx: 12,
                //                cy: 12,
                //                rotate: '<%= getClient("angle") %>',
                //            }
                //        ]
                //    });
                //
                //
                //    //动点矢量图
                //    //var dongdian = new Image();
                //    //dongdian.src = '../img/路径点.png';
                //    //dongdian.onload = function () {
                //    //    dongdian.onload = null;
                //    //    twaver.Util.registerImage('dongdian', dongdian, 32, 32);
                //    //    network.invalidateElementUIs();
                //    //};
                //    //twaver.Util.registerImage('dd', {
                //    //    w: 32,
                //    //    h: 32,
                //    //    //shadowOffsetX: 0,
                //    //    //shadowOffsetY: 0,
                //    //    //shadowBlur: 5,
                //    //    //shadowColor: '#fccedb',
                //    //    origin: {
                //    //        x: 0,
                //    //        y: 0
                //    //    },
                //    //    pattern: 'dongdian',
                //    //    v: [
                //    //        {
                //    //            shape: 'rect',
                //    //            rect: { w: 32, h: 32 },
                //    //        }
                //    //    ]
                //    //});
                //
                //    //小圆点动点矢量图
                //    twaver.Util.registerImage('dd', {
                //        w: 6,
                //        h: 6,
                //        //shadowOffsetX: 0,
                //        //shadowOffsetY: 0,
                //        //shadowBlur: 5,
                //        //shadowColor: '#fccedb',
                //        origin: {
                //            x: 0,
                //            y: 0
                //        },
                //        fill: '#fff',
                //        v: [
                //            {
                //                shape: 'circle',
                //                r: 3,
                //                cx: 3,
                //                cy: 3
                //            }
                //        ]
                //    });
                //
                //
                //    //画点
                //    //微博
                //    var nodeArr=[];
                //    function drawNode(nodeName,wname,wImage,lx,ly,arr){
                //        nodeName = new twaver.Node({
                //            name: wname,
                //            Image: wImage,
                //            location: {
                //                x: lx,
                //                y: ly
                //            }
                //        });
                //        if(arr){
                //            arr.push(nodeName);
                //        }
                //        box.add(nodeName);
                //    }
                //    for(var i=0;i<graphNodes.length;i++){
                //        var nodeName='node'+i;
                //        graphNodes[i].name=nodeName;
                //        if(parseInt(graphNodes[i]['viz_size'])==100){
                //            drawNode(nodeName,graphNodes[i].id,'weibolg',getPos(graphNodes[i]['viz_position_x']),getPos(graphNodes[i]['viz_position_y']),nodeArr);
                //            //drawNode(nodeName+1,'','dongdian',Math.abs(parseInt(graphNodes[i]['viz_position_x'])/2.2),Math.abs(parseInt(graphNodes[i]['viz_position_y'])/2.2));
                //        }else if(parseInt(graphNodes[i]['viz_size'])==52){
                //            drawNode(nodeName,graphNodes[i].id,'weibosm',getPos(graphNodes[i]['viz_position_x']),getPos(graphNodes[i]['viz_position_y']),nodeArr);
                //        }else {
                //            drawNode(nodeName,graphNodes[i].id,'weiboxs',getPos(graphNodes[i]['viz_position_x']),getPos(graphNodes[i]['viz_position_y']),nodeArr);
                //        }
                //    }
                //    //重新计算位置
                //    function getPos(position){
                //        return Math.abs(parseInt(position)/2.2);
                //    }
                //    //画线
                //    function drawLine(nodefrom,nodeto){
                //        createLink(nodefrom,nodeto);
                //    }
                //    for(var i=0;i<graphEdges.length;i++){
                //        for(var j=0;j<nodeArr.length;j++){
                //            if(graphEdges[i]['target']==nodeArr[j]['_name']){
                //                var nodefromName=nodeArr[j];
                //                for(var k=0;k<nodeArr.length;k++){
                //                    if(graphEdges[i]['source']==nodeArr[k]['_name']){
                //                        var nodetoName=nodeArr[k];
                //                        drawLine(nodefromName,nodetoName);
                //                    }
                //                }
                //            }
                //        }
                //    }
                //
                //
                //    //动点
                //    //var ddArr=[];
                //    //drawNode('node111','','dd',100,100,ddArr);
                //    ////ddArr[0].setClient('ang', 0);
                //
                //    //var interval={};
                //    //interval.timer=setInterval(function () {
                //        var ddArr=[];
                //        drawNode('node111','','dd',getPos(994.4762)+17,getPos(-493.86407)+17,ddArr);
                //        //ddArr[0].setClient('ang', 0);
                //
                //        new twaver.Animate({
                //            from: { x: getPos(994.4762)+17, y: getPos(-493.86407)+17 },
                //            to: { x: getPos(456.20563)+13, y: getPos(-304.26956)+13 },
                //            type: 'point',
                //            //delay: 1000,
                //            dur: 1000,
                //            easing: 'easeNone',
                //            repeat:Number.POSITIVE_INFINITY,
                //            reverse:false,
                //            onUpdate: function (value) {
                //                ddArr[0].setLocation(value.x, value.y);
                //            },
                //            onDone:function(){
                //                box.remove(ddArr[0]);
                //            }
                //        })
                //            //.chain()
                //            .play();
                //    //}, 1000);
                //
                //    //window.onVisibilityChanged=function(){
                //    //    clearInterval(interval.timer);
                //    //};
                //
                //
                //
                //    //setInterval(function () {
                //    //    for(var j=0;j<nodeArr.length;j++){
                //    //        nodeArr[j].setClient('angle', 10);
                //    //    }
                //    //}, 1000);
                //
                //    //var node1 = new twaver.Node({
                //    //    name: '网易新闻',
                //    //    Image: 'weibolgimg',
                //    //    location: {
                //    //        x: 420,
                //    //        y: 270
                //    //    }
                //    //});
                //    //box.add(node1);
                //
                //    //var node2 = new twaver.Node({
                //    //    name: '人民网',
                //    //    Image: 'weibosmimg',
                //    //    location: {
                //    //        x: 365,
                //    //        y: 150
                //    //    }
                //    //});
                //    //box.add(node2);
                //    //createLink(node1, node2, "#242754");
                //    //
                //    //var node3 = new twaver.Node({
                //    //    name: '中国网',
                //    //    Image: 'weibosmimg',
                //    //    location: {
                //    //        x: 330,
                //    //        y: 225
                //    //    }
                //    //});
                //    //box.add(node3);
                //    //createLink(node1, node3, "#242754");
                //    //
                //    //var node4 = new twaver.Node({
                //    //    name: '紫色梦想网',
                //    //    Image: 'weiboxsimg',
                //    //    location: {
                //    //        x: 475,
                //    //        y: 165
                //    //    }
                //    //});
                //    //box.add(node4);
                //    //createLink(node2, node4, "#242754");
                //
                //
                //    //添加两点之间的连接线
                //    function createLink(from, to, color, type) {
                //        var link = new twaver.Link(from, to);
                //        link.setStyle('link.looped.type', "rectangle");
                //        link.setStyle('link.color', "#242754");
                //        link.setStyle('link.width',1);
                //        //link.setStyle('link.handler.fill',true);
                //        //link.setStyle('link.handler.fill.color',"red");
                //        //link.setStyle('link.handler.gradient',"linear.east");
                //        //link.setStyle('link.handler.gradient.color',"green");
                //        if (type) {
                //            link.setStyle('link.type', type);
                //        }
                //        if (color) {
                //            link.setStyle('link.color', color);
                //        }
                //        box.add(link);
                //        return link;
                //    }
                //}
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