const caesar = require('../../src/scripts/caesar_cipher')

// Test Cases to Encrypt

test('Encrypt with 0 shifties must be equal', () => {
	expect(caesar.encrypt("hello", 0)).toBe("hello");
	});

test('Encrypt with shifties > 26 and < 0', () => {
	expect(caesar.encrypt("hello", 27)).toBe("ifmmp");
	expect(caesar.encrypt("hello", -2)).toBe("jgnnq");
	});

test('Multiple words must be separated with "-"', () => {
	expect(caesar.encrypt("hello world", 2)).toBe("jgnnq yqtnf");
	});

test('Symbols must be ignorated', () => {
	expect(caesar.encrypt("guilhermesamuel79@gmail.com", 2)).toBe("iwknjgtogucowgn79@iockn.eqo");
	});

test('When not passing value to shifties, use 0', () => {
	expect(caesar.encrypt("hello")).toBe("hello");
});

test('Convert uppercase to lowercase', () => {
	expect(caesar.encrypt("HELLO", 2)).toBe("jgnnq");
});

// Test Cases to Decrypt
