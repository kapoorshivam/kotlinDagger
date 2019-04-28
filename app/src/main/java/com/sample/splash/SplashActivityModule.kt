package com.sample.splash

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import com.sample.injection.view_model.ViewModelKey

@Module
internal abstract class SplashActivityModule {

  @ContributesAndroidInjector
  internal abstract fun splashActivity(): SplashActivity

  @Binds
  @IntoMap
  @ViewModelKey(SplashActivityViewModel::class)
  abstract fun bindSplashActivityViewModel(viewModel: SplashActivityViewModel): ViewModel

}
