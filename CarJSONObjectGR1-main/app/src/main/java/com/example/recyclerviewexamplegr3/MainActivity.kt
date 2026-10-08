package com.example.recyclerviewexamplegr3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexamplegr3.model.CarCollection
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = "{\n" +
                "  \"collection\": {\n" +
                "    \"url\": \"/api/makes/v2?year=2020\",\n" +
                "    \"count\": 45,\n" +
                "    \"pages\": 1,\n" +
                "    \"total\": 45,\n" +
                "    \"next\": \"\",\n" +
                "    \"prev\": \"\",\n" +
                "    \"first\": \"/api/makes/v2?year=2020\",\n" +
                "    \"last\": \"\"\n" +
                "  },\n" +
                "  \"data\": [\n" +
                "    {\"id\": 1, \"name\": \"Acura\"},\n" +
                "    {\"id\": 24, \"name\": \"Alfa Romeo\"},\n" +
                "    {\"id\": 44, \"name\": \"Aston Martin\"},\n" +
                "    {\"id\": 2, \"name\": \"Audi\"},\n" +
                "    {\"id\": 25, \"name\": \"Bentley\"},\n" +
                "    {\"id\": 3, \"name\": \"BMW\"},\n" +
                "    {\"id\": 56, \"name\": \"Bugatti\"},\n" +
                "    {\"id\": 4, \"name\": \"Buick\"},\n" +
                "    {\"id\": 5, \"name\": \"Cadillac\"},\n" +
                "    {\"id\": 6, \"name\": \"Chevrolet\"},\n" +
                "    {\"id\": 26, \"name\": \"Chrysler\"},\n" +
                "    {\"id\": 27, \"name\": \"Dodge\"},\n" +
                "    {\"id\": 46, \"name\": \"Ferrari\"},\n" +
                "    {\"id\": 28, \"name\": \"FIAT\"},\n" +
                "    {\"id\": 29, \"name\": \"Ford\"},\n" +
                "    {\"id\": 7, \"name\": \"Genesis\"},\n" +
                "    {\"id\": 8, \"name\": \"GMC\"},\n" +
                "    {\"id\": 9, \"name\": \"Honda\"},\n" +
                "    {\"id\": 10, \"name\": \"Hyundai\"},\n" +
                "    {\"id\": 11, \"name\": \"INFINITI\"},\n" +
                "    {\"id\": 12, \"name\": \"Jaguar\"},\n" +
                "    {\"id\": 30, \"name\": \"Jeep\"},\n" +
                "    {\"id\": 31, \"name\": \"Karma\"},\n" +
                "    {\"id\": 13, \"name\": \"Kia\"},\n" +
                "    {\"id\": 32, \"name\": \"Lamborghini\"},\n" +
                "    {\"id\": 14, \"name\": \"Land Rover\"},\n" +
                "    {\"id\": 33, \"name\": \"Lexus\"},\n" +
                "    {\"id\": 15, \"name\": \"Lincoln\"},\n" +
                "    {\"id\": 45, \"name\": \"Lotus\"},\n" +
                "    {\"id\": 35, \"name\": \"Maserati\"},\n" +
                "    {\"id\": 16, \"name\": \"Mazda\"},\n" +
                "    {\"id\": 36, \"name\": \"McLaren\"},\n" +
                "    {\"id\": 37, \"name\": \"Mercedes-Benz\"},\n" +
                "    {\"id\": 17, \"name\": \"MINI\"},\n" +
                "    {\"id\": 18, \"name\": \"Mitsubishi\"},\n" +
                "    {\"id\": 19, \"name\": \"Nissan\"},\n" +
                "    {\"id\": 20, \"name\": \"Polestar\"},\n" +
                "    {\"id\": 38, \"name\": \"Porsche\"},\n" +
                "    {\"id\": 39, \"name\": \"Ram\"},\n" +
                "    {\"id\": 41, \"name\": \"Rolls-Royce\"},\n" +
                "    {\"id\": 21, \"name\": \"Subaru\"},\n" +
                "    {\"id\": 42, \"name\": \"Tesla\"},\n" +
                "    {\"id\": 22, \"name\": \"Toyota\"},\n" +
                "    {\"id\": 43, \"name\": \"Volkswagen\"},\n" +
                "    {\"id\": 23, \"name\": \"Volvo\"}\n" +
                "  ]\n" +
                "}"

        val carResponse = Gson().fromJson(result, CarCollection::class.java)
        val carNames = carResponse.data.map { it.name }

        val recyclerView = findViewById<RecyclerView>(R.id.rvCars)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CarAdapter(carNames)
    }
}
