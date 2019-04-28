package com.sample.injection

import android.app.Application
import com.sample.MainApplication
import com.sample.injection.module.ApplicationModule
import com.sample.splash.SplashActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (ApplicationModule::class), (SplashActivityModule::class)])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(mainApplication: MainApplication)
}


