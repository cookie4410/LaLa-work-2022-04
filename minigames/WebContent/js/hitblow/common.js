"use strict";

function ripple(elm) {
  elm.addClass("active");
  setTimeout(() => {
    elm.removeClass("active");
  }, 300);
}
