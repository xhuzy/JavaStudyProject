/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.zyp.mavenfilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zy.
 * @@version $Id: Param, v 0.1 2017/6/27 18:13 zy Exp $
 */
@Component("param")
public class Param {
    @Value("${b}")
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
