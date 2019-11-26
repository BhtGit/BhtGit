// w=87 q=81 a=65
// 要点击的刷新按钮
var elementId = "bhttest";
// 刷新时间
var refershTime = 10000;
var interval = -1;
// 按W开启自动刷新
$(document).keydown(function(event){
    if(event.keyCode == 87 && interval == -1){
        interval = setInterval(() => {
    　　    document.getElementById(elementId).click(); 
        }, refershTime);
    }
});

// 按Q关闭自动刷新
$(document).keydown(function(event){
    if(event.keyCode == 81){
        clearInterval(interval);
        interval = 123;
    }
});

// 按A手动刷新
$(document).keydown(function(event){
    if(event.keyCode == 65){
        document.getElementById(elementId).click(); 
    }
});
