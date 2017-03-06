/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: GraphNodeModel
 * Creator:  wanggao
 * Create-Date: 上午10:37
 **/
package com.eshutech.biz.model.aliyun;

/**
 *
 * @author: Kim
 * @date: 16/10/11
 * @time: 上午10:37
 *
 */
public class GraphNode {
    private String id;
    private String label;
    private String viz_size;
    private String viz_position_x;
    private String viz_position_y;
    private String viz_position_z;
    private String viz_color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getViz_size() {
        return viz_size;
    }

    public void setViz_size(String viz_size) {
        this.viz_size = viz_size;
    }

    public String getViz_position_x() {
        return viz_position_x;
    }

    public void setViz_position_x(String viz_position_x) {
        this.viz_position_x = viz_position_x;
    }

    public String getViz_position_y() {
        return viz_position_y;
    }

    public void setViz_position_y(String viz_position_y) {
        this.viz_position_y = viz_position_y;
    }

    public String getViz_position_z() {
        return viz_position_z;
    }

    public void setViz_position_z(String viz_position_z) {
        this.viz_position_z = viz_position_z;
    }

    public String getViz_color() {
        return viz_color;
    }

    public void setViz_color(String viz_color) {
        this.viz_color = viz_color;
    }
}
