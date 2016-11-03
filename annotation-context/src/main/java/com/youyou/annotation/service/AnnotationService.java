package com.youyou.annotation.service;

import com.youyou.annotation.annotation.NeedTest;

public interface AnnotationService {
	@NeedTest(value = true, methodDesc = "需要测试")
	public void needTest();

	@NeedTest(value = false, methodDesc = "不需要测试")
	public boolean notNeedTest();
}
