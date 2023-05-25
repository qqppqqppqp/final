
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>find_id</title>

    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="/resources/static/css/layout/reset.css">
    <!-- layout css -->
    <link rel="stylesheet" href="/resources/static/css/layout/header.css">
    <link rel="stylesheet" href="/resources/static/css/layout/footer.css">
    <!-- main css -->
    <link rel="stylesheet" href="/resources/static/css/layout/main.css">
    <link rel="stylesheet" href="https://kit.fontawesome.com/889f069cfd.css" crossorigin="anonymous">

    <link rel="stylesheet" href="css/course_write_copy.css">
    

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/889f069cfd.js" crossorigin="anonymous"></script>

  
</head>

<body>
    <div id="header">
        <div class="wrap">
            <h1 class="logo">
                <a href="#"><img src="/resources/static/img/img-logo.png" width="240" height="60"></a>
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
<style>
    #main{
        width: 1200px;
        height: 1px;
        /* border: 1px solid black; */
    
        /* position:relative; */
        /* float:none; */
        /* flex: auto; */
        justify-content: center;
        /* display:block; */
        display:flex;
        align-items: center;
        align-content: center;
        position: relative;
    }
    #other{
        position: relative;
        width:20%;
        height:450px;
        justify-content: center;
        display:inline-flex;
        /* align-items: center; */
        /* align-content: center; */
        /* border:1px dotted red; */
    }
    #other>div{
        position: relative;
        /* background-color :aqua */
    }
    #mainBloack{
        position: relative;
        height:450px;
        width:70%;
        border:1px solid grey;
        justify-content: center;
        display:inline-flex;
        background-color: FFFFFF

    }
    #maindBloack>div{
        position: relative;
    }
    #mainBloack>div>div{
        position: relative;
        display:flex;
        /* justify-content: center; */
        align-items: center;
        align-content: center;
        width: 80%;
        height:9.5%;
        /* border:1px solid orange; */
    }
    #block{
        position: relative;
        width: 100%;
        /* background-color: aliceblue; */
    }
    form,input,label{
        position: relative;
        height: 30px;
    }
    #inputType1,#inputType2{
        /* background-color:#eee; */
        position: relative;
        width: 200px;
        height: 30px;
    }

    #send1{
        position: relative;
        width:70px;
        font-size: large;
    }
    #send2{
        position: relative;
        width:70px;
        font-size: large;
    }
    .power1, .power2{
        position: block;
        /* justify-content: center; */
        font-size: large;

    }
    #sel{
        height: 30px;
        width:200px;
        font-size: large;
    }
    #returnHome{
        justify-content: center;
    }
    #returnHome>button{
        position: relative;
        width: 200px;
        height: 30px;
        font-size: large;
    }
</style>

<!-- ===================================================================================== -->
<section>
    <div id ="test">
        
    </div>

    <div id="container">
        
        <form action="#" method="get">
            <div id="main">
             <div id="other">
                 <div></div>
             </div>
             <div id="mainBloack">
                 <div id="block">
                     <div></div>
                     <div></div>
                     <div></div>
                     <div class="power1">
                         <form action="#" id="form1" onsubmit="return false" method="get" >
                             <label for="">이메일
                                <input id="inputType1" type="user_id" size="15">
                                
                                <select name="선택해주세요" id="sel">
                                    <option value="">선택해주세요</option>
                                    <option value="gmail.com">gmail.com</option>
                                    <option value="kakao">kakao.com</option>
                                    <option value="kakao">naver.com</option>
                                </select>
                                <button id="send1">전송</button>
                                <!-- <input id="inputType2" type="submit" value="전송"> -->
                             </label> 
                         </form>
                     </div>
                     <div id="submitResult1"></div>
                     <!-- <div>인증번호를 전송하였습니다./ 인증번호 발송에 실패하였습니다.</div> -->
                     <div class="power2">
                         <form action="#" method="get" id="form2" onsubmit="return false">
                             <label for="">이메일 인증 번호 확인 
                                <input id="inputType2" type="password"> 
                                <button id="send2">인증</button>
                                <!-- <input id="inputType2" type="submit" value="인증"> -->
                            </label>
                         </form>
                     </div>
                     <div id="submitResult2"></div>
                     <!-- <div id="check">인증에 성공하였습니다. / 인증번호가 일치하지 않습니다.</div> -->
                     <div></div>
                     <div></div>
                     <div id="returnHome"><button type="button" onclick="location.href='https://www.naver.com'"> 확인</button></div>
                     
                     
                 </div>
             </div>
             <div id="other">
                 <div></div>
             </div>
            </div>
         </form>
    </div>
</section>

<div>
<script>
   var send1 = document.getElementById("send1");
   let passqq = "intelinger";
   send1.addEventListener("click",function abc(){
    var form1 = document.getElementById("form1");
    var id = document.getElementById("inputType1").value;
    
    
    if(passqq != id){
        document.getElementById("submitResult1").innerText = "인증번호 발송에 실패하였습니다.";
        document.getElementById("submitResult1").style.color="red";
    }else{
        document.getElementById("submitResult1").innerText = "인증번호를 전송하였습니다.";
        document.getElementById("submitResult1").style.color="black";
    } // end if-else

}); // end send.addEventListener 

    var send2 = document.getElementById("send2");
    let passpw = 000000;
    send2.addEventListener("click",function def(){
        var form2 = document.getElementById("form2");
        var pw = null;
        var pw = document.getElementById("inputType2").value;

        if( pw === null){
            document.getElementById("submitResult2").innerText = "인증번호가 일치하지 않습니다.";
            document.getElementById("submitResult2").style.color="red";
        }
        if(passpw == pw){
            document.getElementById("submitResult2").innerText = "인증에 성공하였습니다.";
            document.getElementById("submitResult2").style.color="black";
         }else{
            document.getElementById("submitResult2").innerText = "인증번호가 일치하지 않습니다.";
            document.getElementById("submitResult2").style.color="red";
        } // end if-else
    });

</script>
</div>



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
                    <a href="#a"><img src="/resources/static/img/img-footer-logo.png" /></a>
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