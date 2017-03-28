var w = c.width = window.innerWidth;
var h = c.height = window.innerHeight*0.382;
var ctx = c.getContext('2d');

var opts = {		      
  color: 'hsl(hue,100%,light%)',
  cx: w / 2,
  cy: h / 2,
};

var tick = 0;
var lines = [];
var dieX = w / 2;
var dieY = h / 2;
var baseRad = Math.PI * 2 / 6;
    
ctx.fillStyle = 'black';
ctx.fillRect( 0, 0, w, h );

function loop() 
{		  
  window.requestAnimationFrame( loop );
  
  ++tick;
  
  ctx.globalCompositeOperation = 'source-over';
  ctx.shadowBlur = 0;
  ctx.fillStyle = 'rgba(0,0,0,alp)'.replace( 'alp', .04 );
  ctx.fillRect( 0, 0, w, h );
  ctx.globalCompositeOperation = 'lighter';
  
  if( lines.length < 300 && Math.random() < 1 )
    lines.push( new Line );
  
  lines.map( function( line ){ line.step(); } );
}

function Line()
{
  this.reset();
}

Line.prototype.reset = function()
{
  
  this.x = 0;
  this.y = 0;
  this.addedX = 0;
  this.addedY = 0;
  this.rad = 0;

	if(Math.random() < 0.5 ) 
	{
		
		if(window.innerWidth <= 1024) 
		{
			this.x = 0;
		} 

		if(window.innerWidth > 1024 && window.innerWidth <= 1440) 
		{
			this.x = 6;
		} 

		if(window.innerWidth > 1440 && window.innerWidth <= 2560)  
		{
			this.x = 12;
		}

		if(window.innerWidth > 2560 && window.innerWidth <= 4000)  
		{
			this.x = 18;
		}

		if(window.innerWidth > 4000)  
		{
			this.x = 24;
		}
		
	} 
	else 
	{
		if(window.innerWidth <= 1024) 
		{
			this.x = 0;
		} 

		if(window.innerWidth > 1024 && window.innerWidth <= 1440) 
		{
			this.x = -6;
		} 

		if(window.innerWidth > 1440 && window.innerWidth <= 2560)  
		{
			this.x = -12;
		}

		if(window.innerWidth > 4000)  
		{
			this.x = -24;
		}					
	}		  
  
  this.lightInputMultiplier = .01 + .02 * Math.random();
  
  this.color = opts.color.replace( 'hue', tick * .07 );
  this.cumulativeTime = 0;
  
  this.beginPhase();
}

Line.prototype.beginPhase = function()
{
  


  this.x += this.addedX;
  this.y += this.addedY;
  
  this.time = 0;
  this.targetTime = ( 10 + 10 * Math.random() ) | 0;
  
  this.rad += baseRad * ( Math.random() < .5 ? 1 : -1 );
  this.addedX = Math.cos( this.rad );
  this.addedY = Math.sin( this.rad );
  
  if( Math.random() < .01 || this.x > dieX || this.x < -dieX || this.y > dieY || this.y < -dieY )
    this.reset();
}

Line.prototype.step = function()
{
  
  ++this.time;
  ++this.cumulativeTime;
  
  if( this.time >= this.targetTime )
    this.beginPhase();
  
  var prop = this.time / this.targetTime,
      wave = Math.sin( prop * Math.PI / 2 ),
      x = this.addedX * wave,
      y = this.addedY * wave;
  
  ctx.shadowBlur = prop * 6;
  ctx.fillStyle = ctx.shadowColor = this.color.replace( 'light', 50 + 10 * Math.sin( this.cumulativeTime * this.lightInputMultiplier ) );
  ctx.fillRect( opts.cx + ( this.x + x ) * 45, opts.cy + ( this.y + y ) * 45, 2 , 2);
  
  if( Math.random() < .1 )
    ctx.fillRect( opts.cx + ( this.x + x ) * 45 + Math.random() * 20 * ( Math.random() < .5 ? 1 : -1 ) - 2 / 2, opts.cy + ( this.y + y ) * 45 + Math.random() * 20 * ( Math.random() < .5 ? 1 : -1 ) - 2 / 2, 2, 2 )
}
loop();

window.addEventListener( 'resize', function(){
  
  w = c.width = window.innerWidth;
  h = c.height = window.innerHeight;
  ctx.fillStyle = 'black';
  ctx.fillRect( 0, 0, w, h );
  
  opts.cx = w / 2;
  opts.cy = h / 2;
  
  dieX = w / 2 / 45;
  dieY = h / 2 / 45;

});