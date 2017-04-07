/*
 * Copyright (c) 2017. DNA Software. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.ui.controllers.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

abstract class BaseInflatableController<V : MvpView, T : MvpPresenter<V>>(args: Bundle?): BaseController<V, T>(args) {
    constructor(): this(args = null)

    protected abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup): View
    open fun onViewInflated(view: View) {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = this.inflateView(inflater, container)
        this.onViewInflated(view)
        return view
    }
}