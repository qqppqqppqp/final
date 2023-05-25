<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Course_search</title>

    <!-- layout css -->
    <!-- main css -->
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
                location = "/board/course/register?currPage="+currPage;
            });

            $('.pageNum').on('click', function (e) {
                let seletedPageNum = e.currentTarget.textContent;
                let searchType="${search.searchType}";
                let keyword="${search.keyword}";
                
                location.href = "/board/course/search?searchType="+searchType+"&keyword="+keyword+"&currPage="+seletedPageNum;
            }); // onclick


        });

    </script>
	

</head>

<body>
<div id="header">
    <div class="wrap">
        <h1 class="logo">
            <a href="#"><img src="../../../resources/img/img-logo.png" width="240" height="60"></a>
        </h1>
        <ul class="bn">
            <a href="#" class="fl">
                <li>여행지</li>
            </a>
            <a href="#" class="fl">
                <li>일정</li>
            </a>

            <a href="#" class="fl">
                <li>자유게시판</li>
            </a>

        </ul>

        <ul class="bn">

            <a href="#" class="fr">
                <li>회원가입</li>
            </a>
            <a href="#" class="fr">
                <li>로그인</li>
            </a>

        </ul>

    </div>

</div>

<div class="search_make">
    <form action="/board/course/search" method="get">
        <select class="course_category" name="searchType">
            <option value="TITLE" selected>제목</option>
            <option value="WRITER">작성자</option>
            <option value="REVIEW">내용</option>
        </select>
        <input class="search_box" type="text" name="keyword" placeholder="검색어를 입력해주세요.">
        <input class="search_button" type="submit" value="검색">
    </form>
    <input class="make_button" type="button" name="make" value="작성">
</div>

<div class="course_list">

	<c:forEach var="course" items="${__LIST__}">
		<div class="course_object">
		    
	
	    
	        <img src="../../../resources/img/seoul_forest.png" alt="" class="top_img">
	        <div class="course_top">
	            <a href="#">
	                <strong>${course.TITLE}</strong>
	                <ul><li>${course.REVIEW}</li></ul>
	                <span class="user_info">
	                        <input type="checkbox" name="jjim" value="하트">
	                        <span class="user_img">
	                            <img src="../../../../resources/img/img_profile.png" alt="${course.WRITER}">
	                        </span>
	                        <em>${course.WRITER}</em>
	                    </span>
	            </a>
	        </div>
	        <c:forEach var="travel" items="${__TRAVEL_LIST__}">
	        <ul>
	            <li><span><a href="#">${travel.LINK}</a></span></li>
	            <li><span><a href="#">${travel.USER_REVIEW}</a></span></li>
	        </ul>
	        </c:forEach>
	        
	        
	    </div>
	</c:forEach>
    
</div>

<div id="pagination">
		<ul>
			<c:if test="${pageMaker.prev}">
				<li class="Prev">
					<a href="/board/course/search?searchType=${search.searchType}&keyword=${search.keyword}&currPage=${pageMaker.startPage-1}">Prev</a>
				</li>
			</c:if>
	
			<c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}" >
	
				<li class="pageNum ${pageMaker.page.currPage== pageNum? 'current':'' }">${pageNum}</li>
	
			</c:forEach>
	
	
			<c:if test="${pageMaker.next}">
				<li class="Next">
					<a href="/board/course/search?searchType=${search.searchType}&keyword=${search.keyword}&currPage=${pageMaker.endPage+1}">Next</a>
				</li>
			</c:if>
		</ul>
</div>


<aside>
    <div class="quick_box">
        <p>QUICK LINK</p>
        <ul>
            <li><a href="#a">날씨</a></li>
            <li><a href="#a">문의</a></li>
            <li class="top"><a href="#a"><i class="fas fa-caret-up"></i></a></li>
            <li class="bottom"><a href="#a"><i class="fas fa-caret-down"></i></a></li>
        </ul>
    </div>

</aside>

<footer>
    <div class="footer_wrap">
        <div class="footer_box">
            <div class="logo_box">
                <a href="#a"><img src="img/img-footer-logo.png" /></a>
            </div>
            <div>
                <ul>
                    <li><a href="#a">이용약관</a></li>
                    <li><a href="#a">개인정보처리방침</a></li>
                    <li><a href="#a">사이트맵</a></li>
                </ul>
                <p class="copyright">Copyright © seoullive. All Rights Reserved</p>
            </div>
        </div>
    </div>
</footer>
</body>

</html>