
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">

<head>
  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>find_id_complete</title>

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
        display:flex;
        align-items: center;
    }
    #other{
        width:20%;
    }
 
    #mainBloack{
        height:450px;
        width:70%;
        border:1px solid grey;
        display:flex;
    }

    #block{
        width: 100%;
    }
    #block>#fisrt,#bottom,#top{
        display:flex;
        height: 50px; 
    }
    #left, #right{
        width: 20%;
        border:1px purple solid;
    }
    #SubBox{
        height:50px;
    }
    #MainBox{
        justify-content: center;
        align-items: center;
        display: flex;
        height: 250px;
        border:1px solid red;
    }

    form,input,label{
        height: 30px;
    }
    #FindId{
        font-weight: bolder;
        font-size:larger;
    }
    #buttonBox1{
        display: flex;
        /* justify-content: center; */
        /* width : 200px;  */
        
    }
    #buttonBox1>div{
        /* width:100px; */
        /* height:200px; */
    }
    #buttonblock{
        /* width:100px; */
    }
    #button{
        width:100px;
        height: 100px;
        /* padding:30px 50px; */
    }

    
</style>

<script>
	$(function(){
		$('#find_password').click(function(){
			location.href = "/member/find_password";
			/* ?email=${__BOARD__.email} */
		}); // onclick
	});	//jq
</script>

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
                <div id="left">

                </div>
                 <div id="block">
                    <div id="top"></div>
                     <div class="pp"></div>
                     <div id="first" class="pp"></div>
                     <div id="FindId" class="pp">이메일 찾기</div>
                     <div><button disabled></button></div>
                     <div>고객님의 정보와 일치하는 이메일입니다.</div>
                     
                     <div id="MainBox">
                        <div id="Box">${__BOARD__.email}</div>
                        <table>
                            <tr>
                                <td> </td>
                                <td> </td>
                                <td> </td>
                            </tr>
                            <tr>
                                <td> </td>
                                <td> </td>
                                <td> </td>

                            </tr>
                        </table>
                        <div id="Box">가입일 ${__BOARD__.join_date}</div>
                     </div>
                     <div id="SubBox"></div>
                     <div class="pp"></div>
                     <div id="buttonBox1">
                        <div><button type="button" onclick="location.href='https://www.naver.com'">로그인</button></div>
                        <div id="buttonblock"><button disabled></button></div>
                        <div><button type="button" id="find_password" >비밀번호 찾기</button></div>
                    </div>
                     <div id="bottom"></div>

                     
                 </div>
                 <div id="right">

                 </div>
             </div>
             <div id="other">
                 <div></div>
             </div>
            </div>
         </form>
    </div>
</section>




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
