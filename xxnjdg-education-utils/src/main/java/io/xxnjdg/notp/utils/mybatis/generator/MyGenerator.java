package io.xxnjdg.notp.utils.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午12:28
 */
public class MyGenerator {
    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
//        File configFile = new File("generatorConfig.xml");
//        InputStream configFile = MyGenerator.class.getResourceAsStream("/mybatis/generatorConfig.xml");
//        InputStream configFile = MyGenerator.class.getResourceAsStream("/mybatis/systemGeneratorConfig.xml");
        InputStream configFile = MyGenerator.class.getResourceAsStream("/mybatis/userGeneratorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
