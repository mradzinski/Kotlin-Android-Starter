/*
 * Copyright (c) 2017. DNA Software. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.coolcows.heyu.R
import com.coolcows.heyu.common.extensions.changeHandlerFrameLayout
import com.coolcows.heyu.common.extensions.color
import com.coolcows.heyu.common.extensions.toolbarSize
import com.coolcows.heyu.common.leaks.IMMLeaks
import com.coolcows.heyu.ui.controllers.MainController
import org.jetbrains.anko.appcompat.v7.titleResource
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

class MainActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private var router: Router? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            fitsSystemWindows = true

            // Toolbar
            appBarLayout {
                toolbar = toolbar {
                    backgroundResource = R.color.colorPrimary
                    titleResource = R.string.app_name
                    setTitleTextColor(color(android.R.color.white))
                }.lparams(width = matchParent, height = toolbarSize())
            }.lparams(width = matchParent, height = wrapContent)

            // Controlles container
            changeHandlerFrameLayout {
                router = Conductor.attachRouter(this@MainActivity, this, savedInstanceState)
            }.lparams(width = matchParent, height = matchParent)
        }

        setSupportActionBar(toolbar)

        if (router?.hasRootController() == false) {
            router?.setRoot(RouterTransaction.with(MainController()))
        }

        IMMLeaks.fixFocusedViewLeak(application)
    }

    override fun onBackPressed() {
        if (router?.handleBack() == false) {
            super.onBackPressed()
        }
    }
}
