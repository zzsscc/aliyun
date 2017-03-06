BundleDemo = function () {
    this.box = new ElementBox();
    this.network = demo.Util.createDraggableNetwork(this.box);
    this.sheet = new PropertySheet(this.box);
};
twaver.Util.ext('BundleDemo', Object, {
    init: function () {
        var mainSplit = new SplitPane(this.network, this.sheet, 'horizontal', 0.7);
        demo.Util.appendChild(mainSplit.getView(), document.getElementById('main'), 0, 0, 0, 0);
        window.onresize = function (e) { mainSplit.invalidate(); };
        this.initSheet();
        this.initBox();
    },
    initSheet: function () {
        this.sheet.setEditable(true);
        this.sheet.setVisibleFunction(function (property) {
            return this.getDataBox().getSelectionModel().getLastData() instanceof twaver.Link;
        });
        var propertyBox = this.sheet.getPropertyBox();
        demo.Util.addStyleProperty(propertyBox, 'link.type', 'Basic').setEnumInfo(demo.LINK_TYPE);
        demo.Util.addStyleProperty(propertyBox, 'link.width', 'Basic');
        demo.Util.addStyleProperty(propertyBox, 'link.color', 'Basic');
        demo.Util.addStyleProperty(propertyBox, 'link.extend', 'Basic');

        demo.Util.addStyleProperty(propertyBox, 'link.looped.type', 'Link Loop').setEnumInfo(demo.LINK_LOOPED_TYPE);
        demo.Util.addStyleProperty(propertyBox, 'link.looped.gap', 'Link Loop');
        demo.Util.addStyleProperty(propertyBox, 'link.looped.direction', 'Link Loop').setEnumInfo(demo.DIRECTION_TYPE);

        demo.Util.addStyleProperty(propertyBox, 'link.bundle.enable', 'Link Bundle');
        demo.Util.addStyleProperty(propertyBox, 'link.bundle.id', 'Link Bundle');
        demo.Util.addStyleProperty(propertyBox, 'link.bundle.expanded', 'Link Bundle');
        demo.Util.addStyleProperty(propertyBox, 'link.bundle.independent', 'Link Bundle');
        demo.Util.addStyleProperty(propertyBox, 'link.bundle.offset', 'Link Bundle');
        demo.Util.addStyleProperty(propertyBox, 'link.bundle.gap', 'Link Bundle');

        this.sheet.expandAll();
    },
    initBox: function () {
        this.initLoop();
        this.initGroup();
    },
    initGroup: function () {
        function FlowLink () {
          FlowLink.superClass.constructor.apply(this, arguments);
          var self = this;
          this.animate = new twaver.Animate({
            from: 0,
            to: 15,
            repeat: Number.POSITIVE_INFINITY,
            reverse: false,
            onUpdate: function (value) {
              var network = self.getClient('network');
              if(!network) return;
              self._styleMap["link.flow.offset"] = 15* value;
              network.invalidateElementUI(self);
          },
          onDone: function () {

          }
      });
      }

      twaver.Util.ext(FlowLink, twaver.Link, {
          playAnimate:function(dur,speed){
            this.animate.dur = dur || 1;
            this.animate.play();
        }
    });

      var from = new twaver.Node();
      from.setName("from");
      from.setLocation(120, 360);
      var to = new twaver.Node();
      to.setName("to");
      to.setLocation(420, 450);

      this.box.add(from);
      this.box.add(to);

      var i = 0;
      var link;
      for (i = 0; i < 6; i++) {
        link = new twaver.Link(from, from);
        link.setStyle('link.looped.type', 'rectangle');
        link.setStyle('link.handler.fill', true);
        if (i % 2 == 0) {
            link.setStyle('link.bundle.id', 0);
            link.setStyle('link.color', '#00FFFF');
            link.setStyle('link.handler.fill.color', '#00FFFF');
            link.setStyle('link.handler.xoffset', -5);
            link.setStyle('link.handler.yoffset', -5);
        } else {
            link.setStyle('link.bundle.id', 1);
            link.setStyle('link.color', '#FF00FF');
            link.setStyle('link.handler.fill.color', '#FF00FF');
            link.setStyle('link.handler.xoffset', 5);
            link.setStyle('link.handler.yoffset', 5);
        }
        this.box.add(link);
    }

    for (i = 0; i < 3; i++) {
        link = new twaver.Link(from, to);
        link.setStyle('link.color', '#0000FF');
        link.setStyle('link.handler.color', '#0000FF');
        link.setStyle('link.bundle.id', 1);
        this.box.add(link);
    }
    for (i = 0; i < 4; i++) {
        link = new twaver.Link(from, to);
        link.setStyle('link.color', '#FF0000');
        link.setStyle('link.handler.color', '#FF0000');
        link.setStyle('link.bundle.id', 2);
        this.box.add(link);
    }
    for (i = 0; i < 5; i++) {
        link = new twaver.Link(from, to);
        link.setStyle('link.color', '#00FF00');
        link.setStyle('link.handler.color', '#00FF00');
        link.setStyle('link.bundle.id', 3);
        this.box.add(link);
    }

    for(var i = 0;i<3;i++){
        var link = new FlowLink(from, to);
        link.s('link.color', '#A5D8F0').
        s('link.width', 1).
        s('link.pattern', [6, 6]).
        s('link.flow', true).
        s('link.color', twaver.Util.randomColor()).
        s('link.flow.color', 'white').
        s('link.width',3).
        setClient('network',this.network).
        playAnimate((i+1)*3000,0);
        this.box.add(link);
    }
},
initLoop: function () {
    var length = demo.DIRECTION_TYPE.length;
    var xGap = 150;
    var yGap = 100;
    for (var i = 0; i < length; i++) {
        var node = new twaver.Node();
        node.setStyle('label.fill', true);
        node.setLocation(80 + (i % 4) * xGap, Math.floor(i / 4) * yGap + 80);
        this.box.add(node);
        this.createLoopLinks(node, demo.DIRECTION_TYPE[i], demo.POSITION_TYPE[i], i <= length / 2 ? 'arc' : 'rectangle');
    }
},
createLoopLinks: function (node, direction, position, loopType) {
    node.setName(direction);
    for (var i = 0; i < 6; i++) {
        var link = new twaver.Link(node, node);
        link.setStyle('link.looped.direction', direction);
        link.setStyle('link.handler.position', position);
        link.setStyle('link.looped.type', loopType);
        this.box.add(link);
    }
}
});