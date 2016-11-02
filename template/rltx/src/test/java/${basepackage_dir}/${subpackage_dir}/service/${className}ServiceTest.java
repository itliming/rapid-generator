<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service;

import java.util.*;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;
import com.wl.xtailor.base.TestBase;
import ${basepackage}.${subpackage}.po.${className}Entity;
import ${basepackage}.${subpackage}.service.I${className}Service;

public class ${className}ServiceTest  extends TestBase {
    
    private Log logger = LogFactory.getLog(this.getClass());
    
    @Resource(name = "${classNameFirstLower}Service")
    private I${className}Service ${classNameFirstLower}Service;
    
    @Before
    public void setUp(){
        Assert.notNull(${classNameFirstLower}Service, "${classNameFirstLower}Service 不能为 null");
    }
    @After
    public void tearDown(){
        ${classNameFirstLower}Service = null;
    }
    
    @Test
    public  void testAdd(){
        logger.debug("开始测试 ${classNameLower}Service.add(entity)");
        ${className}Entity entity = new ${className}Entity();
        <#list table.columns as column>
        // entity.set${column.columnName}(${column.simpleJavaType});
        </#list>
        long id =  ${classNameLower}Service.add(entity);
        Assert.isTrue(id > 0, "${classNameLower}Service.add(entity) fail");
        logger.debug("${classNameLower}Service.add(entity)测试结束.id = " + id);
    }

    @Test
    public  void testDelete(){
        logger.debug("开始测试 ${classNameLower}Service.delete()");
        int rows =  ${classNameLower}Service.delete(0l);
        Assert.isTrue(rows > 0, "开始测试 ${classNameLower}Service.delete() fail");
        logger.debug("${classNameLower}Service.delete()测试结束. rows=" + rows);
    }

    @Test
    public  void testUpdate(){
        logger.debug("开始测试 ${classNameLower}Service.update(entity)");
        ${className}Entity entity = new ${className}Entity();
        <#list table.columns as column>
        // entity.set${column.columnName}(${column.simpleJavaType});
        </#list>
        int rows =  ${classNameLower}Service.update(entity);
        Assert.isTrue(rows > 0, "${classNameLower}Service.update(entity) fail");
        logger.debug("${classNameLower}Service.update(entity) 测试结束.rows = " + rows);
    }


    @Test
    public  void testGetById(){
        logger.debug("开始测试  ${classNameLower}Service.getById");
        ${className}Entity entity =  ${classNameLower}Service.getById(0l);
        Assert.notNull(entity , " ${classNameLower}Service.getById fail");
        logger.debug("${classNameLower}Service.getById 测试结束. entity =" + entity);
    }

    @Test
    public  void testGetList(){
        logger.debug("开始测试   ${classNameLower}Service.getList");
        Map<String, Object> params = new HashMap<String, Object>();
        <#list table.columns as column>
        // params.put("${column.columnNameLower}","");
        </#list>
        List<${className}Entity> resultList =  ${classNameLower}Service.getList(params);
        Assert.notNull(resultList.size() >0 , " ${classNameLower}Service.getList() fail");
        logger.debug("${classNameLower}Service.getList() 测试结束. resultList =" + resultList);
    }

    @Test
    public  void testGetCount(){
        logger.debug("开始测试   ${classNameLower}Service.getList");
        Map<String, Object> params = new HashMap<String, Object>();
        <#list table.columns as column>
        // params.put("${column.columnNameLower}","");
        </#list>
        long count =  ${classNameLower}Service.getCount(params);
        Assert.isTrue(count >0 , " ${classNameLower}Service.getCount(params) fail");
        logger.debug("${classNameLower}Service.getCount(params) 测试结束. count =" + count);
    }

}
