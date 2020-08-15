module.exports = (array, value) => {
    var index = 0;
    while (index < array.length) {
        if (array[index] === value) {
            array.splice(index, 1);
        } else {
            ++index;
        }
    }
    return array;
};