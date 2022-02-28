/** 회원가입 */
/*
   폼 빈칸 체크 
*/
	let empJ = /\s/g;
    let idCheckFlag;
    let idDupliCheckFlag;
    let idUsingFlag;
function joinFormCheck(){
    
    let id, pass, cpass, name, birthdate, email1, email2, email3, hp, gender;
    let idMsg, passMsg, cpassMsg, nameMsg, birthdateMsg,genderMsg, emailMsg, hpMsg;
    id = document.getElementById("id");
    idMsg = document.getElementById("idMsg");
    pass = document.getElementById("pass");
    passMsg = document.getElementById("passMsg");
    cpass = document.getElementById("cpass");
    cpassMsg = document.getElementById("cpassMsg");
    name = document.getElementById("name");
    nameMsg = document.getElementById("nameMsg");
    birthdate = document.getElementById("birthdate");
    birthdateMsg = document.getElementById("birthdateMsg");
    gender = document.getElementById("gender");
    genderMsg =document.getElementById("genderMsg");
    email1 = document.getElementById("email1");
    email2 = document.getElementById("email2");
    email3 = document.getElementById("email3");
    emailMsg = document.getElementById("emailMsg");
    hp = document.getElementById("hp");
    hpMsg = document.getElementById("hpMsg");
    
    let checkList=[idMsg,passMsg,cpassMsg,nameMsg,birthdateMsg,emailMsg,hpMsg];
    let checkListCount=0;
    
    for(let i=0;i<checkList.length;i++){
        if(checkList[i].innerHTML=="유효한 양식이 아닙니다"){
           checkListCount++;
        }
    }
    
    if(id.value == ""){
        idMsg.innerHTML = "아이디를 입력해주세요";
        idMsg.style.color = "#FF1493";
        id.style.border = "2px solid #FF1493";
        id.focus();
        return false;
    }else if(pass.value == ""){
        passMsg.innerHTML = "비밀번호를 입력해주세요";
        passMsg.style.color = "#FF1493";
        pass.style.border = "2px solid #FF1493";
        pass.focus();
        return false;
    }else if(cpass.value == ""){
        cpassMsg.innerHTML = "비밀번호 확인을 입력해주세요";
        cpassMsg.style.color = "#FF1493";
        cpass.style.border = "2px solid #FF1493";
        cpass.focus();
        return false;
    }else if(name.value == ""){
        nameMsg.innerHTML = "성명을 입력해주세요";
        nameMsg.style.color = "#FF1493";
        name.style.border = "2px solid #FF1493";
        name.focus();
        return false;
    }else if(birthdate.value == ""){
        birthdateMsg.innerHTML = "생년월일을 입력해주세요";
        birthdateMsg.style.color = "#FF1493";
        birthdate.style.border = "2px solid #FF1493";
        birthdate.focus();
        return false;
    }else if(checkCount("mem_gender")==0){
		genderMsg.innerHTML = "성별을 선택해주세요";
		genderMsg.style.color = "#FF1493";
        gender.style.border = "2px solid #FF1493";
		return false;
	}else if(email1.value == ""){
        emailMsg.innerHTML = "이메일을 입력해주세요";
        emailMsg.style.color = "#FF1493";
        email1.style.border = "2px solid #FF1493";
        email1.focus();
        return false;
    }else if(email2.value == ""){
        emailMsg.innerHTML = "이메일 주소를 선택해주세요";
        emailMsg.style.color = "#FF1493";
        email2.style.border = "2px solid #FF1493";
        email3.focus();
        return false;
    }else if(hp.value == ""){
        hpMsg.innerHTML = "핸드폰 번호를 입력해주세요";
        hpMsg.style.color = "#FF1493";
        hp.style.border = "2px solid #FF1493";
        hp.focus();
        return false;
    }else if(checkListCount > 0){
        alert("양식을 확인해주세요");
        return false;
    }else if(idDupliCheckFlag==0){
		if(idUsingFlag==1){
	        alert("다른 아이디를 입력해주세요");
	        id.style.border = "2px solid #FF1493";
	        id.focus();
		}else{
	        alert("아이디 중복확인을 해주세요");
	        $('#btn_idCheck').css("border-color","#FF1493");
		}
	        return false;
    }else{
        joinForm.submit();
        alert("회원가입이 완료되었습니다.\n로그인 페이지로 이동합니다.");
    }
}

/*
    회원가입 - 아이디 유효성 체크
*/
function idCheck(){
    let idJ = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,10}$/;
    let id,idMsg;
    id = document.getElementById("id");
    idMsg = document.getElementById("idMsg");
    idCheckFlag=0;
    idDupliCheckFlag=0;
    idUsingFlag=0;
    if(id.value != ""){
        if(!idJ.test($('#id').val())||empJ.test($('#id').val())){
        idMsg.style.color = "#FF1493";
        id.style.border = "2px solid #FF1493";
        idMsg.innerHTML = "유효한 양식이 아닙니다";
        return false;

        }else{
            idMsg.innerHTML = "";
            id.style.border = "1px solid #ddd";
            idCheckFlag=1;
        }
    }
}

/*
    회원가입 - 비밀번호 유효성 체크
*/
    let pwJ = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,10}$/; 
    let pass,cpass,passMsg,cpassMsg;
    pass = document.getElementById("pass");
    cpass = document.getElementById("cpass");
    passMsg = document.getElementById("passMsg");
    cpassMsg = document.getElementById("cpassMsg");
function passCheck(){
	if(cpass.value==""){
        cpass.style.border = "1px solid #ddd";
        cpassMsg.innerHTML = "";
	}
    if(!pwJ.test($('#pass').val())||empJ.test($('#pass').val())){
        passMsg.style.color = "#FF1493";
        pass.style.border = "2px solid #FF1493";
        passMsg.innerHTML = "유효한 양식이 아닙니다";
        return false;
    }else{
        passMsg.innerHTML = "";
        pass.style.border = "1px solid #ddd";
    }
}
function cpassCheck(){
	if(pass.value==""){
        pass.style.border = "1px solid #ddd";
        passMsg.innerHTML = "";
	}
    if(!pwJ.test($('#cpass').val())||empJ.test($('#cpass').val())){
        cpassMsg.style.color = "#FF1493";
        cpass.style.border = "2px solid #FF1493";
        cpassMsg.innerHTML = "유효한 양식이 아닙니다";
    	return false;
    }else{
        cpassMsg.innerHTML = "";
        cpass.style.border = "1px solid #ddd";
    }
}

/*
    회원가입 - 비밀번호 일치 체크
*/
function passSameCheck(){
    if(pass.value != "" && cpass.value != ""){
        if(pass.value == cpass.value){
			if(pwJ.test($('#pass').val())){
	            passMsg.innerHTML = "";
	            cpassMsg.innerHTML = "";
	            pass.style.border = "1px solid #ddd";
	            cpass.style.border = "1px solid #ddd";
	            passMsg.innerHTML = "비밀번호가 일치합니다";
	            passMsg.style.color = "blue";
	            return true;
			}else{
				passMsg.style.color = "#FF1493";
		        passMsg.innerHTML = "유효한 양식이 아닙니다";
		        pass.style.border = "2px solid #FF1493";
		        pass.value="";
		        cpass.value="";
		        cpassMsg.innerHTML = "";
		        cpass.style.border = "1px solid #ddd";
		        pass.focus();
			}
        }else{
            passMsg.style.color = "#FF1493";
            passMsg.innerHTML = "비밀번호가 일치하지 않습니다";
	        pass.style.border = "2px solid #FF1493";
            pass.value = "";
            cpass.value = "";
            cpassMsg.innerHTML = "";
	        cpass.style.border = "1px solid #ddd";
            pass.focus();
            return false;
        }       
    }
}

/*
    회원가입 - 성명 유효성 체크
*/
function nameCheck(){
    let nameJ = /^[가-힣]{2,5}$/;
    let name,nameMsg;
    name = document.getElementById("name");
    nameMsg = document.getElementById("nameMsg");
    if(name.value != ""){
        if(!nameJ.test($('#name').val())||empJ.test($('#name').val())){
        nameMsg.style.color = "#FF1493";
        name.style.border = "2px solid #FF1493";
        nameMsg.innerHTML = "유효한 양식이 아닙니다";
    //    $('#name').val('');
        return false;

        }else{
            nameMsg.innerHTML = "";
            name.style.border = "1px solid #ddd";
        }
    }
}

/*
    회원가입 - 생년월일 유효성 체크
*/
function birthdateCheck(){
    let bdJ = /^[0-9]{8}$/;
    let birthdate, birthdateMsg;
    birthdate = document.getElementById("birthdate");
    birthdateMsg = document.getElementById("birthdateMsg");
    if(birthdate.value != ""){
        if(!bdJ.test($('#birthdate').val())||empJ.test($('#birthdate').val())){
        nameMsg.style.color = "#FF1493";
        birthdate.style.border = "2px solid #FF1493";
        birthdateMsg.innerHTML = "유효한 양식이 아닙니다";
    //    $('#name').val('');
        return false;
        }else{
            birthdateMsg.innerHTML = "";
            birthdate.style.border = "1px solid #ddd";
        }
    }
}

/*
    회원가입 - 성별 유효성 체크
*/
function checkCount(gender){
	let count, list;
	count=0;
	list = document.getElementsByName(gender);
	for(let i=0; i<list.length; i++){
		if(list[i].checked){
			count++;
		}
	}
	return count;
}

/*
    회원가입 - 이메일 주소 체크
*/
function emailSelectCheck(){
    let email2, email3;
    email2 = document.getElementById("email2");
    email3 = document.getElementById("email3");
    emailMsg = document.getElementById("emailMsg");
    
    if(email3.value == "choice"){
        emailMsg.innerHTML = "다른 주소를 선택해주세요";
        emailMsg.style.color = "#FF1493";
        email2.value = "";      
    }else if(email3.value == "self"){
        emailMsg.innerHTML = "";
        email2.value = "";
        email2.focus();
    }else {
        emailMsg.innerHTML = "";
        email2.value = email3.value;
        email2.style.border = "1px solid #ddd";
        if(email1.value!=""){
        	email1.style.border = "1px solid #ddd";
		}
	}
}
/*
    회원가입 - 이메일 유효성 체크
*/
function emailCheck(){
    let email1, email2;
    email1 = document.getElementById("email1");
    email2 = document.getElementById("email2");
    emailMsg = document.getElementById("emailMsg");
    
    if(email1.value != ""&&email2.value != ""){
        emailMsg.innerHTML = "";
        email1.style.border = "1px solid #ddd";
        email2.style.border = "1px solid #ddd";
    }else if(email1.value != ""){
        emailMsg.innerHTML = "";
        email1.style.border = "1px solid #ddd";
	}else if(email2.value != ""){
        emailMsg.innerHTML = "";
        email2.style.border = "1px solid #ddd";
	}
}

/*
   회원가입 - 핸드폰 번호 확인
*/
function hpCheck(){
    let phoneJ = /^01\d\d{3,4}\d{4}$/;
    let hp,hpMsg;
    hp = document.getElementById("hp");
    hpMsg = document.getElementById("hpMsg");
    if(hp.value != ""){
        if(!phoneJ.test($('#hp').val())){
        hpMsg.style.color = "#FF1493";
        hp.style.border = "2px solid #FF1493";
        hpMsg.innerHTML = "유효한 양식이 아닙니다";
        return false;

        }else{
            hpMsg.innerHTML = "";
            hp.style.border = "1px solid #ddd";
        }
    }
}

/*
    아이디 중복 체크
*/
 function idDupliCheck(){
    if(idCheckFlag==1){
       let userId = $('#id').val();
       $.ajax({
           url:"/idCheck",
           type:"post",
           data:{id:userId},
           dataType:"json",
           success:function(result){
               if(result==1){
			$('#btn_idCheck').css("border-color","white");
			$('#id').css("border-color","#FF1493");
			$('#idMsg').html("이미 사용 중인 아이디입니다");
			$('#idMsg').css('color',"#FF1493");
            $('#id').focus();
            idUsingFlag=1;
               }else{
            $('#idMsg').html("사용 가능한 아이디입니다");
            $('#idMsg').css('color','blue');
       		$('#pass').focus();
            idDupliCheckFlag=1;
            $('#btn_idCheck').css("border-color","white");
               }
           },
           error:function(request, status, error){
               alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           }
       })
    }else{
		if($('#id').val()!=""){
	        alert("유효한 아이디를 입력해주세요");
	        $('#btn_idCheck').css("border-color","white");
		}else{
			$('#idMsg').text("아이디를 입력해주세요");
			$('#idMsg').css("color","#FF1493");
			$('#id').css("border","1px solid #FF1493");
			$('#btn_idCheck').css("border-color","white");
		}
    }
}

/*
	회원가입 - 생년월일 달력
*/
   $(function() {
       //input을 datepicker로 선언
       $("#birthdate").datepicker({
           dateFormat: 'yymmdd' //달력 날짜 형태
           ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
           ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
           ,changeYear: true //option값 년 선택 가능
           ,changeMonth: true //option값  월 선택 가능                
           ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
           ,buttonImage: "/image/calendar3.png"//"http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
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

/*
	리셋 버튼 폼 초기화
*/
function resetForm(){
	$('#joinForm .Msg').empty();
	$('#joinForm input').css("border-color", "lightgray");
	$('#joinForm input').css("border-width", "1px");
	$('#btn_idCheck').css("border-color","white");
}






