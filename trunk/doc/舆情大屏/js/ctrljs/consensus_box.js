function getboxsinfo(){
  // 页数
  var page = $(".page-active").html();
  // var key = $(".mediat-name .ss").html();
  // console.log(page);
  // ajax获取数据
  $.ajax({
    type: "GET",
    url: "http://192.168.3.44:8080/front/search",
    timeout: 8000,
    data: {
      toPage: page,
      pageSize: "11",
      subject: "",
      from: ""
    },
    success: function (response) {
      console.log(response);
      // var jsonObject = eval('(' + response + ')');
      // var result= jsonObject.result;

      // console.log(response);
      //string转成json对象
      var jsonObject = JSON.parse(response);

      //获取数据数组
      var result = jsonObject.result.records;
      var totalCount = jsonObject.totalCount;

      if(totalCount == 0){
        alert("查找到的数据数为0");
      }

      for(var i=0; i<result.length;i++){
        var keyword = result[i].monitorKeywords;
        var title = result[i].subject;
        var createdAt = result[i].createdAt;
        var url = result[i].url;
        // console.log(keyword);
        // console.log(title);
        // console.log(createdAt);
        // console.log("");

        // 改变html页面中数据内容
        // html 关键词
        var h_keyword = "#keyword"+(i+1);
        // console.log(h_keyword);
        if(i<11){
          $(h_keyword).html(keyword);
        }
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
    },
    error: function(){
      console.log("查找失败!");
    }
  });
}

function test(){
  // 页数
  var page = $(".page-active").html();
  console.log("page: "+page);
  // 媒体来源
  var medias = $(".mediaselected");
  var media = ""
  console.log(medias.length);
  console.log("medias: ");
  for(i=0;i<medias.length;i++){

        media += medias[i].innerHTML;
        if(i<medias.length-1){
          media +=",";
        }
  };
  console.log(media);
  // 关键词
  var keywords = $(".keywordselected");
  var keyword = ""
  console.log(keywords.length);
  console.log("keywords: ");
  for(i=0;i<keywords.length;i++){

        keyword += keywords[i].innerHTML;
        if(i<keywords.length-1){
          keyword +=",";
        };
  };
  console.log(keyword);

}
