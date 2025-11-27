package com.example.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ForecastAdapter(private val forecasts: List<Cast>) : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateTextView: TextView = view.findViewById(R.id.dateTextView)
        val weatherTextView: TextView = view.findViewById(R.id.weatherTextView)
        val tempTextView: TextView = view.findViewById(R.id.tempTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val forecast = forecasts[position]
        holder.dateTextView.text = "${forecast.date} (星期${forecast.week})"
        holder.weatherTextView.text = "天气: ${forecast.dayweather}"
        holder.tempTextView.text = "温度: ${forecast.nighttemp}°C / ${forecast.daytemp}°C"
    }

    override fun getItemCount() = forecasts.size
}

