package com.example.nit3213studentdashboardapplication.model

import com.google.gson.JsonObject

data class GenericResponse(
    val entities: List<JsonObject>,
    val entityTotal: Int
) 