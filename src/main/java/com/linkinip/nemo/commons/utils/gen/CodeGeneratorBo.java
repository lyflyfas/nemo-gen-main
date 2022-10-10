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
 * 			created on 2021年12月3日 下午1:14:30  by rico
 */

package com.linkinip.nemo.commons.utils.gen;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * CodeGeneratorBo
 * @author  rico
 * @date 2021年12月3日 下午1:14:30  
 */

@Data
@Accessors(chain = true)
public class CodeGeneratorBo {

    // 包名
    private String packageName;

    // 数据库类型
    private String dbType;
    // 数据库连接地址
    private String dbUrl;
    // 数据库名称
    private String username;
    // 数据库密码
    private String password;
    // 数据库驱动
    private String driver;

    // 表名
    private String [] tableNames;
    // 表前缀
    private String [] tablePrefixes;
    // 字段前缀
    private String [] fieldPrefixes;
    // 排出表的表名
    private String [] excludeTableNames;
    // 忽略的字段
    private String [] ignoreColumns;

    // 作者
    private String author;
    // 输入目录
    private String outDir;

    // 实体类包名
    private String packageEntity=Config.PACKAGE_NAME_MODEL;
    // mapper包名
    private String packageMapper=Config.PACKAGE_NAME_DAO;
    // mapper XML目录名
    private String packageMapperXml=Config.DIR_NAME_XML;
    // service包名
    private String packageService=Config.PACKAGE_NAME_SERVICE;
    // serviceImpl包名
    private String packageServiceImpl=Config.PACKAGE_NAME_SERVICE_IMPL;
    // controller包名
    private String packageController=Config.PACKAGE_NAME_CONTROLLER;

    // 实体类文件名格式
    private String fileNamePatternEntity=Config.FILE_NAME_MODEL;
    // mapper文件名格式
    private String fileNamePatternMapper=Config.FILE_NAME_DAO;
    // mapper XML文件名格式
    private String fileNamePatternMapperXml=Config.FILE_NAME_XML;
    // service文件名格式
    private String fileNamePatternService=Config.FILE_NAME_SERVICE;
    // serviceImpl文件名格式
    private String fileNamePatternServiceImpl=Config.FILE_NAME_SERVICE_IMPL;
    // controller文件名格式
    private String fileNamePatternController=Config.FILE_NAME_CONTROLLER;

    // 逻辑删除字段
    private String fieldLogicDelete=Config.FIELD_LOGIC_DELETE_NAME;
    // 乐观锁字段
    private String fieldVersion=Config.FIELD_VERSION_NAME;

    // 模版引擎
    private String templateEngine=Config.TEMPLATE_ENGINE;
    // 是否支持Swagger
    private Boolean swaggerSupport=true;
    // JDK版本
    private String jdkVersion="8";

    // 是否开启Lombok
    private Boolean lombokModel=true;

    // 是否使用构建者模型
    private Boolean lombokChainModel=false;

    // 字段注解
    private Boolean fieldAnnotation=true;

    // 列常量
    private Boolean columnConstant=false;

    // 二级缓存
    private Boolean enableCache=false;

    // 基础结果Map
    private Boolean baseResultMap=true;

    // 基础列名List
    private Boolean baseColumnList=true;

    // 实体父类的全类名
    private String superEntityClass="com.linkinip.ratel.modules.base.entity.DataEntity";
 // Controller父类的全类名
    private String superControllerClass="com.linkinip.ratel.modules.base.web.AbstractBaseController";
 // 实体父类的全类名
    private String[] superEntityColumns={"created_by_id", "last_modified_by_id", "version", "created_date",
			"last_modified_date","parent_code", "sort_no", "tree_path"};
    private String superMapperClass="com.linkinip.ratel.modules.base.dao.BaseDao";
    private String superServiceClass="com.linkinip.ratel.modules.base.service.CrudService";
    private String superServiceImplClass="com.linkinip.ratel.modules.base.service.impl.AbstractService";
    // mapper注解
    private Boolean mapperAnnotation=true;


}
