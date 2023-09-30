try {
    console.log("This is try block");
    console.log(vishal);
} catch (error) {
    console.log("This is catch block");
}

finally { // a block run thayej chhe koy pan kandition hoy, try ma error hoy ke na hoy aato finally block to run thayrj chhe
    console.log("This is finally block");
}

const v = () => {
    try {
        console.log("This is try block");
        console.log(vishal);
        return
    } catch (error) {
        console.log("This is catch block");
    }

    finally { // ahi try block ma return chhe to pan finally block return thay aepSelaj run thay chhe, baki return pachhi function ma kay run thatu nathi
        console.log("This is finally block");
    }
}

v();
console.log("hey, I am simple log messeage");