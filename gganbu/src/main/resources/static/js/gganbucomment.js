/**
 * 깐부평 전용
 */
 
 function insertORupdateGganbuComment(url){
    let insupdsubmit = $("#gganbucommentForm").serialize();
    
    $ajax({
        url : url,
        type : 'POST',
        data : insupdsubmit,
        datatype : "html",
        success: function(data) {
            // Contents 영역 삭제
            $('#diary_change').children().remove();
            // Contents 영역 교체
            $('#diary_change').html(data);
        }
    });
}