const TARGET_BOX = document.querySelector("#target-box")
const GAME_STATUS_BTN = document.querySelector("#game-status-btn")
const GUESS_DISPLAY = document.querySelector("#guess-display")
const END_MSG_DISPLAY = document.querySelector("#end-msg-display")
const GAME_CONTROLS = document.querySelector("#game-controls")

const CORRECT_BTN = document.querySelector("#correct-btn")
const TOO_LOW_BTN = document.querySelector("#too-low-btn")
const TOO_HIGH_BTN = document.querySelector("#too-high-btn")
const CONTROL_BTNS = document.querySelectorAll(".control-btn")


let min
let max
let guess
let guessCount

function startGame ()
{
		TARGET_BOX.disabled = true
		GAME_STATUS_BTN.innerText = "Reset"

		guessCount = 1
		min = 1
		max = 100
		guess = Math.floor((min + max) / 2)
		GUESS_DISPLAY.innerText = guess

		GAME_CONTROLS.style.display = "block"
		for (const btn of CONTROL_BTNS)
		{
			btn.disabled = false
		}
}
function endGame () {
	END_MSG_DISPLAY.innerText = `I guessed your number in ${guessCount} guesses`
	for (const btn of CONTROL_BTNS)
	{
		btn.disabled = true
	}

	
}
function resetGame ()
{
	TARGET_BOX.disabled = false
		GAME_STATUS_BTN.innerText = "Start!"
		GUESS_DISPLAY.innerText = ""
		END_MSG_DISPLAY.innerText = ""
		GAME_CONTROLS.style.display = "none"
}
function lowerGuess ()
{
	max = guess
	guess = Math.ceil((min+ max) / 2)
	GUESS_DISPLAY.innerText = guess
	guessCount++
}
function raiseGuess ()
{
	max = guess
	guess = Math.floor((min+ max) / 2)
	GUESS_DISPLAY.innerText = guess
	guessCount++
}
function toggleGameStatus (){
	if (TARGET_BOX.disabled) 
	{
		resetGame()


	}else{
		startGame()
	}
}

GAME_STATUS_BTN.addEventListener('click', toggleGameStatus)
CORRECT_BTN.addEventListener('click', endGame)
TOO_HIGH_BTN.addEventListener('click', lowerGuess)
TOO_LOW_BTN.addEventListener('click', raiseGuess)