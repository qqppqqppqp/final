<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/889f069cfd.js" crossorigin="anonymous"></script>

<script>
	$(function(){
		$('#travel').click(function(){
			location.href = "/board/travel/list";
			/* ?email=${__BOARD__.email} */
		}); // onclick
		$('#course').click(function(){
			location.href = "/board/course/list";
			/* ?email=${__BOARD__.email} */
		}); // onclick
		$('#review').click(function(){
			location.href = "/board/review/list";
			/* ?email=${__BOARD__.email} */
		}); // onclick
		$('#free').click(function(){
			location.href = "/board/free/list";
			/* ?email=${__BOARD__.email} */
		}); // onclick
	});	//jq
</script>

<!-- 헤더 시작 -->
<div id="header">
    <div class="wrap">
        <h1 class="logo">
            <a href="#"><img src="${pageContext.request.contextPath}/resources/img/img-logo.png" width="240" height="60"></a>
        </h1>
        <ul class="bn">
            <a href="#" class="fl" id="travel">
                <li>여행지</li>
            </a>
            <a href="#" class="fl" id="course">
                <li>코스</li>
            </a>
            <a href="#" class="fl" id="review">
                <li>리뷰</li>
            </a>

            <a href="#" class="fl" id="free">
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
<!-- 헤더 끝 -->