package com.shalan.mergeadapterexample.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.shalan.mergeadapterexample.services.ImageLoadingServiceImp

/**
 * Created by Mohamed Shalan on 4/12/20.
 */

@BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
fun setImageUrl(view: ImageView, url: String?, placeholder: Drawable?) {
	val imageLoading = ImageLoadingServiceImp()
	if (placeholder != null && url != null) {
		imageLoading.loadRoundedImg(url, view, placeholder)
	} else if (url != null) {
		imageLoading.loadRoundedImg(url, view, null)
	} else if (placeholder != null) {
		view.setImageDrawable(placeholder)
	}
}
