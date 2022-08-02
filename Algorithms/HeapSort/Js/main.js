
function getLeftNodeIndex(i){
    // Only need getLeftNode cuz right node is left + 1
    return 2*i + 1;
}

function makeMaxHeap(array) {
    // start at the bottom of the array selecting each index as root and checking if it has leaf nodes.
    // If the value of any leaf is bigger than root, move the bigger value up. Use siftDown function for this

    const end = array.length;
    
    
    for (let start = end-1; start >= 0; start--) {
        siftDown(array, start);
    }
}

function siftDown(array, realRootIndex, end = array.length-1) {

    let tempRootIndex = realRootIndex;
    let left = getLeftNodeIndex(tempRootIndex);

    while ( left <= end ) {

        let swap = tempRootIndex;


        if (array[tempRootIndex] < array[left]) {
            swap = left;
        }

        // Left + 1 is Right. We compare previous swap index value with right left now 
        if (left + 1 <= end && array[swap] < array[left + 1]) {
            swap = left + 1;
        }

        if (swap == tempRootIndex){
            return;
        } else {

            //swapping

            

            let temp = array[tempRootIndex];
            array[tempRootIndex] = array[swap];
            array[swap] = temp;

            // If we swap something, we need to follow the nodes further down to make sure order (of the universe) is still maintained
            // so we make the swapIndex (leaf) into the new root and repeat

            tempRootIndex = swap;
            left = getLeftNodeIndex(tempRootIndex);

        }

    }

}

function heapsort(array){

    //convert sortedArray to max heap array

    makeMaxHeap(array);

    // Now move root to end of array and decrease array size when sifting down.

    for (let i = array.length - 1; i > 0;) {

        let temp = array[0];
        array[0] = array[i];
        array[i] = temp;


        i--;

        siftDown(array, 0, i);


    }

}


const nEWaRRAY = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];

heapsort(nEWaRRAY);

console.log(nEWaRRAY);


//proof of formula
// big O space and time complexity


