function init() {
    var box = new twaver.ElementBox();
    var network = new twaver.vector.Network(box);
    var view = network.getView();
    document.getElementById('dianlutu').appendChild(view);

    network.adjustBounds({x: 0, y: 0, width: 710, height: 410});

    twaver.Styles.setStyle('label.color','#6ad0c5');
    twaver.Styles.setStyle('select.color','transparent');

    //var node1 = new twaver.Node();
    //node1.setName("网易新闻");
    //node1.setLocation(420, 270);
    //box.add(node1);
    //var node2 = new twaver.Node();
    //
    //
    //node2.setName("新浪微博");
    //node2.setLocation(245, 220);
    //box.add(node2);
    //
    //
    //var link = new twaver.Link(node1, node2);
    //box.add(link);

    function initDataBox() {
        //小圆圈矢量图
        var weibobimg = new Image();
        weibobimg.src = '../img/微博1无发光.png';
        weibobimg.onload = function () {
            weibobimg.onload = null;
            twaver.Util.registerImage('weibolgimg', weibobimg, 38, 38);
            network.invalidateElementUIs();
        };
        twaver.Util.registerImage('weibolg', {
            w: 38,
            h: 38,
            //shadowOffsetX: 0,
            //shadowOffsetY: 0,
            //shadowBlur: 5,
            //shadowColor: '#fccedb',
            origin: {
                x: 0,
                y: 0
            },
            pattern: 'weibolgimg',
            v: [
                {
                    shape: 'circle',
                    r: 19,
                    cx: 19,
                    cy: 19
                }
            ]
        });


        var weibosmimg = new Image();
        weibosmimg.src = '../img/微博2无发光.png';
        weibosmimg.onload = function () {
            weibosmimg.onload = null;
            twaver.Util.registerImage('weibosmimg', weibosmimg, 30, 30);
            network.invalidateElementUIs();
        };
        twaver.Util.registerImage('weibosm', {
            w: 30,
            h: 30,
            origin: {
                x: 0,
                y: 0
            },
            pattern: 'weibosm',
            v: [
                {
                    shape: 'circle',
                    r: 15,
                    cx: 15,
                    cy: 15
                }
            ]
        });


        var weiboxsimg = new Image();
        weiboxsimg.src = '../img/微博3无发光.png';
        weiboxsimg.onload = function () {
            weiboxsimg.onload = null;
            twaver.Util.registerImage('weiboxsimg', weiboxsimg, 24, 24);
            network.invalidateElementUIs();
        };
        twaver.Util.registerImage('weiboxs', {
            w: 24,
            h: 24,
            origin: {
                x: 0,
                y: 0
            },
            pattern: 'weiboxs',
            v: [
                {
                    shape: 'circle',
                    r: 12,
                    cx: 12,
                    cy: 12
                }
            ]
        });



        //画点和线
        //新闻
        var node1 = new twaver.Node({
            name: '网易新闻',
            Image:'weibolgimg',
            location: {
                x: 420,
                y: 270
            }
        });
        box.add(node1);

        var node2 = new twaver.Node({
            name: '人民网',
            Image:'weibosmimg',
            location: {
                x: 365,
                y: 150
            }
        });
        box.add(node2);
        createLink(node1,node2,"#7b8a96");

        var node3 = new twaver.Node({
            name: '中国网',
            Image:'weibosmimg',
            location: {
                x: 330,
                y: 225
            }
        });
        box.add(node3);
        createLink(node1,node3,"#7b8a96");

        var node4 = new twaver.Node({
            name: '紫色梦想网',
            Image:'weiboxsimg',
            location: {
                x: 475,
                y: 165
            }
        });
        box.add(node4);
        createLink(node2,node4,"#7b8a96");



        //添加两点之间的连接线
        function createLink(from,to,color,type,splitValue){
            var link = new twaver.Link(from,to);
            if(type){
                link.setStyle('link.type',type);
            }
            if(color){
                link.setStyle('link.color',color);
            }
            if(splitValue){
                link.setStyle('link.split.percent',splitValue);
            }
            box.add(link);
            return link;
        }
    }

    initDataBox();



}
init();