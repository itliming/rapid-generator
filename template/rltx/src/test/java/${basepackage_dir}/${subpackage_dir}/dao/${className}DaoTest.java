<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.dao;

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
import ${basepackage}.${subpackage}.dao.${className}Dao;

public class ${className}DaoTest extends TestBase {
    
    private Log logger = LogFactory.getLog(this.getClass());
    
    @Resource(name = "${classNameFirstLower}Dao")
    private ${className}Dao ${classNameFirstLower}Dao;
    
    @Before
    public void setUp(){
        Assert.notNull(${classNameFirstLower}Dao, "${classNameFirstLower}Dao 不能为 null");
    }
    @After
    public void tearDown(){
        ${classNameFirstLower}Dao = null;
    }

    @Test
    public  void testSave(){
        logger.debug("开始测试 ${classNameFirstLower}Dao.save(entity)");
        ${className}Entity entity = new ${className}Entity();
        <#list table.columns as column>
        // entity.set${column.columnName}(${column.simpleJavaType});
        </#list>
        long id = ${classNameFirstLower}Dao.save(entity);
        Assert.isTrue(id > 0, "${classNameFirstLower}Dao.save(entity) Fail");
        logger.debug("${classNameFirstLower}Dao.save(entity)测试结束. id=" + id);
    }

    @Test
    public  void testDelete(){
        logger.debug("开始测试 ${classNameFirstLower}Dao.delete()");

        int rows = ${classNameFirstLower}Dao.delete(0l);
        Assert.isTrue(rows > 0, "${classNameFirstLower}Dao.delete() Fail");
        logger.debug("${classNameFirstLower}Dao.delete()测试结束. rows=" + rows);
    }

    @Test
    public  void testUpdate(){
        logger.debug("开始测试 ${classNameFirstLower}Dao.update(entity)");
        ${className}Entity entity = new ${className}Entity();
        <#list table.columns as column>
        // entity.set${column.columnName}(${column.simpleJavaType});
        </#list>
        long id = ${classNameFirstLower}Dao.update(entity);
        Assert.isTrue(id > 0, "${classNameFirstLower}Dao.update(entity) Fail");
        logger.debug("${classNameFirstLower}Dao.update(entity)测试结束. id=" + id);
    }


    @Test
    public  void testQuery(){
        logger.debug("开始测试 ${classNameFirstLower}Dao.query(0)");

        ${className}Entity entity = ${classNameFirstLower}Dao.query(0l);
        Assert.notNull(entity , "${classNameFirstLower}Dao.query() Fail");
        logger.debug("${classNameFirstLower}Dao.query(0) 测试结束. entity=" + entity);
    }



    @Test
    public  void testQueryList(){
        logger.debug("开始测试 ${classNameFirstLower}Dao.queryList(params)");
        Map<String, Object> params = new HashMap<String, Object>();
        <#list table.columns as column>
       // params.put("${column.columnNameLower}","");
        </#list>
        List<${className}Entity> resultList =  ${classNameFirstLower}Dao.queryList(params);
        Assert.notNull(resultList, "${classNameFirstLower}Dao.queryList(params) fail");
        logger.debug("${classNameFirstLower}Dao.queryList(params)测试结束. resultList.size()=" + resultList.size());
    }

    @Test
    public  void testQueryCount(){
        logger.debug("开始测试 ${classNameLower}Mapper.countBy(params)");
        Map<String, Object> params = new HashMap<String, Object>();
        <#list table.columns as column>
        // params.put("${column.columnNameLower}","");
        </#list>
        int count =  ${classNameFirstLower}Dao.queryCount(params);
        Assert.isTrue(count > 0, "${classNameFirstLower}Dao.queryCount(params) fail");
        logger.debug("${classNameFirstLower}Dao.queryCount(params)测试结束. count=" + count);
    }


}
