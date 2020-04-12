package com.shalan.mergeadapterexample.services

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.koin.core.inject

/**
 * Created by Mohamed Shalan on 4/12/20.
 */
class ImageLoadingServiceImp() : ImageLoadingService {

	private val context: Context by inject()

	override fun loadRoundedImg(url: String, iv: ImageView, placeholder: Drawable?) {
		Glide.with(context).load(url).apply(RequestOptions.circleCropTransform())
			.placeholder(placeholder).into(iv)
	}
}
