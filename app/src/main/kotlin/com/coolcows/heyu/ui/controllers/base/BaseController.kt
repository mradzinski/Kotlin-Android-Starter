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
import com.github.salomonbrys.kodein.conf.KodeinGlobalAware
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

abstract class BaseController<V : MvpView, T : MvpPresenter<V>>(args: Bundle?):
        RefWatchingController<V, T>(args), KodeinGlobalAware {

    constructor(): this(args = null)

}