
//    获取微博列表
function ajaxGetWbList(){
    $.ajax({
        url: 'http://192.168.3.44:8080/weiboAnalysis/list',
        type: 'get',
        dataType: 'json',
        data: {

        },
        success: function (data) {
            console.log('这是微博列表的数据：');
            console.log(data);

//                先清空
            $('.list').html('');

//            遍历数组，组装字符串
            for(var i=0;i<data.length;i++){
                var wbId = data[i].id;
                var weiboUser = data[i].weiboUser;
                var weiboDesc = data[i].weiboDesc;
                var weiboUrl = data[i].weiboUrl;
                var showStatus = data[i].showStatus;

                var str = '<li class="item clearfix" data-id="'+wbId+'" data-show="'+showStatus+'">'
                    +'<div class="item-checkbox"><input type="checkbox"></div>'
                    +'<div class="item-history clearfix">'
                    +'<img class="item-img">'
                    +'<div class="item-information">'
                    +'<div class="wb-name">'+weiboUser+'</div>'
                    +'<div>2016-10-13&nbsp;14:46:24&nbsp;<a href="'+weiboUrl+'" class="wb-link" target="_blank">微博链接</a></div>'
                    +'<div class="item-in">'+weiboDesc+'</div>'
                    +'</div>'
                    +'</div>'
                    +'<div class="item-ctrl clearfix">'
                    +'<div class="big-show-btn">大屏展示</div>'
                    +'<div class="big-preview"><a href="./focusNews.html">大屏预览</a></div>'
                    +'<div class="edit-btn">重新分析</div>'
                    +'<div class="del">删除</div>'
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
        },
        error: function () {
            console.log('获取微博列表出错了');
        }
    });
}
ajaxGetWbList();

//    添加新微博
function ajaxAddNewWb(weiboUser,weiboDesc,weiboUrl){
    $.ajax({
        url: 'http://192.168.3.44:8080/weiboAnalysis/add',
        type: 'post',
        dataType: 'json',
        data: {
            weiboUrl:weiboUrl
        },
        success: function (data) {
            ajaxGetWbList();
            console.log(data.length); //true
        },
        error: function () {
            console.log('添加新微博出错了');
        }
    });
}

//    设置大屏展示
function ajaxBigScreenShow(id,showStatus){
    console.log(id);
    console.log(showStatus);
    $.ajax({
        url: 'http://192.168.3.44:8080/weiboAnalysis/update',
        type: 'post',
        dataType: 'json',
        data: {
            id:id,
            showStatus:showStatus
        },
        success: function (data) {
            ajaxGetWbList();
            console.log(data); //true
        },
        error: function () {
            console.log('设置大屏展示出错了');
        }
    });
}

//    分析/重新分析
function ajaxReAnalysis(id){
    $.ajax({
        url: 'http://192.168.3.44:8080/weiboAnalysis/refreshAnalysis',
        type: 'post',
        dataType: 'json',
        data: {
            id:id
        },
        success: function (data) {
            console.log(data); //true
        },
        error: function () {
            console.log('分析出错了');
        }
    });
}

//    删除微博
function ajaxDeleteWb(id){
    $.ajax({
        url: 'http://192.168.3.44:8080/weiboAnalysis/delete',
        type: 'post',
        dataType: 'json',
        data: {
            id:id
        },
        success: function (data) {
            console.log(data); //true
            ajaxGetWbList();
        },
        error: function () {
            console.log('删除微博出错了');
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
    addWBhide('.addWb .save');
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
        console.log(selectItem);
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
        $('.item .big-show-btn').removeClass('show-active').text('大屏展示').attr('data-show',0);
        $(this).addClass('show-active').text('取消展示').attr('data-show',1);

        //发送大屏展示ajax
        console.log($(this).attr('data-show'));
        ajaxBigScreenShow($(this).attr('data-id'),$(this).attr('data-show'));
        //$('.item .big-show-btn').off();

        //if($(this).data('show')){
        //    $(this).removeClass('show-active');
        //    $(this).text('大屏展示');
        //    $(this).data('show',false);
        //}
        //else{
        //    $(this).addClass('show-active');
        //    $(this).text('取消展示');
        //    $(this).data('show',true);
        //}

    });
    <!--保存元素-->
    var saveClone = $('.item').eq(0).clone(true);
    <!--添加新微博的逻辑-->
    $('.addWb .save').on('click',function(){
        var name = $('.addWb .d-m-name').find('input').val();
        var introduce = $('.addWb .d-m-right').find('textarea').val();
        var link = $('.addWb .d-m-link').find('input').val();
        if(name){
//          如果.item不存在，就是全部都删除光了
            if($('.list').children().length === 0){
                $(saveClone).find('.wb-name').text(name);
                $(saveClone).find('.item-in').text(introduce);
                $(saveClone).find('.wb-link').attr('href',link);
                //$('.list').append(saveClone);
                //发送添加微博ajax
                //ajaxAddNewWb(weiboUser,weiboDesc,weiboUrl);
                ajaxAddNewWb(name,introduce,link);
                //$('.addWb .save').off();
            }
            else {
//          克隆对象
                var clone = $('.item').eq(0).clone(true);
//            clone是原生的dom对象
                $(clone).find('.wb-name').text(name);
                $(clone).find('.item-in').text(introduce);
                $(clone).find('.wb-link').attr('href',link);
                //$('.list').append(clone);
                //发送添加微博ajax
                ajaxAddNewWb(name,introduce,link);
                //$('.addWb .save').off();
            }
        }
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