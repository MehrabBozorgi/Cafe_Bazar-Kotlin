<?php
include "connect.php";
$id = $_GET["id"];
$query = "SELECT movie.*
,comment_movie.comment_name,comment_movie.date,comment_movie.comment,comment_movie.movie_id
FROM movie JOIN comment_movie ON comment_movie.movie_id = movie.id 
WHERE movie.id= $id ";
$res = $connection->prepare($query);
$res->execute();
$apps = array();
$comments = array();
$faslha = array();

while ($row = $res->fetch(PDO::FETCH_ASSOC)) {

    $apps["id"] = $row["id"];
    $apps["name"] = $row["name"];
    $apps["icon"] = $row["icon"];
    $apps["cat"] = $row["cat"];
    $apps["cat_id"] = $row["cat_id"];
    $apps["age"] = $row["age"];
    $apps["zaban"] = $row["zaban"];
    $apps["zir_nevis"] = $row["zir_nevis"];
    $apps["description"] = $row["description"];
    $apps["point"] = $row["point"];
    $apps["kodom_site"] = $row["kodom_site"];
    $apps["time"] = $row["time"];
    $apps["tools"] = $row["tools"];
    $apps["sale_sakh"] = $row["sale_sakh"];
    $apps["country"] = $row["country"];
    $apps["keyfiat"] = $row["keyfiat"];
    $apps["fasl_id"] = $row["fasl_id"];
    $apps["movie_id"] = $row["movie_id"];

}
$query2 = "SELECT * FROM comment_movie WHERE movie_id = $id";
$res2 = $connection->prepare($query2);
$res2->execute();

while ($row2 = $res2->fetch(PDO::FETCH_ASSOC)) {

    $comment = array();

    $comment["id"] = $row2["id"];
    $comment["comment_name"] = $row2["comment_name"];
    $comment["date"] = $row2["date"];
    $comment["comment"] = $row2["comment"];
    $comment["movie_id"] = $id;


    $comments[] = $comment;
}

$apps["comment"] = $comments;

$query3 = "SELECT movie.*,fasl.id,fasl.chand_fasl,fasl.movie_id
FROM movie JOIN fasl ON fasl.movie_id = movie.id 
WHERE movie.id= $id ";
$res3 = $connection->prepare($query3);
$res3->execute();

while ($row3 = $res3->fetch(PDO::FETCH_ASSOC)) {

    $apps["id"] = $row3["id"];
    $apps["name"] = $row3["name"];
    $apps["icon"] = $row3["icon"];
    $apps["cat"] = $row3["cat"];
    $apps["cat_id"] = $row3["cat_id"];
    $apps["age"] = $row3["age"];
    $apps["zaban"] = $row3["zaban"];
    $apps["zir_nevis"] = $row3["zir_nevis"];
    $apps["description"] = $row3["description"];
    $apps["point"] = $row3["point"];
    $apps["kodom_site"] = $row3["kodom_site"];
    $apps["time"] = $row3["time"];
    $apps["tools"] = $row3["tools"];
    $apps["sale_sakh"] = $row3["sale_sakh"];
    $apps["country"] = $row3["country"];
    $apps["keyfiat"] = $row3["keyfiat"];
    $apps["fasl_id"] = $row3["fasl_id"];
    $apps["movie_id"] = $row3["movie_id"];

}
$query4 = "SELECT * FROM fasl WHERE movie_id = $id";
$res4 = $connection->prepare($query4);
$res4->execute();

while ($row4 = $res4->fetch(PDO::FETCH_ASSOC)) {

    $fasl = array();

    $fasl = array();
    $fasl["id"] = $row4["id"];
    $fasl["chand_fasl"] = $row4["chand_fasl"];
    $fasl["movie_id"] = $id;

    $faslha[] = $fasl;
}

$apps["faslha"] = $faslha;

echo JSON_encode($apps);

