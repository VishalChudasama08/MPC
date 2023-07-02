
let RandomNumber = Math.round(Math.random() * 100);
console.log("Guess of a number between 1 to 100 that is equal to a random number. So You winner\n");
let GuessNumber = prompt("Guess Number between 1 to 100 :- ");
let GuessNumber_try = 1;
if (RandomNumber != GuessNumber) {
  console.log("Number is not equal to Random number\n");
}
while (RandomNumber != GuessNumber) {
  if (GuessNumber > RandomNumber) {
      console.log("Your Guess Number is bigger and Random Number is smaller\n");
  }
  if (GuessNumber < RandomNumber) {
     console.log("Your Guess Number is smaller and Random Number is bigger\n");
  }
  GuessNumber = prompt("guess number again :- ");
  GuessNumber_try++;
}
if (RandomNumber = GuessNumber) {
  console.log("\nCongratulations! Your Guess Number is sem as Random Number\n", "You tried =", GuessNumber_try);
  console.log("Your Score is ", 100 - GuessNumber_try);
} 