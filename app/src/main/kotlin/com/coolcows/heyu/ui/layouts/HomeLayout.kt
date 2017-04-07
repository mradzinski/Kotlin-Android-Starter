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

import android.support.v7.widget.RecyclerView
import android.view.View
import com.coolcows.heyu.common.layout.ViewBinder
import com.coolcows.heyu.ui.controllers.HomeChildController
import org.jetbrains.anko.UI
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent

class HomeLayout : ViewBinder<HomeChildController> {

    lateinit var recyclerView: RecyclerView

    override fun bind(controller: HomeChildController): View {
        return controller.activity?.UI {
            frameLayout {
                lparams(width = matchParent, height = matchParent)

            }
        }?.view ?: View(controller.applicationContext)
    }

    override fun unbind(controller: HomeChildController) { /* no-op */ }

}