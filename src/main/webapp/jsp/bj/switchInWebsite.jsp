<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
	<title>网站接入</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<!-- 需要应用的css -->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/skins/skin/bj/css/switchInWebsite.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/skins/skin/bj/css/spectrum.css"/>
	<!-- 需要引用的js -->
    <script type="text/javascript">
        var context="<%=request.getContextPath()%>";
    </script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/skins/js/bj/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/skins/js/bj/spectrum.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/skins/js/bj/switchInWebsite.js"></script>

</head>
<body class="body-style">
    <div class=" container-fluid margin-size">
	   
	    <!-- 标头 -->
	    <div class="title-name-div">
	        <span class='tltle-name-span'>接入桌面网站</span>
	    </div>  
	    
	    <!-- 网站中嵌入代码 -->
        <div class="insert-code-div">
            <span class="insert-code-span">在网站中嵌入代码</span>
        </div>
        <div class="insert-code-content-div"> 
            <span class="insert-code-content-span">
                &lt;style>a.__cl_weblink{position:fixed;bottom:10px;right:20px;display:inlin-block}&lt;/style>&lt;a class='__cl_weblink' href='getHref' target='_blank'>&lt;img src='getSrc'>&lt;/img></a>
            </span>
            
        </div>
        <div class="insert-code-tip-div">
             <p class="insert-code-tip-p">* 提示： 手动复制上面的代码并添加到网页中，请将代码置于&lt;/body>标签之前。</p>
           <!--  <p class="insert-code-tip-p" style="display: none;" >* 或者直接使用下面的地址： http://u.cn/crttpcneadsf</p>   --> 
             
        </div>
        
        <!-- 选择客服按钮位置 -->
        <div class="insert-code-div " >
            <span class="insert-code-span">选择客服按钮位置</span>
        </div>
        <div class="chat-button-location-div row" >
            <div class="col-xs-7 col-sm-7 col-md-7">
                <div class="col-xs-3 col-sm-3 col-md-3">
                    <input class="chat-button-location-radio-input" type="radio" name="ra" value="right-bottom" />右下角
                 </div>
                 <div class="col-xs-3 col-sm-3 col-md-3">
                    <input class="chat-button-location-radio-input" type="radio" name="ra" value="left-bottom" />左下角
                 </div>
                 <div class="col-xs-3 col-sm-3 col-md-3">
                    <input class="chat-button-location-radio-input" type="radio" name="ra" value="right-top" />右上角
                 </div>
                 <div class="col-xs-3 col-sm-3 col-md-3">
                     <input class="chat-button-location-radio-input" type="radio" name="ra" value="right-top" />左上角
                 </div>
             </div>
        </div>
        
        
        <!-- 自定义聊天窗颜色 -->
        <div class="insert-code-div" >
            <span class="insert-code-span">自定义聊天窗颜色</span>
        </div>

        <div class="chat-windows-color-div row"  >
            <div class="col-xs-4 col-sm-4 col-md-4">
                <div class="col-xs-2 col-sm-2 col-md-2">
                    <input id="color-input-red" class="chat-button-location-radio-input" type="checkbox" name="color-input-red" value="#f0544d" />
                    <label  for="color-input-red"></label >
                 </div>
                 <div class="col-xs-2 col-sm-2 col-md-2">
                    <input id="color-input-orange" class="chat-button-location-radio-input" type="checkbox" name="color-input-orange" value="#ea9836" />
                     <label  for="color-input-orange"></label >
                 </div>

                 <div class="col-xs-2 col-sm-2 col-md-2">
                    <input id="color-input-yellow" class="chat-button-location-radio-input" type="checkbox" name="color-input-yellow" value="#e6c03a" />
                     <label  for="color-input-yellow"></label >
                 </div>
                 <div class="col-xs-2 col-sm-2 col-md-2">
                     <input id="color-input-green" class="chat-button-location-radio-input" type="checkbox" name="color-input-green" value="#5fbd41" />
                      <label  for="color-input-green"></label >
                 </div>
                 <div class="col-xs-2 col-sm-2 col-md-2">
                    <input id="color-input-blue" class="chat-button-location-radio-input" type="checkbox" name="color-input-blue" value="#3daae6" />
                     <label  for="color-input-blue"></label >
                 </div>
                 <div class="col-xs-2 col-sm-2 col-md-2">
                     <input id ="color-input-purple" class="chat-button-location-radio-input" type="checkbox" name="color-input-purple" value="#c37ad3" />
                     <label for="color-input-purple"></label>
                 </div>
             </div>
        </div>
        
        <!-- 调色板-->
        <div class="chat-windows-color-diy-div row"  >
            <div class="col-xs-5 col-sm-5 col-md-5">
	            <div class="col-xs-2 col-sm-2 col-md-2 diy-color-choose">
	                 <input id="color-input-diy"  name="color-input-diy"> 
	               <!--  <label for="color-input-diy"></label>   --> 
	            </div>
	            <div class="col-xs-4 col-sm-4 col-md-4 diy-color-value-div">
	                <span class="diy-color-value-span"> 自定义色值：</span>
	            </div>
	            <div class="col-xs-5 col-sm-5 col-md-5 diy-color-style">
	                <input id="color-input-diy-value" class="diy-color-style-input" onblur="setPalette()" type="text" name="color"> 
	            </div>
            </div>
        </div>
        
        <!-- 自定义聊天窗 -->
        <div class="insert-code-div"  >
            <span class="insert-code-span">自定义聊天窗</span>
        </div>
        
        <div class="diy-chat-windows-div row diy-chat-windows-div"  >
            <div class="col-xs-2 col-sm-2 col-md-2 diy-chat-title-div">
                <span class="diy-chat-title-span">标题:</span>
            </div>
            <div class="col-xs-6 col-sm-6 col-md-6 diy-chat-title-indiv">
                <input class="diy-chat-title-input" type="text" name="diyChatTitle" placeholder="客服在线沟通" value="" >
            </div>
        </div>
        
        <div class="diy-chat-windows-div "  >
            <div class=row>
	            <div class="col-xs-2 col-sm-2 col-md-2 diy-chat-title-div">
	                <span class="diy-chat-title-span">欢迎语:</span>
	            </div>
	            <div class="col-xs-6 col-sm-6 col-md-6">
	                <textarea name="" class="diy-chat-welcome-textarea" cols="55" rows="6" maxlength="500" placeholder="最多可输入500字"> 您好，很高兴为您服务。</textarea>
	            </div>
            </div>
            <div class=row>
                <div class="col-xs-6 col-sm-6 col-md-6 col-xs-offset-2 col-sm-offset-2 col-md-offset-2 diy-chat-welcome-last-text-div">
                    <textarea name="" class=" diy-chat-welcome-last-text" cols="55" rows="1" readonly="readonly" maxlength="500" placeholder="最多可输入500字"> 还可以输入490个字</textarea>                                 
                </div>
            </div>
        </div>
        <div class="row diy-chat-windows-welcom-div"  >
             
        </div>
        
        
        <div class="btn-group save-button"  >
             <button type="button" class="btn  btn-primary">保存</button>
        </div>

    </div>

</body>
</html>