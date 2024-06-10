let output = 0;
for (let i = 0; i < 5; i++) {
	if (i % 2 === 1) {
		continue;
	}
	output += i;
}
console.log(output);