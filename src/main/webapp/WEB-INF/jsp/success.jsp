<%@page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>下载文件</title>
</head>
<body>
    <div>
        <label><a href="${pageContext.request.contextPath}download?filename=${sessionScope.filepath}/${sessionScope.filename} ">${sessionScope.filepath}/${sessionScope.filename}</a> </label>
        <button id="download">下载</button>
    </div>


</body>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">

    var button =document.getElementById("download");
    var filename=document.getElementsByTagName("a")[0].textContent;
    button.onclick=function(){

            $.ajax({
                url:'download',
                type:'post',
                data:{'filename':filename},
                success:function(){
                    console.log("suceess");
                },
                error:function(){
                    console.log("error")
                }
            });


    }
</script>
</html>