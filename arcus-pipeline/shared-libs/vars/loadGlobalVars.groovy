def call() {
    def props = readProperties file: 'arcus-pipeline/config/global-vars.config'
    env.K8S_DEPLOY_CONFIG = props.K8S_DEPLOY_CONFIG
}