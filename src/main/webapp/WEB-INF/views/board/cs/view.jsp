<%--
  Created by IntelliJ IDEA.
  User: sungjaehyun
  Date: 2023/05/11
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객센터</title>
    <link rel="stylesheet" href="../../../../resources/static/css/cs/view.css"/>
    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css"/>

    <jsp:include page="../../layout/header.jsp"/>
</head>

<body>
<div class="wrap">

    <div class="left">
        <div class="banner">
            <a href="#"><h3>자주 묻는 질문(FAQ)</h3></a>
        </div>
        <div class="banner">
            <a href="#"><h3>1:1 문의하기</h3></a>
        </div>
        <div class="banner">
            <a href="#"><h3>1:1 문의내역 조회</h3></a>
        </div>
    </div>

    <div class="right">
        <div class="que">
            <div class="banner">
                <h2>문의 작성</h2>
            </div>
            <div class="list">
                <div>
                    <label for="">작성자</label> <input type="text">
                </div>
                <div>
                    <label for="">휴대전화</label> <input type="text">
                </div>
                <div>
                    <label for="">이메일</label> <input type="text">
                </div>
                <div>
                    <label for="">제목</label> <input type="text" placeholder="제목을 입력해주세요.">
                </div>
                <div>
                    <label for="">문의내용</label> <textarea name="" id="que_msg" cols="10" rows="10" placeholder="우선 접수된 문의 건부터 순차적으로 답변을 드리고 있습니다. 문의내용을 상세히 기재해 주시면 더욱 신속히 답변 드릴 수 있습니다. 문의하신 내용에 답변을 위해 전화로 연락을 드릴 수 있습니다."></textarea>
                </div>
                <div class="file_upload">
                    <label for="">사진</label>
                    <div>
                        <button class="upload"></button>
                        <input type="file" class="real-upload" accept="image/*" style="display: none;" required multiple>
                        <ul class="image-preview">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="faq">
            <div class="banner">
                <h2>자주 묻는 질문</h2>
            </div>
            <div class="list"></div>
        </div>
    </div>

    <div class="btn">
        <div class="btn_accent">
            <a href="" onclick=""><button>작성하기</button></a>
        </div>
        <div class="btn_cancel">
            <a href="" onclick=""><button>취소</button></a>
        </div>
    </div>
</div>

</body>

<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>


<script>

    function getImageFiles(e) {
        const uploadFiles = [];
        const files = e.currentTarget.files;
        const imagePreview = document.querySelector('.image-preview');
        const docFrag = new DocumentFragment();


        // 업로드 파일 수가 여러장 이상인 경우 경고 메시지 출력
        if ([...files].length > 1) {
            alert('이미지는 한개씩 업로드 가능합니다.');
            return;
        }

        // 업로드 파일 중 이미지 파일이 아닌 경우 경고 메시지 출력
        for (let i = 0; i < files.length; i++) {
            if (!files[i].type.match("image/.*")) {
                alert('이미지 파일만 업로드 가능합니다.');
                return;
            }
        }

        for (let i = 0; i < files.length; i++) {
            // 업로드 파일 수가 1장 이하인 경우에만 파일 추가
            if (uploadFiles.length < 1) {
                uploadFiles.push(files[i]);
                const reader = new FileReader();
                reader.onload = (e) => {
                    const preview = createElement(e, files[i]);
                    imagePreview.appendChild(preview);
                };
                reader.readAsDataURL(files[i]);
            }
        }
    }

    function createElement(e, file) {
        const li = document.createElement('li');
        const img = document.createElement('img');
        img.setAttribute('src', e.target.result);
        img.setAttribute('data-file', file.name);
        li.appendChild(img);
        return li;
    }

    const realUpload = document.querySelector('.real-upload');
    const upload = document.querySelector('.upload');



    upload.addEventListener('click', () => realUpload.click());

    realUpload.addEventListener('change', getImageFiles);
</script>
</html>
