# Jenkins 

## 安装Jenkins

- 使用kubectl 安装deploy/jenkins目录下内容

- Homebrew安装

```
brew install jenkins-lts
brew services start jenkins-lts

# 更改配置文件
sudo launchctl bootout gui/$(id -u) ~/Library/LaunchAgents/homebrew.mxcl.jenkins-lts.plist
sudo launchctl bootstrap gui/$(id -u) ~/Library/LaunchAgents/homebrew.mxcl.jenkins-lts.plist
```



## 使用注意

### Github App

- 凭证中管理Github APP信息，其中 key是需要从github下载下来的pem文件中读取到的

### Maven

- 编译java 需要安装Maven Integration Plugins
- 使用流水线时，需要安装Pipeline Maven Plugins

### 环境变量

- jenkins用户执行时，可能没有当前用户的环境变量配置信息，需要在文件中添加

  ```
  <key>EnvironmentVariables</key>
  <dict>
  	<key>PATH</key>					<string>/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Applications/Docker.app/Contents/Resources/bin</string>
  </dict>
  ```

  