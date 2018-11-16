<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>寻梦空间</title>
	</head>

	<body>
		<div id="stage" style="margin: 0 auto; width: 850px; height: 661px; text-align: center; vertical-align: middle" >
			<canvas id="canvas" style="border:0px solid red;" width="850" height="661">
				不支持画板对象
			</canvas>
		</div>
		<script>
            //画笔画布的导入
			var canvas = document.getElementById('canvas');
			var ctx = canvas.getContext('2d');
			//游戏图片的导入
			var bg = new Image();
			bg.src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/bg.jpg";
			//板图片
			var board = new Image();
			board.src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/board.png";
			//游戏结束
			var gameOver = new Image();
			gameOver.src = "<%=request.getContextPath()%>"+"/skins/skin/bj/img/zkgame/GAME_OVER.png";
			//成功
			var success = new Image();
			success.src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/success.png";
			//球图片
			var ball = new Image();
			ball.src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/ball.png";
			//砖块图片数组的创建
			var zk = [];
			zk[0] = new Image();
			zk[0].src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/0.png";
			zk[1] = new Image();
			zk[1].src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/1.png";
			zk[2] = new Image();
			zk[2].src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/2.png";
			zk[3] = new Image();
			zk[3].src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/3.png";
			zk[4] = new Image();
			zk[4].src = "<%=request.getContextPath()%>/skins/skin/bj/img/zkgame/4.png";
			//坐标点
			var x = 552 / 2 - 195 / 2;
			var y = 622;
			//随机数（球的弹射方向-不确定性）
			var n = Math.random() * 2 + 2;
			var m = Math.random() * 2 + 2;
			//初始状态设置
			var score = 0;
			var life = 3;
			// p层数
			var p = 0;

			//球对象（对象固有属性的书写 对象直接量）
			var b = {
				x : 552 / 2 - 46 / 2,
				y : 622 - 46,
				width : 46,
				height : 46,
				//调用paint方法绘制球
				paint : function() {
					ctx.drawImage(ball, this.x, this.y);
				}
			}
		//确保游戏每时每刻都在发生变化
			var zks = [];//砖块数
			var s = setInterval(function() {
				ctx.drawImage(bg, 0, 0);
				ctx.drawImage(board, x, y);
				paint();
				move();
				check();
			}, 1);

			//砖块的构造方法（属性及其应用方法的定义）
			function Zk(x, y, width, height, img) {
				this.x = x;
				this.y = y;
				this.height = height;
				this.width = width;
				this.img = img;
				this.paint = function() {
					ctx.drawImage(this.img, this.x, this.y);
				}
			}
			//for循环：初始值为0，如果i<10,i就会每次都加1
			//直到i<10不成立.p代表砖块层数
			for (var i = 0; i < 10; i++) {
				if (i <= 4) {
					zks[zks.length] = 
					new Zk(i * 98 + 30, 30, 98, 34, zk[i]);
				} else {
					zks[zks.length] = 
					new Zk(p * 98 + 30, 30 + 40, 46, 46, zk[p]);
					p++;
				}
			}
			//绘画方法的定义
			function paint() {
				for (var i = 0; i < zks.length; i++) {
					zks[i].paint();
				}
				ctx.fillStyle = "white";
				ctx.font = "40px 华文琥珀";
				ctx.fillText("SCORE:"+score,591,144);
				ctx.fillText("LIFE :"+life,591,220);
				b.paint();
			}
			//移动方法的定义，b代表我们的小球
			function move() {
				b.x = b.x + m;
				b.y = b.y - n;
				if (b.x < 30) {
					m = Math.random() * 2 + 2;
				}
				if (b.x > 522 - 46) {
					m = -(Math.random() * 2 + 2);
				}
				if (b.y < 30) {
					n = -(Math.random() * 2 + 2);
				}
				
			}
			//碰撞检测机制 check(核实，检测)
			function check(){
				for(var i = 0;i<zks.length;i++){
					//判断小球撞到砖块
					if(b.x>zks[i].x-b.width
						&&b.x<zks[i].x+zks[i].width
						&&b.y>zks[i].y-b.height&&
						b.y<zks[i].y+zks[i].height){
						zks.splice(i,1);//碰到砖块，砖块消失。
						score++;
						m = -1*m;//m,n表示小球弹射的方向
						n = -1*n;
					}
				}
				//没撞到，碰到墙壁，随机方向弹射
				if(b.x>x-b.width&&b.x<x+195
					&&b.y>y-b.height&&b.y<y+20){
					n = Math.random() * 2 + 2;
				}
				//小球掉落，生命减1，游戏重新开始
				if(b.y>662-46){
					life--;
					x = 552 / 2 - 195 / 2;
					y = 622;
					b.x = 552 / 2 - 46 / 2;
					b.y = 622 - 46;
					n = -1*n;
					m = -1*m;
				}
				//生命为0，gameover
				if(life<=0){
					ctx.drawImage(gameOver,-5,663/2-211/2);
					setTimeout(function(){
						clearInterval(s);//停止计时
					},1);
				}
				//砖块数量为0，游戏通关
				if(zks.length==0){
					ctx.drawImage(success,20,663/2-231/2);
					setTimeout(function(){
						clearInterval(s);//停止计时
					},1);
				}
				
				
			}
			
			//浏览器坐标转换为画布坐标
			//浏览器坐标y轴越往上越大，
			//画布的是越往下越大。
			function getPointOnCanvas(x, y) {
				var box = canvas.getBoundingClientRect();
				return {
					x : x - box.left,
					y : y - box.top
				}
			}

			//鼠标移动事件
			canvas.onmousemove = function(e) {
				var point = getPointOnCanvas(e.x, e.y);
				x = point.x - 195 / 2;
				if (point.x + 195 / 2 >= 522) {
					x = 522 - 195;
				}
				if (point.x - 195 / 2 <= 30) {
					x = 30;
				}
			}

		</script>
	</body>
</html>