<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>롤 전적 검색 - 너프점해</title>
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
</head>

<body>
		<!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

        <!-- Content Start -->
        <div class="content" style="width: 580px; margin-top: 300px; margin-left: auto; margin-right: auto;">
        
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
            <!-- Navbar End -->
       		
       		<br>
            <div align="center">
           		<a href="./ChampionInfo.hae" style="font-size: 20px; letter-spacing: 5px">
            		챔피언 통계
            	</a> 
            </div>
				          
        </div>
        <!-- Content End -->


    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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