var index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ 
			this.save();
		});
	},
	
	save: function(){
		
		var insertsubmit = $("#insertForm").serialize();

		$.ajax({
			type: "POST",
			url: "/photoInsert/${session.loginUser.mem_id}",
			data: insertsubmit,
			dataType: "html" 
		}).done(function(data){
			// Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
	        
		});
	}
}

index.init();




function photo(url){
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
        $('#photo').children().remove();
        // Contents 영역 교체
        $('#photo').html(data);
        $('.summernote').summernote({
		    height: 300,
		    width:550,
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
			minHeight: null,             // 최소 높이
		  	maxHeight: null,             // 최대 높이
		  	focus: true,
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
		  });
    });
}


function updatee(url){
	var submit = $("#updateForm").serialize();
	
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
	        $('.summernote').summernote({
			    height: 250,
			    width:550
			  });
   		 });
 	}
 	
 function deletee(url){
	var deletesubmit = $("#update").serialize();
	
    $.ajax({
        url : url,
        type : 'POST', 
        data :  deletesubmit, 
        dataType:"html",
        }).done(function(data){
            // Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
   		 });
 	}
 	
 	
 function inserte(url){
	var submit = $("#insertForm").serialize();
	
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
 
 
  function cinsert(url){
	
	var csubmit = $("#cinsertForm").serialize();
	
    $.ajax({
        url : url,
        type : 'POST', 
        data :  csubmit, 
        dataType:"html",
        }).done(function(data){
            // Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
   		 });
 	}
 	
 	
 	function cdeletee(url){
	
		var cdeletesubmit = $("#cdelete").serialize();
	
    $.ajax({
        url : url,
        type : 'POST', 
        data :  cdeletesubmit, 
        dataType:"html",
        }).done(function(data){
            // Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
   		 });
 	}
 	
 	
 	function movePage(uri, queryString){
	
	
    $.ajax({
        url : uri + queryString,
        type : 'POST', 
        }).done(function(data){
            // Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
   		 });
 	}
 
/************************************************************************************/

