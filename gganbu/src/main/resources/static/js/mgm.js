function Quit(url){
	
    $.ajax({
        url : url,
        type : 'POST', 
        dataType:"html",
        }).done(function(){
            
   		 });
 	}