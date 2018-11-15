<%--
  Created by IntelliJ IDEA.
  User: panxinbing
  Date: 2018/4/26
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="gb2312">
    <title>我们的故事</title>
    <meta name="Keywords" content="你和我" >
    <meta name="Description" content="Just for you" >
    <link href="<%=request.getContextPath()%>/skins/skin/bj/css/index.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="<%=request.getContextPath()%>/skins/js/bj/modernizr.js"></script>
    <![endif]-->
</head>
<body>
<header>
    <div class="quotes">
        <p>初遇时，她的微笑，她往日的深情、承诺和傻劲，两个人共度的美丽时刻，一一印在回忆里，今天的感情已经比不上从前，但是我爱着恋着往日的她，舍不得离开。</p>
        <div class="text5">记录・回忆</div>
        <div class="flower"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/flower.jpg"></div>
    </div>
    <!--nav begin-->
    <div id="nav">
        <ul>
            <li><a href="/">首页</a></li>
            <li><a href="<%=request.getContextPath()%>/jsp/plugs/3dpicture.jsp">关于我们</a></li>
            <li><a href="<%=request.getContextPath()%>/jsp/plugs/musicDinamic.jsp">碎言碎语</a></li>
            <li><a href="<%=request.getContextPath()%>/jsp/plugs/dzkgame.jsp">慢生活</a></li>
            <li><a href="<%=request.getContextPath()%>/jsp/plugs/3dflower.jsp">前世今生</a></li>
            <li><a href="<%=request.getContextPath()%>/jsp/plugs/earth.jsp">永无止境</a></li>
            <li><a href="<%=request.getContextPath()%>/jsp/bj/login.jsp">留言板</a></li>
            <li><a href="http://mail.panxinbing.com/" target="_blank">邮箱</a></li>
        </ul>
    </div>
    <!--nav end-->
</header>
<div class="photowall">
    <ul class="wall_a">
        <li><a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/p01.jpg">
            <figcaption>
                <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
            </figcaption>
        </a></li>
        <li><a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/p02.jpg">
            <figcaption>
                <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
            </figcaption>
        </a></li>
        <li><a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/p03.jpg">
            <figcaption>
                <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
            </figcaption>
        </a></li>
        <li>
            <p class="text_a"><a href="/">一个人最好的模样大概是平静一点，坦然接受自己所有的弱点，不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏......</a></p>
        </li>
        <li><a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/p04.jpg">
            <figcaption>
                <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
            </figcaption>
        </a></li>
        <li>
            <p class="text_b"><a href="/">逃避自己的人，最终只能导致自己世界的崩塌，而变得越来越没有安全感。</a></p>
        </li>
        <li><a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/p05.jpg">
            <figcaption>
                <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
            </figcaption>
        </a></li>
        <li><a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/together2.jpg">
            <figcaption>
                <h2>不再因为别人过得好而焦虑，在没有人看得到你的时候依旧能保持节奏 </h2>
            </figcaption>
        </a></li>
    </ul>
</div>
<div class="about">
    <ul>
        <div id="fountainG">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </div>
        <div class="about_girl"><span><a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/gril.jpg"></a></span>
            <p>初遇时，他的幽默，他往日的深情、承诺和傻劲儿，两个人共度的美丽时刻，一一印在我的回忆里....</p>
        </div>
        <div class="about_boy"><span><a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/boy.jpg"></a></span>
            <p>初遇时，她的热情，她腼腆的微笑、可爱和气质，两个人共度的愉快时刻，一一印在我的回忆里...</p>
        </div>
    </ul>
</div>
<div class="blank"></div>
<div class="blog">
    <figure> <a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/noodle.jpg"></a>
        <p><a href="/">愿有人陪你一起颠沛流离</a></p>
        <figcaption>有一天晚上我收到朋友的邮件，他问我怎样可以最快地摆脱寂寞，我想了想不知道应该怎么回答他，因为我从来没有摆脱过这个问题，我只能去习惯它，就像习惯身体的一部分。</figcaption>
    </figure>
    <figure> <a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/flowerp.jpg"></a>
        <p><a href="/">你要去相信，没有到不了的明天</a></p>
        <figcaption>不管你现在是一个人走在异乡的街道上始终没有找到一丝归属感，还是你在跟朋友们一起吃饭开心地笑着的时候闪过一丝落寞。</figcaption>
    </figure>
    <figure> <a href="/"><img src="<%=request.getContextPath()%>/skins/skin/bj/img/hand300x256.jpg"></a>
        <p><a href="/">美丽的茧</a></p>
        <figcaption>让世界拥有它的脚步，让我保有我的茧。当溃烂已极的心灵再不想做一丝一毫的思索时，就让我静静回到我的茧内，以回忆为睡榻，以悲哀为覆被，这是我唯一的美丽。</figcaption>
    </figure>
</div>
<div class="blank"></div>
<div class="text6">相守・祝福</div>
<div class="hope">
    <ul>
        <div class="visitors">
            <dl>
                <dt><img src="<%=request.getContextPath()%>/skins/skin/bj/img/s6.jpg"> </dt>
                <dd><a href="/">DanceSmile</a> </dd>
                <dd>你们本就是天生一对，地造一双，而今共偕连理，今后更需彼此宽容、互相照顾，祝福你们！</dd>
            </dl>
            <dl>
                <dt><img src="<%=request.getContextPath()%>/skins/skin/bj/img/s7.jpg"> </dt>
                <dd><a href="/">骄傲的小甜甜</a> </dd>
                <dd>十年修得同船渡，百年修得共枕眠。于茫茫人海中找到她，分明是千年前的一段缘，祝你俩幸福美满，共谐连理。</dd>
            </dl>
            <dl>
                <dt><img src="<%=request.getContextPath()%>/skins/skin/bj/img/s8.jpg"> </dt>
                <dd><a href="/">执子之手</a> </dd>
                <dd>托清风捎去衷心的祝福，让流云奉上真挚的情意；今夕何夕，空气里都充满了醉人的甜蜜。谨祝我最亲爱的朋友，从今后，爱河永浴！</dd>
            </dl>
        </div>
    </ul>
</div>
<footer>
    <p>Design by <a href="/" target="_blank">DanceSmile</a></p>
</footer>
</body>
</html>
