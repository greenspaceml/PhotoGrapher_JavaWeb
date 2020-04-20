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
        <title>Contact us</title>
        <link href="css/contact.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="container">
            <div class="content">
                <div class="main-content">

                    <h1 class="spacing">Contact</h1>
                    
                    <h1>PHOTOGRAPHER</h1>

                    <div class="info-contact">

                        <div class="address">
                            <table>
                                <tr>
                                    <td class="title-name">Address:</td>
                                    <td  class="info">${contact.address}</td>
                                </tr>
                                <tr>
                                    <td class="title-name">City:</td>
                                    <td  class="info">${contact.city}</td>
                                </tr>
                                <tr>
                                    <td class="title-name">Country:</td>
                                    <td  class="info">${contact.country}</td>
                                </tr>
                            </table>
                        </div>

                        <div>
                            <table>
                                <tr>
                                    <td class="title-name">Tel:</td>
                                    <td  class="info">${contact.phone}</td>
                                </tr>

                                <tr>
                                    <td class="title-name">Email:</td>
                                    <td class="info">${contact.email}</td>
                                </tr> 
                            </table>
                        </div>


                        <div class="map">
                            <img src="${contact.image}">
                        </div>    

                    </div>
                </div>
                <%@ include file="sharing.jsp" %>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
    </body>
</html>
