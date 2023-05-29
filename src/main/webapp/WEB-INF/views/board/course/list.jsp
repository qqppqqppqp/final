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

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/course_list.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout/footer.css">

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
	

</head>

<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/layout/header.jsp"/>

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
	    
	        <img src="${pageContext.request.contextPath}/resources/img/seoul_forest.png" alt="" class="top_img">
	        <div class="course_top">
	            <a href="#">
	                <strong>${course.TITLE}</strong>
	                <ul><li>${course.REVIEW}</li></ul>
	                <span class="user_info">
	                        <input type="checkbox" name="jjim" value="하트">
	                        <span class="user_img">
	                            <img src="${pageContext.request.contextPath}/resources/img/img_profile.png" alt="${course.WRITER}">
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

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>

</html>