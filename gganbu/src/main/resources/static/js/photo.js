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
	},
	
	save: function(){
		let data = {
			content: $("#photo_content").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/photo_list",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(resp){
			alert("글쓰기가 완료되었습니다.");
			location.href = "/photo_list";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	},
	
	delete: function(){		
		let photo_num = $("#photo_num").text();
		
		$.ajax({
			type: "DELETE",
			url: "/photo_list"+mem_id+photo_num,
			dataType: "json" 
		}).done(function(resp){
			alert("삭제가 완료되었습니다.");
			location.href = "/photo_list";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	},
	
	update: function(){
		let data = {
			content: $("#content").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/photo_list",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(resp){
			alert("글수정이 완료되었습니다.");
			location.href = "/photo_list";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	},
}

index.init();