import { createApp } from "vue";
import { router } from "./routes/router.js";
import App from "./App.vue";
import GlobalComponent from "./components/GlobalComponent.vue";

console.log(App);

createApp(App)
  .component("global-component", GlobalComponent)
  .use(router)
  .mount("#app");
