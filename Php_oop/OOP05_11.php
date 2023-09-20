<?php
#array within class

session_start();

$items = new items;
$x = 0;
// do {
echo "<br>You Can Do The Following";
echo "<br>choose Approriate<br>";
?>
<form method="post">
    <label for="1">Add An Item : </label> <input type="radio" id="1" name="choose" value="1"> <br>
    <label for="2">Display Total Value : </label> <input type="radio" id="2" name="choose" value="2"> <br>
    <label for="3">Delete An Item : </label> <input type="radio" id="3" name="choose" value="3"> <br>
    <label for="4">Display All Items : </label> <input type="radio" id="4" name="choose" value="4"> <br>
    <label for="5">Delete Session : </label> <input type="radio" id="5" name="choose" value="5"> <br>
    <input type="submit" name="submit" value="Submit">
</form>
<?php
// print_r($_POST);

if (isset($_POST["submit"])) {
    $x = $_POST["choose"];
    switch ($x) {
        case 1:
            $items->getitem();
            break;
        case 2:
            $items->displaysum();
            break;
        case 3:
            $items->remove();
            break;
        case 4:
            $items->displayitems();
            break;
        case 5:
            session_destroy();
            break;
    }
}
// } while ($x != 5);


class items
{
    protected $itemcode, $itemprice, $count = 0, $sum = 0.0;

    public function getitem()
    {
        if (!isset($_SESSION['itemcode'])) {
            $_SESSION['itemcode'] = array(); // Initialize the arrays if not already set
        }
        if (!isset($_SESSION['itemprice'])) {
            $_SESSION['itemprice'] = array();
        }

?>
        <form method="get">
            Enter Item Code : <input type="number" name="ic">
            Enter Item Cost : <input type="number" name="ip">
            <input type="submit" name="ok" value="ok">
        </form>
        <?php

        if (isset($_GET["ok"])) {
            $ic = $_GET["ic"];
            $ip = $_GET["ip"];

            $_SESSION['itemcode'][] = $ic; // Append values to the arrays in the session
            $_SESSION['itemprice'][] = $ip;

            echo $this->count;
            $this->count++;
            echo $this->count;
            $_SESSION['item_count'] = $this->count;
        }

        $this->itemcode = $_SESSION['itemcode'];
        $this->itemprice = $_SESSION['itemprice'];
        echo "<pre>";
        print_r($this->itemcode);
        print_r($this->itemprice);
        echo "</pre>";
    }

    public function displaysum()
    {
        $this->count = isset($_SESSION['item_count']) ? $_SESSION['item_count'] : $this->count;
        echo $this->count;

        for ($i = 0; $i < $this->count; $i++) {
            $itemprice_sum = (float)$_GET["ip"];
            // echo $itemprice_sum;
            // print_r($_GET);
            $this->sum = $itemprice_sum + (isset($_SESSION['itemprice_sum']) ? $_SESSION['itemprice_sum'] : $this->sum);
            $_SESSION['itemprice_sum'] = $this->sum;
            // echo $this->sum;
        }
        echo "Total Value : " . $this->sum . "<br>";
    }

    public function remove()
    {
        $a = 0;
        echo "Enter Item Code : ";
        ?>
        <form method="get">
            <input type="number" name="code" id="code">
            <input type="submit" name="yes" value="Yes">
        </form>
<?php
        if (isset($_GET["yes"])) {
            $a = $_GET["code"];
        }
        for ($i = 0; $i < $this->count; $i++) {
            if ($this->itemcode[$i] == 0) {
                $this->itemprice[$i];
            }
        }
    }
    public function displayitems()
    {
        echo "code\tprice";
        for ($i = 0; $i < $this->count; $i++) {
            echo $this->itemcode[$i] . "\t" . $this->itemprice[$i];
        }
        echo "<br>";
    }
}
