 
 /** 글쓰기 버튼 눌렀을 때*/
 function profileUpdate(url){
	var option ={
			type:"get",
			url:url,
			async:true,
			dataType:"html",
			cache:false
	};
	 $.ajax(option).done(function(data){
        // Contents 영역 삭제
        $('#profile-content').children().remove();
        // Contents 영역 교체
        $('#profile-content').html(data);
    });
}
/* 글쓰고 등록 버튼 눌렀을 때*/
     function diaryWrite2(){
        $.ajax({
            cache : false,
            url : "/diaryInsert/${session.loginUser.mem_id}",
            type : 'POST', 
            data :  $("#diaryWriteForm").serialize(), 
            async:true,
            dataType:"html",
            success : function(data)
            {
             // Contents 영역 삭제
	        $('#diary_change').children().remove();
	        // Contents 영역 교체
	        $('#diary_change').html(data);
       		 } // $.ajax */
   	 	});
   	 }
   	 
   	 /** 수정하고 수정완료 버튼 눌렀을 때  */
   	 function diaryUpdate(){
	    $.ajax({
            cache : false,
            url : "/diaryUpdate/${session.loginUser.mem_id}", 
            type : 'POST', 
            data :  $("#diaryUpdateForm").serialize(), 
            async:true,
            dataType:"html",
            success : function(data)
            {
                // Contents 영역 삭제
	        $('#diary_change').children().remove();
	        // Contents 영역 교체
	        $('#diary_change').html(data);
       		 } // $.ajax */
   	 	});
	
}

/* 다이어리 수정 버튼 눌렀을 때 */ 
 	function diaryUpdateMove(){
		console.log($("#diaryForm").serialize());
	    $.ajax({
            cache : false,
            url : "/diary_update/${session.loginUser.mem_id}", /*${list.diary_num}*/
            data :  $("#diaryForm").serialize(), 
            async:true,
            type : 'POST', 
            dataType:"html",
            success : function(data)
            {
                // Contents 영역 삭제
	        $('#diary_change').children().remove();
	        // Contents 영역 교체
	        $('#diary_change').html(data);
       		 } 
   	 	});
   	 	
	} 





 