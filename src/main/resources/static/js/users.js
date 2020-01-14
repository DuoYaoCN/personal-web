var target = null;
var allSec = null;
var isCa = false;
var errorNum = 0;
function getTargetTime() {
    //ajax请求服务器获取目标时间
    $.ajax({
        url:"/time",
        dataType: "JSON",
        type:"GET",
        success:function(result) {
            target = result;
        },
        error:function(params) {
            errorNum++;
            if(errorNum>=10){
               // alert("服务器开小差了，请等待站长修复。。。")
                window.location.replace('/404');
            }
        }
    });
    return target;
}

function getRemainTime(){
    if(target == null){
        getTargetTime();
        $("#circle").addClass("circle");
    }
    else{
        if(!isCa){
            allSec = target.second + 60 * target.minute + 60 * 60 * target.hour + 60 * 60 * 24 * target.day;
            isCa = true;
        }
        SetRemainTime();
    }
}
function formatZero(num, len) {
    if(String(num).length > len) return num;
    return (Array(len).join(0) + num).slice(-len);
}
function SetRemainTime() {
    allSec--;
    $("#day").html(formatZero(Math.floor((allSec / 3600) / 24), 3));
    $("#hour").html(formatZero(Math.floor((allSec / 3600) % 24), 2));
    $("#min").html(formatZero(Math.floor((allSec / 60) % 60), 2));
    $("#sec").html(formatZero(Math.floor(allSec % 60), 2));
    $("#clock").removeClass("clock");
    $("#circle").removeClass("circle");
}

self.setInterval(getRemainTime, 1000);

function SendEmail() {
    //ajax请求服务器获取目标时间
    var username = $("#name").val();
    var address = $("#email").val();
    var domain = $("#subject").val();
    var summary = $("#message").val();
    console.log(username)
    $.ajax({
        url:"/mail/" + username + "/" + address + "/" + domain + "/" + summary,
        type:"GET",
        success:function(){
          alert("发送成功！");
        },
        error:function(params) {
            alert("发送失败");
        }
    });
    return target;
}