package com.example.weather

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var cityTextView: TextView
    private lateinit var forecastRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        cityTextView = findViewById(R.id.cityTextView)
        forecastRecyclerView = findViewById(R.id.forecastRecyclerView)
        progressBar = findViewById(R.id.progressBar)

        forecastRecyclerView.layoutManager = LinearLayoutManager(this)

        fetchWeatherData()
    }

    private fun fetchWeatherData() {
        if (!isNetworkAvailable()) {
            Toast.makeText(this, "无网络连接", Toast.LENGTH_LONG).show()
            return
        }

        val apiKey = "55151a9a13f97d49d7ee88ef7f4f6dce"
        if (apiKey == "YOUR_API_KEY") {
            Toast.makeText(this, "请替换为你的 API Key", Toast.LENGTH_LONG).show()
            return
        }

        progressBar.visibility = View.VISIBLE

        RetrofitClient.apiService.getWeather(city = "110101", apiKey = apiKey)
            .enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                    progressBar.visibility = View.GONE
                    if (response.isSuccessful) {
                        val weatherResponse = response.body()
                        if (weatherResponse != null && weatherResponse.status == "1") {
                            val forecast = weatherResponse.forecasts.firstOrNull()
                            if (forecast != null) {
                                cityTextView.text = forecast.city
                                forecastRecyclerView.adapter = ForecastAdapter(forecast.casts)
                            } else {
                                Toast.makeText(this@MainActivity, "未找到预报信息", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this@MainActivity, "API 错误: ${weatherResponse?.info}", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "请求失败: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@MainActivity, "发生错误: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }
}