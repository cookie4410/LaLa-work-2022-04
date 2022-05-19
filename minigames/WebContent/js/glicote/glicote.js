"use strict";

$(function(){
	userStep += 5;
    let item_num = $(".station").length;
    let deg = 360.0/item_num;
    let red = (deg*Math.PI/180.0);
    let circle_r = $(".station").width() * 8;
    $(".station").each(function(i, elem) {
        let x = Math.cos(red * i) * circle_r + circle_r;
        let y = Math.sin(red * i) * circle_r + circle_r;
        $(elem).css("left", x);
        $(elem).css("top", y);
        if(i == userStep){
			if(i == comStep){
				$(elem).css("background-color", "#9c27b0");
			} else {
				$(elem).css("background-color", "#2196f3");
			}
		} else if (i == comStep) {
			$(elem).css("background-color", "#e91e63");
		}
    });
});

$("#hands i").click(function(){
	let send_data = new XMLHttpRequest();
	send_data.open("POST", path);
	send_data.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	send_data.send("hand=" + $(this).attr("id"));
})