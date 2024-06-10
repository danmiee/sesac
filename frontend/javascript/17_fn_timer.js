let id;
let count = 0;
id = setInterval(() => {
	console.log(`1초마다 실행(${count}번째)`);
	count++;
}, 1 * 1000);

setTimeout(() => {
	console.log('타이머 종료');
	clearInterval(id);
}, 5 * 1000);
