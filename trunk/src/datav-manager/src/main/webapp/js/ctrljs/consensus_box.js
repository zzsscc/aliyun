
getInfoAndPage();


// 查找数据
function getboxsinfo(topage){
  // 页数
  var page = topage;

  // ajax获取数据
  showLoading();

  $.ajax({
    type: "GET",
    url: "/front/search",
    timeout: 8000,
    data: {
      toPage: page,
      pageSize: "11",
      subject: "",
      from: ""
    },
    success: function (response) {
      hideLoading();

      //string转成json对象
      var jsonObject = JSON.parse(response);


      var totalPages = jsonObject.totalPages;


      //获取数据数组
      var result = jsonObject.result.records;
      var totalCount = jsonObject.totalCount;
      var success = jsonObject.success;
      var message = jsonObject.message;

      // 查到数据了
      if(success == true){

        if(totalCount==0){
          alert("未查到数据");
          $('.public-sentiment-box-main').html("");
          $('.public-sentiment-box-main').html('<p>未找到数据</p>');
        }
        for(var i=0; i<result.length;i++){
          // var keyword = result[i].monitorKeywords;
          var title = result[i].subject;
          var createdAt = result[i].createdAt;
          var url = result[i].url;


          // 改变html页面中数据内容
          // html 关键词
          // var h_keyword = "#keyword"+(i+1);
          //
          // if(i<11){
          //   $(h_keyword).html(keyword);
          // }
          // html 标题
          var h_title = "#title"+(i+1);

          if(i<11){
            $(h_title).html(title);
          }

          // html 时间日期
          var h_time = "#time"+(i+1);

          var date = new Date(createdAt);
          var year = date.getFullYear();
          var month = date.getMonth();
          var day = date.getDate();

          var time = year+"."+month+"."+day;

          if(i<11){
            $(h_time).html(time);
          }

          // html url原地址
          var h_url = "#url"+(i+1);
          // console.log(h_url);
          // console.log(url);
          if(i<11){
            $(h_url).html(url);
          }

        }
      }
      // 如果查询失败
      else{
        $('.public-sentiment-box-main').html('<p>'+message+'</p>');
        hideLoading();
      }




      document.getElementById("page-wrap").style.display = "block";
    },
    error: function(){
      // console.log("查找失败!");
        hideLoading();
    }
  });
}

// 查页数生成页码栏
function getInfoAndPage(){
  // 页数
  var page = 1;
  showLoading();

  $.ajax({
    type: "GET",
    url: "/front/search",
    timeout: 8000,
    data: {
      toPage: page,
      pageSize: "11",
    },
    success: function (response) {
      hideLoading();

      //string转成json对象
      var jsonObject = JSON.parse(response);

      var totalPages = jsonObject.totalPages;
      var success = jsonObject.success;
      var message = jsonObject.message;


      //获取数据数组
      var result = jsonObject.result.records;
      var totalCount = jsonObject.totalCount;

      if(success == true){
        // 无数据
        if(totalCount == 0){
          alert("未查到数据");
          $('.public-sentiment-box-main').html("");
          $('.public-sentiment-box-main').append('<p>没有查到数据</p>');

        }

        else if(totalCount >0 && totalCount<12){
          for(k=0;k<totalCount;k++){

            // var keywordid = "keyword"+(k+1);
            var titleid = "title"+(k+1);
            var urlid = "url"+(k+1);
            var timeid = "time"+(k+1);
            $('.public-sentiment-box-main').append('<li class="clearfix"><div id="'+titleid+'" class="box-news-title"></div><div id="'+urlid+'" class="url"></div><div id="'+timeid+'" class="box-news-time"></div><div class="box-news-source blue clearfix"/></li>');
          }
          document.getElementById("page-wrap").style.display = "block";
        }
        else{
          for(l=0;l<11;l++){
            // var keywordid = "keyword"+(l+1);
            var titleid = "title"+(l+1);
            var urlid = "url"+(l+1);
            var timeid = "time"+(l+1);
            $('.public-sentiment-box-main').append('<li class="clearfix"><div id="'+titleid+'" class="box-news-title"></div><div id="'+urlid+'" class="url"></div><div id="'+timeid+'" class="box-news-time"></div><div class="box-news-source blue clearfix"/></li>');

          }
          document.getElementById("page-wrap").style.display = "block";
        }


        for(var i=0; i<result.length;i++){
          // var keyword = result[i].monitorKeywords;
          var title = result[i].subject;
          var createdAt = result[i].createdAt;
          var url = result[i].url;
          // 改变html页面中数据内容
          // html 关键词
          // var h_keyword = "#keyword"+(i+1);
          // // console.log(h_keyword);
          // if(i<11){
          //   $(h_keyword).html(keyword);
          // }
          // html 标题
          var h_title = "#title"+(i+1);
          // console.log(h_title);
          if(i<11){
            $(h_title).html(title);
          }

          // html 时间日期
          var h_time = "#time"+(i+1);
          // console.log(h_time);
          var date = new Date(createdAt);
          var year = date.getFullYear();
          var month = date.getMonth();
          var day = date.getDate();

          var time = year+"."+month+"."+day;

          if(i<11){
            $(h_time).html(time);
          }

          // html url原地址
          var h_url = "#url"+(i+1);
          // console.log(h_url);
          // console.log(url);
          if(i<11){
            $(h_url).html(url);
          }

        }
        //改变页码栏totalPages
        $('#page-wrap').jqPaginator({
            totalPages: totalPages,
            visiblePages: 7,
            currentPage: 1,
            onPageChange: function (num, type) {
                // pagenum=num;
                getboxsinfo(num);
            }
        });

      }
      // 没查到数据
      else{
          $('.public-sentiment-box-main').html("");
          $('.public-sentiment-box-main').append('<p>'+message+'</p>');
      }


    },
    error: function(){

        hideLoading();
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
            (getWindowInnerHeight() - $("#loadingTip").height()) / 2 + 'px');
    $(".spinner").css('left',
            (getWindowInnerWidth() - $("#loadingTip").width()) / 2 + 'px');

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

function getnowpagefresh(){
  var s = $('.page.active').children().html();
  getboxsinfo(s);
}




$(document).on('click',".box-checkbox",function () {
    $(this).parent().toggleClass("colorchange");
});

$(document).on('click',".box-news-title",function () {
    window.open($(this).next('.url').html());
});
