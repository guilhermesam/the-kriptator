const alphabet = require("../utils/alphabet");
const switchAlphabetRoot = require("../utils/switchAlphabetRoot");
const filterInput = require("../utils/filterInput");

function encrypt(message, times = 0) {
    if (times > 26) {
        times %= 26;
    };

    const messageEncrypted = [];
    message = filterInput(message).toLowerCase();
    times = Math.abs(times);
    const words = message.split('-');
    const symbols = ['"', '(', ')', ',', '!', '.', '@', '/', '?'];

    words.forEach(word => {
        for (let i = 0; i < word.length; i++) {

            if (symbols.includes(word[i]) || !isNaN(word[i])) {
                messageEncrypted.push(word[i])
            }

            else {
                let index = alphabet.indexOf(word[i]);
                messageEncrypted.push(switchAlphabetRoot(times)[index]);
            }
        }     
    
        messageEncrypted.push(' ');
    });

    return messageEncrypted.slice(0, -1).join("");
}

function decrypt(message, times) {
    message = filterInput(message);
    const messageEncrypted = [];
    const words = message.split('-');
    const symbols = ['"', '(', ')'];

    words.forEach(word => {
        for (let i = 0; i < word.length; i++) {
            
            if (symbols.includes(word[i])) {
                messageEncrypted.push(word[i]);
            }

            else {
                let index = alphabet.indexOf(word[i]);
                messageEncrypted.push(switchAlphabetRoot(26 - times)[index])
            }
        }

        messageEncrypted.push("-")
    });

    return messageEncrypted.slice(0, -1).join("");
};

module.exports = { encrypt, decrypt }
