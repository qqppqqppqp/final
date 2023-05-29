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
                <li id="loginout">로그인</li>
            </a>

        </ul>

    </div>

</div>
<!-- 헤더 끝 -->
