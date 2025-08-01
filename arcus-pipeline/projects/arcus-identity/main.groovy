@Library('shared-libs') _

buildAndDeployTemplate_20250801([
        imageName: 'arcus-identity',
        projectDir: 'arcus-identity',
        profiles: 'sit'  // 改为使用 profiles
])

