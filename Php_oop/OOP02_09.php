<?php
class person
{
    protected $age, $name;
    public function getdata()
    {
        ?>

    <form method="get">
        <label for="name">Enter name : </label><br>
        <input type="text" name="nname"><br>
        <label for="age">Enter Age : </label><br>
        <input type="text" id="aname" name="aname"><br><br>
        <input type="submit" name="submit" value="Submit">
    </form>

    <?php
    if (isset($_GET["submit"])) {
        $this->name = $_GET["nname"];
        $this->age = $_GET["aname"];
    }
}


public function display()
{
    if (isset($_GET["submit"])) {
        echo "The name of the person is " . $this->name . "<br>";
        echo "The age of the person is " . $this->age . "<br>";
    }
}
}
$p = new person;
$p->getdata();
$p->display();

?>