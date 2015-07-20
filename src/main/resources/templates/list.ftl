<title>博客列表</title>

<body>
<h1>
UserName: ${userName!""}
</h1>

<label>Doc List:</label>

<#list docs as item>

<p>
    ${item.blogPO.title }
</p>

</#list>


</body>