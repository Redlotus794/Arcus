def call() {
    script {
        // The config file path is relative to the workspace root
        def configFile = 'arcus-pipeline/config/global-vars.groovy'

        echo "Loading global variables from ${configFile}"

        // Load the groovy script. The script returns a Map.
        def globalVars = load configFile

        // Iterate over the map and set environment variables
        globalVars.each { key, value ->
            echo "Setting environment variable: ${key}=${value.toString()}"
            env[key] = value.toString()
        }
    }
}
