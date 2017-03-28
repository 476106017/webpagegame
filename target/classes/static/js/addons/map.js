$(function (){
	
});

clickedXY = function(userX,userY,sight,index){
	var l = sight*2+1;
	var x = index % l;
	var y = parseInt(index / l);
	return [userX-sight+x,userY-sight+y];
}

getTypeName = function(typeNo){
	var name;
	switch(parseInt(typeNo)){
	case 1: name="玩家";break;
	
	case 1001: name="星球";break;
	}
	
	return name;
}