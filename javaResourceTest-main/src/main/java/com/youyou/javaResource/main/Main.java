package com.youyou.javaResource.main;

import java.io.IOException;
import java.net.URL;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class Main {
	public static void main(String[] args) throws IOException {
		getResourceByClass();
		getResourceByClass2();
		getResourceByClassLoaer();
		getResourceBySpringPathMapping();
	}

	/**
	 * 使用class获取资源时，如果没有/表示从类所在的目录进行加载
	 */
	public static void getResourceByClass() {
		URL url = Main.class.getResource("../spring/jdbc.properties");
		System.out.println(url.getFile());
	}

	/**
	 * 使用class获取资源，使用了/表示从classpath目录(class)目录下进行加载
	 */
	public static void getResourceByClass2() {
		URL url = Main.class.getResource("/com/youyou/javaResource/spring/jdbc.properties");
		System.out.println(url.getFile());
	}

	/**
	 * classLoader加载时不需要/
	 */
	public static void getResourceByClassLoaer() {
		URL url = Main.class.getClassLoader().getResource("com/youyou/javaResource/spring/jdbc.properties");
		System.out.println(url.getFile());
	}

	/**
	 * 使用spring的PathMatchingResourcePatternResolver支持使用Ant方式获取资源文件
	 * 
	 * @throws IOException
	 */
	public static void getResourceBySpringPathMapping() throws IOException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("classpath*:com/youyou/**/*.properties");
		for (Resource resource : resources) {
			System.out.println(resource.getFile().getAbsolutePath());
		}

	}
}
