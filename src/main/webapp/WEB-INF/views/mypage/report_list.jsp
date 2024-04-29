<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="../resources/css/common/reset.css" type="text/css">
    <link rel="stylesheet" href="../resources/css/report_list/report_list.css" type="text/css">
   		<link rel="stylesheet" href="../resources/css/header/header.css">
<script src="../resources/js/jquery.twbsPagination.js" type="text/javascript"></script>
      <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <title>신고/문의 리스트</title>
</head>
<body>
	<jsp:include page="../header/header.jsp"/>
    <div class="match_ask_list">
        <h1 class="title">신고 내역</h1>
        <table class="report_list">
            <thead class="report_list_thead">
                <tr> 
                    <th class="report_list_th">No.</th>
                    <th class="report_list_th">제목</th>
                    <th class="report_list_th">날짜</th>
                    <th class="report_list_th">신청 상태</th>
                    <th class="report_list_th"></th>
                    <th class="report_list_th"></th>
                </tr>
            </thead>
            <tbody id="list">
                <!-- <tr class="report_list_tbody">   기본 탬플릿
                    <td class="report_list_td" >1.</td>
                    <td class="report_list_td">2024.12.12</td>
                    <td class="report_list_td">00-02</td>
                    <td class="report_list_td"><button disabled id="match_list_Checking">확인중</button></td>
                    <th class="report_list_td"><button class="button" id="report_modify">수정</button></th>
                    <th class="report_list_td"><button class="button" id="report_del">삭제</button></th>
                </tr> -->
            </tbody>
            <tr>
                <!-- 플러그인 사용법 --> 
                   <td colspan="4">
                       <div class="container">                           
                        <nav aria-label="Page navigation" style="text-align:center">
                           <ul class="pagination" id="pagination"></ul>
                        </nav>               
                     </div>
                   </td>
                </tr>
        </table>
    </div>
</body>
<script>
    var showPage = 1; //n번부터
    var pagePerNum = 3; //n개 보여줌
	listCall(showPage);
    
	//리스트 호출
    function listCall(page,perNum){
    	$.ajax({
    		type:'post',
            url:'./report_list.ajax',
            data:{
                'page':page,
                'cnt':pagePerNum
            },
            dataType:'JSON',
            success:function(data){
            	reportList(data.list);
				console.log(data);
				
		         // 플러그인
	            $('#pagination').twbsPagination({
	        	  startPage:1, // 시작 페이지 [1] (너 몇 페이지야)
	        	  totalPages:data.totalPages, // 총 페이지 갯수 (내가 개산 해야함) 
	        	  visiblePages:5, //보여줄 페이지 수 [1][2][3][4][5]
	        	  onPageClick:function(evt,pg){ //페이지 클릭시 실행 함수
	        		  console.log(evt); //이벤트 객체
	        		  console.log(pg); //클릭한 페이지 번호
	        		  showPage = pg;
	        		  listCall(pg);
	        	  	}
	        	  });
            },
            error:function(error){
                console.log(error);
            }


    	});
    }
    
 function reportList(list){
	 var content = '';
	 var count = 0;
	for (report of list) {
		count++;
		content += '<tr class="report_list_tbody">';
		content +='<td class="report_list_td" >'+count+'</td>';
       	content +='<td class="report_list_td">'+report.report_tit+'</td>'; 
       	//날짜 수정
       	var date = new Date(report.report_date);
       	var ModifyDate = date.toLocaleDateString("ko-KR");
       	content +='<td class="report_list_td">'+ModifyDate+'</td>';
       	var state = report.report_state;
       	console.log("처리 내용 :",state);
        content +='<td class="report_list_td"><button disabled id="match_list_Checking">'+report.report_state+'</button></td>';    
        content +='<th class="report_list_td"><button class="button" id="report_modify">수정</button></th>';    
       	content +='<th class="report_list_td"><button class="button" id="report_del">삭제</button></th>';   
        content +='</tr>';
	} 
	$('#list').html(content);
 }

</script>
</html>