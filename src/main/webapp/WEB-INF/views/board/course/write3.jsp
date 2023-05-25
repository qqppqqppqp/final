
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Course_write</title>

    <link rel="stylesheet" href="css/reset.css">
    <!-- layout css -->
    <link rel="stylesheet" href="css/layout/header.css">
    <link rel="stylesheet" href="css/layout/footer.css">
    <!-- main css -->
    <link rel="stylesheet" href="css/main/main.css">
    <link rel="stylesheet" href="https://kit.fontawesome.com/889f069cfd.css" crossorigin="anonymous">

    <!-- <link rel="stylesheet" href="css/course_write_copy.css"> -->


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/889f069cfd.js" crossorigin="anonymous"></script>

    <script>
        $(document).ready(function () {
            $("#dec_plus").click(function () {
                $("#dec_ul").append('<li><div class="write_day_dec_search"><input type="search" id="myInput" onsearch="myFunction()" value="여행지를 검색해주세요"><input type="button" value="검색"><input type="button" value="사진변경" ></div></li>');
            });
            $("#day_plus").click(function () {
                $("#day_ul").append('<div class="write_day"><div class="write_day_left"><span class="day_text">1일차</span></div><div class="write_day_right"><ul id="dec_ul"><li><div class="write_day_top"> Day1. [2023년 4월 1일] <br><br><em>1일차, 서울숲부터 남산까지 뚜벅여행</em></div></li></ul><ul><li><div id="dec_plus" class="dec_plus"><input type="button" value="여행지 추가"></div></li></ul></div>');
            });
        });
    </script>
</head>
<style>
    @charset "utf8";

    .write {
        border: 1px solid black;
        width: 1200px;
    }

    .write .write_func {
        border-bottom: 1px solid #777;
        padding: 20px;
        height: 30px;
    }

    .write .write_day {
        border-top: 3px solid #777;
        border-bottom: 3px solid #777;

        position: relative;
    }

    .write .write_day_left {
        width: 150px;
        margin: 30vh 60px;
        float: left;
        height: 100%;

        position: relative;
    }

    .write .write_day_left .day_text {

        margin: auto;

        position: relative;
    }

    .write .write_day_right {
        float: left;
    }

    .write .write_day::after {
        content: '';
        display: block;
        clear: both;
    }

    .write .write_day .write_day_top {
        border-bottom: 1px solid #DDD;
        width: 500px;
        padding: 20px;
        height: 50px;
    }

    .write .write_day .write_day_dec_choice {
        border-bottom: 1px solid #DDD;
        width: 500px;
        padding: 20px;
        height: 120px;

    }

    .write .write_day .write_day_dec_choice div {
        float: left;
    }

    .write .write_day .write_day_dec_choice::after {
        content: '';
        display: block;
        clear: both;
    }

    .write .write_day .write_day_dec_search {
        border-bottom: 1px solid #DDD;
        width: 500px;
        padding: 20px;
        height: 120px;

    }

    .write .write_day .write_day_right>ul>li {
        border: 1px solid #DDD;
    }



    .write .write_day .write_day_dec_choice:last-of-type {
        border-bottom: 0px;
    }

    .write .write_day .dec_plus {
        border-bottom: 2px solid #777;
        padding: 20px;
        display: flex;
        justify-content: center;
    }

    .write .write_day .day_plus {
        padding: 20px;
        display: flex;
        justify-content: center;
    }

    .write .write_button {
        padding: 20px;
        display: flex;
        justify-content: center;
    }
</style>

<body>
    <div id="header">
        <div class="wrap">
            <h1 class="logo">
                <a href="#"><img src="img/img-logo.png" width="240" height="60"></a>
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

    <!-- ===================================================================================== -->
    <form action="#" method="get">
        <div class="write">
            <div class="write_func">

                <label for="birthday">출발일자:</label>
                <input type="date" name="start_date">
                <input type="button" value="day추가">
            </div>
            <ul id="day_ul">
                <li>
                    <div class="write_day">
                        <div class="write_day_left"><span class="day_text">1일차</span></div>
                        <div class="write_day_right">
                            <ul id="dec_ul">
                                <li>
                                    <div class="write_day_top">
                                        Day1. [2023년 4월 1일] <br><br>
                                        <em>1일차, 서울숲부터 남산까지 뚜벅여행</em>
                                    </div>
                                </li>
                                <li>
                                    <div class="write_day_dec_choice">
                                        <div><img src="img/seoul_forest.png" alt="" width="80px" height="50px"></div>
                                        <div class="dec_title">서울숲 / 실외, 자연</div>
                                        <div></div>
                                    </div>
                                </li>
                                <li>
                                    <div class="write_day_dec_search" id="write_day_dec_search">
                                        <input type="search" id="myInput" onsearch="myFunction()" value="여행지를 검색해주세요">
                                        <input type="button" value="검색">
                                        <input type="button" value="사진변경">

                                        <p id="demo"></p>
                                        <script>
                                            function myFunction() {
                                                var x = document.getElementById("myInput");
                                                document.getElementById("demo").innerHTML = "You are searching for: " + x.value;
                                            }
                                        </script>

                                    </div>
                                </li>

                            </ul>
                            <ul>
                                <li>
                                    <div id="dec_plus" class="dec_plus"><input type="button" value="여행지 추가"> <input
                                            type="button" value="여행지 삭제"></div>

                                </li>
                            </ul>
                        </div>
                        <div>지도</div>

                    </div>
                </li>
            </ul>
            <div class="write_day">
                <div id="day_plus" class="day_plus"><input type="button" value="Day 추가"><input type="button"
                        value="Day 삭제"></div>
            </div>
            <div class="write_button">
                <input type="submit" value="등록">
            </div>
        </div>
    </form>
    <!-- ===================================================================================== -->

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