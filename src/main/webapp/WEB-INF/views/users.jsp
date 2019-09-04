<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap Toggle Switch -->
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Font Roboto 400, 500, 700 and 900-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap" rel="stylesheet">

    <!-- Styles -->
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/dashboard.css">
    <link rel="stylesheet" href="/resources/css/users.css">
    <link rel="stylesheet" href="/resources/css/toggle-switch.css">

    <title>Users</title>
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
                    <h3>All Users</h3>
                    <button class="btn-blue btn-adduser" data-toggle="modal" data-target="#exampleModal">+ Add user</button>
                    <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
                </div>

                <div class="dashboard-body">
                    <table class="table table-borderless">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Status</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Email</th>
                            <th scope="col">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>
                                        <div class="table-profile-picture">
                                            <img src="/resources/icons/profile-pic.png" alt="Profile picture">
                                        </div>
                                        <div class="table-profile-text">
                                            <p class="table-name">${user.getFirstName()}</p>
                                            <p>Parent</p>
                                        </div>
                                    </td>
                                    <td><p class="txt-green">${user.getStatus()}</p></td>
                                    <td>${user.getPhoneNumber()}</td>
                                    <td>${user.getEmail()}</td>
                                    <td>
                                        <ul class="list-actions">
                                            <a href="/user/update/view?id=${user.getId()}">
                                                <li>
                                                    <img src="/resources/icons/edit-user-icon.png" alt="Edit user icon ">
                                                </li>
                                            </a>
                                            <li>
                                                <label class="switch">
                                                    <input type="checkbox">
                                                    <span class="slider round"></span>
                                                </label>
                                            </li>
                                            <a href="/user/delete?id=${user.getId()}">
                                                <li>
                                                    <img src="/resources/icons/delete-icon.png" alt="Delete user icon">
                                                </li>
                                            </a>
                                        </ul>
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

<!--Add user Modal-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">X</span>
                </button>

                <div class="wrapper-modal-body">
                    <h4>ADD USER</h4>
                    <form class="modal-form" method="POST" action="/user">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="text" name="firstName" placeholder="FIRST NAME" value="${user.firstName}">
                            </div>
                            <div class="col-md-6">
                                <input type="text" name="lastName" placeholder="LAST NAME" value="${user.lastName}">
                            </div>
                            <div class="col-md-7">
                                <input type="email" name="email" placeholder="EMAIL ADDRESS" value="${user.email}">
                            </div>
                            <div class="col-md-5">
                                <select name="accountType" id="" value="${user.accountType}">
                                    <option value="0">SELECT ACCOUNT TYPE</option>
                                    <option value="1">ADMIN</option>
                                    <option value="2">EMPLOYEE</option>
                                    <option value="3">OWNER</option>
                                    <option value="4">PARENT</option>
                                    <option value="5">STUDENT</option>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <input type="text" name="addressLine1" placeholder="ADDRESS LINE 1" value="${user.addressLine1}">
                            </div>
                            <div class="col-md-6">
                                <input type="text" name="addressLine2" placeholder="ADDRESS LINE 2" value="${user.addressLine2}">
                            </div>
                            <div class="col-md-12">
                                <button class="btn-blue" type="submit">ADD USER</button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

<!-- Bootstrap Toggle Switch -->
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js" async></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>