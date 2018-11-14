<%--
  Created by IntelliJ IDEA.
  User: panxinbing
  Date: 2018/11/14
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Clay - A 3D engine on canvas</title>

    <script type="text/javascript" src="<%=request.getContextPath()%>/skins/js/plugs/clay.min.js"></script>
    <script>
        var contextGlobal = "<%=request.getContextPath()%>"
    </script>


    <script type="text/javascript">

        function Earth() {

            var stage = new Clay.Stage(800, 600);
            var world = stage.getWorld();
            var camera = stage.getCamera();

            camera.set(0,0,0);
            camera.setResolution(800, 600);
            camera.setTarget(new Clay.Vector(-100,0,100));

            window.onresize = function() {
                stage.resizeTo(
                    window.innerWidth || document.documentElement.clientWidth,
                    window.innerHeight || document.documentElement.clientHeight
                );
            };

            window.onresize();

            Clay.Collada.load(contextGlobal+'/skins/skin/bj/img/earth/earth.xml', function(scene) {
                scene.init(stage);

                var earth = new Clay.Texture(contextGlobal+'/skins/skin/bj/img/earth/earthmap1k.jpg', stage);

                var clouds = new Image();
                clouds.src = contextGlobal+'/skins/skin/bj/img/earth/earthclouds1k.png';

                var dark = new Image();
                dark.src = contextGlobal+'/skins/skin/bj/img/earth/darkside.png';

                var waiting = setInterval(function(){
                    if (earth.complete && clouds.complete && dark.complete){
                        clearInterval(waiting);
                        play();
                    }
                }, 1000);

                function play() {
                    var shape = world.getShapes()[0];
                    shape.setMaterial(earth);

                    var x, y, z, t = Math.PI/4, r = 0, tick = 0.01, radius = 200;
                    var ttx = earth.canvas.getContext('2d');
                    var base = earth.image;
                    var wind = 0;

                    stage.addEvent('enterframe', function(){

                        ttx.drawImage(base, 0,0);
                        var pos = (++wind)%1000;
                        ttx.drawImage(clouds, pos, 0);
                        ttx.drawImage(clouds, pos-1000, 0);
                        ttx.drawImage(dark, 0,0);

                        t += tick;
                        x = -100 + Math.sin(t) * radius;
                        z = 100 + Math.cos(t) * radius;
                        y = Math.cos(t/3) * 50
                        camera.set(x, y, z);
                    });

                    stage.run();
                }
            });
        }

        window.addEventListener('load', function(){
            new Earth();
        }, false);


    </script>

    <style type="text/css">
        html,body {
            width:100%;
            height:100%;
            margin:0;
            padding:0;
            position:relative;
            background:black;
        }

        .canvas3D {
            background:black;
            position:absolute;
            left:0;
            top:0;
        }

    </style>

</head>
<body>

<div id="canvas">
    <!-- canvas, centered on screen  -->

</div>


</body>

</html>
