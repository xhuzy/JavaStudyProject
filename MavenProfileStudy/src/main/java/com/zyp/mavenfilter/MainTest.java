/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.zyp.mavenfilter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zy.
 * @@version $Id: MainTest, v 0.1 2017/6/27 18:14 zy Exp $
 */
public class MainTest {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("./app-content.xml");
            Param param = (Param) context.getBean("param");
            System.out.println(param.getParam());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
