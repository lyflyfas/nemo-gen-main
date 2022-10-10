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
 * 			created on 2021年12月3日 下午1:13:18  by rico
 */

package com.linkinip.nemo.commons.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.linkinip.nemo.commons.utils.gen.CodeGeneratorBo;
import com.linkinip.nemo.commons.utils.gen.Config;

/**
 * MyBatisPlusAutoGenerator
 * 
 * @author rico
 * @date 2021年12月3日 下午1:13:18
 */

public class MyBatisPlusAutoGenerator {

	private final CodeGeneratorBo bo;

	public MyBatisPlusAutoGenerator(CodeGeneratorBo bo) {
		this.bo = bo;
	}

	public void execute() {
		FastAutoGenerator.create(dataSourceBuilder()).globalConfig(this::globalConfigBuilder)
				.templateConfig(this::templateConfigBuilder).packageConfig(this::packageConfigBuilder)
				.strategyConfig(this::strategyConfigBuilder).injectionConfig(this::injectionConfigBuilder)
				.templateEngine(new FreemarkerTemplateEngine()).execute();
	}

	public DataSourceConfig.Builder dataSourceBuilder() {
		return new DataSourceConfig.Builder(bo.getDbUrl(), bo.getUsername(), bo.getPassword());
	}

	public void globalConfigBuilder(GlobalConfig.Builder builder) {
		builder.fileOverride().author(bo.getAuthor());
		String outDir = Config.OUTPUT_DIR;
		if (StringUtils.isNotBlank(bo.getOutDir())) {
			outDir = bo.getOutDir();
		}
		builder.outputDir(outDir);

		DateType dateType = DateType.TIME_PACK;
		if (!"8".equalsIgnoreCase(bo.getJdkVersion())) {
			dateType = DateType.ONLY_DATE;
		}
		builder.dateType(dateType);

		if (BooleanUtils.isTrue(bo.getSwaggerSupport())) {
			builder.enableSwagger();
		}

	}

	public void packageConfigBuilder(PackageConfig.Builder builder) {
		builder.parent(bo.getPackageName())
				// builder.moduleName("");
				.controller(bo.getPackageController()).entity(bo.getPackageEntity()).mapper(bo.getPackageMapper())
				.xml(bo.getPackageMapperXml()).service(bo.getPackageService()).serviceImpl(bo.getPackageServiceImpl());
	}

	public void templateConfigBuilder(TemplateConfig.Builder builder) {
		builder.disable(TemplateType.ENTITY).entity("/templates/entity.java").service("/templates/service.java")
				.serviceImpl("/templates/serviceImpl.java").mapper("/templates/mapper.java")
				.mapperXml("/templates/mapper.xml").controller("/templates/controller.java").build();
	}

	public void injectionConfigBuilder(InjectionConfig.Builder builder) {

		Map<String, Object> customMap = Collections.singletonMap("test", "test");
		Map<String, String> customFile = new HashMap<String, String>();
		customFile.put("VO.java", "/templates/vo.java.ftl");
		customFile.put("Provider.java", "/templates/provider.java.ftl");
		customFile.put("ProviderImpl.java", "/templates/providerImpl.java.ftl");
		builder.beforeOutputFile((tableInfo, objectMap) -> {
			List<TableField> fields = tableInfo.getFields();
			if (fields != null && !fields.isEmpty()) {
				for (TableField t : fields) {
					if (t.isKeyFlag()) {
						objectMap.put("pkType", t.getPropertyType());
						objectMap.put("pkName", t.getPropertyName());
						objectMap.put("pkColumnName", t.getColumnName());
					}
					if (t.isLogicDeleteField()) {
						objectMap.put("logicDeleteFlag", true);
					}
					if ("status".equals(t.getAnnotationColumnName())) {
						objectMap.put("statusFlag", true);
					}
					if ("sort_no".equals(t.getAnnotationColumnName())) {
						objectMap.put("sortFlag", true);
						objectMap.put("sortNoField", true);
					}
					
				}
			}

			List<TableField> commonFields = tableInfo.getCommonFields();
			for (TableField t : commonFields) {
				if ("parent_code".equals(t.getAnnotationColumnName())) {
					objectMap.put("treeFlag", true);
				}
				if ("last_modified_date".equals(t.getAnnotationColumnName())) {
					objectMap.put("modifiedDateField", true);
					objectMap.put("sortFlag", true);
				}
				if ("sort_no".equals(t.getAnnotationColumnName())) {
					objectMap.put("sortFlag", true);
					objectMap.put("sortNoField", true);
				}
			}
			System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap);
		}).customMap(customMap).customFile(customFile).build();
	}

	public void strategyConfigBuilder(StrategyConfig.Builder builder) {
		if (bo.getTableNames() != null && bo.getTableNames().length > 0) {
			builder.addInclude(bo.getTableNames());
		}

		if (bo.getFieldPrefixes() != null && bo.getFieldPrefixes().length > 0) {
			builder.addFieldPrefix(bo.getFieldPrefixes());
		}

		if (bo.getTablePrefixes() != null && bo.getTablePrefixes().length > 0) {
			builder.addTablePrefix(bo.getTablePrefixes());
		}
		if (bo.getExcludeTableNames() != null && bo.getExcludeTableNames().length > 0) {
			builder.addExclude(bo.getExcludeTableNames());
		}
		builder.entityBuilder().naming(NamingStrategy.underline_to_camel).enableRemoveIsPrefix()
				.disableSerialVersionUID()
				// .enableActiveRecord()
				.addSuperEntityColumns(bo.getSuperEntityColumns()).formatFileName(bo.getFileNamePatternEntity())
				.idType(IdType.ASSIGN_ID).addTableFills(new Column("created_date", FieldFill.INSERT))
				.addTableFills(new Property("last_modified_date", FieldFill.INSERT_UPDATE))
				.logicDeleteColumnName(bo.getFieldLogicDelete()).versionColumnName(bo.getFieldVersion())
				.superClass(bo.getSuperEntityClass())
				.addIgnoreColumns(bo.getIgnoreColumns() == null ? new String[] {} : bo.getIgnoreColumns())
				.mapperBuilder().superClass(bo.getSuperMapperClass())
				.formatMapperFileName(bo.getFileNamePatternMapper()).formatXmlFileName(bo.getFileNamePatternMapperXml())
				.serviceBuilder().superServiceClass(bo.getSuperServiceClass())
				.superServiceImplClass(bo.getSuperServiceImplClass())
				.formatServiceFileName(bo.getFileNamePatternService())
				.formatServiceImplFileName(bo.getFileNamePatternServiceImpl()).controllerBuilder()
				.superClass(bo.getSuperControllerClass()).formatFileName(bo.getFileNamePatternController())
				.enableHyphenStyle().enableRestStyle();

		com.baomidou.mybatisplus.generator.config.builder.Entity.Builder entityBuilder = builder.entityBuilder();
		if (BooleanUtils.isTrue(bo.getLombokChainModel())) {
			entityBuilder.enableChainModel();
		}
		if (BooleanUtils.isTrue(bo.getLombokModel())) {
			entityBuilder.enableLombok();
		}
		if (BooleanUtils.isTrue(bo.getColumnConstant())) {
			entityBuilder.enableColumnConstant();
		}
		// 字段注解
		if (BooleanUtils.isTrue(bo.getFieldAnnotation())) {
			entityBuilder.enableTableFieldAnnotation();
		}

		com.baomidou.mybatisplus.generator.config.builder.Mapper.Builder mapperBuilder = builder.mapperBuilder();
		if (BooleanUtils.isTrue(bo.getBaseResultMap())) {
			mapperBuilder.enableBaseResultMap();
		}
		if (BooleanUtils.isTrue(bo.getBaseColumnList())) {
			mapperBuilder.enableBaseColumnList();
		}

		// 开启mapper注解
		if (BooleanUtils.isTrue(bo.getMapperAnnotation())) {
			mapperBuilder.enableMapperAnnotation();
		}
	}
}
