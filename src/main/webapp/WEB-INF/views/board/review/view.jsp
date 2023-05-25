<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>여행지view</title>
    <link rel="stylesheet" href="../../../../resources/static/css/review/view.css">
    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">
    <!--    swiper -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="/js/reviewvi.js"></script> -->
    <script src="https://kit.fontawesome.com/6ba5041685.js" crossorigin="anonymous"></script>

    <script>
        $(function() {
            $('.listBtn').click(function() {
                // 게시판 목록으로 이동 : GET / board / list

                location.href = "/board/review/list";
            }); // on click

            $('.modifyBtn').click(function() {
                // 게시판 목록으로 이동 : GET / board / list

                location.href = "/board/review/modify?&seq=${__BOARD__.seq}";
            }); // on click


        })
    </script>
</head>
<jsp:include page="../../layout/header.jsp"/>
<body>
<div class="wrapper">
    <div class="title">
        <h2 class="title_name">${__BOARD__.title}</h2>
        <div class="head_line">
            <div id="writer_container">
                <span class="writer_picture"><i class="fas fa-user"></i>프로필사진</span>
                <span id="writer">${__BOARD__.writer}
            <span id="area_profile"></span>
            <span id="nick"></span>
          </span>
                <i class="fas fa-circle"></i>
                <span id="publish_date">날짜</span>
            </div>
            <div class="title_function">
                <a href="#" id="copyBtn" class="url_setClipboard" title="" style="cursor:pointer;">
                    <i class="fas fa-share-nodes"></i>URL 복사
                </a>
                <a href="#" class="buddyBtn"><i class="fas fa-user"></i></a>팔로우
                <button id="myButton"><a href="#"><i id="myIcon" class="fa-regular fa-heart"></i></a>

                </button>
                <a href="" class="heartBtn"><i class="fas fa-heart off"></i></a>

            </div>
        </div>
    </div>

    <!-- swiper -->
    <div class="swiper">
        <div class="swiper-wrapper">
            <!-- slides -->
            <div class="swiper-slide"><img src="../../../../resources/static/img/경복궁2.jpg" onclick="window.open(this.src)"
                                           style="height: 100%; width: 100%;"></div>
            <div class="swiper-slide"><img src="../../../../resources/static/img/남산1.jpg" onclick="window.open(this.src)"
                                           style="height: 100%; width: 100%;"></div>
            <div class="swiper-slide"><img src="../../../../resources/static/img/명동1.jpg" onclick="window.open(this.src)"
                                           style="height: 100%; width: 100%;"></div>
        </div>

        <div class="swiper-pagination"></div>

        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>

    </div>

    <div class="content">
        ${__BOARD__.content}
    </div>

    <div class="viewBtn">
        <ul class="btnList">
            <li><a class="deleteBtn" href="#">삭제</a></li>
            <li><a class="modifyBtn" href="#">수정</a></li>
            <li><a class="listBtn" href="#">목록</a></li>
        </ul>
    </div>

    <div class="commant">
        <div class="commant_top">
            댓글
        </div>
        <div class="commant_mid">
            <input class="commant_box" type="text" value="댓글을 남겨주세요.">
            <input class="commant_upload" type="button" value="등록">
        </div>
        <div class="commant_bottom">
            <ul class="commant_bot_wrap">
                <img src="../../../../resources/static/img/profilebasic.png" alt="">
                <li class="commant_id">user1</li>
                <li class="commant_cont">댓글내용</li>
            </ul>
            <ul class="commant_bot_wrap">
                <img src="../../../../resources/static/img/profilebasic.png" alt="">
                <li class="commant_id">user1</li>
                <li class="commant_cont">댓글내용</li>
            </ul>
            <ul class="commant_bot_wrap">
                <img src="../../../../resources/static/img/profilebasic.png" alt="">
                <li class="commant_id">user1</li>
                <li class="commant_cont">댓글내용</li>
            </ul>
        </div>
    </div>

</div>
<script src="../../../../resources/static/js/review/view.js" defer></script>
<jsp:include page="../../layout/footer.jsp"/>
</body>

</html>
