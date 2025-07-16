/**
 * jquery_formCheck.js
 * jquery 이용 입력양식 이벤트 및 유효성 정리
 */

$(document).ready(function(){
	
	$('#id').focus(); //시작 시 id에 포커스	
	
	//id와 비밀번호 입력한에 포커스 있을 때 색상 변경
	$(':text, :password').on('focus',function(){
		$(this).css('background','rgb(232,232,232')
	});
	
	//id와 비밀번호 입력란에 포커스 잃을 때 색상 변경
	$(':text, ::password').on('blur',function(){
		$(this).css('background','white');
	});
	
	//키보드 이벤트 - keyup
	//휴대폰 번호 입력 첫번째 칸
	$('#hp1').on('keyup',function(){
		if($(this).val().length == 3)
			$('#h2').focus();
	});
	
	$('#hp2').on('keyup',function(){
		if($(this).val().length == 4)
			$('#h3').focus();
	});
	
	//엔터키를 눌렀는지 확인해 submit - 키 정보를 인수로 전달 받음
	$(document).on('keydown',function(e){ //이벤트 발생 시 발생되는 정보를 받기 위해 매개변수 구성
		if(e.keyCode == 13){
			return false;
		}
	});
	
	//ID 입력 후 엔터키를 눌렀을 때 비밀번호로 포커스 이동
	$('#id').on('keydown',function(e){
		if($('#id').val() !='' && e.keyCode==13){
			$('#pwd').focus();
		}	
	});
	
	$('#newMemberForm').on('submit',function(){
		if($('#id').val()==""){
			alert("아이디를 입력하세요.");
			$('#id').focus();
			return false;
		}
		
		if($('#pwd').val()==""){
			alert("비밀번호를 입력하세요");
			$('pwd').focus();
			return false;
		}
		
		//라디오 버튼 선택하지 않은 경우
		if($('input[type="radio"]').is(':checked')){
			alert("학년을 선택하세요");
			return false;
		}
		
		//체크박스 선택하지 않은 경우
		if(!$(':checkbox').is(':checked')){
			alert("관심분야를 입력하세요");
			return false;
		}
		
		//select 박스 선택하지 않은 경우
		if($('select').val()==""){
			alert("관심분야를 입력하세요");
			$('select').focus();
			return false;
		}
		
	}); //폼 submit 끝
	
}); //종료