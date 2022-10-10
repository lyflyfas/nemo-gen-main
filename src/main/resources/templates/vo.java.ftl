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

package ${package.Parent}.vo;

import com.linkinip.ratel.modules.base.domain.RootEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @date ${date}
 */

@Setter
@Getter
@NoArgsConstructor
public class ${entity?replace('Entity','')}VO implements RootEntity{

    private static final long serialVersionUID = 1L;
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.comment!?length gt 0>
    @ApiModelProperty(value ="${field.comment}")
    </#if>
    private ${field.propertyType} ${field.propertyName}<#if field.logicDeleteField> = false</#if>;
</#list>

<#list table.commonFields as field>
    <#if field.comment!?length gt 0>
    @ApiModelProperty(value ="${field.comment}")
    </#if>
    private ${field.propertyType} ${field.propertyName}<#if field.logicDeleteField> = false</#if>;
</#list>


<#if entityColumnConstant>
    <#list table.fields as field>
    public static final String ${field.name?upper_case} = "${field.name}";
    </#list>
</#if>

	public ${entity?replace('Entity','VO')}(${entity} entity) {
		super();
<#list table.fields as field>
		this.${field.propertyName} = entity.get${field.capitalName}();
</#list>

<#list table.commonFields as field>
		this.${field.propertyName} = entity.get${field.capitalName}();
</#list>
	}
}
