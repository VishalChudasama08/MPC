<?php
	class SimpleClass
	{
		// property declaration (Property mean Variable)
		public $var = 'A Default Variable  value';
		
		// method declaration (method  mean Function)
		public function displayVar() 
		{
			//Access the varible Here
			echo $this->var."<hr>";
			
			echo 'Function Block Here <hr>';
		}
	}
	
	//MAking Class To Object And 'new' keyword
	$objA = new SimpleClass();
	
	//Calling Function USing Object A
	$objA->displayVar();
	
	//calling varible USing Object A
	echo $objA->var."<hr>";
