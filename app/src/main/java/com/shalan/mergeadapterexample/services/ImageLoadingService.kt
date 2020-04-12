package com.shalan.mergeadapterexample.services

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import org.koin.core.KoinComponent

/**
 * Created by Mohamed Shalan on 4/12/20.
 */
interface ImageLoadingService: KoinComponent {

	fun loadRoundedImg(url: String, iv: ImageView, placeholder: Drawable?)
}
