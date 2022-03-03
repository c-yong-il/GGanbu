/*
var menu = document.getElementsByClassName("menu-item");

      function handleClick(event) {

        if (event.target.classList[1] === "clicked") {
          event.target.classList.remove("clicked");
        } else {
          for (var i = 0; i < menu.length; i++) {
            menu[i].classList.remove("clicked");
          }

          event.target.classList.add("clicked");
        }
      }

      function init() {
        for (var i = 0; i < menu.length; i++) {
          menu[i].addEventListener("click", handleClick);
        }
      }

      init();
*/

let menu = document.getElementsByClassName("menu-item");
 for (var i = 0; i < menu.length; i++) {
	$( '.menu-item a' ).click( function() {
	  	$('.menu-item').removeClass('menu-checked');
	  	$(this).parent().addClass('menu-checked');
} );
}

/*
$(".Btn").on("click",funtion(e){
    e.preventDefault();
    let btnValue = this.value;
    checkboxpoint(btnValue);
});
*/
//체크박스 케크 확인
function checkboxpoint(btntext){
    var checkArr = [];
    $('input:checkbox[name=check]:checked').each(function(i) {
        checkArr.push(this.value);
    });
    checkArr.forEach(function(i){
        $("#attendenceType"+i).text(btntext);
    });
    $("input[name=check]").prop("checked",false);
}

//깐부평 삭제
function deleteGganbuComment(url){
    
    let delsubmit = $("#gganbucommentForm").serialize();
    
    if(confirm("깐부평을 삭제 하시겠습니까?")){
    
    $.ajax({
			url:url,
			type : 'POST',
			 data : delsubmit,
			 datatype : "html",
			success:function(data){
					window.location.href=window.location.href;
			}
		})
/*    $.ajax({
        url : url,
        type : 'POST',
        data : delsubmit,
        datatype : "html"
    }).done(function(data){
        $('#test').children().remove();
        $('#test').html(data);
    })*/
    
    }
}
    
 /* 미니홈피에서 깐부신청하기 */ 
 function requestGganbu(url){
	if(confirm("깐부신청을 하시겠습니까?")){
		$.ajax({
			url:url,
			success:function(result){
				if(result == 0){
					alert("깐부 신청이 완료되었습니다.");
					window.location.href=window.location.href;
				}
			}
		})
	}
}
	