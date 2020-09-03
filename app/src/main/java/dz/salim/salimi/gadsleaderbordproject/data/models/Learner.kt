package dz.salim.salimi.gadsleaderbordproject.data.models

import dz.salim.salimi.gadsleaderbordproject.data.models.Leader

data class Learner(val name: String, val hours: Int, val country: String, val badgeUrl: String): Leader(name, country, badgeUrl) {
}