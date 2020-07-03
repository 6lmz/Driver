$(function(){
	$(window).scroll(function(event) {
		var down = true;
		var up = true;
	    if($(window).scrollTop() > 0){
			if(down){
				$("nav").stop().animate({
					backgroundColor: "rgba(0,0,0,1)"
                },10);
                down = false;
            }
        }
	    else{
	    	if(up){
	    		$("nav").stop().animate({
	    			backgroundColor: "rgba(0,0,0,0)"
	    		},10);
	    		up = false;
	    	}	
	    }
	});
	$("button").mouseover(function(){
		$(this).stop().animate({width:"100px",borderRadius:"25px"},500);
	});
 	$("button").mouseout(function(){
 		$(this).stop().animate({width:"200px",borderRadius:"0"},500);	
 	});
});