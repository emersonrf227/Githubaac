package com.example.logonrmlocal.githubaac.di.modules

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import com.example.logonrmlocal.githubaac.data.local.MeuBancoDeDados
import com.example.logonrmlocal.githubaac.data.local.dao.UserDao
import com.example.logonrmlocal.githubaac.data.local.empty.User
import com.example.logonrmlocal.githubaac.data.remote.UserWebService
import com.example.logonrmlocal.githubaac.data.repositories.UserRepository
import com.facebook.stetho.okhttp3.StethoInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import okhttp3.OkHttpClient
import java.util.concurrent.Executor
import java.util.concurrent.Executors





@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): MeuBancoDeDados {
        return Room.databaseBuilder(
                application,
                MeuBancoDeDados::class.java, "MeuBancoDeDados"
        )
                .build()
    }


    @Provides
    @Singleton
    fun provideOkhttp() : OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build();
    }


    @Provides
    @Singleton
    fun provideUserDao(database: MeuBancoDeDados): UserDao {
        return database.userDao()
    }
    @Provides
    fun provideExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }
    @Provides
    @Singleton
    fun provideUserRepository(
            webservice: UserWebService,
            userDao: UserDao,
            executor: Executor
    ): UserRepository {
        return UserRepository(webservice, userDao, executor)
    }
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.github.com")
                .client(okHttpClient)
                .build()
    }
    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): UserWebService {
        return restAdapter.create(UserWebService::class.java)
    }
    companion object {
        private val BASE_URL = "https://api.github.com/"
    }
}