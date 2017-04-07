/*
 * Copyright (c) 2017. DNA Software. All rights reserved.
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
import com.coolcows.heyu.common.extensions.bottomNavigationViewEx
import com.coolcows.heyu.common.layout.ViewBinder
import com.coolcows.heyu.ui.controllers.MainController
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import org.jetbrains.anko.UI
import org.jetbrains.anko.dip

class BottomNavitagionLayout : ViewBinder<MainController> {

    private var bottomNavigationView: BottomNavigationViewEx? = null

    override fun bind(controller: MainController): View {
        return controller.activity?.UI {
            bottomNavigationView = bottomNavigationViewEx(R.style.BottomNavigationView_style) {
                inflateMenu(R.menu.bottom_navigation_menu)

                setTextVisibility(false)
                setPadding(0, dip(8), 0, dip(8))

                setOnNavigationItemSelectedListener { item ->
                    controller.navigate(item)
                    true
                }

                // If this is not set then controller.navigate gets
                // invoked upon reselecting too, re-creating the controller
                setOnNavigationItemReselectedListener { /* no-op */  }
            }
        }?.view ?: View(controller.applicationContext)
    }

    override fun unbind(controller: MainController) { /* no-op */ }

    internal fun setSelectedNavigationItem(itemMenuId: Int) {
        if (bottomNavigationView != null) {
            if (bottomNavigationView!!.selectedItemId == itemMenuId) { return }
            bottomNavigationView!!.selectedItemId = itemMenuId
        }
    }
}