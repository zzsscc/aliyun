
        //对话框margin
        var setDialogMargin=$('.dialog');
        for(var i=0;i<setDialogMargin.length;i++){
            $(setDialogMargin[i]).css('marginTop',-($(setDialogMargin[i]).height()/2));
            $(setDialogMargin[i]).css('marginLeft',-($(setDialogMargin[i]).width()/2));
        }

        //操作专题
        var zt=$('.zt');
        var drop=$('.drop');
        var dropDown=$('.drop-down');
        drop.mouseenter(function(){
            dropDown.show();
        })
        drop.mouseleave(function(){
            dropDown.hide();
        })

        //添加专题
        var addztPopup=$('.addzt-popup');
        var noToaddZt=$('.no-zt').find('.no-button');
        var newZt=$('.new-zt');
        noToaddZt.click(function(){
            addztPopup.find('.zhengzeinput').val('');
            addztPopup.find('#rule1').attr('checked',true);
            addztPopup.show();
        })
        newZt.click(function(){
            addztPopup.find('.zhengzeinput').val('');
            addztPopup.find('#rule1').attr('checked',true);
            addztPopup.show();
        })
        //添加专题保存
        addztPopup.find('.sure-button').click(function(){
            var radios=$('.addzt-radios');
            var torf=null;
            for(var i=0;i<radios.length;i++){
                if(radios[i].checked){
                    if(i==0){
                        torf=1;
                    }else if(i==1){
                        torf=0;
                    }
                }
            }
            if(addztPopup.find('.zhengzeinput').val()){
                $.ajax({
                    type: "POST",
                    //url: "http://192.168.3.44:10086/topic/add",
                    url: "http://121.40.197.218:8080/topic/add",
                    //dataType: "json",
                    data:{
                        topicName:  addztPopup.find('.zhengzeinput').val(),
                        topicStatus: torf,
                        topicType:0
                    },
                    success: function (response) {
                        //console.log(response);
                        getztshujuQU();
                        addztPopup.hide();
                    },
                    error: function () {
                        alert('fail');
                    }
                });
            }else{
                alert('请填写专题名称');
            }
        })


        //编辑专题
        var editLi=null
        var editztPopup=$('.editzt-popup');
        var changeZt=$('.change-zt');
        changeZt.click(function(){
            for(var i=0;i<zt.find('li').length;i++){
                if($(zt.find('li')[i]).hasClass('active')){
                    editLi=$(zt.find('li')[i]);
                }
            }
            editztPopup.find('.zhengzeinput').val(editLi.html());
            var radios=$('.editzt-radios');
            for(var i=0;i<radios.length;i++){
                if(editLi.data('data-topicStatus')==0){
                    $(radios[1]).attr('checked',true)
                }else if(editLi.data('data-topicStatus')==1){
                    $(radios[0]).attr('checked',true)
                }
            }
            editztPopup.show();
        })
        //编辑专题确定
        editztPopup.find('.sure-button').click(function(){
            var radios=$('.editzt-radios');
            var torf=null;
            for(var i=0;i<radios.length;i++){
                if(radios[i].checked){
                    if(i==0){
                        torf=1;
                    }else if(i==1){
                        torf=0;
                    }
                }
            }
            var editztName=editztPopup.find('.zhengzeinput').val();
            if(editztName){
                $.ajax({
                    type: "POST",
                    //url: "http://192.168.3.44:10086/topic/update",
                    url: "http://121.40.197.218:8080/topic/update",
                    //dataType: "json",
                    data:{
                        topicName:  editztName,
                        topicStatus: torf,
                        id: editLi.data('data-topicId')
                    },
                    success: function (response) {
                        //console.log(response);
                        getztshujuLIU();
                    },
                    error: function () {
                        alert('fail');
                    }
                });
            }
            //editLi.html(editztPopup.find('.zhengzeinput').val());
            editztPopup.hide();
        })



        //删除专题
        var removeLi=null;
        var delztPopup=$('.delzt-popup');
        var removeZt=$('.remove-zt');
        removeZt.click(function(){
            for(var i=0;i<zt.find('li').length;i++){
                if($(zt.find('li')[i]).hasClass('active')){
                    removeLi=$(zt.find('li')[i]);
                }
            }
            delztPopup.show();
        })
        //删除专题确定
        delztPopup.find('.sure-button').click(function(){
            $.ajax({
                type: "POST",
                //url: "http://192.168.3.44:10086/topic/delete",
                url: "http://121.40.197.218:8080/topic/delete",
                //dataType: "json",
                data:{
                    id: removeLi.data('data-topicId')
                },
                success: function (response) {
                    //console.log(response);
                    getztshujuQU();
                },
                error: function () {
                    alert('fail');
                }
            });
            delztPopup.hide();
        })










        //添加竞品
        var addjpPopup=$('.addjp-popup');
        var newJp=$('.new-jp');
        var noToaddZt=$('.no-jp').find('.no-button');
        noToaddZt.click(function(){
            addjpPopup.find('.zhengzeinput').val('');
            addjpPopup.find('#rule5').attr('checked',true);
            addjpPopup.show();
        })
        newJp.click(function(){
            addjpPopup.find('.zhengzeinput').val('');
            addjpPopup.find('#rule5').attr('checked',true);
            addjpPopup.show();
        })
        //添加竞品保存
        addjpPopup.find('.sure-button').click(function(){
            var radios=$('.addjp-radios');
            var torf=null;
            for(var i=0;i<radios.length;i++){
                if(radios[i].checked){
                    if(i==0){
                        torf=1;
                    }else if(i==1){
                        torf=0;
                    }
                }
            }
            if(addjpPopup.find('.zhengzeinput').val()){
                $.ajax({
                    type: "POST",
                    //url: "http://192.168.3.44:10086/topic/add",
                    url: "http://121.40.197.218:8080/topic/add",
                    //dataType: "json",
                    data:{
                        topicName:  addjpPopup.find('.zhengzeinput').val(),
                        topicStatus: torf,
                        topicType:1
                    },
                    success: function (response) {
                        //console.log(response);
                        getztshujuQU();
                        addjpPopup.hide();
                    },
                    error: function () {
                        alert('fail');
                    }
                });
            }else{
                alert('请填写竞品名称');
            }
        })


        //编辑竞品
        //var editLi=null
        var editjpPopup=$('.editjp-popup');
        var changeJp=$('.change-jp');
        changeJp.click(function(){
            for(var i=0;i<zt.find('li').length;i++){
                if($(zt.find('li')[i]).hasClass('active')){
                    editLi=$(zt.find('li')[i]);
                }
            }
            editjpPopup.find('.zhengzeinput').val(editLi.html());
            var radios=$('.editjp-radios');
            for(var i=0;i<radios.length;i++){
                if(editLi.data('data-topicStatus')==0){
                    $(radios[1]).attr('checked',true)
                }else if(editLi.data('data-topicStatus')==1){
                    $(radios[0]).attr('checked',true)
                }
            }
            editjpPopup.show();
        })
        //编辑竞品确定
        editjpPopup.find('.sure-button').click(function(){
            var radios=$('.editjp-radios');
            var torf=null;
            for(var i=0;i<radios.length;i++){
                if(radios[i].checked){
                    if(i==0){
                        torf=1;
                    }else if(i==1){
                        torf=0;
                    }
                }
            }
            var editjpName=editjpPopup.find('.zhengzeinput').val();
            if(editjpName){
                $.ajax({
                    type: "POST",
                    //url: "http://192.168.3.44:10086/topic/update",
                    url: "http://121.40.197.218:8080/topic/update",
                    //dataType: "json",
                    data:{
                        topicName:  editjpName,
                        topicStatus: torf,
                        id: editLi.data('data-topicId')
                    },
                    success: function (response) {
                        //console.log(response);
                        getztshujuLIU();
                    },
                    error: function () {
                        alert('fail');
                    }
                });
            }
            //editLi.html(editztPopup.find('.zhengzeinput').val());
            editjpPopup.hide();
        })



        //删除竞品
        //var removeLi=null;
        var deljpPopup=$('.deljp-popup');
        var removeJp=$('.remove-jp');
        removeJp.click(function(){
            for(var i=0;i<zt.find('li').length;i++){
                if($(zt.find('li')[i]).hasClass('active')){
                    removeLi=$(zt.find('li')[i]);
                }
            }
            deljpPopup.show();
        })
        //删除竞品确定
        deljpPopup.find('.sure-button').click(function(){
            $.ajax({
                type: "POST",
                //url: "http://192.168.3.44:10086/topic/delete",
                url: "http://121.40.197.218:8080/topic/delete",
                //dataType: "json",
                data:{
                    id: removeLi.data('data-topicId')
                },
                success: function (response) {
                    //console.log(response);
                    getztshujuQU();
                },
                error: function () {
                    alert('fail');
                }
            });
            deljpPopup.hide();
        })
        ////专题切换，保存专题名
        //var ztID=null;
        ////ztID=zt.find('li').data('data-topicId');
        //function toggleZt(){
        //    var ztLi=zt.find('li');
        //    ztID=$(ztLi[0]).data('data-topicId');
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
        //toggleZt();


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



        var itemName = null;
        var itemSource = null;
        var itemRule = null;
        var changeLi = null;
        var delLi = null;
    function shijian() {
        //编辑对话框
        var changes = $('.change');
        var setupPopup = $('.setup-popup');
        changes.click(function () {
            $('#checkboxAll1').attr('checked',false);
            changeLi = $(this).parents("li");
            itemName = changeLi.find('.item-name').html();
            itemSource = changeLi.find('.item-source').html();
            itemRule = changeLi.find('.item-rule').html();
            clearSelect();
            //规则
            setupPopup.find('.zhengzeinput').val(itemName);
            //专题
            //setupPopup.find('.ztselect').find('option').html(ztName);
            var ztLi = zt.find('li');
            for (var i = 0; i < ztLi.length; i++) {
                setupPopup.find('.ztselect').append("<option></option>");
            }
            var options = setupPopup.find('.ztselect').find('option');
            for (var i = 0; i < ztLi.length; i++) {
                options[i].innerHTML = ztLi[i].innerHTML;
            }


            //alert($('select').attr("value"))

            //勾选原来选择的源站类型
            var wcheckbox = setupPopup.find('.checkboxSel').find('span');
            var subSource = itemSource.split('，');
            for (var i = 0; i < wcheckbox.length; i++) {
                $(wcheckbox[i]).prev().attr('checked', false);
            }
            for (var i = 0; i < wcheckbox.length; i++) {
                for (var j = 0; j < subSource.length; j++) {
                    if (wcheckbox[i].innerHTML == subSource[j]) {
                        $(wcheckbox[i]).prev().attr('checked', true);
                    }
                }
            }

            setupPopup.css("display", "block");

        })

        //编辑保存
        setupPopup.find('.sure-button').on('click',function () {
            itemName = $(this).parents(".dialog").find('.zhengzeinput').val();
            itemRule = $(this).parents(".dialog").find('.checkboxSel').find('input');

            //源站类型
            var ruleArr = [];
            for (var i = 0; i < itemRule.length; i++) {
                if (itemRule[i].checked) {
                    ruleArr.push($(itemRule[i]).next().html());
                }
            }
            var ruleStr = ruleArr.join(',');
            ruleStr = ruleStr.replace(/[视][频]/,'38');
            ruleStr = ruleStr.replace(/[政][府]/,'37');
            ruleStr = ruleStr.replace(/[微][信]/,'35');
            ruleStr = ruleStr.replace(/[微][博]/,'34');
            ruleStr = ruleStr.replace(/[贴][吧]/,'30');
            ruleStr = ruleStr.replace(/[论][坛]/,'26');
            ruleStr = ruleStr.replace(/[新][闻]/,'3');
            ruleStr = '['+ruleStr+']';
            var ruleStrNull=ruleStr.search(/[0-9]/);


            if (itemName && ruleStrNull!=-1) {
                //changeLi.find('.item-name').html(itemName);
                ////过滤类型
                //changeLi.find('.item-rule').html($(itemSource[i]).next().html());
                //源站类型
                //changeLi.find('.item-source').html(ruleStr);
                $.ajax({
                    type: "POST",
                    //async: false,
                    //url: "http://192.168.3.44:10086/keyword/update",
                    url: "http://121.40.197.218:8080/keyword/update",
                    data: {
                        keyword: itemName,
                        siteTypeIds: ruleStr,
                        id: changeLi.data('data-kwId')
                    },
                    //url: "js/focusNewsjs/aj.json",
                    //dataType: "json",
                    //jsonp: "callback",
                    //jsonpCallback:"flightHandler",
                    success: function (response) {
                        console.log(response);
                        getgjzshuju()
                    },
                    error: function () {
                        alert('changefail');
                    }
                });
                setupPopup.css("display", "none");
                $(this).off('click');
            } else {
                alert('规则未填写完整');
            }
        })

        //删除对话框
        var del = $('.del');
        var delrulePopup = $('.del-rule-popup');
        del.click(function () {
            delLi = $(this).parents("li");
            delrulePopup.css("display", "block");
        })
        delrulePopup.find('.sure-button').on('click',function () {
            $.ajax({
                type: "POST",
                //async: false,
                //url: "http://192.168.3.44:10086/keyword/update",
                url: "http://121.40.197.218:8080/keyword/delete",
                data: {
                    id: delLi.data('data-kwId')
                },
                //url: "js/focusNewsjs/aj.json",
                //dataType: "json",
                //jsonp: "callback",
                //jsonpCallback:"flightHandler",
                success: function (response) {
                    console.log(response);
                    getgjzshuju()
                },
                error: function () {
                    //alert('delfail');
                }
            });
            closepopup(this);
            $(this).off('click');
        })

        ////把要克隆的li保存下来
        //var lis = $('.item');
        //var LisClo = $(lis[0]).clone(true);


        //复选框联动
        var checkboxAll1 = $('#checkboxAll1');
        var checkboxIn1 = $('.checkboxs-in1');

        var checkboxAll2 = $('#checkboxAll2');
        var checkboxIn2 = $('.checkboxs-in2');

        var checkboxAll3 = $('#checkboxAll3');
        var checkboxIn3 = $('.checkboxs-in3');
        //全选，全不选
        function cbLinkage(obj, all) {
            obj.click(function () {
                if (this.checked) {
                    all.each(function () {
                        $(this).attr("checked", true);
                    });
                } else {
                    all.each(function () {
                        $(this).attr("checked", false);
                    });
                }
            });
        }

        function cbLinkage2(obj, all) {
            obj.click(function () {
                if (this.checked) {
                    all.each(function () {
                        $(this).attr("checked", true);
                    });
                } else {
                    all.each(function () {
                        $(this).attr("checked", false);
                    });
                }
                delLinum = [];
                for (var i = 0; i < checkboxIn2.length; i++) {
                    if (checkboxIn2[i].checked) {
                        delLinum.push(i);
                    }
                }
            });
        }

        cbLinkage(checkboxAll1, checkboxIn1);
        cbLinkage2(checkboxAll2, checkboxIn2);
        cbLinkage(checkboxAll3, checkboxIn3);


        //上面全选中则全部选项也选中，有一个没选则全部选项不选中
        function setSelectAll1(obj) {
            var checkedsub = $("input[type='checkbox'][name='subcheck1']:checked").length; //获取选中的subcheck的个数
            if (checkedsub == checkboxIn1.length) {
                obj.attr("checked", true);
            } else {
                obj.attr("checked", false);
            }
        }

        checkboxIn1.click(function () {
            setSelectAll1(checkboxAll1);
        });


        function setSelectAll2(obj) {
            var subcheck2 = $("input[type='checkbox'][name='subcheck2']");
            delLinum = [];
            for (var i = 0; i < subcheck2.length; i++) {
                if (subcheck2[i].checked) {
                    delLinum.push(i);
                }
            }
            var checkedsub = $("input[type='checkbox'][name='subcheck2']:checked").length; //获取选中的subcheck的个数
            //if (checkedsub > 0) {
            if (checkedsub == checkboxIn2.length) {
                obj.attr("checked", true);
            } else {
                obj.attr("checked", false);
            }
        }

        checkboxIn2.click(function () {
            setSelectAll2(checkboxAll2);
        });

        function setSelectAll3(obj) {
            var checkedsub = $("input[type='checkbox'][name='subcheck3']:checked").length; //获取选中的subcheck的个数
            if (checkedsub == checkboxIn3.length) {
                obj.attr("checked", true);
            } else {
                obj.attr("checked", false);
            }
        }

        checkboxIn3.click(function () {
            setSelectAll3(checkboxAll3);
        });


        //清空下拉框
        function clearSelect() {
            setupPopup.find('.ztselect').html("");
        }

    }

        //添加关键字
        var addRule = $('.add-keyword');
        var noToaddGjz = $('.no-gjz').find('.no-button');
        noToaddGjz.click(function () {
            $('#checkboxAll3').attr('checked',false);
            $('.add-popup').find('textarea').val('');
            $('.add-popup').find('.checkboxSel').find('input').attr('checked', false);
            $('.add-popup').css("display", "block");
        })
        addRule.click(function () {
            $('#checkboxAll3').attr('checked',false);
            $('.add-popup').find('textarea').val('');
            $('.add-popup').find('.checkboxSel').find('input').attr('checked', false);
            $('.add-popup').css("display", "block");
        })
        //添加关键字保存
        var addPopup = $('.add-popup');
        addPopup.find('.sure-button').on('click',function () {

            itemName = $(this).parents(".dialog").find('textarea').val();
            itemRule = $(this).parents(".dialog").find('.checkboxSel').find('input');

            //处理输入的关键字
            if(itemName.search(/\n/ig)!= -1){
                itemName=itemName.replace(/(\n)+/ig,'\n');
                itemName=itemName.replace(/(\n)$/ig,'');
                itemName=itemName.replace(/(\n)/ig,'\",\"');
                itemName = '["'+itemName+'"]';
                console.log(itemName);
            }else{
                itemName='["'+itemName+'"]';
            }

            //源站类型
            var ruleArr = [];
            for (var i = 0; i < itemRule.length; i++) {
                if (itemRule[i].checked) {
                    ruleArr.push($(itemRule[i]).next().html());
                }
            }
            var ruleStr = ruleArr.join(',');
            ruleStr = ruleStr.replace(/[视][频]/,'38');
            ruleStr = ruleStr.replace(/[政][府]/,'37');
            ruleStr = ruleStr.replace(/[微][信]/,'35');
            ruleStr = ruleStr.replace(/[微][博]/,'34');
            ruleStr = ruleStr.replace(/[贴][吧]/,'30');
            ruleStr = ruleStr.replace(/[论][坛]/,'26');
            ruleStr = ruleStr.replace(/[新][闻]/,'3');
            ruleStr = '['+ruleStr+']';
            var ruleStrNull=ruleStr.search(/[0-9]/);

            if (itemName && ruleStrNull!=-1) {
                ////复制第一条
                //$('.list').prepend(LisClo);
                //var liss = $($('.item')[0]);
                //
                //
                ////规则
                //liss.find('.item-name').html(itemName);
                ////源站类型
                //liss.find('.item-source').html(ruleStr);
                ////时间
                //var date = new Date();
                //var dd = format(date);
                //liss.find('.item-data').html(dd);
                //
                //重置复选框选择
                //checkboxIn2 = $('.checkboxs-in2');
                //cbLinkage2(checkboxAll2, checkboxIn2);
                //checkboxIn2.click(function () {
                //    setSelectAll2(checkboxAll2);
                //});
                ////重新得到所有行的集合
                //lis = $('.item');
                $.ajax({
                    type: "POST",
                    //async: false,
                    //url: "http://192.168.3.44:10086/keyword/add",
                    url: "http://121.40.197.218:8080/keyword/add",
                    data: {
                        keyword:itemName,
                        topicId:ztID,
                        siteTypeIds:ruleStr
                    },
                    success: function (response) {
                        console.log(response);
                        getgjzshuju()
                    },
                    error: function () {
                        alert('fail');
                    }
                });
                //隐藏对话框
                addPopup.css("display", "none");
            }else{
                alert('规则未填写完整');
            }
        })


        //批量删除
        var delAll = $('.del-all');
        var delLinum = [];
        var delallrulePopup = $('.del-allrule-popup');
        var lis = $('.item');
        delAll.click(function () {
            //重新获得新的li集合
            lis = $('.item');
            delallrulePopup.css("display", "block");
        })
        delallrulePopup.find('.sure-button').click(function () {
            console.log(delLinum);
            for (var j = 0; j < delLinum.length; j++) {
                $(lis[delLinum[j]]).remove();
            }
            $('#checkboxAll2').attr('checked',false);
            hideNo();
            noGjz.show();
            closepopup(this);
        })


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
            h = date.getHours();
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



//    分页切换
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
