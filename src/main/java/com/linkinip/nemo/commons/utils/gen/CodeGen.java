/**
 *  Copyright (C) 2021 www.linkinip.com Inc. All rights reserved.
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
 * 			created on 2021年12月3日 上午11:54:04  by rico
 */

package com.linkinip.nemo.commons.utils.gen;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.linkinip.nemo.commons.utils.ClassLoaderUtil;
import com.linkinip.nemo.commons.utils.MyBatisPlusAutoGenerator;
import com.linkinip.nemo.commons.utils.gen.xml.XmlUtil;

/**
 * CodeGen
 * 
 * @author rico
 * @date 2021年12月3日 上午11:54:04
 */

public class CodeGen {
	public void codeGen()
			throws InvalidConfigurationException, XMLParserException, IOException, SQLException, InterruptedException {
		InputStream in = ClassLoaderUtil.getInputStream("generatorConfig.xml");
		// MBG 执行过程中的警告信息
		List<String> warnings = new ArrayList<>();
		// 读取我们的 MBG 配置文件
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(in);
		in.close();
		// 当生成的代码重复时，不要覆盖原代码
		DefaultShellCallback callback = new DefaultShellCallback(true);
		// 创建 MBG
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		// 执行生成代码
		myBatisGenerator.generate(null);
		// 输出警告信息
		warnings.forEach(System.err::println);
	}

	public void mybaitsPlusCodeGen(CodeGeneratorBo bo) {
		MyBatisPlusAutoGenerator gen = new MyBatisPlusAutoGenerator(bo);
		gen.execute();
	}

	public void xmlGen() {
		InputStream in = ClassLoaderUtil.getInputStream("generatorConfig.xml");
		XmlUtil xmlUtil = XmlUtil.of(in);
		System.out.println(xmlUtil.toMap());
	}

	public static void main(String[] args) {
		CodeGen cg = new CodeGen();
		String dbUrl = "jdbc:mysql://127.0.0.1:3306/ratel-saas?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&failOverReadOnly=false";
		String outputDir = "d:/tmp";
		CodeGeneratorBo bo = new CodeGeneratorBo();
		bo.setDbUrl(dbUrl);
		bo.setUsername("root");
		bo.setPassword("123456");
		bo.setOutDir(outputDir);
		bo.setAuthor("rico");
		bo.setPackageName("com.linkinip.ratel.modules.sys");
		bo.setTablePrefixes(new String[] {"s_"});
		bo.setTableNames(new String[] { "s_job_log", "s_quartz_job", "s_permission", "s_menu", "s_prores" ,"s_area"});
		cg.mybaitsPlusCodeGen(bo);
	}
}
