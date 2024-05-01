package com.example.astra.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

data class Vehicle(val id: Int, val name: String)



val vehicleList = listOf(
    Vehicle(1, "Vehicle 1"),
    Vehicle(2, "Vehicle 2"),
    Vehicle(3, "Vehicle 3"),
    Vehicle(4, "Vehicle 4"),
    Vehicle(5, "Vehicle 5")
)


@Composable
fun VehicleList() {
    LazyColumn {
        items(vehicleList) { vehicle ->
            VehicleItem(vehicle)
        }
    }
}

@Composable
fun VehicleItem(vehicle: Vehicle) {
    val navController = rememberNavController()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("VehicleDetails/${vehicle}")
            }
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "ID: ${vehicle.id}")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = vehicle.name)
        }
    }
}