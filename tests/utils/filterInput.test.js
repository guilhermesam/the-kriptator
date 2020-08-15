const filterInput = require('../../src/utils/filterInput');

test('Random Symbols in input must return only alphabetical symbols', () => {
	expect(filterInput("bom@!dds,!dd")).toBe("bomddsdd");
	});