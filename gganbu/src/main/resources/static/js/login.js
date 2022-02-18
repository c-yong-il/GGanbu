/** 로그인 */

/*
    빈칸 체크

document.addEventListener("DOMContentLoaded", function() {
    let id = document.getElementById("id");
    let pass = document.getElementById("pass");
    
        id.oninvalid = function(e) {
            e.target.setCustomValidity("");
            if (!e.target.validity.valid) {
	        	e.target.setCustomValidity("아이디를 입력해주세요");
            }
        };
        id.oninput = function(e) {
            e.target.setCustomValidity("");
        };
        pass.oninvalid = function(e) {
            e.target.setCustomValidity("");
            if (!e.target.validity.valid) {
	        	e.target.setCustomValidity("비밀번호를 입력해주세요");
            }
        };
        pass.oninput = function(e) {
            e.target.setCustomValidity("");
        };
})*/

/* 
	로그인 - 로그인 성공,실패 체크
 */
 function loginCheck(){
       let mem_id = $('#id');
       let mem_pass = $('#pass');
       let loginMsg = $('#loginMsg');
       
       if(mem_id.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').html('아이디를 입력해주세요');
	        mem_id.focus();
	        return false;
		}
       if(mem_pass.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').html('비밀번호를 입력해주세요');
	        mem_pass.focus();
	        return false;
		}
       
   if(mem_id.val()!="" && mem_pass.val()!=""){
	
		let loginData = jQuery("#loginForm").serialize();
	
       $.ajax({
           url:"/login/loginCheck",
           type:"post",
           data:loginData,
           dataType:"json",
           success:function(result){
               if(result==1){
					alert(mem_id.val()+"님 어서 오세요~");
					location.href="/main";
               }else if(result==0){
					$('#loginMsg').html('아이디 혹은 비밀번호가 일치하지 않습니다');
					$('#loginMsg').attr('style','visibility:visible');
					$('#loginMsg').attr('style','color:#FF1493');
               }
           },
           error:function(request, status, error){
               alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           }
       })
	}
}


