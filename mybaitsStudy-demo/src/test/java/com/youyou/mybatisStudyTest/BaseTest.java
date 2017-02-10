package com.youyou.mybatisStudyTest;

import java.io.FileNotFoundException;

import javax.swing.Spring;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/app-*.xml")
public class BaseTest {
	/**
	 * Ìí¼Ó×Ö¶Î×¢ÊÍ.
	 */
	protected Logger logger = Logger.getLogger(BaseTest.class);
	static {
		try {
			Log4jConfigurer.initLogging("target/classes/config/log4j.properties");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.err.println("Cannot Initialize log4j");
		}
	}
}
