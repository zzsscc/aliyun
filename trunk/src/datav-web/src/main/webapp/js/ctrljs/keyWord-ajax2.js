//专题全局变量
var zt=$('.zt');
var ztID=null;

var topicLisClo0=$(zt.find('li')[0]).clone(true);
//关键字列表全局变量
var list=$('.list');
//操作下拉框
var dropDown=$('.drop-down');

//引导内容
//无专题
var noZt=$('.no-zt');
var noJp=$('.no-jp');
var noGjz=$('.no-gjz');
var shownormal=$('.normal');
//隐藏所有引导
function hideNo(){
    noZt.hide();
    noJp.hide();
    noGjz.hide();
    shownormal.hide();
}

//专题的方法
function getallTab(shuju){
    //console.log(shuju);
    var responsezt=[];
    var responsejpzong=[];
    var responsejpkai=[];
    var responsejpguan=[];
    for(var i=0;i<shuju.length;i++){
        if(shuju[i].topicType==1 && shuju[i].topicStatus==1){
            responsejpkai.push(shuju[i]);
        }else if(shuju[i].topicType==1 && shuju[i].topicStatus==0){
            responsejpguan.push(shuju[i]);
        }else if(shuju[i].topicType==0){
            responsezt.push(shuju[i]);
        }
    }
    for(var i=0;i<shuju.length;i++){
        if(shuju[i].topicType==1){
            responsejpzong.push(shuju[i]);
        }
    }
    zt.html('');
    var topicName= null;
    var topicId = null;
    var topicStatus = null;
    var topicType = null;
    var topicLisClo=null;
    if(responsezt.length==0  && responsejpzong.length==0){       //专题竞品都没有
        //添加专题引导
        topicName='自身品牌';
        topicId = 'wu';
        topicStatus = 'wu';
        topicType = '10';
        topicLisClo0.text(topicName);
        topicLisClo0.data('data-topicId',topicId);
        topicLisClo0.data('data-topicStatus',topicStatus);
        topicLisClo0.data('data-topicType',topicType);
        zt.append(topicLisClo0);
        //添加竞品引导
        topicName='其他关注品牌';
        topicId = 'wu';
        topicStatus = 'wu';
        topicType = '11';
        topicLisClo=$(zt.find('li')[0]).clone(true);
        topicLisClo.text(topicName);
        topicLisClo.data('data-topicId',topicId);
        topicLisClo.data('data-topicStatus',topicStatus);
        topicLisClo.data('data-topicType',topicType);
        zt.append(topicLisClo);
        hideNo();
        noZt.show();
    }else if(responsezt.length==0  && responsejpzong.length!=0){      //没有专题，有竞品
        //添加专题引导
        topicName='自身品牌';
        topicId = 'wu';
        topicStatus = 'wu';
        topicType = '10';
        topicLisClo0.text(topicName);
        topicLisClo0.data('data-topicId',topicId);
        topicLisClo0.data('data-topicStatus',topicStatus);
        topicLisClo0.data('data-topicType',topicType);
        zt.append(topicLisClo0);

        //添加已添加的竞品
        for (var i = 0; i < responsejpkai.length; i++) {
            topicName = responsejpkai[i].topicName;
            topicId = responsejpkai[i].id;
            topicStatus = responsejpkai[i].topicStatus;
            topicType = responsejpkai[i].topicType;
            //console.log(topicType);
            topicLisClo = $(zt.find('li')[0]).clone(true);
            topicLisClo.text(topicName);
            topicLisClo.data('data-topicId', topicId);
            topicLisClo.data('data-topicStatus', topicStatus);
            topicLisClo.data('data-topicType', topicType);
            zt.append(topicLisClo);
        }
        for (var i = 0; i < responsejpguan.length; i++) {
            topicName = responsejpguan[i].topicName;
            topicId = responsejpguan[i].id;
            topicStatus = responsejpguan[i].topicStatus;
            topicType = responsejpguan[i].topicType;
            //console.log(topicType);
            topicLisClo = $(zt.find('li')[0]).clone(true);
            topicLisClo.text(topicName);
            topicLisClo.data('data-topicId', topicId);
            topicLisClo.data('data-topicStatus', topicStatus);
            topicLisClo.data('data-topicType', topicType);
            topicLisClo.addClass('enabled');
            zt.append(topicLisClo);
        }
        hideNo();
        noZt.show();
    }else if(responsezt.length!=0  && responsejpzong.length==0) {      //有专题，没有竞品
        //添加已添加的专题
        for (var i = 0; i < responsezt.length; i++) {
            topicName = responsezt[i].topicName;
            topicId = responsezt[i].id;
            topicStatus = responsezt[i].topicStatus;
            topicType = responsezt[i].topicType;
            //console.log(topicType);
            topicLisClo0.text(topicName);
            topicLisClo0.data('data-topicId', topicId);
            topicLisClo0.data('data-topicStatus', topicStatus);
            topicLisClo0.data('data-topicType', topicType);
            zt.append(topicLisClo0);
        }

        //添加竞品引导
        topicName='其他关注品牌';
        topicId = 'wu';
        topicStatus = 'wu';
        topicType = '11';
        topicLisClo=$(zt.find('li')[0]).clone(true);
        topicLisClo.text(topicName);
        topicLisClo.data('data-topicId',topicId);
        topicLisClo.data('data-topicStatus',topicStatus);
        topicLisClo.data('data-topicType',topicType);
        zt.append(topicLisClo);
        hideNo();
        shownormal.show();
    }else if(responsezt.length!=0  && responsejpzong.length!=0) {                   //专题、竞品都有
        //添加已添加的专题
        for (var i = 0; i < responsezt.length; i++) {
            topicName = responsezt[i].topicName;
            topicId = responsezt[i].id;
            topicStatus = responsezt[i].topicStatus;
            topicType = responsezt[i].topicType;
            //console.log(topicType);
            topicLisClo0.text(topicName);
            topicLisClo0.data('data-topicId', topicId);
            topicLisClo0.data('data-topicStatus', topicStatus);
            topicLisClo0.data('data-topicType', topicType);
            zt.append(topicLisClo0);
        }

        //添加已添加的竞品
        for (var i = 0; i < responsejpkai.length; i++) {
            topicName = responsejpkai[i].topicName;
            topicId = responsejpkai[i].id;
            topicStatus = responsejpkai[i].topicStatus;
            topicType = responsejpkai[i].topicType;
            //console.log(topicType);
            topicLisClo = $(zt.find('li')[0]).clone(true);
            topicLisClo.text(topicName);
            topicLisClo.data('data-topicId', topicId);
            topicLisClo.data('data-topicStatus', topicStatus);
            topicLisClo.data('data-topicType', topicType);
            zt.append(topicLisClo);
        }
        for (var i = 0; i < responsejpguan.length; i++) {
            topicName = responsejpguan[i].topicName;
            topicId = responsejpguan[i].id;
            topicStatus = responsejpguan[i].topicStatus;
            topicType = responsejpguan[i].topicType;
            //console.log(topicType);
            topicLisClo = $(zt.find('li')[0]).clone(true);
            topicLisClo.text(topicName);
            topicLisClo.data('data-topicId', topicId);
            topicLisClo.data('data-topicStatus', topicStatus);
            topicLisClo.data('data-topicType', topicType);
            topicLisClo.addClass('enabled');
            zt.append(topicLisClo);
        }
        hideNo();
        shownormal.show();
    }

    zt.find('li').on('click',function(){
        $(this).siblings().removeClass('active');
        $(this).addClass('active');
        ztID=$(this).data('data-topicId');
        //console.log(ztID);
        $('#checkboxAll2').attr('checked',false);
        //console.log(cc);
        //console.log($(this).data('data-topicType'));
        if($(this).data('data-topicType')==0){
            dropDown.find('li').hide();
            $(dropDown.find('li')[0]).show();
            $(dropDown.find('li')[3]).show();
            $(dropDown.find('li')[5]).show();
            hideNo();
            shownormal.show();
            pagenum=1;
            getgjzshuju();
        }else if($(this).data('data-topicType')==1){
            dropDown.find('li').hide();
            $(dropDown.find('li')[0]).show();
            $(dropDown.find('li')[2]).show();
            $(dropDown.find('li')[4]).show();
            hideNo();
            shownormal.show();
            pagenum=1;
            getgjzshuju();
        }else if($(this).data('data-topicType')==10){
            dropDown.find('li').hide();
            hideNo();
            noZt.show();
        }else if($(this).data('data-topicType')==11){
            dropDown.find('li').hide();
            hideNo();
            noJp.show();
        }
        //console.log(ztID);
    });
}
function initGet(){
    showLoading();
    $.ajax({
        type: "GET",
        url: "/topic/list",
        success: function (response) {
            hideLoading();
            getallTab(response);
            $(zt.find('li')[0]).click();
        },
        error: function () {
            hideLoading();
            alert('fail');
        }
    });
}
initGet();


function getztshujuLIU() {
    showLoading();
     $.ajax({
         type: "GET",
         url: "/topic/list",
         success: function (response) {
             hideLoading();
             getallTab(response);

             //留在当前tab栏
             for(var i=0;i<zt.find('li').length;i++){
                 //alert(ztID);
                 //console.log(ztID);
                 //console.log($(zt.find('li')[i]).data('data-topicId'));
                 if($(zt.find('li')[i]).data('data-topicId')==ztID){
                     $(zt.find('li')[i]).siblings().removeClass('active');
                     $(zt.find('li')[i]).addClass('active');
                     $(zt.find('li')[i]).click();
                 }
             }
             // hideLoading();
         },
         error: function () {
             //alert('fail');
             hideLoading();
         }
     });
 }

function getztshujuQU() {
    showLoading();
    $.ajax({
        type: "GET",
        url: "/topic/list",
        success: function (response) {
            hideLoading();
            getallTab(response);
            //去到第一栏
            $(zt.find('li')[0]).click();
        },
        error: function () {
            //alert('fail');
            hideLoading();
        }
    });
}




var pagesize=15;
var pagenum=1;
var initTotal=null;
function getgjzshuju() {
    showLoading();
    $.ajax({
            type: "GET",
            url: "/keyword/list",
            data: {
                topicId: ztID,
                pageNum: pagenum,
                pageSize: pagesize
            },
            success: function (response) {
                //console.log(response);
                hideLoading();
                var responseList=response['list'];
                initTotal=Math.ceil((response.total)/pagesize);
                //console.log(initTotal);
                // showLoading();
                if(responseList.length==0) {
                    hideNo();
                    noGjz.show();
                }else{
                    list.html('<li class="item clearfix">'+
                        '<div class="item-checkbox"><input type="checkbox" name="subcheck2" class="checkboxs-in2"></div>'+
                        '<div class="item-name">贵州茅台1</div>'+
                        '<div class="item-source">新闻，论坛，贴吧，微博，微信，政府，视频</div>'+
                        '<div class="item-twrap"><span class="item-data">2016-10-12&nbsp;11:32:05</span></div>'+
                        '<div class="item-ctrl clearfix"><div class="change">编辑</div> <div class="del">删除</div></div>'+
                        '</li>');
                    var kwLisClo0=$(list.find('li')[0]).clone(true);
                    list.html('');
                    for(var i=0;i<responseList.length;i++){
                        var kwName=responseList[i].keyword;
                        var kwId = responseList[i].id;
                        var kwTopicId = responseList[i].topicId;
                        var kwSiteTypeIds = responseList[i].siteTypeIds;
                        var kwDate = responseList[i].createTime;
                        //console.log(kwTopicId);

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
                    hideNo();
                    shownormal.show();
                    $('.change').off();
                    $('.setup-popup').find('.sure-button').off();
                    $('.del').off();
                    $('.del-rule-popup').find('.sure-button').off();
                    shijian();
                    // hideLoading();
                    //    分页切换
                    if(initTotal>5){
                        $('#page-wrap').jqPaginator({
                            totalPages: initTotal,
                            visiblePages: 5,
                            currentPage: pagenum,
                            onPageChange: function (num, type) {
                                pagenum=num;
                                getgjzshuju();
                            }
                        });
                    }else{
                        $('#page-wrap').jqPaginator({
                            totalPages: initTotal,
                            visiblePages: initTotal,
                            currentPage: pagenum,
                            onPageChange: function (num, type) {
                                pagenum=num;
                                getgjzshuju();
                            }
                        });
                    }
                }
            },
            error: function () {
                hideLoading();
                alert('fail');
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





