/* 
	로그인 - 로그인 성공,실패 체크
 */
 function loginCheck(){
       let mem_id = $('#id');
       let mem_pass = $('#pass');
       let loginMsg = $('#loginMsg');
       
       if(mem_id.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').text('아이디를 입력해주세요');
	        mem_id.focus();
	        return false;
		}
       if(mem_pass.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').text('비밀번호를 입력해주세요');
	        mem_pass.focus();
	        return false;
		}
       
   if(mem_id.val()!="" && mem_pass.val()!=""){
	
		let loginFormData = jQuery("#loginForm").serialize();
	
       $.ajax({
           url:"/login/loginCheck",
           type:"post",
           data: loginFormData,
           dataType:"json",
           success:function(result){
				if(result==0){
					$('#loginMsg').text('아이디 혹은 비밀번호가 일치하지 않습니다');
					$('#loginMsg').attr('style','visibility:visible');
					$('#loginMsg').attr('style','color:#FF1493');
                }else if(result==2){
					$('#loginMsg').text('탈퇴한 회원입니다');
					$('#loginMsg').attr('style','visibility:visible');
					$('#loginMsg').attr('style','color:#FF1493');
                }else if(result==3){
                    $('#loginMsg').text('존재하지 않는 아이디입니다');
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
			$('#loginMsg').text('이름을 입력해주세요');
	        mem_name.focus();
	        return false;
		}
       if(mem_hp.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').text('핸드폰번호를 입력해주세요');
	        mem_hp.focus();
	        return false;
		}
       
   if(mem_name.val()!="" && mem_hp.val()!=""){
	
		let loginFormData = jQuery("#loginForm").serialize();
	
       $.ajax({
           url:"/login/forgotIdCheck",
           type:"post",
           data: loginFormData,
           success:function(result){
				if(result==""){
					$('#loginMsg').text('입력한 정보와 일치하는 회원이 없습니다');
					$('#loginMsg').attr('style','visibility:visible');
					$('#loginMsg').attr('style','color:#FF1493');
                }else{
					$('#loginMsg').text('아이디: '+result);
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

/* 
	비밀번호찾기 - 성공,실패 체크
 */
 function forgotPassCheck(){
       let mem_name = $('#name');
       let mem_id = $('#id');
       let mem_birth = $('#birth');
       let mem_hp = $('#hp');
       let loginMsg = $('#loginMsg');
       
       if(mem_name.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').text('이름을 입력해주세요');
	        mem_name.focus();
	        return false;
		}
       if(mem_id.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').text('아이디를 입력해주세요');
	        mem_id.focus();
	        return false;
		}
       if(mem_birth.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').text('생년월일을 입력해주세요');
	        mem_birth.focus();
	        return false;
		}
       if(mem_hp.val() == ""){
			$('#loginMsg').attr('style','visibility:visible');
			$('#loginMsg').text('핸드폰번호를 입력해주세요');
	        mem_hp.focus();
	        return false;
		}
       
   if(mem_name.val()!="" && mem_hp.val()!=""){
	
		let loginFormData = jQuery("#loginForm").serialize();
	
       $.ajax({
           url:"/login/forgotPassCheck",
           type:"post",
           data: loginFormData,
           success:function(result){
				if(result==0){
					$('#loginMsg').text('입력한 정보와 일치하는 회원이 없습니다');
					$('#loginMsg').attr('style','visibility:visible');
					$('#loginMsg').attr('style','color:#FF1493');
                }else{
					$('#loginMsg').text('해당 이메일로 임시비밀번호가 발송되었습니다');
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


