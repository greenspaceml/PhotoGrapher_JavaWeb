<%-- 
    Document   : home
    Created on : Mar 16, 2020, 13:58:38 PM
    Author     : green
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="css/font.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="menu" data-page="Menu"></div>    
        <%@ include file="header.jsp" %>
        <div class="container">
            <div class="content">

                <div class="main-content">

                    <div class="intro">
                        <img class="intro-image" src="${information.image}">
                        <i>${information.sortAbout}</i>
                    </div>

                    <div class="view-gallery">

                        <c:forEach var="g" items="${listGalleriesInPage}">
                            <div class="gallery-card">

                                <img class="image-card" src="${g.image}">

                                <div class="content-card">
                                    <a href="gallery?gid=${g.id}&pageIndex=1">View ${g.name}</a>
                                    <p>${g.description}</p>
                                </div>

                            </div>
                        </c:forEach>

                    </div>


                    <div class="paging">

                        <c:forEach var="i" begin="1" end="${NumOfPage}"  step="1">
                            <c:if test="${i == curentPage}">
                                <div class="curent">
                                    <a class="curent" id="${i}">${i}</a>
                                </div>

                            </c:if>

                            <c:if test="${i != curentPage}">
                                <div>
                                <a id="${i}" href="?pageIndex=${i}">${i}</a>
                                </div>
                            </c:if>

                        </c:forEach>
                    </div>





                    <div class="about-me">

                        <div class="about-title">
                            About me
                        </div>

                        <p>
                            ${information.about}
                        </p>

                    </div>

                </div>

                <%@ include file="sharing.jsp" %>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
