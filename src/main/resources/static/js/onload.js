var colorss =["#ffe500","#51ff00","#ff0000","#003cff","#00ffaa","#ccff00"]
var colors =["#ffe500","#ff0090"]
var n=0,mouseInBox=0,boxBinded=0;
var flashingBox;

$(function (){
	loadStatusIcon(); 
    $("[data-toggle='tooltip']").tooltip();
    flashBoxBinding();
});

var flashBoxBinding = function(){
	if(boxBinded==0){
		boxBinded=1;
	    $(".flash-box").mouseenter(function(){mouseInBox=1;flashingBox=this;turncolors(this);});
		$(".flash-box").mouseleave(function(){
			mouseInBox=0;$(".flash-box").css("border-color","#ccc");})
	}else{
		boxBinded=0;
		$(".flash-box").unbind("mouseenter").unbind("mouseleave");
	}
}

var turncolors = function(flashBox){
	if(flashBox!=flashingBox)return;
	if(mouseInBox==0)return;
	n++;if (n==colors.length) n=0;
	$(flashBox).css("border-color",colors[n]);
	setTimeout(function(){turncolors(flashBox)},100);
}