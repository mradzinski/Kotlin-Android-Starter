/*
 * Copyright (c) 2017. Cool cows. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.ui.layouts

import android.view.View
import com.coolcows.heyu.R
import com.coolcows.heyu.common.layout.ViewBinder
import com.coolcows.heyu.ui.controllers.MainController
import org.jetbrains.anko.*

class MainLayout: ViewBinder<MainController> {

    private var bottomNavigationLayout: BottomNavitagionLayout? = null

    override fun bind(controller: MainController): View {
        return controller.activity?.UI {
            verticalLayout {
                padding = dip(0)

                val container = frameLayout {
                    id = R.id.home_container

                }.lparams {
                    width = matchParent
                    height = dip(0)
                    weight = 1F
                }

                controller.attachRootChild(container)
                bottomNavigationLayout = BottomNavitagionLayout()
                addView(bottomNavigationLayout!!.bind(controller))
            }
        }?.view ?: View(controller.applicationContext)
    }

    override fun unbind(controller: MainController) { /* no-op */ }

    internal fun setSelectedNavigationItem(menuItemId: Int) {
        if (bottomNavigationLayout != null) {
            bottomNavigationLayout!!.setSelectedNavigationItem(menuItemId)
        }
    }
}