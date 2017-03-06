var pagesize=5;
var pagenum=1;
var initTotal=null;

//出现自定义模态框
function showM3(str){
    $('body').addClass('modal-open');
    $('#myModal3').addClass('in');
    $('#myModal3').attr('aria-hidden',false);
    $('#myModal3').show();
    $('#myModal3 .modal-body').text(str);
}
//隐藏自定义模态框
function hideM3(){
    $('body').removeClass('modal-open');
    $('#myModal3').removeClass('in');
    $('#myModal3').attr('aria-hidden',true);
    $('#myModal3').hide();
    $('#myModal3 .modal-body').text('');
}


function showTips(str){
    $('body').addClass('modal-open');
    $('#tipsModal').addClass('in');
    $('#tipsModal').attr('aria-hidden',false);
    $('#tipsModal').show();
    $('#tipsModal .modal-body').text(str);
}
//隐藏自定义模态框
function hideTips(){
    $('body').removeClass('modal-open');
    $('#tipsModal').removeClass('in');
    $('#tipsModal').attr('aria-hidden',true);
    $('#tipsModal').hide();
    $('#tipsModal .modal-body').text('');
}

//    获取微博列表
function ajaxGetWbList(){
    showLoading();
    $.ajax({
        url: '/weiboAnalysis/list',
        type: 'get',
        dataType: 'json',
        data: {
            pageNum: pagenum,
            pageSize: pagesize
        },
        success: function (data) {
            hideLoading();

            var dataList=data['list'];
            initTotal=Math.ceil((data.total)/pagesize);

//                先清空
            $('.list').html('');

//            遍历数组，组装字符串
            for(var i=0;i<dataList.length;i++){
                var wbId = dataList[i].id;
                var weiboHeadImg = dataList[i].weiboHeadImg;
                var weiboUser = dataList[i].weiboUser;
                var weiboDesc = dataList[i].weiboDesc;
                var weiboCreateTime = dataList[i].weiboCreateTime;
                var weiboUrl = dataList[i].weiboUrl;
                var showStatus = dataList[i].showStatus;

                var str = '<li class="item clearfix" data-id="'+wbId+'" data-show="'+showStatus+'">'
                    +'<div class="item-checkbox"><input type="checkbox"></div>'
                    +'<div class="item-history">'
                    +'<img class="item-img" src="'+weiboHeadImg+'">'
                    +'<div class="item-information">'
                    +'<div class="wb-name">'+weiboUser+'</div>'
                    +'<div>'+weiboCreateTime+'<a href="'+weiboUrl+'" class="wb-link" target="_blank">&nbsp;&nbsp;微博链接</a></div>'
                    +'<div class="item-in">'+weiboDesc+'</div>'
                    +'</div>'
                    +'</div>'
                    +'<div class="item-ctrl">'
                    +'<div class="row">';
                //analysisResultId,只在分析结果拿到以后才会更新
                if(dataList[i].analysisResultId != null &&dataList[i].analysisResultId!="")
                {
                    if(showStatus==1)
                    {
                        str = str+'<button class="big-show-btn btn btn-cyan btn-ef btn-ef-7 btn-ef-7h btn-sm me" data-id="'+wbId+'" data-status="'+showStatus+'">'+'<i class="fa fa-desktop"></i>'+'取消展示</button>';

                    }
                    else {
                        str = str+'<button class="big-show-btn btn btn-cyan btn-ef btn-ef-7 btn-ef-7h btn-sm me" data-id="'+wbId+'" data-status="'+showStatus+'">'+'<i class="fa fa-desktop"></i>'+'大屏展示</button>';

                    }
                    str = str +'<button class="big-preview btn btn-default btn-ef btn-ef-7 btn-ef-7h btn-sm me">'+'<i class="fa fa-eye"></i>'+'<a target="_blank" href="/weiboAnalysis/preview?previewId='+dataList[i].analysisId+'">大屏预览</a></button>';
                    // str = str +'<div class="edit-btn"><a>重新分析</a></div>';
                }
                else{
                    // str = str +'<div class="edit-btn">分析中</div>';
                    //如果分析中,请求ajax,刷新状态
                    $.ajax({
                            url: '/weiboAnalysis/refreshAnalysisStatus',
                            type: 'post',
                            dataType: 'json',
                            data: {
                                analysisId:dataList[i].analysisId
                            },
                            success: function (data) {
                                if (data) {
                                    ajaxGetWbList();
                                }
                            }
                        }
                    );
                }
                str = str +'<button class="del btn btn-default btn-ef btn-ef-7 btn-ef-7h btn-sm me" data-toggle="modal" data-target="#myModal2">'+'<i class="fa fa-trash-o"></i>'+'删除</button>'
                    +'</div>'
                    +'</div>'
                    +'</li>';

                $('.list').append($(str));
            }

            $('.item .edit-btn').off();
            $('.item .big-show-btn').off();
            $('.save').off();
//            重新绑定
            bind();
            //    分页切换
            $('#page-wrap').jqPaginator({
                totalPages: initTotal,
                visiblePages: initTotal,
                currentPage: pagenum,
                onPageChange: function (num, type) {
                    pagenum=num;
                    ajaxGetWbList();
                }
            });
        },
        error: function () {
            hideLoading();
        }
    });
}
ajaxGetWbList();

function ajaxCheckAnalysisCount(weiboUrl)
{
    showLoading();
    $.ajax({
        url: '/weiboAnalysis/checkAnalysisCount',
        type: 'get',
        dataType: 'json',
        data: {
            url:weiboUrl
        },
        success: function (data) {
            hideLoading();
            if(data.success=='true'){
                showTips("本次分析将消耗"+data.result+"配额，确定分析？");
            }else{
                showM3(data.message);
                //alert(data.message);
            }
        },
        error: function () {
            hideLoading();
        }
    });
}

//    添加新微博
function ajaxAddNewWb(weiboUser,weiboDesc,weiboUrl){
    showLoading();
    $.ajax({
        url: '/weiboAnalysis/add',
        type: 'post',
        dataType: 'json',
        data: {
            weiboUrl:weiboUrl
        },
        success: function (data) {
            hideLoading();
            if(data.success=='true'){
                pagenum=1;
                ajaxGetWbList();
                $('#myModal').modal('hide');
            }else{
                showM3(data.message);
                //alert(data.message);
            }
        },
        error: function () {
            hideLoading();
        }
    });
}

//    设置大屏展示
function ajaxBigScreenShow(id,showStatus){
    showLoading();
    $.ajax({
        url: '/weiboAnalysis/update',
        type: 'post',
        dataType: 'json',
        data: {
            id:id,
            showStatus:showStatus
        },
        success: function (data) {
            hideLoading();
            pagenum=1;
            ajaxGetWbList();
            //console.log(data); //true
        },
        error: function () {
            hideLoading();
        }
    });
}

//    分析/重新分析
function ajaxReAnalysis(id){
    showLoading();
    $.ajax({
        url: '/weiboAnalysis/refreshAnalysis',
        type: 'post',
        dataType: 'json',
        data: {
            id:id
        },
        success: function (data) {
            //console.log(data); //true
            hideLoading();
        },
        error: function () {
            //console.log('分析出错了');
            hideLoading();
        }
    });
}

//    删除微博
function ajaxDeleteWb(id){
    showLoading();
    $.ajax({
        url: '/weiboAnalysis/delete',
        type: 'post',
        dataType: 'json',
        data: {
            id:id
        },
        success: function (data) {
            hideLoading();
            //console.log(data); //true
            pagenum=1;
            ajaxGetWbList();
        },
        error: function () {
            hideLoading();
        }
    });
}

//  绑定事件函数
function bind(){
    function show (){
        var length = $('.list .item').length;
        for( var i=0;i<length;i++){
            if($('.item').eq(i).attr('data-show')===1){
                //$('.item').eq(i).find('.big-show-btn').addClass('show-active').text('取消展示');
                $('.item').eq(i).find('.big-show-btn').text('取消展示');
            }
        }
    }
    show ();
    <!--全局变量-->
    var selectItem ;
    $('#myModal3').on('click',function(){
        hideM3();
    });
    $('#myModal3 .modal-content').on('click',function(e){
        e.stopPropagation();
    });
    $('#myModal3 .cancel').on('click',function(){
        hideM3();
    });
    <!--分页样式-->
    $('.page-wrap li').on('click',function(){
        var length = $('.page-wrap li').length;
        if(this === $('.page-wrap li')[0]){
            return;
        }
        else if(this === $('.page-wrap li')[length-1]){
            return;
        }
        else{
            $('.page-wrap li').removeClass('active');
            $(this).addClass('active');
        }
    });
    <!--对话框的视图展现-->
    $('.add-keyword').on('click',function(){
        $('#myModal input').val('');
    });
//     删除微博对话框 show
    $('.item .del').on('click',function(){
        selectItem = $(this).parents('.item').index();
    });

    <!--大屏展示逻辑-->
    $('.item .big-show-btn').on('click',function(){
        //展示状态
        if($(this).attr('data-status') == 0)
        {
            //$(this).addClass('show-active').text('取消展示').attr('data-show',1);
            $(this).text('取消展示').attr('data-show',1);
        }
        else {
            //$(this).removeClass('show-active').text('大屏展示').attr('data-show',0);
            $(this).text('大屏展示').attr('data-show',0);
        }
        //发送大屏展示ajax
        ajaxBigScreenShow($(this).attr('data-id'),$(this).attr('data-show'));

    });
    <!--保存元素-->
    <!--添加新微博的逻辑-->
    $('#myModal .save').on('click',function(){
        var link = $('#myModal .d-m-link').find('input').val();
        //判断输入的微博是否符合规则
        var re = /^http:\/\/(www\.)*weibo\.com\/(\d{8,10})\/(\w{9}).*/g;
        if(re.test(link)){
            ajaxCheckAnalysisCount(link);
        }
        else{
            showM3('微博地址非法，请按照提示的规则输入正确的地址');
        }
    });

    $('#tipsModal .save').on('click',function(){
        var link = $('#myModal .d-m-link').find('input').val();
        //判断输入的微博是否符合规则
        var re = /^http:\/\/(www\.)*weibo\.com\/(\d{8,10})\/(\w{9}).*/g;
        if(re.test(link)){
            ajaxAddNewWb("","",link);
            hideTips();
        }
        else{
            showM3('微博地址非法，请按照提示的规则输入正确的地址');
        }
    });

    $('#tipsModal .cancel').on('click',function(){
        hideTips();
    });

    <!--删除微博的逻辑-->
    $('#myModal2 .save').on('click',function(){
        //发送删除微博ajax
        ajaxDeleteWb($('.item').eq(selectItem).attr('data-id'));
    });
}

bind();



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