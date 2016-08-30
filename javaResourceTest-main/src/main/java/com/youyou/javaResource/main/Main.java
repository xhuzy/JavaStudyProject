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
	 * ʹ��class��ȡ��Դʱ�����û��/��ʾ�������ڵ�Ŀ¼���м���
	 */
	public static void getResourceByClass() {
		URL url = Main.class.getResource("../spring/jdbc.properties");
		System.out.println(url.getFile());
	}

	/**
	 * ʹ��class��ȡ��Դ��ʹ����/��ʾ��classpathĿ¼(class)Ŀ¼�½��м���
	 */
	public static void getResourceByClass2() {
		URL url = Main.class.getResource("/com/youyou/javaResource/spring/jdbc.properties");
		System.out.println(url.getFile());
	}

	/**
	 * classLoader����ʱ����Ҫ/
	 */
	public static void getResourceByClassLoaer() {
		URL url = Main.class.getClassLoader().getResource("com/youyou/javaResource/spring/jdbc.properties");
		System.out.println(url.getFile());
	}

	/**
	 * ʹ��spring��PathMatchingResourcePatternResolver֧��ʹ��Ant��ʽ��ȡ��Դ�ļ�
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
