const scaleNames = {
	c: "섭씨",
	f: "화씨"
};

function TemperatureInput(props) {
	const handleChange = (e) => {
		props.onTemperatureChange(e.target.value);
	};

	return (
		<fieldset>
			<legend>
				온도 입력 (단위: {scaleNames[props.scale]}):
			</legend>
			<input value={props.temperature} onChange={handleChange} />
		</fieldset>
	);
}

export default TemperatureInput;