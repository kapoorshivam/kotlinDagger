package com.sample.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

internal abstract class BaseActivity<T : ViewModel> : DaggerAppCompatActivity() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  private lateinit var mutableViewModel: T

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    supportActionBar?.elevation = 0F
    supportActionBar?.setHomeButtonEnabled(true)
  }

  protected abstract fun getViewModelClass(): Class<T>

}