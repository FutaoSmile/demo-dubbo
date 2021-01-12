<#macro greet name color>
    <p style="color: ${color!'red'}">Hello ${name}</p>
    <#--这里面为嵌套内容 使用者可以将内容写在标签中间-->
    <#nested />
</#macro>