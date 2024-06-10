// 나머지 매개변수는 항상 마지막에 기입
function sample(a, b, ...c) {
	console.log(a, b, c);
}

sample(1, 2);
sample(1, 2, 3);
sample(1, 2, 3, 4);