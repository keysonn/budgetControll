package com.example.budgetcontroll

import java.io.Serializable

data class ChangesHistory(var from: String, var where: String, var change: String): Serializable
