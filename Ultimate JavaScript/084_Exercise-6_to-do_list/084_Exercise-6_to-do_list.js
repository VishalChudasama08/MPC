submit.addEventListener("click", (e) => { // submit is submit button id
    e.preventDefault(); // if web page reload than use this to not reloa in this case submit button

    let titlec = title.value; // title is "To-Do List" input tag id, and .value return user input value
    let descc = desc.value; // desc is "ToDo Desc" input tag id, and .value return user input value

    localStorage.setItem("todo", JSON.stringify([titlec, descc])); // click submit then stor titlec and descc value in localstorage 
    // JSON.stringify() use to convert string

    console.log(e);

    todo.innerHTML = `<h2>${titlec}</h2><h4>${descc}</h4>` //add todo id in html

    title.value = ""; // after submit clear input box
    desc.value = ""; // after submit clear input box
})
deletebtn.addEventListener("click", (e) => {
    e.preventDefault();
    localStorage.removeItem("todo");
    console.log(e);
})