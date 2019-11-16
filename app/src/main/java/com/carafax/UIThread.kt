package com.carafax

import com.carafax.domain.executor.PostExecutionThread
import rx.Scheduler
import javax.inject.Inject
import javax.inject.Singleton
import rx.android.schedulers.AndroidSchedulers

/**
 * MainThread (UI Thread) implementation based on a [rx.Scheduler]
 * which will execute actions on the Android UI thread
 */
@Singleton
class UIThread @Inject
constructor() : PostExecutionThread {
    override val scheduler: Scheduler get() =  AndroidSchedulers.mainThread()
}