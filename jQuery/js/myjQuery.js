// $('selector').action()
// ↑ syntax of jQuery

// $('p').click(); /*clicked p tag*/
// ↑ p par click thay jay chhe auto

$(document).ready(function() {
  console.log("i am using jQuery");

  // let v = $('p').click(function(){
  $('p').click(function(){ /*click on p tag and run this function*/
  
    // console.log("You click p tag");
    // $('p').hide(); /*p tag par click kar ta te hide thay*/
    // $(this).hide(); /*use of "this" kar ta jena par click kar vama aave te hide thay*/
    // $('#p-2').hide(); /*id hoy te ↑*/
    // $('.p3').hide(); /*class hoy te ↑*/
    // $('*').hide(); /*badha hide thay*/
    
    // $('.p5').click().hide(); /*.p5 tag clicked and hide*/
    // console.log("You click on p tag", this); /*je na par click kar vama aavr te aakho tag console ma aave chhe */
    // $('p.p3').hide(); /*hide .p3 tag*/
    // $('p:first').hide(); /*hide first p*/
  });
  // console.log(v); /*print full function*/
  
  // ↓↓ jQuery mouse events ↓↓
  
  /*$("p").click(function(){
    console.log("You click over p tag");
  });*/
  
  /*$('p').dblclick(function(){
    console.log("You dubble click on p tag", this);
  });*/
  
  /*$('p').mouseenter(function(){
    console.log("You mouse enter(mouse pointer go on p tag area) on p tag", this);
  });*/
  
  /*$('p').mouseleave(function(){
        console.log("You mouse leave(mouse pointer leave on p tag area) on p tag", this);
  });*/
  
  /*$("p").mousedown(function() {
    console.log("Mouse down over p tag !", this);
  });*/
  
  /*$("#p1").mouseup(function() {
    console.log("Mouse up over p tag", this);
  });*/
   
  /*$('p').hover(function(){
    console.log("You entered mouse in p tag", this);
  }, function(){
    console.log("You leave mouse in p tag", this);
  });*/
  
  // ↓↓ jQuery Keyboard Event ↓↓
  
  // ↓↓ on method ↓↓
  
  $("p").on({
    click: function(){
      console.log("Thanks for clicking", this);
    },
    mouseenter: function(){
      console.log("mouseenter!");
    }
  });
  
  // $(".div1").hide(1000, function(){
  //   console.log("hidden");
  // }); /*1000 ms milisecond*/
  // $(".div1").show(1000, function(){
  //   console.log("showing");
  // });
  
  // $("#playbtn").click(function(){
    // $(".div1").toggle(1000); /*toggle minss jo aam chhe to aam karo and jo aam hoy to aam kari do*/
  // });
  
  $("#playbtn").click(function(){
    console.log("You clicked play botton");
  });
  
  // ↓↓ fade method ↓↓

  // $("#playbtn").click(function() {
    // $(".div1").fadeIn(2000); /*animation start-end */
  // });
  // $("#playbtn").click(function() {
    // $(".div1").fadeOut(2000); /*animation end-start*/
  // });
  // $("#playbtn").click(function() {
  //   $(".div1").fadeToggle(3000); /*animate time 3000 = 3 second*/
  // });
  // $("#playbtn").click(function() {
  //   $(".div1").fadeTo(500, 0.2);
  //   /*0.2 opacity in 500ms = 1/2s*/
  // });
  // $("#playbtn").dblclick(function() {
  //   $(".div1").fadeTo(1, 1);
  // });
  
  // ↓↓ slide method ↓↓ 
  $("#playbtn").click(function(){
    // $(".div1").slideUp(1000);
    /*$(".div1").slideUp(1000, function(){
      console.log("slideUp");
    });*/
    $(".div1").slideDown(1000);
    $(".div1").slideToggle(1000);
  });
  
  // ↓↓ animate function in jQuery ↓↓
  
  // $(".div1").animate({
  //   opacity: 0.2,
  //   width: "200px",
  //   hieght: "350px",
  // }, "slow"); /*time in ms|fast|slow*/
  /*$(".div1").animate({opacity: 0.2}, 1000);
  $(".div1").animate({width: "300px"}, 3000);
  $(".div1").animate({hieght: "450px"}, 5000);
  $(".div1").animate({opacity: 1}, 1000);
  */
  // ↓↓ All are using in console ↓↓
  
  // $(".div1").text(); you write this in console then show you all text in .div1 
  // $(".div1").text("Using text function to show this text"); you write in text function then .div1 conten chenge
  
  // $("body").html(); body ma jetlu html chhe te bhatase
  // $("body").html("Vishal is King"); and $("body").html("<p>This is p tav</p>"); if you write in this type then run in body tag
  
  
});

  /* τ ιονε λου ϛεετα */
  