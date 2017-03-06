var pagesize=5;
var pagenum=1;
var initTotal=null;
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
                    +'<div class="item-history clearfix">'
                    +'<img class="item-img" src="'+weiboHeadImg+'">'
                    +'<div class="item-information">'
                    +'<div class="wb-name">'+weiboUser+'</div>'
                    +'<div>'+weiboCreateTime+'<a href="'+weiboUrl+'" class="wb-link" target="_blank">&nbsp;&nbsp;微博链接</a></div>'
                    +'<div class="item-in">'+weiboDesc+'</div>'
                    +'</div>'
                    +'</div>'
                    +'<div class="item-ctrl clearfix">';
                //analysisResultId,只在分析结果拿到以后才会更新
                if(dataList[i].analysisResultId != null &&dataList[i].analysisResultId!="")
                {
                    if(showStatus==1)
                    {
                        str = str+'<div class="big-show-btn show-active" data-id="'+wbId+'" data-status="'+showStatus+'">取消展示</div>';
                    }
                    else {
                        str = str+'<div class="big-show-btn" data-id="'+wbId+'" data-status="'+showStatus+'">大屏展示</div>';
                    }
                    str = str +'<div class="big-preview"><a target="_blank" href="/weiboAnalysis/preview?previewId='+dataList[i].analysisId+'">大屏预览</a></div>';
                    // str = str +'<div class="edit-btn"><a>重新分析</a></div>';
                }
                else{
                    str = str +'<div class="edit-btn">分析中</div>';
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
                                    location.reload();
                                }
                            }
                        }
                    );
                }
                str = str +'<div class="del" data-toggle="modal" data-target="#myModal2">删除</div>'
                    +'</div>'
                    +'</li>';

                $('.list').append($(str));
            }

            $('.item .edit-btn').off();
            $('.item .big-show-btn').off();
            $('.addWb .save').off();
            $('.delWb .save').off();
//            重新绑定
            bind();
            //    分页切换
            $('#page-wrap').jqPaginator({
                totalPages: initTotal,
                visiblePages: initTotal,
                currentPage: pagenum,
                onPageChange: function (num, type) {
                    pagenum=num;
                    getgjzshuju();
                }
            });
        },
        error: function () {
            //console.log('获取微博列表出错了');
            hideLoading();
        }
    });
}
ajaxGetWbList();

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
                // addWBhide('.addWb .save');
                $('.addWb').hide();
                pagenum=1;
                ajaxGetWbList();
            }else{
                alert('请根据下面的提示，重新输入正确的微博地址');
            }
        },
        error: function () {
            //console.log('添加新微博出错了');
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
            //console.log('设置大屏展示出错了');
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
            //console.log('删除微博出错了');
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
                $('.item').eq(i).find('.big-show-btn').addClass('show-active').text('取消展示');
            }
        }
    }
    show ();
    <!--全局变量-->
    var selectItem ;
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
//    添加新微博对话框 show
    $('.add-keyword').on('click',function(){
        $('.addWb').show();
    });
//    隐藏添加新微博对话框 hide
    function addWBhide(str){
        $(str).on('click',function(){
            $('.addWb').hide();
        });
    }
    addWBhide('.addWb .d-close');
    //addWBhide('.addWb .save');
    addWBhide('.addWb .cancel');


//    编辑微博对话框 show
    $('.item .edit-btn').on('click',function(){
        selectItem = $(this).parents('.item').index();
        $('.item').eq(selectItem).find('.edit-btn').text('重新分析');

        //    发送 分析/重新分析 ajax
        //    ajaxReAnalysis(id);
        ajaxReAnalysis($('.item').eq(selectItem).attr('data-id'));
        //$('.item .edit-btn').off();

        //初始化对话框样式
        $('.editWb .cancel').text('取消');
        $('.editWb .cancel').css({
            color:'#000',
            backgroundColor:'#f2f2f2'
        });
        $('.editWb .editTitle').text('结果分析中......');
        $('.editWb').show();
        //        出现进度条
        $('.editWb .editBar').css({
            width:0
        });
        $('.editWb .editBar').animate({
            width:500
        },3000,function(){
            $('.editWb .editTitle').text('分析完成');
            $('.editWb .cancel').text('确定');
            $('.editWb .cancel').css({
                color:'#fff',
                backgroundColor:'#65bfff'
            });
        });
    });

//    隐藏编辑微博对话框 hide
    function editWbhide(str){
        $(str).on('click',function(){
            $('.editWb').hide();
            $('.editWb .editBar').stop();
        });
    }
    editWbhide('.editWb .d-close');
    editWbhide('.editWb .save');
    editWbhide('.editWb .cancel');


//     删除微博对话框 show
    $('.item .del').on('click',function(){
        selectItem = $(this).parents('.item').index();
        //console.log(selectItem);
        $('.delWb').show();
    });
//    隐藏删除微博对话框 hide
    function delWbhide(str){
        $(str).on('click',function(){
            $('.delWb').hide();
        });
    }
    delWbhide('.delWb .d-close');
    delWbhide('.delWb .save');
    delWbhide('.delWb .cancel');


//    批量删除微博对话框 show
    $('.del-all').on('click',function(){
        $('.delAllWb').show();
    });
//    隐藏 批量删除微博对话框 hide
    function delAllWbhide(str){
        $(str).on('click',function(){
            $('.delAllWb').hide();
        });
    }
    delAllWbhide('.delAllWb .d-close');
    delAllWbhide('.delAllWb .save');
    delAllWbhide('.delAllWb .cancel');
//    勾选批量删除事件
    $('.del-input').on('click',function(e){
//        打钩
        if(e.target.checked === true){
            $('.item').each(function(){
                $(this).find('input')[0].checked = true;
            });
        }
//        取消打钩
        else{
            $('.item').each(function(){
                $(this).find('input')[0].checked = false;
            });
        }
    });
    <!--大屏展示逻辑-->
    $('.item .big-show-btn').on('click',function(){
        //展示状态
        if($(this).attr('data-status') == 0)
        {
            $(this).addClass('show-active').text('取消展示').attr('data-show',1);
        }
        else {
            $(this).removeClass('show-active').text('大屏展示').attr('data-show',0);
        }


        //发送大屏展示ajax
        ajaxBigScreenShow($(this).attr('data-id'),$(this).attr('data-show'));

    });
    <!--保存元素-->
    var saveClone = $('.item').eq(0).clone(true);
    <!--添加新微博的逻辑-->
    $('.addWb .save').on('click',function(){
        // var name = $('.addWb .d-m-name').find('input').val();
        // var introduce = $('.addWb .d-m-right').find('textarea').val();
        var link = $('.addWb .d-m-link').find('input').val();
        // if(name){
//          如果.item不存在，就是全部都删除光了
            if($('.list').children().length === 0){
                // $(saveClone).find('.wb-name').text(name);
                // $(saveClone).find('.item-in').text(introduce);
                $(saveClone).find('.wb-link').attr('href',link);
                //$('.list').append(saveClone);
                //发送添加微博ajax
                //ajaxAddNewWb(weiboUser,weiboDesc,weiboUrl);
                ajaxAddNewWb("","",link);
                //$('.addWb .save').off();
            }
            else {
//          克隆对象
                var clone = $('.item').eq(0).clone(true);
//            clone是原生的dom对象
                // $(clone).find('.wb-name').text(name);
                // $(clone).find('.item-in').text(introduce);
                $(clone).find('.wb-link').attr('href',link);
                //$('.list').append(clone);
                //发送添加微博ajax
                ajaxAddNewWb("","",link);
                //$('.addWb .save').off();
            }
        // }
    });
    <!--删除微博的逻辑-->
    $('.delWb .save').on('click',function(){
        //$('.item').eq(selectItem).remove();
        //发送删除微博ajax
        //ajaxDeleteWb(id);
        ajaxDeleteWb($('.item').eq(selectItem).attr('data-id'));
        //$('.delWb .save').off();
    });

    <!--批量删除微博的逻辑-->
    $('.delAllWb .save').on('click',function(){
        $(".item .item-checkbox input[type='checkbox']:checked").parents('.item').remove();
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