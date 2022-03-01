
/* 글쓰기 버튼 눌렀을 때*/
function guest(url) {
	var option = {
		type: "POST",
		url: url,
		async: true,
		dataType: "html",
		cache: false
	};
	$.ajax(option).done(function(data) {
		// Contents 영역 삭제
		$('#guest_change').children().remove();
		// Contents 영역 교체
		$('#guest_change').html(data);
	});
}

/* 글쓰고 등록 버튼 눌렀을 때*/
function guestWrite(url) {
	var content = $("#guest_write").val();
	if(content == "") {
		alert("내용을 입력해주세요");
		$("#guest_write").focus();
		return false;
	}
	
	$.ajax({
		cache: false,
		url: url,
		type: 'POST',
		data: $("#guestWriteForm").serialize(),
		async: true,
		dataType: "html",
		success: function(data) {
			// Contents 영역 삭제
			$('#guest_change').children().remove();
			// Contents 영역 교체
			$('#guest_change').html(data);
		} 
	});
}

/* 방명록 수정 버튼 눌렀을 때 */
function guestUpdateMove(url) {
	
	$.ajax({
		cache: false,
		url: url,
		data: $("#guestForm").serialize(),
		async: true,
		type: 'POST',
		dataType: "html",
		success: function(data) {
			// Contents 영역 삭제
			$('#guest_change').children().remove();
			// Contents 영역 교체
			$('#guest_change').html(data);
		}
	});
}

/** 수정하고 수정완료 버튼 눌렀을 때  */
	function guestUpdate(url) {
		var content = $("#guest_write").val();
	if(content == "") {
		alert("내용을 입력해주세요");
		$("#guest_write").focus();
		return false;
	}
	$.ajax({
		cache: false,
		url: url,
		type: 'POST',
		data: $("#guestUpdateForm").serialize(),
		async: true,
		dataType: "html",
		success: function(data) {
			// Contents 영역 삭제
			$('#guest_change').children().remove();
			// Contents 영역 교체
			$('#guest_change').html(data);
		} 
	});

}

/* 방명록 삭제 버튼 눌렀을 때 */
function guestDelete(url) {
	if (confirm("정말로 삭제하시겠습니까?\n(삭제된 글은 복구되지 않습니다)")) {
		$.ajax({
			cache: false,
			url: url,
			type: 'POST',
			data: $("#guestForm").serialize(),
			async: true,
			dataType: "html",
			success: function(data) {
				// Contents 영역 삭제
				$('#guest_change').children().remove();
				// Contents 영역 교체
				$('#guest_change').html(data);
			}
		});
	}
}
/* 페이징 이동 */ 
function movePage(uri, queryString){
	$.ajax({
	    url : uri + queryString,
	    type : 'POST', 
	    }).done(function(data){
	        // Contents 영역 삭제
	        $('#guest_change').children().remove();
	        // Contents 영역 교체
	        $('#guest_change').html(data);
		 });
}