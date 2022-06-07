const path = require("path");

module.exports = {
  outputDir: "../build/resources/main/static",
  // assetsDir: "../build/resources/main/static",
  // indexPath: "../templates/index.html",
  devServer: {
    client: {
      overlay: false,
    },
    proxy: {
      '/api': {
        target: process.env.VUE_APP_API_BASE_URL || "http://localhost:8081",
        changeOrigin: true
      },
      // '/chat': {
      //   target: process.env.VUE_APP_API_BASE_URL || "http://localhost:8081",
      //   changeOrigin: true
      // }
    }
  },
  configureWebpack: {
    resolve: {
      alias: {
        "@": path.join(__dirname, "src"),
        styles: path.join(__dirname, "src/assets/scss"),
        // "@": path.join(__dirname, "src/views/"),
        "@@": path.join(__dirname, "design"),
      },
      extensions: [".png", ".jpg", ".vue", ".js", ".scss"],
    },
  },
  css: {
    loaderOptions: {
      sass: {
        additionalData: `
          @import "styles/_variables.scss";
        `,
      },
    },
  },
};
