<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script>
        $(document).ready(function(){

            var regex = new RegExp("(.*?)\.(exe|sh|zip|alz|dmg)$");
            var maxSize = 5242880; //5MB

            function checkExtension(fileName, fileSize) {

                if (fileSize >= maxSize) {
                    alert("파일 사이즈 초과");
                    return false;
                }

                if (regex.test(fileName)) {
                    alert("해당 종류의 파일은 업로드할 수 없습니다.");
                    return false;
                }
                return true;
            }

            var cloneObj = $(".uploadDiv").clone();

            $("#uploadBtn").on("click", function(e) {

                var formData = new FormData();


                var inputFile = $("input[name='uploadFile']");

                var files = inputFile[0].files;

                //console.log(files);

                for (var i = 0; i < files.length; i++) {

                    if (!checkExtension(files[i].name, files[i].size)) {
                        return false;
                    }

                    formData.append("uploadFile", files[i]);

                }



                  $.ajax({
                 url: '/board/free/uploadAjaxAction',
                 processData: false,
                 contentType: false,
                 data: formData,
                 type: 'POST',
                      dataType: 'json',
                 success: function(result){
                 console.log(result);
                 showUploadedFile(result);
                 $(".uploadDiv").html(cloneObj.html());
                 }
                }); //$.ajax


            });
            var uploadResult = $(".uploadResult ul");
            function showUploadedFile(uploadResultArr){

                var str = "";

                $(uploadResultArr).each(function(i, obj){

                    if(!obj.image){

                        var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);

                        str += "<li><a href='/download?fileName="+fileCallPath+"'>"
                            +"<img src='/resources/static/img/attach.png'>"+obj.fileName+"</a></li>"
                    }else{

                        var fileCallPath =  encodeURIComponent( obj.uploadPath+ "/s_"+obj.uuid +"_"+obj.fileName);

                        str += "<li><img src='/display?fileName="+fileCallPath+"'><li>";
                    }
                });

                uploadResult.append(str);

            }
// 6월 7일 3층

        });
    </script>

    <style>
        .uploadResult {
            width: 100%;
            background-color: gray;
        }

        .uploadResult ul {
            display: flex;
            flex-flow: row;
            justify-content: center;
            align-items: center;
        }

        .uploadResult ul li {
            list-style: none;
            padding: 10px;
        }

        .uploadResult ul li img {
            width: 100px;
        }
    </style>
</head>
<body>
<h1>Upload with Ajax</h1>

<div class="uploadDiv">
    <input type="file" name="uploadFile" multiple>
</div>
<div class="uploadResult">
    <ul>

    </ul>
</div>
<button id="uploadBtn">Upload</button>
</body>
</html>
