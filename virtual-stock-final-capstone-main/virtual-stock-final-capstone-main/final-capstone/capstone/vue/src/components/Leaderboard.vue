<template>
  <div>
    <h1>Leaderboard</h1>
    <div class="tables">
        <table class="leaderboard-table">
          <tr class="head">
              <th>Player</th>
          </tr>
          <tr class="row" v-for="user in userList" v-bind:key="user.id">
              <td>{{user.username}}</td>
          </tr>
      </table>
      <table class="leaderboard-table">
          <tr class="head">
              <th>Cash Balance</th>
          </tr>
          <tr class="row" v-for="portfolio in portfolioList" v-bind:key="portfolio.id">
              <td>${{portfolio.cashBalance?.toFixed(2)}}</td>
          </tr>
      </table>
    </div>
  </div>
</template>

<script>
import userService from "../services/AuthService.js";
import stockService from "../services/StockService.js";
export default {
  data() {
    return {
      gameId: this.$route.params.id,
      userList: [],
      portfolioList: [],
    };
  },
  created() {
    userService.getUsers(this.gameId).then((response) => {
      this.userList = response.data;
    });

    stockService.getAllPortfolios(this.gameId).then((response) => {
      this.portfolioList = response.data;
    });
  },
};
</script>

<style scope>

h1 {
  text-align: center;
  color: white;
}

.tables {
    display: flex;
    justify-content: center;
}

.leaderboard-table tr:nth-child(odd) {
  background-color: #fff;
}

.leaderboard-table tr:nth-child(even) {
  background-color: #f1f1f1;
}

.leaderboard-table tr {
  border-bottom: 1px solid #ddd;
}

.leaderboard-table th:first-child,
.leaderboard-table td:first-child {
  padding-left: 20px;
}

.leaderboard-table td,
.leaderboard-table th {
  padding: 10px 10px;
  display: table-cell;
  text-align: left;
  vertical-align: top;
}

.leaderboard-table th {
  font-weight: bold;
}

.leaderboard-table {
  font-size: 16px !important;
  border: 1px solid #ccc;
  border-collapse: collapse;
  border-spacing: 0;
  width: 49%;
  display: table;
}
</style>