package band.effective.bootstrap.other

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.activityToLayout
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template

val bootstrapSetupTemplate
    get() = template {
        revision = 1
        name = "Effective template with Compose Activity"
        description = "Creates a new activity along layout file."
        minApi = 21

        category = Category.Compose
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.NewProject)

        val packageNameParam = packageNameParameter

        widgets(
            PackageNameWidget(packageNameParam)
        )

        recipe = { data: TemplateData ->
            bootStrapTemplateSetup(
                data as ModuleTemplateData,
                packageNameParam.value
            )
        }
    }

val packageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "band.effective"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }