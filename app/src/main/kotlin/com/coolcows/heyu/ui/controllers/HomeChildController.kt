/*
 * Copyright (c) 2017. DNA Software. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.ui.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.coolcows.heyu.mvp.home.HomeContract
import com.coolcows.heyu.mvp.home.HomePresenter
import com.coolcows.heyu.ui.controllers.base.BaseController
import com.coolcows.heyu.ui.layouts.HomeLayout

class HomeChildController : BaseController<HomeContract.HomeView, HomePresenter>(), HomeContract.HomeView {
    private val viewBinder = HomeLayout()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View = viewBinder.bind(this)

    override fun createPresenter(): HomePresenter = HomePresenter()

    override fun onAttach(view: View) {
        super.onAttach(view)
        // Same as Activity.OnResume()
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        // Same as Activity.onStop()
    }
}