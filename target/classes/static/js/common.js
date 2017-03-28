var loadStatusIcon = function(){
	$(".glyphicon").attr("data-toggle","tooltip");
	$(".fate-status-0").addClass("glyphicon-warning-sign").attr("title","游戏错误");
	$(".fate-status-1").addClass("glyphicon-pencil").attr("title","言论自由");
	$(".fate-status-2").addClass("glyphicon-heart").attr("title","第十三");
	$(".fate-status-3").addClass("glyphicon-user").attr("title","匿名者");
	$(".fate-status-4").addClass("glyphicon-remove").attr("title","不合理");
	$(".fate-status-5").addClass("glyphicon-globe").attr("title","black sheep wall");
	$(".fate-status-6").addClass("glyphicon-magnet").attr("title","磁性");
	$(".fate-status-7").addClass("glyphicon-certificate").attr("title","病毒");
	$(".fate-status-8").addClass("glyphicon-link").attr("title","锁链");
}

var LayoutCommon={
		showMessage: function(message){
			$(".modal-body").text(message);
			$(".modal-header").remove();
			$(".modal-footer").remove();
			$(".modal").modal('show');
			setTimeout(function(){
				$(".modal").modal('hide')},1500);
		}
}