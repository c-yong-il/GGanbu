/** 로그인 */

/*
    빈칸 체크
*/
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
})

/* 
	로그인 - 로그인 성공,실패 체크
 */
 function loginCheck(){
       let mem_id = $('#id').val();
       let mem_pass = $('#pass').val();
       
   if(mem_id!="" && mem_pass!=""){
	
       $.ajax({
           url:"/login/loginCheck",
           type:"post",
           data:{mem_id:mem_id,mem_pass:mem_pass},
           dataType:"json",
           success:function(result){
               if(result==1){
					alert(mem_id+"님 어서 오세요~");
					location.href="/main";
               }else if(result==0){
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


