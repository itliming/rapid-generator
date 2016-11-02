package cn.org.rapid_framework.generator;


/**
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
    /**
     * 请直接修改以下代码调用不同的方法以执行相关生成任务.
     */
    public static void main(String[] args) throws Exception {
        GeneratorFacade g = new GeneratorFacade();
//		g.printAllTableNames();				//打印数据库中的表名称

        g.deleteOutRootDir();                            // 删除生成器的输出目录
        String templateRootDir = "F:\\software\\rapid-generator.git\\trunk\\template\\rltx-mybatis";
        g.generateByTable("mobile_app", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_menu", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_app_patch", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_app_version", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_app_version_device_user_relation", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_device", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_exception_record", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_exception_statistic", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_patch_device_relation", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_user_event_define", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_user_event_record", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
        g.generateByTable("mobile_user_event_record", templateRootDir);    // 通过数据库表生成文件,template为模板的根目录
//		g.generateByAllTable("template");	//自动搜索数据库中的所有表并生成文件,template为模板的根目录
//		g.generateByClass(Blog.class,"template_clazz");

//		g.deleteByTable("table_name", "template"); //删除生成的文件
        //打开文件夹
        Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));
    }
}
