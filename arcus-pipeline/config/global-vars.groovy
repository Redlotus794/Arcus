#!/usr/bin/env groovy

// 全局变量配置文件
// 返回一个包含所有全局变量的 Map

return [
    ARCUS_GIT_REPO_URL: "https://github.com/Redlotus794/Arcus.git",
    // K8s 部署配置
    K8S_DEPLOY_CONFIG: "k8s/deployment.yaml",

]
