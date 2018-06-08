
<%@page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>
<div>
    <form action="" enctype="multipart/form-data" id="form">
        <input type="file" name="file" >
        <input type="button" id="button" value="点击上传">
    </form>
</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">

    var button =document.getElementById("button");
    button.onclick=function(){
        var form=document.getElementById("form");
        var formdata=new FormData(form);
        $.ajax({

            type:'post',
            url:'dofileupload',
            data:formdata,
            cache:false,
            processData:false,
            contentType:false,
            success:function(result){
                alert(result);
                window.location.href="${pageContext.request.contextPath}success";
            },
            error:function(){
                alert("error");
            }



        });
    }
</script>
</html>
