// 단순하게 매개변수 모두 출력하는 함수
function sample(...items) {
	console.log(items);
}

// 전개 연산자 사용 여부 비교
const array = [1, 2, 3, 4];

console.log('# 전개 연산자 미사용');
sample(array);
console.log('# 전개 연선자 사용');
sample(...array);