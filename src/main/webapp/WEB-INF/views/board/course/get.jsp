<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
    

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course_View</title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/course/courseView.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout/layout.css">


    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/js/course/courseComm.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/889f069cfd.js" crossorigin="anonymous"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js" ></script>

    <script>
       /* $(function () {
            $('.boardList').click(function() {
                console.clear();

                location = "/board/course/list"

                console.log('List Button Clicked ..')
            });

        }); //.jq*/

    </script>

</head>
<body>
    <jsp:include page="../../layout/header.jsp" />


<div class="plan_page">
    <div class="plan_cover">
        <div class="cover_img"><img src="https://picsum.photos/id/1081/600/400"></div>
        <div class="cover_bottom">
            <div class="cover_bleft">
                <div class="plan_title">${__BOARD__.TITLE}</div>
                <div class="plan_datetheme">
                    <div class="plan_user">${__BOARD__.WRITER}</div>
                    <div class="plan_date">${__BOARD__.DURATION_START}-${__BOARD__.DURATION_END}</div>
                    <div class="clear"></div>
                </div>
            </div>

            <div class="title_function">
                <div class="url_setClipboard">
                    <a href="#" id="copyBtn" title="" style="cursor:pointer;">
                        <i class="fas fa-share-nodes"></i>URL 복사
                    </a>
                </div>
                <div class="buddyBtn">
                    <a href="#"><i class="fas fa-user"></i></a>팔로우
                </div>
                <button id="myButton">
                    <a href="#"><i id="myIcon" class="fa-regular fa-heart"></i></a>
                </button>
            </div>


            <div class="cover_bright">
                <span>${__BOARD__.REVIEW}</span>
            </div>
        </div>
    </div>


    <div class="plan_mnu_box">
        <div class="plan_mnu">일정표</div>
        <div class="plan_mnu_line"></div>
        <div class="plan_mnu">댓글</div>
    </div>

    
	<c:set var="lastIndex" value="${__COURSETRAVELBOARD__.size() - 1}" />
	<c:set var="travelId" value="${__COURSETRAVELBOARD__[lastIndex].TRAVEL_ID}" />

	<c:set var="underscoreIndex" value="${travelId.indexOf('_')}" />
	<c:set var="extractedValue" value="${travelId.substring(0, underscoreIndex)}" />
    <c:forEach begin="1" end="${extractedValue}" varStatus="loop">
    	<%-- 반복문 내에서 loop.index 또는 loop.count 등을 사용하여 반복 처리 --%>
  		<%-- 예: 현재 반복의 인덱스를 출력 --%>
  		<%-- <p>반복 인덱스: ${loop.index}</p> --%>
	    
	    <div class="wrap_planpage1">
	
	        <!-- day 박스 -->
	        <div class="planpage_day">
	            <div class="planpage_daytxt">
	                Day${loop.count}
	            </div>
	        </div>

	        <div class="planpage_title">${__BOARD__.DURATION_START}</div>
	        <div class="planpage_daytitle"></div>
	
	        <div class="planpage_course1">
	            <c:forEach var="courseTravelVO" items = "${__COURSETRAVELBOARD__}">
		            <c:choose>
	    				<c:when test="${courseTravelVO.TRAVEL_ID.substring(0, 1) == loop.count}">
		<%--                <div class="planpage_couse1pic"><img src="${courseTravelVO.LINK}"></div>--%>
		
			                <div class="planpage_course1txt">
			                        ${courseTravelVO.TITLE} / ${courseTravelVO.CATEGORY}
			                </div>
			                <div class="planpage_course1review">${courseTravelVO.USER_REVIEW}</div>
	               		</c:when>
	                </c:choose>
	            </c:forEach>
	
	        </div>
	     </div>
	</c:forEach>
</div>
        <!-- 맵 -->
        <div class="map">
            <%--            <img src="/img/맵사진.PNG" alt="map">--%>
            <h3>map</h3>
        </div>


        <!-- 댓글 -->
        <div class="comm_page">
            <div class="comm">
                <div class="comm_list">댓글(${__COMMENT_LIST__.size()})</div>
                <div class="comm_write">
	                <form action="/board/course/comm_write" method="post">
	                    <div class="comm_writecontent">
	                        <input type="text" name="content" placeholder="댓글을 입력해주세요." 
	                               size="20" style= "width: 960px; height: 100px;">
	                        <input type="hidden" name="seq" value="${__BOARD__.seq}">
	                        <input type="submit" class="comm_regbutton" value="등록"
	                               style="width:50px; height:50px; background: #49539E; border:none " >
	                    </div>
	                </form>
                
                </div>
                <div class="comments">
	                <c:forEach var="commVO" items = "${__COMMENT_LIST__}">
	                    <div class="comm_user_info">
	                        <div class="comm_userpic"><a href="#"><img src="${pageContext.request.contextPath}/resources/static/img/로고.png"></a> </div>
	                        <div class="comm_usercomminfo">
	
	                            <div class="comm_username">${commVO.writer}</div>
	                            <div class="comm_usercommtime">${commVO.write_date}</div>
	                            <div class="comm_usercommtxt">${commVO.content}</div>
	                        </div>
	                    </div>
					</c:forEach>
				</div>
			</div>
		</div>


                    <form id='operForm' action="/board/course/modify" method="get">
                        <input type="hidden" id="seq" name="seq"
                               value="${__BOARD__.seq}">
                    </form>


                    <div class="getContainer">
                    	<form action="/board/course/list" method="get">
                        	<div class="boardList">
                        		<button type="submit" class="boardList">list</button>
                        	</div>
                        </form>
                        <form action="/board/course/modify" method="get">
                        	<div class="viewModify">
                        		<input type="hidden" name="seq" value="${__BOARD__.seq}">
                        		<input type="submit" class="viewModify" value="modify">
                        	</div>
                        </form>
                    </div>





    <jsp:include page="../../layout/footer.jsp" />
</body>
</html>