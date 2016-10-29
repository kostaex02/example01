<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
BODY {
margin-left:0px;
margin-top:0px;
margin-right: 0px;
margin-bottom:0px;
}

#console {
	height: 476px;
    width: 600px;
}

#console td {
	vertical-align: top;
}

#viewsBG{
	height: 400px;
	width: 230px;
}

#views td{
	padding: 0px 0px 0px 0px;
    margin: 0px 0px 0px 0px;
    text-align: center;
}


#playlist td.playing{
	width: 350px;
	background: white;
}
#playlistBG{
	height: 400px;
    width: 350px;
	background: #00ff00;
}

#album {
    height: 225px;
    width: 225px;
}

#menu {
	height: 70px;
    width: 350px;
	background: green;
}
.buttons {
	height: 70px;
    width: 70px;
}
#loopBTN{
	height: 35px;
	width: 35px;
}

p { clear: both; }
.audiojs {width: 220px; height: 22px; background: #404040;
  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #444), color-stop(0.5, #555), color-stop(0.51, #444), color-stop(1, #444));
  background-image: -moz-linear-gradient(center top, #444 0%, #555 50%, #444 51%, #444 100%);
  -webkit-box-shadow: 1px 1px 8px rgba(0, 0, 0, 0.3); -moz-box-shadow: 1px 1px 8px rgba(0, 0, 0, 0.3);
  -o-box-shadow: 1px 1px 8px rgba(0, 0, 0, 0.3); box-shadow: 1px 1px 8px rgba(0, 0, 0, 0.3); }
.audiojs .play-pause { width: 15px; height: 20px; padding: 0px 8px 0px 0px; display:none;}
.audiojs p { width: 25px; height: 20px; margin: -3px 0px 0px -1px; }
.audiojs .scrubber { background: #5a5a5a; width: 210px; height: 10px; margin: 5px; }
.audiojs .progress { height: 10px; width: 0px; background: #ccc;
  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #ccc), color-stop(0.5, #ddd), color-stop(0.51, #ccc), color-stop(1, #ccc));
  background-image: -moz-linear-gradient(center top, #ccc 0%, #ddd 50%, #ccc 51%, #ccc 100%); }
.audiojs .loaded { height: 10px; background: #000;
  background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #222), color-stop(0.5, #333), color-stop(0.51, #222), color-stop(1, #222));
  background-image: -moz-linear-gradient(center top, #222 0%, #333 50%, #222 51%, #222 100%); }
.audiojs .time {float: left; height: 25px;  line-height: 25px; display:none;}
.audiojs .error-message { height: 24px;line-height: 24px; }

#repeatBTN_all {
	display: none;
}
#repeatBTN_single {
	display: none;
}
</style>
<script src="../bootstrap/js/jquery-2.2.4.js"></script>
<script src="../bootstrap/js/audio.min.js"></script>
<script type="text/javascript">
$(function() { 
	var state = 0;
	var a = audiojs.createAll({
		//트랙이 끝나면 자동으로 다음곡 재생
		trackEnded: function() {
			//next는 현제 플레이되고있는 플레이리스트의 다음 리스트
			if (state==1) {
				var next = $('#playlist tr td.playing').parent().next().contents().filter("#list");
				//만약 리스트이 끝이라면 next는 플레이리스트의 제일 처음
				if (next.length==0)
					next = $('#playlist tr:first-child td:nth-child(2)');
				$("td").removeClass('playing');
				next.addClass('playing');
				audio.load($('a', next).attr('data-src'));
				audio.play();
				showInfo()
			} else if (state==2) {
				audio.play();
			}
		}
	});
	var audio = a[0];
	//리스트 클릭하면 재생
	$(document).on("click","#playlist tr td:nth-child(2)", function(e) {
		e.preventDefault();
		$("td").removeClass('playing');
		$(this).addClass('playing')
		audio.load($('a', this).attr('data-src'));
		audio.play();
		showInfo()
	});
	//이전 버튼을 눌렀을때
	$("#prevBTN").click(function() {
		prevSong()
	})
	
	//정지,실행 버튼을 눌렀을때
	$("#playBTN").click(function() {
		audio.playPause();
		$(this).css("display", "none").removeClass("waaagh")
		$("#pauseBTN").css("display", "inline").addClass("waaagh")
	})
	$("#pauseBTN").click(function() {
		audio.playPause();
		$(this).css("display", "none").removeClass("waaagh")
		$("#playBTN").css("display", "inline").addClass("waaagh")
	})
	
	//다음 버튼을 눌렀을때
	$("#nextBTN").click(function() {
		nextSong()
	})
	//반복버튼1
	$("#repeatBTN_none").click(function() {
		state = 1
		$(this).css("display", "none")
		$("#repeatBTN_all").css("display", "inline")
	})
	
	//반복버튼2
	$("#repeatBTN_all").click(function() {
		state = 2
		$(this).css("display", "none")
		$("#repeatBTN_single").css("display", "inline")
	})
	
	//반복버튼3
	$("#repeatBTN_single").click(function() {
		state = 0
		$(this).css("display", "none")
		$("#repeatBTN_none").css("display", "inline")
	})

	//목록삭제
	$("#delBTN").click(function() {
		var indexs = ""
			for (var i = $("input:checkbox").length-1; i > -1  ; i--) {
				console.log($("input:checkbox:eq("+i+")").is(":checked"));
				if ($("input:checkbox:eq("+i+")").is(":checked")) {
					if (!$("input:checkbox:eq("+i+")").parent().next().attr("class")) {
						//체크박스에 체크가 되어있고 재생중인 곡이 아닐때,
						indexs += 0+"|"	
					} else {
						//체크박스에 체크가 되어있고 재생중인 곡일때,
						indexs += 1+"|"	
					}
				} else {
					if (!$("input:checkbox:eq("+i+")").parent().next().attr("class")) {
						//체크박스에 체크가 되어있지않고, 재생중인 곡이 아닐때,
						indexs += 2+"|"	
					} else {
						//체크박스에 체크가 되어있지않고, 재생중인 곡일때,
						indexs += 3+"|"	
					}
				}
			}
		$.ajax({
			type:"post",
			url:"../deleteListServlet",
			data:"indexs="+indexs,
			dataType:"json",
			success:function(result) {
				//테이블안의 값 제거
				$("#playlist").empty()
				//받아온 리스트를 div영역에 뿌려주기
			 	$.each(result, function(index, item) {
					$("#playlist").append("<tr><td><input type='checkbox'></td><td id='list'>"+(index+1)+" <a style='text-decoration:none' href='#' data-src='"+item.url+"'>"+item.songName+"</a></td></tr>")
					.css("height", "50px")
					if (item.isPlay==1) {
						$("#playlist tr:nth-child("+(index+1)+") td:nth-child(2)").addClass('playing');
					}
				})
			},
			error:function() {
				alert("오류남!")
			}
		})
	})
	
	$("#upBTN").click(function() {
		var indexs = ""
			for (var i = 0; i < $("input:checkbox").length ; i++) {
				console.log($("input:checkbox:eq("+i+")").is(":checked"));
				if ($("input:checkbox:eq("+i+")").is(":checked")) {
					if (!$("input:checkbox:eq("+i+")").parent().next().attr("class")) {
						//체크박스에 체크가 되어있고 재생중인 곡이 아닐때,
						indexs += 0+"|"	
					} else {
						//체크박스에 체크가 되어있고 재생중인 곡일때,
						indexs += 1+"|"	
					}
				} else {
					if (!$("input:checkbox:eq("+i+")").parent().next().attr("class")) {
						//체크박스에 체크가 되어있지않고, 재생중인 곡이 아닐때,
						indexs += 2+"|"	
					} else {
						//체크박스에 체크가 되어있지않고, 재생중인 곡일때,
						indexs += 3+"|"	
					}
				}
			}
		$.ajax({
			type:"post",
			url:"../upListServlet",
			data:"indexs="+indexs,
			dataType:"json",
			success:function(result) {
				//테이블안의 값 제거
				$("#playlist").empty()
				//받아온 리스트를 div영역에 뿌려주기
			 	$.each(result, function(index, item) {
					$("#playlist").append("<tr><td><input type='checkbox'></td><td id='list'>"+(index+1)+" <a style='text-decoration:none' href='#' data-src='"+item.url+"'>"+item.songName+"</a></td></tr>")
					.css("height", "50px")
					if (item.isPlay==1) {
						$("#playlist tr:nth-child("+(index+1)+") td:nth-child(2)").addClass('playing');
					}
					if (item.isChecked==1) {
						$("#playlist tr:nth-child("+(index+1)+") td:nth-child(1) :checkbox").prop("checked", this)
					}
				})
			},
			error:function() {

			}
		})
	})
	
	$("#downBTN").click(function() {
		var indexs = ""
			console.log($("input:checkbox").length)
			for (var i = $("input:checkbox").length-1; i > -1  ; i--) {
				console.log($("input:checkbox:eq("+i+")").is(":checked"));
				console.log(i)
				if ($("input:checkbox:eq("+i+")").is(":checked")) {
					if (!$("input:checkbox:eq("+i+")").parent().next().attr("class")) {
						//체크박스에 체크가 되어있고 재생중인 곡이 아닐때,
						indexs += 0+"|"	
					} else {
						//체크박스에 체크가 되어있고 재생중인 곡일때,
						indexs += 1+"|"	
					}
				} else {
					if (!$("input:checkbox:eq("+i+")").parent().next().attr("class")) {
						//체크박스에 체크가 되어있지않고, 재생중인 곡이 아닐때,
						indexs += 2+"|"	
					} else {
						//체크박스에 체크가 되어있지않고, 재생중인 곡일때,
						indexs += 3+"|"	
					}
				}
			}
		$.ajax({
			type:"post",
			url:"../downListServlet",
			data:"indexs="+indexs,
			dataType:"json",
			success:function(result) {
				//테이블안의 값 제거
				$("#playlist").empty()
				//받아온 리스트를 div영역에 뿌려주기
			 	$.each(result, function(index, item) {
					$("#playlist").append("<tr><td><input type='checkbox'></td><td id='list'>"+(index+1)+" <a style='text-decoration:none' href='#' data-src='"+item.url+"'>"+item.songName+"</a></td></tr>")
					.css("height", "50px")
					if (item.isPlay==1) {
						$("#playlist tr:nth-child("+(index+1)+") td:nth-child(2)").addClass('playing');
					}
					if (item.isChecked==1) {
						$("#playlist tr:nth-child("+(index+1)+") td:nth-child(1) :checkbox").prop("checked", this)
					}
				})
			},
			error:function() {

			}
		})
	})
	
	//키보드 조작
	$(document).keydown(function(e) {
		var unicode = e.charCode ? e.charCode : e.keyCode;
		//앞(키보드의 십자)을 눌렀을때 다음곡
		if (unicode == 39) {
			nextSong()
		//뒤(키보드의 십자)를 눌렀을때 전곡
		} else if (unicode == 37) {
			prevSong()
		//스페이스바를 눌렀을때 정지,실행
		} else if (unicode == 32) {
			audio.playPause();
			console.log($("#playBTN").attr("class"))	
			if ($("#playBTN").attr("class")=="buttons waaagh") {
				console.log("플레이중")
				$("#playBTN").css("display", "none").removeClass("waaagh")
				$("#pauseBTN").css("display", "inline").addClass("waaagh")
			} else if ($("#playBTN").attr("class")=="buttons"){
				console.log("정지중")
				$("#playBTN").css("display", "inline").addClass("waaagh")
				$("#pauseBTN").css("display", "none").removeClass("waaagh")
			}
		}
	})
	//재생중인 곡 정보가져와서 변경하기
	function showInfo() {
		$.ajax({
			type:"post",
			url:"../showInfoListServlet",
			data:"playing="+$('#playlist tr td.playing a').attr('data-src'),
			dataType:"json",
			success:function(result) {
				$.each(result, function(index, item) {
					$("#album").attr("src", item.songImgUrl)
					$("#songName").empty().append(item.songName)
					$("#artist").empty().append(item.songArtist)
				})
			},
			error:function() {
				alert("showInfo 오류남!")
			}
		})
	}
	//플레이 리스트 로드
	function loadList() {
		$.ajax({
			type:"post",
			url:"../loadListServlet",
			dataType:"json",
			success:function(result) {
				//받아온 리스트를 div영역에 뿌려주기
				$.each(result, function(index, item) {
					$("#playlist").append("<tr><td><input type='checkbox'></td><td id='list'>"+(index+1)+" <a style='text-decoration:none' href='#' data-src='"+item.url+"'>"+item.songName+"</a></td></tr>")
					.css("height", "50px")
				})
				firstTrack()
			},
			error:function() {
				alert("오류남!")
			}
		})
	}
	//트랙의 첫번째 곡을 선택후 플레이
	function firstTrack() {
		first = $('#playlist a').attr('data-src');
		$('#playlist tr:first-child td:nth-child(2)').addClass('playing');
		audio.load(first);
		audio.play();
		$("#songName").load()
		showInfo()
	}
	//다음곡
	function nextSong() {
		var next = $('#playlist tr td.playing').parent().next().contents().filter("#list");
		if (next.length==0)
			next = $('#playlist tr:first-child td:nth-child(2)');
		next.click();
		showInfo()
	}
	//이전곡
	function prevSong(){
		var prev = $('#playlist tr td.playing').parent().prev().contents().filter("#list");
		if (prev.length==0)
			prev = $('#playlist tr:last-child td:nth-child(2)');
		prev.click();
		showInfo()
	}
	//음량조절바
	var rangeSlider = function(){
		  var slider = $('.range-slider'),
		      range = $('.range-slider__range'),
		      value = $('.range-slider__value');
		  slider.each(function(){
		    value.each(function(){
		      var value = $(this).prev().attr('value');
		      $(this).html(value);
		    });
		    range.on('input', function(){
		      $(this).next(value).html(this.value);
		      audio.setVolume(this.value*0.01);
		    });
		  });
		};
	$("#pauseBTN").css("display", "inline").addClass("waaagh")
	$("#playBTN").css("display", "none")
	audio.setVolume(0.5)
	loadList()
	rangeSlider();
	
});
</script>
</head>
<body>
<table id="console">
<tr>
<td>
<div id="viewsBG">
<table id="views">
<tr><td><tr><td><img src="wah.jpg" id="album"></td><td rowspan="2"></td></tr>
<tr><td><audio></audio></td></tr>
<tr><td><div id="songName">곡명</div></td></tr>
<tr><td><div id="artist">아티스트</div></td></tr>
<tr><td>
<img src="orks-red-waaagh1.png" id="prevBTN" class="buttons">
<img src="orks-red-waaagh1.png" id="playBTN" class="buttons">
<img src="6.png" id="pauseBTN" class="buttons">
<img src="orks-red-waaagh1.png" id="nextBTN" class="buttons"></td></tr>
<tr><td>
<div class="range-slider">
  <input class="range-slider__range" type="range" value="50" min="0" max="100">
  <span class="range-slider__value">0</span>
</div>
<img src="orks-red-waaagh1.png" id="repeatBTN_none" class="buttons">
<img src="2.jpg" id="repeatBTN_all" class="buttons">
<img src="3.jpg" id="repeatBTN_single" class="buttons">
</td></tr>
</table>
</div>
</td>

<td>
<div id="playlistBG">
<table id="playlist">
</table>
</div>
<div id="menu">
<img src="orks-red-waaagh1.png" id="delBTN" class="buttons">
<img src="orks-red-waaagh1.png" id="upBTN" class="buttons">
<img src="orks-red-waaagh1.png" id="downBTN" class="buttons">
</div>
</td>

</tr>
</table>
</body>
</html>