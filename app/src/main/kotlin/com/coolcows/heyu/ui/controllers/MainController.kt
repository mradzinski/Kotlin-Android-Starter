/*
 * Copyright (c) 2017. Cool cows. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.ui.controllers

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.coolcows.heyu.R
import com.coolcows.heyu.mvp.main.MainContract
import com.coolcows.heyu.mvp.main.MainPresenter
import com.coolcows.heyu.navigation.Navigator
import com.coolcows.heyu.ui.controllers.base.BaseController
import com.coolcows.heyu.ui.layouts.MainLayout
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.with

class MainController: BaseController<MainContract.MainView, MainPresenter>(), MainContract.MainView {
    private val viewBinder = MainLayout()
    private lateinit var navigator: Navigator
    private lateinit var childRouter: Router

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View = viewBinder.bind(this)

    override fun createPresenter(): MainPresenter = MainPresenter()

    internal fun attachRootChild(view: ViewGroup) {
        this.childRouter = getChildRouter(view)
        this.navigator = kodein.with(childRouter).instance<Navigator>()

        if (!childRouter.hasRootController()) {
            childRouter.setRoot(RouterTransaction.with(HomeChildController()))
        }

        childRouter.addChangeListener(object : ControllerChangeHandler.ControllerChangeListener {
            override fun onChangeStarted(to: Controller?, from: Controller?, isPush: Boolean,
                                         container: ViewGroup, handler: ControllerChangeHandler) {
                if (!isPush && to != null) {
                    if (to is HomeChildController) {
                        viewBinder.setSelectedNavigationItem(R.id.bottom_navigation_item_home)
                    }
                }
            }

            override fun onChangeCompleted(to: Controller?, from: Controller?, isPush: Boolean,
                                           container: ViewGroup, handler: ControllerChangeHandler) {}
        })
    }

    internal fun navigate(item: MenuItem) {
        when (item.itemId) {
            R.id.bottom_navigation_item_home -> {
                navigator.showHome()
            }
            //...
            // and so on for main navigatable screens
        }
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        // Same as Activity.OnResume()
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        // Same as Activity.onStop()
    }

}