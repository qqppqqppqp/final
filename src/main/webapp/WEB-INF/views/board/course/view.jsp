
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Course_list</title>

    <link rel="stylesheet" href="css/reset.css">
    <!-- layout css -->
    <link rel="stylesheet" href="css/layout/header.css">
    <link rel="stylesheet" href="css/layout/footer.css">
    <!-- main css -->
    <link rel="stylesheet" href="css/main/main.css">
    <link rel="stylesheet" href="https://kit.fontawesome.com/889f069cfd.css" crossorigin="anonymous">

    <link rel="stylesheet" href="css/course_list.css">
    

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/889f069cfd.js" crossorigin="anonymous"></script>
</head>

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

    <div class="search_make">
        <select class="course_category" name="category" value="카테고리">
            <option value="1" selected>전체</option>
            <option value="2">여행지</option>
            <option value="3">유저 이름</option>
            <option value="4">글 제목</option>
        </select>
        <input class="search_box" type="text">
        <input class="search_button" type="button" name="search" value="검색">

        <input class="make_button" type="button" name="make" value="작성">
    </div>

    <div class="course_list">
        <div class="course_object">
            <img src=" img/seoul_forest.png" alt="" class="top_img">
            <div class="course_top">
                <a href="#">
                    <strong>서울 여행</strong>
                    <ul>
                        <li>지역 : 서울 성동구~중구</li>
                        <li>총거리 : 8.4km</li>
                    </ul>
                    <span class="user_info">
                        <input type="checkbox" name="jjim" value="하트">
                        <span class="user_img">
                            <img src="img/img_profile.png" alt="Rain">
                        </span>
                        <em>Rain</em>
                    </span>
                </a>
            </div>
            <ul>
                <li><span><a href="#">디뮤지엄</a></span></li>
                <li><span><a href="#">서울숲</a></span></li>
                <li><span><a href="#">응봉산</a></span></li>
                <li><span><a href="#">서울신라호텔</a></span></li>
                <li><span><a href="#">국립극장</a></span></li>
                <li><span><a href="#">남산</a></span></li>

            </ul>
        </div>

        <div class="course_object">
            <img src="img/shilla_hotel.png" alt="" class="top_img" >
            <div class="course_top">
                <a href="#">
                    <strong>서울 여행</strong>
                    <ul>
                        <li>지역 : 서울 성동구~중구</li>
                        <li>총거리 : 8.4km</li>
                    </ul>
                    <span class="user_info">
                        <span class="user_img">
                            <img src="img/img_profile.png" alt="Rain">
                        </span>
                        <em>Rain</em>
                    </span>
                </a> 
            </div>
            <ul>
                <li><span><a href="#">디뮤지엄</a></span></li>
                <li><span><a href="#">서울숲</a></span></li>
                <li><span><a href="#">응봉산</a></span></li>
                <li><span><a href="#">서울신라호텔</a></span></li>
                <li><span><a href="#">국립극장</a></span></li>
                <li><span><a href="#">남산</a></span></li>

            </ul>
        </div>

        <div class="course_object">
            <img src=" img/namsan.jpg" alt="" class="top_img" >
            <div class="course_top"> <a href="#">
                    <strong>서울 여행</strong>
                    <ul>
                        <li>지역 : 서울 성동구~중구</li>
                        <li>총거리 : 8.4km</li>
                    </ul>
                    <span class="user_info">
                        <span class="user_img">
                            <img src="img/img_profile.png" alt="Rain">
                        </span>
                        <em>Rain</em>
                    </span>
                </a>
                
            </div>
            <ul>
                <li><span><a href="#">디뮤지엄</a></span></li>
                <li><span><a href="#">서울숲</a></span></li>
                <li><span><a href="#">응봉산</a></span></li>
                <li><span><a href="#">서울신라호텔</a></span></li>
                <li><span><a href="#">국립극장</a></span></li>
                <li><span><a href="#">남산</a></span></li>

            </ul>
        </div>
    </div>

    <div class="paging">
        <a href="#" class="direction first">처음</a>
        <a href="#" class="direction prev">이전</a>
        
        <strong class="page_button">1</strong>
        <a href="#" class="page_button">2</a>
        <a href="#" class="page_button">3</a>
        <a href="#" class="page_button">4</a>
        <a href="#" class="page_button">5</a>
        <a href="#" class="page_button">6</a>
        <a href="#" class="page_button">7</a>
        <a href="#" class="page_button">8</a>
        <a href="#" class="page_button">9</a>
        <a href="#" class="page_button">10</a>

        <a href="#" class="direction next">다음</a>
        <a href="#" class="direction last">끝</a>
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