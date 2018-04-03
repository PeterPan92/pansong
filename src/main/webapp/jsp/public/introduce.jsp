<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/tags/loushang-web" prefix="l"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<l:asset path='jquery.js'/>"></script>
<script type="text/javascript" src="<l:asset path='form.js'/>"></script>

<link rel="stylesheet" type="text/css" href="<l:asset path='css/form.css'/>" />
<link rel="stylesheet" type="text/css"href="<l:asset path='platform/css/home.css'/>" />
<title>产品介绍</title>
</head>
<body>
	<div id="fullpage">
		<div class="section framework">
			<div class="headline">
				<label class="title">框架</label>
				<label class="subtitle">组件多、开发快、体验好、架构优、稳定强的轻应用开发运行底层支撑平台</label>
			</div>
			<div>
				<img class="intro" src="<l:assetcontext/>/skins/skin/platform/img/intro_framework.png">
			</div>
		</div>
		<div class="section bsp">
			<div class="headline">
				<label class="title">BSP</label>
				<label class="subtitle">开箱即用的公共技术组件，高度柔性的通用业务模型，灵活应对互联网、企业、政府应用</label>
			</div>
			<div>
				<img class="intro" src="<l:assetcontext/>/skins/skin/platform/img/intro_bsp.png">
			</div>
		</div>
		<div class="section bpm">
			<div class="headline">
				<label class="title">BPM</label>
				<label class="subtitle">一体化全生命周期业务流程管理：流程建模、流程开发、流程运行、流程监控分析</label>
			</div>
			<div>
				<img class="intro" src="<l:assetcontext/>/skins/skin/platform/img/intro_bpm.png">
			</div>
		</div>
		<div class="section cform">
			<div class="headline">
				<label class="title">云表单</label>
				<label class="subtitle">灵活扩展、简单实用、操作高效、所见即所得的在线表单设计器</label>
			</div>
			<div>
				<img class="intro" src="<l:assetcontext/>/skins/skin/platform/img/intro_cform.png">
			</div>
		</div>
		<div class="section cportal">
			<div class="headline">
				<label class="title">云门户</label>
				<label class="subtitle">简单易用、快速高效、体验卓越、安全可靠的轻量级企业门户解决方案</label>
			</div>
			<div>
				<img class="intro" src="<l:assetcontext/>/skins/skin/platform/img/intro_cportal.png">
			</div>
		</div>
		<div class="section hsf">
			<div class="headline">
				<label class="title">HSF</label>
				<label class="subtitle">应用前后端分离、应用间高效通信的轻量级服务化解决方案</label>
			</div>
			<div>
				<img class="intro" src="<l:assetcontext/>/skins/skin/platform/img/intro_hsf.png">
			</div>
		</div>
		<div class="section alm">
			<div class="headline">
				<label class="title">ALM</label>
				<label class="subtitle">提升开发效率、管控研发流程、保证软件质量、持续集成发布的软件开发生命周期管理产品</label>
			</div>
			<div>
				<img class="intro" src="<l:assetcontext/>/skins/skin/platform/img/intro_alm.png">
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$("#fullpage").fullpage({
			navigation: true,
			navigationPosition: 'right',
			anchors:["框架","BSP","BPM","云表单","云门户","HSF","ALM"],
			afterLoad:function(anchorLink,index){
				var label = '<label class="tip">'+anchorLink+'</label>'
				$("li:eq("+(index-1)+")").append(label)
			},
			onLeave:function(index){
				$("li:eq("+(index-1)+")").find("label").remove();
			}
		});
	})
	</script>
</body>
</html>