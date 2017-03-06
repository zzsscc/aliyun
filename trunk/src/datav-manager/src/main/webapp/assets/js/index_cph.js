// Initialize rickshaw chart
var graph;
var getwidth;
var t = setTimeout( function(){


      getwidth = $("#nowwidth").width();
      console.log("宽度： "+getwidth);
      createChart();
    },
 100 );
// document.getElementById("getwidth").style.width;

// document.getElementById("div").style.width
// 数据
//x,y结构体
// function rickshawObject(x,y){
//   this.x = x;
//   this.y = y;
// }
function createChart(){
  var seriesData = [ [] ];
  var random = new Rickshaw.Fixtures.RandomData(50);

  var xv = 10;
  var yv = 200;
  var y0v = 0;
  console.log("xv: "+typeof xv);
  console.log("yv: "+typeof yv);
  // seriesData[0].push({x:0,y:200});
  console.log(seriesData[0]);
  for(var j=0;j<10;j++){
    seriesData[0].push({x:j,y:10});
  }


  random.addDatachange(seriesData,xv,yv);

  graph = new Rickshaw.Graph( {
      element: document.querySelector("#realtime-rickshaw"),
      renderer: 'area',
      height: 200,
      width: getwidth,
      // width:1000,
      // max:500,
      // min:200,
      series: [{
          name: '当前舆情数:',
          color: '#9675ce',
          data: seriesData[0]
      }]


  });
  // var x_axis = new Rickshaw.Graph.Axis.Time({
  //   graph:graph
  // });

  var hoverDetail = new Rickshaw.Graph.HoverDetail( {
      graph: graph,
      xFormatter:function(x){
        // return new Date(x * 1000).toString();
        return getNowTime();
      }
  });
  // var format = function(n) {
  //
  // 	var map = {
  // 		0: 'zero',
  // 		1: 'first',
  // 		2: 'second',
  // 		3: 'third',
  // 		4: 'fourth'
  // 	};
  //
  // 	return map[n];
  // }

  // var ticksTreatment = 'glow';
  //
  // var x_ticks = new Rickshaw.Graph.Axis.X( {
  // 	graph: graph,
  // 	// orientation: 'bottom',
  // 	// element: document.getElementById('x_axis'),
  // 	// pixelsPerTick: 100,
  // 	// tickFormat: format,
  //   // tickSize:30
  // } );


  // var x_ticks = new Rickshaw.Graph.Axis.Time( {
  // 	graph: graph,
  // 	// orientation: 'bottom',
  //   ticksTreatment: ticksTreatment,
  //   timeFixture: new Rickshaw.Fixtures.Time.Local()
  // 	// pixelsPerTick: 200,
  // 	// tickFormat: format,
  //   // tickSize:30
  // } );

  // x_ticks.render();
  // x_ticks.render();


  graph.render();

  setInterval( function() {
      getTotalCounts();
      random.removeData(seriesData);
      random.addDatachange(seriesData,xv,yv);
      graph.update();
      $('.nowConsensus').html(yv);
      xv=xv+1;
      // yv=yv+1;

  },3000);

}

// var xAxis = new Rickshaw.Graph.Axis.Time( {
// 	graph: graph,
// 	ticksTreatment: ticksTreatment,
// 	// timeFixture: new Rickshaw.Fixtures.Time.Local()
// } );

//* Initialize rickshaw char

// function rickshawObject(x,y,y0){
//   this.x = x;
//   this.y = y;
//   this.y0 = y0;
// }

function timelyChangeSvg(){
  // window.setInterval("getTotalCounts()",3000);

}

function getNowTime(){
    var date = new Date();
    // date.getFullYear();
    date.getFullYear();   //获取系统的年；
    date.getMonth()+1;   //获取系统月份，由于月份是从0开始计算，所以要加1
    date.getDate(); // 获取系统日，
    date.getHours(); //获取系统时，
    date.getMinutes(); //分
    date.getSeconds(); //秒
    return date;
}

function getTotalCounts(){
  $.ajax({
    type: "GET",
    url: "/front/search",
    timeout: 8000,
    data: {
      toPage: 1,
      pageSize: "14",
      subject: "",
      from: ""
    },
    success: function (response) {
      //string转成json对象
      var jsonObject = JSON.parse(response);
      var totalPages = jsonObject.totalPages;
      //获取数据数组
      var result = jsonObject.result.records;
      var totalCount = jsonObject.totalCount;
      var success = jsonObject.success;

      // 查到数据了
      if(success == true){
        // 打印结果集
        // console.log(result);
        if(result == null){
        }else{
          if(result.length>0){
            if(totalPages>0){
              // maxpage = totalPages;
            }
            // console.log("totalCount: ")+totalCount;
            // $('.totalCount').html(totalCount);
            yv = totalCount;
            console.log();
            // return totalCount;
            // console.log("length: "+result.length);
          }else{
            // $('.nodatalist').css('display','block');
          }



        }
      }

    },
    error: function(){
      //console.log("查找失败!");
        // hideLoading();
    }
  });
}
