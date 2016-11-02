<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import ${basepackage}.${subpackage}.po.${className}Entity;

@Repository("${classNameFirstLower}Dao")
public interface ${className}Dao {

    long save(${className}Entity ${classNameFirstLower});

    int delete(Long id);

    int update(${className}Entity ${classNameFirstLower});

    ${className}Entity query(Long id);

    List<${className}Entity> queryList(Map<String, Object> params);

    int queryCount(Map<String, Object> params);

}