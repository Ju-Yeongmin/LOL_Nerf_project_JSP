<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>${param.summonerID }님의 전적</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
 
    
</head>

<body>
    <div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->
		



        <!-- Content Start -->
        <div class="content">
        <a href="./Nerf.hae" class="navbar-brand mx-4 mb-3">
	                    <h3 class="text-primary" style="font-size: calc(4rem + .6vw); padding-left: 70px; letter-spacing: 20px;">Nerf.hae</h3>
	            </a>
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
                <form class="d-none d-md-flex ms-4" style="margin-top: 10px; margin-bottom: 10px; height: 50px" action="./FightRecord.hae" >
                    <input class="form-control bg-dark border-0" type="search" placeholder="소환사명" style="width:400px;" name="summonerID">
					<button type="submit" class="btn btn-primary ms-2" style="width: 70px" >검색</button>
                </form>
            </nav>
		<div class="col-sm-12 col-xl-6">
		<div class="container-fluid pt-4 px-4">
                        <div style="width: 1220px;" class="bg-secondary rounded h-100 p-4 col-12">
<!--                             <h6 class="mb-4">Testimonial</h6> -->
                            <div class="owl-carousel testimonial-carousel">
                                <div class="testimonial-item">
                                    <img class="img-fluid" src="img/profileicon/${icon }.png" style="width: 128px; height: 128px; display: inline; float: left; ">
                                    <div style="padding: 1px 6px; margin-left: 140px; margin-bottom: 0px; margin-right: 946px;" class="alert alert-dark" role="alert">
                                		레벨:${level }
                            		</div>
                                   	<span style="text-align: left; padding-left: 10px; font-size: 30px; font-weight: bold; line-height: 52px;">${param.summonerID }</span>
                                   	<br>
                                    <button type="button" style="margin-top: 18px; margin-left:12px;" class="btn btn-sm btn-primary" onclick="location.href='./updateMatch.hae?name=${param.summonerID}'">전적 갱신</button>
                                </div>
                               
                            </div>
                        </div>
                    </div>
                    </div>
		
            <!-- Recent Sales Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0" style="width:100%;">
                            <thead>
                                <tr class="text-white">
                                    <th style="vertical-align:middle;text-align:center;">승 </th>
                                    <th scope="col" style="font-size:11px;">챔피언  </th>
                                    <th scope="col" style="vertical-align:middle; text-align:center; padding:2px;">타입 </th>
                                    <th scope="col" style="vertical-align:middle; text-align:center; padding:0px;">KDA </th>
                                    <th scope="col" style="vertical-align:middle; text-align:center; padding:0px;">킬관여 </th>
                                    <th scope="col" style="font-family: arial; font-size: 11px; vertical-align: middle; text-align: center;width: 50px;padding: 0px;">S/R</th>
                                    <th scope="col" style="width: 134px; vertical-align:middle; text-align:center;">팀 </th>
                                    <th scope="col" style="width: 110px; vertical-align:middle; text-align:center;">아이템 </th>
                                    <th scope="col" style="vertical-align:middle; text-align:center;">레벨/골드/CS</th>
                                    <th scope="col" style="vertical-align:middle; text-align:center; padding:0px;">경기시간 </th>
                                    <th scope="col" style="vertical-align:middle; text-align:center; padding:0px; ">와드 </th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="m" items="${mList }">
                                <tr>
                                    <td style="vertical-align:middle;text-align:center;">
                                    <c:if test="${m.win eq 'true' }">승</c:if>
                                    <c:if test="${m.win eq 'false' }">패</c:if>
                                    </td>
                                    <td class="recent_td recent_champ" style="\vertical-align:middle; text-align:center; width:52px; padding:0px;">
                                    <div style="position:relative; width:100%; height:100%;">
										<img src="img/champion/${m.champs.split(',')[m.u_num] }.png" alt="챔피언" width="48" height="48">
										<div style="position:absolute; width:48px; height:14px; bottom:0px; left:2px; text-align:center; background-color:black; filter:alpha(opacity=80); -moz-opacity:0.8; opacity: 0.8; color:white; font-size:12px;">
											<b>${m.champs.split(',')[m.u_num] }</b>
										</div>
									</div>
									</td>
                                    
                                    <td style="vertical-align:middle; text-align:center; padding:2px;">
                                    <c:if test='${m.queueid==400 }'>일반 교차</c:if>
                                    <c:if test='${m.queueid==420 }'>랭크</c:if>
                                    <c:if test='${m.queueid==430 }'>일반</c:if>
                                    <c:if test='${m.queueid==440 }'>자유 랭크</c:if>
                                    <c:if test='${m.queueid==450 }'>칼바람</c:if>
                                    <c:if test='${m.queueid==700 }'>격전</c:if>
                                    <c:if test='${799 < m.queueid and m.queueid < 851 }'>봇전</c:if>
                                    <c:if test='${m.queueid==900 }'>우르프</c:if>
                                    <c:if test='${m.queueid==920 }'>포로왕</c:if>
                                    <c:if test='${m.queueid==1020 }'>단일 모드</c:if>
                                    <c:if test='${m.queueid==1300 }'>돌격 넥서스</c:if>
                                    <c:if test='${m.queueid==1400 }'>궁 주문서</c:if>
                                    <c:if test='${1999 < m.queueid and m.queueid < 2021 }'>솔로 랭크</c:if>
                                    </td>
                                    <td style="vertical-align:middle; text-align:center; padding:0px;">
                                    평점 
                                    <c:if test="${m.kda.split(',')[1]!=0 }">
                                    <fmt:formatNumber value="${(m.kda.split(',')[0]+m.kda.split(',')[2])/m.kda.split(',')[1]}" pattern=".0"/>
                                    </c:if>
                                    <c:if test="${m.kda.split(',')[1]==0 }">
                                    <span style="font-size:15px" class="bg-primary text-white">Perfect!</span>
                                    </c:if>
                                    <br>
                                    ${m.kda.split(',')[0] }/${m.kda.split(',')[1] }/${m.kda.split(',')[2] }</td>
                                    <td style="vertical-align:middle; text-align:center; padding:0px;">${((m.kda.split(',')[0]+m.kda.split(',')[2])/m.team_kills*100).toString().substring(0,2)}%</td>
                                    <td style="font-family: arial; font-size: 11px; vertical-align: middle; text-align: center;width: 28px;padding: 0px;">
                                    <img width="20" src="img/summoner_spell/${m.spells.split(',')[0] }.png">
                                    <img width="20" src="img/perks/${m.primary_perks.split(',')[0] }.png"><br>
                                    <img width="20" src="img/summoner_spell/${m.spells.split(',')[1] }.png">
                                    <img width="20" src="img/perks/${m.sub_perks.split(',')[0] }.png">
                                    </td>
                                    <td>
                                    <div>
                                    <c:set var="i" value="0" />
                                    <c:forEach var="c" items="${m.champs.split(',')}" begin="0" end="4" step="1">
                                    	<c:if test="${!(m.champs.split(',')[m.u_num] eq c) }">
                                    	<img src="img/champion/${c}.png" width="20">
                                    	<c:set var="i" value="1" />
                                    	</c:if>
                                    </c:forEach>
                                    </div>
                                    <c:forEach var="c" items="${m.champs.split(',')}" begin="5" end="9" step="1">
                                    <c:if test="${!(m.champs.split(',')[m.u_num] eq c)}">
                                    <img src="img/champion/${c}.png" width="20">
                                    </c:if>
                                    </c:forEach>
                                    </td>
                                    <td>
                                    <img src="img/item/${m.items.split(',')[0] }.png" width="20">
                                    <img src="img/item/${m.items.split(',')[1] }.png" width="20">
                                    <img src="img/item/${m.items.split(',')[2] }.png" width="20">
                                    <img src="img/item/${m.items.split(',')[6] }.png" width="20">
                                    <br>
                                    <img src="img/item/${m.items.split(',')[3] }.png" width="20">
                                    <img src="img/item/${m.items.split(',')[4] }.png" width="20">
                                    <img src="img/item/${m.items.split(',')[5] }.png" width="20">
                                    <img class="show_new_build tipsy_live" alt="빌드 보기" src="img/item/detail.png" width="20" style="cursor:pointer;">
                                    </td>
                                    <td style="vertical-align:middle; text-align:center; padding:0px; ">
                                    레벨 ${m.level }<br>
                                    <b>골드 ${m.gold }</b><br>
                                    CS ${m.cs } (${Math.round(m.cs / (m.playtime/1000/60) )})</td>
                                    <td style="vertical-align:middle; text-align:center; padding:0px; ">
                                    <fmt:parseNumber var="minute" value="${m.playtime/1000/60}" integerOnly="true"/>
                                    <fmt:parseNumber var="second" value="${m.playtime/1000%60}" integerOnly="true"/>
                                    ${minute }분 ${second }초
                                    <br>
                                    ${m.time }
                                    </td>
                                    
                                    <td style="vertical-align:middle; text-align:center; padding:0px; ">
                                    <img src="img/item/2055.png" width="20"> ${m.d_ward }<br>
                                    ${m.ward_kp.split(',')[0] } / ${m.ward_kp.split(',')[1] } 
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                
                <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0"></h6>
                        <a href="">더보기 </a>
                    </div>
            </div>


            <!-- Widgets Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-12 col-md-6 col-xl-4">
                        <div class="h-100 bg-secondary rounded p-4">
                            <div class="d-flex align-items-center justify-content-between mb-2">
                                <h6 class="mb-0">Messages</h6>
                                <a href="">Show All</a>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-3">
                                <img class="rounded-circle flex-shrink-0" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h6 class="mb-0">Jhon Doe</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                    <span>Short message goes here...</span>
                                </div>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-3">
                                <img class="rounded-circle flex-shrink-0" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h6 class="mb-0">Jhon Doe</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                    <span>Short message goes here...</span>
                                </div>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-3">
                                <img class="rounded-circle flex-shrink-0" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h6 class="mb-0">Jhon Doe</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                    <span>Short message goes here...</span>
                                </div>
                            </div>
                            <div class="d-flex align-items-center pt-3">
                                <img class="rounded-circle flex-shrink-0" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h6 class="mb-0">Jhon Doe</h6>
                                        <small>15 minutes ago</small>
                                    </div>
                                    <span>Short message goes here...</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6 col-xl-4">
                        <div class="h-100 bg-secondary rounded p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">Calender</h6>
                                <a href="">Show All</a>
                            </div>
                            <div id="calender"></div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-6 col-xl-4">
                        <div class="h-100 bg-secondary rounded p-4">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h6 class="mb-0">To Do List</h6>
                                <a href="">Show All</a>
                            </div>
                            <div class="d-flex mb-2">
                                <input class="form-control bg-dark border-0" type="text" placeholder="Enter task">
                                <button type="button" class="btn btn-primary ms-2">Add</button>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-2">
                                <input class="form-check-input m-0" type="checkbox">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span>Short task goes here...</span>
                                        <button class="btn btn-sm"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-2">
                                <input class="form-check-input m-0" type="checkbox">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span>Short task goes here...</span>
                                        <button class="btn btn-sm"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-2">
                                <input class="form-check-input m-0" type="checkbox" checked>
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span><del>Short task goes here...</del></span>
                                        <button class="btn btn-sm text-primary"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center border-bottom py-2">
                                <input class="form-check-input m-0" type="checkbox">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span>Short task goes here...</span>
                                        <button class="btn btn-sm"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex align-items-center pt-2">
                                <input class="form-check-input m-0" type="checkbox">
                                <div class="w-100 ms-3">
                                    <div class="d-flex w-100 align-items-center justify-content-between">
                                        <span>Short task goes here...</span>
                                        <button class="btn btn-sm"><i class="fa fa-times"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Widgets End -->


            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="#">Your Site Name</a>, All Right Reserved. 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By <a href="https://htmlcodex.com">HTML Codex</a>
                            <br>Distributed By: <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>