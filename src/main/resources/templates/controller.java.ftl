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
package ${package.Controller};

import ${package.Service}.${table.serviceName};
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.linkinip.ratel.framework.core.message.ResponseMessage;
import com.linkinip.ratel.modules.base.log.AccessLogger;
import com.linkinip.ratel.mybatis.extension.PageParams;
import com.linkinip.ratel.mybatis.extension.pagination.PageInfo;
import org.apache.commons.lang3.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import ${package.Entity}.${entity};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * ${table.comment!} 前端控制器
 *
 * @author ${author}
 * @date ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@Validated
@RequestMapping("/api<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen?replace('-entity','')}<#else>${table.entityPath}</#if>")
@AccessLogger("${table.comment!}管理")
@Api(value = "${table.comment!}管理", tags = "<#if controllerMappingHyphenStyle??>${controllerMappingHyphen?replace('-entity','')}<#else>${table.entityPath}</#if>", description = "${table.comment!}管理")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
	@Autowired
	private ${table.serviceName} ${table.serviceName?uncap_first};
	
	@ApiOperation(value = "${table.comment!}列表数据")
	@PostMapping(value = "listData")
	public ResponseMessage<PageInfo<${entity}>> listData(@RequestBody  PageParams<${entity}> pageParams) {
		return ok(${table.serviceName?uncap_first}.queryForPage(pageParams));
	}
	
	@ApiOperation(value = "发布${table.comment!}")
	@PostMapping(value = "release")
	public ResponseMessage<<#if pkType??>${pkType}</#if>> release(@RequestBody @Valid ${entity} ${entity?uncap_first}) {
		return ok(${table.serviceName?uncap_first}.saveEntity(${entity?uncap_first}));
	}
	
	@ApiOperation(value = "${table.comment!}详细信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "<#if pkName??>${pkName}</#if>", value = "编码", required = true, dataType = "String", paramType = "path") })
	@GetMapping(value = "{<#if pkName??>${pkName}</#if>:[a-zA-z0-9]+}")
	public ResponseMessage<${entity}> get${entity}(@PathVariable String <#if pkName??>${pkName}</#if>) {
		return ok(${table.serviceName?uncap_first}.selectByPk(<#if pkName??>${pkName}</#if>));
	}
	
	@ApiOperation(value = "删除${table.comment!}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "<#if pkName??>${pkName}</#if>", value = "编码", required = true, dataType = "String", paramType = "path") })
	@PostMapping(value = "/del/{<#if pkName??>${pkName}</#if>:[a-zA-z0-9]+}")
	public ResponseMessage<Boolean> del(@PathVariable String <#if pkName??>${pkName}</#if>) {
		if (StringUtils.isBlank(<#if pkName??>${pkName}</#if>)) {
			return error("编码不能为空");
		}
		${table.serviceName?uncap_first}.delByKey(<#if pkName??>${pkName}</#if>);
		return success();
	}
	
}
</#if>
