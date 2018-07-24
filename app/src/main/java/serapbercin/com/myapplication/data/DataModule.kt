package serapbercin.com.myapplication.data

import dagger.Binds
import dagger.Module
import serapbercin.com.myapplication.data.api.ApiModule
import serapbercin.com.myapplication.data.repo.EventRepository
import serapbercin.com.myapplication.data.repo.EventRepositoryImpl
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
abstract class DataModule {

	@Singleton
	@Binds
	abstract fun provideEventRepository(eventRepositoryImpl: EventRepositoryImpl):
			EventRepository

}