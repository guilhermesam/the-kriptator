const caesar = require('../../src/scripts/caesar_cipher')

test('Encrypt with 0 shifties must be equal', () => {
	expect(caesar.encrypt("bom", 0)).toBe("bom");
	});

test('Encrypt with shifties > 26 and < 0', () => {
	expect(caesar.encrypt("bom", 27)).toBe("cpn");
	expect(caesar.encrypt("bom", -2)).toBe("dqo");
	});

test('Encrypt with > 26 shifties, i.e 27 must be 1 shift', () => {
	expect(caesar.encrypt("bom", 27)).toBe("cpn");
	});

