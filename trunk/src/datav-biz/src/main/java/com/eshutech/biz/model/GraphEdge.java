/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: GraphEdge
 * Creator:  wanggao
 * Create-Date: 上午10:39
 **/
package com.eshutech.biz.model;

/**
 *
 * @author: Kim
 * @date: 16/10/11
 * @time: 上午10:39
 *
 */
public class GraphEdge {
    private String id;
    private String source;
    private String target;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
