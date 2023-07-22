<template>
  <div class="game-card">
    <h1>{{ game.gameName }}</h1>
    <div class="game-info">
      <p>
        Account Value:&nbsp;&nbsp;${{ (stockValue + portfolio.cashBalance)?.toFixed(2) }}
      </p>
      <h2>Organized By: <br />{{ game.organizerName }}</h2>
    </div>
    <div class="buy-info">
      <span>Cash Balance:&nbsp;&nbsp;${{ portfolio.cashBalance?.toFixed(2) }}</span>
      <form class="buy-form" v-on:submit.prevent="buy">
        <input type="text" placeholder="Symbol" v-model="stock.ticker" />
        <input type="number" placeholder="Quantity" v-model="stock.quantity" />
        <button type="submit" class="buy">Buy</button>
      </form>
    </div>
    <div class="portfolio-container">
      <table class="portfolio">
        <tr class="head">
          <th>Ticker:</th>
          <th>Quantity:</th>
          <th>Value:</th>
          <th></th>
        </tr>
        <tr
          class="row"
          v-for="stockPortfolio in stockList"
          v-bind:key="stockPortfolio.id"
        >
          <td>{{ stockPortfolio.ticker }}</td>
          <td>{{ stockPortfolio.quantity }}</td>
          <td>${{ stockPortfolio.value?.toFixed(2) }}</td>
          <td class="sell-row">
            <button class="sell" v-on:click="sell(stockPortfolio)">Sell</button>
          </td>
        </tr>
      </table>
    </div>
    <div class="add-user" v-if="user == game.organizerName">
      <h3>Add Player to Game</h3>
      <form v-on:submit.prevent="addUser">
        <input type="text" placeholder="Username" v-model="newUser.username" />
        <button type="submit" class="add-user-btn">Add User</button>
      </form>
    </div>
  </div>
</template>

<script>
import stockService from "../services/StockService.js";
import polygonService from "../services/PolygonService.js";
export default {
  data() {
    return {
      gameId: this.$route.params.id,
      game: {},
      portfolio: {},
      stockList: [],
      stock: {
        ticker: "",
        quantity: "",
      },
      newUser: {
        username: "",
      },
      user : this.$store.state.user.username,
    };
  },
  computed: {
    stockValue() {
      let sum = 0;
      this.stockList.forEach((s) => {
        sum += s.value;
      });
      return sum;
    },
  },
  methods: {
    buy() {
      polygonService
        .getResults(this.stock.ticker)
        .then((response) => {
          let price = response.data.close;
          stockService
            .buy(this.stock, price, this.gameId)
            .then((response) => {
              if (response.status == 200) {
                alert("Your purchase was successful!");
                this.$router.go();
              }
            })
            .catch((e) => {
              console.log(e.response);
            });
        })
        .catch((e) => {
          console.log(e.response);
        });
    },
    sell(stockPortfolio) {
      polygonService.getResults(stockPortfolio.ticker).then((response) => {
        let price = response.data.close;
        stockService
          .sell(price, this.gameId, stockPortfolio.id)
          .then((response) => {
            if (response.status == 200) {
              alert("Your sale was succesful!");
              this.$router.go();
            }
          });
      });
    },
    addUser() {
      stockService
        .addUserToGame(this.gameId, this.newUser.username)
        .then((response) => {
          if (response.status === 200) {
            alert("User added to the game successfully.");
            this.newUser.username = "";
            this.$router.go();
          }
        })
        .catch((error) => {
          console.error(error);
          alert("Failed to add the user to the game.");
        });
    },
  },
  created() {
    stockService.getGame(this.gameId).then((response) => {
      this.game = response.data;
    });

    stockService.getPortfolio(this.gameId).then((response) => {
      this.portfolio = response.data;
    });

    stockService.getPortfolioStocks(this.gameId).then((response) => {
      this.stockList = response.data;
      this.stockList.forEach((s) => {
        polygonService.getResults(s.ticker).then((response) => {
          let price = response.data.close;
          s.value = price * s.quantity;
        });
      });
    });
  },
};
</script>

<style scope>
*,
html {
  font-family: system-ui, -apple-system, system-ui, "Segoe UI", Roboto, Ubuntu,
    "Helvetica Neue", sans-serif;
}
.game-card {
  background: #9daac8;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.game-info {
  display: flex;
  justify-content: space-between;
  padding: 0px 20px;
  font-size: 14px;
}

.game-info p,
.buy-info span {
  font-size: 17px;
}

.game-info p {
  border-bottom: 1px solid white;
  padding-bottom: 25px;
}

.game-info h2 {
  text-align: center;
  font-size: 16px;
}

.buy,
.sell {
  border-radius: 5px;
  background-color: #052641;
  font-weight: bold;
  color: white;
  border: solid 1px;
  cursor: pointer;
  padding: 5px 10px;
  font-size: 14px;
  text-decoration: none;
}

.buy:hover, 
.sell:hover,
.add-user-btn:hover {
  box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
  transform: scale(1.05);
}

.buy-info {
  padding: 0px 20px 20px 20px;
  display: flex;
  justify-content: space-between;
}

.buy-form input {
  margin: 0px 5px;
}

.portfolio-container {
  display: flex;
  justify-content: center;
  padding-bottom: 10px;
}

.portfolio {
  font-size: 13px !important;
  border: 1px solid #ccc;
  border-collapse: collapse;
  border-spacing: 0;
  width: 98%;
  display: table;
  color: #052641;
}

.portfolio tr:nth-child(odd) {
  background-color: #fff;
}

.portfolio tr:nth-child(even) {
  background-color: #f1f1f1;
}

.portfolio tr {
  border-bottom: 1px solid #ddd;
}

.portfolio th:first-child,
.portfolio td:first-child {
  padding-left: 20px;
}

.portfolio td,
.portfolio th {
  padding: 10px 10px;
  display: table-cell;

  vertical-align: top;
}

.portfolio th {
  font-weight: bold;
  text-align: left;
}

.sell-row {
  text-align: right;
}
</style>
