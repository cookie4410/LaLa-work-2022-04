"use strict";

$("#userResult .resultHeader h2").on("animationstart", function () {
  $("#numFormWrapper").removeClass("active")
  setTimeout(function () {
    $("#userResult, #comResult").toggleClass("active");
  }, 8000);
  setTimeout(function () {
    $("#comResult").css("transition", "all .4s");
    $("#comResult, #numFormWrapper").toggleClass("active");
  }, 16000);
});

$("#startMes .resultHeader h2").on("animationstart", function () {
  $("#numFormWrapper").removeClass("active")
  setTimeout(function () {
    $("#startMes").css("transition", "all .4s");
    $("#startMes, #numFormWrapper").toggleClass("active");
  }, 3000);
});
