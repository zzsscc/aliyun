//获取竞品列表 GET
function ajaxPSget(){
    $.ajax({
        url: 'http://192.168.3.44:8080/topic/list',
        type: 'get',
        dataType: 'json',
        data: {

        },
        success:function(data){
            console.log(data);
            //这是放置所有竞品的数组
            var psArr = [];
            for(var i=0;i<data.length;i++){
                //专题
                if(data[i].topicType === 0){
                    $('.topic-dialog .d-m-select').text(data[i].topicName);
                    $('.topic-dialog .d-m-select').data('topicId',data[i].topicId);
                    $('.island2 .i-title').text(data[i].topicName);
                    $('.island2 .i-title').data('topicId',data[i].topicId);
                }
                //竞品
                else{
                    //竞品要判断启动
                    if(data[i].topicStatus === 1){
                        psArr.push(data[i]);
                    }
                }
            }
            //拿到竞品的数组
            for(var j=0;j<psArr.length;j++){
                var str = '<li '+"data-id="+psArr[j].topicId+'>'+psArr[j].topicName+'</li>';
                $('.d-m-drapDown').append(str);
            }

            //绑定事件
            $('.d-m-drapDown li').on('click',function(){
                $('.drap-name').text($(this).text());
                PSID = $(this).attr('data-id');
            });

        },
        error: function () {
            console.log('获取竞品列表出错了');
        }
    });
}
ajaxPSget();

//提交用户选中的竞品和专题
function ajaxPSpost(str){
    $.ajax({
        url: 'http://192.168.3.44:8080/competition/update',
        type: 'post',
        dataType: 'json',
        data: {
            info:str
        },
        success:function(data){
            console.log(data);
        },
        error: function () {
            console.log('获取竞品列表出错了');
        }
    });
}




//全局变量 点击的竞品img
var PSIndex;
//全局变量 下拉框中选中的竞品的ID
var PSID;
//全局变量 选取对象的数组
var resultArr = [];  //数组最后会有很多个相同相同相同的对象，请根据 PSIndex / position 只取一个

//下拉框
$('.drap').on('click',function(){
    $('.d-m-drapDown').toggle();
});


//视图展示
//专题对话框 show
$('.ps-topic').on('click',function(){
    $('.topic-dialog').show();
    zutiYulanImg();
});

//d-close cancel
//专题对话框 hide
$('.topic-dialog .d-close').on('click',function(){
    $('.topic-dialog').hide();
});



//竞品对话框 show
$('.product').on('click',function(){
    var index = $(this).index();
    PSIndex = index;
    $('.product-dialog').show();
    psYulanImg();
});
//竞品对话框 hide
$('.product-dialog .d-close').on('click',function(){
    $('.product-dialog').hide();
});


//对话框预览图片
function zutiYulanImg(){
    $('.topic-dialog #d-img-url').on('change',function(){
            var val = $('.topic-dialog #d-img-url').val();
            $('.topic-dialog .d-m-img').attr('src',val);
    });
}
function psYulanImg(){
    $('.product-dialog #d-img2-url').on('change',function(){
        var val = $('.product-dialog #d-img2-url').val();
        $('.product-dialog .d-m-img').attr('src',val);
    });
}

//专题对话框点击确定按钮
$('.topic-dialog .ok').on('click',function(){
    //专题文字
    var text = $('.topic-dialog .d-m-select').text();
    var url= $('#d-img-url').val();
    $('.island2 .i-title').text(text);
    //background: url("http://img4.imgtn.bdimg.com/it/u=1000471642,1164149058&fm=11&gp=0.jpg");
    //$('.ps-topic').attr('src',url);
    $('.ps-topic').css({
        background:'url('+url+')',
        backgroundSize:'100% 100%',
        backgroundRepeat:'no-repeat'
    });
    //提交修改内容
    var obj = {};
    obj.topicId = $('.island2 .i-title').data('topicId');
    obj.position =  -1;
    obj.imgUrl = url;
    obj.name = $('.island2 .i-title').text();

    resultArr.push(obj);

    ajaxPSpost(JSON.stringify(resultArr));

    $('.topic-dialog').hide();
});


//竞品对话框点击确定按钮
$('.product-dialog .ok').on('click',function(){
    if($('.drap-name').text() !== '选择竞品'){
        var text = $('.drap-name').text();
        var url= $('#d-img2-url').val();
        //改变文字
        switch (PSIndex){
            case 0: $('.island1 .i-title').text(text); break;
            case 1: $('.port1').text(text); break;
            case 2: $('.port2').text(text); break;
            case 3: $('.port3').text(text); break;
            case 4: $('.island3 .i-title').text(text); break;
            case 5: $('.port4').text(text); break;
            case 6: $('.island4 .i-title').text(text); break;
            default : console.log('希望你不要看到我'); break;
        }
        //$('.img-ct img').eq(PSIndex).attr('src',url);
        $('.img-ct .product').eq(PSIndex).css({
            background:'url('+url+')',
            backgroundSize:'100% 100%'
        });

        //提交修改内容
        var obj = {};
        obj.topicId = PSID;
        obj.position =  PSIndex;
        obj.imgUrl = url;
        obj.name = $('.drap-name').text();
        resultArr.push(obj);
        ajaxPSpost(JSON.stringify(resultArr));

        PSID = '';
    }
    $('.product-dialog').hide();


});