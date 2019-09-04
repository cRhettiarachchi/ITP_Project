<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Font Roboto 400, 500, 700 and 900-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap" rel="stylesheet">

    <!-- Styles -->
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/dashboard.css">

    <title>Payment Details</title>
</head>
    <body>
        <div class="section">
            <div class="container-fluid">
                <div class="row">
                    <div class="left-panel">
                        <div class="wrapper-profile">
                            <div class="profile-picture">
                                <img src="/resources/icons/profile-pic.png" alt="Profile picture">
                            </div>
                            <div class="profile-text">
                                <h5>John Peter</h5>
                                <p>Parent</p>
                            </div>
                            <div class="profile-notification">
                                <img src="/resources/icons/notification-icon.png" alt="Notification Icon">
                            </div>
                        </div>

                        <div class="wrapper-menu">
                            <ul>
                                <a href="dashboard.html"><li class="active"><img src="/resources/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
                                <a href=""><li><img src="/resources/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
                                <a href=""><li><img src="/resources/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
                                <a href="users.html"><li><img src="/resources/icons/users-icon.png" alt="Users Icon">Users</li></a>
                                <a href="all-promotions.html"><li><img src="/resources/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
                                <a href="payment-details.html"><li><img src="/resources/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
                                <a href=""><li><img src="/resources/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
                                <a href=""><li><img src="/resources/icons/support-icon.png" alt="Support Icon">Support</li></a>
                            </ul>
                        </div>

                        <div class="wrapper-help">
                            <a href=""><img src="/resources/icons/help-icon.png" alt="Help icon">Help</a>
                        </div>
                    </div>
                    <div class="right-panel">
                        <div class="wrapper-body">
                            <h3>Dashboard</h3>
                            <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
                        </div>

                        <div class="dashboard-body">
                            <table class="table table-borderless">
                                <thead>
                                    <tr>
                                        <th scope="col">Transaction ID</th>
                                        <th scope="col">Payment type</th>
                                        <th scope="col">Amount</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Invoice</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="payment" items="${payments}">
                                    <tr>
                                        <td><p>${payment.getPayment_token()}</p></td>
                                        <td><p>${payment.getPaymentMethod()}</p></td>
                                        <td><p>Rs.${payment.getAmount()}</p></td>
                                        <td>
                                            <p class = "txt-green">${payment.getStatus()}</p>
                                        </td>
                                        <td>
                                            <a href = "#"><img src = "/resources/icons/download.png" alt = "download invoice icon" class = "download-invoice"></a>
                                        </td>
                                    </tr>
                                 </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
