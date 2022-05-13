"use strict";

// レベル選択
$(".levelBtn").click(function () {
	$("#levelInput").val($(this).text());
	$("#levelFormWrapper, #numFormWrapper").toggleClass("active");
});

// 入力済パネルセッティング
$(".ansPanel").click(function () {
	if ($(this).text() !== "" || $(this).prev().text() !== "") {
		moveSelectedId($(this));
	}
})

// 数字パネルセッティング
$(".numPanel").click(function () {
	ripple($(this));

	const panels = $(".ansPanel:not(#selected)");
	const [num1, num2] = panels.text()
	const current = $("#selected");
	if ($(this).text() === num1 || $(this).text() === num2) {
		// エラー時の処理
	} else {
		current.text($(this).text());
		moveSelectedId(current.next());
	}
});

function ripple(elm) {
	elm.addClass("active");
	setTimeout(() => {
		elm.removeClass('active');
	}, 300);
}

// バックスペース
$("#backspaceBtn").click(function () {
	const panels = $(".ansPanel");
	const [x, y, z] = panels.text();
	if (typeof z === "undefined") {
		if (typeof y === "undefined") {
			if (typeof x === "undefined") {
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
});

function moveSelectedId(target) {
	$("#selected").removeAttr("id");
	return target.attr("id", "selected");
}

// 送信チェック
function checkSubmit() {
	const panels = $(".ansPanel");
	let isFilled = true;
	panels.each(function () {
		if ($(this).text() === "") {
			isFilled = false;
		}
	});
	if (!isFilled) { return false; }
	$("#numInput").val(panels.text());
	return true;
}

// レベル選択に戻る
$("#changeLevelBtn").click(function () {
	$("#levelFormWrapper, #numFormWrapper").toggleClass("active");
});








// function check() {
// 	const numInput = document.getElementById("numInput");
// 	const PATTERN = /^\d{3}$/u;
// 	let num = numInput.value;
// 	let isError = false;
// 	if (num.length >= 3) {
// 		if (PATTERN.test(num)) {
// 			num = Number(num);
// 			let x = Math.floor(num / 100);
// 			let y = Math.floor((num % 100) / 10);
// 			let z = num % 10;
// 			isError = (x === y || x === z || y === z);
// 		} else {
// 			isError = true;
// 		}
// 	} else {
// 		isError = true;
// 	}
// 	document.getElementById("ngMes").innerText = isError ? "入力が無効です。\n三桁の異なる数字を入力してください。" : "";
// 	return !isError;
// }
