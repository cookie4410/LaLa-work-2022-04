"use strict";

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
