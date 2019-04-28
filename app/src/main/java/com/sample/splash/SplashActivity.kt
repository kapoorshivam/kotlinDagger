package com.sample.splash

import android.os.Bundle
import com.sample.base.BaseActivity

internal class SplashActivity : BaseActivity<SplashActivityViewModel>() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun getViewModelClass(): Class<SplashActivityViewModel> {
    return SplashActivityViewModel::class.java
  }

}
