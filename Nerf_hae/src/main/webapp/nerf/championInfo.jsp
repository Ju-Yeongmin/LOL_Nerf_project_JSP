<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>챔피언 통계 - 너프점해</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="./img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="./lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="./lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="./css/style.css" rel="stylesheet">
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
    $(window).on('load', function() {
        setTimeout(function(){
            $("#waiting").fadeOut();
        }, 300);
    }); // 로딩 대기 화면(안될수도있음)
    
</script>
	<script type="text/javascript">
		$(document).ready(function(){
			if ( $('#param_ym').val() == "jug" ) {
				$('#top').css('color','#FFFFFF')
				$('#jug').css('color','#EB1616')
				$('#mid').css('color','#FFFFFF')
				$('#adc').css('color','#FFFFFF')
				$('#sup').css('color','#FFFFFF')
			} else if ( $('#param_ym').val() == "mid" ) {
				$('#top').css('color','#FFFFFF')
				$('#jug').css('color','#FFFFFF')
				$('#mid').css('color','#EB1616')
				$('#adc').css('color','#FFFFFF')
				$('#sup').css('color','#FFFFFF')
			} else if ( $('#param_ym').val() == "adc" ) {
				$('#top').css('color','#FFFFFF')
				$('#jug').css('color','#FFFFFF')
				$('#mid').css('color','#FFFFFF')
				$('#adc').css('color','#EB1616')
				$('#sup').css('color','#FFFFFF')
			} else if ( $('#param_ym').val() == "sup" ) {
				$('#top').css('color','#FFFFFF')
				$('#jug').css('color','#FFFFFF')
				$('#mid').css('color','#FFFFFF')
				$('#adc').css('color','#FFFFFF')
				$('#sup').css('color','#EB1616')
			} else {
				$('#top').css('color','#EB1616')
				$('#jug').css('color','#FFFFFF')
				$('#mid').css('color','#FFFFFF')
				$('#adc').css('color','#FFFFFF')
				$('#sup').css('color','#FFFFFF')
			}
		});
	
	
	</script>
	    
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
      


            <!-- Table Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    
                    <!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
                    <div class="col-sm-12 col-xl-6" style="margin-left: auto; margin-right: auto; width: 60%">
                        <div class="bg-secondary rounded h-100 p-4">
                        
                            <h6 class="mb-4" style="font-size: 1.5em; padding-top: 10px; padding-bottom: 10px; padding-left: 10px;" >
                            	<a href="./ChampionInfo.hae?category=top" id="top" style="color: #EB1616;" >Top</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                            	<a href="./ChampionInfo.hae?category=jug" id="jug" style="color: #FFFFFF;" >Jungle</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                            	<a href="./ChampionInfo.hae?category=mid" id="mid" style="color: #FFFFFF;" >Mid</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                            	<a href="./ChampionInfo.hae?category=adc" id="adc" style="color: #FFFFFF;" >ADcarry</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                            	<a href="./ChampionInfo.hae?category=sup" id="sup" style="color: #FFFFFF;" >Supporter</a>
                            	<input type="hidden" value="${param.category }" id="param_ym">
                            	<button type="button" class="btn btn-outline-danger m-2" style="margin-left: 16rem !important;"
                            	onclick="location.href='./ChampionUpdate.hae';">업데이트</button>
                            </h6>
                            
                            <table class="table table-dark">
                                <thead>
                                    <tr>
                                        <th scope="col" width="10%">#</th>
                                        <th scope="col" width="30%">챔피언</th>
                                        <th scope="col" width="15%">티어</th>
                                        <th scope="col" width="15%">승률</th>
                                        <th scope="col" width="15%">픽률</th>
                                        <th scope="col" width="15%">밴률</th>
                                    </tr>
                                </thead>
                                
                                <c:choose>
                                	<c:when test=""></c:when>
                                </c:choose>
                                
                               
                                <tbody>
                                
                                	<c:set var="i" value="1"></c:set>
                                	<c:choose>
	                                    <c:when test="${param.category.equals('jug') }">
		                                	<c:forEach var="vo" items="${jugChampionInfo}">
			                                    <tr>
			                                        <th scope="row">${i }</th>
			                                        <td><a href="./ChampionDetail.hae" style="color: #FFFFFF">
			                                        	<img src="${vo.c_image }" width="25px">
			                                        	&nbsp;&nbsp;${vo.c_name }
			                                        </a></td>
			                                        <td>${vo.c_tier }</td>
			                                        <td>${vo.c_winrate }</td>
			                                        <td>${vo.c_pickrate }</td>
			                                        <td>${vo.c_banrate }</td>
			                                    </tr>
			                                    <c:set var="i" value="${i+1 }"></c:set>
		                                    </c:forEach>
	                                    </c:when>
	                                    
	                                    <c:when test="${param.category.equals('mid') }">
		                                	<c:forEach var="vo" items="${midChampionInfo}">
			                                    <tr>
			                                        <th scope="row">${i }</th>
			                                        <td><a href="./ChampionDetail.hae" style="color: #FFFFFF">
			                                        	<img src="${vo.c_image }" width="25px">
			                                        	&nbsp;&nbsp;${vo.c_name }
			                                        </a></td>
			                                        <td>${vo.c_tier }</td>
			                                        <td>${vo.c_winrate }</td>
			                                        <td>${vo.c_pickrate }</td>
			                                        <td>${vo.c_banrate }</td>
			                                    </tr>
			                                    <c:set var="i" value="${i+1 }"></c:set>
		                                    </c:forEach>
	                                    </c:when>
	                                    
	                                    <c:when test="${param.category.equals('adc') }">
		                                	<c:forEach var="vo" items="${adcChampionInfo}">
			                                    <tr>
			                                        <th scope="row">${i }</th>
			                                        <td><a href="./ChampionDetail.hae" style="color: #FFFFFF">
			                                        	<img src="${vo.c_image }" width="25px">
			                                        	&nbsp;&nbsp;${vo.c_name }
			                                        </a></td>
			                                        <td>${vo.c_tier }</td>
			                                        <td>${vo.c_winrate }</td>
			                                        <td>${vo.c_pickrate }</td>
			                                        <td>${vo.c_banrate }</td>
			                                    </tr>
			                                    <c:set var="i" value="${i+1 }"></c:set>
		                                    </c:forEach>
	                                    </c:when>
	                                    
	                                    <c:when test="${param.category.equals('sup') }">
		                                	<c:forEach var="vo" items="${supChampionInfo}">
			                                    <tr>
			                                        <th scope="row">${i }</th>
			                                        <td><a href="./ChampionDetail.hae" style="color: #FFFFFF">
			                                        	<img src="${vo.c_image }" width="25px">
			                                        	&nbsp;&nbsp;${vo.c_name }
			                                        </a></td>
			                                        <td>${vo.c_tier }</td>
			                                        <td>${vo.c_winrate }</td>
			                                        <td>${vo.c_pickrate }</td>
			                                        <td>${vo.c_banrate }</td>
			                                    </tr>
			                                    <c:set var="i" value="${i+1 }"></c:set>
		                                    </c:forEach>
	                                    </c:when>
	                                    
	                                    <c:otherwise>
	                                    	<c:forEach var="vo" items="${topChampionInfo}">
			                                    <tr>
			                                        <th scope="row">${i }</th>
			                                        <td><a href="./ChampionDetail.hae" style="color: #FFFFFF">
			                                        	<img src="${vo.c_image }" width="25px">
			                                        	&nbsp;&nbsp;${vo.c_name }
			                                        </a></td>
			                                        <td>${vo.c_tier }</td>
			                                        <td>${vo.c_winrate }</td>
			                                        <td>${vo.c_pickrate }</td>
			                                        <td>${vo.c_banrate }</td>
			                                    </tr>
			                                    <c:set var="i" value="${i+1 }"></c:set>
		                                    </c:forEach>
	                                    </c:otherwise>
                                    </c:choose>
                                       
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
                </div>
            </div>
            <!-- Table End -->
           
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="./lib/chart/chart.min.js"></script>
    <script src="./lib/easing/easing.min.js"></script>
    <script src="./lib/waypoints/waypoints.min.js"></script>
    <script src="./lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="./lib/tempusdominus/js/moment.min.js"></script>
    <script src="./lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="./lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="./js/main.js"></script>
</body>

</html>