$(document).ready(function(){
    var $div_li = $('#jcSide li a')
    $('#jcSide li a').click(function () {
        var index = $div_li.index(this);
        $(this).parent().addClass("select").siblings().removeClass("select");
        $("#jcContent div").eq(index).show().siblings().hide();
    })
});
$(document).ready(function(){
    $('#jcSide').mouseenter(function(){
        $('#jcSide').stop(true, false).animate({"left": 0}, 300);
    });
});
$(document).ready(function(){
    $('#jcSide').mouseleave(function(){
        $('#jcSide').stop(true, false).animate({"left": -210}, 300);
    });
});/**
 * Created by goufaning on 2016/11/17.
 */
