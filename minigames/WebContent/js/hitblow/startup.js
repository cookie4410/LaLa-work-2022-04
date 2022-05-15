"use strict";

// レベル選択
$(".levelBtn").click(function () {
  ripple($(this));
  setTimeout(() => {
    $("#levelInput").val($(this).text());
    $("#levelFormWrapper, #numFormWrapper").toggleClass("active");
  }, 200);
});

// レベル選択に戻る
$("#changeLevelBtn").click(function () {
  ripple($(this));
  setTimeout(() => {
    $("#levelFormWrapper, #numFormWrapper").toggleClass("active");
  }, 200);
});
