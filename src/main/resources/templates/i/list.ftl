<title>博客列表</title>

<body>

<label>Blog List:</label>
<table>
<#list blogs as item>
    <tr>
        <td>
        ${item?index +1}.
        </td>
        <td>
            <a href="/i/blog/${item.blogPO.id!''}">${item.blogPO.title }</a>
        </td>
    </tr>
</#list>
</table>

</body>