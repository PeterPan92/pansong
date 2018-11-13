$(document).ready(function(){
	//初始化dom结构
	initDom();
	
	//初始化页面中的颜色
	initColors();
	
	//初始化网站中接入的代码
	initWebsitecode();
	
});

//初始化DOM结构
function initDom(){
	$('.left-menu>.submenu>li').removeClass('active');
	$('#website-service').addClass('active');
	$('#website-service').addClass('submenu-active');
	$('#website-service').parents('.submenu').prev('.parent-catalog').addClass('menu-active');
	$('#website-service').parents('.submenu').prev('.parent-catalog').children('div').addClass('image-active');
}

function initColors(){
	
	$("#color-input-diy").spectrum({
		color: "red",//初始化颜色
		showInput: true,//显示输入
//		allowEmpty:true,//允许为空,显示清楚颜色按钮
		clickoutFiresChange: false,//单击选择器外部,如果颜色有改变则应用
		containerClassName: "full-spectrum",
		showInitial: true,//显示初始颜色,提供现在选择的颜色和初始颜色对比
		showPalette: true,//显示选择器面板
		showSelectionPalette: true,//记住选择过的颜色
		showAlpha: true,//显示透明度选择
		maxPaletteSize: 7,//记住选择过的颜色的最大数量
		cancelText: "取消",//取消按钮,按钮文字
		chooseText: "确定",//选择按钮,按钮文字
		noColorSelectedText: "无颜色选择",//清除,按钮文字
		preferredFormat: "hex",//输入框颜色格式,(hex十六进制,hex3十六进制可以的话只显示3位,hsl,rgb三原色,name英文名显示)
		localStorageKey: "spectrum.demo",//把选择过的颜色存在浏览器上
		
		//选择器右边面板移动时触发
		move: function (color) {
			updateBorders(color);
		},
		//选择器面板显示时触发
		show: function () {
	
		},
		//选择器面板显示之前触发,返回false时不显示
		beforeShow: function () {

		},
		//关闭面板或点击选择按钮,颜色变化时触发
		change:function(){
			
		},
		//选择器面板隐藏时触发
		hide: function (color) {
			updateBorders(color);
		},
		//调色选择器面板显示的颜色
		palette: [
		      ["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)", "rgb(153, 153, 153)","rgb(183, 183, 183)",
		      "rgb(204, 204, 204)", "rgb(217, 217, 217)", "rgb(239, 239, 239)", "rgb(243, 243, 243)", "rgb(255, 255, 255)"],
		      ["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
		      "rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"],
		      ["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)",
		      "rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)"],
		      ["rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)",
		      "rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)"],
		      ["rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)",
		      "rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)"],
		      ["rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
		      "rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)"],
		      ["rgb(133, 32, 12)", "rgb(153, 0, 0)", "rgb(180, 95, 6)", "rgb(191, 144, 0)", "rgb(56, 118, 29)",
		      "rgb(19, 79, 92)", "rgb(17, 85, 204)", "rgb(11, 83, 148)", "rgb(53, 28, 117)", "rgb(116, 27, 71)"],
		      ["rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)",
		      "rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
		     ]
		
	});
     function updateBorders(color) {
		var hexColor = "transparent";
		if(color) {
		hexColor = color.toHexString();
		}
		$("#docs-content").css("border-color", hexColor);
		$('#color-input-diy-value').val(hexColor);
	}
}

//设置调色板的颜色值
function setPalette(){
	var colorValue=$("#color-input-diy-value").val();
	 if(colorValue.indexOf('#')==0&&colorValue.length==7){
		 $("#color-input-diy").spectrum("set", $("#color-input-diy-value").val());
	 }else if(colorValue==null||colorValue.length==0){
		 return;
	 }else{
		 alert("请输入正确的色值");
	 }
}

//取消掉所有选择的颜色
function cancelChooseColor( clickId ){
	var inputColor = $('#color-input-green').parents(".chat-windows-color-div ").find("input");
	for(var i=0;i<inputColor.length;i++){
		inputColor[i].checked=false;
	}
	//选中点击的元素
	$(clickId)[0].checked=true;
	//获取选中元素的color值
	var color =$(clickId).val();
	$("#color-input-diy").spectrum("set", color);
	$('#color-input-diy-value').val(color);
}
$(document).on("click","#color-input-red",function(){
	cancelChooseColor("#color-input-red");
})
$(document).on("click","#color-input-orange",function(){
	cancelChooseColor("#color-input-orange");
})
$(document).on("click","#color-input-yellow",function(){
	cancelChooseColor("#color-input-yellow");
})
$(document).on("click","#color-input-green",function(){
	cancelChooseColor("#color-input-green");
})
$(document).on("click","#color-input-blue",function(){
	cancelChooseColor("#color-input-blue");
})
$(document).on("click","#color-input-purple",function(){
	cancelChooseColor("#color-input-purple");
})

//统计text框中字数的多少
$(document).on('input propertychange','.diy-chat-welcome-textarea',function(){
	var text=$('.diy-chat-welcome-textarea').val();
	if(text.length>500){
		$('.diy-chat-welcome-textarea').val(text.substring(0,500));
	}
	var count =500-text.length;
	if(count>=0){
		$('.diy-chat-welcome-last-text').val("还可以输入"+count+"个字");
	}else{
		$('.diy-chat-welcome-last-text').val("还可以输入"+0+"个字");
	}
	
})

//初始化网站中接入的代码
function initWebsitecode(){

	$.ajax({
		 url : context + "/bj/back/website",
		 type:'get',
		 success : function(data){
			 if(data!=null){
				 var websiteCode =$('.insert-code-content-span').text();
				 //替换href内容
				 websiteCode = websiteCode.replace('getHref',data.url+'service/bot/page/ask?'+'uid='+data.userId);
				 //替换src内容
				 websiteCode = websiteCode.replace('getSrc',data.url+'skins/skin/qa/img/ask.png');
				 $('.insert-code-content-span').text(websiteCode);
			 }
		 },
		 error:function(data){}
	})
	
}



