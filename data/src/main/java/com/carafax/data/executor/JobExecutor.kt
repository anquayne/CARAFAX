package com.carafax.data.executor

import com.carafax.domain.executor.ThreadExecutor
import java.util.concurrent.*
import javax.inject.Inject

/**
 * class that manages all threads that are not of the main thread by using thread pool to
 * enhance performance when executing multiple asynchronous task
 * */
class JobExecutor  @Inject constructor() : ThreadExecutor {

    companion object {

        private const val INITIAL_POOL_SIZE = 5
        private const val MAX_POOL_SIZE = 10

        // Sets the amount of time an idle thread waits before terminating
        private const val KEEP_ALIVE_TIME = 10

        // Sets the Time Unit to seconds
        private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    }

    private val workQueue: BlockingQueue<Runnable>

    private val threadPoolExecutor: ThreadPoolExecutor

    private val threadFactory: ThreadFactory

    init {
        this.workQueue = LinkedBlockingQueue()
        this.threadFactory = JobThreadFactory()
        threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT, this.workQueue, this.threadFactory)
    }

    override fun execute(runable: Runnable?) {
        threadPoolExecutor.execute(runable)
    }

    private class JobThreadFactory : ThreadFactory{
        var counter : Int = 1
        override fun newThread(runable: Runnable?): Thread {
            return Thread(runable, "RideFlag$counter")
        }
    }
}