const readline = require('readline');

// readline 인터페이스 생성
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
})

// 사용자에게 숫자를 입력 받음
rl.question('숫자 입력 : ', (input) => {
	const number = Number(input);

	if (number == 0) {
		console.log(number);
	}
	else {
		// 조건문
		const result = number >= 0 ? '0 이상' : '0보다 작음';
		console.log(result);

	}
	// readline 인터페이스 닫기
	rl.close();
})
