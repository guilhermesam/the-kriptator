function removeItemAll(arr, value) {
    var i = 0;
    while (i < arr.length) {
      if (arr[i] === value) {
        arr.splice(i, 1);
      } else {
        ++i;
      }
    }
    return arr;
}

function filterInput(message) {
    const symbols = [',', '!', '.', '@', '/', '?'];
    message = message.split('');
    symbols.forEach(symbol => {
        message = removeItemAll(message, symbol);
    });
    
    return message.join("");
};

module.exports = filterInput;