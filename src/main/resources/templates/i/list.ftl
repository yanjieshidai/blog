<title>博客列表</title>

<body>

<label>Blog List:</label>

<#list blogs as item>
    <a href="/i/blog/${item.blogPO.id!''}">${item.blogPO.title }</a>
</#list>


</body>