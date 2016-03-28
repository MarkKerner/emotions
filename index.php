<!DOCTYPE html>
<?php
require_once("backend/connect.php");
$conn = establish();

?>
<html >
  	<head>
	    <meta charset="UTF-8">
	    <title>Double ring</title>   
	 	<link rel="stylesheet" href="css/style.css">   
  	</head>
	<body id="bg">
		<div id="menu-container">
			<div id="menu-bg"></div>
			<div id="menu"></div>
		</div>

		<div id="profile-container">
			<div id="profile-picture"></div>

			<div id="love" class="emotion-container deg135">
				<div class="hoja"></div>
				<div class="emotion-name noselect">love</div>
			</div>

			<div id="happiness" class="emotion-container deg207">
				<div class="hoja"></div>
				<div class="emotion-name">happiness</div>
			</div>

			<div id="anger" class="emotion-container deg279">
				<div class="hoja"></div>
				<div class="emotion-name">anger</div>
			</div>

			<div id="satisfaction" class="emotion-container deg351">
				<div class="hoja"></div>
				<div class="emotion-name">satisfaction</div>
			</div>

			<div id="sadness" class="emotion-container deg63">
				<div class="hoja"></div>
				<div class="emotion-name">sadness</div>
			</div>
		</div>

	<script src="js/background-color-toggle.js"></script>
  	</body>
</html>
<?php
mysqli_close($conn);
?>