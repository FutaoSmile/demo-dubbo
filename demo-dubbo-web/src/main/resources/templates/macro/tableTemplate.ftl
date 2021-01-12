<#macro tableTemplate headers orders>
    <table>
        <tr>
            <#list headers as header>
                <th>${header}</th>
            </#list>
        </tr>
        <#list orders as order>
            <tr>
                <td>${order.userId}</td>
                <td>${order.totalPrice}</td>
                <td>${order.status}</td>
                <td>${order.createDateTime!"--"}</td>
            </tr>
        </#list>
    </table>
</#macro>