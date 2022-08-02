// I didn't know how to write comments in JS. I learned that is // or /* */ (multi-line)

// To run a specific file, type `node <file path>` in console

// I didn't know whether arrays are passed to functions are objects in js or as values the following is a test:

console.log("Modify array test \n")

function modifyArray(array) {
    array[1] = 11;
}

let array = [1,2,3,4,5,6];

modifyArray(array);

console.log(array);

console.log("\n end test \n")

// The result is that arrays are passed as objects