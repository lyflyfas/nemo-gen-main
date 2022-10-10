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
package ${package.Parent?replace('modules','rpc')}.provider.impl;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${package.Parent?replace('modules','rpc')}.provider.${entity?replace('Entity','')}Provider;
import org.springframework.beans.factory.annotation.Autowired;
import com.linkinip.ratel.mybatis.extension.PageParams;
import com.linkinip.ratel.mybatis.extension.pagination.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
/**
 * <p>
 * ${table.comment!} rpc服务实现类
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */
@DubboService(version = "${"${"}ratel.dubbo.version${"}"}")
public class ${entity?replace('Entity','')}ProviderImpl implements ${entity?replace('Entity','')}Provider {

	@Autowired
	private ${table.serviceName} ${table.serviceName?uncap_first};

	@Override
	public ${entity} selectByPk(<#if pkType??>${pkType}</#if> pk) {
		return ${table.serviceName?uncap_first}.selectByPk(pk);
	}

	
	@Override
	public <#if pkType??>${pkType}</#if> saveEntity(${entity} entity) {
		return ${table.serviceName?uncap_first}.saveEntity(entity);
	}

	@Override
	public ${entity} delByKey(<#if pkType??>${pkType}</#if> pk) {
		return ${table.serviceName?uncap_first}.delByKey(pk);
	}
	
	<#if treeFlag??>
	@Override
	public boolean updateTree(${entity} entity) {
		return ${table.serviceName?uncap_first}.updateTree(entity);
	}

	@Override
	public boolean deleteComsByPk(String treeCode) {
			return ${table.serviceName?uncap_first}.deleteComsByPk(treeCode);
	}

	@Override
	public void updateFix() {
		${table.serviceName?uncap_first}.updateFix();
	}

	@Override
	public void updateFix(String parentCode) {
		${table.serviceName?uncap_first}.updateFix(parentCode);
	}
</#if>

	@Override
	public PageInfo<${entity}> queryForPage(PageParams<${entity}> pageParams) {
		return  ${table.serviceName?uncap_first}.queryForPage(pageParams);
	}

}
