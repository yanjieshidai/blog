<title>博客列表</title>

<body>

<label>Doc List:</label>

<#list docs as item>
    <a href="/blog/${item.docPO.id!''}">${item.docPO.title }</a>
</#list>


</body>