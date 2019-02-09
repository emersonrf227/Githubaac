package com.example.logonrmlocal.githubaac.di.components

import android.app.Application
import com.example.logonrmlocal.githubaac.MyApp
import dagger.BindsInstance
import com.example.logonrmlocal.githubaac.di.modules.ActivityModule
import com.example.logonrmlocal.githubaac.di.modules.AppModule
import com.example.logonrmlocal.githubaac.di.modules.FragmentModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
        modules = [AndroidSupportInjectionModule::class, ActivityModule::class,
            FragmentModule::class, AppModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent

    }
    fun inject(app: MyApp)
}
