package com.arindam.android.training.kotlin

import com.arindam.android.training.kotlin.Medium.EMAIL
import com.arindam.android.training.kotlin.Medium.SMS
import com.arindam.android.training.kotlin.VisaDecision.APPROVED
import com.arindam.android.training.kotlin.VisaDecision.REJECTED

/**
 * Infix functions can lay the foundations for building 🏛️ interesting DSLs in Kotlin.
 *
 * Created by Arindam Karmakar on 7/8/19.
 */

enum class VisaDecision { APPROVED, REJECTED }
enum class Medium { EMAIL, SMS }

data class EntryClearanceOfficer(val firstName: String, val lastName: String)
data class VisaApplication(val applicantName: String)

infix fun EntryClearanceOfficer.process(application: VisaApplication): VisaDecision {
    val officerFullName = "${this.firstName} ${this.lastName}"
    return if (application.applicantName == "Arindam") {
        println("$officerFullName processing ${application.applicantName}'s application #${application.hashCode()}")
        APPROVED
    } else {
        println("Sorry, $officerFullName is rejected ${application.applicantName}'s application #${application.hashCode()}")
        REJECTED
    }
}

infix fun VisaDecision.sendIntimationVia(medium: Medium) {
    when (medium) {
        EMAIL -> println("Sending intimation via $medium")
        SMS -> println("Retrying again via $medium")
    }
}

fun main() {
    val johnDoe = EntryClearanceOfficer("John", "Doe")
    val myVisaApplication = VisaApplication("Mary")

    val decision = johnDoe process myVisaApplication
    decision sendIntimationVia if (decision == APPROVED) EMAIL else SMS
}
