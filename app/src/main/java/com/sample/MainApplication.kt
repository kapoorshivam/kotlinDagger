package com.sample

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainApplication : Application(), HasActivityInjector {

  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()
    initializeAppInjector()
  }

  private fun initializeAppInjector() {
    AppInjector.init(this)
  }

  override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
    return dispatchingAndroidInjector
  }

  object AppInjector {
    fun init(kotlinApplication: MainApplication) {
      DaggerApplicationComponent.builder()
          .application(kotlinApplication)
          .build()
          .inject(kotlinApplication)

      kotlinApplication.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {

        override fun onActivityCreated(
          activity: Activity,
          savedInstanceState: Bundle?
        ) {
          handleActivity(activity)
        }

        override fun onActivityStarted(activity: Activity) {

        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(
          activity: Activity,
          outState: Bundle
        ) {

        }

        override fun onActivityDestroyed(activity: Activity) {

        }
      })
    }

    private fun handleActivity(activity: Activity) {
      if (activity is HasSupportFragmentInjector) {
        AndroidInjection.inject(activity)
      }
      (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
          object : FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentCreated(
              fm: FragmentManager,
              f: Fragment,
              savedInstanceState: Bundle?
            ) {

            }
          }, true
      )
    }
  }
}
