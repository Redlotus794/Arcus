@Library('shared-libs') _

buildAndDeployTemplate_20250801([
        gitBranch: 'main',
        imageName: 'arcus-gateway',
        imageTag: 'lts',
        namespace: 'arcus',
        projectDir: 'arcus-gateway',
])