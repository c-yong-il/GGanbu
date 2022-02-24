function Quit(url){
	if(confirm("깐부관계를 끊으시겠습니까?")){
		window.location.href=url;
	}
 }
 	
function acceptGganbu(url){
	if(confirm("깐부요청을 수락하시겠습니까?")){
		window.location.href=url;
	}
}

function refuseGganbu(url){
 	if(confirm("깐부요청을 거절하시겠습니까?")){
		window.location.href=url;
	}
}