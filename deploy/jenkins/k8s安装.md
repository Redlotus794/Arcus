
- Jenkins k8s部署

  ```shell
  cd deploy/jenkins
  kubectl apply -f jenkins-pvc.yaml -n arucs
  kubectl apply -f jenkins-deployment.yaml -n arcus
  kubectl apply -f jenkins-service.yaml -n arcus
  
  ```

账号： arcus / 123456
