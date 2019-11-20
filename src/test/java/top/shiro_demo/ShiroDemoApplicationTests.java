package top.shiro_demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroDemoApplicationTests {

    @Test
    public void run(){
        //生成加密加盐的密码
        SimpleHash simpleHash = new SimpleHash("MD5", "123456", "ABC", 1);
        System.out.println(simpleHash.toString());
    }

    @Test
    void contextLoads() {
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//项目路径
        globalConfig.setOutputDir(projectPath + "/src/main/java")
                .setAuthor("wwh")
                .setOpen(false)
                .setFileOverride(true)//生成的文件是否覆盖
                .setIdType(IdType.INPUT)//ID类型
                .setActiveRecord(false);//不支持ActiveRecord
        autoGenerator.setGlobalConfig(globalConfig);
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://127.0.0.1:3306/shiro_demo?characterEncoding=utf8&useSSL=false")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("root");
        autoGenerator.setDataSource(dataSourceConfig);
        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("top.shiro_demo.user")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service")
                .setEntity("entity")
                .setMapper("mapper")
                .setXml("mapper");
        autoGenerator.setPackageInfo(packageConfig);
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig()
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)//lombok模式的实体类
                .setRestControllerStyle(true)//RestController
                .setControllerMappingHyphenStyle(true)
                .setInclude("user_perm");//这里输入要生成的表名
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();

    }

}
