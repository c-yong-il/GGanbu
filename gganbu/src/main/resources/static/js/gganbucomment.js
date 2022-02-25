/**
 * 깐부평 전용
 */
 
 function insertORupdateGganbuComment(url){
    let insupdsubmit = $("#insertORupdateForm").serialize();
    
    $.ajax({
        url : url,
        type : 'POST',
        data : insupdsubmit,
        datatype : "html",
        success: function(data) {
            // Contents 영역 삭제
            $('#test').children().remove();
            // Contents 영역 교체
            $('#test').html(data);
        }
    });
}