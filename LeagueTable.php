<?php
$db_host = 'mysql5'; // Server Name
$db_user = 'fet15024440'; // Username
$db_pass = 'password'; // Password
$db_name = 'fet15024440'; // Database Name

$conn = mysqli_connect($db_host, $db_user, $db_pass, $db_name);
if (!$conn) {
	die ('Failed to connect to MySQL: ' . mysqli_connect_error());	
} //connects to the database

$sql = 'SELECT
  tname AS Team, Sum(P) AS P,Sum(W) AS W,Sum(D) AS D,Sum(L) AS L,
  SUM(F) as F,SUM(A) AS A,SUM(GD) AS GD,SUM(Pts) AS Pts
FROM(
  SELECT
    hteam Team,
    1 P,
    IF(hscore > ascore,1,0) W,
    IF(hscore = ascore,1,0) D,
    IF(hscore < ascore,1,0) L,
    hscore F,
    ascore A,
    hscore-ascore GD,
    CASE WHEN hscore > ascore THEN 3 WHEN hscore = ascore THEN 1 ELSE 0 END PTS
  FROM games
  UNION ALL
  SELECT
    ateam,
    1,
    IF(hscore < ascore,1,0),
    IF(hscore = ascore,1,0),
    IF(hscore > ascore,1,0),
    ascore,
    hscore,
    ascore-hscore GD,
    CASE WHEN hscore < ascore THEN 3 WHEN hscore = ascore THEN 1 ELSE 0 END
  FROM games
) as tot
JOIN teams t ON tot.Team=t.id
GROUP BY Team
ORDER BY SUM(Pts) DESC, SUM(GD) DESC, SUM(F) DESC';
		
$query = mysqli_query($conn, $sql);

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
			min-width: 420px;
		}

		.data-table th, 
		.data-table td {
			border: 1px solid #387701;
			padding: 12px 10px;
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
			text-align: center;
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
		<caption class="title">Mens Football League Table</caption>
		<thead>
			<tr>
				<th>Team</th>
				<th>PL</th>
				<th>W</th>
				<th>D</th>
				<th>L</th>
				<th>F</th>
				<th>A</th>
				<th>GD</th>
				<th>PTS</th>
			</tr>
		</thead> <!-- Headings, title of the table -->
		<tbody> 
		<?php
		
		while ($row = mysqli_fetch_array($query))
		{
			$pts  = $row['Pts'] == 0 ? '' : number_format($row['Pts']);
			echo '<tr>
					<td>'.$row['Team'].'</td>
					<td>'.$row['P'].'</td>
					<td>'.$row['W'].'</td>
					<td>'.$row['D'].'</td>
					<td>'.$row['L'].'</td>
					<td>'.$row['F'].'</td>
					<td>'.$row['A'].'</td>
					<td>'.$row['GD'].'</td>
					<td>'.$row['Pts'].'</td>
				</tr>'; //Inputs the correct data from the database into the table

		}?>
		</tbody>

	</table>
</body>
</html>