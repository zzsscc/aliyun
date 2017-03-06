//专题全局变量
var zt=$('.zt');
var ztID=null;

var topicLisClo0=$(zt.find('li')[0]).clone(true);
//关键字列表全局变量
var list=$('.gjzlist');

//引导内容
//无专题
var noZt=$('.no-zt').parent();
var noGjz=$('.no-gjz').parent();
var shownormal=$('.normal');
var showAllnormal=$('.allnormal');
//隐藏所有引导
function hideNo(){
    noZt.hide();
    noGjz.hide();
    shownormal.hide();
}


//时间戳转换为时间格式，dateday为yyyy-mm-dd  datetime为h:m:s
var dateday=null;
var datetime=null
function formatDay(dateC) {
    var date=new Date(dateC);
    var y = date.getFullYear() + "-";
    var m = date.getMonth() + 1 + "-";
    var d = date.getDate();


    //字符串拼接
    var dateday = y + m + d;
    return dateday;
}
function formatTime(dateC) {
    var date=new Date(dateC);

    //当前小时大于12
    var h = date.getHours();
    //var am=h>12?" 下午 ":" 上午 ";
    //24小时制换为12小时制
    //h=h>12?h-12:h;
    //一位数小时数前加个0
    h = h < 10 ? "0" + h : "" + h;

    //一位数分钟数前加个0
    var mi = date.getMinutes();
    mi = mi < 10 ? "0" + mi : "" + mi;

    //一位数秒数前加个0
    var s = date.getSeconds();
    s = s < 10 ? "0" + s : "" + s;

    //字符串拼接
    var datetime = h + ":" + mi + ":" + s;
    return datetime;
}



//专题的方法
function getallTab(shuju){
    var responsejpzong=[];
    var responsejpkai=[];
    var responsejpguan=[];
    for(var i=0;i<shuju.length;i++){
        if(shuju[i].topicType==1 && shuju[i].topicStatus==1){
            responsejpkai.push(shuju[i]);
        }else if(shuju[i].topicType==1 && shuju[i].topicStatus==0){
            responsejpguan.push(shuju[i]);
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
    if(responsejpzong.length==0){       //竞品没有
        //添加竞品引导
        topicName='其他关注品牌';
        topicId = 'wu';
        topicStatus = 'wu';
        topicType = '11';
        topicLisClo0.find('a').text(topicName);
        topicLisClo0.find('a').data('data-topicId',topicId);
        topicLisClo0.find('a').data('data-topicStatus',topicStatus);
        topicLisClo0.find('a').data('data-topicType',topicType);
        zt.append(topicLisClo0);
        showAllnormal.hide();
        hideNo();
        noZt.show();
    }else if(responsejpzong.length!=0){      //有竞品
        //添加竞品引导
        topicName='其他关注品牌';
        topicId = 'wu';
        topicStatus = 'wu';
        topicType = '11';
        topicLisClo0.find('a').text(topicName);
        topicLisClo0.find('a').data('data-topicId',topicId);
        topicLisClo0.find('a').data('data-topicStatus',topicStatus);
        topicLisClo0.find('a').data('data-topicType',topicType);
        zt.append(topicLisClo0);

        //添加已添加的竞品
        for (var i = 0; i < responsejpkai.length; i++) {
            topicName = responsejpkai[i].topicName;
            topicId = responsejpkai[i].id;
            topicStatus = responsejpkai[i].topicStatus;
            topicType = responsejpkai[i].topicType;
            //console.log(topicType);
            topicLisClo = $(zt.find('li')[0]).clone(true);
            topicLisClo.find('a').text(topicName);
            topicLisClo.find('a').data('data-topicId', topicId);
            topicLisClo.find('a').data('data-topicStatus', topicStatus);
            topicLisClo.find('a').data('data-topicType', topicType);
            zt.append(topicLisClo);
        }
        for (var i = 0; i < responsejpguan.length; i++) {
            topicName = responsejpguan[i].topicName;
            topicId = responsejpguan[i].id;
            topicStatus = responsejpguan[i].topicStatus;
            topicType = responsejpguan[i].topicType;
            //console.log(topicType);
            topicLisClo = $(zt.find('li')[0]).clone(true);
            topicLisClo.find('a').text(topicName);
            topicLisClo.find('a').data('data-topicId', topicId);
            topicLisClo.find('a').data('data-topicStatus', topicStatus);
            topicLisClo.find('a').data('data-topicType', topicType);
            topicLisClo.find('a').addClass('enabled');
            zt.append(topicLisClo);
        }
        $(zt.find('li')[0]).remove();
        showAllnormal.show();
        hideNo();
        noZt.show();
    }

    zt.find('a').on('click',function(){
        $(this).parent().siblings().removeClass('active');
        $(this).parent().addClass('active');
        ztID=$(this).data('data-topicId');
        //console.log(ztID);
        $('#checkboxAll2').attr('checked',false);
        //console.log(cc);
        //console.log($(this).data('data-topicType'));
        if($(this).data('data-topicType')==1){
            hideNo();
            pagenum=1;
            getgjzshuju();
        }else if($(this).data('data-topicType')==11){
            hideNo();
            noZt.show();
        }
        //console.log(ztID);
    });
}


function initGet(){
    $.ajax({
        type: "GET",
        url: "/topic/list",
        success: function (response) {
            hideLoading();
            getallTab(response);
            $(zt.find('a')[0]).click();
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
            for(var i=0;i<zt.find('a').length;i++){
                //alert(ztID);
                //console.log(ztID);
                //console.log($(zt.find('li')[i]).data('data-topicId'));
                if($(zt.find('a')[i]).data('data-topicId')==ztID){
                    $(zt.find('li')[i]).siblings().removeClass('active');
                    $(zt.find('li')[i]).addClass('active');
                    $(zt.find('a')[i]).click();
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
            $(zt.find('a')[0]).click();
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
    //console.log(ztID);
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
                console.log(response['list']);
                hideLoading();
                var responseList=response['list'];
                initTotal=Math.ceil((response.total)/pagesize);
                //console.log(initTotal);
                // showLoading();
                if(responseList.length==0) {
                    hideNo();
                    noGjz.show();
                }else{
                    //list.html('<li class="item clearfix">'+
                    //    '<div class="item-checkbox"><input type="checkbox" name="subcheck2" class="checkboxs-in2"></div>'+
                    //    '<div class="item-name">贵州茅台1</div>'+
                    //    '<div class="item-source">新闻，论坛，贴吧，微博，微信，政府，视频</div>'+
                    //    '<div class="item-twrap"><span class="item-data">2016-10-12&nbsp;11:32:05</span></div>'+
                    //    '<div class="item-ctrl clearfix"><div class="change">编辑</div> <div class="del">删除</div></div>'+
                    //    '</li>');
                    list.html('<tr>'+
                        '<td class="item-name">3</td>'+
                        '<td class="item-source">Larry</td>'+
                        '<td class="item-data">the Bird</td>'+
                        '<td><button class="change btn btn-info btn-rounded-20 btn-ef btn-ef-5 btn-ef-5b mb-10" data-toggle="modal" data-target="#changeModal"><i class="fa fa-pencil"></i> <span>编辑</span></button>'+
                        '<button class="del btn btn-danger btn-rounded btn-ef btn-ef-5 btn-ef-5b mb-10" data-toggle="modal" data-target="#delModal"><i class="fa fa-trash"></i> <span>删除</span> </button></td>'+
                            '</tr>');
                    var kwLisClo0=$(list.find('tr')[0]).clone(true);
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
                        //console.log(typeIdsStr);
                        if(i==0){
                            kwLisClo0.find('.item-name').html(kwName);
                            kwLisClo0.find('.item-source').html(typeIdsStr);
                            kwLisClo0.find('.item-data').html(formatDay(kwDate)+'&nbsp;&nbsp;'+formatTime(kwDate));
                            //kwLisClo0.find('.item-data').text(unix_to_datetime(kwDate));
                            //kwLisClo0.find('.item-data').text(kwDate);
                            kwLisClo0.data('data-kwId',kwId);
                            kwLisClo0.data('data-kwTopicId',kwTopicId);
                            kwLisClo0.data('data-kwSiteTypeIds',typeIdsStr);
                            list.prepend(kwLisClo0);
                        }else{
                            var kwLisClo=$(list.find('tr')[0]).clone(true);
                            kwLisClo.find('.item-name').html(kwName);
                            kwLisClo.find('.item-source').html(typeIdsStr);
                            kwLisClo.find('.item-data').html(formatDay(kwDate)+'&nbsp;&nbsp;'+formatTime(kwDate));
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
                    $('#changeModal').find('.sure-button').off();
                    $('.del').off();
                    $('#delModal').find('.sure-button').off();
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





