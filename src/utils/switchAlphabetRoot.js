module.exports = (times) => {
    const alphabet = "abcdefghijklmnopqrstuvwxyz";
    const pt1 =  alphabet.slice(times, alphabet.length);
    const pt2 = alphabet.slice(0, times);
    return pt1.concat(pt2);
};