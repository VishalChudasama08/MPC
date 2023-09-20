<?php
class abc
{
    private $x;
    protected function getvalue()
    {
        echo "Enter The Value Of Variable : ";
?>
        <form method="get">
            <input type="number" name="vvalue">
            <input type="submit" name="submit" value="Submit">
        </form>
<?php
        if (isset($_GET["submit"])) {
            $this->x = $_GET["vvalue"];
            return ($this->x);
        }
    }
    public function editvalue()
    {
        $this->getvalue();
        $this->x = ($this->x) + 15;
        if (isset($_GET["submit"])) {
            echo "The Value After Modification Is : " . $this->x;
        }
    }
}
$a = new abc;
$a->editvalue();
