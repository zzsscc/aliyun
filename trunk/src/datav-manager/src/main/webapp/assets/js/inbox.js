// 全局变量

// topage页数
var page = 1;
var init = 0;
var maxpage = 1;
// 初始查询出来的总页数
var initTotalpage = 1;
// keyword 关键词
var keyword = "";

// 滚动条位置
var scrollTopValue;

function toNextPage(){
  page = page+1;
  if(page>0&&page<maxpage){
  getInboxsData(page);
  }
}

function toPrevPage(){
  if(page==1){

  }
  else{
    page = page-1;
    getInboxsData(page)
  }

}
// 格式化日期时间
function timeformated(timestr){
  // 时间日期的格式转换
  var time = new Date(timestr);
  var hh = time.getHours();
  var mm = time.getMinutes();
  var ss = time.getMinutes();
  var day = time.getDate();
  var month = time.getMonth()+1;
  var year = time.getFullYear().toString().substring(2,4);

  if(hh<10){
    hh = "0"+hh;
  }
  if(mm<10){
    mm = "0"+mm;
  }
  if(ss<10){
    ss = "0"+ss;
  }
  if(day<10){
    day = "0"+day;
  }
  if(month<10){
    month = "0"+month;
  }
  // 输出格式化后的   时间
  // var timeformated = hh+":"+mm+","+month+"."+day+"."+year;
  var timeformated = year+"-"+month+"-"+day+" "+hh+":"+mm+":"+ss;
  return timeformated;
}

function hideLoadingAndLayer(){
  $('.loading').css('display','none');
  $('.modal-backdrop').css('display','none');
}

function showLoadingAndLayer(){
  $('.loading').css('display','block');
  $('.modal-backdrop').css('display','block');
}

// 正则表达式 判断url来源
function sourcesfromurl(url){
  // var weibourl = "http://weibo.com/5015392205/Efv2gsydj";
  // var tiebaurl = "http://tieba.baidu.com/p/4844096720";
  // var strRegex = '^( (http|https)?:// )' + 'weibo.com';
  var strRegex_weibo = '^((https|http)?://weibo.com)';
  var strRegex_tieba = '^((https|http)?://tieba.baidu.com)';

  var tieba_Reg = new RegExp(strRegex_tieba);
  var weibo_Reg = new RegExp(strRegex_weibo);

  if(!!url.match(tieba_Reg)){
    return "贴吧";
  }
  else if(!!url.match(weibo_Reg)){
    return "微博";
  }
  else{
    return "其他";
  }

}

function getInboxsData(page){
  $('.nodatalist').css('display','none');
  // 页数
  // var page = topage;
  if(init != 0)
  {
    showLoadingAndLayer();
  }
  else
  {
    init = 1;
  }

  $.ajax({
    type: "GET",
    url: "/front/search",
    timeout: 8000,
    data: {
      toPage: page,
      pageSize: "20",
      subject: "",
      from: ""
    },
    success: function (response) {
      // hideLoading();
      hideLoadingAndLayer();
      //string转成json对象
      var jsonObject = JSON.parse(response);
      var totalPages = jsonObject.totalPages;
      //获取数据数组
      var result = jsonObject.result.records;
      var totalCount = jsonObject.totalCount;
      var success = jsonObject.success;
      var message = jsonObject.message;
      /* response结果集*/
      // console.log("response为： "+response);
      /* result结果集*/
      // console.log("result为： "+result);
      // 一个字母或字的标题
      var shorttitle = "";
      // 作者
      var fromwho;
      // 创建的具体时间, pubTime 精确到秒 格式为: 16:54, 24.11.2016
      var specifictime;
      // 描述，即 简述内容
      var description;
      // 来源：分为微博，新闻，贴吧等，根据url地址来正则判断
      var source;

      // 查到数据了
      if(success == true){
        // 打印结果集
        // console.log(result);
              // console.log("result为： "+result);
        if(result == "" || result == null){
          // console.log(message);
          //todo：modal 提示
          <!-- 提醒，暂无舆情数据 -->
          $('.nodatalist').css('display','block');
        }else{
          if(result.length>0 && totalPages>0){
              initTotalpage = totalPages;
            // console.log("totalCount: "+ totalCount);
            $('.totalCount').html(totalCount);
            // console.log("length: "+result.length);
            keyword = result[0].monitorKeywords;
            $('.list-group-item').each(function(index,element){
              if(index<result.length){
                // $(element).style.display = "block";
                $(element).css('display','block');
                // 隐藏的subject
                $(element).find('.hiddensubject').html(result[index].subject);

                // 隐藏的url地址
                $(element).find('.hiddenurl').html(result[index].url);
              }
            });

            // 遍历html页面里所有对象
            //  遍历短标题
            $('.shorttitles').each(function(index,element){
              if(index<result.length){
                // var a0 = result[index].from;
                shorttitle = result[index].from.substring(0,1);
                $(element).html(shorttitle);
              }
            });
            // 遍历作者
            $('.authors').each(function(index,element){
              if(index<result.length){
                fromwho = result[index].from;
                $(element).html(fromwho);
              }
            });
            // 遍历时间
            $('.specifictimes').each(function(index,element){
              if(index<result.length){
                specifictime = timeformated(result[index].pubTime);
                $(element).html(specifictime);
              }
            });
            // 遍历description
            $('.descriptions').each(function(index,element){
              if(index<result.length){
                description = result[index].description;
                $(element).html(description);
              }
            });
            // 来源
            $('.sources').each(function(index,element){
              if(index<result.length){
                source = sourcesfromurl(result[index].url);
                $(element).html(source);
                // 根据来源描绘颜色和背景
                if(source == "微博"){
                  $(element).removeClass("bg-primary");
                  $(element).removeClass("bg-orange");
                  $(element).removeClass("bg-default");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-primary");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-orange");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-default");
                  $(element).parents(".list-group-item").removeClass("b-orange");
                  $(element).parents(".list-group-item").removeClass("b-primary");
                  $(element).parents(".list-group-item").removeClass("b-default");

                  $(element).addClass("bg-primary");
                  $(element).parents(".list-group-item").find('.shorttitles').addClass("bg-primary");
                  $(element).parents(".list-group-item").addClass("b-primary");

                }
                else if (source ==  "贴吧"){
                  $(element).removeClass("bg-primary");
                  $(element).removeClass("bg-orange");
                  $(element).removeClass("bg-default");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-primary");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-orange");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-default");
                  $(element).parents(".list-group-item").removeClass("b-orange");
                  $(element).parents(".list-group-item").removeClass("b-primary");
                  $(element).parents(".list-group-item").removeClass("b-default");


                  $(element).addClass("bg-orange");
                  $(element).parents(".list-group-item").find('.shorttitles').addClass("bg-orange");
                  $(element).parents(".list-group-item").addClass("b-orange");
                }
                else{
                  $(element).removeClass("bg-primary");
                  $(element).removeClass("bg-orange");
                  $(element).removeClass("bg-default");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-primary");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-orange");
                  $(element).parents(".list-group-item").find('.shorttitles').removeClass("bg-default");
                  $(element).parents(".list-group-item").removeClass("b-orange");
                  $(element).parents(".list-group-item").removeClass("b-primary");
                  $(element).parents(".list-group-item").removeClass("b-default");

                  $(element).addClass("bg-default");
                  $(element).parents(".list-group-item").find('.shorttitles').addClass("bg-default");
                  $(element).parents(".list-group-item").addClass("b-default");
                }
              }
            });

                //    分页切换
                if(initTotalpage>5){
                    $('#page-wrap').jqPaginator({
                        totalPages: initTotalpage,
                        visiblePages: 5,
                        currentPage: page,
                        onPageChange: function (num, type) {
                          page=num;
                          getInboxsData(num);
                        }
                    });
                }else{
                    $('#page-wrap').jqPaginator({
                        totalPages: initTotalpage,
                        visiblePages: initTotalpage,
                        currentPage: page,
                        onPageChange: function (num, type) {
                            page=num;
                            getInboxsData(num);
                        }
                    });
                }
          }else{
            $('.nodatalist').css('display','block');
          }



        }
      }
      else{
        $('.nodatalist').css('display','block');
        // message
      }

    },
    error: function(){
      // console.log("ajax请求失败!");
        // hideLoading();
      hideLoadingAndLayer();
    }
  });
}


// function celldetaildisplay(){
//   // 显示
//
// }
$(document).on('click',".list-group-item",function(){

    scrollTopValue = $(window).scrollTop();
    // 改变内容
    var subject = $(this).find('.hiddensubject').html();
    $('.detailtitle').html(subject);

    // 关键词
    $('.detailkeyword').html(keyword);

    // 作者
    var author = $(this).find('.authors').html();
    $('.detailauthor').html(author);

    // 发布时间
    var pubtime = $(this).find('.specifictimes').html();
    $('.detailpubtime').html(pubtime);

    // 简述
    var description = $(this).find('.descriptions').html();
    $('.detaildescription').html(description);

    // url地址
    var url = $(this).find('.hiddenurl').html();
    $('.urltosource').attr('href',url);

    // 显示
    $('.celldetail').css('display','block');
    $('.celltable').css('display','none');

    $(window).scrollTop(0);
});

$(document).on('click',".backbtn",function(){
  $('.celldetail').css('display','none');
  $('.celltable').css('display','block');

  $(window).scrollTop(scrollTopValue);
});
