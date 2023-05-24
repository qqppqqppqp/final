<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 헤더 시작 -->
<div id="header">
    <div class="wrap">
        <h1 class="logo">
            <a href="#"><img src="${pageContext.request.contextPath}/resources/static/img/img-logo.png" width="240" height="60"></a>
        </h1>
        <ul class="bn">
            <span class="fl" id="travelBoard">
                <li>여행지</li>
            </span>
            <a href="#" class="fl">
                <li>코스</li>
            </a>
            <a href="#" class="fl">
                <li>리뷰</li>
            </a>

            <span class="fl" id="freeBoard">
                <li>자유게시판</li>
            </span>

        </ul>

        <ul class="bn">

            <c:if test="${sessionScope.__AUTH__ == null}">
                <span class="fr" id="joinBtn">
                    <li>회원가입</li>
                </span>

                <span class="fr" id="loginBtn">
                    <li>로그인</li>
                </span>
            </c:if>

            <c:if test="${sessionScope.__AUTH__ != null}">
                <span class="fr" id="logoutBtn">
                    <li>로그아웃</li>
                </span>
                <span class="fr" id="myPageBtn">
                    <li>마이페이지</li>
                </span>
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

        $('#freeBoard').on('click', function () {
            self.location.href = '/board/free/list';
        }); // .onclick

    }); // .jq
</script>
<!-- 헤더 끝 -->
