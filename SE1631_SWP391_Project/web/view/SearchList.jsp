<%-- 
    Document   : SettingList
    Created on : Sep 25, 2022, 7:43:10 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Subject List</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="${pageContext.request.contextPath}/assets/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/assets/css/sb-admin.css" rel="stylesheet">


        <style>
            .advanced-search{
                display: flex;
/*                flex-direction: row;
                flex-wrap: wrap;
                margin: 5px;*/
                width: 1500px;
                margin-bottom: 10px;
                
                /*                justify-content: space-between;*/
            }
            .advanced-search label{
                font-weight: bold;
                color: #333;
            }

            .setting-pagination{
                display: flex;
                justify-content: center;
                margin-top: 20px;

            }
            .page-link:hover{
                color : white !important;
            }

            .advanced-search .advanced-search-item{
                flex-basis: 32%;
            }
            .advanced-search .first{
            }
            .advanced-search .second{
                margin-left: 20px;
            }
            .advanced-search .three{
                margin-left: -60px;

            }
            .advanced-search .four{
                margin-top: -38px;
                margin-left: 90%;
            }
            .advanced-search-submit{
                display: flex;
                /*                justify-content: center;*/
                margin-top: 10px;
                margin-bottom: 10px;
            }
           
            
            .advanced-search button{
                padding-bottom: 5px;
                margin-top: 31px;
                height: 38px;
                
            }
            
            .csw-btn-button {
                cursor: pointer;
                font-size: 16px;
                padding: 5px 12px;
                color: white;
                border-radius: 12px;
                background:orange ;
                border: 1px solid #9B6A1D;
                transition: 0.4s;
            }
            .csw-btn-button:hover {
                background: #292929;
                border-radius: 15px;
            }

            @media (max-width: 900px){
                .advanced-search .advanced-search-item{
                    flex-basis: calc(50% - 50px);
                }
            }
            @media (max-width: 600px){
                .advanced-search .advanced-search-item{
                    flex-basis: 100% !important;
                }
            }
        </style>


    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="/WebApplication2/Home.jsp">S-Course</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-bell fa-fw"></i>
                        <span class="badge badge-danger">9+</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-envelope fa-fw"></i>
                        <span class="badge badge-danger">7</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-circle fa-fw"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Settings</a>
                        <a class="dropdown-item" href="#">Activity Log</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/WebApplication2/Home.jsp" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Pages</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        <h6 class="dropdown-header">System List:</h6>
                        <a class="dropdown-item" href="/WebApplication2/admin/setting">Setting List</a>
                        <a class="dropdown-item" href="register.html">User List</a>
                        <div class="dropdown-divider"></div>
                        <h6 class="dropdown-header">System Detail:</h6>
                        <a class="dropdown-item" href="../../assets/blank.html">Setting Detail</a>
                        <a class="dropdown-item" href="404.html">404 Page</a>
                        <a class="dropdown-item" href="blank.html">Blank Page</a>
                    </div>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">Subject List</li>
                    </ol>

                    <!--Form search-->
                    <form action = "Search" method="GET">
                        <div class="advanced-search">
                            <div class = "advanced-search-item secondd" id="search-1">
                                <label for="type" class="mr-sm-2">Filter by Manager</label>
                                <select style="width: 200px" class="form-control" id="type" name = "Manager">
                                    <option value="" disabled selected hidden>Manager</option>
                                    <c:forEach items="${user}" var="u">
                                        <option value = "${u.userId}">${u.getFullname()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class = "advanced-search-item secondd" id="search-1">
                                <label for="type" class="mr-sm-2">Filter by Expert</label>
                                <select style="width: 200px" class="form-control" id="type" name = "expert">
                                    <option value="" disabled selected hidden>Expert</option>
                                    <c:forEach items="${manager}" var="m">
                                        <option value = "${m.userId}">${m.getFullname()}</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class = "advanced-search-item secondd" id="search-2">
                                <label for="status">Filter by Status</label>
                                <select style="width: 200px" class="form-control" id="status" name = "status">
                                    <option value="" disabled selected hidden>Status</option>
                                    <option value = "1">Active</option>
                                    <option value = "0">Inactive</option>
                                </select>
                            </div>
                            <div class = "advanced-search-item secondd" id="search-3">
                                <label for="title" class="mr-sm-2">Search by Title</label>
                                <input style="width: 230px" type="text" class="form-control" name ="txt"  id="title" placeholder="Enter subject code or name" >
                            </div>
                            
                            <div class = "advanced-search" id="search-4">
                                <button style="margin-left: 10px" class="btn btn-danger" type="submit">Search</button>
                            </div>
                        </div>
                    </form>
                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Subject List</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class = "bg-warning">
                                            <th style="text-align: center" scope="col">
                                                <span onclick="sort(${requestScope.sortId})">ID </span>                      
                                            </th>
                                            <th style="text-align: center" scope="col">
                                                <span> Subject code </span>
                                                <!--                        <div>
                                                                                <i class="fa fa-sort-alpha-asc" aria-hidden="true"></i>
                                                                                <i class="fa fa-sort-alpha-desc" aria-hidden="true"></i>
                                                                            </div>-->
                                            </th>
                                            <th style="text-align: center" scope="col">
                                                <span> Subject name</span>
                                            </th>
                                            <th style="text-align: center" scope="col">
                                                <span> Manager</span>
                                            </th>
                                            <th style="text-align: center" scope="col">
                                                <span> Expert</span>
                                            </th>
                                            <th style="text-align: center" scope="col">
                                                Status
<!--                                                <span style="cursor: pointer" onclick ="sort(${requestScope.sortStatus})">Status <i class="fa fa-sort" aria-hidden="true"></i></span>-->
                                            </th>
                                            <!--                        <th scope="col">Valid from</th>
                                                                    <th scope="col">Valid to</th>-->
                                            <th style="text-align: center" scope="col">
                                                Detail
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listSubjects}" var="l">
                                            <tr>
                                                <td>${l.getSubjectId()}</td>
                                                <td>${l.getSubjectCode()}</td>
                                                <td>${l.getSubjectName()}</td>
                                                <td>${l.getManagerId()}</td>    
                                                <td>${l.getExpertId()}</td>
                                                <c:if test="${l.getStatus() eq false}">
                                                    <td style="text-align: center" id="change">
                                                        <button name="Inactive" type="button" onchange="switchStatus()" style="width: 75px; border-radius: 8px; background-color: #B22222;  color: white;">Inactive</button>
                                                    </td>
                                                </c:if>
                                                <c:if test="${l.getStatus() eq true}">
                                                    <td style="text-align: center" id="change">
                                                        <button name="Active" type="button" onchange="switchStatus()" style="width: 75px; border-radius: 8px; background-color: #006400;  color: white;">Active</button>
                                                    </td>
                                                </c:if>
                                                <td style="text-align: center">
                                                    <button type="button" onclick="location.href = '/SE1631_SWP391_Project/view/SubjectDetail.jsp';" class="csw-btn-button" >Edit</button>
                                                </td>         
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <!-- This is pagination -->
                                <div class = "setting-pagination">
                                    <ul class="pagination" id = "paggerBottom">
                                        <c:forEach begin="1" end="${endP}" var="i">
                                            <a class="page-link" href="Search?index=${i}&txt=${search}">${i}</a>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © Your Website 2019</span>
                        </div>
                    </div>
                </footer>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables/jquery.dataTables.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="${pageContext.request.contextPath}/assets/js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="${pageContext.request.contextPath}/assets/js/demo/datatables-demo.js"></script>
        <script>
         
        </script>
    </body>
</html>

