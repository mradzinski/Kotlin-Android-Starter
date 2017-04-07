/*
 * Copyright (c) 2017. DNA Software. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.di

import com.bluelinelabs.conductor.Router
import com.coolcows.heyu.navigation.Navigator
import com.coolcows.heyu.navigation.PhoneNavigator
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.multiton

val navigationModule = Kodein.Module {

    bind<Navigator>() with multiton { router: Router -> PhoneNavigator(router) }

}