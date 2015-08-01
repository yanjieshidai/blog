<title>博客列表</title>

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function () {
        console.log("ready!");
        $(".blog-publish").click(function () {
            var $tr = $(this).parents("tr");
            console.log("click" + "data-docId:" + $tr.data("docid"));
            publish_doc($tr.data("docid"));
        });
    });

    function publish_doc(docid) {
        $.ajax({
            url: "/admin/doc/publish",
            data: {
                id: docid
            },
            success: function (data) {
                alert(data.message);
            }
        });
    }

</script>
<body>

<label>Doc List:</label>

<table>


<#list docs as item>
    <tr data-docid="${item.docPO.id}">
        <td>
            <a href="/admin/doc/${item.docPO.id!''}">${item.docPO.title }</a>
        </td>
        <td>
            <button class="blog-publish" type="button">发布</button>
        </td>
    </tr>
</#list>

</table>

</body>

