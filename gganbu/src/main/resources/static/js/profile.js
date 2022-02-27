 
 


/* 프로필 - 글쓰기(등록,수정) 진입: 썸머노트 */ 
function profileWrite(url){
    // ajax option
    var ajaxOption = {
            url : url,
            async : true,
            type : "POST",
            dataType : "html",
            cache : false
    };
    
    $.ajax(ajaxOption).done(function(data){
        // Contents 영역 삭제
        $('#profile-content').children().remove();
        // Contents 영역 교체
        $('#profile-content').html(data);
        $('.summernote').summernote({
		    height: 250,
		    width: 539,
		    toolbar: [
			    // [groupName, [list of button]]
			    ['fontname', ['fontname']],
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    ['color', ['forecolor','color']],
			    ['table', ['table']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']],
			    ['insert',['picture','link','video']],
			    ['view', ['fullscreen', 'help']]
			  ],
			minHeight: 200,             // 최소 높이
		  	maxHeight: 300,             // 최대 높이
		  	focus: true,
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
		  });
    });
}


/* 프로필 - 등록,수정 */ 
function profileUpdate(url){
	var updateDate = $("#profileForm").serialize();
	
    $.ajax({
        url : url,
        type : 'POST', 
        data :  updateDate, 
        dataType:"html",
        }).done(function(data){
            // Contents 영역 삭제
	        $('#profile-content').children().remove();
	        // Contents 영역 교체
	        $('#profile-content').html(data);
	        
   		 });
 	}
 