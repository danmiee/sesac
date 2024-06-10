let numbers = [273, 52, 103, 32, 57];

numbers
	.filter((value) => value % 2 === 0)
	.map((value) => value * value)
	.forEach((value, index) => console.log(`${index}번째 요소 : ${value}`))