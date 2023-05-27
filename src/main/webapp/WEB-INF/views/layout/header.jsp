<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 헤더 시작 -->
<div id="header">
    <div class="wrap">
        <h1 class="logo">
            <a href="#"><img src="${pageContext.request.contextPath}/resources/static/img/img-logo.png" width="240" height="60"></a>
        </h1>
        <ul class="bn">
            <li class="fl" id="travelBoard">여행지</li>
            <li class="fl" id="courseBoard">코스</li>
            <li class="fl" id="reviewBoard">리뷰</li>
            <li class="fl" id="freeBoard">자유게시판</li>
        </ul>

        <ul class="bn">
            <c:if test="${sessionScope.__AUTH__ == null}">
                <li class="fr" id="joinBtn">회원가입</li>
                <li class="fr" id="loginBtn">로그인</li>
            </c:if>

            <c:if test="${sessionScope.__AUTH__ != null}">
                <li class="fr" id="logoutBtn">로그아웃</li>
                <li class="fr" id="myPageBtn">마이페이지</li>
            </c:if>
        </ul>

    </div>

</div>

<script>
    // To display sign-in result.
    var result = "${param.__RESULT__}";

    if(result != null && result.length > 0) {
        alert(result);
    } // if

    $(function () {

        $('#loginBtn').on('click', function () {
            self.location.href = '/member/login/main';
        }); // .onclick

        $('#joinBtn').on('click', function () {
            self.location.href = '/member/join/main';
        }); // .onclick

        $('#logoutBtn').on('click', function () {
            self.location.href = '/member/logout';
        }); // .onclick

        $('#myPageBtn').on('click', function () {
            self.location.href = '#';
        }); // .onclick

        $('#travelBoard').on('click', function () {
            self.location.href = '/board/travel/list';
        }); // .onclick

        $('#courseBoard').on('click', function () {
            self.location.href = '/board/course/list';
        }); // .onclick

        $('#reviewBoard').on('click', function () {
            self.location.href = '/board/review/list';
        }); // .onclick

        $('#freeBoard').on('click', function () {
            self.location.href = '/board/free/list';
        }); // .onclick

    }); // .jq
</script>
<!-- 헤더 끝 -->
