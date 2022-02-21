/** 달력*/
/* $(document).ready(function () { 
      $(document).on('focus', '.datefield', function () {
          $(this).datepicker();
      });
  });*/
    $(function() {
       //input을 datepicker로 선언
       $("#dateSelect").datepicker({
           dateFormat: 'yymmdd' //달력 날짜 형태
           ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
           ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
           ,changeYear: true //option값 년 선택 가능
           ,changeMonth: true //option값  월 선택 가능                
           ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
           ,buttonImage: "/image/calendar3.png" //"http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
           ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
           ,buttonText: "선택" //버튼 호버 텍스트              
           ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
           ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
           ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
           ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
           ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
           ,minDate: "-100Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
           ,maxDate: "0" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후) 
           ,yearRange: "-100:+0"
       });                    
   });

 
 /** 글쓰기 버튼 눌렀을 때*/
 function diaryWrite(url){
	var option ={
			type:"POST",
			url:url,
			async:true,
			dataType:"html",
			cache:false
	};
	 $.ajax(option).done(function(data){
        // Contents 영역 삭제
        $('#diary_change').children().remove();
        // Contents 영역 교체
        $('#diary_change').html(data);
    });
    /*$(document).find("#dateSelect").removeClass('hasDatepicker').datepicker();*/
}
/* 글쓰고 등록 버튼 눌렀을 때*/
     function diaryWrite2(){
        $.ajax({
            cache : false,
            url : "/diaryInsert/${session.loginUser.mem_id}",
            type : 'POST', 
            data :  $("#diaryWriteForm").serialize(), 
            async:true,
            dataType:"html",
            success : function(data)
            {
             // Contents 영역 삭제
	        $('#diary_change').children().remove();
	        // Contents 영역 교체
	        $('#diary_change').html(data);
       		 } // $.ajax */
   	 	});
   	 	/*$(document).find("#dateSelect").removeClass('hasDatepicker').datepicker();*/
   	 }
   	 
   	 /** 수정하고 수정완료 버튼 눌렀을 때  */
   	 function diaryUpdate(){
	    $.ajax({
            cache : false,
            url : "/diaryUpdate/${session.loginUser.mem_id}", 
            type : 'POST', 
            data :  $("#diaryUpdateForm").serialize(), 
            async:true,
            dataType:"html",
            success : function(data)
            {
                // Contents 영역 삭제
	        $('#diary_change').children().remove();
	        // Contents 영역 교체
	        $('#diary_change').html(data);
       		 } // $.ajax */
   	 	});
   	 	/*$(document).find("#dateSelect").removeClass('hasDatepicker').datepicker();*/
	
}

/* 다이어리 수정 버튼 눌렀을 때 */ 
 	function diaryUpdateMove(url){
	    $.ajax({
            cache : false,
            url : url, 
            data :  $("#diaryForm").serialize(), 
            async:true,
            type : 'POST', 
            dataType:"html",
            success : function(data)
            {
                // Contents 영역 삭제
	        $('#diary_change').children().remove();
	        // Contents 영역 교체
	        $('#diary_change').html(data);
       		 } 
   	 	});
   	 	/*$(document).find("#dateSelect").removeClass('hasDatepicker').datepicker();*/
	} 


/** 다이어리 삭제 버튼 눌렀을 때 */	
	function diaryDelete(url) {
		if(confirm("정말로 삭제하시겠습니까?")){
		  $.ajax({
            cache : false,
            url : url, 
            type : 'POST', 
            data :  $("#diaryForm").serialize(), 
            async:true,
            dataType:"html",
            success : function(data)
            {
                // Contents 영역 삭제
	        $('#diary_change').children().remove();
	        // Contents 영역 교체
	        $('#diary_change').html(data);
       		 }
   	 	});
		}
	}
	
	/** 다이어리 날짜 눌렀을 때 */
		function diarySelect(url) {
		
		  $.ajax({
            cache : false,
            url : url, 
            type : 'POST', 
            data :  $("#dateSelect").serialize(), 
            async:true,
            dataType:"html",
            success : function(data)
            {
                // Contents 영역 삭제
	        $('#diary_change').children().remove();
	        // Contents 영역 교체
	        $('#diary_change').html(data);
       		 }
   	 	});
   	 	/*$(document).find("#dateSelect").removeClass('hasDatepicker').datepicker();*/
       		
	}





 