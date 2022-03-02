
/* 글쓰기 화면 이동 */
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
		    height: 300,
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
			minHeight: null,             // 최소 높이
		  	maxHeight: null,             // 최대 높이
		  	focus: true,
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
		  });
    });
}

/* 수정화면 이동 and 수정하기 */
function updatee(url){
	var ucontent = $("#photo_content").val();
	if(ucontent == ""){
		alert("수정할 내용을 입력해 주세요");
		$("#photo_content").focus();
		return false;
	}
	
	var submit = $("#updateForm").serialize();
	
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
			    height: 300,
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
			minHeight: null,             // 최소 높이
		  	maxHeight: null,             // 최대 높이
		  	focus: true,
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
			  });
   		 });
 	}
 	
/* 게시글 삭제 */
 function deletee(url){
	
	if (confirm("정말로 삭제하시겠습니까?")){
	
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
 	}
 	
 /* 게시글 등록 */
 function inserte(url){
	var content = $("#photo_content").val();
	if(content == ""){
		alert("글을 입력해 주세요");
		$("#photo_content").focus();
		return false;
	}
		var submit = $("#insertForm").serialize();
	
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
   		 });
 	}
 
  /* 댓글 등록 */
  function cinsert(url,num){
	var c_content = $("#comment_content"+num).val();
	if(c_content == ""){
		alert("댓글을 입력해 주세요");
		$("#comment_content"+num).focus();
		return false;
	}
	
		var csubmit = $("#cinsertForm"+num).serialize();
	
    $.ajax({
        url : url,
        type : 'POST', 
        data :  csubmit, 
        dataType:"html",
        }).done(function(data){
            // Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
   		 });
    }
 	
 	
 	
/* 댓글 삭제 */
function cdeletee(url){
	if (confirm("정말로 삭제하시겠습니까?")){
		var cdeletesubmit = $("#cdelete").serialize();
	
    $.ajax({
        url : url,
        type : 'POST', 
        data :  cdeletesubmit, 
        dataType:"html",
        }).done(function(data){
            // Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
   		 });
   		 }
 	}
 	
 	/* 페이징 */
 	function movePage(uri, queryString){
	
    $.ajax({
        url : uri + queryString,
        type : 'POST', 
        }).done(function(data){
            // Contents 영역 삭제
	        $('#photo').children().remove();
	        // Contents 영역 교체
	        $('#photo').html(data);
   		 });
 	}
 	
 	
/*****************************************************/

/* 댓글 보이기/숨기기 */
function openCloseToc(num) {
	/*var con = document.getElementById('Contentt'+num);*/
	var submenu = $("#toc-toggle"+num).next("div");
	
	if( submenu.is(":visible") ){
                submenu.slideUp();
                document.getElementById('toc-toggle'+num).textContent = '댓글보이기';
            }else{
                submenu.slideDown();
                document.getElementById('toc-toggle'+num).textContent = '댓글숨기기';
            }
  }

 
/************************************************************************************/
