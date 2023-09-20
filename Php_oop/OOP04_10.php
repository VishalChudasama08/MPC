<?php
class set
{
    private $m, $n;
    public function input()
    {
        echo "Input Values of m and n ";
?>
        <form action="" method="get">
            <label for="m">M : </label><input type="number" id="m" name="m">
            <label for="n">N : </label><input type="number" id="n" name="n">
            <input type="submit" name="ok" value="Ok">
        </form>
<?php
        if (isset($_GET["ok"])) {
            $this->m = $_GET["m"];
            $this->n = $_GET["n"];
        }
    }
    public function largest()
    {
        if (($this->m) >= ($this->n)) {
            return ($this->m);
        } else {
            return ($this->n);
        }
    }
    public function display()
    {
        if (isset($_GET["ok"])) {
            echo "Largest Value = " . $this->largest();
        }
    }
}
$s = new set;
$s->input();
$s->display();
