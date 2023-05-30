<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Course_List</title>

    <link rel="stylesheet" href="https://kit.fontawesome.com/889f069cfd.css" crossorigin="anonymous">

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/course/course_list.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout/footer.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/889f069cfd.js" crossorigin="anonymous"></script>

    <script>

        $(function () {

            $('.make_button').click(function () {
                let currPage = "${pageMaker.page.currPage}";
                location = "/board/course/register";
            });

            $('.pageNum').on('click', function (e) {
                let seletedPageNum = e.currentTarget.textContent;
                let searchType="${pageMaker.page.searchType}";
                let keyword="${pageMaker.page.keyword}";
                
                location.href = "/board/course/list?searchType="+searchType+"&keyword="+keyword+"&currPage="+seletedPageNum;
            }); // onclick

        });
        

    </script>
	
	<style>
		
		.area_txt .fa-heart{
		    float: right;
		    font-size: 20px;
		    cursor: pointer;
		    
		}
		
		.area_txt .fa-heart.off{
		    color: #e6e6e6;
		}
		
		.area_txt .fa-heart.on{
		    color: #ff3333;
		}
		
	</style>

</head>

<body>
<jsp:include page="../../layout/header.jsp" />

<div class="search_make">
    <form action="/board/course/list" method="get">
        <select class="course_category" name="searchType">
            <option value="TITLE" selected>제목</option>
            <option value="WRITER">작성자</option>
            <option value="REVIEW">내용</option>
        </select>
        <input class="search_box" type="text" name="keyword" placeholder="검색어를 입력해주세요.">
        <input class="search_button" type="submit"  value="검색">
    </form>
    <form action="/board/course/write" method="post">
    	<input class="make_button" type="button" name="make" value="작성">
    </form>
</div>

<div class="course_list">

	<c:forEach var="course" items="${__LIST__}">
	<div class="course_object_size">
		<div class="course_object">
	    
	        <img src="${pageContext.request.contextPath}/resources/static/img/seoul_forest.png" alt="" class="top_img">
	        <div class="course_top">
	            <a href="/board/course/get?seq=${course.seq}">
	                <strong>${course.TITLE}</strong><p> 조회수: ${course.TOTAL}</p>
	                <ul><li>${course.REVIEW}</li></ul>
	                <span class="user_info">
	                		
	                        <div class="area_txt">
		                       <i class="fas fa-heart off">
		                       		<input type="hidden" name="board" value="course">
		                       		<input type="hidden" name="board_seq" value="${course.seq}">
		                       </i>
		                   </div>
	                        <span class="user_img">
	                            <img src="${pageContext.request.contextPath}/resources/static/img/img_profile.png" alt="${course.WRITER}">
	                        </span>
	                        <em>${course.WRITER}</em>
	                    </span>
	            </a>
	        </div>
	        
	        <c:set var="travel_list" value="${course.listVO}" />
            <c:choose>
                
                <c:when test="${travel_list.size() <= 6}">
                    <c:forEach var="travel" items="${travel_list}" >
                        <ul>
                            <li><span><a href="#"> ${travel.TITLE}</a></span></li>
                        </ul>
                    </c:forEach>
                </c:when>
                <c:when test="${travel_list.size() > 6}">
                    <c:forEach var="travel" items="${travel_list}" begin="0" end="5" varStatus="status">
                        <c:choose>
                            <c:when test="${status.index < 4}">
                                <ul>
                                    <li><span><a href="#">${travel.TITLE}</a></span></li>
                                </ul>
                            </c:when>
                            <c:when test="${status.index == 4}">
                                <ul>
                                    <li><span style="opacity: 0.6;"><a href="#">${travel.TITLE}</a></span></li>
                                </ul>
                            </c:when>
                            <c:when test="${status.index == 5}">
                                <ul>
                                    <li><span style="opacity: 0.3;"><a href="#">${travel.TITLE}</a></span></li>
                                </ul>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </c:when>
            </c:choose>
	    </div>
	</div>
	</c:forEach>
	
	<script>
		$(function () {
	    	var heartIcon = $('.area_txt .fa-heart');
	        heartIcon.click(function() {
	            $(this).toggleClass('on');
	            
	            
	            var boardType = $(this).find('input[name="board"]').val();
				var boardSeq = $(this).find('input[name="board_seq"]').val();
				
				
				$.ajax({
				    url: '/board/course/course_like',
				    method: 'POST',
				    data: {
				      BOARD: boardType,
				      BOARD_SEQ: boardSeq
				    },
				    success: function(response) {
				    	alert("좋아요!");
				      // 성공적으로 요청을 처리한 후 실행할 코드
				    },
				    error: function(xhr, status, error) {
				    	alert("오류");
				      // 요청 처리 중 오류가 발생한 경우 실행할 코드
				    }
				  });
				
	        })
	        
	    });
	</script>
	
	
</div>

<div id="pagination">
		<ul>
			<c:if test="${pageMaker.prev}">
				<li class="Prev">
					<a href="/board/course/list?searchType=${pageMaker.page.searchType}&keyword=${pageMaker.page.keyword}&currPage=${pageMaker.startPage-1}">Prev</a>
				</li>
			</c:if>
	
			<c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" >
	
				<li class="pageNum ${pageMaker.page.currPage== pageNum? 'current':'' }">${pageNum}</li>
	
			</c:forEach>
	
	
			<c:if test="${pageMaker.next}">
				<li class="Next">
					<a href="/board/course/list?searchType=${pageMaker.page.searchType}&keyword=${pageMaker.page.keyword}&currPage=${pageMaker.endPage+1}">Next</a>
				</li>
			</c:if>
		</ul>
</div>


<jsp:include page="../../layout/footer.jsp" />
</body>

</html>