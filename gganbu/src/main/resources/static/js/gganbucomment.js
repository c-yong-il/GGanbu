/**
 * 깐부평 전용
 let data = (${gganbu_comment_content}).val();
 */
 let comment = [['[[${gganbu_comment_content}]]']];
 var re2 = /^.{1,20}$/;
 
 
 function insertORupdateGganbuComment(url){
    
    //alert('111');
    let you = document.getElementById("gganbu_comment_content");
    let insupdsubmit = $("#insertORupdateForm").serialize();
    
    
    //alert($('#gganbu_comment_content').val());
    if(!re2.test($('#gganbu_comment_content').val())){
        
    //alert('222');
    
    gganbu_comment_content.style.border = "2px solid #FF1493";
    return false;
    
    }else {
        
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
    
    //alert('444');
    
}