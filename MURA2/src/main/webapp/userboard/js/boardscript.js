$.ajaxSetup({
    type:"POST",
    async:true,
    dataType:"json",
    error:function(xhr) {
        console.log("error html = " + xhr.statusText);
    }
});

$(function() {
    $("#replyWrite").on("click", function() {
        $.ajax({
            url:"/MURA2/userboard/replyWrite.mur",
            data:{
                content_reply:$("#content_reply").val(),
                board_reply:"${userArticle.idx_ut}"
            },
            beforeSend:function() {
                console.log("시작 전...");
            },
            complete:function() {
                console.log("완료 후...");
            },
            success:function(data) {          
                if(data.result == 1) {
                    console.log("reply가 정상적으로 입력되었습니다.");
                    $("#content_reply").val("");
                    showHtml(data.replyList, 1);
                }
            }
        })
    });
});

function showHtml(data, commPageNum) {
    let html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>";
    $.each(data, function(index, item) {
        html += "<tr align='center'>";
        html += "<td>" + (index+1) + "</td>";
        html += "<td>" + item.id + "</td>";
        html += "<td align='left'>" + item.content_reply + "</td>";
        let presentDay = item.date_reply.substring(0, 10);
        html += "<td>" + presentDay + "</td>";
        html += "</tr>";
    });
    html += "</tbody></table>";
    commPageNum = parseInt(commPageNum);
    
    if("${userArticle.replycnt_ut}" > commPageNum * 10) {
        nextPageNum = commPageNum + 1;
        html +="<input type='button' class='btn btn-default' onclick='getReply(nextPageNum, event)' value='다음 comment 보기'>";
    }
    
    $("#showReply").html(html);
    $("#content_reply").val("");
    $("#content_reply").focus();
}

function getReply(commPageNum, event) {
    $.ajax({
        url:"/MURA2/userboard/replyRead.mur",
        data:{
            commPageNum:commPageNum*10,
            board_reply:"${userArticle.idx_ut}"
        },
        beforeSend:function() {
            console.log("읽어오기 시작 전...");
        },
        complete:function() {
            console.log("읽어오기 완료 후...");
        },
        success:function(data) {
            console.log("reply를 정상적으로 조회하였습니다.");
            showHtml(data, commPageNum);
            
            let position = $("#showReply table tr:last").position();
            $('html, body').animate({scrollTop : position.top}, 400);
        }
    })
}
