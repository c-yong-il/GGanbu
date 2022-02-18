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
				if(result==0){
					$('#loginMsg').html('아이디 혹은 비밀번호가 일치하지 않습니다');
					$('#loginMsg').attr('style','visibility:visible');
					$('#loginMsg').attr('style','color:#FF1493');
                }else if(result==2){
					$('#loginMsg').html('탈퇴한 회원입니다');
					$('#loginMsg').attr('style','visibility:visible');
					$('#loginMsg').attr('style','color:#FF1493');
                }else{
					alert(mem_id.val()+"님 어서 오세요~");
					location.href="/main";
				}
           },
           error:function(request, status, error){
               alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           }
       })
	}
}


/* 
	아이디찾기 - 성공,실패 체크
 */
 function forgotIdCheck(){
       let mem_name = $('#name');
       let mem_hp = $('#hp');
       let loginMsg = $('#loginMsg');
       
       if(mem_name.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').html('이름를 입력해주세요');
	        mem_name.focus();
	        return false;
		}
       if(mem_hp.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').html('핸드폰번호를 입력해주세요');
	        mem_hp.focus();
	        return false;
		}
       
   if(mem_name.val()!="" && mem_hp.val()!=""){
	
		let forgotIdData = jQuery("#forgotIdForm").serialize();
	
       $.ajax({
           url:"/login/forgotIdCheck",
           type:"post",
           data:forgotIdData,
           success:function(result){
				if(result==""){
					$('#loginMsg').html('이름 혹은 핸드폰번호가 일치하지 않습니다');
					$('#loginMsg').attr('style','visibility:visible');
					$('#loginMsg').attr('style','color:#FF1493');
                }else{
					$('#loginMsg').html('아이디: '+result);
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


