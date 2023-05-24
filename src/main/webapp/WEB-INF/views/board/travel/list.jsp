<%--
  Created by IntelliJ IDEA.
  User: nayoung
  Date: 2023/05/10
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>여행지 List</title>

    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">
    <link rel="stylesheet" href="../../../../resources/static/css/travel/list.css">

    <script src="../../../../resources/static/js/travel/list.js" defer></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>

    <script src="https://kit.fontawesome.com/7ae3a6a91c.js" crossorigin="anonymous"></script>

    <%--  날씨 API  --%>
    <script src="https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={seoul}&appid={19d293c9493145a49d96d3143af18942}"></script>

    <script>
        $(function() {
            $('.write_btn').click(function() {

                location.href = "/board/travel/write";

            });

        });
    </script>
</head>

<body>
<!-- <%-- header --%> -->
<jsp:include page="../../layout/header.jsp"/>

<div id="container" class="list_wrap">

    <!-- search bar -->
    <div class="search_wrap">
        <div class="search">
            <select name="" id="">
                <option value="카테고리">전체</option>
                <option value="카테고리">공연</option>
                <option value="카테고리">야외활동</option>
                <option value="카테고리">팝업스토어</option>
                <option value="카테고리">전시회</option>
            </select>
            <input type="text" class="searchTerm" placeholder="검색내용을 입력하세요.">

            <button type="submit" class="searchButton">
                <i class="fa fa-search"></i>
            </button>
        </div>
    </div>

    <!-- tab menu -->
    <ul class="tab">
        <li class="on" data-tab="menu1"><a href="#">전체</a></li>
        <li data-tab="menu2"><a href="#">공연</a></li>
        <li data-tab="menu3"><a href="#">야외활동</a></li>
        <li data-tab="menu4"><a href="#">팝업스토어</a></li>
        <li data-tab="menu5"><a href="#">전시회</a></li>
    </ul>

    <div id="menu1" class="tabcont on">

        <!-- calendar -->
        <div class="calendarWrap">
            <div class="contBox">
                <div class="item" id="today">
                    <div id="week"></div>
                    <div id="date"></div>
                </div>
                <div class="item item_cal">
                    <button type="button" onclick="prev()"><&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;</button>
                    <div id="year" class="top-bar"></div>
                    <div id="month" class="top-bar"></div>
                    <button type="button" onclick="next()">&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;></button><br>
                    <table>
                        <tr>
                            <th>일</th>
                            <th>월</th>
                            <th>화</th>
                            <th>수</th>
                            <th>목</th>
                            <th>금</th>
                            <th>토</th>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <ul class="list_thumType flnon">
            <li class="thum thum_1">
                <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                    <em class="flag type_ing">진행중</em></a>
                </div>
                <div class="area_txt">
                    <i class="fas fa-heart off"></i>
                    <div class="tit"><a href="#">석촌호수 벚꽃축제</a></div>
                    <p class="date">[2023. 4. 5.~2023. 4. 9.]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    <p class="tag"><span>#가볼만한축제</span><span>#가족과함께</span><span>#가족여행</span><span>#관광지</span><span>#기차여행</span><span>#꽃여행</span></p>
                </div>
            </li>
            <li class="thum thum_2">
                <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                    <em class="flag type_before">진행전</em></a>
                </div>
                <div class="area_txt">
                    <i class="fas fa-heart off"></i>
                    <div class="tit"><a href="#">석촌호수 벚꽃축제</a> </div>
                    <p class="date">[2023. 4. 5.~2023. 4. 9.]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
                    <p class="tag"><span>#가볼만한축제</span><span>#가족과함께</span><span>#가족여행</span><span>#관광지</span><span>#기차여행</span><span>#꽃여행</span></p>
                </div>
            </li>
        </ul>

        <!-- pagination -->
        <div class="pagination_wrap">
            <ul class="pagination">
                <li class="fas fa-angle-left"></li>
                <li><a class="active" href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li class="fas fa-angle-right"></li>
            </ul>
            <div class="btn_wrap">
                <button class="write_btn"><a href="#">글쓰기</a></button>
            </div>
        </div>

    </div>

    <div id="menu2" class="tabcont">
        <h3>menu2</h3>
        <p> This is menu2 content</p>
    </div>

    <div id="menu3" class="tabcont">
        <h3>menu3</h3>
        <p> This is menu3 content</p>
    </div>

    <div id="menu4" class="tabcont">
        <h3>menu4</h3>
        <p> This is menu4 content</p>
    </div>

    <div id="menu5" class="tabcont">
        <h3>menu5</h3>
        <p> This is menu5 content</p>
    </div>


</div>

</body>

<jsp:include page="../../layout/footer.jsp"/>
</html>
