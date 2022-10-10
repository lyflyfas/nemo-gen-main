/**
 *  Copyright (C) 2018 www.linkinip.com Inc. All rights reserved.
 * 
 * 
 *               			  _ooOoo_
 *                			 o8888888o
 *              			 88" . "88
 *                			 (| ^_^ |)
 *               			 O\  =  /O
 *              		  ____/`---'\____
 *               		.'  \\|     |//  `.
 *              	   /  \\|||  :  |||//  \
 *                    /  _||||| -:- |||||-  \
 *					  |   | \\\  -  /// |   |
 *					  | \_|  ''\---/''  |   |
 *					  \  .-\__  `-`  ___/-. /
 *					___`. .'  /--.--\  `. . __
 *               ."" '<  `.___\_<|>_/___.'  >'"".
 *              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *              \  \ `-.   \_ __\ /__ _/   .-` /  /
 *         ======`-.____`-.___\_____/___.-`____.-'======
 *                            `=---='
 *         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *                         佛祖保佑       永无BUG 
 * 			created on 2018年5月11日 下午5:02:01  by rico
 */

package com.linkinip.nemo.commons.utils;

import java.io.InputStream;

public class ClassLoaderUtil {

	private ClassLoaderUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Copy from Spring, 按顺序获取默认ClassLoader
	 * 
	 * 1. Thread.currentThread().getContextClassLoader()
	 * 
	 * 2. ClassLoaderUtil的加载ClassLoader
	 * 
	 * 3. SystemClassLoader
	 */
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable ex) { // NOSONAR
			// Cannot access thread context ClassLoader - falling back...
		}
		if (cl == null) {
			// No thread context class loader -> use class loader of this class.
			cl = ClassLoaderUtil.class.getClassLoader();
			if (cl == null) {
				// getClassLoader() returning null indicates the bootstrap ClassLoader
				try {
					cl = ClassLoader.getSystemClassLoader();
				} catch (Throwable ex) { // NOSONAR
					// Cannot access system ClassLoader - oh well, maybe the caller can live with null...
				}
			}
		}
		return cl;
	}


	/**
	 * 探测类是否存在classpath中
	 */
	public static boolean isPresent(String className, ClassLoader classLoader) {
		try {
			classLoader.loadClass(className);
			return true;
		} catch (Throwable ex) { // NOSONAR
			// Class or one of its dependencies is not present...
			return false;
		}
	}

	public static InputStream getInputStream(String path) {
		InputStream is = null;
		String pathToUse = StringUtil.cleanPath(path);
		if (pathToUse.startsWith("/")) {
			pathToUse = pathToUse.substring(1);
		}
		ClassLoader classLoader = getDefaultClassLoader();
		if (classLoader != null) {
			is = classLoader.getResourceAsStream(pathToUse);
		}
		return is;
	}


}
