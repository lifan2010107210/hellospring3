package com.test;

/**
 * 操作实体类接口的实现类
 * @author dhc
 *
 */
public class FirstImpl implements IFirst {

	@Override
	public String sayFirst(String words) {
		return "fuck +++++++" + words;
	}

}
