<%-- 
    Document   : home
    Created on : Mar 16, 2020, 1:01:17 AM
    Author     : green
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Gallery</title>
        <link href="css/gallery.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="container">
            <div class="content">
                <div class="main-content">

                    <c:if test="${empty errReporter}">

                        <h1>${gallery.name}</h1>

                        <div class="image-slide">

                            <img id="showingImage" src="${gallery.imageList[0]}" alt=""/>

                        </div>



                        <div class="detail-gallery">

                            <c:forEach var="i" items="${gallery.imageList}">

                                <div onclick="ActiveImage('${i}')"  class="image">

                                    <img class="image-small" src="${i}">
                                </div>


                            </c:forEach>

                        </div>





                        <div class="paging">


                            <c:forEach var="i" begin="1" end="${NumOfPage}"  step="1">

                                <c:if test="${i == curentPage}">
                                    <div class="curent">
                                        <a id="${i}">${i}</a>
                                    </div>
                                </c:if>

                                <c:if test="${i != curentPage}">

                                    <div>
                                        <a id="${i}" href="?gid=${gallery.id}&pageIndex=${i}">${i}</a>
                                    </div>
                                </c:if>

                            </c:forEach>

                        </div>



                    </c:if>

                    <c:if test="${not empty errReporter}">

                        <div class="noti">
                            <p>${errReporter}</p>
                        </div>

                    </c:if>    

                </div>
                <%@ include file="sharing.jsp" %>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
    <script src="js/activeImage.js" type="text/javascript"></script>
</html>
