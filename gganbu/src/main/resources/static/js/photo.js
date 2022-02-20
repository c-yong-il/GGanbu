var index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ 
			this.save();
		});
		$("#btn-delete").on("click", ()=>{ 
			this.delete();
		});
		$("#btn-update").on("click", ()=>{ 
			this.update();
		});
		$("#btn-ud").on("click", ()=>{ 
			this.ud();
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
	},
	
	delete: function(){		
		var deletesubmit = $("#update").serialize();
		
		$.ajax({
			type: "POST",
			url: "/delete/${session.loginUser.mem_id}",
			data: deletesubmit,
			dataType: "html" 
		}).done(function(data){
			// Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
		}); 
	},
	
	update: function(){
		var updatesubmit = $("#updateForm").serialize();
		
		$.ajax({
			type: "POST",
			url: "/photoupdate/${session.loginUser.mem_id}",
			data: updatesubmit,
			dataType: "html" 
		}).done(function(data){
			// Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
		}); 
	},
	
	ud: function(){
		var udsubmit = $("#update").serialize();
		
		$.ajax({
			type: "POST",
			url: "/photo_update/${session.loginUser.mem_id}",
			data: udsubmit,
			dataType: "html",
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
		    height: 250,
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
			minHeight: 300,             // 최소 높이
		  	maxHeight: null,             // 최대 높이
		  	focus: true,
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
		  });
    });
}


function updatee(url){
	var submit = $("#update").serialize();
	
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
 	
 	
// infinite scroll start



