function loadComments() {
    $.get("/comments", function (json) {
        var row = $("<table>").appendTo($("#content"));
        $.each(json, function (index, comment) {
            $("<tr>").appendTo(row)
                .append($("<td>").text(comment.date))
                .append($("<td>").text(comment.text))
        });
    });
}

function saveComment() {
    var inputText = $("#text").val();
    $.ajax({
        url: '/comments',
        type: 'POST',
        data: "text=" + inputText
    });
}