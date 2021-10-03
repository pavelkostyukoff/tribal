package covenant.tribal.di

import covenant.tribal.ui.feed.FeedViewModel
import covenant.tribal.domain.usecase.GetFeedUseCase
import covenant.tribal.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module =  module {
    viewModel { FeedViewModel(get()) }
    factory { GetFeedUseCase(get()) }
    viewModel { LoginViewModel() }
}