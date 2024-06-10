// 명시적으로 넣는 것이 아니라면 버그를 일으킬 확률이 높아 비추천

// power() 메소드 추가
Number.prototype.power = (n = 2) => {
	return this.valueOf() ** n;
};

// Number 객체의 power() 메소드 사용
console.log('\n' + 'number.power()');
const num = 12;
console.log(`num.power(): ${num.power()}`);
console.log(`num.power(3): ${num.power(3)}`);
console.log(`num.power(4): ${num.power(4)}`);

// contain() 메소드 추가
String.prototype.contain = (data) => {
	return this.indexOf(data) >= 0;
};
Array.prototype.contain = (data) => {
	return this.indexOf(data) >= 0;
};

// String 객체의 contain() 메소드 사용
console.log('\n' + 'String.contain()');
const str = '안녕하세요';
console.log(`안녕 in 안녕하세요: ${str.contain('안녕')}`);
console.log(`없는데 in 안녕하세요: ${str.contain('없는데')}`);

// Array 객체의 contain() 메소드 사용
console.log('\n' + 'Array.contain()');
const arr = [273, 32, 103, 57, 52];
console.log(`273 in [273, 32, 103, 57, 52]: ${arr.contain(273)}`);
console.log(`0 in [273, 32, 103, 57, 52]: ${arr.contain(0)}`);
