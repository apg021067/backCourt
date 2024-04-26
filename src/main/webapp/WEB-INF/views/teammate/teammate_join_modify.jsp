<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>팀원 모집글 작성</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<link rel="stylesheet" href="../resources/css/common/reset.css"
	type="text/css">
<link rel="stylesheet" href="../resources/css/teammate/teammate_write.css" 
	type="text/css">
<link rel="stylesheet" href="../resources/css/header/header.css"
	type="text/css">
</head>
<body>
<jsp:include page="../header/header.jsp"/>
	<div class="wrapper">
		<div class="header">
<!-- 			<img src="../resources/img/icon/logo.png" class="img" alt="로고" />  -->
		<span>팀원 모집글 수정</span>
		</div>
		<br />
		<div class="content-wrapper">
			<div class="content">팀명 : ${info.team_name}</div>
		</div>
		<div class="content-wrapper">
			<div class="content" id="address">지역 : ${info.team_address}</div>
		</div>
		<div class="content-wrapper">
			<div class="content">팀 설명 : ${info.team_info}</div>
		</div>
		<form id="teammateForm" action="teammate_join_write.do" method="post">
		<div class="content-wrapper">
			<div class="content">모집내용 : </div>
			<textarea name="teammate_info" class="textarea" id="teammateContent" maxlength="500"
				placeholder=" 팀원 모집내용(특이사항, 참가비를 받을 개인계좌, 연락처 등)을 자유롭게 입력해주세요.(글자수 제한: 500자)">
            </textarea>
			<div id="char-count"></div>
		</div>
		<div class="content-wrapper">
			<div class="content">모집 성별 :</div>
			<div class="radio-wrapper">
				<input type="radio" id="male" name="teammateGender" value="male"> 
				<label for="male">남자</label> 
				<input type="radio" id="female" name="teammateGender"	value="female"> 
				<label for="female">여자</label>
			</div>
		</div>
		<div class="content-wrapper">
			<div class="content">모집 레벨 : </div>
			<div class="radio-wrapper">
				<input type="radio" id="bronze" name="teammateLevel" value="bronze">
					<label for="bronze">브론즈</label> 
				<input type="radio" id="silver"name="teammateLevel" value="silver">
				 	<label for="silver">실버</label>
				<input type="radio" id="gold" name="teammateLevel" value="gold">
				 	<label	for="gold">골드</label>
				<input type="radio" id="platinum" name="teammateLevel" value="platinum"> 
					<label for="platinum">플레티넘</label>
			</div>
		</div>
		<div class="content-wrapper">
			<div class="content">모집 포지션 :</div>
			<select class="select" name="teammatePosition" id="teammatePosition">
				<option value="">포지션 선택</option>
				<option value="센터">센터</option>
				<option value="포워드">포워드</option>
				<option value="가드">가드</option>
			</select>
		</div>
		<div class="update">
			<input type="submit" value="수정 취소" id="cancel" class="submit">
			<input type="submit" value="수정 완료" id="finish" class="submit">
		</div>
		</form>
	</div>
</body>
<script>
$('.menu').css('display','none');
var join_team_idx = '${info.join_team_idx}';


	// 수정완료 클릭 시
	$('#update').on('click',function(){
		if(!confirm("수정 하시겠습니까?")){
			return;
		}
		var selectedGender = $("input[name='teammateGender']:checked").val();
		var selectedLevel = $("input[name='teammateLevel']:checked").val();
		console.log(selectedGender,selectedLevel);
		$.ajax({
			type: 'POST'
			, url: './teammateUpdate.ajax'
			, dataType: 'json'
			, data:{
				'teammate_info':$('#game-teammateContent').val()
				,'teammate_gender':selectedGender
				,'teammate_level':selectedLevel
				,'teammate_position':$('#teammatePosition').val()
				,'join_team_idx':join_team_idx
			}
			, success:function(data){
					alert("수정 완료되었습니다.");
					window.location.href = './teammate/info.go'
			}
			, error:function(){
				alert("수정 실패");
			}
		});
		
	});
	
	// 수정 취소 시 컨펌창
	$(document).ready(function() {
	    $('#cancel').click(function(event) {
	        // 취소 여부 확인
	        var confirmed = confirm("수정을 취소하시겠습니까?");
	        if (confirmed) {
	            // 확인을 누를 경우 이전 페이지로 이동
	            window.history.back();
	        } else {
	            // 취소를 누르면 폼 제출을 중지
	            event.preventDefault();
	        }
	    });
	});
	
	
	$(document).ready(function(){
    	
    	$.ajax({
    		type:'POST'
    		,url: './teammateModify.ajax'
    		,dataType:'json'
    		,data:{'join_team_idx':join_team_idx
    		}
    		, success:function(data){
    			console.log(data);
    			$("#teammateContent").val(data.teammateInfo.join_team_content);
    			$("input[name='teammateGender'][value='" + data.teammateInfo.join_to_gender + "']").prop("checked", true);
    			$("input[name='teammateLevel'][value='" + data.teammateInfo.join_team_level + "']").prop("checked", true);
    			$("#position").val(data.teammateInfo.join_team_position);
    		}
			, error: function(error){
				
			}
    	});
    });

	 	
</script>
</html>