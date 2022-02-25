
/* 글쓰기 버튼 눌렀을 때*/
function guestWrite(url) {
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