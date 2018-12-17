/**
 * Created by panxinbing on 2018/11/22.
 */
window.onload = function(){
    playMusic(musicList);
}
function playMusic(musicList){
    var div1=document.createElement("div");
    div1.id="audioBox";
    document.body.appendChild(div1);
    var myAudio = new Audio();
    myAudio.preload = false;
    myAudio.controls = true;
    myAudio.hidden = true;
    var src = musicList.pop();
    myAudio.src =context + src;
    musicList.unshift(src);
    myAudio.addEventListener("ended",playEndedHandler,false);
    myAudio.play();
    document.getElementById("audioBox").appendChild(myAudio);
    myAudio.loop = false;
    function playEndedHandler(){
        src = musicList.pop();
        myAudio.src =context+ src;
        musicList.unshift(src);
        myAudio.play();
    }
}
