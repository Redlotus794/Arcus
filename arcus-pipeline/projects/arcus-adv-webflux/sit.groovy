@Library('shared-libs') _

buildAndDeployTemplate_20250801([
        imageName: 'arcus-adv-webflux',
        projectDir: 'arcus-starter-webflux-parent/arcus-adv-webflux',
        profiles: 'sit',  // 改为使用 profiles
])

