function min(first, ...rests) {
	// 변수 선언
	let output;
	let items;

	// 매개변수 자료형에 따라 조건 분기
	if (Array.isArray(first)) {
		output = first[0];
		items = first;
	} else if (typeof first === 'number') {
		output = first;
		items = rests;
	}

	// 이전 절에서 살펴보았던 최솟값 공식
	for (const item of items) {
		if (output > item) {
			output = item;
		}
	}
	return output;
}

console.log(`min(배열): ${min([52, 273, 32, 103, 275, 24, 57])}`);
console.log(`min(숫자, ...): ${min(52, 273, 32, 103, 275, 24, 57)}`);