const todos = ['우유구매', '업무 메일 확인', '필라테스 수업'];

// for-of
console.log("for of");
for (const todo of todos) {
	console.log(`오늘의 할 일 : ${todo}`);
}
console.log();
// for-in
console.log("for in");
for (const i in todos) {
	console.log(`${i}번째 할 일: ${todos[i]}`);
}
console.log();
// forEach
console.log("forEach");
todos.forEach((todo, index) => {
	console.log(`index: ${index}, todo: ${todo}`);
})
console.log();
// 일반적인 for문
console.log("for - asc");
for (let i=0; i<todos.length; i++) {
	console.log(`${i}번째 할 일: ${todos[i]}`);
}
console.log();
// 역순으로 나열
console.log("for - desc");
for (let i=todos.length-1;  i>=0; i--) {
	console.log(`${i}번째 할 일: ${todos[i]}`);
}