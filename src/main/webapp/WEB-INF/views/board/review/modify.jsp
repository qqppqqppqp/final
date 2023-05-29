<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD:target/WEB-INF/views/board/free/modify.jsp
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
=======
>>>>>>> origin:src/main/webapp/WEB-INF/views/board/review/modify.jsp
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SEOULLIVE</title>
    <!-- layout css -->
<<<<<<< HEAD:target/WEB-INF/views/board/free/modify.jsp
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/free/list&write.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/layout/layout.css">

    <%-- 제이쿼리 --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>

    <%-- 폰트어썸 --%>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>

    <%-- 자바스크립트 --%>
    <script src="../../../../resources/static/js/free/write&modify.js"></script>

    <%-- 썸머 노트--%>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>



</head>
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
<body>
<!-- <%-- header --%> -->

<div id="container">
    <div class="title_box">
        <h2 class="title">자유게시판</h2>이
    </div>
    <div class="board_write_wrap">
        <form id="frm" class="write-form" action="/board/free/modify" method="post">

            <fieldset class="board_write_box">
                <legend class="hide">게시글 수</legend>
                <div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="category">카테고리 선택</label>
                        </div>
                        <div class="input_box col2">
                            <select name="category">
                                <option <c:if test="${dto.category eq 'category1'}">selected</c:if>  value="category1">카테고리1</option>
                                <option <c:if test="${dto.category eq 'category2'}">selected</c:if> value="category2">카테고리2</option>
                                <option <c:if test="${dto.category eq 'category3'}">selected</c:if> value="category3">카테고리3</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="seq">번호</label>
                        </div>
                        <div class="input_box col2">
                            <input class="b_input" type="text" name="seq" readonly="readonly" value="${dto.seq}">
                        </div>
                    </div>

                    <div class="row">
                        <div class="title_box col1">
                            <label for="title">제목</label>
                        </div>
                        <div class="input_box col2">
                            <input class="b_input" type="text" name="title" value="${dto.title}">
=======
    <!-- layout css -->
    <link rel="stylesheet" href="../../../../resources/static/css/review/list.css">
    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>


    <script src="../../../../resources/static/review/js/review.js"></script>
    <script>
        function chk_form() {
            document.getElementById('frm').submit();
        }
        $(function () {
        $('#deleteBtn').click(function () {
            let formObj = $("form");

            formObj.attr("action", "/board/review/remove");
            formObj.attr("method", "POST");
            formObj.submit();
        });
        });


    </script>

</head>
<body>
<!-- <%-- header --%> -->
<jsp:include page="../../layout/header.jsp"/>

<div id="container">
    <div class="title_box">
        <h2 class="title">리뷰게시판</h2>
    </div>
    <div class="board_write_wrap">
        <form id="frm" action="/board/review/modify" method="post">
            <input type="hidden" name="seq" value="${__BOARD__.seq}">
            <input type="hidden" name="writer" value="${__BOARD__.writer}">
            <fieldset class="board_write_box">
                <legend class="hide">게시글 등록</legend>
                <div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="title">제목</label>
                        </div>
                        <div class="input_box col2">
                            <input class="b_input" type="text" name="title">
>>>>>>> origin:src/main/webapp/WEB-INF/views/board/review/modify.jsp
                        </div>
                    </div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="writer">작성자</label>
                        </div>
<<<<<<< HEAD:target/WEB-INF/views/board/free/modify.jsp
                        <div class="input_box col2">
                            <input class="b_input" type="text" name="writer" value="${dto.writer}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="content">내용</label>
                        </div>
                        <div class="input_box col2">
                                <textarea name="content" cols="30" rows="10">${dto.content}</textarea>
                        </div>
                    </div>
                </div>
            </fieldset>
            <div class="button_wrap">
                <ul class="button_box">
                    <li><a href="#a">영구삭제</a></li>
                    <li><a href="#a">삭제</a></li>
                    <li><a href="#" onclick="return chk_form()">수정</a></li>
                    <li><a href="/board/free/list">목록</a></li>
                </ul>
            </div>
        </form>
=======
                        <div class="input_box col2" style="height: 43px; margin: 11px;">
                            <p>${__BOARD__.writer}</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="title_box col1">
                            <label for="place">장소</label>
                        </div>
                        <div class="input_box col2">
                            <input class="b_input" type="text" name="place">
                        </div>
                    </div>

                    <div class="row">
                        <div class="title_box col1">
                            <label for="content">사진 설명</label>
                        </div>
                        <div class="input_box col2">
                                <textarea name="content" cols="30" rows="10">

                                </textarea>
                        </div>
                    </div>

                </div>
            </fieldset>



            <div class="file_container"></div>
            <div class="file_form">
                <input type="file">
                <span class="text">파일추가</span>
            </div>

            <div class="button_wrap">
                <button type="button" id="deleteBtn">삭제</button>
                <button type="submit" id="writeBtn">작성</button>
                <button type="button" id="listBtn">목록</button>
            </div>

        </form>


>>>>>>> origin:src/main/webapp/WEB-INF/views/board/review/modify.jsp
    </div>



<<<<<<< HEAD:target/WEB-INF/views/board/free/modify.jsp



</div>


<%--<!-- &lt;%&ndash; quickmenu footer&ndash;%&gt;--%>
</body>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>

</html>
=======
    <jsp:include page="../../layout/footer.jsp"/>

</body>

</html>
>>>>>>> origin:src/main/webapp/WEB-INF/views/board/review/modify.jsp
