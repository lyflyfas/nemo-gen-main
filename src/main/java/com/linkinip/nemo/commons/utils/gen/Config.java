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
 * 			created on 2021年12月3日 下午1:18:06  by rico
 */

package com.linkinip.nemo.commons.utils.gen;

/**
 * TODO
 * @author  rico
 * @date 2021年12月3日 下午1:18:06  
 */

public class Config {

    /** 包名：controller */
    public static final String PACKAGE_NAME_CONTROLLER = "web";

    /** 包名：service */
    public static final String PACKAGE_NAME_SERVICE = "service";

    /** 包名：service.impl */
    public static final String PACKAGE_NAME_SERVICE_IMPL = "service.impl";

    /** 包名：model */
    public static final String PACKAGE_NAME_MODEL = "entity";

    /** 包名：dao */
    public static final String PACKAGE_NAME_DAO = "dao";

    /** 目录名：xml */
    public static final String DIR_NAME_XML = "mapper";

    /** 文件名后缀：Model */
    public static final String FILE_NAME_MODEL = "%sEntity";

    /** 文件名后缀：Dao */
    public static final String FILE_NAME_DAO = "%sDao";

    /** 文件名后缀：Mapper */
    public static final String FILE_NAME_XML = "%sDao";

    /** MP开头，Service结尾 */
    public static final String FILE_NAME_SERVICE = "%sService";

    /** 文件名后缀：ServiceImpl */
    public static final String FILE_NAME_SERVICE_IMPL = "%sServiceImpl";

    /** 文件名后缀：Controller */
    public static final String FILE_NAME_CONTROLLER = "%sController";

    /** 逻辑删除字段 */
    public static final String FIELD_LOGIC_DELETE_NAME = "deleted";


    /** 乐观锁字段名 */
    public static final String FIELD_VERSION_NAME = "version";

    /** 作者 */
    public static final String AUTHOR = "rico";

    /** 生成文件的输出目录 */
    public static String PROJECT_PATH = System.getProperty("user.dir");

    /** 输出目录 */
    public static final String OUTPUT_DIR = PROJECT_PATH + "/temp/code-gen";

    /** 模板引擎。velocity / freemarker / beetl */
    public static final String TEMPLATE_ENGINE = "freemarker";

    /** 是否支持Swagger，默认不支持 */
    public static final Boolean SWAGGER_SUPPORT = false;

}
