<?php
require "connect.php";

$id=$_GET["id"];

$query = "SELECT getgoli.*
,img_slide_game.application_id,img_slide_game.img_url
FROM getgoli JOIN img_slide_game ON img_slide_game.application_id = getgoli.id 
WHERE getgoli.id= $id";
$res = $connection->prepare($query);
$res->execute();
$slide = array();
$apps = array();
$comments = array();

while ($row = $res->fetch(PDO::FETCH_ASSOC)) {

    $apps["id"] = $row["id"];
    $apps["name"] = $row["name"];
    $apps["description"] = $row["description"];
    $apps["size"] = $row["size"];
    $apps["icon"] = $row["icon"];
    $apps["big_img"] = $row["big_img"];
    $apps["img_slide"] = $row["img_slide"];
    $apps["developer_name"] = $row["developer_name"];
    $apps["kind"] = $row["kind"];
    $apps["download"] = $row["download"];
    $apps["version"] = $row["version"];
    $apps["cat_id"] = $row["cat_id"];
    $apps["developer_phone"] = $row["developer_phone"];
    $apps["developer_email"] = $row["developer_email"];
    $apps["developer_web"] = $row["developer_web"];
    $apps["apk"] = $row["apk"];
    $apps["application_id"] = $row["application_id"];
    $apps["cat"] = $row["cat"];


//    $apps["img_url"] = $row["img_url"];

}
$query2="SELECT * FROM img_slide_game WHERE application_id = $id";
$res2=$connection->prepare($query2);
$res2->execute();

while($row2=$res2->fetch(PDO::FETCH_ASSOC)){

    $slide[]=$row2["img_url"];

}
$apps["slide"]=$slide;




$query3 = "SELECT * FROM comment_game WHERE game_id = $id";
$res3 = $connection->prepare($query3);
$res3->execute();

while ($row3 = $res3->fetch(PDO::FETCH_ASSOC)) {

    $comment = array();

    $comment["id"] = $row3["id"];
    $comment["comment_name"] = $row3["comment_name"];
    $comment["date"] = $row3["date"];
    $comment["comment"] = $row3["comment"];
    $comment["game_id"] = $id;


    $comments[] = $comment;
}
$apps["comment"] = $comments;

echo JSON_encode($apps);
//print_r($apps);

