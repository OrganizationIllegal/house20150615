$(function(){
	$(".cp").data("open",false);
	$(".cp").click(function(){
		if($(this).data("open") == false){
			$(".main_more").fadeIn(function(){
				$(".cp").data("open",true);			
			});
		}else{
			$(".main_more").fadeOut(function(){
				$(".cp").data("open",false);			
			});
		}
	});
});
