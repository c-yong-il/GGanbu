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
	$( 'a' ).click( function() {
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
    
    $.ajax({
        url : url,
        type : 'POST',
        data : delsubmit,
        datatype : "html"
    }).done(function(data){
        alert('1'+'hi');
        $('#test').children().remove();
        $('#test').html(data);
        alert('2'+$("#gganbucommentForm").serialize());
        alert('3'+data);
        alert('4'+delsubmit);
        alert('5'+session.loginUser.mem_id);
        alert('6'+mem_id);
        alert('7'+id);
        window.location.href = '/mini/pop_main/@{${session.loginUser.mem_id}}';
        
    });
    }
    
