<template>
  <div class="createGame">
    <div class="instructions">
      <h1>How to Play</h1>
      <ol>
        <li>
          Your initial virtual currency or investment amount is set to $100,000!
          This is the amount of money you will use to buy and sell stocks within
          the game.
        </li>
        <li>
          Research and explore available stocks you are interested. Analyze
          their historical performance, current prices, company news, and any
          other relevant information provided.
        </li>
        <li>
          Use the game's interface to buy stocks. Enter the ticker symbol, the
          quantity of shares you want to buy, and confirm your purchase.
        </li>
        <li>
          Monitor your portfolio. Keep track of the stocks you own, their
          current prices, and the overall value of your holdings to make
          informed decisions to buy or sell stocks.
        </li>
        <li>
          Keep playing! Adjust your investment strategy, buying or selling
          stocks as needed, to maximize your profits and portfolio value.
          Explore our competitions, challenges, and leaderboards to learn more!
        </li>
      </ol>
    </div>
    <div id="form-container">
      <form v-on:submit.prevent="createGame">
        <h1>Create Your Game</h1>
        <div class="form-input-group">
          <label for="name" id="gamename">Game Name</label>
          <input type="text" id="text" v-model="newGame.gameName" />
        </div>
        <div class="form-input-group">
          <label for="date" id="end">End Date</label>
          <input type="date" id="date" v-model="newGame.endDate" />
        </div>
        <div>
          <button type="submit" id="create">Create</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import stockService from "../services/StockService.js";
export default {
  data() {
    return {
      newGame: {},
    };
  },
  methods: {
    createGame() {
      stockService.createGame(this.newGame).then((response) => {
        if (response.status === 201) {
          this.newGame = {};
          this.$router.push({ name: "my-games" });
        }
      });
    },
  },
};
</script>

<style scoped>

.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}

#form-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 35vh;

  text-align: center;
  background-color: #052641;
  color: white;
  /* border-radius: 10px; */
  border: 1px solid black;
}
#create{
  background-color: #052641;
    font-weight: bold;
    color: white;
    border: solid 1px;
    cursor: pointer;
    padding: 5px 10px;
    font-size: 14px;
    text-decoration: none;
}

#create:hover{
   box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
  transform: scale(1.05);
}

#end{
  background-color: #052641;
    font-weight: bold;
    color: white;
    cursor: pointer;
    padding: 5px 10px;
    font-size: 14px;
    text-decoration: none;
}

#gamename{
  background-color: #052641;
    font-weight: bold;
    color: white;
    cursor: pointer;
    padding: 5px 10px;
    font-size: 14px;
    text-decoration: none;
}

.instructions {
  /* border-radius: 10px; */
  padding: 20px 10px 20px 0px;
  margin-top: -10px;
  margin-bottom: 10px;
  border: 1px solid rgb(31, 31, 56);
  display: flex;
  flex-direction: column;
  align-items: center;
}

.instructions ol {
  line-height: 3;
}
</style>