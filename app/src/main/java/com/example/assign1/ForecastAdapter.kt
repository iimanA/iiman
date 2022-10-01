package com.example.assign1
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class ForecastAdapter (private val data: List<DayForecast>) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val dateView: TextView = view.findViewById(R.id.date)
        private val sunriseView: TextView = view.findViewById(R.id.sunrise)
        private val sunsetView: TextView = view.findViewById(R.id.sunset)
        private val tempViewHigh: TextView = view.findViewById(R.id.low)
        private val tempViewLow: TextView = view.findViewById(R.id.low)
        private val tempView: TextView = view.findViewById(R.id.temp)

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(data: DayForecast) {
            dateView.text = data.date.toString()


            val instant = Instant.ofEpochSecond(data.date.toLong())
            val dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
            val formatter = DateTimeFormatter.ofPattern("MMM dd")
            dateView.text = formatter.format(dateTime)






            val sunriseInstant = Instant.ofEpochSecond(data.sunrise)
            val sunriseTime = LocalDateTime.ofInstant(sunriseInstant, ZoneId.systemDefault())
            val sunriseFormatter = DateTimeFormatter.ofPattern("HH:MM a")

            sunriseView.text = "Sunrise: " + sunriseFormatter.format(sunriseTime)

            val sunsetInstant = Instant.ofEpochSecond(data.sunset)
            val sunsetTime = LocalDateTime.ofInstant(sunsetInstant, ZoneId.systemDefault())
            val sunsetFormatter = DateTimeFormatter.ofPattern("HH:MM a")

            sunsetView.text = "Sunset: " + sunsetFormatter.format(sunsetTime)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_current_conditions, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}