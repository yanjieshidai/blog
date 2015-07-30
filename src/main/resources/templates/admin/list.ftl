<title>博客列表</title>

<body>

<label>Doc List:</label>

<#list docs as item>
    <a href="/admin/doc/${item.docPO.id!''}">${item.docPO.title }</a>
</#list>


</body>