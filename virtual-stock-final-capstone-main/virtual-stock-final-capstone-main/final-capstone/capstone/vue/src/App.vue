<template>
  <div id="app">
    <div id="nav">
      <img id="banner-logo-img" src="../public/img/smartstock-high-resolution-logo-color-on-transparent-background (1).png">
      <div class="links">
        <router-link v-bind:to="{ name: 'home' }">
          <button class="home-button">Home</button>
        </router-link>&nbsp;&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
          <button class="logout-button">Logout</button>
        </router-link>
      </div>
    </div>
    <router-view class="view"/>
    <div class="footer">
      &copy;
      <img id="footer-logo-img" src="../public/img/smartstock-high-resolution-logo-color-on-transparent-background (1).png">
    </div>
  </div>
</template>

<style scoped>
  *, html {
    font-family: system-ui,-apple-system,system-ui,"Segoe UI",Roboto,Ubuntu,"Helvetica Neue",sans-serif;
  }

  #app {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 100vh;
  }

  #nav {
    margin-bottom: 20px;
    background-color: #052641;
    padding: 10px;
    /* border-radius: 5px; */
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: sticky; top: 0;
  }

  .home-button, .logout-button {
    background-color: #052641;
    font-weight: bold;
    color: white;
    border: solid 1px;
    cursor: pointer;
    padding: 5px 10px;
    font-size: 14px;
    text-decoration: none;
  }

  .home-button:hover, .logout-button:hover {
    box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
  transform: scale(1.05);
  }


  #banner-logo-img {
    height: 50px;
    width: 170px;
    border-radius: 10px;
  }

  .links {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .footer {
    background-color: #052641;
    color: #cff5ea;
    display: flex;
    padding: 5px;
    /* border-radius: 5px; */
  }

  #footer-logo-img {
    height: 40px;
    border-radius: 10px;
    margin-left: 5px;
  }
</style>
