
// program to shuffle the deck of cards

// declare card elements
const SHUFFLE_BTN = document.querySelector("#shuffleBtn")
const PRINT_BTN = document.querySelector("#printBtn")
const END_MSG_DISPLAY = document.querySelector("#end-msg-display")
const suits = ["Spades", "Diamonds", "Clubs", "Hearts"];
const values = [
  "Ace",
  "2",
  "3",
  "4",
  "5",
  "6",
  "7",
  "8",
  "9",
  "10",
  "Jack",
  "Queen",
  "King",
];

// empty array to contain cards
let deck = [];
let deckString = ""

// create a deck of cards
for (let i = 0; i < suits.length; i++) {
    for (let x = 0; x < values.length; x++) {
        let card = { Value: values[x], Suit: suits[i] };
        deck.push(card);
    }
}

// shuffle the cards
function shuffleCards()
{
    for (let i = deck.length - 1; i > 0; i--) {
    let j = Math.floor(Math.random() * i);
    let temp = deck[i];
    deck[i] = deck[j];
    deck[j] = temp;
}
}

function printDeck()
{
    document.getElementById("displayingDeck").innerHTML = ('Displaying Entire Deck:');
    deckString = ""

    for (let i = 0; i < deck.length; i++) 
    {
        deckString += (`${deck[i].Value} of ${deck[i].Suit}, `)
    }
    document.getElementById("deckDisplay").innerHTML = deckString
// display  results

}
SHUFFLE_BTN.addEventListener('click', shuffleCards)
PRINT_BTN.addEventListener('click', printDeck)
