var change= document.getElementById("change-btn");
change.onclick=function () {
    if(ifChange==0) {
        ifChange=1,change.innerText="多个组合对比";
        cleanFun();
    }
    else {
        ifChange = 0, change.innerText = "单个组合观察";
        cleanFun();
    }
}