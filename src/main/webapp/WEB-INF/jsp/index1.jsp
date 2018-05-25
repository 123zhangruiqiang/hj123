<%@page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>数据比对工具</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <style>
        @media (min-width: 768px) {
            #nav{
                width: 250px;
                margin-top: 51px;
                position: absolute;
                z-index: 1;
                height:100%;

            }
        }

        .icon{
            margin-right: 5px
        }
        #sub{
            margin-left: 35px;
            text-align: left;
        }
        .page_main{
            margin-left: 255px;
        }

    </style>
</head>
<body>

<div >
    <nav class="navbar navbar-default navbar-static-top">
        <div class="navbar-header">
            <a href="" class="navbar-brand">数据比对工具</a>
            <button class="btn btn-default navbar-brand pull-right"><span class="glyphicon glyphicon-search"></span></button>
        </div>
        <div class="toolbar">
            <ul class="nav" id="nav">

                <li><a href="#sub"  data-toggle="collapse"><span  class="icon  glyphicon glyphicon-th-list"></span>基础数据检查</a>
                    <ul id="sub" class="nav collapse">
                        <li><a href="#"><span class="icon glyphicon glyphicon-paperclip"></span>借款人数据</a></li>
                        <li><a href="#"><span class="icon glyphicon glyphicon-paperclip"></span>标的数据</a></li>
                        <li><a href="#"><span class="icon glyphicon glyphicon-paperclip"></span>还款数据</a></li>
                        <li><a href="#"><span class="icon glyphicon glyphicon-paperclip"></span>出借数据</a></li>
                        <li><a href="#"><span class="icon glyphicon glyphicon-paperclip"></span>投资人数据</a></li>
                        <li><a href="#"><span class="icon glyphicon glyphicon-paperclip"></span>代偿数据</a></li>
                        <li><a href="#"><span class="icon glyphicon glyphicon-paperclip"></span>平台数据</a></li>
                    </ul>
                </li>
                <li><a href=""> lanmugadasdg</a></li>
                <li><a href="">sfdfadafsdfaf</a></li>
                <li><a href="">sfafdsfasdf</a></li>
            </ul>
        </div>

    </nav>
    <div class="page_main">

        <div class="panel">
            <div id="matter1">
                <form action="${pageContext.request.contextPath}/index" id="subform">
                    <button id="subtn" class="btn btn-default btn-primary" style="margin-top: 5px;margin-left: 5px;">平台数据校对</button>
                </form>
               <%-- <h3 id="title">一共有${fn:length(list)}个平台,必要字段缺失的有个</h3>--%>
                <div class="tb pre-scrollable" style="margin-top: 5px">
                    <table class="table table-bordered ">
                        <tr>
                            <th>序号</th>
                            <th>平台编号</th>
                            <th>平台名称</th>
                            <th>法人</th>
                            <th>法人证件号</th>
                            <th>省</th>
                            <th>市</th>
                            <th>区</th>
                        </tr>

                        <c:forEach items="${list}" var="platform_base_info" varStatus="id">
                            <tr>
                                <td>${id.index+1}</td>
                                <td>${platform_base_info.platform_no}</td>
                                <td>${platform_base_info.platform_name}</td>
                                <td>${platform_base_info.legal}</td>
                                <td>${platform_base_info.id_card_no}</td>
                                <td>${platform_base_info.provience}</td>
                                <td>${platform_base_info.district}</td>
                                <td>${platform_base_info.city}</td>
                            </tr>


                        </c:forEach>



                    </table>
                </div>
            </div>
        </div>

    </div>

</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" >

    /*var form =document.getElementById("subform");
    form.submit();*/

  /*  $(document).ready(
        function(){

            var temp="none";

            $("#li1").click(function(){
                showpage(1)
            });

            $("#li1").click(function(){
                showpage(1)
            });
            $("#li1").click(function(){
                showpage(1)
            });
            $("#li1").click(function(){
                showpage(1)
            });
            $("#li1").click(function(){
                showpage(1)
            });
            $("#li1").click(function(){
                showpage(1)
            });
            $("#li1").click(function(){
                showpage(1)
            });

            function showpage(obj){
                for(var i=1;i<10;i++){
                    if(i==obj){
                        temp="block";
                    }else{
                        temp="none";
                    }
                }

                document.getElementById("matter"+i).style.display=temp;
            }


        }



    )*/
  /*  $.ajax({
        url:'/index',
        type:'GET',
        dataType:'text',
        success:function(data){
            alert('success');
        },
        error:function(){
            alert('error');
        }

    });
*/
   /* $('#subtn').click(function(){

    });*/

</script>
</html>
