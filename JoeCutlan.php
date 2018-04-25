<?php
$db_host = 'mysql5'; // Server Name
$db_user = 'fet15024440'; // Username
$db_pass = 'password'; // Password
$db_name = 'fet15024440'; // Database Name

$conn = mysqli_connect($db_host, $db_user, $db_pass, $db_name);
if (!$conn) {
	die ('Failed to connect to MySQL: ' . mysqli_connect_error());	
} //connects to the database

$sql = 'SELECT pname AS Name, dob AS DOB, pemail AS Email, ptelephone AS Telephone, twitter AS Twitter FROM players WHERE pname = "Joe Cutlan"';
		
$query = mysqli_query($conn, $sql);

$sql = 'SELECT image FROM players WHERE pname = "Joe Cutlan"';
		
$query2 = mysqli_query($conn, $sql);

if (!$query) {
	die ('SQL Error: ' . mysqli_error($conn));
} //will output the above query
?>
<html>
<head>
	<title>Displaying MySQL Data in HTML Table</title>
	<style type="text/css">
		body {
			font-size: 15px;
			background-color: #96e253;
			color: #000000;
			font-family: "segoe-ui", "open-sans", tahoma, arial;
			padding: 0;
			margin: 0;
		}
		table {
			margin: auto;
			font-family: "Lucida Sans Unicode", "Lucida Grande", "Segoe Ui";
			font-size: 12px;
		}

		h1 {
			margin: 25px auto 0;
			text-align: center;
			text-transform: uppercase;
			font-size: 25px;
		}
		.title{
			margin: 25px auto 0;
			text-align: center;
			font-size: 20px;
			}

		table td {
			transition: all .5s;
		}
		
		/* Table */
		.data-table {
			border-collapse: collapse;
			font-size: 12px;
			min-width: 340px;
			text-align: center;
		}

		.data-table th, 
		.data-table td {
			border: 1px solid #387701;
			padding: 10px 10px;
		}
		.data-table caption {
			margin: 7px;
		}

		/* Table Header */
		.data-table thead th {
			background-color: #62a334;
			color: #FFFFFF;
			border-color: #387701 !important;
			text-transform: uppercase;
		}

		/* Table Body */
		.data-table tbody td {
			color: #000000;
			background-color: #ffffff;
			text-align: left;
		}
		.data-table tbody td:first-child,
		.data-table tbody td:nth-child(4),
		.data-table tbody td:last-child {
			text-align: centre;
		}
		
 <!-- This is the styling of the table -->

	</style>
</head>
<body>
	<h1>Cardiff & District</h1>
	<table class="data-table">
		<caption class="title">Joe Cutlan</caption>
		<tbody bgcolor="#ffffff"> 
		<?php
		
		while ($row = mysqli_fetch_array($query))
		{
			echo '<tr>
					<td><b>NAME: </b>'.$row['Name'].'</td>
					</tr>
					<td><b>DOB: </b>'.$row['DOB'].'</td>
					</tr>
					<td><b>EMAIL: </b>'.$row['Email'].'</td>
					</tr>
					<td><b>TELEPHONE: </b>'.$row['Telephone'].'</td>
					</tr>
					<td><b>TWITTER: </b>'.$row['Twitter'].'</td>
				</tr>'; //Inputs the correct data from the database into the table

		}?>
		
		<?php
	while ($row = mysqli_fetch_array($query2))
{
	echo"<tr>";
	echo"<th>";
	echo '<img src="data:image/jpeg;base64,'.base64_encode($row['image']).' "height="300" width="320" />';
	echo "</th>";
	echo"</tr>";
}
	?>
		</tbody>

	</table>
</body>
</html>