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