$(function(){
    //对话框margin
    var setDialogMargin=$('.dialog');
    for(var i=0;i<setDialogMargin.length;i++){
        $(setDialogMargin[i]).css('marginTop',-($(setDialogMargin[i]).height()/2));
        $(setDialogMargin[i]).css('marginLeft',-($(setDialogMargin[i]).width()/2));
    }

    //关闭对话框
    function closepopup(obj){
        $(obj).parents(".popup").css("display","none");
    }
    var closecha=$('.dialog-title').find('i');
    var closeButton=$('.close-button');
    closecha.click(function(){
        closepopup(this);
    });
    closeButton.click(function(){
        closepopup(this);
    });

    //帮助对话框
    var helpText=$('.helpText');
    helpText.click(function(){
        $('.help-popup').css("display","block");
    })

    //垃圾箱对话框
    var DustbinText=$('.DustbinText');
    DustbinText.click(function(){
        $('.dustbin-popup').css("display","block");
    })

    //编辑对话框
    var changes=$('.change');
    var itemName=null;
    var itemSource=null;
    var itemRule=null;
    var changeLi=null;
    var setupPopup=$('.setup-popup');
    changes.click(function(){
        changeLi=$(this).parents("li");
        itemName=changeLi.find('.item-name').html();
        itemSource=changeLi.find('.item-source').html();
        itemRule=changeLi.find('.item-rule').html();
        //规则
        setupPopup.find('.zhengzeinput').val(itemName);
        //过滤类型
        var wradio=setupPopup.find('.radios').find('span');
        for(var i=0;i<wradio.length;i++){
            if(wradio[i].innerHTML==itemRule){
                setupPopup.find('.radios').find("input").attr('checked',false);
                $(wradio[i]).prev().attr('checked',true);
            }
        }

        //勾选原来选择的源站类型
        var wcheckbox=setupPopup.find('.checkboxSel').find('span');
        var subSource=itemSource.split('，');
        for(var i=0;i<wcheckbox.length;i++){
            $(wcheckbox[i]).prev().attr('checked',false);
        }
        for(var i=0;i<wcheckbox.length;i++){
            for(var j=0;j<subSource.length;j++){
                if(wcheckbox[i].innerHTML==subSource[j]){
                    $(wcheckbox[i]).prev().attr('checked',true);
                }
            }
        }

        setupPopup.css("display","block");

    })

    //编辑保存
    setupPopup.find('.sure-button').click(function(){
        itemName=$(this).parents(".dialog").find('.zhengzeinput').val();
        itemSource=$(this).parents(".dialog").find('.radios').find('input');
        itemRule=$(this).parents(".dialog").find('.checkboxSel').find('input');

        //过滤类型
        for(var i=0;i<itemSource.length;i++){
            if(itemSource[i].checked){
                var addSource=$(itemSource[i]).next().html();
            }
        }
        //源站类型
        var ruleArr=[];
        for(var i=0;i<itemRule.length;i++){
            if(itemRule[i].checked){
                ruleArr.push($(itemRule[i]).next().html());
            }
        }
        var ruleStr=ruleArr.join('，');


        if(itemName && addSource && ruleStr){
            changeLi.find('.item-name').html(itemName);
            //过滤类型
            changeLi.find('.item-rule').html(addSource);
            //源站类型
            changeLi.find('.item-source').html(ruleStr);


            setupPopup.css("display","none");
        }else{
            alert('规则未填写完整');
        }
    })

    //删除对话框
    var del=$('.del');
    var delLi=null;
    var delrulePopup=$('.del-rule-popup');
    del.on('click',function(){
        delLi=$(this).parents("li");
        delrulePopup.css("display","block");
    })
    delrulePopup.find('.sure-button').click(function(){
        delLi.remove();
        closepopup(this);
    })

    //把要克隆的li保存下来
    var lis=$('.item');
    var LisClo=$(lis[0]).clone(true);



    //复选框联动
    var checkboxAll1=$('#checkboxAll1');
    var checkboxIn1=$('.checkboxs-in1');

    var checkboxAll2=$('#checkboxAll2');
    var checkboxIn2=$('.checkboxs-in2');

    var checkboxAll3=$('#checkboxAll3');
    var checkboxIn3=$('.checkboxs-in3');
    //全选，全不选
    function cbLinkage(obj,all){
        obj.click(function() {
            if(this.checked){
                all.each(function() {
                    $(this).attr("checked", true);
                });
            }else{
                all.each(function() {
                    $(this).attr("checked", false);
                });
            }
        });
    }
    function cbLinkage2(obj,all){
        obj.click(function() {
            if(this.checked){
                all.each(function() {
                    $(this).attr("checked", true);
                });
            }else{
                all.each(function() {
                    $(this).attr("checked", false);
                });
            }
            delLinum=[];
            for(var i=0;i<checkboxIn2.length;i++){
                if(checkboxIn2[i].checked){
                    delLinum.push(i);
                }
            }
        });
    }
    cbLinkage(checkboxAll1,checkboxIn1);
    cbLinkage2(checkboxAll2,checkboxIn2);
    cbLinkage(checkboxAll3,checkboxIn3);


    //上面全选中则全部选项也选中，有一个没选则全部选项不选中
    function setSelectAll1(obj){
        var checkedsub = $("input[type='checkbox'][name='subcheck1']:checked").length; //获取选中的subcheck的个数
        if (checkedsub == checkboxIn1.length) {
            obj.attr("checked", true);
        }else{
            obj.attr("checked", false);
        }
    }
    checkboxIn1.click(function(){
        setSelectAll1(checkboxAll1);
    });


    function setSelectAll2(obj){
        var subcheck2=$("input[type='checkbox'][name='subcheck2']");
        delLinum=[];
        for(var i=0;i<subcheck2.length;i++){
            if(subcheck2[i].checked){
                delLinum.push(i);
            }
        }
        var checkedsub = $("input[type='checkbox'][name='subcheck2']:checked").length; //获取选中的subcheck的个数
        if (checkedsub >0) {
            obj.attr("checked", true);
        }else{
            obj.attr("checked", false);
        }
    }
    checkboxIn2.click(function(){
        setSelectAll2(checkboxAll2);
    });

    function setSelectAll3(obj){
        var checkedsub = $("input[type='checkbox'][name='subcheck3']:checked").length; //获取选中的subcheck的个数
        if (checkedsub == checkboxIn3.length) {
            obj.attr("checked", true);
        }else{
            obj.attr("checked", false);
        }
    }
    checkboxIn3.click(function(){
        setSelectAll3(checkboxAll3);
    });

    //添加规则
    var addRule=$('.add-keyword');
    addRule.click(function(){
        $('.add-popup').find('.zhengzeinput').val('');
        $('.add-popup').find('.radios').find('input').attr('checked',false);
        $('.add-popup').find('.checkboxSel').find('input').attr('checked',false);
        $('.add-popup').css("display","block");
    })
    //添加规则保存
    var addPopup=$('.add-popup');
    addPopup.find('.sure-button').click(function(){

        itemName=$(this).parents(".dialog").find('.zhengzeinput').val();
        itemSource=$(this).parents(".dialog").find('.radios').find('input');
        itemRule=$(this).parents(".dialog").find('.checkboxSel').find('input');

        //过滤类型
        for(var i=0;i<itemSource.length;i++){
            if(itemSource[i].checked){
                var addSource=$(itemSource[i]).next().html();
            }
        }
        //源站类型
        var ruleArr=[];
        for(var i=0;i<itemRule.length;i++){
            if(itemRule[i].checked){
                ruleArr.push($(itemRule[i]).next().html());
            }
        }
        var ruleStr=ruleArr.join('，');

        if(itemName && addSource && ruleStr){
            //复制第一条
            $('.list').prepend(LisClo);
            var liss=$($('.item')[0]);


            //规则
            liss.find('.item-name').html(itemName);
            //过滤类型
            liss.find('.item-rule').html(addSource);
            //源站类型
            liss.find('.item-source').html(ruleStr);
            //时间
            var date=new Date();
            var dd=format(date);
            liss.find('.item-data').html(dd);

            //重置复选框选择
            checkboxIn2=$('.checkboxs-in2');
            cbLinkage2(checkboxAll2,checkboxIn2);
            checkboxIn2.click(function(){
                setSelectAll2(checkboxAll2);
            });
            //重新得到所有行的集合
            lis=$('.item');


            //隐藏对话框
            addPopup.css("display","none");
        }else{
            alert('规则未填写完整');
        }
    })


    //批量删除
    var delAll=$('.del-all');
    var delLinum=[];
    var delallrulePopup=$('.del-allrule-popup');
    delAll.click(function(){
        //重新获得新的li集合
        lis=$('.item');
        delallrulePopup.css("display","block");
    })
    delallrulePopup.find('.sure-button').click(function(){
        for(var j=0;j<delLinum.length;j++){
            $(lis[delLinum[j]]).remove();
        }
        closepopup(this);
    })

    function format(date){
        var y=date.getFullYear()+"-";
        var m=date.getMonth()+1+"-";
        var d=date.getDate()+"&nbsp;";


        //当前小时大于12
        h=date.getHours();
        //var am=h>12?" 下午 ":" 上午 ";
        //24小时制换为12小时制
        //h=h>12?h-12:h;
        //一位数小时数前加个0
        h=h<10?"0"+h:""+h;

        //一位数分钟数前加个0
        var mi=date.getMinutes();
        mi=mi<10?"0"+mi:""+mi;

        //一位数秒数前加个0
        var s=date.getSeconds();
        s=s<10?"0"+s:""+s;

        //字符串拼接
        var datestr=y+m+d+h+":"+mi+":"+s;
        return datestr;
    }


    //分页切换
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
});