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
package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
<#if statusFlag??>
import com.linkinip.ratel.modules.sys.constants.DataStatusEnum;
 </#if> 
<#if treeFlag??>
import com.linkinip.ratel.modules.base.service.impl.AbstractTreeSortService;
<#else> 
import ${superServiceImplClassPackage};
</#if>
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.linkinip.ratel.mybatis.extension.PageParams;
import com.linkinip.ratel.mybatis.extension.pagination.PageInfo;
<#if sortFlag??>
import org.apache.commons.collections.CollectionUtils;
import com.linkinip.ratel.mybatis.extension.pagination.OrderMapping;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
 </#if>
/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends <#if treeFlag??>AbstractTreeSortService<${entity},${table.mapperName}><#else>${superServiceImplClass}<${entity}<#if pkType??>,${pkType}</#if>,${table.mapperName}></#if> implements ${table.serviceName} {

	@Override
	public ${entity} selectByPk(<#if pkType??>${pkType}</#if> pk) {
		return super.getById(pk);
	}

	
	@Override
	public <#if pkType??>${pkType}</#if> saveEntity(${entity} entity) {
		if (dataExisted(entity)) {
			updateByPk(entity);
		} else {
		  <#if statusFlag??>
			entity.setStatus(DataStatusEnum.ENABLED.getValue());
			 </#if>
			insertEntity(entity);
		}
		return entity.getId();
	}

	@Override
	public ${entity} delByKey(<#if pkType??>${pkType}</#if> pk) {
		return deleteByPk(pk);
	}
	
	<#if treeFlag??>
	@Override
	public boolean updateTree(${entity} entity) {
		return super.updateTreePath(entity);
	}

	@Override
	public boolean deleteComsByPk(String treeCode) {
		${entity}  old = selectByPk(treeCode);
		if (old != null) {
			return super.deleteComsByTreeCode(treeCode, old);
		}
		return false;
	}

	@Override
	public void updateFix() {
		super.updateFixTreePath();
	}

	@Override
	public void updateFix(String parentCode) {
		super.updateFixTreePath(parentCode);
	}
</#if>

	@Override
	public PageInfo<${entity}> queryForPage(PageParams<${entity}> pageParams) {
		<#if sortFlag??>
		if (CollectionUtils.isEmpty(pageParams.getOrders())) {
			pageParams.defaultPageSort(OrderItem.desc(<#if sortNoField??>OrderMapping.SORT_NO<#else>OrderMapping.LAST_MODIFIED_DATE</#if>));
		}
		</#if>
		return new PageInfo<>(super.list2page(pageParams.buildPage(pageParams), pageParams.getModel(), pageParams.getColumnArray()));
	}

	@Override
	public QueryWrapper<${entity}> getQueryWrapper(${entity} entity) {
		if (entity == null) {
			return Wrappers.query();
		}
		return Wrappers.query(entity);
	}
}
</#if>
