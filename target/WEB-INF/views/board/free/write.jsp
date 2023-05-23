<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SEOULLIVE</title>
    <!-- layout css -->
    <link rel="stylesheet" href="../../../../resources/static/css/free/list&write.css">
    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>

</head>
<jsp:include page="../../layout/header.jsp"/>
<body>
<!-- <%-- header --%> -->

<div id="container">
    <div class="title_box">
        <h2 class="title">자유게시판</h2>
    </div>
    <div class="board_write_wrap">
        <form action="" method="">
            <fieldset class="board_write_box">
                <legend class="hide">게시글 등록</legend>
                <div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="category">카테고리 선택</label>
                        </div>
                        <div class="input_box col2">
                            <select name="category" id="">
                                <option value="category1">카테고리1</option>
                                <option value="category2">카테고리2</option>
                                <option value="category3">카테고리3</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="title">제목</label>
                        </div>
                        <div class="input_box col2">
                            <input class="b_input" type="text" name="title" id="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="author">작성자</label>
                        </div>
                        <div class="input_box col2">
                            <input class="b_input" type="text" name="author" id="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="title_box col1">
                            <label for="content">내용</label>
                        </div>
                        <div class="input_box col2">
                                <textarea name="content" id="" cols="30" rows="10">

                                </textarea>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>


    <div class="button_wrap">
        <ul class="button_box">
            <li><a href="#a">영구삭제</a></li>
            <li><a href="#a">삭제</a></li>
            <li><a href="#a">수정</a></li>
            <li><a href="freeBoard.html">목록</a></li>
        </ul>
    </div>



</div>


<%--<!-- &lt;%&ndash; quickmenu footer&ndash;%&gt;--%>
</body>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>

</html>