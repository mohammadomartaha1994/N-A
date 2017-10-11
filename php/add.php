<?php
  $connect= mysqli_connect("localhost", "kufermalikUser", "kufermalikUser", "kufermalik");
    $connect->set_charset("utf8"); 
    
    $num1= $_POST['num1'];  
    $num2= $_POST['num2'];  
    $num3= $_POST['num3'];  
    $num4= $_POST['num4'];  
    $num5= $_POST['num5'];  
    $num6= $_POST['num6'];  
    $num7= $_POST['num7'];  
    $num8= $_POST['num8'];  
    $num9= $_POST['num9'];  
    $num10= $_POST['num10'];  

    $num11= $_POST['num11'];  
    $num12= $_POST['num12'];  
    $num13= $_POST['num13'];  
    $num14= $_POST['num14'];  
    $num15= $_POST['num15'];  
    $num16= $_POST['num16'];  
    $num17= $_POST['num17'];  
    $num18= $_POST['num18'];  
    $num19= $_POST['num19'];  
    $num20= $_POST['num20'];  

    $num21= $_POST['num21'];  
    $num22= $_POST['num22'];  
    $num23= $_POST['num23'];  
    $num24= $_POST['num24'];  
    $num25= $_POST['num25'];  
    $num26= $_POST['num26'];  
    $num27= $_POST['num27'];  
    $num28= $_POST['num28'];  
    $num29= $_POST['num29'];  
    $num30= $_POST['num30'];  

    $num31= $_POST['num31'];  
    $num32= $_POST['num32'];  
    $num33= $_POST['num33'];  
    $num34= $_POST['num34'];  
    $num35= $_POST['num35'];  
    $num36= $_POST['num36'];  
    $num37= $_POST['num37'];  
    $num38= $_POST['num38'];  
    $num39= $_POST['num39'];  
    $num40= $_POST['num40'];  

    $num41= $_POST['num41'];  
    $num42= $_POST['num42'];  
    $num43= $_POST['num43'];  
    $num44= $_POST['num44'];  
    $num45= $_POST['num45'];  
    $num46= $_POST['num46'];  
    $num47= $_POST['num47'];  
    $num48= $_POST['num48'];  
    $num49= $_POST['num49'];  
    $num50= $_POST['num50'];  

    $num51= $_POST['num51'];  
    $num52= $_POST['num52'];  
    $num53= $_POST['num53'];  
    $num54= $_POST['num54'];  
    $num55= $_POST['num55'];  
    $num56= $_POST['num56'];  
    $num57= $_POST['num57'];  
    $num58= $_POST['num58'];  
    $num59= $_POST['num59'];  
    $num60= $_POST['num60'];  

    $num61= $_POST['num61'];  
    $num62= $_POST['num62'];  
    $num63= $_POST['num63'];  
    $num64= $_POST['num64'];  
    $num65= $_POST['num65'];  
    $num66= $_POST['num66'];  
    $num67= $_POST['num67'];  
    $num68= $_POST['num68'];  
    $num69= $_POST['num69'];  
    $num70= $_POST['num70'];  

    $num71= $_POST['num71'];  
    $num72= $_POST['num72'];  
    $num73= $_POST['num73'];  
    $num74= $_POST['num74'];  
    $num75= $_POST['num75'];  
    
	$response["success"] = false;  

  		        $response = array();

		    $statement = mysqli_prepare($connect, " INSERT INTO Nouran ( num1 , num2 ,  num3 ,  num4,  num5,  num6 ,  num7,  num8 , num9 ,  num10 ,
                    num11 , num12 ,  num13 ,  num14,  num15,  num16 ,  num17,  num18 , num19 ,  num20 ,
                    num21 , num22 ,  num23 ,  num24,  num25,  num26 ,  num27,  num28 , num29 ,  num30 ,
                    num31  ,num32 ,   num33 ,  num34,  num35,  num36 ,  num37,  num38 , num39 ,  num40 ,
                    num41 , num42 ,  num43 ,  num44,  num45,  num46 ,  num47,  num48 , num49 ,  num50 ,
                    num51 , num52 ,  num53 ,  num54,  num55,  num56 ,  num57,  num58 , num59 ,  num60 ,
                    num61 , num62 ,  num63 ,  num64,  num65,  num66 ,  num67,  num68 , num69 ,  num70 ,
                    num71 , num72 , num73 ,  num74, num75) VALUES ( 
                    ? , ? , ? , ? , ? ,? , ? , ? , ? , ? ,
                    ? , ? , ? , ? , ? ,? , ? , ? , ? , ? ,
                    ? , ? , ? , ? , ? ,? , ? , ? , ? , ? ,
                    ? , ? , ? , ? , ? ,? , ? , ? , ? , ? ,
                    ? , ? , ? , ? , ? ,? , ? , ? , ? , ? ,
                    ? , ? , ? , ? , ? ,? , ? , ? , ? , ? ,
                    ? , ? , ? , ? , ? ,? , ? , ? , ? , ? ,
                    ? , ? , ? , ? , ?  ) ");
		    mysqli_stmt_bind_param($statement, "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
		     $num1 , $num2 ,  $num3 ,  $num4,  $num5,  $num6 ,  $num7,  $num8 , $num9 ,  $num10 ,
                    $num11 , $num12 ,  $num13 ,  $num14,  $num15,  $num16 ,  $num17,  $num18 , $num19 ,  $num20 ,
                    $num21 , $num22 ,  $num23 ,  $num24,  $num25,  $num26 ,  $num27,  $num28 , $num29 ,  $num30 ,
                    $num31  ,$num32 ,   $num33 ,  $num34,  $num35,  $num36 ,  $num37,  $num38 , $num39 ,  $num40 ,
                    $num41 , $num42 ,  $num43 ,  $num44,  $num45,  $num46 ,  $num47,  $num48 , $num49 ,  $num50 ,
                    $num51 , $num52 ,  $num53 ,  $num54,  $num55,  $num56 ,  $num57,  $num58 , $num59 ,  $num60 ,
                    $num61 , $num62 ,  $num63 ,  $num64,  $num65,  $num66 ,  $num67,  $num68 , $num69 ,  $num70 ,
                    $num71 , $num72 , $num73 ,  $num74, $num75 );
		    mysqli_stmt_execute($statement);
                    
                    mysqli_stmt_store_result($statement);
		    mysqli_stmt_bind_result($statement, $id, $num1 , $num2 ,  $num3 ,  $num4,  $num5,  $num6 ,  $num7,  $num8 , $num9 ,  $num10 ,
                    $num11 , $num12 ,  $num13 ,  $num14,  $num15,  $num16 ,  $num17,  $num18 , $num19 ,  $num20 ,
                    $num21 , $num22 ,  $num23 ,  $num24,  $num25,  $num26 ,  $num27,  $num28 , $num29 ,  $num30 ,
                    $num31  ,$num32 ,   $num33 ,  $num34,  $num35,  $num36 ,  $num37,  $num38 , $num39 ,  $num40 ,
                    $num41 , $num42 ,  $num43 ,  $num44,  $num45,  $num46 ,  $num47,  $num48 , $num49 ,  $num50 ,
                    $num51 , $num52 ,  $num53 ,  $num54,  $num55,  $num56 ,  $num57,  $num58 , $num59 ,  $num60 ,
                    $num61 , $num62 ,  $num63 ,  $num64,  $num65,  $num66 ,  $num67,  $num68 , $num69 ,  $num70 ,
                    $num71 , $num72 , $num73 ,  $num74, $num75 );
		        
		        
		         while(mysqli_stmt_fetch($statement)){
		        $response["success"] = true; 
		       // $response["id"] = $id; 
		         
		    }

		       
        echo json_encode($response);

?>

		   