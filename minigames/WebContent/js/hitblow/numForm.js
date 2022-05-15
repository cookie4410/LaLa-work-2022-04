"use strict";

// 入力済パネルセッティング
$(".ansPanel").click(function () {
  if (
    $(this).text() !== "" ||
    $(this).prev().text() !== "" ||
    $(this).next().text() !== "" ||
    $(this).next().next().text() !== ""
  ) {
    moveSelectedId($(this));
  }
});

// 数字パネルセッティング
$(".numPanel").click(function () {
  ripple($(this));

  const panels = $(".ansPanel:not(#selected)");
  const [x, y, z] = panels.text();
  const current = $("#selected");
  let isFilled = false;
  if (!current.length) {
    isFilled = true;
    panels.each(function () {
      if ($(this).text === "") {
        isFilled = false;
        return false;
      }
    });
  }
  if (
    isFilled ||
    $(this).text() === x ||
    $(this).text() === y ||
    $(this).text() === z
  ) {
    // エラー時の処理
    errorAnime();
  } else {
    current.text($(this).text());
    let result = true;
    current.siblings().each(function () {
      if ($(this).text() === "") {
        moveSelectedId($(this));
        result = false;
        return false;
      }
    });
    if (result) {
      current.removeAttr("id");
    }
  }
});

function errorAnime() {
  $("#numFormWrapper").addClass("error");
  setTimeout(() => {
    $("#numFormWrapper").removeClass("error");
  }, 300);
}

// バックスペース
$("#backspaceBtn").click(function () {
  ripple($(this));
  const selected = $("#selected");
  const panels = $(".ansPanel");
  if (selected.text() !== "") {
    selected.text("");
    if (panels.eq(0).text() === "") {
      moveSelectedId(panels.eq(0));
    } else if (panels.eq(1).text() === "") {
      moveSelectedId(panels.eq(1));
    } else if (panels.eq(2).text() === "") {
      moveSelectedId(panels.eq(2));
    }
  } else {
    const [x, y, z] = panels.text();
    if (typeof z === "undefined") {
      if (typeof y === "undefined") {
        if (typeof x === "undefined") {
          errorAnime();
          return;
        } else {
          moveSelectedId(panels.eq(0)).text("");
        }
      } else {
        moveSelectedId(panels.eq(1)).text("");
      }
    } else {
      moveSelectedId(panels.eq(2)).text("");
    }
  }
});

function moveSelectedId(target) {
  $("#selected").removeAttr("id");
  return target.attr("id", "selected");
}

// 送信ボタン
$("#submitBtn").click(function () {
  ripple($(this));
});

// 送信チェック
function checkSubmit() {
  const panels = $(".ansPanel");
  let isFilled = true;
  panels.each(function () {
    if ($(this).text() === "") {
      isFilled = false;
    }
  });
  if (!isFilled) {
    errorAnime();
    return false;
  }
  $("#numInput").val(panels.text());
  return true;
}
