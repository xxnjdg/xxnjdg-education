package io.xxnjdg.notp.utils.mybatis.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-14 下午1:14
 */
public class MyCommentGenerator extends DefaultCommentGenerator {
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
//        super.addFieldComment(field, introspectedTable, introspectedColumn);
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            addJavadocTag(field, false);
            field.addJavaDocLine(" */");
        }
    }
}