"use strict";

function ripple(elm) {
  elm.addClass("active");
  setTimeout(() => {
    elm.removeClass("active");
  }, 300);
}

$("#logCloseBtn").click(function () {
  ripple($(this));
  setTimeout(() => {
    $("#logPanel").removeClass("active");
  }, 200);
});

$("#logOpenBtn").click(function () {
  ripple($(this));
  setTimeout(() => {
    $("#logPanel").addClass("active");
  }, 200);
});

$("#restartBtn").click(function () {
  ripple($(this));
  setTimeout(() => {
    window.location.pathname = "/minigames/hitblow";
  }, 200);
});

$("#homeBtn").click(function () {
  ripple($(this));
  setTimeout(() => {
    window.location.pathname = "/minigames";
  }, 200);
});