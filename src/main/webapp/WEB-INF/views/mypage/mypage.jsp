<%--
  Created by IntelliJ IDEA.
  User: nayoung
  Date: 2023/05/10
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <!-- layout css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout/myPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout/layout.css">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>

    <script src="https://kit.fontawesome.com/7ae3a6a91c.js" crossorigin="anonymous"></script>


</head>
<body>
<!-- <%-- header --%> -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/layout/header.jsp"/>

<div class="mypage_wrap">

    <h1 class="susb_tit">마이페이지</h1>


    <!-- 프로필/사이드메뉴 -->
    <div class="myCont left_menu clear">
        <!-- 프로필 -->
        <p class="user_box">
            <img src="/resources/static/img/user.png" alt="프로필">
            <span class="user_id">user01</span>
        </p>
        <!-- 사이드메뉴 -->
        <ul class="side_menu">
            <li><a href="#">회원정보 수정</a></li>
            <li><a href="#" id="change_password">비밀번호 변경</a></li>
            <li><a href="#">팔로워/팔로잉</a></li>
            <li><a href="#">고객센터</a></li>
        </ul>
    </div>

    <!-- 찜목록/내리뷰/내코스 -->
    <div class="myCont right_menu">
        <div class="my_box my_like">
            <!-- 찜목록 -->
            <div class="my_cont_box like_cont">
                <h2>찜목록</h2>
                <p class="more_btn"><a href="#" id="likeList1">더보기</a><i class="fas fa-chevron-right"></i></p>
                <div class="container">
                    <ul class="list_thumType flnon">
                    
                       <%--   <li class="thum thum_1">
                            <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                <em class="flag type_ing">진행중</em></a>
                                <i class="fas fa-heart on"></i>
                            </div>
                            <div class="area_txt">
                                <div class="tit"><a href="#">석촌호수 벚꽃축제</a></div>
                            </div>
                        </li>
                        <li class="thum thum_2">
                            <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
                                <em class="flag type_before">진행전</em></a>
                                <i class="fas fa-heart on"></i>
                            </div>
                            <div class="area_txt">
                                <div class="tit"><a href="#">석촌호수 벚꽃축제</a> </div>
                            </div>
                        </li> 
                        --%>
                        
                       <%-- <c:forEach var="tbl_likeVO" items="${__LIKELIST__}">
	                        <li class="thum thum_2">
	                            <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
	                                <!-- <em class="flag type_before">진행전</em></a> -->
	                                <!-- <i class="fas fa-heart on"></i> -->
	                                
	                            </div>
	                            <div class="area_txt">
	                                <div class="tit"><a href="#">석촌호수 벚꽃축제</a> </div>
	                            </div>
	                        </li>
                        </c:forEach> --%>
                        
                        <c:forEach var="ReviewBoardVO" items="${__reviewList__}">
	                        <li class="thum thum_2">
	                            <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
	                                <!-- <em class="flag type_before">진행전</em></a> -->
	                                <!-- <i class="fas fa-heart on"></i> -->
	                                
	                            </div>
	                            <div class="area_txt">
	                                <div class="tit"><a href="#">${ReviewBoardVO.title}</a> </div>
	                            </div>
	                        </li>
                        </c:forEach>
                        <c:forEach var="tbl_courseVO" items="${__courseList__}">
	                        <li class="thum thum_2">
	                            <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
	                                <!-- <em class="flag type_before">진행전</em></a> -->
	                                <!-- <i class="fas fa-heart on"></i> -->
	                                
	                            </div>
	                            <div class="area_txt">
	                                <div class="tit"><a href="#">${tbl_courseVO.title}</a> </div>
	                            </div>
	                        </li>
                        </c:forEach>
                        <c:forEach var="tbl_freeList" items="${__freeList__}">
	                        <li class="thum thum_2">
	                            <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
	                                <!-- <em class="flag type_before">진행전</em></a> -->
	                                <!-- <i class="fas fa-heart on"></i> -->
	                                
	                            </div>
	                            <div class="area_txt">
	                                <div class="tit"><a href="#">${tbl_freeList.title}</a> </div>
	                            </div>
	                        </li>
                        </c:forEach>
                        
                        <c:forEach var="TravelBoardVO" items="${__travelList__}">
	                        <li class="thum thum_2">
	                            <div class="photo"><a href="#"><img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&amp;id=870e2a7c-eb93-4708-83b0-94cd277b6f04" alt="석촌호수 벚꽃축제">
	                                <!-- <em class="flag type_before">진행전</em></a> -->
	                                <!-- <i class="fas fa-heart on"></i> -->
	                                
	                            </div>
	                            <div class="area_txt">
	                                <div class="tit"><a href="#">${TravelBoardVO.title} aaa</a> </div>
	                            </div>
	                        </li>
                        </c:forEach>
                        
                        
                    </ul>
                </div>

            </div>
            <!-- 내 리뷰 -->
            <div class="my_cont_box">
                <h2>내 리뷰</h2>
                <%-- <p class="more_btn"><a href="#"  id="likeList2">더보기</a><i class="fas fa-chevron-right"></i></p> --%>
                <div class="container my_review">
                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=1ec32eb6-aac2-4c5a-9e56-9ac1c817afd6" alt="마포 나만의 여행">
                    <div class="desc_wrap">
                        <h4>명동에서 이태원까지 서울의 낭만을...</h4>
                        <p class="review_desc">
                            명동에서 이태원까지는 개화기의 역사를 담은 과거의 낭만과 현재의 세련된 감각이 교차하는 곳이다. 쇼핑하고 즐기기 좋은 명동부터 과거가 돌아온 듯 잘 보존되어 있는 한옥마을과 지금은 젊은 예술인이 마음껏 끼를 펼치는 이태원에서 도시만의 즐거움을 느껴보자.
                        </p>
                    </div>
                </div>
                <div class="container my_review">
                    <img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=1f2173d0-a2ee-4f66-8b89-5ae3baa1b446" alt="마포 나만의 여행">
                    <div class="desc_wrap">
                        <h4>마포 나만의 여행</h4>
                        <p class="review_desc">
                            우리동네 마포구를 소개할 겸 만들어 봤습니다.<br>
                            날씨가 좋은 날 힐링할 수 있었으면 좋겠습니다.
                        </p>
                    </div>
                </div>
                <c:forEach var="BoardVO" items="${__RESULT__}">
                	<div class="container my_review">
                		<img src="https://cdn.visitkorea.or.kr/img/call?cmd=VIEW&id=1ec32eb6-aac2-4c5a-9e56-9ac1c817afd6" alt="마포 나만의 여행">
                		<div class="desc_wrap">
                			<h4>
                				
                				<a href="/board/get?currPage=${ pageMaker.cri.currPage }&bno=${ BoardVO.seq }">${ BoardVO.title }</a>
                			</h4>
                			<p class="desc_wrap">
                				
                				<a href="/board/get?currPage=${ pageMaker.cri.currPage }&bno=${ tBoardVO.seq }">${ BoardVO.content }</a>
                			</p>
                		</div>
                	</div>
                </c:forEach>
                <div id="pagination">
                    <ul>
                        <c:if test="${pageMaker.prev}">
                            <li class="Prev">
                                <a href="/mypage/mypage?currPage=${pageMaker.startPage - 1 }">Prev</a>
                            </li>
                        </c:if>
                        <c:forEach var="pageNum" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                            <li class="pageNum ${pageMaker.cri.currPage == pageNum ? 'current' : ''}">${pageNum}</li>
                        </c:forEach>
                        <c:if test="${pageMaker.next}">
                            <li class="Next">
                                <a href="/mypage/mypage?currPage=${pageMaker.endPage+1}">Next</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
                
            </div>
            <!-- 내 코스 -->
            <div class="my_cont_box my_course">
                <h2>내 코스</h2>
                <p class="more_btn"><a href="#" id="courseBoard">더보기</a><i class="fas fa-chevron-right"></i></p>
                <div class="container">
                    내 코스 영역
                    <ul>
                    	<a href="#" id="MyCourse1"><li> test1</a>
                    	<a href="#" id="MyCourse2"><li> test2</a>
                    	<a href="#" id="MyCourse3"><li> test3</a>
                    	
                    	
                    	
                    </ul>
                    
                    
                    
                </div>
            </div>
			
        </div>
    </div>
    
</div>


<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>

</body>


<script>
    $(function(){
        $('#change_password').click(function(){
            location.href="/member/change_password";
        }); // function change_password;
        $('#likeList1').click(function(){
        	location.href="/board/review/list";
        })	// likeList1
        $('#likeList2').click(function(){
        	location.href="/board/review/list";
        })	// likeList2
        $('#courseBoard').click(function(){
        	location.href="/board/course/list";
        })	// courseBoard
        
        //--------------- page ------------------//
        $('.pageNum').on('click',function(e){
            let selectedPageNum = e.currentTarget.textContent;
            console.log(e.currentTarget.textContent);
            location.href="/mypage/mypage?currPage="+selectedPageNum;
        })  //pageNum
    });    // jq
</script>
</html>


