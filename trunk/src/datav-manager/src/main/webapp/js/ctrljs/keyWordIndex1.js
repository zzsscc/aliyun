        $('#errorModal').on('click',function(){
            $('body').removeClass('modal-open');
            $('#errorModal').removeClass('in');
            $('#errorModal').attr('aria-hidden',true);
            $('#errorModal').hide();
        });
        $('#errorModal .modal-content').on('click',function(e){
            e.stopPropagation();
        });
        $('#errorModal .cancel').on('click',function(){
            $('body').removeClass('modal-open');
            $('#errorModal').removeClass('in');
            $('#errorModal').attr('aria-hidden',true);
            $('#errorModal').hide();
        });


        //对话框margin
        var setDialogMargin=$('.dialog');
        for(var i=0;i<setDialogMargin.length;i++){
            $(setDialogMargin[i]).css('marginTop',-($(setDialogMargin[i]).height()/2));
            $(setDialogMargin[i]).css('marginLeft',-($(setDialogMargin[i]).width()/2));
        }


        //添加专题
        var addztPopup=$('#addZtModal');
        var noToaddZt=$('.no-zt').find('.no-button');
        noToaddZt.click(function(){
            addztPopup.find('.zhengzeinput').val('');
            addztPopup.find('.addzt-checkbox').prop('checked',true);
        })
        //添加专题保存
        addztPopup.find('.sure-button').click(function(){
            var addztCheckbox=$('#switch11');
            var torf=null;
            if(addztCheckbox.prop('checked')){
                torf=1;
            }else{
                torf=0;
            }
            if(addztPopup.find('.zhengzeinput').val()){
                $.ajax({
                    type: "POST",
                    url: "/topic/add",
                    data:{
                        topicName:  addztPopup.find('.zhengzeinput').val(),
                        topicStatus: torf,
                        topicType:0
                    },
                    success: function (response) {
                        //console.log(response);
                        initGet();
                    },
                    error: function () {
                        //alert('fail');
                    }
                });
            }else{
                $('body').addClass('modal-open');
                $('#errorModal').addClass('in');
                $('#errorModal').attr('aria-hidden',false);
                $('#errorModal').show();
            }
        })


        //编辑专题
        var editLi=null
        var editztPopup=$('#changeZtModal');
        var changeZt=$('.change-zt');
        changeZt.click(function(){
            editLi=$(zt.find('a')[0]);
            editztPopup.find('.zhengzeinput').val(editLi.html());
            var editztCheckbox=$('.editzt-checkbox');
            if(editLi.data('data-topicStatus')==0){
                editztCheckbox.prop('checked',false);
            }else if(editLi.data('data-topicStatus')==1){
                editztCheckbox.prop('checked',true);
            }
        })
        //编辑专题确定
        editztPopup.find('.sure-button').click(function(){
            var editztCheckbox=$('#switch10');
            var torf=null;
            if(editztCheckbox.prop('checked')){
               torf=1;
            }else{
                torf=0;
            }
            var editztName=editztPopup.find('.zhengzeinput').val();
            if(editztName){
                $.ajax({
                    type: "POST",
                    url: "/topic/update",
                    data:{
                        topicName:  editztName,
                        topicStatus: torf,
                        id: editLi.data('data-topicId')
                    },
                    success: function (response) {
                        initGet();
                    },
                    error: function () {
                        //alert('fail');
                    }
                });
            }else{
                $('body').addClass('modal-open');
                $('#errorModal').addClass('in');
                $('#errorModal').attr('aria-hidden',false);
                $('#errorModal').show();
            }
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
                url: "/topic/delete",
                data:{
                    id: removeLi.data('data-topicId')
                },
                success: function (response) {
                    initGet();
                },
                error: function () {
                    //alert('fail');
                }
            });
        })


        var itemName = null;
        var itemSource = null;
        var itemRule = null;
        var changeLi = null;
        var delLi = null;
    function shijian() {
        //编辑对话框
        var changes = $('.change');
        var setupPopup = $('#changeModal');
        changes.on('click',function () {
            $('#checkboxAll1').prop('checked',false);
            changeLi = $(this).parents("tr");
            itemName = changeLi.find('.item-name').html();
            itemSource = changeLi.find('.item-source').html();
            itemRule = changeLi.find('.item-rule').html();
            clearSelect();
            //规则
            setupPopup.find('.zhengzeinput').val(itemName);

            //专题选择下拉框暂时隐藏
            // //专题
            // //setupPopup.find('.ztselect').find('option').html(ztName);
            // var ztLi = zt.find('li');
            // for (var i = 0; i < ztLi.length; i++) {
            //     setupPopup.find('.ztselect').append("<option></option>");
            // }
            // var options = setupPopup.find('.ztselect').find('option');
            // for (var i = 0; i < ztLi.length; i++) {
            //     options[i].innerHTML = ztLi[i].innerHTML;
            // }


            //alert($('select').attr("value"))

            //勾选原来选择的源站类型
            var wcheckbox = setupPopup.find('.checkboxSel').find('span');
            var subSource = itemSource.split('，');
            for (var i = 0; i < wcheckbox.length; i++) {
                $(wcheckbox[i]).prev().prev().prop('checked', false);
            }
            for (var i = 0; i < wcheckbox.length; i++) {
                for (var j = 0; j < subSource.length; j++) {
                    if (wcheckbox[i].innerHTML == subSource[j]) {
                        $(wcheckbox[i]).prev().prev().prop('checked', true);
                    }
                }
            }
        })

        //编辑保存
        setupPopup.find('.sure-button').on('click',function () {
            itemName = $(this).parents(".modal").find('.zhengzeinput').val();
            itemRule = $(this).parents(".modal").find('.checkboxSel').find('input');

            //源站类型
            var ruleArr = [];
            for (var i = 0; i < itemRule.length; i++) {
                if (itemRule[i].checked) {
                    ruleArr.push($(itemRule[i]).next().next().html());
                }
            }
            var ruleStr = ruleArr.join(',');
            // ruleStr = ruleStr.replace(/[视][频]/,'38');
            ruleStr = ruleStr.replace(/[政][府]/,'37');
            ruleStr = ruleStr.replace(/[微][信]/,'35');
            ruleStr = ruleStr.replace(/[微][博]/,'34');
            ruleStr = ruleStr.replace(/[贴][吧]/,'30');
            ruleStr = ruleStr.replace(/[论][坛]/,'26');
            ruleStr = ruleStr.replace(/[新][闻]/,'3');
            ruleStr = '['+ruleStr+']';
            var ruleStrNull=ruleStr.search(/[0-9]/);

            if (itemName && ruleStrNull!=-1) {
                
                $.ajax({
                    type: "POST",
                    url: "/keyword/update",
                    data: {
                        keyword: itemName,
                        siteTypeIds: ruleStr,
                        id: changeLi.data('data-kwId')
                    },
                    success: function (response) {
                        getgjzshuju();
                    },
                    error: function () {
                        
                    }
                });
                setupPopup.hide();
                $(this).off('click');
            } else {
                $('body').addClass('modal-open');
                $('#errorModal').addClass('in');
                $('#errorModal').attr('aria-hidden',false);
                $('#errorModal').show();
            }
        })

        //删除对话框
        var del = $('.del');
        var delrulePopup = $('#delModal');
        del.on('click',function () {
            delLi = $(this).parents("tr");
        })
        delrulePopup.find('.sure-button').on('click',function () {
            $.ajax({
                type: "POST",
                url: "/keyword/delete",
                data: {
                    id: "["+delLi.data('data-kwId')+"]"
                },
                success: function (response) {
                    //console.log(response);
                    getgjzshuju();
                },
                error: function () {
                    //alert('delfail');
                }
            });
            $(this).off('click');
        })


        //清空下拉框
        function clearSelect() {
            setupPopup.find('.ztselect').html("");
        }

    }

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
                        $(this).prop("checked", true);
                    });
                } else {
                    all.each(function () {
                        $(this).prop("checked", false);
                    });
                }
            });
        }

        function cbLinkage2(obj, all) {
            obj.click(function () {
                if (this.checked) {
                    all.each(function () {
                        $(this).prop("checked", true);
                    });
                } else {
                    all.each(function () {
                        $(this).prop("checked", false);
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
                obj.prop("checked", true);
            } else {
                obj.prop("checked", false);
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
                obj.prop("checked", true);
            } else {
                obj.prop("checked", false);
            }
        }

        checkboxIn2.click(function () {
            setSelectAll2(checkboxAll2);
        });

        function setSelectAll3(obj) {
            var checkedsub = $("input[type='checkbox'][name='subcheck3']:checked").length; //获取选中的subcheck的个数
            if (checkedsub == checkboxIn3.length) {
                obj.prop("checked", true);
            } else {
                obj.prop("checked", false);
            }
        }

        checkboxIn3.click(function () {
            setSelectAll3(checkboxAll3);
        });









        //添加关键字
        var addRule = $('.add-keyword');
        var noToaddGjz = $('.no-gjz').find('.no-button');
        noToaddGjz.click(function () {
            $('#checkboxAll3').prop('checked',false);
            $('#addKwModal').find('textarea').val('');
            $('#addKwModal').find('.checkboxSel').find('input').prop('checked', false);
            $('#addKwModal').css("display", "block");
        })
        addRule.click(function () {
            $('#checkboxAll3').prop('checked',false);
            $('#addKwModal').find('textarea').val('');
            $('#addKwModal').find('.checkboxSel').find('input').prop('checked', false);
            $('#addKwModal').css("display", "block");
        })
        //添加关键字保存
        var addPopup = $('#addKwModal');
        addPopup.find('.sure-button').on('click',function () {

            itemName = $(this).parents(".modal").find('textarea').val();
            itemRule = $(this).parents(".modal").find('.checkboxSel').find('input');

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
                    ruleArr.push($(itemRule[i]).next().next().html());
                }
            }
            var ruleStr = ruleArr.join(',');
            // ruleStr = ruleStr.replace(/[视][频]/,'38');
            ruleStr = ruleStr.replace(/[政][府]/,'37');
            ruleStr = ruleStr.replace(/[微][信]/,'35');
            ruleStr = ruleStr.replace(/[微][博]/,'34');
            ruleStr = ruleStr.replace(/[贴][吧]/,'30');
            ruleStr = ruleStr.replace(/[论][坛]/,'26');
            ruleStr = ruleStr.replace(/[新][闻]/,'3');
            ruleStr = '['+ruleStr+']';
            var ruleStrNull=ruleStr.search(/[0-9]/);

            if (itemName && ruleStrNull!=-1) {
                $.ajax({
                    type: "POST",
                    //async: false,
                    //url: "http://192.168.3.44:10086/keyword/add",
                    url: "/keyword/add",
                    data: {
                        keyword:itemName,
                        topicId:ztID,
                        siteTypeIds:ruleStr
                    },
                    success: function (response) {
                        console.log(response);
                        getgjzshuju();
                    },
                    error: function () {
                        alert('fail');
                    }
                });
            }else{
                $('body').addClass('modal-open');
                $('#errorModal').addClass('in');
                $('#errorModal').attr('aria-hidden',false);
                $('#errorModal').show();
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
            $('#checkboxAll2').prop('checked',false);
            hideNo();
            noGjz.show();
            closepopup(this);
        })






