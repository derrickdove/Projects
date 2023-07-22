import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import CreateGameView from '../views/CreateGameView.vue'
import MyGamesView from '../views/MyGamesView.vue'
import ViewGame from '../views/ViewGame.vue'
import StockAnalysis from '../views/StockAnalysis.vue';

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/create-game",
      name: "create-game",
      component: CreateGameView,
      meta: {
        requiresAuth: true
      }
    },
    {
      
      path: "/my-games/",
      name: "my-games",
      component: MyGamesView,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/view-game/:id',
      name: 'view-game',
      component: ViewGame,
      meta: {
        requiresAuth: true,
      },
    },
    {
      path: '/stock-analysis', // Add the path for stock analysis
      name: 'stock-analysis',
      component: StockAnalysis, // Add the StockAnalysis view component here
      meta: {
        requiresAuth: true,
      },
    },
  ],
});

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
