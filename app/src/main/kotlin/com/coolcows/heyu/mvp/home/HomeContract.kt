/*
 * Copyright (c) 2017. DNA Software. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.mvp.home

import com.github.salomonbrys.kodein.conf.KodeinGlobalAware
import com.hannesdorfmann.mosby3.mvp.MvpView

interface HomeContract {
    interface HomeView : MvpView {

    }

    interface HomePresenter : KodeinGlobalAware {

    }
}