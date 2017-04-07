/*
 * Copyright (c) 2017. Cool cows. All rights reserved.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.coolcows.heyu.common.logging

import android.util.Log
import timber.log.Timber

class TimberProductionTree: Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String?, t: Throwable?) {
        // Do not attach Verbose or Debug logs, only Info, Warning and Error
        if (priority <= Log.DEBUG) { return }

        // TODO: Replace for actual implementation based on the error reporting service chosen
        if (t != null) {
            // FirebaseCrash.report(t)
        } else {
            // FirebaseCrash.log(message)
        }
    }
}