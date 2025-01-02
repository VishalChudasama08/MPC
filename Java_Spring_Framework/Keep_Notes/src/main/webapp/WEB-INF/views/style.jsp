// $(".hideIcon").hide();

// $(".pin-icon").css({
//    "top": "0px",
//    "right": "1px",
//    "cursor": "pointer"
// });

// $(".icons i").hover(
//    function () {
//       $(this).css({
//          "transform": "scale(1.2)", // Slight zoom effect
//          "transition": "transform 0.2s ease-in-out",
//          "cursor": "pointer"
//       });
//    },
//    function () {
//       $(this).css({
//          "transform": "scale(1)", // Reset zoom effect
//          "transition": "transform 0.2s ease-in-out"
//       });
//    }
// );

// $(".card").hover(
//    function () {
//       $(this).find(".hideIcon").show();
//       $(this).css({
//          "box-shadow": "-3px 3px 0px rgba(0, 0, 0, 0.2)", // Subtle shadow effect
//          "transition": "box-shadow 0.3s ease-in-out"
//       });
//       $(this).find(".iconDiv") // select iconDiv name tag from this card only 
//          .css({
//             "box-shadow": "-3px 3px 0px rgba(0, 0, 0, 0.2)", // Subtle shadow effect
//             "transition": "box-shadow 0.3s ease-in-out"
//          })
//          .addClass('card-footer');
//    },
//    function () {
//       $(this).find(".hideIcon").hide();
//       $(this).css({
//          "box-shadow": "", // Reset to default
//          "transition": "box-shadow 0.3s ease-in-out"
//       });
//       $(this)
//          .find(".iconDiv")
//          .css({
//             "box-shadow": "", // Reset to default
//             "transition": "box-shadow 0.3s ease-in-out"
//          })
//          .removeClass('card-footer');
//    }
// );





// Delegate hover and click events to dynamically created elements

// Delegate hover for zoom effect on icons
$(document).on('mouseenter', '.icons i', function () {
   $(this).css({
      "transform": "scale(1.2)", // Slight zoom effect
      "transition": "transform 0.2s ease-in-out",
      "cursor": "pointer"
   });
});

$(document).on('mouseleave', '.icons i', function () {
   $(this).css({
      "transform": "scale(1)", // Reset zoom effect
      "transition": "transform 0.2s ease-in-out"
   });
});

// Delegate hover for cards
$(document).on('mouseenter', '.card', function () {
   $(this).find(".hideIcon").show();
   $(this).css({
      "box-shadow": "-3px 3px 0px rgba(0, 0, 0, 0.2)", // Subtle shadow effect
      "transition": "box-shadow 0.3s ease-in-out"
   });
   $(this)
      .find(".iconDiv")
      .css({
         "box-shadow": "-3px 3px 0px rgba(0, 0, 0, 0.2)", // Subtle shadow effect
         "transition": "box-shadow 0.3s ease-in-out"
      })
      .addClass('card-footer');
});

$(document).on('mouseleave', '.card', function () {
   $(this).find(".hideIcon").hide();
   $(this).css({
      "box-shadow": "", // Reset to default
      "transition": "box-shadow 0.3s ease-in-out"
   });
   $(this)
      .find(".iconDiv")
      .css({
         "box-shadow": "", // Reset to default
         "transition": "box-shadow 0.3s ease-in-out"
      })
      .removeClass('card-footer');
});