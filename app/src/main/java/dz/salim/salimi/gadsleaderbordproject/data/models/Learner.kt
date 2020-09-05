package dz.salim.salimi.gadsleaderbordproject.data.models

import dz.salim.salimi.gadsleaderbordproject.data.models.Leader

class Learner(name: String, country: String, badgeUrl: String, val hours: Int): Leader(name, country, badgeUrl) {
}