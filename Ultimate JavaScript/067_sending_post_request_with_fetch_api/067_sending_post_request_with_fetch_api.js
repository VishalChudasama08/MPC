const createTodo = async (todo) => {
    let options = {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(todo), //.stringify => javasript object to convert string
    }
    let p = await fetch('https://jsonplaceholder.typicode.com/posts', options)
    let response = await p.json();
    return response;
}

const getTodo = async (id) => {
    let po = await fetch('https://jsonplaceholder.typicode.com/posts/' + id)
    let re = await po.json();
    return re;
}

const mainFunc = async () => {
    let todo = {
        title: 'Vishal',
        body: 'Bhai',
        userId: 8,
    };
    let todor = await createTodo(todo);
    console.log(todor);
    console.log(getTodo(8));
}

mainFunc();