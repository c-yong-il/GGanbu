/**
 * 깐부평 전용
 let data = (${gganbu_comment_content}).val();
 */
 let comment = [['[[${gganbu_comment_content}]]']];
 var re2 = /^.{1,20}$/;
 
 
 function insertORupdateGganbuComment(url){
    
    //let you = document.getElementById("gganbu_comment_content");
    let insupdsubmit = $("#insertORupdateForm").serialize();
    
    if(!re2.test($('#gganbu_comment_content').val())){
    
    gganbu_comment_content.style.border = "2px solid #FF1493";
    return false;
    
    }else {
           $.ajax({
			url:url,
			type : 'POST',
			 data : insupdsubmit,
			 datatype : "html",
			success:function(data){
					window.location.href=window.location.href;
			}
		})
    
    }
    
}