package com.sample.injection.module

import android.content.Context
import com.sample.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal open class ApplicationModule {

  @Singleton
  @Provides
  internal fun provideContext(application: MainApplication): Context {
    return application
  }
}
