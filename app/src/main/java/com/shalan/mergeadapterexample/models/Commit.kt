package com.shalan.mergeadapterexample.models

import com.squareup.moshi.JsonClass

/**
 * Created by Mohamed Shalan on 4/12/20.
 */
@JsonClass(generateAdapter = true)
data class Commit(val id: String, val userId: String, val commit: String)
