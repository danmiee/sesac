const readline = require('readline');

// readline 인터페이스 생성
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
})

// 숫자 입력 받음
rl.question('태어난 해 입력 : ', (input) => {
	const year = Number(input);
	const tti = '원숭이, 닭, 개, 돼지, 쥐, 소, 호랑이, 토끼, 용, 뱀, 말, 양'.split(',');

	console.log(`${year}년에 태어났다면 ${tti[year%12]}띠입니다.`);

	// readline 인터페이스 닫기
	rl.close();
})
