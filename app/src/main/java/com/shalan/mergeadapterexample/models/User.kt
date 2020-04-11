package com.shalan.mergeadapterexample.models

import com.squareup.moshi.JsonClass

/**
 * Created by Mohamed Shalan on 4/12/20.
 */

@JsonClass(generateAdapter = true)
data class User(val id: String, val name: String, val avatar: String)
