//AGE
//queryselector to grab the value and input
const ageValue = document.querySelector("#ageValue");
const ageInput = document.querySelector("#pokeAge");
//Link the textual output to the current state of slider
ageValue.textContent = ageInput.value;
//Create event listener for the slider

ageInput.addEventListener("input", (event) => {
  ageValue.textContent = event.target.value;
});

//Height
//queryselector to grab the value and input
const heightValue = document.querySelector("#heightValue");
const heightInput = document.querySelector("#pokeHeight");
//Link the textual output to the current state of slider
heightValue.textContent = heightInput.value;
//Create event listener for the slider

heightInput.addEventListener("input", (event) => {
  heightValue.textContent = event.target.value;
});

//Weight
//queryselector to grab the value and input
const weightValue = document.querySelector("#weightValue");
const weightInput = document.querySelector("#pokeWeight");
//Link the textual output to the current state of slider
weightValue.textContent = weightInput.value;
//Create event listener for the slider

weightInput.addEventListener("input", (event) => {
  weightValue.textContent = event.target.value;
});
