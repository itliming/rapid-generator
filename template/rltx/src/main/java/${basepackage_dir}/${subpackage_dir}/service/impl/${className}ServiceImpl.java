<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.${subpackage}.service.I${className}Service;
import ${basepackage}.${subpackage}.po.${className}Entity;
import ${basepackage}.${subpackage}.dao.${className}Dao;

@Service("${classNameFirstLower}Service")
@Transactional(readOnly = true)
public class ${className}ServiceImpl implements I${className}Service {
	
    @Resource(name = "${classNameFirstLower}Dao")
    private ${className}Dao ${classNameFirstLower}Dao;

    @Transactional(readOnly = false)
	public long add(${className}Entity ${classNameFirstLower}) {
        long id = ${classNameFirstLower}Dao.save(${classNameFirstLower});
        return id;
	}

    @Transactional(readOnly = false)
    public int delete(Long id) {
        int rows = ${classNameFirstLower}Dao.delete(id);
        return rows;
    }

    @Transactional(readOnly = false)
    public int update(${className}Entity ${classNameFirstLower}) {
        int rows = ${classNameFirstLower}Dao.update(${classNameFirstLower});
        return rows;
    }
    
    public ${className}Entity getById(Long id) {
		${className}Entity ${classNameFirstLower} = ${classNameFirstLower}Dao.query(id);
        return ${classNameFirstLower};
    }
	
	public List<${className}Entity> getList(Map<String, Object> params){
		List<${className}Entity> lists = ${classNameLower}Dao.queryList(params);
		return lists;
	}

    public long getCount(Map<String, Object> params){
        long count = ${classNameLower}Dao.queryCount(params);
        return count;
    }
}
