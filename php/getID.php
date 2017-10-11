<?php

  
  $connect= mysqli_connect("localhost", "kufermalikUser", "kufermalikUser", "kufermalik");
  $connect->set_charset("utf8"); 
  
  $query = "SELECT AUTO_INCREMENT
FROM information_schema.tables
WHERE table_name = 'Nouran' ";

  $result=  mysqli_query($connect, $query);
	if(! $result)
	{ die("Error in query");}
	 
	while($row=  mysqli_fetch_assoc($result))
	{
	 $output[]=$row; 
	}
	print(json_encode($output));
	mysqli_free_result($result);
	mysqli_close($connect);


?>
