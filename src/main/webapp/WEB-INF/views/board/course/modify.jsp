<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>modify</title>

    <style>
        #wrapper {
            width: 1024px;

            margin: 0 auto;

            font-family: D2Coding;
            font-size: 16px;
        }
        table {
            width: 60%;
            font-weight: bold;
        }

        textarea {
            font-size: 15px;
        }
        #submitBtn {
            width: 80px;
            height: 30px;
            border: 0;

            font-size: 15px;
            font-weight: bold;
            color: white;
            background-color: rgb(107, 159, 232);
            cursor: pointer;
        }

        .buttons {
            padding: 20px;
            text-align: center;
        }

        #listBtn {
            width: 80px;
            height: 30px;
            border: 0;

            font-size: 15px;
            font-weight: bold;
            color: white;
            background-color: rgb(138, 138, 198);
            cursor: pointer;
        }

        #removeBtn {
            width: 80px;
            height: 30px;
            border: 0;

            font-size: 15px;
            font-weight: bold;
            color: white;
            background-color: rgb(4, 218, 197);
            cursor: pointer;
        }

    </style>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js" ></script>

    <script>
        $(function () {
            $('#listBtn').click(function() {
                // 게시판 목록으로 이동 : GET 방식이면서 /board/list로 이동
                location.href = "/board/course/list?currPage=${param.currPage}";

                console.log('list Button Clicked ..')
            }); //onclick

            // 동기방식으로 POST 요청전송을 보내려면
            $('#removeBtn').click(function() {
                // 게시판 삭제요청 : POST 방식이면서 /board/remove로 이동
                // 전송파라미터: 1. bno

                let formObj = $("form");

                // formObj.attr(name, value); 액션 속성과 method 속성 고쳐야 함
                formObj.attr("action", "/board/course/remove"); //BoardControllerTests에서 어디로 보낼지 확인 가능
                formObj.attr("method", "POST");
                // bno와 currPage 값을 추가하여 전송
                $("<input>").attr({
                    type: "hidden",
                    name: "seq",
                    value: "${__BOARD__.SEQ}"
                }).appendTo(formObj);

                $("<input>").attr({
                    type: "hidden",
                    name: "currPage",
                    value: "${param.currPage}"
                }).appendTo(formObj);

                // form 전송
                formObj.submit();

                // 문제는 전송파라미터임, 이를 어떻게 지정하는가?
                //form tag의 bno는 날라가고 있으므로 만질게 없음

            }); //onclick



        }); //.jq

    </script>
</head>
<body>

<code>
    <!-- 공유속성명 == EL변수명 -->
    <!-- ${__BOARD__} -->
</code>

<div id="wrapper">

    <!-- 전송파라미터 보내려고 form 태그로 table 태그를 감쌈 -->
    <form action="/board/course/modify" method="POST">
        <!-- 타입이 hidden이면 무조건 전송파라미터용 -->
        <!-- 글번호는 전송파라미터 보냄 -->
        <input type="hidden" name="seq" value="${__BOARD__.SEQ}">
        <input type="hidden" name="writer" value="${__BOARD__.WRITER}">

        <!-- 제목은 화면에 렌더링되어야 함 => hidden이면 안 됨 -->
        <!-- 사용자가 수정가능하게 해 줘야 하므로 text 타입-->
        <!-- <input type="text" name="title" value="${__BOARD__.TITLE}"> -->

        <!-- 최초 등록일시, 최종수정일시(current_date 함수로 들어감)는 안 보내도 됨 -->

        <!-- 내용은 이미 textarea로 감싸고, readonly가 아니라 수정 가능해야 함 -->

        <!-- 버튼은 -->
        <table>
            <tr>
                <td>글번호</td>
                <td>${__BOARD__.SEQ}</td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>${__BOARD__.WRITER}</td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" name="title" value="${__BOARD__.TITLE}" size="70"></td>
            </tr>
            <tr>
                <td>최초등록일시</td>
                <td>${__BOARD__.WRITE_DATE}</td>
            </tr>

            <tr>
                <td>내용</td>
                <td><textarea cols="60" rows="10" name="TOTAL">${__BOARD__.TOTAL}</textarea></td>
            </tr>
            <tr>
                <td>기간 시작</td>
                <td><textarea cols="15" rows="1" name="duration_start">${__BOARD__.DURATION_START}</textarea></td>
            </tr>
            <tr>
                <td>기간 종료</td>
                <td><textarea cols="15" rows="1" name="duration_end">${__BOARD__.DURATION_END}</textarea></td>
            </tr>

            <tr>
                <td colspan="2" class="buttons">
                    <!-- submit 타입 = 폼이 날라감 => 이벤트 처리할 필요X -->
                    <button type="submit" id="submitBtn">SUBMIT</button>
                    <!-- POST 방식이라 얘를 처리해줘야 함 -->
                    <button type="button" id="removeBtn">REMOVE</button>
                    <button type="button" id="listBtn">LIST</button>
                </td>
            </tr>
        </table>

    </form>

</div>
</body>
</html>