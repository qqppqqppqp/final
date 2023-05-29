// 프로필 사진 미리보기
function setThumbnail(event) {
    var reader = new FileReader();

    reader.onload = function (event) {
        var img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        document.querySelector("div#image_container").appendChild(img);
    };

    reader.readAsDataURL(event.target.files[0]);
}

// 리스트 펼치기
$('.selection_item').each(function () {
    $(this).click(function () {
        $(this).toggleClass('on');
    });
});
$('.selection_list').each(function () {
    $(this).children('li').click(function (event) {
        const value = $(this).children().text();

        $('input[name=gender]').attr('value', value);
        $(this).parent().prev().text(value);
        $(this).parent().prev().removeClass('on');
    });
});


// 회원가입 유효성 검사
var pwCheck = /^[A-Za-z0-9\d@$!%*?&]{10,20}$/;
var nickCheck = /^[가-힣]{2,12}$/;
var mailCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
var birthCheck = /^(19|20)[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;

// 이메일
$('#email').blur(function() {
    if (mailCheck.test($(this).val())) {
        console.log(mailCheck.test($(this).val()));
        $('#emailError').text('');
    } else {
        $('#emailError').text('이메일을 확인해주세요');
        $('#emailError').css('color', 'red');
    }
});
// 암호
$('#password').blur(function() {
    if (pwCheck.test($(this).val())) {
        console.log(pwCheck.test($(this).val()));
        $('#pwError').text('');
    } else {
        $('#pwError').text('암호는 영문/숫자/특수문자 10자 이상 20자 이하로 입력해주세요');
        $('#pwError').css('color', 'red');
    }
});
// 암호 체크
$('#password_check').blur(function() {
    if ($('#password').val() === $('#password_check').val()) {
        $('#pwError').text('');
    } else {
        $('#pwError').text('암호가 일치하지 않습니다');
        $('#pwError').css('color', 'red');
    }
});
// 생년월일
$('#birthDate').blur(function() {
    if (birthCheck.test($(this).val())) {
        console.log(birthCheck.test($(this).val()));
        $('#birthError').text('');
    } else {
        $('#birthError').text('생년월일을 8자로 입력해주세요');
        $('#birthError').css('color', 'red');
    }
});
// 성별
$('#gender').blur(function() {
    if ($(this).val() === '') {
        $('#birthError').text('성별을 선택해주세요');
        $('#birthError').css('color', 'red');
    } else {
        $('#birthError').text('');
    }
});
// 닉네임
$('#nickName').blur(function() {
    if (nickCheck.test($(this).val())) {
            console.log(nickCheck.test($(this).val()));
            $('#nickError').text('');
    } else {
        $('#nickError').text('닉네임은 2-12자 이내로 입력해주세요');
        $('#nickError').css('color', 'red');
    }
});
// 가입 클릭시
var terms = document.getElementById('terms');
$('#join_btn').click(function(){
    // 성별
    if ($('#gender').val() === '') {
        $('#genderError').text('성별을 선택해주세요');
        $('#genderError').css('color', 'red');
    }
    // 약관
    if($('#terms').is(':checked') === false) {
        $('#termsError').text('약관에 동의해주세요');
        $('#termsError').css('color', 'red');
    } else {
        $('#termsError').text('');
    }
});