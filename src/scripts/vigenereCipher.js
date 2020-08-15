const alphabet = require("../utils/alphabet");
const switchAlphabetRoot = require("../utils/switchAlphabetRoot");

function generateTable() {
    table = [];
    for (let index = 0; index < 26; index++) {
        table.push(switchAlphabetRoot(index));
    }

    return table;
};

function encrypt(key, message) {
    const encryptedMessage = [];

    for (let index = 0; index < key.length; index++) {
        let x = alphabet.indexOf(key[index]);
        let y = alphabet.indexOf(message[index]);
        encryptedMessage.push(switchAlphabetRoot(y)[x]);
    };

    return encryptedMessage.join("");
};

function decrypt(key, message) {
    const table = generateTable();
    const encryptedMessage = [];
    let x, y = 0;

    for (let i = 0; i < key.length; i++) {
        x = alphabet.indexOf(key.charAt(i));
        
        for (let j = 0; j < alphabet.length; j++) {
            if (table[j].charAt(x) == message.charAt(i)) {
                y = j;
            };
        };

        encryptedMessage[i] = switchAlphabetRoot(y).charAt(0);
    };

    return encryptedMessage.join("");
};
