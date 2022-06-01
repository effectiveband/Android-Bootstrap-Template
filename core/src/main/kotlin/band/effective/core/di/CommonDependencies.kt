package band.effective.core.di

import android.content.Context

interface CommonDependencies: ComponentDependencies {
    val context: Context
}
