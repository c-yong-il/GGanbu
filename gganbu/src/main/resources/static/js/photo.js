let index = {
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
		
		var formsubmit = $("#insertForm").serialize();

		$.ajax({
			type: "POST",
			url: "/photoInsert/{session.loginUser.mem_id}",
			data: formsubmit,
			dataType: "html" 
		}).done(function(data){
			// Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
		});
	},
	
	delete: function(){		
		var formsubmit = $("#deleteForm").serialize();
		
		$.ajax({
			type: "DELETE",
			url: "/delete/{photo_num}",
			data: formsubmit,
			dataType: "json" 
		}).done(function(data){
			// Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
		}); 
	},
	
	update: function(){
		var formsubmit = $("#updateForm").serialize();
		
		$.ajax({
			type: "POST",
			url: "/photoupdate/${session.loginUser.mem_id}",
			data: formsubmit,
			dataType: "html" 
		}).done(function(data){
			// Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
		}); 
	},
	
	ud: function(){
		var formsubmit = $("#update").serialize();
		
		$.ajax({
			type: "POST",
			url: "/photo_update/${session.loginUser.mem_id}",
			data: formsubmit,
			dataType: "html" 
		}).done(function(data){
			// Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
		}); 
	},
}

index.init();