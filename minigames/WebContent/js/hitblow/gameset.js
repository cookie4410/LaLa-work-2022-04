$("#userResult .resultHeader h2").on("animationstart", function () {
	setTimeout(function () {
		$("#userResult, #comResult").toggleClass("active");
	}, 8000);
	setTimeout(function () {
		$("#comResult, #gameResult").toggleClass("active");
	}, 16000);
	setTimeout(function () {
		$("#resultPanel, #gamesetPanel").toggleClass("active");
	}, 24000);
});

$("#durationTime .popup span").on("animationend", function () {
	setTimeout(function () {
		$("#buttons").addClass("active");
	}, 750);
})