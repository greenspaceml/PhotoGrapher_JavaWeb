<%-- 
    Document   : header
    Created on : Mar 16, 2020, 13:58:38 PM
    Author     : green
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
        <script src="js/activeTitle.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="header">

            <div class="navitigator">
                <div class="navi-bar">

                    <a id="front"  class="navi-text" href="front">
                        <div class="navi-item">My front page</div>
                    </a>

                    <c:forEach var="gi" items="${list3HeaderGalleries}">
                        <a id="gallery${gi.id}" class="navi-text" href="gallery?gid=${gi.id}&pageIndex=1">
                            <div class="navi-item">${gi.name}</div>
                        </a>
                    </c:forEach>

                    <a id="contact" class="navi-text" href="contact">
                        <div class="navi-item">Contact</div>
                    </a>

                </div>
            </div>

            <div class="title-header">
                <div class="title-content">
                    <div class="logo">
                        <img src="image/logo.PNG"/>
                    </div>

                    <div class="title-web">
                        <div class="name-web">
                            <a class="name" >PHOTOGRAPHER</a>
                        </div>

                        <div class="sub-title">
                            Welcome to this website
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <script>
            setBold();
        </script>
    </body
</html>
