package dz.salim.salimi.gadsleaderbordproject.data.models

import dz.salim.salimi.gadsleaderbordproject.data.models.Leader

data class Learner(override val name: String, val hours: Int, override val country: String, override val badgeUrl: String): Leader(name, country, badgeUrl) {
}