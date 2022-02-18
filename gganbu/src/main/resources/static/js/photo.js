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
		    width:550
		  });
    });
}
