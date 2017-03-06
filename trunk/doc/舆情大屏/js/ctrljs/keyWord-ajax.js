//专题全局变量
var zt=$('.zt');
var ztID=null;
//zt.find('li').on('click',function(){
//    $(this).siblings().removeClass('active');
//    $(this).addClass('active');
//    ztID=$(this).data('data-topicId');
//})
var topicLisClo0=$(zt.find('li')[0]).clone(true);
//关键字列表全局变量
var list=$('.list');
//操作下拉框
var dropDown=$('.drop-down');
////专题切换，保存专题名
//var ztID=null;
//function toggleZt(){
//    var ztLi=zt.find('li');
//    if(ztID==null) {
//        ztID = $(ztLi[0]).data('data-topicId');
//    }
//    for(var i=0;i<ztLi.length;i++){
//        $(ztLi[i]).click(function(){
//            for(var i=0;i<ztLi.length;i++){
//                $(ztLi[i]).removeClass('active');
//            }
//            $(this).addClass('active');
//            ztID=$(this).data('data-topicId');
//            console.log(ztID);
//        })
//    }
//}
$.ajax({
    type: "GET",
    //async: false,
    //url: "http://192.168.3.44:10086/topic/list",
    url: "http://121.40.197.218:8080/topic/list",
    //url: "js/focusNewsjs/aj.json",
    //dataType: "json",
    //jsonp: "callback",
    //jsonpCallback:"flightHandler",
    success: function (response) {
        console.log(response);
        var responsezt=[];
        var responsejpkai=[];
        var responsejpguan=[];
        for(var i=0;i<response.length;i++){
            if(response[i].topicType==1 && response[i].topicStatus==1){
                responsejpkai.push(response[i]);
            }else if(response[i].topicType==1 && response[i].topicStatus==0){
                responsejpguan.push(response[i]);
            }else if(response[i].topicType==0){
                responsezt.push(response[i]);
            }
        }
        console.log(responsezt);
        console.log(responsejpkai);
        console.log(responsejpguan);
        var cc=response;
        zt.html('');
        var topicName= null;
        var topicId = null;
        var topicStatus = null;
        var topicType = null;
        if(responsezt.length==0){
            topicName='自身品牌';
            topicId = 'wu';
            topicStatus = 'wu';
            topicType = 'wu';
            topicLisClo0.text(topicName);
            topicLisClo0.data('data-topicId',topicId);
            topicLisClo0.data('data-topicStatus',topicStatus);
            topicLisClo0.data('data-topicType',topicType);
            zt.append(topicLisClo0);
        }
        for(var i=0;i<response.length;i++){
            topicName=response[i].topicName;
            topicId = response[i].id;
            topicStatus = response[i].topicStatus;
            topicType = response[i].topicType;
            console.log(topicType);
            if(i==0){
                topicLisClo0.text(topicName);
                topicLisClo0.data('data-topicId',topicId);
                topicLisClo0.data('data-topicStatus',topicStatus);
                topicLisClo0.data('data-topicType',topicType);
                zt.append(topicLisClo0);
            }else{
                var topicLisClo=$(zt.find('li')[0]).clone(true);
                topicLisClo.text(topicName);
                topicLisClo.data('data-topicId',topicId);
                topicLisClo.data('data-topicStatus',topicStatus);
                topicLisClo.data('data-topicType',topicType);
                zt.append(topicLisClo);
            }
        }
        zt.find('li').on('click',function(){
            $(this).siblings().removeClass('active');
            $(this).addClass('active');
            ztID=$(this).data('data-topicId');
            $('#checkboxAll2').attr('checked',false);
            console.log(cc);
            getgjzshuju();
            //console.log($(this).data('data-topicType'));
            if($(this).data('data-topicType')==0){
                dropDown.find('li').hide();
                $(dropDown.find('li')[0]).show();
                $(dropDown.find('li')[3]).show();
            }else if($(this).data('data-topicType')==1){
                dropDown.find('li').hide();
                $(dropDown.find('li')[0]).show();
                $(dropDown.find('li')[2]).show();
                $(dropDown.find('li')[4]).show();
            }
            //console.log(ztID);
        });
        $(zt.find('li')[0]).click();
        //getgjzshuju();
        //alert(zt.find('li:last-child').data('data-topicStatus'))
    },
    error: function () {
        alert('fail');
    }
});



function getztshuju() {
     $.ajax({
         type: "GET",
         //async: false,
         //url: "http://192.168.3.44:10086/topic/list",
         url: "http://121.40.197.218:8080/topic/list",
         //url: "js/focusNewsjs/aj.json",
         //dataType: "json",
         //jsonp: "callback",
         //jsonpCallback:"flightHandler",
         success: function (response) {
             console.log(response);
             var cc=response;
             zt.html('');
                 for(var i=0;i<response.length;i++){
                     var topicName=response[i].topicName;
                     var topicId = response[i].id;
                     var topicStatus = response[i].topicStatus;
                     var topicType = response[i].topicType;
                     console.log(topicType);
                     if(i==0){
                         topicLisClo0.text(topicName);
                         topicLisClo0.data('data-topicId',topicId);
                         topicLisClo0.data('data-topicStatus',topicStatus);
                         topicLisClo0.data('data-topicType',topicType);
                         zt.append(topicLisClo0);
                     }else{
                         var topicLisClo=$(zt.find('li')[0]).clone(true);
                         topicLisClo.text(topicName);
                         topicLisClo.data('data-topicId',topicId);
                         topicLisClo.data('data-topicStatus',topicStatus);
                         topicLisClo.data('data-topicType',topicType);
                         zt.append(topicLisClo);
                     }
                 }
             zt.find('li').on('click',function(){
                 $(this).siblings().removeClass('active');
                 $(this).addClass('active');
                 ztID=$(this).data('data-topicId');
                 $('#checkboxAll2').attr('checked',false);
                 console.log(cc);
                 getgjzshuju();
                 //console.log($(this).data('data-topicType'));
                 if($(this).data('data-topicType')==0){
                     dropDown.find('li').hide();
                     $(dropDown.find('li')[0]).show();
                     $(dropDown.find('li')[3]).show();
                 }else if($(this).data('data-topicType')==1){
                     dropDown.find('li').hide();
                     $(dropDown.find('li')[0]).show();
                     $(dropDown.find('li')[2]).show();
                     $(dropDown.find('li')[4]).show();
                 }
                 //console.log(ztID);
             });
             for(var i=0;i<zt.find('li').length;i++){
                 //console.log(ztID);
                 //console.log($(zt.find('li')[i]).data('data-topicId'));
                 if($(zt.find('li')[i]).data('data-topicId')==ztID){
                     $(zt.find('li')[i]).siblings().removeClass('active');
                     $(zt.find('li')[i]).addClass('active');
                     $(zt.find('li')[i]).click();
                 }
             }
             //$(zt.find('li')[0]).click();
             //getgjzshuju();
             //alert(zt.find('li:last-child').data('data-topicStatus'))
         },
         error: function () {
             alert('fail');
         }
     });
 }





function getgjzshuju() {
    $.ajax({
        type: "GET",
        //async: false,
        //url: "http://192.168.3.44:10086/keyword/list",
        url: "http://121.40.197.218:8080/keyword/list",
        data: {
            topicId: ztID
        },
        //url: "js/focusNewsjs/aj.json",
        //dataType: "json",
        //jsonp: "callback",
        //jsonpCallback:"flightHandler",
        success: function (response) {
            console.log(response);
            list.html('<li class="item clearfix">'+
                '<div class="item-checkbox"><input type="checkbox" name="subcheck2" class="checkboxs-in2"></div>'+
                '<div class="item-name">贵州茅台1</div>'+
                '<div class="item-source">新闻，论坛，贴吧，微博，微信，政府，视频</div>'+
                '<div class="item-twrap"><span class="item-data">2016-10-12&nbsp;11:32:05</span></div>'+
                '<div class="item-ctrl clearfix"><div class="change">编辑</div> <div class="del">删除</div></div>'+
                '</li>');
            var kwLisClo0=$(list.find('li')[0]).clone(true);
            list.html('');
            for(var i=0;i<response.length;i++){
                var kwName=response[i].keyword;
                var kwId = response[i].id;
                var kwTopicId = response[i].topicId;
                var kwSiteTypeIds = response[i].siteTypeIds;
                var kwDate = response[i].createTime;
                console.log(kwTopicId);
                //var sub=kwSiteTypeIds.split(",");
                //var typeIdsArr=[];
                //var value = text.replace(/[^0-9]/ig,"");
                //console.log(sub);
                var typeIdsJson=eval(kwSiteTypeIds);
                var typeIdsStr=JSON.stringify(typeIdsJson);
                typeIdsStr = typeIdsStr.replace(/[3][8]/,'视频');
                typeIdsStr = typeIdsStr.replace(/[3][7]/,'政府');
                typeIdsStr = typeIdsStr.replace(/[3][5]/,'微信');
                typeIdsStr = typeIdsStr.replace(/[3][4]/,'微博');
                typeIdsStr = typeIdsStr.replace(/[3][0]/,'贴吧');
                typeIdsStr = typeIdsStr.replace(/[2][6]/,'论坛');
                typeIdsStr = typeIdsStr.replace(/[3]/,'新闻');
                typeIdsStr = typeIdsStr.replace(/\,/ig,'，');
                typeIdsStr = typeIdsStr.replace(/\[/,'');
                typeIdsStr = typeIdsStr.replace(/\]/,'');
                if(i==0){
                    kwLisClo0.find('.item-name').text(kwName);
                    kwLisClo0.find('.item-source').text(typeIdsStr);
                    kwLisClo0.find('.item-data').html(formatDay(kwDate)+'&nbsp;'+formatTime(kwDate));
                    //kwLisClo0.find('.item-data').text(unix_to_datetime(kwDate));
                    //kwLisClo0.find('.item-data').text(kwDate);
                    kwLisClo0.data('data-kwId',kwId);
                    kwLisClo0.data('data-kwTopicId',kwTopicId);
                    kwLisClo0.data('data-kwSiteTypeIds',typeIdsStr);
                    list.prepend(kwLisClo0);
                }else{
                    var kwLisClo=$(list.find('li')[0]).clone(true);
                    kwLisClo.find('.item-name').text(kwName);
                    kwLisClo.find('.item-source').text(typeIdsStr);
                    kwLisClo.find('.item-data').html(formatDay(kwDate)+'&nbsp;'+formatTime(kwDate));
                    //kwLisClo.find('.item-data').text(unix_to_datetime(kwDate));
                    //kwLisClo.find('.item-data').text(kwDate);
                    kwLisClo.data('data-kwId',kwId);
                    kwLisClo.data('data-kwTopicId',kwTopicId);
                    kwLisClo.data('data-kwSiteTypeIds',typeIdsStr);
                    list.prepend(kwLisClo);
                }
            }
            shijian();
        },
        error: function () {
            alert('fail');
        }
    });
}

//function getfxkshuju() {
//    $.ajax({
//        type: "GET",
//        //async: false,
//        url: "http://192.168.3.44:8080/rest/v1/systemSite",
//        //data: {
//        //    topicId:1
//        //},
//        //url: "js/focusNewsjs/aj.json",
//        //dataType: "json",
//        //jsonp: "callback",
//        //jsonpCallback:"flightHandler",
//        success: function (response) {
//            console.log(response);
//        },
//        error: function () {
//            alert('fail');
//        }
//    });
//}
//getfxkshuju();


