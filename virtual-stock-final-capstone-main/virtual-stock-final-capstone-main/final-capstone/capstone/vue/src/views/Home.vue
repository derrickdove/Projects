<template>
  <div class="home">
    <div class="header">
      <h1>Learning Today, Earning Tomorrow</h1>
      <h2>SmartStock Empowers Investors through Education</h2>
    </div>
    <div class="link-container">
      <div class="link stock-link">
        <router-link v-bind:to="{name: 'stock-analysis'}">
          <button class="link-btn">Search Stocks</button>
        </router-link>
      </div>
      <div class="link inner-link-container">
        <div class="game-link create-game">
          <router-link v-bind:to="{name: 'create-game'}">
            <button class="create">Create Game</button>
          </router-link>
        </div>
        <div class="game-link my-games">
          <router-link v-bind:to="{name: 'my-games'}">
            <button class="games">My Games</button>
          </router-link>
        </div>
      </div> 
    </div>
  </div>
</template>

<script>
export default {
  name: 'home',
  data() {
    return {
      showIframe: false
    };
  },
  methods: {
    showStockAnalysis() {
      this.showIframe = true;
    }
  }
}
</script>

<style scoped>
  *, html {
    font-family: system-ui,-apple-system,system-ui,"Segoe UI",Roboto,Ubuntu,"Helvetica Neue",sans-serif;
  }

  .home{
    background-color: white;
  }

  .header {
    background-color: #052641;
    color: white;
    padding: 5px 5px;
    text-align: center;
    /* border-radius: 10px; */
    margin-bottom: 5px;
    margin-top: -15px;
    border: solid 1px #052641;
   
  }

  h1 {
    font-size: 24px;
    margin-bottom: 10px;
  }

  h2 {
    font-size: 16px;
    font-style: italic;
    margin-bottom: 30px;
  }

  .link-container {
    display: flex;
    flex-direction: column;
    height: 90vh;
  }

  .link {
    /* border-radius: 10px; */
    margin-bottom: 10px;
    height: 100%;

    display: flex;
    align-items: center;
    justify-content: center;
  }

  .stock-link {
    background-color: transparent;
    background-image: url("C:\Users\Student\workspace\virtual-stock-final-capstone\final-capstone\capstone\vue\public\img\stock-market-graph-design-on-white-background-vector.jpg");
    background-size: cover;
    background-position: bottom 50%;
    /* border: solid 1.5px; */
    margin-bottom: -15px;
    border: solid 1px;
    height: 80vh
  }

  .inner-link-container {
    display: flex;
    /* background-image: linear-gradient(rgb(31, 31, 56), #cff5ea); */
    flex-basis: 45%;
    height: 15vh;
    justify-content: space-around;
  }

  .game-link {
    background-color: black;
    height: 100%;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    border: solid 1px
  }

  .create-game {
    background-color: #052641;
    background-size: cover;
      background-position: center;
    /* margin-right: 5px; */
    /* background-image: url("C:\Users\Student\workspace\virtual-stock-final-capstone\final-capstone\capstone\vue\public\img\c7fda15d5f26108c27845deb28afa9dc.jpg"); */
    align-items: center;
    margin-bottom: -25px;
    height: 93%;

  }

  .my-games {
    /* background-image: url("C:\Users\Student\workspace\virtual-stock-final-capstone\final-capstone\capstone\vue\public\img\360_F_588749573_CFBDPTgoyr7EB0whIo51COKoGYPTHCbQ.jpg"); */
    background-size: cover;
    background-position: center;
    margin-left: 5px;
    background-color: #052641;
    align-items: center;
    border: black 1px;
    border: solid 1px;
    margin-bottom: -25px;
    height: 93%;
  }

  .link-btn {
    border: 0;
    border: 1px solid #052641; 
    background-color: white; 
    border-radius: 0; 
    padding: 10px 20px; 
    font-size: 16px;
    color: #052641; 
    cursor: pointer;
    cursor: pointer;
    display: inline-block;
    font-size: 18px;
    font-weight: 600;
    outline: 0;
    padding: 16px 21px;
    position: relative;
    text-align: center;
    text-decoration: none;
    transition: all .3s;
    user-select: none;
    -webkit-user-select: none;
    touch-action: manipulation;
  }

.link-btn:hover {
  box-shadow: #052641 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
  transform: scale(1.05);
}

.create{
  border: 0;
    border: 1px solid white; 
    background-color: #052641;
    border-radius: 0; 
    padding: 10px 20px; 
    font-size: 16px;
    color: white; 
    cursor: pointer;
    cursor: pointer;
    display: inline-block;
    font-size: 18px;
    font-weight: 600;
    outline: 0;
    padding: 16px 21px;
    position: relative;
    text-align: center;
    text-decoration: none;
    transition: all .3s;
    user-select: none;
    -webkit-user-select: none;
    touch-action: manipulation;
}

.games{
  border: 0;
    border: 1px solid white; 
    background-color: #052641;
    border-radius: 0; 
    padding: 10px 20px; 
    font-size: 16px;
    color: white; 
    cursor: pointer;
    cursor: pointer;
    display: inline-block;
    font-size: 18px;
    font-weight: 600;
    outline: 0;
    padding: 16px 21px;
    position: relative;
    text-align: center;
    text-decoration: none;
    transition: all .3s;
    user-select: none;
    -webkit-user-select: none;
    touch-action: manipulation;
}

.create:hover {
  box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
  transform: scale(1.05);
}

.games:hover {
  box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
  transform: scale(1.05);
}
@media (min-width: 768px) {
  .link-btn {
    padding: 16px 48px;
  }

}
</style>
