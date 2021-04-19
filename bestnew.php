<?php
include "connect.php";
$apps=array();
$query="SELECT id,name,kind,icon FROM game ";
$res=$connection->prepare($query);
$res->execute();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
    $record=array();
    $record["id"]=$row["id"];
    $record["name"]=$row["name"];
    $record["kind"]=$row["kind"];
    $record["icon"]=$row["icon"];

    $apps[]=$record;
}
shuffle($apps);

echo JSON_encode($apps);
