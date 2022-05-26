const path = require("path");

module.exports = {
  outputDir: "../build/resources/main/static",
  // assetsDir: "../build/resources/main/static",
  // indexPath: "../templates/index.html",
  devServer: {
    client: {
      overlay: false,
    },
  },
  configureWebpack: {
    resolve: {
      alias: {
        "@": path.join(__dirname, "src/views/"),
      },
    },
  },
};
