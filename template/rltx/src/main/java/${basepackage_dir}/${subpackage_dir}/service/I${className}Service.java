<#assign className = table.className>
<#assign classNameFirstLower = table.classNameFirstLower>
<#assign classNameLower = className?uncap_first>
<#assign shortName = table.shortName>
package ${basepackage}.${subpackage}.service;

import java.util.List;
import java.util.Map;
import ${basepackage}.${subpackage}.po.${className}Entity;

public interface I${className}Service {

    long add(${className}Entity ${classNameFirstLower});

    int delete(Long id);

	int update(${className}Entity ${classNameFirstLower});

	${className}Entity getById(Long id);

    List<${className}Entity> getList(Map<String, Object> params);

	long getCount(Map<String, Object> params);



}
