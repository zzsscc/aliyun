var nodes = [
    { name: "奇摩旅游" }, { name: "台州旅游" }, { name: "三门旅游" }, { name: "安顺风尚标" }, { name: "台州旅游" },
    { name: "新浪微博" }, { name: "腾讯微博" } ,{name : "台州通"}, {name:"一根有仙气的竹竿"},
    {name :"网易新闻"},{name:"中国网"},{name:"人民网"},{name:"洞头新闻网"},{name:"紫色梦想网"},
    {name:"吃喝玩乐网"},{name:"凯迪社区"},{name:"麻辣论坛"},{name:"三国源论坛"},{name:"民生旅游"},{name:"望江论坛"},
    ];

var edges = [ { source : 0 , target: 1 } , { source : 0 , target: 2 } , { source : 0 , target: 6 } ,
              { source : 5 , target: 6 } , { source : 5 , target: 8 } , { source : 5 , target: 9 } ,
              { source : 9 , target: 10 } , { source : 9 , target: 11 } , { source : 9 , target: 12 } , { source : 9 , target: 13 } , { source : 9 , target: 14 },
              { source : 14 , target: 15 } , { source : 14 , target: 16 } , { source : 14 , target: 17 } ,
              { source : 16 , target: 13 },{ source : 16 , target: 18 },{ source : 16 , target: 19 },
            ];


var force = d3.layout.force()
    .nodes(nodes) //指定节点数组
    .links(edges) //指定连线数组
    .size([710,410]) //指定作用域范围
    .linkDistance(150) //指定连线长度
    .charge([-300]); //相互之间的作用力


force.start();    //开始作用


console.log(nodes);
console.log(edges);


var svg=d3.select('svg');
var svg_edges = svg.selectAll("line")
    .data(edges)
    .enter()
    .append("line")
    .style("stroke","#67747e")
    .style("stroke-width",2);

var color = ['#f0eaa9'];

//添加节点
var svg_nodes = svg.selectAll("circle")
    .data(nodes)
    .enter()
    .append("circle")
    .attr("r",8)
    .style({"stroke":"#f0eaa9","fill":"transparent","stroke-width":2})
    .call(force.drag);  //使得节点能够拖动

//添加描述节点的文字
var svg_texts = svg.selectAll("text")
    .data(nodes)
    .enter()
    .append("text")
    .style({"fill": "#6ad0c5","font-size":"12"})
    .attr("dx", 12)
    .attr("dy", 5)
    .text(function(d){
        return d.name;
    });


force.on("tick", function(){ //对于每一个时间间隔
    //更新连线坐标
    svg_edges.attr("x1",function(d){ return d.source.x; })
        .attr("y1",function(d){ return d.source.y; })
        .attr("x2",function(d){ return d.target.x; })
        .attr("y2",function(d){ return d.target.y; });

    //更新节点坐标
    svg_nodes.attr("cx",function(d){ return d.x; })
        .attr("cy",function(d){ return d.y; });

    //更新文字坐标
    svg_texts.attr("x", function(d){ return d.x; })
        .attr("y", function(d){ return d.y; });
});