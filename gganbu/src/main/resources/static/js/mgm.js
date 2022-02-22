function Quit(url){
	var submit = $("#quitForm").serialize();
	
    $.ajax({
        url : url,
        type : 'POST', 
        data :  submit, 
        dataType:"html",
        }).done(function(data){
            // Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
   		 });
 	}