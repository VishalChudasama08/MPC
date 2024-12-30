<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="sessionVariables.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>MyNotes</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <!-- Font awesome-->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
   <style>
      .hideIcon {
         display: none; /* Same as $(".hideIcon").hide() */
      }
      .pin-icon {
         top: 0px;
         right: 1px;
         cursor: pointer; /* Same as $(".pin-icon").css({...}) */
      }
      .custom-tooltip {
         background-color: #ffc107; /* Change background color */
         color: #000; /* Change text color */
         font-size: 0.875rem; /* Adjust font size */
         border-radius: 0.5rem; /* Rounded corners */
      }
</style>
</head>
<body>