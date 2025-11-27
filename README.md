# Weather App

这是一个简单的天气预报安卓应用，它使用高德天气 API 来获取并显示天气信息。

## 功能

*   获取并显示指定城市的天气信息。
*   以列表形式展示未来几天的天气预报。
*   在数据加载时显示进度条。

## 开始

请按照以下说明在本地设置项目。

### 环境

*   Android Studio
*   Android SDK

### 安装

1.  **克隆仓库**

    ```bash
    git clone https://github.com/your-username/weather-app.git
    ```

2.  **在 Android Studio 中打开**

    在 Android Studio 中，选择 "Open an existing Android Studio project"，然后选择克隆的仓库目录。

3.  **配置 API 密钥**

    *   前往 [高德开放平台](https://console.amap.com/dev/key/app) 注册并获取您的 API 密钥。
    *   在 `app/src/main/java/com/example/weather/network/ApiClient.java` (如果不存在，请创建) 或您的网络请求模块中，将 `"YOUR_API_KEY"` 替换为您的 API 密钥。

## 使用

1.  **运行应用**

    在 Android Studio 中，选择一个模拟器或连接一个物理设备，然后点击 "Run" 按钮。

2.  **查看天气**

    应用启动后，它将自动加载并显示默认城市的天气信息。

## 项目结构

*   `app/src/main/java/com/example/weather/`
    *   `MainActivity.java`: 应用的主活动，负责 UI 交互和数据显示。
    *   `network/`: 包含所有与网络相关的类。
        *   `ApiClient.java`: Retrofit 客户端配置。
        *   `ApiService.java`: 定义 API 端点。
    *   `model/`: 包含数据模型类。
    *   `adapter/`: 包含 RecyclerView 的适配器。
*   `app/src/main/res/`
    *   `layout/`: 包含所有布局文件。
    *   `drawable/`: 包含所有图片资源。
    *   `values/`: 包含字符串、颜色等资源。

## 技术栈

*   [Retrofit](https://square.github.io/retrofit/) - 用于处理网络请求的 HTTP 客户端。
*   [Gson](https://github.com/google/gson) - 用于解析 JSON 数据的 Java 库。
*   [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) - 用于高效显示大型数据集的 UI 组件。

