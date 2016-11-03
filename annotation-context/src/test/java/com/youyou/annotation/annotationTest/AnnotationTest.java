package com.youyou.annotation.annotationTest;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import com.youyou.annotation.annotation.NeedTest;
import com.youyou.annotation.service.AnnotationService;

import junit.framework.TestCase;

public class AnnotationTest extends TestCase {
	@Test
	public void testGetAnnotation() {
		Class clazz = AnnotationService.class;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			NeedTest needTest = method.getAnnotation(NeedTest.class);

			System.out.println(method.getName()+":"+needTest.value() + needTest.methodDesc());
		}

		Assert.assertEquals(true, true);
	}

}
