package com.ws.exp.everything.annotation.sample1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 运行时注解处理器：需要我们自己编写<br/>
 * 构造表创建语句
 *
 * @author Eric at 2020-03-04_15:41
 */
public class TableCreator {
    public static String createTableSql(String className) throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);
        if (!cl.isAnnotationPresent(DBTable.class)) {
            System.out.println("No DBTable annotations in class " + className);
            return null;
        }

        DBTable dbTable = cl.getAnnotation(DBTable.class);
        String tableName = dbTable.name();
        if (tableName.isEmpty()) {
            tableName = cl.getName().toUpperCase();
        }

        // 假设每个函数上只有1个或0个注解
        List<String> columnDefs = new ArrayList<>();
        for (Field field : cl.getDeclaredFields()) {
            String columnName = null;
            Annotation[] anns = field.getDeclaredAnnotations();
            if (anns.length < 1) {
                continue;
            }

            if (anns[0] instanceof SQLInteger) {
                SQLInteger sInt = (SQLInteger) anns[0];
                if (sInt.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sInt.name();
                }
                columnDefs.add(columnName + " INT" +
                        getConstraints(sInt.constraint()));
            }

            if(anns[0] instanceof SQLString) {
                SQLString sString = (SQLString) anns[0];
                if(sString.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sString.name();
                }
                columnDefs.add(columnName + " VARCHAR(" +
                        sString.value() + ")" +
                        getConstraints(sString.constraint()));
            }
        }

        StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String columnDef : columnDefs) {
            createCommand.append("\n " + columnDef + ",");
        }

        String tableCreate = createCommand.substring(0,
                createCommand.length() - 1) + ")";
        return tableCreate;
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if(!con.allowNull())
            constraints += " NOT NULL";
        if(con.primaryKey())
            constraints += " PRIMARY KEY";
        if(con.unique())
            constraints += " UNIQUE";
        return constraints;
    }

    public static void main(String[] args) throws Exception {
        String[] arg = {"com.ws.exp.everything.annotation.sample1.Member"};
        for (String className : arg) {
            System.out.println("Table creation SQL for " +
                    className + "is:\n" + createTableSql(className));
        }
    }
}
