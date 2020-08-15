//const removeItemAll = require('../utils/removeItemAll');

function filterInput(message) {    
    return message.replace(' ','-');
};

module.exports = filterInput;