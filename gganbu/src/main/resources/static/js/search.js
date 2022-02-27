/**
 * 깐부 신청하기
 */
 function requestGganbu(url){
	if(confirm("깐부신청을 하시겠습니까?")){
		$.ajax({
			url:url,
			success:function(result){
				if(result == 0){
					alert("깐부 신청이 완료되었습니다.");
					window.location.href ="/mgm/mgm";
				}else if(result == 1){
					alert("이미 깐부관계입니다 :D \n우린 깐부잖아~");
				}else if(result == 2){
					alert("깐부 수락 대기 중입니다! ");
				}
			}
		})
	}
}
		
		
/** 검색했을 때 */
function searchWord(url){
		$.ajax({
			url:url,
			type:'POST',
			data : $("#searchForm").serialize(),
			async:true,
            success : function(data){
			// Contents 영역 삭제
	        $('#searchContent').children().remove();
	        // Contents 영역 교체
	        $('#searchContent').html(data);
       		 } 
		});
}

		

	
