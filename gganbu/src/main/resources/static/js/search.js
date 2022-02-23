/**
 * 깐부 신청하기
 */
 function requestGganbu(url){
	/*alert("깐부신청이 되었습니다.");*/
	if(confirm("깐부신청을 하시겠습니까?")){
	/*searchResultForm.submit();*/
	window.location.href = url;
	}
		}
		

function searchWord(url){
/*	alert("나오는거야 마는거야0");*/
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
       		 } // $.ajax */
	
			});
			
		}

		

	
