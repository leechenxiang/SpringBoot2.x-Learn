<html>
<head>
    <title>Hello Freemarker~~~</title>
</head>

<body>

<#--
    freemarker 的构成语法：
    1. 注释
    2. 表达式
    3. 指令
    4. 普通文本
-->

<#-- 输出一个字符串 -->
<#-- ${} 作为变量的表达式，同jsp -->
<div>Hello ${there}</div>

<br/>
<br/>

<#-- 输出一个对象 -->
<div>
    id: ${teacher.id}<br/>
    姓名: ${teacher.name}<br/>
    年龄: ${teacher.age}<br/>
    性别: ${teacher.sex}<br/>
    生日: ${teacher.birthday?string('yyyy-MM-dd HH:mm:ss')}<br/>
    钱包: ${teacher.amount}<br/>
    已育: ${teacher.haveChild?string('yes', 'no')}<br/>
    <#--辅导学生：名为${teacher.stu.name}的学生，年龄为${teacher.stu.age}岁<br/>-->
    <#if teacher.stu??>
        辅导学生：名为${teacher.stu.name}的学生，年龄为${teacher.stu.age}岁
    </#if>
    <#if !teacher.stu??>
        没有1对1的学生进行辅导
    </#if>

</div>

<br/>
<br/>

<#-- list 指令，用于循环-->
<#list teacherList as t>
    <div>
        <span>${t.id}</span>
        <span>${t.name}</span>
        <span>${t.age}</span>
    </div>
</#list>

<br/>
<br/>

<#-- 演示map中的数据循环 -->
<#list tMap?keys as key>
    <div>
        <span>${tMap[key].name}</span>
        <span>${tMap[key].age}</span>
    </div>
</#list>

<br/>
<br/>

<#--  if指令，用于判断 -->
<div>
    <#if teacher.id == "1001">
        这个老师的编号为1001
    </#if>
    <#if teacher.id != "1001">
        这个老师的编号不是1001
    </#if>
    <br/>
    <#if (teacher.age >= 18)>
        这个老师已经成年
    </#if>
    <#if (teacher.age < 18)>
        这个老师未成年
    </#if>
    <br/>
    <#if teacher.haveChild>
        已育
    </#if>
    <#if !teacher.haveChild>
        未育
    </#if>
    <br/>
</div>



</body>
</html>