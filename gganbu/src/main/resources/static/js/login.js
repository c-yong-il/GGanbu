/** 로그인 */

/*
    로그인 실패 메시지 출력
*/
 function loginCheck(){
       let mem_id = $('#id').val();
       let mem_pass = $('#pass').val();
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
					$('#loginMsg').attr('style','color:red');
               }
           },
           error:function(request, status, error){
               alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           }
       })
}



