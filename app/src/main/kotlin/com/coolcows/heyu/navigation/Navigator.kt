/*
 * Copyright (c) 2017. DNA Software. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.navigation

import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler

/**
 * Responsible to navigate from one screen to another
 */
interface Navigator {
    val router: Router

    fun showHome() {
        if(router.hasRootController() && router.backstackSize > 1) {
            val handler = HorizontalChangeHandler(150)
            router.popToRoot(handler)
        }
    }

}