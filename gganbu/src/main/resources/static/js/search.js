/**
 * 깐부 신청하기
 */
 function requestGganbu(url){
	alert("깐부신청이 되었습니다.");
		$.ajax({
			url:url,
			type:'POST',
			data : $("#searchResultForm").serialize(),
			async:true,
			dataType:"html",
            success : function(data){
			// Contents 영역 삭제
	        $('#searchContent').children().remove();
	        // Contents 영역 교체
	        $('#searchContent').html(data);
       		 } // $.ajax */
	
			});
			
		}
		

function searchWord(url){
/*	alert("나오는거야 마는거야0");*/
		$.ajax({
			url:url,
			type:'POST',
			data : $("#searchForm").serialize(),
			async:true,
			dataType:"html",
            success : function(data){
			// Contents 영역 삭제
	        $('#searchContent').children().remove();
	        // Contents 영역 교체
	        $('#searchContent').html(data);
       		 } // $.ajax */
	
			});
			
		}

		

	
