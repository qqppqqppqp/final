<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% session.removeAttribute("member_mid");

response.sendRedirect("../main/index.jsp"); %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
<script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>
<script>
          console.log("<%= session.getAttribute("__AUTH__") %>");
    </script>
<script>
	

    $(function(){
        $('#course').click(function(){
            location.href="/board/course/list";
        })
        $('#travel').click(function(){
            location.href="/board/travel/list";
        })
        $('#free').click(function(){
            location.href="/board/free/list";
        })
        $('#review').click(function(){
        	location.href="/board/review/list";
        })
    }); // jq
</script>

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
            <a href="#"><img src="/resources/static/img/img-logo.png" width="240" height="60"></a>
        </h1>
        <ul class="bn">
            <a href="#" class="fl">
                <li id="travel">여행지</li>
            </a>
            <a href="#" class="fl">
                <li id="course">코스 </li>
            </a>

            <a href="#" class="fl">
                <li id="free">자유게시판</li>
            </a>
            <a href="#" class="fl">
                <li id="review">리뷰</li>
            </a>

        </ul>

        <ul class="bn">

            <a href="/member/join/register" class="fr">
                <li id="regidence">회원가입</li>
            </a>
            <a id="loginout" href="/member/login/main" class="fr">
                <li>로그인</li>
            </a>

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
<!-- 헤더 끝 -->
