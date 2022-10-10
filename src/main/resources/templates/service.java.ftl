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
 * 			created on ${date}  by ${author}
 */
package ${package.Service};

import ${package.Entity}.${entity};
import com.linkinip.ratel.mybatis.extension.PageParams;
import com.linkinip.ratel.mybatis.extension.pagination.PageInfo;
<#if treeFlag??>
import com.linkinip.ratel.modules.base.service.TreeService;
<#else> 
import ${superServiceClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends <#if treeFlag??>TreeService<${entity}><#else>${superServiceClass}<${entity}<#if pkType??>,${pkType}</#if>></#if> {

	${entity} selectByPk(<#if pkType??>${pkType}</#if> pk);

	
	PageInfo<${entity}> queryForPage(PageParams<${entity}> pageParams);

	
	<#if pkType??>${pkType}</#if> saveEntity(${entity} entity);

	${entity} delByKey(<#if pkType??>${pkType}</#if> pk);

<#if treeFlag??>
	boolean updateTree(${entity} entity);

	boolean deleteComsByPk(String treeCode);

	void updateFix();

	void updateFix(String parentCode);
</#if>
}
</#if>
