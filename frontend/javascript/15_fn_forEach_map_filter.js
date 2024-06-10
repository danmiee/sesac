let numbers = [273, 52, 103, 32, 57];

// forEach(): return 없음
console.log('\n'+'forEach()');
numbers.forEach(function (value, index, array) {
	console.log(`${index}번째 요소 : ${value}`);
});

// map(): return
console.log('\n'+'map()');
numbers = numbers.map(function (value, index, array) {
	return value * value;
});
numbers.forEach((value) => { console.log(value) });

// filter(): 필요한 것만 추출
console.log('\n'+'filter()');
const evenNumbers = numbers.filter(
	function (value) {
		return value % 2 === 0;
	}
);
console.log(`원래 배열: ${numbers}`);
console.log(`짝수만 추출: ${evenNumbers}`);