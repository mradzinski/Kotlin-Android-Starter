/*
 * Copyright (c) 2017. DNA Software. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu

import android.content.Context
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatDelegate
import com.coolcows.heyu.common.logging.TimberProductionTree
import com.coolcows.heyu.di.navigationModule
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.conf.KodeinGlobalAware
import com.github.salomonbrys.kodein.conf.global
import com.github.salomonbrys.kodein.singleton
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber

class App: MultiDexApplication(), KodeinGlobalAware {

    companion object {
        lateinit var refWatcher: RefWatcher
    }

    override fun onCreate() {
        super.onCreate()

        // LeakCanary instansiation
        if (LeakCanary.isInAnalyzerProcess(this)) { return }

        refWatcher = LeakCanary.install(this)

        // Init DI
        initKodein()

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(TimberProductionTree())
        }

        // Enable compat vector resources
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        // RxJava init to allow swallowing errors
        RxJavaPlugins.setErrorHandler { /* no-op */ }
        RxJavaPlugins.lockdown()
    }

    private fun initKodein() {
        Kodein.global.mutable = false
        Kodein.global.addImport(navigationModule)
        Kodein.global.addConfig {
            bind<Context>() with singleton { this@App.applicationContext }
        }
    }
}