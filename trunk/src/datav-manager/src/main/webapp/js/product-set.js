
//这个就是中转站的超级数组
var superArr = [];

//数组去重方法
function chuli(res){
    var returnArr = [];
    function jade(parm){
        for(var j=0;j<returnArr.length;j++){
            if(parm.position === returnArr[j].position){
                return { index : j };
            }
        }
        return false;
    }
    for(var i=0;i<res.length;i++){
        if(jade(res[i])){
//                找到之前的对象将它剔除
            var obj = jade(res[i]);
            returnArr.splice(obj.index,1);
//                加入后来的对象
            returnArr.push(res[i]);
        }
        else{
            returnArr.push(res[i]);
        }
    }
    return returnArr;
}

//放置竞品位置
function setPosition(paramArr){
    for(var i=0;i<paramArr.length;i++){
        //放置竞品位置
        switch (paramArr[i].position){
            case -1 :
                $('.ps-topic').css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                $('#d-img-url').val(paramArr[i].imgUrl);
                $('.topic-dialog .d-m-img').attr('src',paramArr[i].imgUrl);

                var topicText = paramArr[i].name;
                $('.island2 .i-title').text(topicText).attr('data-id',paramArr[i].topicId);

                break;

            case 0:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText0 = paramArr[i].name;
                $('.island1 .i-title').text(psText0).attr('data-id',paramArr[i].topicId);
                break;

            case 1:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText1 = paramArr[i].name;
                $('.port1').text(psText1).attr('data-id',paramArr[i].topicId);
                break;

            case 2:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText2 = paramArr[i].name;
                $('.port2').text(psText2).attr('data-id',paramArr[i].topicId);
                break;

            case 3:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText3 = paramArr[i].name;
                $('.port3').text(psText3).attr('data-id',paramArr[i].topicId);
                break;

            case 4:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText4 = paramArr[i].name;
                $('.island3 .i-title').text(psText4).attr('data-id',paramArr[i].topicId);
                break;

            case 5:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText5 = paramArr[i].name;
                $('.port4').text(psText5).attr('data-id',paramArr[i].topicId);
                break;
            case 6:
                $('.img-ct .product').eq(paramArr[i].position).css({
                    background:'url('+paramArr[i].imgUrl+')',
                    backgroundSize:'100% 100%'
                });
                var psText6 = paramArr[i].name;
                $('.island4 .i-title').text(psText6).attr('data-id',paramArr[i].topicId);
                break;
            default : console.log('希望你不要看到我'); break;
        }
    }
}


//获取之前用户设置过的竞品列表的信息 GET
///competition/list
//1
function ajaxPSList(){
    $.ajax({
        url: '/competition/list',
        type: 'get',
        dataType: 'json',
        data: {

        },
        success:function(data){
            ajaxPSget();
            if(data === []){
                //console.log('第一次刚进来这个页面');
                return;
            }

            //console.log(data);
            var res =  JSON.parse(data[0].info);

            //  千万别动这个函数，耗时近半个小时，有点绕   处理返回的数组 让每个位置（position）都只有一个对象
            var chulires = chuli(res);

            //每次都把超级数组赋值为用户设置过的竞品列表
            superArr = chulires || [];

            //console.log(chulires);

            //放置竞品位置
            //setPosition(chulires);

        },
        error: function () {
            //console.log('获取竞品列表出错了');
            ajaxPSget();
        }
    });
}
ajaxPSList();


//2
//获取竞品列表 GET 并通过upTopic()将皮球踢出去
function ajaxPSget(){
    $.ajax({
        url: '/topic/list',
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

                    //用户没有点击对话框的时候，也要往超级数组里放入专题信息的对象
                    upTopic();
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

            //取子集 放置位置
            var childArr = [];
            for(var i=0;i<superArr.length;i++){
                for(var j=0;j<psArr.length;j++){
                    if(superArr[i].topicId === psArr[j].topicId){
                        childArr.push(superArr[i]);
                    }
                }
            }
            setPosition(childArr);

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



//提交用户选中的竞品和专题
function ajaxPSpost(str){
    $.ajax({
        url: '/competition/update',
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
//var resultArr = [];

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
    //优化函数
    //'.island1 .i-title'
    function youhua(youhuaStr){
        //如果没有文字就触发
        if($(youhuaStr).text() === ''){
            $('.drap-name').text('选择竞品');
            $('#d-img2-url').val('');
            $('.product-dialog .d-m-img').attr('src','');
            $('.no').hide();
        }
        else{
            $('.drap-name').text($(youhuaStr).text());
            var str = $('.product')[index].style.background;
            var re = /\(.*\)/g;
            var tmp = str.match(re); //["("http://www.pp3.cn/uploads/allimg/111124/155ASV8-8.jpg")"]
            var str1 = tmp[0].replace('(','');
            var str2 = str1.replace(')',''); // ""http://www.pp3.cn/uploads/allimg/111124/155ASV8-8.jpg""
            var str3 = str2.substr(1,str2.length-2); //"http://www.pp3.cn/uploads/allimg/111124/155ASV8-8.jpg"
            $('#d-img2-url').val(str3);
            $('.product-dialog .d-m-img').attr('src',str3);
            $('.no').show();
            $('.no').off();
            $('.no').on('click',function(){
                //清空文字
                $(youhuaStr).text('');
                //清空背景图
                $('.img-ct .product')[index].style.background = '';
                $('.product-dialog').hide();
                function del(index){
                    for(var i=0;i<superArr.length;i++){
                        if(superArr[i].position === index ){
                            superArr.splice(i,1);
                            var chulisuperArr = chuli(superArr);
                            ajaxPSpost(JSON.stringify(chulisuperArr));
                        }
                    }
                }
                del(index); //例如index=2，删除第三个图
            });
        }
    }
    //优化交互效果
    switch (index){
        case 0:
            youhua('.island1 .i-title');
            break;
        case 1:
            youhua('.port1');
            break;
        case 2:
            youhua('.port2');
            break;
        case 3:
            youhua('.port3');
            break;
        case 4:
            youhua('.island3 .i-title');
            break;
        case 5:
            youhua('.port4');
            break;
        case 6:
            youhua('.island4 .i-title');
            break;
        default : console.log('希望你不要看到我'); break;
    }
    psYulanImg();
});

//竞品对话框 hide
$('.product-dialog .d-close').on('click',function(){
    $('.product-dialog').hide();
    PSID = '';
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


//提交专题
function upTopic(){
    var obj = {};
    obj.topicId = $('.island2 .i-title').data('topicId');
    obj.position =  -1;
    obj.imgUrl = $('#d-img-url').val();
    obj.name = $('.island2 .i-title').text();

    superArr.push(obj);
    var chulisuperArr = chuli(superArr);
    ajaxPSpost(JSON.stringify(chulisuperArr));
}



//专题对话框点击确定按钮
$('.topic-dialog .ok').on('click',function(){
    //专题文字
    var text = $('.topic-dialog .d-m-select').text();
    var url= $('#d-img-url').val();
    $('.island2 .i-title').text(text);
    $('.ps-topic').css({
        background:'url('+url+')',
        backgroundSize:'100% 100%',
        backgroundRepeat:'no-repeat'
    });

    //提交专题的方法
    upTopic();
    $('.topic-dialog').hide();
});


//竞品对话框点击确定按钮
$('.product-dialog .ok').on('click',function(){
    if($('.drap-name').text() !== '选择竞品'){
        var text = $('.drap-name').text();
        var url= $('#d-img2-url').val();
        var obj = {};
        function innerChange(str){
            $(str).text(text);
            if(PSID){
                $(str).attr('data-id',PSID);
            }
            obj.topicId=$(str).attr('data-id');
        }
        //改变文字
        switch (PSIndex){
            case 0:
                innerChange('.island1 .i-title');
                break;
            case 1:
                innerChange('.port1');
                break;
            case 2:
                innerChange('.port2');
                break;
            case 3:
                innerChange('.port3');
                break;
            case 4:
                innerChange('.island3 .i-title');
                break;
            case 5:
                innerChange('.port4');
                break;
            case 6:
                innerChange('.island4 .i-title');
                break;
            default :
                //console.log('希望你不要看到我');
                break;
        }
        //$('.img-ct img').eq(PSIndex).attr('src',url);
        $('.img-ct .product').eq(PSIndex).css({
            background:'url('+url+')',
            backgroundSize:'100% 100%'
        });

        //提交修改内容
        obj.position =  PSIndex;
        obj.imgUrl = url;
        obj.name = $('.drap-name').text();
        superArr.push(obj);
        var chulisuperArr = chuli(superArr);
        ajaxPSpost(JSON.stringify(chulisuperArr));
    }
    upTopic();
    $('.product-dialog').hide();
    PSID = '';
});