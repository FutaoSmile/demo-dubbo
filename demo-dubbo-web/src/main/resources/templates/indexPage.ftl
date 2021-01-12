<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
</head>
<body>
<H1>Hello ${user.username}</H1>
<p>性别:
    <#--条件渲染-->
    <#if user.gender==1>
        男
    <#elseif user.gender==2>
        女
    <#else>
        未知
    </#if>
</p>

<h3>订单列表:</h3>
<table>
    <tr>
        <td>用户ID</td>
        <td>订单金额</td>
        <td>订单状态</td>
        <td>下单时间</td>
    </tr>
    <#--列表渲染-->
    <#list user.orderList as order>
        <tr>
            <td>${order.userId}</td>
            <td>${order.totalPrice}</td>
            <td>${order.status}</td>
            <#--对于空值的处理 !表示前面的值不存在时取后面的默认值，??用于判定是否是空，返回一个boolean值，一般和if共用-->
            <td>${order.createDateTime!"--"}</td>
        </tr>
    </#list>
</table>
<#--内建函数，使用?来调用，而不是.  全部内建函数: http://freemarker.foofun.cn/ref_builtins.html-->
<p>英文姓名:${user.englishName?upper_case}</p>
<p>${user.orderList?join(",")?html}</p>
<#include "./macro/greet.ftl" />
<@greet name='futao' color='red'/>
<h2>自定义指令：模板</h2>
<#include './macro/tableTemplate.ftl'/>
<@tableTemplate  headers=['用户ID','总价','订单状态','创建时间']  orders=user.orderList />
<#--插入其他文件内容-->
<#include "./layout/footer.html"/>
</body>
</html>