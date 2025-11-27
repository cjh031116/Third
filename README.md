# 天气预报安卓应用

一个简单的安卓应用程序，用于显示特定城市的天气预报。

## 📖 描述

本应用从高德地图Web服务API获取天气数据并呈现给用户。它会显示当前城市以及未来几天的天气预报列表，包括日期、白天/夜间温度和天气状况。

## ✨ 功能

- 显示未来的天气预报列表。
- 显示预报对应的城市名称。
- 处理没有网络连接时的情况。
- 获取数据时显示加载指示器。

## 🛠️ 技术栈

- **语言:** [Kotlin](https://kotlinlang.org/)
- **框架:** 原生安卓SDK
- **网络请求:** [Retrofit](https://square.github.io/retrofit/) & [OkHttp](https://square.github.io/okhttp/)
- **UI:** [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) 用于显示列表。
- **架构:** 基于单个Activity的简单结构。

## 🚀 安装与运行

要构建和运行此项目，请按照以下步骤操作：

1.  **克隆仓库:**
    ```bash
    git clone https://github.com/cjh031116/Third.git
    ```
2.  **在Android Studio中打开:**
    在Android Studio中打开克隆的目录，等待Gradle同步项目。

3.  **获取高德API密钥:**
    本项目使用高德地图Web服务API来获取天气数据。您需要获取自己的免费API密钥。
    - 前往 [高德开放平台控制台](https://console.amap.com/)。
    - 创建一个新应用并添加一个新Key。
    - 选择“Web服务”作为服务平台。
    - 您的API密钥将会生成。

4.  **将API密钥添加到项目中:**
    - 打开 `app/src/main/java/com/example/weather/MainActivity.kt` 文件。
    - 找到以下代码行：
      ```kotlin
      val apiKey = "YOUR_API_KEY" 
      ```
    - 将其替换为您在上一步中获取的密钥。

5.  **运行应用:**
    在安卓模拟器或物理设备上构建并运行该应用。

## 📝 注意

目前，城市在 `MainActivity.kt` 中被硬编码为“北京”（城市代码 `110101`）。您可以更改 `getWeather` API调用中的 `city` 参数，以显示不同城市的天气预报。


