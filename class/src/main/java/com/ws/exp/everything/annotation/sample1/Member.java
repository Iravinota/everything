package com.ws.exp.everything.annotation.sample1;

/**
 * Member
 *
 * @author Eric at 2020-03-04_15:26
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(name = "ID", value = 50, constraint = @Constraints(primaryKey = true))
    private String id;

    @SQLString(name = "NAME", value = 30)
    private String name;

    @SQLInteger(name = "AGE")
    private int age;

    @SQLString(name = "DESCRIPTION", value = 150, constraint = @Constraints(allowNull = true))
    private String description;
}
